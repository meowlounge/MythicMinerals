package dev.meowlounge.mythicminerals.item;

import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

/**
 * Utility class for item registration in the Mythic Minerals mod.
 */
public class RegisterItem {

	/**
	 * Registers a new {@link Item} with the given name and configuration function.
	 *
	 * <p>This utility method simplifies item registration by applying the mod's {@link MythicMinerals#MOD_ID}
	 * to both the registry ID and the {@link RegistryKey} of the item.</p>
	 *
	 * @param name     The string ID of the item (without namespace).
	 * @param function A function that accepts {@link Item.Settings} and returns a configured {@link Item}.
	 * @return The registered {@link Item} instance.
	 */
	public static Item registerItem(String name, Function<Item.Settings, Item> function) {
		return Registry.register(Registries.ITEM,
				Identifier.of(MythicMinerals.MOD_ID, name),
				function.apply(new Item.Settings().registryKey(
						RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MythicMinerals.MOD_ID, name)))
				)
		);
	}
	public static RegistryKey<Item> createItemKey(String name) {
		return RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(MythicMinerals.MOD_ID, name));
	}
}
