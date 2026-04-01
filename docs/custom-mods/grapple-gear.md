# Grapple Gear — Custom Mod Spec

## Summary

Adds four throwable/ranged tools: a leather whip, a brass hookshot, a diamond fishing spear (fishing spear), and a flint hunting spear. Each has distinct tether and combat mechanics.

## Items

### Hunting Spear (Flint)
**Early game throwable weapon — no tether**

- Thrown like a trident
- Deals arrow-equivalent damage
- **1 in 10 chance of breaking** on impact
- If it doesn't break, it sticks in the ground/entity and can be picked up
- No tether, no retrieval mechanic — just throw and recover
- Early game ranged weapon before the player gets a bow

**Recipe:** TBD — flint + sticks

### Leather Whip
**Crowd control weapon with short-range grapple**

- **4 block range** melee attack with a long cooldown
- **Combat**: Hitting an entity deals damage normally
- **Taunt**: Attacking with the whip causes all hostile mobs in an **8 block radius** to target the player (loud crack sound draws aggro)
- **Grapple**: If you attack a **wood plank or any non-full-block** (fences, trapdoors, slabs, stairs, leaves, etc.), the whip connects you to it with a lead-like tether
  - **Works in adventure mode** — attaching doesn't break or place blocks
  - Tether breaks when you **attack with the whip again** or **jump**
  - While tethered, you swing/hang from the connection point
- Does not connect to full solid blocks (stone, dirt, etc.)

**Recipe:** TBD — leather + sticks

### Brass Hookshot
**Mid-game grappling hook — pull yourself to blocks**

- Attacking fires a hook projectile with a tether back to the player
- Hook attaches to **any block** it hits
- Once the hook lands, the **max tether distance is set** to the current player-hook distance
- If the hook travels more than **16 blocks** from the player without hitting anything, it despawns
- **Right-click (hold)**: Reduces tether distance, pulling the player toward the hook
- **Hooking an entity**: Deals damage and the hook despawns immediately (no tether)
- **Attacking again** or **jumping** despawns the previous hook
- Only one hook can exist at a time — firing a new one despawns the old one

**Recipe:** TBD — brass + sticks + string

### Diamond Fishing Spear
**Late-game tethered spear — pulls entities, slides down blocks, catches fish**

- Attacking throws the spear with a tether back to the player
- Attaches to **any entity or block**

**Entity hit:**
- Entity is tethered to the player
- Tether distance **slowly decreases**, pulling the entity toward the player ("get over here")
- When distance reaches 0 or the entity arrives, the spear returns

**Block hit:**
- Spear sticks in the block
- Tether distance **slowly increases** (player slides/falls away from the block)
- When distance reaches **16 blocks**, the spear auto-returns (as if you attacked or jumped)

**Fishing mechanic:**
- When the spear returns and is **underwater** at the time, there is a **0–25% chance** of getting fishing loot
- Chance scales with how little distance remains — closer to the spear = higher chance (0 distance = 25%, 16 distance = 0%)

**Despawn/return:**
- Attacking again or jumping returns the spear
- Auto-returns at 16 block distance (block hit only)

**Recipe:** TBD — diamond + sticks + string

## Shared Mechanics

All tethered items (whip, hookshot, fishing spear):
- Tether visually renders as a line between player and hook point (like a lead)
- Attacking or jumping breaks/despawns the connection
- Only one active tether per player at a time

### Tether Physics
- **Whip**: Rigid pendulum — fixed length, player swings like a wrecking ball
- **Hookshot**: Rigid — fixed max length, player pulls toward hook point
- **Fishing Spear**: Slightly elastic — tether has give, entities bounce a bit when pulled

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **No dependencies** — works standalone (brass ingredient means Create is a soft dependency for the hookshot recipe)
- Custom projectile entities for hook, spear, hunting spear
- Tether rendering via custom line renderer (similar to lead rendering)
- Taunt mechanic: modify target AI of hostile mobs within radius on whip attack event
- Fishing loot: use vanilla fishing loot table when spear returns underwater

## Open Questions

- Exact recipes for each item?
- Durability values for each item?
- Does the whip's taunt work through walls?
- Grapple spear entity pull speed — how fast does the tether shorten?
- Hookshot pull speed when holding right-click?
