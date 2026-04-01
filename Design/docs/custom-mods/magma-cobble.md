# Magma Cobble — Custom Mod Spec

## Summary

Changes the water + lava interaction to produce magma blocks instead of cobblestone/stone. Breaking magma blocks drops lava instead of a magma block item.

## Core Mechanics

### Water + Lava → Magma Block
- Replaces all vanilla water/lava interactions:
  - Flowing water + flowing lava → magma block (instead of cobblestone)
  - Water + lava source → magma block (instead of obsidian)
- Applies everywhere (overworld, Deep Nether, etc.)
- **Obsidian** is no longer obtainable via water + lava. A KubeJS Create Mixer recipe will be added (lava + water, superheated)
- **Magma block items** obtainable via silk touch on any magma block

### Breaking Magma Blocks
- Breaking a magma block does **not** drop a magma block item
- Instead, it places a **lava source block** where the magma block was
- **Silk touch** bypasses this — drops the magma block item normally
- Applies to all magma blocks (player-created and naturally generated)

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **No dependencies** — works standalone
- Override the fluid interaction logic for water + lava
- Override magma block's loot table / break behavior to place lava instead of dropping item

## KubeJS Recipes Needed

- **Obsidian**: Create Mixer, superheated — lava + water → obsidian
- **Magma block**: Create Mixer — TBD recipe (lava + ?)

## Open Questions

(None currently)
