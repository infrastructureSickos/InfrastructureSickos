# Surface Safety — Custom Mod Spec

## Summary

Changes hostile mob spawning and equipment based on Y level. The surface is a safe zone with no hostile spawns. Above and below the safe zone, mobs have a linearly increasing chance of spawning with gear — leather at high altitudes, iron in the depths.

## Core Mechanics

### Safe Zone (Y 47–79)
- **No zombie or skeleton spawning**
- 16 blocks above and below sea level (Y 63)
- Other hostile mobs (creepers, spiders, witches, etc.) spawn normally everywhere

### High Altitude (Y 79 – build height)
- Hostile mobs spawn normally
- **Leather gear chance**: 0% at Y 79, scales linearly to 100% at build height (Y 320)
- Each equipment slot (helmet, chestplate, leggings, boots, weapon) is rolled independently
- Zombies get wooden sword, skeletons get bow (when weapon roll succeeds)

### Deep Underground (Y 47 – Y 0)
- Hostile mobs spawn normally
- **Iron gear chance**: 0% at Y 47, scales linearly to 100% at Y 0
- Each equipment slot rolled independently
- Zombies get iron sword, skeletons get bow (when weapon roll succeeds)

### Per-Piece Rolling
For each equipment slot, the mob:
1. Generates a random number 0–100%
2. Compares against the chance at that Y level
3. If the random number is below the chance, equip that piece. Otherwise skip it.

This means a zombie at Y 24 (~50% chance) might spawn with iron boots and a sword but no helmet. Every mob is different.

## Configuration
- Safe zone range: configurable (default: 16 blocks above/below sea level)

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **No dependencies** — works standalone
- Cancel zombie/skeleton spawn events within the safe zone Y range (other hostile mobs unaffected)
- Modify zombie/skeleton equipment on spawn event based on Y level with per-slot random rolls
- Should apply to natural spawns only (not spawn eggs or spawners)

## Open Questions

(None currently)
