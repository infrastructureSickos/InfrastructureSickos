# Simple Waterwheel — Custom Mod Spec

## Summary

Overrides Create's water wheel behavior. Instead of checking water flow direction and speed, the wheel simply counts how many water blocks are directly adjacent to it. More water = more speed. Always turns the same direction regardless of water flow.

## Core Mechanics

- Water wheel speed is based on **number of adjacent water blocks** (not flow direction or velocity)
- **Direction is constant** — always turns the same way regardless of water placement
- Any water block counts equally (source, flowing, any level)
- Compatible with modded water behavior (Flowing Fluids, Flood, Flash Flood)

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **Depends on**: Create
- Override Create's water wheel rotation calculation
- Count water blocks in the wheel's contact area, map count to RPM
- Ignore flow direction entirely

## Open Questions

(None currently)
