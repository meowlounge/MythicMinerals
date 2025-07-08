package dev.meowlounge.oreveil;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item RAW_FROSTIUM = registerItem("raw_frostium", Item::new);
    public static final Item FROSTIUM = registerItem("frostium", Item::new);

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Oreveil.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Oreveil.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Oreveil.LOGGER.info("⛏️ [OREVEIL]: Registering Items");
    }
}
