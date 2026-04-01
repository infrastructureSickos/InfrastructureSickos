# DangerousStone — Review & Revamp Spec

## Existing Mod
- Repo: https://github.com/OurCraftOnCraft/DangerousStone
- Target: Minecraft 1.20.1 Forge (correct version)

## Current Functionality

Mining stone causes cracks to propagate through neighboring blocks via BFS. Transformation chains:

- Stone → Cobblestone → Gravel
- ~~Andesite → Cobblestone → Gravel~~ **REMOVED**
- Tuff → Gravel
- Stone Bricks / Mossy / Chiseled → Cracked Stone Bricks
- Blue Ice → Packed Ice → Ice → Water
- ~~Deepslate → Cobbled Deepslate → Magma Block → Lava~~ **REMOVED**

Crack chance depends on tool tier (Wood: 50%, Stone: 35%, Iron: 10%, Diamond/Netherite: 0%). Wood/log blocks within a **6 block radius of the player** act as structural support and prevent cracking in that area.

### Config
- Per-tier crack chances
- Max blocks converted per break (default 24)
- Max distance (default 6, Manhattan)
- Air exposure toggle

## Known Bugs

- **Double event registration**: `StoneBreakEvents` is both manually registered AND auto-registered via `@Mod.EventBusSubscriber`, causing propagation to fire twice per break
- **Excessive logging**: `LOGGER.info()` on every block check, spams server logs
- **Build artifacts committed to repo**
- **Synchronous BFS on server thread**: bad configs could cause tick lag

## Open Questions

- Any changes to transformation chains or mechanics?
