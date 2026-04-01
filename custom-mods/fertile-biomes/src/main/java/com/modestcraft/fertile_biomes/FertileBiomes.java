package com.modestcraft.fertile_biomes;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(FertileBiomes.MOD_ID)
public class FertileBiomes {
    public static final String MOD_ID = "fertile_biomes";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public FertileBiomes() {
        LOGGER.info("FertileBiomes initialized");
    }
}
