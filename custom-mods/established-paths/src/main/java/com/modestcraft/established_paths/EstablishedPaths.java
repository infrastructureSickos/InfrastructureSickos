package com.modestcraft.established_paths;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(EstablishedPaths.MOD_ID)
public class EstablishedPaths {
    public static final String MOD_ID = "established_paths";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public EstablishedPaths() {
        LOGGER.info("EstablishedPaths initialized");
    }
}
