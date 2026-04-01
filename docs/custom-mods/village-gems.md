# Village Gems — Custom Mod Spec

## Summary

Adds colored gem ores and items (one per dye color), and makes each village operate on a specific gem as its currency instead of emeralds. Replaces Silent's Gems.

## Gems

| Color | Gem | Ore? |
|-------|-----|------|
| Red | Ruby | Yes |
| Orange | Amber | Yes |
| Magenta | Tourmaline | Yes |
| Yellow | Topaz | Yes |
| Lime | Peridot | Yes |
| Pink | Rose Quartz | Yes |
| Gray | Moonstone | Yes |
| Light Gray | Opal | Yes |
| Cyan | Aquamarine | Yes |
| Brown | Tiger's Eye | Yes |
| Black | Onyx | Yes |

**Existing gems used as-is (no new ore):**
- Green → Emerald
- Purple → Amethyst
- Blue → Lapis Lazuli
- Light Blue → Diamond
- White → Quartz

## Village Currency

- Each village is assigned a **gem color** as its local currency
- All villager trades in that village use the local gem instead of emeralds
- Assignment could be biome-based, random per village, or hash-based (like FertileBiomes)
- Cafe table trades, shipping container trades, and illager trades all use the local gem

## Currency Exchange Villager (Tier 2 Profession)

- **Workstation**: Exchange Table (TBD recipe)
- **Trades**: Buys and sells all gem types
- Exchanges one gem type for another at a rate (e.g., 2:1 or level-dependent)
- Higher level = better exchange rates
- The only villager that accepts foreign gems

## Emergent Trade

- Players must explore to find villages with the gem they need
- Or set up exchange villagers to convert between currencies
- Shipping containers near exchange villagers enable automated currency conversion
- Natural motivation to connect villages — different currencies create demand for inter-village commerce

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **No dependencies** — works standalone
- 11 new ore types generating in overworld
- Override villager trade system to replace emerald with local gem
- Village gem assignment stored per village (persistent)
- Exchange villager registered as new profession with Exchange Table as POI

## Design Details

- **Gem assignment**: Random per village
- **No decorative gem blocks** — gems are currency and crafting materials, not building materials
- **Three signature equipment pieces** for underused gems:
  - **Onyx Sword** — dark blade
  - **Rose Quartz Helmet** — harmony
  - **Peridot Hoe** — nature, farming
- Stats TBD, but should be roughly diamond-tier
- **Exchange rates**: Loosely based on ore drop rate (rarer gems cost more). Rates **fluctuate per exchange villager** so players can shop around for good deals. Creates a reason to visit multiple villages.

## Open Questions

(None currently)
