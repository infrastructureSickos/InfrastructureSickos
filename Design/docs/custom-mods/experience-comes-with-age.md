# ExperienceComesWithAge — Review & Revamp Spec

## Existing Mod
- Repo: https://github.com/OurCraftOnCraft/ExperienceComesWithAge
- Target: Minecraft 1.20.1 Forge (correct version)

## Current Functionality

Passively awards XP to all online players at regular intervals.

### Config
- `enabled` — toggle on/off
- `xpPerInterval` — XP points per award (default 7)
- `intervalSeconds` — seconds between awards (default 60)
- `onlySurvival` — restrict to survival mode only (default false)

### Code Structure (3 files)
- `ExperienceComesWithAgeMod.java` — entry point
- `ECAConfig.java` — config spec
- `ServerTickHandler.java` — tick counter, awards XP when interval reached

## Known Issues

- **Minor**: tick counter persists across server restarts in same JVM session (singleplayer edge case)
- **No LICENSE file** despite mods.toml declaring MIT
- **Missing `gradlew` script** (only gradlew.bat for Windows)

## Open Questions

- Any changes to the mechanic, or just bug fixes?
