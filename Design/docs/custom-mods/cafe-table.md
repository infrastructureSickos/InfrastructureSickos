# Cafe Table — Custom Mod Spec

## Summary

A block that attracts villagers during their socializing period. Villagers sit at cafe tables and their trade list temporarily swaps to a food menu — they buy food for emeralds. Cafe trading levels up villagers the same way normal trading does, unlocking more food options at higher levels.

## Core Mechanics

### Cafe Table Block
- Small table block, full block height (carpet can be placed on top as a tablecloth)
- Two variants: **Wooden** and **Stone**
- Villagers are attracted to nearby cafe tables after they visit the bell for socializing
- Multiple villagers can use the same table, but they prefer tables with fewer villagers already seated

### Villager Behavior

**Arrival:**
1. Cafe tables function as **alternative gathering points** (like bells) — villagers can socialize at a cafe table instead of a bell
2. Villagers walk to a nearby cafe table (preferring less crowded tables)

**At the table:**
- Villager's normal trade list is **replaced** with a cafe food menu (villager is "on break")
- Player interacts with the villager via the standard trading UI
- Cafe trades accept **food items** and pay **emeralds**
- Completing cafe trades levels up the villager the same way normal trades do
- Higher villager levels unlock more food items on the cafe menu (parallel to normal trade unlocks)
- **10% chance** of spawning a child villager per cafe trade completed

**Leaving:**
- When the villager's next scheduled activity starts (work, sleep, etc.), they leave the table
- Normal trade list is restored
- One visit per socializing period

### Food Menu
- Includes all valid food items (vanilla + modded)
- Food options are tiered by villager level, unlocking more as the villager levels up
- Food menu is a second trade list parallel to the villager's normal profession trades

## Recipes

**Wooden Cafe Table:**
```
P P P
  F
  F
```
- P = any Plank, F = any Fence

**Stone Cafe Table:**
```
T T T
  W
  W
```
- T = any Stone Slab, W = Cobblestone Wall

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **No dependencies** — works standalone
- Hook into villager AI/schedule system — add cafe table visit as a behavior during the socializing period (after bell)
- Swap villager's MerchantOffers when seated at cafe, restore on leave
- Cafe trade list stored as a second offer set on the villager (persistent via NBT)
- Leveling uses vanilla villager XP system — cafe trades grant XP same as normal trades
- Child spawn: 10% roll per completed cafe trade, standard baby villager spawned nearby
- Table crowding: villagers pathfind to the nearest cafe table weighted by inverse occupancy
- Modded food detection: scan item registry for anything extending vanilla food properties

## Open Questions

- Should emerald payout scale with food rarity/complexity? (Revisit later)
- Exact food-to-level tier mapping?
