package dev.meowlounge.mythicminerals.item;

import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.providers.TagsProvider;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.BlockTags;

import static dev.meowlounge.mythicminerals.providers.RegisterProvider.registerItem;

public class PyrostoneItems {
	public static final ToolMaterial PYROSTONE_TOOL_MATERIAL = new ToolMaterial(
			BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1700, 15.0F, 3.0F, 15, TagsProvider.Items.PYROSTONE_REPAIR
	);

	public static final Item RAW_PYROSTONE = registerItem("raw_pyrostone", Item::new);
	public static final Item PYROSTONE = registerItem("pyrostone", Item::new);

	public static final Item PYROSTONE_SWORD = registerItem("pyrostone_sword",
			settings -> new Item(settings.sword(PYROSTONE_TOOL_MATERIAL, 5, -2.2F)
					.fireproof()));

	public static final Item PYROSTONE_SHOVEL = registerItem("pyrostone_shovel",
			settings -> new ShovelItem(PYROSTONE_TOOL_MATERIAL, -0.5F, -3,
					settings.fireproof()));

	public static final Item PYROSTONE_PICKAXE = registerItem("pyrostone_pickaxe",
			settings -> new Item(settings.pickaxe(PYROSTONE_TOOL_MATERIAL, -0.5F, -3)
					.fireproof()));

	public static final Item PYROSTONE_AXE = registerItem("pyrostone_axe",
			settings -> new AxeItem(PYROSTONE_TOOL_MATERIAL, 7, -2.8F,
					settings.fireproof()));

	public static final Item PYROSTONE_HOE = registerItem("pyrostone_hoe",
			settings -> new HoeItem(PYROSTONE_TOOL_MATERIAL, -0.5F, -3,
					settings.fireproof()));

	//* ---------------------- //

	public static final Item PYROSTONE_HELMET = registerItem("pyrostone_helmet",
			settings -> new Item(settings.armor(Armor.PYROSTONE_ARMOR_MATERIAL, EquipmentType.HELMET)
					.fireproof()));

	public static final Item PYROSTONE_CHESTPLATE = registerItem("pyrostone_chestplate",
			settings -> new Item(settings.armor(Armor.PYROSTONE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)
					.fireproof()));

	public static final Item PYROSTONE_LEGGINGS = registerItem("pyrostone_leggings",
			settings -> new Item(settings.armor(Armor.PYROSTONE_ARMOR_MATERIAL, EquipmentType.LEGGINGS)
					.fireproof()));

	public static final Item PYROSTONE_BOOTS = registerItem("pyrostone_boots",
			settings -> new Item(settings.armor(Armor.PYROSTONE_ARMOR_MATERIAL, EquipmentType.BOOTS)
					.fireproof()));

	//* ---------------------- //

	public static void registerPyrostoneItems() {
		MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Pyrostone Items");
	}
}
