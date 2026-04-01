# DangerousSand — Review & Revamp Spec

## Existing Mod
- Repo: https://github.com/OurCraftOnCraft/DangerousSand
- Target: Minecraft 1.20.1 Forge (correct version)

## Current Functionality

Falling blocks (sand, gravel, concrete powder) "pour" sideways when they land. If an adjacent column is empty for `dropDepth` blocks deep, the block slides sideways into that column. Creates cascading avalanche behavior.

### Config
- `dropDepth` (default 3): how deep the adjacent column must be empty
- `allowReplaceable` (default false): whether grass/snow count as empty
- `maxMovesPerTick` (default 512): safety throttle

## Known Bugs

- **Build artifacts committed** (build/, .gradle/ in repo)
- **Memory leak**: `blocksToCheck` map keyed by Level instances, never cleaned on dimension unload
- **Recursive `server.execute()` polling**: fragile timing, can queue many runnables with lots of falling blocks
- **Race condition**: gap between entity landing and block placement detection
- **Pour only moves one block per landing**: slow cascading, requires re-detection each step

## Open Questions

- Any gameplay changes needed, or just bug fixes?
