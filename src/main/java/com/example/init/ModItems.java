package com.example.init;

import java.util.function.Function;

import com.example.MoreBags;
import com.example.items.AlchemicalBagItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final AlchemicalBagItem ALCHEMICAL_BAG = register("alchemical_bag", AlchemicalBagItem::new, new AlchemicalBagItem.Properties());

    /** This method will create an item with the provided identifier and register it with the game's item registry */
    public static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreBags.MOD_ID, name));
        GenericItem item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }

    /** Initialize items */
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register((itemGroup) -> itemGroup.accept(ModItems.ALCHEMICAL_BAG));
    }
}