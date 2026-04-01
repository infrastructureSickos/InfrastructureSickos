# Portal Pool — Custom Mod Spec

## Summary

A Botania-themed portal system that provides access to all custom dimensions. A single multiblock structure activated by tossing in different items to connect to different destinations. Once activated, the destination is locked.

## Multiblock Structure

- **3x3 platform of Mana Steel Blocks** (9 total)
- When built correctly, forms the Portal Pool
- Portal appears above the platform when activated

## Activation

Toss an item into the Portal Pool to activate it and lock its destination:

| Item | Portal Color | Destination |
|------|-------------|-------------|
| Magma Block | Red | Nether |
| Nether Star | Purple/Dark | End |
| Livingwood Log | Green | Rootways |

- Activation is **permanent** — once set, the destination cannot be changed
- The activator item is consumed
- Portal linking follows **standard Nether portal rules** — a corresponding portal generates in the destination dimension at the appropriate coordinate ratio

## Coordinate Ratios

| Destination | Ratio |
|-------------|-------|
| Nether | 8:1 (standard) |
| End | 1:1 (standard) |
| Rootways | 64:1 |

## Design Principles

- **Depends only on Botania** — Mana Steel Blocks are the only gating material
- **Replaces vanilla portals** — vanilla Nether portal (obsidian + flint & steel) and vanilla End portal (stronghold) are disabled
- **Overrides other mod portals** — when Portal Pool is active, it disables the Rootways standalone portal (and any other custom dimension portals that support the override hook)
- **Simple mechanics** — build, toss, use. No rituals, no mana drain, no maintenance.
- The Portal Pool is the single point of entry for all non-overworld dimensions
- Destination mods (Rootways, etc.) are soft dependencies — the Portal Pool registers activators for detected dimension mods

## Progression Context

- **Nether access** (Magma Block): Available as soon as the player has Mana Steel. Magma Blocks are obtainable from the overworld or Deep Nether.
- **End access** (Nether Star): Requires killing the Wither, which requires Wither Skeleton Skulls from the real Nether. This is a late-game gate.
- **Rootways access** (Livingwood Log): Available as soon as the player has Mana Steel and Livingwood. Livingwood is early Botania.

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- Depends on: Botania (for Mana Steel Blocks and Livingwood)
- Disable vanilla Nether portal ignition
- Disable vanilla End portal activation in strongholds
- Multiblock detection on item toss event
- Portal block rendering with color tinting based on destination

## Breaking/Deactivation

- Breaking any Mana Steel Block from an active Portal Pool **deactivates the portal**
- Rebuilding the 3x3 platform does NOT restore it — a new activator item must be tossed in
- This means breaking an End portal costs another Nether Star to reactivate

## Open Questions
- Should the portal have a visual/particle effect before activation (empty pool) vs. after (colored portal)?
- Does the End portal link to the vanilla End spawn platform, or use coordinate-based linking?
- Sound effects on activation?
