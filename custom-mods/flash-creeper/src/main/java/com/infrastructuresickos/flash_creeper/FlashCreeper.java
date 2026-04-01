package com.infrastructuresickos.flash_creeper;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(FlashCreeper.MOD_ID)
public class FlashCreeper {
    public static final String MOD_ID = "flash_creeper";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public FlashCreeper() {
        LOGGER.info("FlashCreeper initialized");
    }
}
