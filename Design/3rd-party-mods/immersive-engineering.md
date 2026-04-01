# Immersive Engineering — Tweaks

## Recipe Removals (via KubeJS)

- **Windmill** — removed (conflicts with Create's windmill bearing)
- **Water Wheel** — removed (conflicts with Create's water wheel)

These are removed to avoid confusion since Create already provides rotational power generation through similar-looking machines.

- **Fluid Pipes** — removed (use Create's fluid pipes)
- **Fluid Pumps** — removed (use Create's mechanical pumps)
- All IE fluid management replaced by Create's fluid handling system

## Recipe Changes (via KubeJS)

### Mechanical Crafting Required
- **Blast Bricks** — moved to Create Mechanical Crafting (same ingredients)
- **Light Engineering Block** — moved to Create Mechanical Crafting (same ingredients)
- **Heavy Engineering Block** — moved to Create Mechanical Crafting (same ingredients)
- **Redstone Engineering Block** — moved to Create Mechanical Crafting (same ingredients)

### Sequenced Assembly Required
- **Iron Mechanical Component** (`component_iron`) — moved to Create Sequenced Assembly
- **Steel Mechanical Component** (`component_steel`) — moved to Create Sequenced Assembly

This creates a two-layer gate: components are a production line challenge (Sequenced Assembly), then blocks are assembled via Mechanical Crafters. Both require mid-game Create infrastructure.
