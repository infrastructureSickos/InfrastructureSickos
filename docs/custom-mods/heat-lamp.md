# Heat Lamp — Custom Mod Spec

## Summary

A Create-powered light source. Light level scales with rotational speed. Sets undead mobs on fire within its light radius.

## Core Mechanics

### Light Output
- Accepts Create rotational power (stress units)
- Light level scales linearly with RPM — more speed = brighter
- No light when not receiving rotation

### 6-Way Gearbox
- Shaft connections on **all 6 faces** — passes rotation through like a gearbox
- Can be used as part of a Create kinetic network while also providing light
- Acts as both infrastructure (power distribution) and utility (lighting/undead burning)

### Undead Burning
- All undead mobs (zombies, skeletons, phantoms, drowned, etc.) within the light radius are **set on fire**
- Functions like sunlight for undead — they burn as long as they're in range
- Radius matches the light level (brighter = larger burn radius)

### Hostile Mob Repulsion
- **Undead and hostile beasts** flee from the light radius (whitelist-based)
- Includes: zombies, skeletons, creepers, spiders, phantoms, etc.
- **Does NOT repel**: pillagers, illagers, witches, or other humanoid hostiles
- Same avoidance AI as cats repelling creepers — mobs pathfind away from the lamp
- Undead still burn AND flee

## Recipe
- TBD — likely Create components (brass, shaft, glass)

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **Depends on**: Create (rotational power input)
- Block acts as a 6-way gearbox — shaft connections on all faces, passes rotation through
- Map RPM to light level (e.g., 0 RPM = 0 light, 256 RPM = 15 light)
- Apply fire tick to undead entities within light radius each tick
- Light updates on RPM change

## Open Questions

(None currently)
