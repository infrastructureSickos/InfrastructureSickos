package com.modestcraft.magma_cobble;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MagmaCobble.MOD_ID)
public class MagmaCobble {
    public static final String MOD_ID = "magma_cobble";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public MagmaCobble() {
        LOGGER.info("MagmaCobble initialized");
    }
}
