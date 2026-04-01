# Ultimate Immersive Tool — Custom Mod Spec

## Summary

Makes IE's Engineer's Hammer work in place of Ultimate Car Mod's wrench for car interactions.

## Core Mechanics

- **IE's Engineer's Hammer** is accepted anywhere UC's wrench is expected
- Remove UC wrench recipe
- Create's wrench remains separate (it's a different tool for a different purpose)

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- Depends on: Immersive Engineering, Ultimate Car Mod, Ultimate Plane Mod
- Intercept UC's wrench checks and UP's wrench checks, accept IE's hammer item for both
- Remove UC wrench and UP plane wrench recipes
- May require mixins into both mods' wrench-check code

## Open Questions

(None currently)
