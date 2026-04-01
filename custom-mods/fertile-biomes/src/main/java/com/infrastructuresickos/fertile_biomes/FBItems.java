package com.infrastructuresickos.fertile_biomes;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FBItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FertileBiomes.MOD_ID);

    public static final RegistryObject<Item> FERTILE_GROUND = ITEMS.register("fertile_ground",
            () -> new BlockItem(FBBlocks.FERTILE_GROUND.get(), new Item.Properties()));
}
