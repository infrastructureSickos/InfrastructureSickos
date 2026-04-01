# InfrastructureSickos Dimension Design

## Portal Pool (Custom Mod)

All non-overworld dimensions are accessed via the **Portal Pool** — a 3x3 platform of Mana Steel Blocks. Toss an item in to activate and lock the destination. Vanilla Nether portals and End portals are disabled.

| Activator | Color | Destination | Progression Gate |
|-----------|-------|-------------|-----------------|
| Magma Block | Red | Nether | Early Botania (Mana Steel + overworld magma) |
| Nether Star | Purple/Dark | End | Late game (requires Wither kill in Nether) |
| Livingwood Log | Green | Rootways | Early Botania (Mana Steel + Livingwood) |

Once activated, the destination is **permanently locked**. Portal linking follows standard Nether portal rules.

## Overworld

Standard vanilla overworld with one major modification: the deepslate layer (Y -64 to 0) uses **Nether-like terrain generation** (custom mod: Deep Nether). This provides basic Nether materials (netherrack, nether quartz, glowstone, soul sand, blazes, etc.) without actual Nether access, allowing IE's Blast Brick recipe to work naturally.

The full tech tree (Create → PneumaticCraft → IE → Botania) plays out in the overworld before players gain access to other dimensions.

## Nether

### Access
- **Portal Pool** activated with a **Magma Block**
- Available as soon as the player has Mana Steel (early Botania)
- Magma Blocks are obtainable from the overworld (Deep Nether layer or magma underwater)

### Design Goals
- **Extremely hostile**. The Nether should feel dangerous and unwelcoming at all times.
- The reward for braving the Nether is obtaining resources needed for late Botania (Nether Wart, Ghast Tears, Wither Skeleton Skulls) and ultimately the End.
- Not intended as a place to set up permanent bases or tech.

### Enhancement Mods (Under Consideration)
- L'Ender's Cataclysm — Boss dungeons (Soul Forge, Burning Arena)
- Incendium — 8 new biomes, 9 structures, custom bosses
- Advanced Netherite — 4 tiers beyond standard netherite
- Bygone Nether — Biome-specific hostile structures
- Infernal Expansion Redux — Unique hostile mobs per biome

## End

### Access
- **Portal Pool** activated with a **Nether Star**
- Requires killing the Wither (3 Wither Skeleton Skulls from real Nether + 4 Soul Sand)
- This is a significant late-game gate — players must brave the hostile Nether extensively

### Design Goals
- **Extremely hostile**. The End is the ultimate challenge.
- The reward for the End is **the challenge itself** — no major tech unlocks here.
- Should feel like a true endgame gauntlet.

### Enhancement Mods (Under Consideration)
- Progressive Bosses — Dragon gets harder each kill (infinite scaling)
- Nullscape — Dramatic terrain overhaul (384 block height)
- The Outer End — Hostile dungeons, Crystal Armor with void protection
- BetterEnd Forge — 13+ biomes, creatures, resources
- Enderite Mod — End-exclusive ore tier above netherite

## Rootways (Custom Mod)

### Access
- **Portal Pool** activated with a **Livingwood Log**
- Available early Botania alongside Nether access

### Environment
- Organic tunnels of **livingwood** and **livingrock**
- Glowing mana-infused moss lighting
- Visible mana veins pulsing through walls
- The terrain is **fully immutable** — no blocks can be broken or placed

### Hazard
- **Mana poisoning** — raw ambient mana damages players over time
- Protection requires **Manasteel Weave Armor** or a protective bauble (crafted from manasteel + livingwood + mana pearls, TBD)

### Design Principles
- Immutable terrain prevents griefing, highway building, or cheesing
- Players are guests in nature's infrastructure, not builders
- Fits Botania's theme: mana flows through all of nature, the Rootways are that flow made traversable
- Simple mechanics: walk in, walk through, walk out. No gimmicks.
- 64:1 coordinate ratio to overworld
