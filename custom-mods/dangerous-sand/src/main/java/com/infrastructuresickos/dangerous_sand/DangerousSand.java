package com.infrastructuresickos.dangerous_sand;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(DangerousSand.MOD_ID)
public class DangerousSand {
    public static final String MOD_ID = "dangerous_sand";

    public DangerousSand() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, DSConfig.SPEC);
        // SandPourHandler uses @Mod.EventBusSubscriber for auto-registration.
    }
}
