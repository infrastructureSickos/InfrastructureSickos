package com.infrastructuresickos.water_growth;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(WaterGrowth.MOD_ID)
public class WaterGrowth {
    public static final String MOD_ID = "water_growth";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public WaterGrowth() {
        LOGGER.info("WaterGrowth initialized");
    }
}
