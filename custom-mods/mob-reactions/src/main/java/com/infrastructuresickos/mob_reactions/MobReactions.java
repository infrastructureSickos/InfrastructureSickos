package com.infrastructuresickos.mob_reactions;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MobReactions.MOD_ID)
public class MobReactions {
    public static final String MOD_ID = "mob_reactions";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public MobReactions() {
        LOGGER.info("MobReactions initialized");
    }
}
