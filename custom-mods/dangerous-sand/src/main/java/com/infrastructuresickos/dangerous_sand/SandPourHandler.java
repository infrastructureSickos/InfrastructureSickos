package com.infrastructuresickos.dangerous_sand;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.EntityLeaveLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Handles sideways cascading of falling blocks (sand, gravel, concrete powder).
 *
 * When a FallingBlockEntity lands and places its block, we scan adjacent columns.
 * If an adjacent column has at least dropDepth consecutive empty (or replaceable)
 * blocks, we slide this block into that column — then keep cascading until no
 * more moves are possible or maxMovesPerTick is reached.
 *
 * Design notes:
 * - No Level-keyed maps (avoids memory leak on dimension unload).
 * - Cascading is done iteratively in the same tick via a work queue rather than
 *   server.execute() scheduling (eliminates recursive runnable queuing).
 * - Uses EntityLeaveLevelEvent on FallingBlockEntity, which fires after the
 *   entity places its block and discards — no race with block placement.
 */
@Mod.EventBusSubscriber(modid = DangerousSand.MOD_ID)
public class SandPourHandler {

    private static final Direction[] HORIZONTALS = {
            Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST
    };

    /**
     * FallingBlockEntity fires EntityLeaveLevelEvent when it lands (discards itself
     * after calling level.setBlock). At this point the block is already placed in
     * the world, so reading level.getBlockState(pos) is safe.
     */
    @SubscribeEvent
    public static void onEntityLeave(EntityLeaveLevelEvent event) {
        if (!(event.getEntity() instanceof FallingBlockEntity falling)) return;
        if (event.getLevel().isClientSide()) return;
        ServerLevel level = (ServerLevel) event.getLevel();

        // The entity's blockPosition is where it landed and placed its block.
        BlockPos landPos = falling.blockPosition();
        BlockState placed = level.getBlockState(landPos);

        // Only cascade if a falling block is actually present at that position.
        if (!(placed.getBlock() instanceof FallingBlock)) return;

        pourCascade(level, landPos, placed);
    }

    /**
     * Cascade falling blocks sideways from startPos.
     * Iterative BFS — processes the start position and all downstream positions
     * within the maxMovesPerTick budget.
     */
    static void pourCascade(ServerLevel level, BlockPos startPos, BlockState fallingState) {
        int maxMoves = DSConfig.INSTANCE.maxMovesPerTick.get();
        int dropDepth = DSConfig.INSTANCE.dropDepth.get();
        boolean allowReplaceable = DSConfig.INSTANCE.allowReplaceable.get();

        Deque<BlockPos> queue = new ArrayDeque<>();
        queue.add(startPos);
        int moves = 0;

        while (!queue.isEmpty() && moves < maxMoves) {
            BlockPos pos = queue.poll();
            BlockState current = level.getBlockState(pos);

            if (!(current.getBlock() instanceof FallingBlock)) continue;

            for (Direction dir : HORIZONTALS) {
                if (moves >= maxMoves) break;

                BlockPos neighbor = pos.relative(dir);
                if (!isColumnDeep(level, neighbor, dropDepth, allowReplaceable)) continue;

                // Slide the block sideways into the open column.
                level.removeBlock(pos, false);
                level.setBlockAndUpdate(neighbor, current);
                moves++;
                queue.add(neighbor);
                break;
            }
        }
    }

    private static boolean isColumnDeep(ServerLevel level, BlockPos pos, int dropDepth, boolean allowReplaceable) {
        for (int i = 0; i < dropDepth; i++) {
            BlockState state = level.getBlockState(pos.below(i));
            if (!isEmpty(state, allowReplaceable)) return false;
        }
        return true;
    }

    private static boolean isEmpty(BlockState state, boolean allowReplaceable) {
        if (state.isAir()) return true;
        return allowReplaceable && state.canBeReplaced();
    }
}
