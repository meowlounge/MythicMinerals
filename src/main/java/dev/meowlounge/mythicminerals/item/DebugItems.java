package dev.meowlounge.mythicminerals.item;

import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.logic.locator.FogstoneLocator;
import dev.meowlounge.mythicminerals.logic.locator.FrostiumLocator;
import dev.meowlounge.mythicminerals.logic.locator.StellariumLocator;
import dev.meowlounge.mythicminerals.logic.locator.VoidstoneLocator;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static dev.meowlounge.mythicminerals.providers.RegisterProvider.registerItem;

public class DebugItems {
	public static final Item FROSTIUM_ORE_LOCATOR = registerItem("frostium_ore_locator",
			settings -> new FrostiumLocator(settings.component(DataComponentTypes.RARITY, Rarity.EPIC).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

	public static final Item VOIDSTONE_ORE_LOCATOR = registerItem("voidstone_ore_locator",
			settings -> new VoidstoneLocator(settings.component(DataComponentTypes.RARITY, Rarity.EPIC).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

	public static final Item STELLARIUM_ORE_LOCATOR = registerItem("stellarium_ore_locator",
			settings -> new StellariumLocator(settings.component(DataComponentTypes.RARITY, Rarity.EPIC).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

	public static final Item FOGSTONE_ORE_LOCATOR = registerItem("fogstone_ore_locator",
			settings -> new FogstoneLocator(settings.component(DataComponentTypes.RARITY, Rarity.EPIC).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));

	public static void registerDEBUGItems() {
		MythicMinerals.LOGGER.info("❌❌❌ [MythicMinerals]: Registering DEBUG Items");
	}
}
