# Flash Creeper — Custom Mod Spec

## Summary

Reworks creeper explosions into flashbang-style disorientation attacks. No damage, no block destruction, but full knockback and a new "Flash" effect that blinds, deafens, and disorients the player.

## Core Changes

### Explosion
- **No damage** to players or entities
- **No block destruction**
- **Full knockback** — same push force as vanilla creeper explosion
- **Sets player look direction away** from the creeper's position (snaps camera away from the blast)

### Flash Effect (New Status Effect)
Applied to all players/entities within explosion radius:

**Visual:**
- Screen goes **white** (full screen overlay)
- White fades out gradually over the effect duration

**Audio:**
- **Flashbang ringing sound** plays on effect start
- **All other game sounds are muted** while the effect is active
- Ringing and mute fade out gradually as the effect ends

**Mob effects:**
- **50% movement speed** during flash
- **Cannot attack** during flash

**Combined with the knockback and forced look direction, the player is:**
1. Thrown backwards
2. Looking the wrong way
3. Blinded by white screen
4. Deafened with ringing

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **No dependencies** — works standalone
- Override creeper explosion event: cancel damage and block breaking, keep knockback
- Register custom "Flash" potion effect
- Client-side rendering: white overlay shader/screen effect that fades with remaining effect duration
- Client-side audio: play ringing sound, suppress all other sound categories during effect
- Force player look direction via packet on explosion (rotate yaw 180° from creeper position)
- Effect duration TBD — probably 3–5 seconds

## Open Questions

(None currently)
