# Discomfort — Custom Mod Spec

## Summary

Retextures villagers to remove the exaggerated nose from their model/texture. Applies to all villager types (regular villagers, zombie villagers, wandering traders, etc.).

## Core Changes

- Replace villager textures with versions that have a normal/proportional nose
- Applies to all villager professions and biome variants
- Applies to zombie villagers
- Applies to wandering traders

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **No dependencies** — works standalone
- Implemented as a **resource pack** (bundled in a mod or standalone)
- Make the nose region of villager textures **transparent** — the 3D geometry remains but is invisible
- No model override needed

## Open Questions

(None currently)
