package com.infrastructuresickos.water_growth;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * Cancels water-breaking crops/saplings and instead applies a bonemeal growth tick.
 * The flowing water block is consumed (replaced with air).
 * Registered manually on the Forge bus — no @Mod.EventBusSubscriber.
 */
public class WaterGrowthEventHandler {

    @SubscribeEvent
    public void onFluidPlace(BlockEvent.FluidPlaceBlockEvent event) {
        if (!(event.getLevel() instanceof Level level)) return;
        if (level.isClientSide()) return;

        BlockPos pos = event.getPos();
        BlockState existing = event.getExistingBlock();
        Block block = existing.getBlock();

        // Only intercept when water would destroy a bonemealable plant
        if (!(block instanceof BonemealableBlock bonemealable)) return;
        if (!bonemealable.isValidBonemealTarget(level, pos, existing, false)) return;

        // Cancel the fluid placement (water won't break the plant)
        event.setCanceled(true);

        // Consume the water source that triggered this event
        BlockPos fluidPos = event.getFluidPos();
        if (level.getBlockState(fluidPos).is(Blocks.WATER)) {
            level.setBlockAndUpdate(fluidPos, Blocks.AIR.defaultBlockState());
        }

        // Apply one bonemeal growth tick
        bonemealable.performBonemeal(level, level.random, pos, existing);
    }
}
