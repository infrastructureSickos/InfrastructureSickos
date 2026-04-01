package com.infrastructuresickos.fertile_biomes;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FBBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FertileBiomes.MOD_ID);

    public static final RegistryObject<Block> FERTILE_GROUND = BLOCKS.register("fertile_ground",
            () -> new FertileGroundBlock(
                    BlockBehaviour.Properties.copy(Blocks.FARMLAND)
                            .sound(SoundType.GRAVEL)
                            .strength(0.6f)
            ));
}
