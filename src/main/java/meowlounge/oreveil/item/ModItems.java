package meowlounge.oreveil.item;

import meowlounge.oreveil.Oreveil;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item RAW_FROSTIUM = registerItem("raw_frostium", Item::new);
    public static final Item FROSTIUM_INGOT = registerItem("frostium_ingot", Item::new);

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Oreveil.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Oreveil.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Oreveil.LOGGER.info("Registering Mod Items for " + Oreveil.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(FROSTIUM_INGOT);
            entries.add(RAW_FROSTIUM);
        });
    }
}
