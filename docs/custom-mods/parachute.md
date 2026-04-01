# Parachute — Custom Mod Spec

## Summary

Removes elytra from the game. Adds a parachute item that automatically deploys when a player reaches lethal fall speed, saving them from fall damage.

## Core Mechanics

### Parachute Item
- Craftable item, held in inventory (not worn)
- When a player's fall speed reaches the threshold that would kill them, a parachute is **automatically consumed** from their inventory
- The parachute deploys, drastically slowing the player's descent
- Player floats down safely and the parachute is gone (single use)

### Deployment
- Triggers automatically — no button press needed, no manual deploy
- Consumes one parachute item from **any inventory slot**
- If no parachute is in inventory, nothing happens (normal fall death)
- Dampens **all velocity** (not just vertical — player slows in every direction)
- Visual: parachute canopy renders above the player while descending

## Recipe

```
W W W
S S S
  S
```
- W = Wool Sheet (Create mechanical press)
- S = String

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **No dependencies** — works standalone
- Monitor player velocity each tick; when downward speed exceeds lethal threshold, trigger deployment
- On deployment: consume item, apply slow falling or set velocity, render parachute
- Parachute effect ends on landing

## Elytra Removal
- Elytra is **removed from the game** (disabled drop from End ships, removed from loot tables)
- Parachute is the replacement for controlled descent
- Flight is handled by Ultimate Plane Mod (IE tier) and PneumaticCraft jet boots

## Open Questions

(None currently)
