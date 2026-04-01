# Mob Reactions — Custom Mod Spec

## Summary

Certain mobs place blocks when hit, adding environmental hazards to combat.

## Core Mechanics

### On Hit

| Mob | Block Placed |
|-----|-------------|
| Spider | Cobweb at spider's location |
| Drowned | Water source at drowned's location |
| Husk | Sand at husk's location (10% chance) |

- Blocks are placed at the mob's current position when hit
- Standard block placement rules apply (won't replace solid blocks)

### On Death

| Mob | Drop | Chance |
|-----|------|--------|
| Zombie | Gravel block | 25% |
| Skeleton | Gravel block | 10% |
| Husk | Sand block | 50% |

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **No dependencies** — works standalone
- Hook into LivingHurtEvent, check entity type, place block at entity position

## Open Questions

(None currently)
