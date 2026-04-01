package com.modestcraft.dangerous_sand;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class DSConfig {
    public static final ForgeConfigSpec SPEC;
    public static final DSConfig INSTANCE;

    static {
        Pair<DSConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(DSConfig::new);
        INSTANCE = specPair.getLeft();
        SPEC = specPair.getRight();
    }

    public final ForgeConfigSpec.IntValue dropDepth;
    public final ForgeConfigSpec.IntValue maxMovesPerTick;
    public final ForgeConfigSpec.BooleanValue allowReplaceable;

    private DSConfig(ForgeConfigSpec.Builder builder) {
        dropDepth = builder
                .comment("How deep an adjacent column must be empty for a block to slide sideways")
                .defineInRange("dropDepth", 3, 1, 64);

        maxMovesPerTick = builder
                .comment("Safety throttle: maximum block moves processed per tick")
                .defineInRange("maxMovesPerTick", 512, 1, 4096);

        allowReplaceable = builder
                .comment("If true, replaceable blocks (grass, snow) count as empty for pour detection")
                .define("allowReplaceable", false);
    }
}
