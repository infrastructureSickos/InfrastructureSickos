package com.infrastructuresickos.fertile_biomes;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(FertileBiomes.MOD_ID)
public class FertileBiomes {
    public static final String MOD_ID = "fertile_biomes";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public FertileBiomes() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, FBConfig.SPEC);

        FBBlocks.BLOCKS.register(bus);
        FBItems.ITEMS.register(bus);
        FBFeatures.FEATURES.register(bus);

        MinecraftForge.EVENT_BUS.register(new CropGrowthEvents());

        LOGGER.info("FertileBiomes initialized");
    }
}
