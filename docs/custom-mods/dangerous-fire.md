# DangerousFire — Review & Revamp Spec

## Existing Mod
- Repo: https://github.com/OurCraftOnCraft/DangerousFire
- Target: Minecraft 1.20.1 Forge (correct version)

## Current Functionality

Two mechanics:

### Lava/Magma Ignition
- Lava and magma blocks can ignite nearby flammable blocks within configurable radius (default: 3 for lava, 2 for magma)
- Triggered on block placement or neighbor update

### Chaotic Fire Spread
- When fire goes out naturally (not punched by player), 50% chance (configurable) it spawns 2 new fire blocks at random nearby positions
- Creates hydra-like effect — extinguishing fire can cause it to jump and spread unpredictably
- Player-broken fire does NOT trigger spread

### Config
- Lava/magma ignition radius and chance
- Fire spread chance and distance

## Known Bugs

- **Lava ignition doesn't work**: `placeFire` only places fire on empty (air) blocks, but it's called at the flammable block's position (which is occupied). Should place fire adjacent to/above the flammable block.
- **Memory leak**: `checkedLavaPositions` and `checkedMagmaPositions` are plain HashSets, not per-level. Grow unboundedly between periodic clears.
- **`scanForFireBlocks` is a no-op**: Empty method body, so fires from lightning/existing world aren't tracked.
- **Double registration potential**: Worth checking (other repos had this bug)
- **Build artifacts committed to repo**

## Open Questions

- Keep current behavior or redesign fire mechanics?
