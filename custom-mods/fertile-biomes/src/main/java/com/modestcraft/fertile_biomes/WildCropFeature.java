package com.modestcraft.fertile_biomes;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlacementContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

/**
 * Spawns wild crops on FertileGround blocks during worldgen.
 * Only crops whose biome multiplier meets the minimum threshold are placed.
 */
public class WildCropFeature extends Feature<NoneFeatureConfiguration> {

    private static final List<Block> VANILLA_CROPS = List.of(
            Blocks.WHEAT, Blocks.CARROTS, Blocks.POTATOES, Blocks.BEETROOTS
    );

    public WildCropFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlacementContext context, RandomSource random, BlockPos origin) {
        if (!FBConfig.INSTANCE.enableNaturalSpawning.get()) return false;

        WorldGenLevel level = context.level();
        ResourceLocation biomeId = level.registryAccess()
                .registryOrThrow(Registries.BIOME)
                .getKey(level.getBiome(origin).value());
        if (biomeId == null) return false;

        List<Block> candidates = buildCropList();
        if (candidates.isEmpty()) return false;

        int density = FBConfig.INSTANCE.wildCropDensity.get();
        double minThreshold = FBConfig.INSTANCE.minSpawnMultiplier.get();
        boolean placed = false;

        for (int i = 0; i < density; i++) {
            int dx = random.nextInt(16) - 8;
            int dz = random.nextInt(16) - 8;
            BlockPos surface = level.getHeightmapPos(
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    origin.offset(dx, 0, dz)
            );
            BlockPos groundPos = surface.below();

            if (!level.getBlockState(surface).isAir()) continue;
            if (!level.getBlockState(groundPos).isSolid()) continue;

            // Pick a random crop and check its biome multiplier
            Block crop = candidates.get(random.nextInt(candidates.size()));
            ResourceLocation cropId = ForgeRegistries.BLOCKS.getKey(crop);
            if (cropId == null) continue;

            double multiplier = GrowthMultiplier.getMultiplier(cropId, biomeId, FBConfig.INSTANCE);
            if (multiplier < minThreshold) continue;

            // Replace ground with FertileGround (max moisture)
            level.setBlock(groundPos,
                    FBBlocks.FERTILE_GROUND.get().defaultBlockState()
                            .setValue(FarmBlock.MOISTURE, 7),
                    2);

            // Place the crop at max age so it's immediately harvestable
            if (crop instanceof CropBlock cropBlock) {
                level.setBlock(surface, cropBlock.getStateForAge(cropBlock.getMaxAge()), 2);
            } else {
                level.setBlock(surface, crop.defaultBlockState(), 2);
            }
            placed = true;
        }

        return placed;
    }

    /**
     * Build the list of crops to consider for spawning.
     * Starts with vanilla crops and adds any modded CropBlock found in the registry.
     */
    private List<Block> buildCropList() {
        List<Block> list = new ArrayList<>(VANILLA_CROPS);
        for (Block block : ForgeRegistries.BLOCKS) {
            if (block instanceof CropBlock && !VANILLA_CROPS.contains(block)) {
                list.add(block);
            }
        }
        return list;
    }
}
