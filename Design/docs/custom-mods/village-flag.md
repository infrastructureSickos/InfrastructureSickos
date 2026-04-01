# Village Flag — Custom Mod Spec

## Summary

A land claim system tied to villages. Flags protect areas by switching non-owners to adventure mode. Radius scales with the sum of villager and pillager levels. Neutral flags generate in structures and override player claims.

## Core Mechanics

### Flag Types

**Player Flag:**
- Crafted by a player — the **crafter's UUID** is stored on the item at craft time
- The flag belongs to whoever crafted it, regardless of who places it
- A player can give their flag to another player to place on their behalf

**Neutral Flag:**
- Generates in structures during worldgen (villages, outposts, etc.)
- Not associated with any player
- Must be broken to claim the area

### Protection Logic (Adventure Mode)

Protection works by **switching the player's game mode**:

1. If the player is in range of **no flags** → **survival mode**
2. If the player is in range of **any flag that belongs to them** (and no neutral flags) → **survival mode**
3. If the player is in range of **only other players' flags** → **adventure mode**
4. If the player is in range of **any neutral flag** → **adventure mode** (overrides even the player's own flag — you cannot share space with neutral claimed land)

### Flags Are Always Breakable
- Flags can be broken by **anyone** with **anything** (bare hands included)
- This works **even in adventure mode** — flags are the one block exempt from adventure mode restrictions
- This allows players to clear neutral flags from structures they want to claim, or break enemy flags during raids

### Protection Radius
- `base` and `multiplier` are configurable (default: base = 16, multiplier = 4)
- Villager/pillager detection uses Minecraft's built-in village system (POI/bell-based)
- If the flag is not in a village, the radius is just the base value

**Player flags:**
- **Radius = base + (multiplier × sum of villager levels)**
- Only villagers contribute — pillagers do not expand player territory
- Incentivizes developing your village economy — trading with villagers grows your territory

**Neutral flags:**
- **Radius = base + (multiplier × (sum of villager levels + sum of pillager levels))**
- Both villagers and pillagers contribute
- Pillager contribution: **1 if unarmed, 2 if armed**
- Neutral territories grow stronger with pillager presence — harder to reclaim

### Generated Flags
- Neutral flags spawn in **all generated structures** (villages, outposts, temples, etc.)
- **1 neutral flag per chunk** of the structure, placed at the **highest point** of that chunk
- A large structure spanning 4 chunks = 4 neutral flags to clear
- Players must break all neutral flags before they can claim the area with their own flag
- Structures are "pre-claimed" by the world itself until cleared
- Finding and breaking all the flags adds exploration gameplay to structures

### Pillager Flag Attacks
- Pillagers **pathfind toward player-owned flags** even if they can't see them
- When a pillager reaches a player flag, the **flag pops** (breaks and drops as an item)
- This means undefended flags are vulnerable to any pillagers in the area (raids, patrols, etc.)
- Players must defend their flags with guards, golems, heat lamps, or walls

## Recipe

```
S W
S
```
- S = Stick
- W = Wool

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **No dependencies** — works standalone
- Flag item stores crafter UUID via NBT data (null/absent UUID = neutral flag)
- Protection via game mode switching (survival ↔ adventure), not custom event blocking
- Flag blocks are exempt from adventure mode restrictions (always breakable)
- Village detection via Minecraft's POI (Point of Interest) system
- Radius recalculated when villagers/pillagers are added/removed (cache with periodic refresh, not every tick)
- Flag appearance: pole with a cloth flag (`|>`)
- Multiple players' flags can overlap — if any flag in range is yours, you're in survival
- No visual radius indicator
- Unlimited flags per player
- Game mode restored when player leaves all non-owned flag radii

## Open Questions

(None currently)
