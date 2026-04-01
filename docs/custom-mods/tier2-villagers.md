# Tier 2 Villagers — Custom Mod Spec

## Summary

Adds new villager professions focused on nation building. Their workstations require high-end resources to craft, making them a late-game investment. These are the bureaucrats, specialists, and leaders that turn a village into a nation.

## Professions

### Social Worker
- **Workstation**: Rehabilitation Desk
- **Ability**: Once per day, attempts to convert one of the following (in priority order):
  1. **Pillager → Villager** (100% success)
  2. **Illager → Villager** (100% success, restores previous profession)
  3. **Nitwit → Villager** (10% success chance)
- Passively seeks out targets within the village territory
- Converted villagers are fresh/unemployed (except restored illagers)


### Captain of the Guard
- **Workstation**: Command Post
- **Behavior**: Wanders the village picking up **dropped weapons** (swords, crossbows, axes, etc.)
- Gives collected weapons to **nitwits first**, then **regular villagers**, converting them into **guards** (Guard Villagers mod)
- **Trade list**: Only **buys weapons** — never sells anything. Levels up by purchasing weapons from the player.
- Higher level = buys better/more expensive weapons
- Depends on: Guard Villagers mod

## Workstation Costs

All tier 2 workstations require resources from mid-to-late game tech tiers:

| Profession | Workstation | Key Ingredients |
|------------|-------------|-----------------|
| Social Worker | Rehabilitation Desk | Mana Steel + Livingwood + Book |
| Captain of the Guard | Command Post | Steel + Iron Block + Brass + Banner |

All require resources spanning multiple tech tiers — these are the "you've beaten the tech tree, now build a civilization" workstations.

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- Depends on: Village Flag, Guard Villagers, Trade Routes, Tax Block, Housing Quality
- New villager profession types registered via Forge's villager profession system
- New workstation blocks (POI types) for each profession
- Custom AI goals per profession (social worker seeks pillagers, caravan master initiates routes, etc.)
- Profession levels affect ability strength (same 1–5 system as vanilla)

## Open Questions

(None currently)
