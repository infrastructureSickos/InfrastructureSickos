# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

InfrastructureSickos is a Minecraft 1.20.1 Forge modpack and server project. The name is ironic — the pack features a very long linear tech tree.

## Key Details

- **Minecraft**: 1.20.1, Forge
- **All 3rd-party mods must be on Modrinth**
- **Tech progression**: Create → Immersive Engineering → Botania
- **Custom mods will be needed** — specs live in `Design/docs/custom-mods/`
- **Recipe tweaking tool**: KubeJS

## Repository Structure

- `Design/docs/` — Modpack documentation (overview, mod list, progression tree, dimension design)
- `Design/docs/custom-mods/` — Specs for custom mods to be built
- `Design/3rd-party-mods/` — Third-party mod configs and tweaks
- `Repos/InfrastructureSickos/` — Custom Forge mod source code (Gradle multi-project)
- `Repos/kubejs/` — KubeJS scripts
