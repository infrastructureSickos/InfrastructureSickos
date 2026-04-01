package com.infrastructuresickos.fertile_biomes;

import net.minecraft.resources.ResourceLocation;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GrowthMultiplier {

    /**
     * Returns a stable double in [0, 1) derived from the SHA-256 of cropId + biomeId + salt.
     */
    private static double rawHash(ResourceLocation cropId, ResourceLocation biomeId, String salt) {
        String input = cropId + "|" + biomeId + "|" + salt;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            // Combine first 8 bytes into a positive long, then normalize
            long raw = 0;
            for (int i = 0; i < 8; i++) {
                raw = (raw << 8) | (hash[i] & 0xFFL);
            }
            return (double) (raw >>> 1) / (double) Long.MAX_VALUE;
        } catch (NoSuchAlgorithmException e) {
            return 0.5;
        }
    }

    /**
     * Returns the growth multiplier for the given crop/biome pair.
     * Values < 1.0 slow growth; values > 1.0 accelerate it.
     */
    public static double getMultiplier(ResourceLocation cropId, ResourceLocation biomeId, FBConfig config) {
        double normalized = rawHash(cropId, biomeId, config.configSalt.get());
        double min = config.minMultiplier.get();
        double max = config.maxMultiplier.get();
        double k = config.curveK.get();
        double amplitude = config.amplitude.get();

        // Sigmoid: maps normalized [0,1] → roughly [min, max] with variable sharpness
        double sigmoid = 1.0 / (1.0 + Math.exp(-k * (normalized - 0.5)));
        double multiplier = min + (max - min) * sigmoid * amplitude;
        return Math.max(min, Math.min(max, multiplier));
    }
}
