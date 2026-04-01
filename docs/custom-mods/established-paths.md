# EstablishedPaths — Review & Revamp Spec

## Existing Mod
- Repo: https://github.com/OurCraftOnCraft/EstablishedPaths
- Target: Minecraft 1.20.1 Forge (correct version)

## Current Functionality

Player foot traffic gradually transforms blocks into worn variants. Chance scales with movement speed — sprinting (50%), walking (~25%), sneaking (0%).

### Transformation Chains
- Grass Block → Dirt → Path
- Stone → Cobblestone → Gravel
- Coarse Dirt → Gravel
- Stone Bricks → Cracked Stone Bricks
- Mycelium → Dirt
- ~~Nether Bricks → Cracked Nether Bricks → Netherrack → Air~~ **REMOVED**
- ~~Soul Sand → Air~~ **REMOVED**
- Ice → Packed Ice → Blue Ice
- Tuff → Gravel
- Magma Block → Cobbled Deepslate

### Code Structure (2 files)
- `EstablishedPathsMod.java` — entry point
- `PathEvents.java` — tick handler, position tracking, block transformation

## Known Issues

- **Memory leak**: `lastPlayerPositions` HashMap never cleaned on logout, grows forever
- **No configuration**: chance and transformation table are hardcoded
- **Chance is flat 10%**: needs rework to scale with movement speed
- **Build artifacts committed to repo** (build/, bin/)
- **Nether transforms to Air**: can create fall-through holes into lava
- **Dirt Path height quirk**: Path blocks are 1 pixel shorter, can break and revert to dirt creating a loop

## Open Questions

- Should the transformation table be configurable?
- Should the 10% chance be configurable?
- Any new transformation chains needed?
