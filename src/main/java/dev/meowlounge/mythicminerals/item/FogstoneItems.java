package dev.meowlounge.mythicminerals.item;

import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.providers.TagsProvider;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.BlockTags;

import static dev.meowlounge.mythicminerals.providers.RegisterProvider.registerItem;

public class FogstoneItems {
	public static final ToolMaterial FOGSTONE_TOOL_MATERIAL = new ToolMaterial(
			BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1700, 15.0F, 3.0F, 15, TagsProvider.Items.FOGSTONE_REPAIR
	);

	public static final Item RAW_FOGSTONE = registerItem("raw_fogstone", Item::new);
	public static final Item FOGSTONE = registerItem("fogstone", Item::new);

	public static final Item FOGSTONE_SWORD = registerItem("fogstone_sword",
			settings -> new Item(settings.sword(FOGSTONE_TOOL_MATERIAL, 5, -2.2F)));

	public static final Item FOGSTONE_SHOVEL = registerItem("fogstone_shovel",
			settings -> new ShovelItem(FOGSTONE_TOOL_MATERIAL, -0.5F, -3, settings));

	public static final Item FOGSTONE_PICKAXE = registerItem("fogstone_pickaxe",
			settings -> new Item(settings.pickaxe(FOGSTONE_TOOL_MATERIAL, -0.5F, -3)));

	public static final Item FOGSTONE_AXE = registerItem("fogstone_axe",
			settings -> new AxeItem(FOGSTONE_TOOL_MATERIAL, 7, -2.8F, settings));

	public static final Item FOGSTONE_HOE = registerItem("fogstone_hoe",
			settings -> new HoeItem(FOGSTONE_TOOL_MATERIAL, -0.5F, -3, settings));

	//* ---------------------- //

	public static final Item FOGSTONE_HELMET = registerItem("fogstone_helmet",
			settings -> new Item(settings.armor(Armor.FOGSTONE_ARMOR_MATERIAL, EquipmentType.HELMET)));

	public static final Item FOGSTONE_CHESTPLATE = registerItem("fogstone_chestplate",
			settings -> new Item(settings.armor(Armor.FOGSTONE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));

	public static final Item FOGSTONE_LEGGINGS = registerItem("fogstone_leggings",
			settings -> new Item(settings.armor(Armor.FOGSTONE_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));

	public static final Item FOGSTONE_BOOTS = registerItem("fogstone_boots",
			settings -> new Item(settings.armor(Armor.FOGSTONE_ARMOR_MATERIAL, EquipmentType.BOOTS)));

	//* ---------------------- //

	public static void registerFogstoneItems() {
		MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Fogstone Items");
	}
}
