package com.infrastructuresickos.water_growth;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(WaterGrowth.MOD_ID)
public class WaterGrowth {
    public static final String MOD_ID = "water_growth";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public WaterGrowth() {
        MinecraftForge.EVENT_BUS.register(new WaterGrowthEventHandler());
        LOGGER.info("WaterGrowth initialized");
    }
}
