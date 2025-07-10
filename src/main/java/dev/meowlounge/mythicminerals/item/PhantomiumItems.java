package dev.meowlounge.mythicminerals.item;

import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import static dev.meowlounge.mythicminerals.item.Utils.registerItem;

public class PhantomiumItems {
    public static final ToolMaterial PHANTOMIUM_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1700, 10.0F, 3.0F, 15, ItemTags.DIAMOND_TOOL_MATERIALS
    );

    public static final Item RAW_PHANTOMIUM = registerItem("raw_phantomium", Item::new);
    public static final Item PHANTOMIUM = registerItem("phantomium", Item::new);

    public static final Item PHANTOMIUM_SWORD = registerItem("phantomium_sword",
            settings -> new Item(settings.sword(PhantomiumItems.PHANTOMIUM_TOOL_MATERIAL,5,-2.2F)));
    public static final Item PHANTOMIUM_SHOVEL = registerItem("phantomium_shovel",
            settings -> new ShovelItem(PhantomiumItems.PHANTOMIUM_TOOL_MATERIAL,-0.5F,-3, settings));
    public static final Item PHANTOMIUM_PICKAXE = registerItem("phantomium_pickaxe",
            settings -> new Item(settings.sword(PhantomiumItems.PHANTOMIUM_TOOL_MATERIAL,-0.5F,-3)));
    public static final Item PHANTOMIUM_AXE = registerItem("phantomium_axe",
            settings -> new AxeItem(PhantomiumItems.PHANTOMIUM_TOOL_MATERIAL,7,-2.8F, settings));
    public static final Item PHANTOMIUM_HOE = registerItem("phantomium_hoe",
            settings -> new HoeItem(PhantomiumItems.PHANTOMIUM_TOOL_MATERIAL,-0.5F,-3, settings));
    public static final Item PHANTOMIUM_HELMET = registerItem("phantomium_helmet",
            settings -> new Item(settings.armor(Armor.PHANTOMIUM_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item PHANTOMIUM_CHESTPLATE = registerItem("phantomium_chestplate",
            settings -> new Item(settings.armor(Armor.PHANTOMIUM_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item PHANTOMIUM_LEGGINGS = registerItem("phantomium_leggings",
            settings -> new Item(settings.armor(Armor.PHANTOMIUM_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item PHANTOMIUM_BOOTS = registerItem("phantomium_boots",
            settings -> new Item(settings.armor(Armor.PHANTOMIUM_ARMOR_MATERIAL, EquipmentType.BOOTS)));

    public static void registerPahntomiumItems() {
        MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Phantomium Items");
    }
}
