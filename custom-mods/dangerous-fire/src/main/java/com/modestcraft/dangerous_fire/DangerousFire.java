package com.modestcraft.dangerous_fire;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(DangerousFire.MOD_ID)
public class DangerousFire {
    public static final String MOD_ID = "dangerous_fire";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public DangerousFire() {
        LOGGER.info("DangerousFire initialized");
    }
}
