# Stealth — Custom Mod Spec

## Summary

Mobs can only detect players based on line of sight (facing direction) and light level. Darker areas and staying behind mobs makes you harder to detect.

## Core Mechanics

### Detection Factors
- **Facing direction**: Mobs can only detect players within their forward-facing cone of vision. Behind a mob = undetected.
- **Light level**: Lower light = harder to detect. Full darkness significantly reduces detection range. Full light = normal vanilla detection range.

### Combined Effect
Detection range scales with both factors:
- Mob facing you + bright light = normal vanilla detection range
- Mob facing you + darkness = reduced range
- Mob facing away + bright light = very short range (peripheral awareness)
- Mob facing away + darkness = nearly undetectable

### What's Affected
- All hostile mobs that target players (zombies, skeletons, creepers, spiders, etc.)
- Does not affect mobs that have already detected you (once aggro'd, they track normally)
- Sneaking further reduces detection (stacks with light/facing)

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **No dependencies** — works standalone
- Override mob targeting AI goal's detection range based on light level at player position + angle between mob facing direction and player position
- Does not affect already-aggro'd mobs (only initial detection)

## Open Questions

(None currently)
