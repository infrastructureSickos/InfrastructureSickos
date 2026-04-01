# ImmersiveItemDespawn — Review & Revamp Spec

## Existing Mod
- Repo: https://github.com/OurCraftOnCraft/ImmersiveItemDespawn (private)
- Status: Never worked right, needs revamp

## Intended Functionality

Instead of items despawning (vanishing), they persist in the world:

### Despawn Priority Chain
When an item's despawn timer expires:

1. **Place as block** — if the item is a placeable block (sand, dirt, cobblestone, etc.) and there's space at the item's position, place **one block** in the world
2. **Split remainder** — check which sides of the placed block are vacant. Split the remaining stack evenly and eject as new item entities (with fresh despawn timers) to each open side
3. **If no sides are open** — remaining items are **destroyed** (entombed)
4. **If not a placeable block** — find a nearby container with room and insert the item
5. **If no nearby container** — spawn a **barrel** at the item's position and put the item inside

### Examples
- Stack of 64 sand despawns, 3 open sides → places 1 sand block, ejects three stacks of ~21 to each side
- Those stacks eventually despawn too → each places a block and splits again
- Over time, sand naturally fills and spreads
- A stack entombed with no open sides → destroyed
- A diamond sword despawns → goes into nearest chest, or a barrel is created

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **No dependencies** — works standalone
- Hook into item entity despawn event
- Check if item's corresponding block can be placed at entity position (air check, valid placement)
- Container search radius: configurable (default TBD)
- Barrel placement: find valid adjacent position, place barrel block, insert item
- Places one block per despawn, splits remainder to vacant sides as new item entities
- Items with no vacant sides are destroyed

## Open Questions

- Container search radius?
- If multiple items despawn at the same time in the same spot, do they all try to place/barrel independently, or batch?
- Should barrels created by this mod be visually distinct (like a "junk barrel")?
- What was specifically broken about the original implementation?
