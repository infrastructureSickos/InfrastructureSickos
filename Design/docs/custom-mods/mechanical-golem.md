# Mechanical Golem — Custom Mod Spec

## Summary

Renames and reworks iron golems into Mechanical Golems. Removes natural spawning, removes player aggression, and adds a Create mechanical crafting recipe for a Mechanical Golem spawn egg.

## Core Changes

### Spawning
- **Disable natural iron golem spawning** in villages (villagers can no longer summon them)
- **Disable player-built iron golems** (iron blocks + pumpkin no longer works)
- Golems are only obtainable via the **Mechanical Golem Egg** crafted through Create's Mechanical Crafter

### Behavior
- **Remove all player aggression** — Mechanical Golems never attack players regardless of reputation
- All other behavior remains (attacks hostile mobs, defends villagers, wanders village)

### Naming
- Rename "Iron Golem" → **"Mechanical Golem"** everywhere (entity name, spawn egg, death messages, etc.)

### Crafting
- **Mechanical Golem Egg** crafted via Create's **Mechanical Crafter**

```
    C
I I B I I
I   P   I
I   I   I
  I   I
  I   I
```
- I = Iron Block
- B = Brass Block
- P = Precision Mechanism
- C = Carved Pumpkin

Shaped like a golem — wide shoulders, narrow legs, pumpkin head.

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- Depends on: Create (for Mechanical Crafting recipe)
- Suppress natural golem spawning via village AI/spawning rules override
- Cancel the iron blocks + pumpkin golem construction event
- Remove player-targeting AI goal from iron golem entity
- Rename via lang file overrides or entity attribute modification
- Spawn egg creates a standard iron golem entity (just renamed and with modified AI)

## Open Questions

(None currently)
