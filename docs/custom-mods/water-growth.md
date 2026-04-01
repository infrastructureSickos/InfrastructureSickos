# Water Growth — Custom Mod Spec

## Summary

Changes how flowing water interacts with crops and saplings. Instead of breaking them, water is consumed by the plant and acts like bonemeal, advancing their growth stage.

## Core Mechanics

- When flowing water reaches a **crop** or **sapling**, instead of breaking the plant:
  - The water source block is **consumed** (removed)
  - The plant advances one **growth stage** (equivalent to one bonemeal use)
- Works with all vanilla crops and saplings
- Should automatically support modded crops/saplings that extend vanilla plant classes

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **No dependencies** — works standalone
- Intercept the block-breaking event when water flows into a crop/sapling block
- Cancel the break, consume the water source, apply growth tick
- Should be compatible with Flowing Fluids, Flood, and Flash Flood (these mods change water flow behavior, but the interaction point is the same: water flowing into a plant block)

## Open Questions

(None currently)
