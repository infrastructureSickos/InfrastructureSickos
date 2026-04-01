# InfrastructureSickos Overview

InfrastructureSickos is a Minecraft 1.20.1 Forge modpack about nation building. The ironically named "modest" pack features a long linear tech tree, tiered transportation, village development, territory claiming, and a world that feels alive and reactive.

## Core Themes

### Nation Building
The pack revolves around building and developing villages into thriving settlements. Villagers are central — their levels grow your territory, their economy funds your progression, and their happiness determines whether your nation holds together or falls to civil unrest.

### Tech Progression
A long, gated linear tech tree provides the backbone:
**Create → Immersive Engineering → Botania**

Each tier unlocks new infrastructure, automation, and capabilities. The tech isn't the goal — it's the tool you use to build your nation.

### Transport & Infrastructure
As your tech advances, so does your ability to connect and expand:
- **Carts and ships** (Create tier) — early exploration and trade
- **Cars and planes** (IE tier) — rapid expansion
- **Rootways** (Botania tier) — fast travel network connecting distant settlements

### Living World
The world reacts to player presence:
- **Paths form** from foot traffic
- **Fire spreads** chaotically
- **Stone cracks** when mined without support
- **Sand pours** sideways into gaps
- **Water feeds crops** instead of breaking them
- **Terrain weathers** and erodes over time
- **Wild crops** grow naturally in fertile biomes

### Territory & Conflict
- **Flags** claim territory, with radius scaling based on villager levels
- **Structures are pre-claimed** — find and break neutral flags to take over
- **Pillagers** spawn from civil unrest at player-owned flags
- **Angry villagers** become pillagers if mistreated
- **Pillagers attack flags** — defend your territory or lose it

### Hostile Dimensions
The Nether and End are accessed through Botania and designed to be extremely dangerous. The Nether unlocks mid/late Botania progression, and the End is the ultimate challenge.

## Progression Gates

| From | To | Gate Material |
|------|----|---------------|
| Vanilla | Create | (natural progression) |
| Create | Immersive Engineering | Brass (Create alloy) |
| Immersive Engineering | Botania | Steel → Mana Steel |

## Transport Tiers

| Tier | Mod | Transport |
|------|-----|-----------|
| Create | Astikor Carts | Carts (tweaked with Create components) |
| Create | Aleki's Nifty Ships | Boats/Ships (tweaked with Create components) |
| IE | Ultimate Car Mod | Cars (tweaked with IE Petroleum resources) |
| IE | Ultimate Plane Mod | Planes (tweaked with IE Petroleum resources) |
| Botania | Rootways (custom) | Fast travel dimension (64:1 ratio) |

## Dimensions

- **Overworld**: Standard gameplay with Deep Nether layer (Y -64 to 0). Full tech tree plays out here.
- **Nether**: Accessed via Portal Pool (Magma Block). Extremely hostile. Unlocks late Botania.
- **End**: Accessed via Portal Pool (Nether Star). The ultimate challenge.
- **Rootways**: Accessed via Portal Pool (Livingwood Log). Fast travel, constant Wither I damage, immutable terrain.

## Server Infrastructure

| Environment | Player Capacity | Notes |
|-------------|----------------|-------|
| Dev | 1 | Local development and testing |
| Staging | 4 | Pre-release testing |
| Prod | 20 | Dynamic/scheduled scaling (TBD) |

## Minecraft Version & Loader

- **Version**: 1.20.1
- **Mod Loader**: Forge
- **Mod Source**: Modrinth (all 3rd-party mods must be available on Modrinth)
