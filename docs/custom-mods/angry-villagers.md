# Angry Villagers — Custom Mod Spec

## Summary

Villagers with very low reputation toward a player become illagers. Illagers are a villager profession whose workstation is the player's flag — when they claim it, the flag becomes neutral, revoking the player's territory.

## Core Mechanics

### Villager → Illager Conversion
- Uses vanilla Minecraft's **villager reputation system**
- When a player's reputation with a villager drops below a configurable threshold (-100, matching golem aggro), the villager becomes an **illager**
- Illager is a **villager profession** — they're still villagers mechanically
- Previous profession/trades/XP stored in NBT

### Illager Behavior
- Illager's workstation is the **player's flag** (the player whose reputation triggered the conversion)
- Illagers pathfind to the flag like any villager going to work
- When an illager claims a player flag as their workstation, the flag becomes **neutral** (player ownership removed)
- Neutral flags put everyone in adventure mode — territory is effectively lost

### Illager Trading
- Illagers have a trade list — but it's junk
- **They sell**: dirt, gravel, sticks, rotten flesh, cobblestone, suspicious stew (several emeralds), and other trash items
- **They buy**: food items and emeralds
- They've given up contributing — just surviving and taking what they can

### Illager → Pillager
- If an illager's flag (their workstation) is **broken**, the illager becomes a **pillager with a wooden sword**
- This means breaking a neutralized flag has consequences — the illager radicalizes

### Pillager-Illager Relations
- Pillagers **do not attack illagers**
- They coexist — illagers are sympathizers, not targets
- If an illager **witnesses** a player kill a pillager or villager, they instantly become a **pillager with a wooden sword**
- Violence breeds more violence — careless killing near illagers escalates fast

### Restoration
- If an illager hasn't yet claimed a flag, they can reclaim a normal profession if a workstation is available
- Player can break the neutralized flag and re-place their own (but the illager becomes a pillager)

## Conversion Details

- **Villager → Illager**: Stores previous profession/trades/XP in NBT. Illager profession assigned.
- **Illager → Pillager**: If their flag workstation is broken, they radicalize into a pillager with a wooden sword.
- Illagers still count toward village population and flag radius (at their current level).

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- Depends on: Village Flag mod (for flag workstation registration)
- Register "illager" as a villager profession with player flags as the POI/workstation type
- On workstation claim event: check if the claiming villager is an illager, if so neutralize the flag
- Reputation threshold: configurable (default: -100)
- Hook into vanilla reputation/gossip system

## Open Questions

(None currently)
