# Deep Nether — Custom Mod Spec

## Summary

Replaces the overworld's deepslate layer (-64 to 0) with Nether-like terrain generation. This provides access to basic Nether materials (netherrack, nether bricks, etc.) without requiring actual Nether access, resolving the circular dependency between IE's Nether-material recipes and the Nether being gated behind Botania.

## Core Mechanics

### Worldgen
- Overworld Y levels -64 to 0 use **Nether-style terrain generation**
- Netherrack replaces deepslate/stone as the primary block
- Nether-style cave generation (large open caverns, lava lakes)
- Basic Nether ores and materials generate here (netherrack, nether quartz, glowstone, soul sand, etc.)
- **Transition zone (Y -32 to 0)**: Perlin noise blends overworld stone/deepslate with netherrack. No hard cutoff — the nether bleeds through gradually.
- **Full Deep Nether (Y -64 to -32)**: Entirely Nether-style generation
- **Deep Dark biomes are preserved** — sculk, sculk sensors, sculk shriekers, reinforced deepslate, and all Deep Dark-specific blocks persist. However, surrounding stone/deepslate is replaced with **netherrack** — ancient cities are embedded in a hellscape. Warden spawning is unaffected.

### What's Available in the Deep Nether
- Netherrack
- Nether Quartz Ore
- Glowstone
- Soul Sand / Soul Soil
- Magma Blocks
- Lava (abundant)
- Nether Bricks (via smelting netherrack, as vanilla)
- Blazes (spawn naturally in the Deep Nether)
- Magma Cubes (spawn naturally in the Deep Nether)

### What's ONLY in the Real Nether
- Nether Fortresses
- Bastions
- Ghasts (and therefore Ghast Tears)
- Wither Skeletons (and therefore Wither Skeleton Skulls → Nether Star)
- Nether Wart
- Ancient Debris / Netherite
- Piglins / Piglin Bartering
- Any modded Nether-exclusive content (Incendium bosses, Cataclysm dungeons, etc.)

## Design Principles

- The Deep Nether provides **materials**, not **experiences**. You can get netherrack and quartz, but not the mobs, structures, or danger of the real Nether.
- This keeps IE's Blast Brick recipe working without changes (netherrack → nether bricks + blaze powder still needs resolution — see open questions).
- The real Nether remains valuable and worth accessing through Botania.

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- Custom dimension noise/biome settings applied to overworld Y -64 to 0
- May be achievable via datapack worldgen customization rather than a full mod
- Need to investigate whether Forge's biome/noise APIs allow per-Y-range biome overrides

## Open Questions

- Should any Deep Nether-specific ores exist, or strictly vanilla Nether ores?
- Blaze/Magma Cube spawn rates — same as real Nether or reduced?
