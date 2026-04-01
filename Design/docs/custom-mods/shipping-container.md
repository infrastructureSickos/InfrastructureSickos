# Shipping Container — Custom Mod Spec

## Summary

A block that automates villager trading. It has two inventories: a sell side (input) and a bought side (output). If a nearby villager would buy items in the sell side, the trade executes automatically and payment appears in the bought side.

## Core Mechanics

### Shipping Container Block
- Two-sided inventory:
  - **Sell side (input)**: Place items here to sell
  - **Bought side (output)**: Emeralds (or trade outputs) appear here after a trade completes

### Trading Logic
- Periodically checks for nearby villagers
- If any nearby villager has a trade matching items in the sell side, the trade executes
- Items are consumed from the sell side, payment placed in the bought side
- Trades respect the villager's normal trade limits (lock out when overused, refresh on restock)
- Trades level up the villager the same way manual trading does
- Works with both normal profession trades and cafe table trades (if a villager at a cafe has food trades, the container can fulfill those too)

### Configuration
- **Villager must be near their job station** — default: on
- **Villager must be awake** — default: on

### Automation
- Hoppers/pipes can push items into the sell side
- Hoppers/pipes can pull items from the bought side
- Enables full automation of villager trading via Create, PneumaticCraft, or vanilla hoppers

## Recipe

```
I W I
W   W
I W I
```
- I = Iron Ingot, W = any Plank

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **No dependencies** — works standalone
- Scans for villagers within a configurable radius (default: 4 blocks)
- Container inventory: two separate IItemHandler capabilities, one per side
- Trade execution respects villager trade locks and restocking schedule
- Hopper/pipe interaction: input pushes to sell side, output pulls from bought side

## Appearance

- Full block, grey/iron colored mini shipping container with ridged sides

## Open Questions

(None currently)
