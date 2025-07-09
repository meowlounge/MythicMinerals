package dev.meowlounge.mythicminerals.item;

import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class FrostiumItems {
	public static final Item RAW_FROSTIUM = registerItem("raw_frostium", Item::new);
	public static final Item FROSTIUM = registerItem("frostium", Item::new);

	private static Item registerItem(String name, Function<Item.Settings, Item> function) {
		return Registry.register(Registries.ITEM, Identifier.of(MythicMinerals.MOD_ID, name),
				function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MythicMinerals.MOD_ID, name)))));
	}

	public static void registerItems() {
		MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Frostium Items");
	}
}
