package com.modestcraft.dangerous_sand;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(DangerousSand.MOD_ID)
public class DangerousSand {
    public static final String MOD_ID = "dangerous_sand";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public DangerousSand() {
        LOGGER.info("DangerousSand initialized");
    }
}
