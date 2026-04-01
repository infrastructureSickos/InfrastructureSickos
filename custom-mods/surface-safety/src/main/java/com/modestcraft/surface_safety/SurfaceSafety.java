package com.modestcraft.surface_safety;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SurfaceSafety.MOD_ID)
public class SurfaceSafety {
    public static final String MOD_ID = "surface_safety";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public SurfaceSafety() {
        LOGGER.info("SurfaceSafety initialized");
    }
}
