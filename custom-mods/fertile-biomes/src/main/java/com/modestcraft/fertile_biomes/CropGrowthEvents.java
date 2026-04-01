package com.modestcraft.fertile_biomes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class CropGrowthEvents {

    @SubscribeEvent
    public void onCropGrow(BlockEvent.CropGrowEvent.Pre event) {
        Level level = (Level) event.getLevel();
        if (level.isClientSide()) return;

        BlockPos pos = event.getPos();
        BlockState state = event.getState();
        if (!(state.getBlock() instanceof CropBlock crop)) return;

        ResourceLocation cropId = ForgeRegistries.BLOCKS.getKey(crop);
        if (cropId == null) return;

        // Allowlist / denylist checks
        List<? extends String> denylist = FBConfig.INSTANCE.denylist.get();
        if (!denylist.isEmpty() && denylist.contains(cropId.toString())) return;
        List<? extends String> allowlist = FBConfig.INSTANCE.allowlist.get();
        if (!allowlist.isEmpty() && !allowlist.contains(cropId.toString())) return;

        ResourceLocation biomeId = level.registryAccess()
                .registryOrThrow(Registries.BIOME)
                .getKey(level.getBiome(pos).value());
        if (biomeId == null) return;

        double multiplier = GrowthMultiplier.getMultiplier(cropId, biomeId, FBConfig.INSTANCE);

        if (multiplier < 1.0) {
            // Cancel growth with probability (1 - multiplier)
            if (level.random.nextDouble() > multiplier) {
                event.setResult(Event.Result.DENY);
                return;
            }
        }

        // Particle feedback
        spawnGrowthParticles((ServerLevel) level, pos, multiplier);

        // Extra age increments for multiplier > 1.0
        if (multiplier > 1.0) {
            int extra = (int) (multiplier - 1.0);
            for (int i = 0; i < extra; i++) {
                BlockState current = level.getBlockState(pos);
                if (!(current.getBlock() instanceof CropBlock c) || c.isMaxAge(current)) break;
                level.setBlock(pos, c.getStateForAge(c.getAge(current) + 1), 3);
            }
        }
    }

    /**
     * When a player harvests a crop growing on FertileGround, convert the FertileGround to mud.
     * This makes wild crops a one-time discovery reward.
     */
    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        Level level = (Level) event.getLevel();
        BlockPos pos = event.getPos();
        BlockState broken = event.getState();

        if (!(broken.getBlock() instanceof CropBlock)) return;

        BlockPos below = pos.below();
        if (level.getBlockState(below).getBlock() == FBBlocks.FERTILE_GROUND.get()) {
            level.setBlock(below, Blocks.MUD.defaultBlockState(), 3);
        }
    }

    private void spawnGrowthParticles(ServerLevel level, BlockPos pos, double multiplier) {
        double x = pos.getX() + 0.5, y = pos.getY() + 1.0, z = pos.getZ() + 0.5;
        if (multiplier >= 2.0) {
            level.sendParticles(net.minecraft.core.particles.ParticleTypes.HEART,
                    x, y, z, 3, 0.3, 0.3, 0.3, 0.0);
        } else if (multiplier >= 1.0) {
            level.sendParticles(net.minecraft.core.particles.ParticleTypes.HAPPY_VILLAGER,
                    x, y, z, 2, 0.3, 0.3, 0.3, 0.0);
        } else if (multiplier >= 0.5) {
            level.sendParticles(net.minecraft.core.particles.ParticleTypes.SMOKE,
                    x, y, z, 1, 0.1, 0.1, 0.1, 0.0);
        } else {
            level.sendParticles(net.minecraft.core.particles.ParticleTypes.SOUL_FIRE_FLAME,
                    x, y, z, 1, 0.1, 0.1, 0.1, 0.0);
        }
    }
}
