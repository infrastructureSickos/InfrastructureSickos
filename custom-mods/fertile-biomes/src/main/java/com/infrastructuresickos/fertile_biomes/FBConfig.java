package com.infrastructuresickos.fertile_biomes;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class FBConfig {
    public static final ForgeConfigSpec SPEC;
    public static final FBConfig INSTANCE;

    static {
        Pair<FBConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(FBConfig::new);
        INSTANCE = specPair.getLeft();
        SPEC = specPair.getRight();
    }

    public final ForgeConfigSpec.DoubleValue minMultiplier;
    public final ForgeConfigSpec.DoubleValue maxMultiplier;
    public final ForgeConfigSpec.DoubleValue amplitude;
    public final ForgeConfigSpec.DoubleValue curveK;
    public final ForgeConfigSpec.ConfigValue<String> configSalt;
    public final ForgeConfigSpec.BooleanValue affectsBonemeal;
    public final ForgeConfigSpec.ConfigValue<java.util.List<? extends String>> allowlist;
    public final ForgeConfigSpec.ConfigValue<java.util.List<? extends String>> denylist;

    public final ForgeConfigSpec.BooleanValue enableNaturalSpawning;
    public final ForgeConfigSpec.IntValue wildCropDensity;
    public final ForgeConfigSpec.DoubleValue minSpawnMultiplier;

    private FBConfig(ForgeConfigSpec.Builder builder) {
        builder.push("multiplier");
        minMultiplier = builder.comment("Minimum growth multiplier (default 0.1)")
                               .defineInRange("minMultiplier", 0.1, 0.0, 1.0);
        maxMultiplier = builder.comment("Maximum growth multiplier (default 3.0)")
                               .defineInRange("maxMultiplier", 3.0, 1.0, 10.0);
        amplitude = builder.comment("Amplitude scaling factor for the sigmoid curve (default 1.0)")
                           .defineInRange("amplitude", 1.0, 0.1, 2.0);
        curveK = builder.comment("Sigmoid steepness — higher values create sharper extremes (default 6.0)")
                        .defineInRange("curveK", 6.0, 0.5, 20.0);
        configSalt = builder.comment("Salt for the SHA-256 hash — change to randomize all multipliers")
                            .define("configSalt", "default");
        affectsBonemeal = builder.comment("Whether the multiplier also affects bonemeal growth")
                                 .define("affectsBonemeal", true);
        allowlist = builder.comment("If non-empty, only crops in this list are affected (e.g. minecraft:wheat)")
                           .defineList("allowlist", java.util.List.of(), e -> e instanceof String);
        denylist = builder.comment("Crops in this list are never affected")
                          .defineList("denylist", java.util.List.of(), e -> e instanceof String);
        builder.pop();

        builder.push("worldgen");
        enableNaturalSpawning = builder.comment("Enable wild crop spawning on FertileGround during worldgen")
                                       .define("enableNaturalSpawning", true);
        wildCropDensity = builder.comment("Number of crop placement attempts per feature invocation (default 8)")
                                  .defineInRange("wildCropDensity", 8, 1, 64);
        minSpawnMultiplier = builder.comment("Minimum multiplier for a crop to spawn in a biome (default 1.5)")
                                    .defineInRange("minSpawnMultiplier", 1.5, 0.1, 10.0);
        builder.pop();
    }
}
