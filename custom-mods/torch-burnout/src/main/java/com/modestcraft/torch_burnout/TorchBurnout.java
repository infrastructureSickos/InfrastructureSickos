package com.modestcraft.torch_burnout;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TorchBurnout.MOD_ID)
public class TorchBurnout {
    public static final String MOD_ID = "torch_burnout";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public TorchBurnout() {
        LOGGER.info("TorchBurnout initialized");
    }
}
