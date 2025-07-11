package dev.meowlounge.mythicminerals.item;

import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import static dev.meowlounge.mythicminerals.item.RegisterItem.registerItem;

public class StellariumItems {
	public static final ToolMaterial STELLARIUM_TOOL_MATERIAL = new ToolMaterial(
			BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1700, 25.0F, 3.0F, 15, ItemTags.DIAMOND_TOOL_MATERIALS
	);

	public static final Item RAW_STELLARIUM = registerItem("raw_stellarium", Item::new);
	public static final Item STELLARIUM = registerItem("stellarium", Item::new);

	public static final Item STELLARIUM_SWORD = registerItem("stellarium_sword",
			settings -> new Item(settings.sword(StellariumItems.STELLARIUM_TOOL_MATERIAL, 5, -2.2F)));

	public static final Item STELLARIUM_SHOVEL = registerItem("stellarium_shovel",
			settings -> new ShovelItem(StellariumItems.STELLARIUM_TOOL_MATERIAL, -0.5F, -3, settings));

	public static final Item STELLARIUM_PICKAXE = registerItem("stellarium_pickaxe",
			settings -> new Item(settings.pickaxe(StellariumItems.STELLARIUM_TOOL_MATERIAL, -0.5F, -3)));

	public static final Item STELLARIUM_AXE = registerItem("stellarium_axe",
			settings -> new AxeItem(StellariumItems.STELLARIUM_TOOL_MATERIAL, 7, -2.8F, settings));

	public static final Item STELLARIUM_HOE = registerItem("stellarium_hoe",
			settings -> new HoeItem(StellariumItems.STELLARIUM_TOOL_MATERIAL, -0.5F, -3, settings));


	// ---------------------- //

	public static final Item STELLARIUM_HELMET = registerItem("stellarium_helmet",
			settings -> new Item(settings.armor(Armor.STELLARIUM_ARMOR_MATERIAL, EquipmentType.HELMET)));

	public static final Item STELLARIUM_CHESTPLATE = registerItem("stellarium_chestplate",
			settings -> new Item(settings.armor(Armor.STELLARIUM_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));

	public static final Item STELLARIUM_LEGGINGS = registerItem("stellarium_leggings",
			settings -> new Item(settings.armor(Armor.STELLARIUM_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));

	public static final Item STELLARIUM_BOOTS = registerItem("stellarium_boots",
			settings -> new Item(settings.armor(Armor.STELLARIUM_ARMOR_MATERIAL, EquipmentType.BOOTS)));

	// ---------------------- //

	public static void registerStellariumItems() {
		MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Stellarium Items");
	}
}