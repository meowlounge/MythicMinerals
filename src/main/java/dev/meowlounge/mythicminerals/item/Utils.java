package dev.meowlounge.mythicminerals.item;

import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class Utils {
    public static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(MythicMinerals.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MythicMinerals.MOD_ID, name)))));
    }
    public static RegistryKey<Item> createItemKey(String name) {
        return RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(MythicMinerals.MOD_ID, name));
    }
}
