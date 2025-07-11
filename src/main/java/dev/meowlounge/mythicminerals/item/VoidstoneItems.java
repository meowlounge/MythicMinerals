package dev.meowlounge.mythicminerals.item;

import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.TagsProvider;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.BlockTags;

import static dev.meowlounge.mythicminerals.item.ItemUtils.*;

public class VoidstoneItems {
    public static final ToolMaterial VOIDSTONE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1700, 15.0F, 3.0F, 15, TagsProvider.Items.VOIDSTONE_REPAIR
    );

    public static final Item RAW_VOIDSTONE = registerItem("raw_voidstone", Item::new);
    public static final Item VOIDSTONE = registerItem("voidstone", Item::new);

    public static final Item VOIDSTONE_SWORD = registerItem("voidstone_sword",
            settings -> new Item(settings.sword(VoidstoneItems.VOIDSTONE_TOOL_MATERIAL, 5, -2.2F)));

    public static final Item VOIDSTONE_SHOVEL = registerItem("voidstone_shovel",
            settings -> new ShovelItem(VoidstoneItems.VOIDSTONE_TOOL_MATERIAL, -0.5F, -3, settings));

    public static final Item VOIDSTONE_PICKAXE = registerItem("voidstone_pickaxe",
            settings -> new Item(settings.pickaxe(VoidstoneItems.VOIDSTONE_TOOL_MATERIAL, -0.5F, -3)));

    public static final Item VOIDSTONE_AXE = registerItem("voidstone_axe",
            settings -> new AxeItem(VoidstoneItems.VOIDSTONE_TOOL_MATERIAL, 7, -2.8F, settings));

    public static final Item VOIDSTONE_HOE = registerItem("voidstone_hoe",
            settings -> new HoeItem(VoidstoneItems.VOIDSTONE_TOOL_MATERIAL, -0.5F, -3, settings));

    // ---------------------- //

    public static final Item VOIDSTONE_HELMET = registerItem("voidstone_helmet",
            settings -> new Item(settings.armor(Armor.VOIDSTONE_ARMOR_MATERIAL, EquipmentType.HELMET)));

    public static final Item VOIDSTONE_CHESTPLATE = registerItem("voidstone_chestplate",
            settings -> new Item(settings.armor(Armor.VOIDSTONE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));

    public static final Item VOIDSTONE_LEGGINGS = registerItem("voidstone_leggings",
            settings -> new Item(settings.armor(Armor.VOIDSTONE_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));

    public static final Item VOIDSTONE_BOOTS = registerItem("voidstone_boots",
            settings -> new Item(settings.armor(Armor.VOIDSTONE_ARMOR_MATERIAL, EquipmentType.BOOTS)));

    // ---------------------- //

    public static void registerVoidstoneItems() {
        MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Voidstone Items");
    }
}
