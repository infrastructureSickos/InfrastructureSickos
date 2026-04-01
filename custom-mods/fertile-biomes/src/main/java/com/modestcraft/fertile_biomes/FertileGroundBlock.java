package com.modestcraft.fertile_biomes;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;

/**
 * FertileGround: a farmland variant that never needs water and never dries out.
 * When a crop growing on it is harvested, it is replaced with mud (handled in CropGrowthEvents).
 */
public class FertileGroundBlock extends FarmBlock {

    public FertileGroundBlock(Properties properties) {
        super(properties);
    }

    /** Always fertile — no water hydration required. */
    @Override
    public boolean isFertile(BlockState state, BlockGetter world, BlockPos pos) {
        return true;
    }

    /**
     * Override randomTick to prevent normal farmland drying/reverting logic.
     * FertileGround stays fertile indefinitely until a crop is harvested from it.
     */
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        // Intentionally empty — FertileGround never dries out on its own.
        // The only way it changes is when the crop above is harvested (see CropGrowthEvents).
    }
}
