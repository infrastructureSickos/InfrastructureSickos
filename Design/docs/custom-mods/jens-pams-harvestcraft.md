# Jen's Pam's Harvestcraft — Custom Mod Spec

## Summary

An unofficial reimplementation of Pam's HarvestCraft 2 Crops and Trees for 1.20.1 Forge. Adds the same crops and fruit/nut trees with original AI-generated assets. Uses the same forge tags so that Pam's Food Core and Food Extended recipes work seamlessly.

## What It Replaces

- **Pam's HarvestCraft 2 - Crops** (not on Modrinth for 1.20.1)
- **Pam's HarvestCraft 2 - Trees** (not on Modrinth for 1.20.1)

## Content

### Crops (~96)

**Fruits (16):** Blackberry, Blueberry, Cactus Fruit, Candleberry, Cantaloupe, Cranberry, Elderberry, Grape, Green Grape, Huckleberry, Juniperberry, Kiwi, Mulberry, Pineapple, Raspberry, Strawberry

**Vegetables (37):** Arrowroot, Artichoke, Asparagus, Bell Pepper, Broccoli, Brussel Sprout, Cabbage, Cassava, Cauliflower, Celery, Chili Pepper, Cucumber, Eggplant, Garlic, Jicama, Kale, Kohlrabi, Leek, Lettuce, Okra, Onion, Parsnip, Peanut, Peas, Radish, Rhubarb, Rutabaga, Scallion, Spinach, Sweet Potato, Taro, Tomatillo, Tomato, Turnip, Water Chestnut, Winter Squash, Zucchini

**Grains (12):** Amaranth, Barley, Bean, Chickpea, Corn, Lentil, Millet, Oats, Quinoa, Rice, Rye, Soybean

**Fibers (5):** Cotton, Flax, Jute, Kenaf, Sisal

**Herbs/Misc (8+):** Agave, Coffee Bean, Curry Leaf, Ginger, Mustard Seeds, Sesame Seeds, Spice Leaf, Tea Leaf, White Mushroom

### Trees (~50)

**Temperate:** Apple, Avocado, Candlenut, Cherry, Chestnut, Gooseberry, Hazelnut, Lemon, Nutmeg, Orange, Pawpaw, Peach, Pear, Plum, Soursop, Walnut

**Warm Fruit:** Almond, Apricot, Banana, Breadfruit, Cashew, Coconut, Date, Dragonfruit, Durian, Fig, Grapefruit, Guava, Jackfruit, Lime, Lychee, Mango, Olive, Papaya, Passionfruit, Pecan, Peppercorn, Persimmon, Pistachio, Pomegranate, Rambutan, Starfruit, Tamarind, Vanilla Bean

**Cold:** Pine Nut

**Log Fruit:** Cinnamon, Maple (drops Maple Syrup), Paperbark

### Garden Bushes
- 6 garden bush types that spawn in biomes and drop crop items (matching Pam's Crops behavior)

## Forge Tags

Must register items under the same forge tags as Pam's Crops/Trees:
- `forge:fruits` — all fruit items
- `forge:vegetables` — all vegetable items
- `forge:crops` — all crop items
- Individual item tags (e.g., `forge:crops/tomato`, `forge:fruits/banana`) for specific recipe matching

This ensures Food Core and Food Extended recipes accept Jen's Pam's items interchangeably.

## Assets

- All textures are **original AI-generated art** — no Pam's assets used
- Item textures, crop stage textures, tree/leaf/sapling textures all need generation
- Style should be consistent with vanilla Minecraft's pixel art feel (16x16)

## Technical Notes

- Target: Minecraft 1.20.1 Forge
- **Depends on**: Pam's HarvestCraft 2 Food Core (for tag compatibility and crafting tools)
- Must match Pam's Crops/Trees forge tag structure exactly
- Garden bush worldgen should match biome distribution of original mods
- Tree worldgen should match climate-appropriate biome spawning

## Mod IDs

- Uses Pam's original mod IDs: `pamhc2crops` and `pamhc2trees`
- Drop-in replacement — Food Core and Food Extended recipes work without modification
- **Cannot be installed alongside the real Pam's Crops/Trees mods**

## TEMPORARY MOD — HARD DELETE POLICY

**This mod is a stopgap.** It exists only because Pam's Crops and Trees are not on Modrinth for 1.20.1.

This mod will be **immediately and permanently deleted** when either:
1. Pam's HarvestCraft 2 Crops and/or Trees become available on Modrinth for 1.20.1 Forge
2. Pam (MatrexsVigil) requests its removal

No migration path. No deprecation period. Hard delete.

## Open Questions

(None currently)
