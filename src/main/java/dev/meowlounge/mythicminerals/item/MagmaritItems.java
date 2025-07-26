package dev.meowlounge.mythicminerals.item;

import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.providers.TagsProvider;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.BlockTags;

import static dev.meowlounge.mythicminerals.providers.RegisterProvider.registerItem;

public class MagmaritItems {
	public static final ToolMaterial MAGMARIT_TOOL_MATERIAL = new ToolMaterial(
			BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1700, 15.0F, 3.0F, 15, TagsProvider.Items.MAGMARIT_REPAIR
	);

	public static final Item RAW_MAGMARIT = registerItem("raw_magmarit", Item::new);
	public static final Item MAGMARIT = registerItem("magmarit", Item::new);

	public static final Item MAGMARIT_SWORD = registerItem("magmarit_sword",
			settings -> new Item(settings.sword(MAGMARIT_TOOL_MATERIAL, 5, -2.2F)
					.fireproof()));

	public static final Item MAGMARIT_SHOVEL = registerItem("magmarit_shovel",
			settings -> new ShovelItem(MAGMARIT_TOOL_MATERIAL, -0.5F, -3,
					settings.fireproof()));

	public static final Item MAGMARIT_PICKAXE = registerItem("magmarit_pickaxe",
			settings -> new Item(settings.pickaxe(MAGMARIT_TOOL_MATERIAL, -0.5F, -3)
					.fireproof()));

	public static final Item MAGMARIT_AXE = registerItem("magmarit_axe",
			settings -> new AxeItem(MAGMARIT_TOOL_MATERIAL, 7, -2.8F,
					settings.fireproof()));

	public static final Item MAGMARIT_HOE = registerItem("magmarit_hoe",
			settings -> new HoeItem(MAGMARIT_TOOL_MATERIAL, -0.5F, -3,
					settings.fireproof()));

	//* ---------------------- //

	public static final Item MAGMARIT_HELMET = registerItem("magmarit_helmet",
			settings -> new Item(settings.armor(Armor.MAGMARIT_ARMOR_MATERIAL, EquipmentType.HELMET)
					.fireproof()));

	public static final Item MAGMARIT_CHESTPLATE = registerItem("magmarit_chestplate",
			settings -> new Item(settings.armor(Armor.MAGMARIT_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)
					.fireproof()));

	public static final Item MAGMARIT_LEGGINGS = registerItem("magmarit_leggings",
			settings -> new Item(settings.armor(Armor.MAGMARIT_ARMOR_MATERIAL, EquipmentType.LEGGINGS)
					.fireproof()));

	public static final Item MAGMARIT_BOOTS = registerItem("magmarit_boots",
			settings -> new Item(settings.armor(Armor.MAGMARIT_ARMOR_MATERIAL, EquipmentType.BOOTS)
					.fireproof()));

	//* ---------------------- //

	public static void registerMagmaritItems() {
		MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Magmarit Items");
	}
}
