package dev.meowlounge.mythicminerals.item;

import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.logic.OreLocatorLogic;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static dev.meowlounge.mythicminerals.providers.RegisterProvider.registerItem;

public class DebugItems {
	public static final Item ORE_LOCATOR = registerItem("ore_locator",
			settings -> new OreLocatorLogic(settings.component(DataComponentTypes.RARITY, Rarity.RARE)));

	public static void registerDEBUGItems() {
		MythicMinerals.LOGGER.info("❌❌❌ [MythicMinerals]: Registering DEBUG Items");
	}
}
