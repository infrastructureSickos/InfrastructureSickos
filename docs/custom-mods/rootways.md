# Rootways — Custom Mod Spec

## Summary

A fast-travel dimension. The Rootways are the living root network of the world, saturated with raw mana. Travel ratio is 64:1 (one block in the Rootways = 64 blocks in the overworld). Works as a standalone mod with its own portal, but defers to the Portal Pool mod when both are present.

## Core Mechanics

### Dimension Properties
- **Coordinate ratio**: 64:1 to overworld
- **Terrain**: Organic tunnels made of livingwood and livingrock, with glowing mana moss and visible mana veins
- **Immutable**: No blocks can be broken or placed by players
- **Lighting**: Ambient glow from mana-infused surfaces

### Standalone Portal
- **3x3 circle of Logs** (any log type) with **water** in the center
- Toss a **Pumpkin** into the water to activate
- Once activated, the destination is locked
- Uses **standard Nether portal linking rules** with 64:1 ratio

### Portal Pool Override
- When the **Portal Pool** mod is also installed, the standalone Rootways portal is **disabled**
- Rootways access is instead handled through the Portal Pool (Livingwood Log activator)
- The Rootways mod exposes an API/hook for other mods to disable its native portal

### Damage
- **Wither I** applied every 1 second, duration 3 seconds (constantly refreshed while in the dimension)
- Deals 1 heart per 2 seconds
- Unavoidable — no item, armor, or enchantment prevents the effect from being applied
- If you die in the Rootways, **you lose everything** (standard death mechanics, items drop in the dimension)
- The Rootways are hostile transit, not a destination — get in, sprint, get out

## Worldgen

- Pre-generated tunnel network (not infinite open space)
- Tunnels should feel organic and winding, not grid-like
- Occasional wider caverns where tunnels intersect
- No mobs spawn in the Rootways
- No structures, chests, or lootables

## Lore

The Rootways are nature's own circulatory system — the network through which mana flows between all living things. Botania practitioners discovered that this network can be physically entered, but the raw mana concentration is lethal to mortals. No gear can fully shield you — the mana seeps through everything. The Rootways offer unparalleled fast travel, but at a cost. Every second counts. Nature does not permit you to linger in its veins.

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **No hard dependencies** — works standalone without Botania
- Optional soft dependency on Botania (for livingwood/livingrock terrain if available, fallback to oak/stone otherwise)
- Optional soft dependency on Portal Pool mod (disables native portal when detected)
- Dimension registration via Forge dimension system
- Portal logic can likely extend/mirror vanilla Nether portal code with modified ratio
- Block interaction events cancelled for all players in the dimension
- Apply Wither effect (3s duration) every 20 ticks (1 second) via dimension tick handler

## Open Questions

(None currently)
