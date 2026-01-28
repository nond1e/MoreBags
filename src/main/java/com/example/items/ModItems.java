package com.example.items;

import java.util.function.Function;

import com.example.MoreBags;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class ModItems {
    public static final  Item ALCHEMICAL_BAG = register("alchemical_bag", Item::new, new Item.Properties());

    /** This method will create an item with the provided identifier and register it with the game's item registry */
    public static <GenericItem extends Item> GenericItem register(String name, @NotNull Function<Item.Properties, GenericItem> itemFactory, @NotNull Item.Properties settings) {

        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreBags.MOD_ID, name));

        // Create the item instance.
        GenericItem item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;

    }
    /** Initialize items */
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT)
                .register((itemGroup) -> itemGroup.accept(ModItems.ALCHEMICAL_BAG));
    }
}