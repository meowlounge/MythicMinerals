package dev.meowlounge.mythicminerals.item;

import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.providers.TagsProvider;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Rarity;

import static dev.meowlounge.mythicminerals.providers.RegisterProvider.registerItem;

public class VoidstoneItems {
	public static final ToolMaterial VOIDSTONE_TOOL_MATERIAL = new ToolMaterial(
			BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1700, 15.0F, 3.0F, 15, TagsProvider.Items.VOIDSTONE_REPAIR
	);

	public static final Item RAW_VOIDSTONE = registerItem("raw_voidstone",
			settings -> new Item(settings.component(DataComponentTypes.RARITY, Rarity.RARE)));

	public static final Item VOIDSTONE = registerItem("voidstone",
			settings -> new Item(settings.component(DataComponentTypes.RARITY, Rarity.RARE)));

	public static final Item VOIDSTONE_SWORD = registerItem("voidstone_sword",
			settings -> new Item(settings.sword(VOIDSTONE_TOOL_MATERIAL, 5, -2.2F)
					.component(DataComponentTypes.RARITY, Rarity.RARE)));

	public static final Item VOIDSTONE_SHOVEL = registerItem("voidstone_shovel",
			settings -> new ShovelItem(VOIDSTONE_TOOL_MATERIAL, -0.5F, -3,
					settings.component(DataComponentTypes.RARITY, Rarity.RARE)));

	public static final Item VOIDSTONE_PICKAXE = registerItem("voidstone_pickaxe",
			settings -> new Item(settings.pickaxe(VOIDSTONE_TOOL_MATERIAL, -0.5F, -3)
					.component(DataComponentTypes.RARITY, Rarity.RARE)));

	public static final Item VOIDSTONE_AXE = registerItem("voidstone_axe",
			settings -> new AxeItem(VOIDSTONE_TOOL_MATERIAL, 7, -2.8F,
					settings.component(DataComponentTypes.RARITY, Rarity.RARE)));

	public static final Item VOIDSTONE_HOE = registerItem("voidstone_hoe",
			settings -> new HoeItem(VOIDSTONE_TOOL_MATERIAL, -0.5F, -3,
					settings.component(DataComponentTypes.RARITY, Rarity.RARE)));

	//* ---------------------- //

	public static final Item VOIDSTONE_HELMET = registerItem("voidstone_helmet",
			settings -> new Item(settings.armor(Armor.VOIDSTONE_ARMOR_MATERIAL, EquipmentType.HELMET)
					.component(DataComponentTypes.RARITY, Rarity.RARE)));

	public static final Item VOIDSTONE_CHESTPLATE = registerItem("voidstone_chestplate",
			settings -> new Item(settings.armor(Armor.VOIDSTONE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)
					.component(DataComponentTypes.RARITY, Rarity.RARE)));

	public static final Item VOIDSTONE_LEGGINGS = registerItem("voidstone_leggings",
			settings -> new Item(settings.armor(Armor.VOIDSTONE_ARMOR_MATERIAL, EquipmentType.LEGGINGS)
					.component(DataComponentTypes.RARITY, Rarity.RARE)));

	public static final Item VOIDSTONE_BOOTS = registerItem("voidstone_boots",
			settings -> new Item(settings.armor(Armor.VOIDSTONE_ARMOR_MATERIAL, EquipmentType.BOOTS)
					.component(DataComponentTypes.RARITY, Rarity.RARE)));

	//* ---------------------- //

	public static void registerVoidstoneItems() {
		MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Voidstone Items");
	}
}
