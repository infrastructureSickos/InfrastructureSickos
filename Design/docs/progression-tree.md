# InfrastructureSickos Progression Tree

## Main Tech Line

```
Vanilla
  │
  ▼
Create ─────────────── Astikor Carts, Aleki's Nifty Ships
  │                     (tweaked to use Create components)
  │ [Brass]
  ▼
Immersive Engineering ─ Immersive Petroleum
  │                     Ultimate Car Mod, Ultimate Plane Mod
  │                     (require IE aluminum + Immersive Petroleum resources)
  │ [Steel → Mana Steel]
  ▼
Botania (early) ──────── Portal Pool (3x3 Mana Steel Blocks)
  │                       ├─ Magma Block → Nether Access
  │                       ├─ Livingwood Log → Rootways Access
  │                       │
  │                       (Nether unlocks rest of Botania:
  │                        Nether Wart, Ghast Tears, Wither Skeletons)
  │
  ▼
Botania (late) ────────── Gaia Guardian (needs Beacon/Nether Star)
  │                       Terrasteel, Elven Trade, endgame
  │
  │ [Nether Star → Portal Pool]
  ▼
End Access
```

## Deep Nether (Overworld Y -64 to 0)

The overworld's deepslate layer (-64 to 0) uses Nether-like terrain generation (custom mod). This provides basic Nether materials (netherrack, nether quartz, glowstone, soul sand, etc.) without requiring actual Nether access. This allows IE's Blast Brick recipe to work since netherrack is accessible by digging deep.

The real Nether still has exclusive content: Ghasts, Wither Skeletons, Nether Fortresses, Bastions, Ancient Debris, Nether Wart, Piglins, and all modded Nether content.

## Gate Details

### Create → Immersive Engineering
- Create's **Brass** is required in IE's early recipes (specific recipes TBD via KubeJS)
- IE's Blast Furnace requires Blast Bricks (Nether Bricks + Blaze Powder from Deep Nether)
- Netherrack for Blast Bricks is available from the Deep Nether (overworld Y -64 to 0)

### Immersive Petroleum → Cars/Planes
- **Ultimate Car Mod** recipes tweaked to require **IE aluminum** and Immersive Petroleum resources
- **Ultimate Plane Mod** recipes tweaked to require **IE aluminum** and Immersive Petroleum resources

### Immersive Engineering → Botania
- IE's **Steel** is required to craft **Mana Steel** in Botania
- Specific recipe modifications TBD via KubeJS

### Botania → Nether
- **Portal Pool** (3x3 Mana Steel Blocks) activated with a **Magma Block**
- Vanilla Nether portal is disabled
- Available early Botania — only requires Mana Steel + an overworld Magma Block

### Botania → Rootways
- **Portal Pool** activated with a **Livingwood Log**
- Available early Botania alongside Nether access

### Nether → End
- **Portal Pool** activated with a **Nether Star**
- Requires killing the Wither in the real Nether (Wither Skeleton Skulls + Soul Sand)
- Vanilla End portal is disabled

## Open Questions

- Exact KubeJS recipes for Create → IE gate (which IE recipes require brass?)
- Which specific Immersive Petroleum resources do cars and planes require alongside aluminum?
