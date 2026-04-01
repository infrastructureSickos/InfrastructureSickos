# FertileBiomes — Revamp Spec

## Existing Mod
- Repo: https://github.com/OurCraftOnCraft/FertileBiomes
- Target: Minecraft 1.20.1 Forge (already correct version)

## Current Functionality

Crop growth rates vary by biome using a deterministic hash-based system:

- Each (crop + biome) pair gets a **growth multiplier** derived from SHA-256 hash of crop ID + biome ID + configurable salt
- Multiplier < 1.0: growth ticks probabilistically cancelled (crop grows slower)
- Multiplier > 1.0: extra age increments applied (crop grows faster)
- Particle feedback on growth/planting: hearts (>=2.0), happy villager (>=1.0), smoke (>=0.5), soul fire (<0.5)

### Config Options
- `minMultiplier`, `maxMultiplier`, `amplitude`, `curveK` — control the multiplier distribution
- `configSalt` — changes all multiplier values (world-specific randomization)
- `affectsBonemeal` — whether bonemeal is also affected
- `allowlist` / `denylist` — filter which crops are affected

### Code Structure (4 files)
- `FertileBiomesMod.java` — entry point, registers config and events
- `FBConfig.java` — Forge config spec
- `GrowthMultiplier.java` — deterministic hash-based multiplier calculation
- `CropGrowthEvents.java` — growth modification and particle effects

### Limitations
- Seed-to-crop mapping is hardcoded for 6 vanilla crops
- No modded crop support beyond tag/registry fallback
- No worldgen integration

## Revamp: Natural Crop Growth

### New Feature: Natural Crop Spawning
- Crops with high fertility in a biome **spawn naturally** during worldgen
- Players discover crops through exploration

### New Block: Fertile Ground
- A special farmland block that **does not require water**
- Wild crops spawn on Fertile Ground during worldgen
- When a crop is harvested from Fertile Ground, the block turns to **mud** (or similar vanilla block)
- **No replanting** on Fertile Ground — it's a one-time harvest
- This makes wild crops a discovery/exploration reward, not a free farm

### Implementation Needed
- New worldgen `Feature` that places Fertile Ground + crop blocks during biome decoration
- Custom `PlacementModifier` using existing `GrowthMultiplier.calculateMultiplier()` for spawn probability
- Generalize seed-to-crop mapping for modded crop support (Jen's Pam's Harvestcraft)
- New config: enable/disable natural spawning, density, minimum multiplier threshold
- Fertile Ground block: farmland variant, no water requirement, converts on harvest

### Integration
- Should support all vanilla crops
- Should support modded crops via tag/registry scanning
- Crop-to-biome mappings are already deterministic via the hash system — just need to use multiplier as spawn weight

## Security Issue
- **gradle.properties contains SFTP credentials in a public repo — rotate immediately**

## Open Questions

(None currently)
