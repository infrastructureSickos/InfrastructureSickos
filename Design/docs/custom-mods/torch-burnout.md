# Torch Burnout — Custom Mod Spec

## Summary

Torches randomly burn out over time, dropping a stick. Rain accelerates burnout for torches exposed to the sky.

## Core Mechanics

- Each torch has a **small random chance per tick** of burning out
- When a torch burns out, it **removes itself** and **drops a stick**
- Chance is **higher** if the torch can see the sky AND it's raining
- Chance is **higher** if an **Enderman** is within **8 blocks**
- Indoor/underground torches burn out very rarely
- Exposed torches in rain burn out more frequently
- Endermen near torches flicker them out — thematic with their reality-bending nature

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **No dependencies** — works standalone
- Random tick or scheduled tick on torch blocks
- Check `level.canSeeSky(pos)` and `level.isRaining()` for increased chance
- Base chance and rain multiplier should be configurable
- Encourages players to use Create-powered heat lamps or other permanent light sources

## Open Questions

(None currently)
