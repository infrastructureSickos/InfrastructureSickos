package com.modestcraft.fertile_biomes;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FBFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(ForgeRegistries.FEATURES, FertileBiomes.MOD_ID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> WILD_CROPS =
            FEATURES.register("wild_crops",
                    () -> new WildCropFeature(NoneFeatureConfiguration.CODEC));
}
