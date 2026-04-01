package com.modestcraft.dangerous_stone;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(DangerousStone.MOD_ID)
public class DangerousStone {
    public static final String MOD_ID = "dangerous_stone";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public DangerousStone() {
        LOGGER.info("DangerousStone initialized");
    }
}
