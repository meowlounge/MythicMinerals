package dev.meowlounge.mythicminerals.item;

import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.providers.TagsProvider;
import dev.meowlounge.mythicminerals.logic.FrostiumLogic;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.BlockTags;

import static dev.meowlounge.mythicminerals.providers.RegisterProvider.registerItem;

public class FrostiumItems {
    public static final ToolMaterial FROSTIUM_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 2.0F, 14, TagsProvider.Items.FROSTIUM_REPAIR
    );

    public static final Item RAW_FROSTIUM = registerItem("raw_frostium", Item::new);
    public static final Item FROSTIUM = registerItem("frostium", Item::new);

    public static final Item FROSTIUM_SWORD = registerItem("frostium_sword",
            settings -> new Item(settings.sword(FrostiumItems.FROSTIUM_TOOL_MATERIAL, 4, -2.4F)));

    public static final Item FROSTIUM_PICKAXE = registerItem("frostium_pickaxe",
            settings -> new Item(settings.pickaxe(FrostiumItems.FROSTIUM_TOOL_MATERIAL, -1, -3)));

    public static final Item FROSTIUM_AXE = registerItem("frostium_axe",
            settings -> new AxeItem(FrostiumItems.FROSTIUM_TOOL_MATERIAL, 5, -3.1F, settings));

    public static final Item FROSTIUM_SHOVEL = registerItem("frostium_shovel",
            settings -> new ShovelItem(FrostiumItems.FROSTIUM_TOOL_MATERIAL, -1, -3, settings));

    public static final Item FROSTIUM_HOE = registerItem("frostium_hoe",
            settings -> new HoeItem(FrostiumItems.FROSTIUM_TOOL_MATERIAL, -1, -3, settings));

    //* ---------------------- //

    public static final Item FROSTIUM_HELMET = registerItem("frostium_helmet",
            settings -> new FrostiumLogic(settings.armor(Armor.FROSTIUM_ARMOR_MATERIAL, EquipmentType.HELMET)));

    public static final Item FROSTIUM_CHESTPLATE = registerItem("frostium_chestplate",
            settings -> new Item(settings.armor(Armor.FROSTIUM_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));

    public static final Item FROSTIUM_LEGGINGS = registerItem("frostium_leggings",
            settings -> new Item(settings.armor(Armor.FROSTIUM_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));

    public static final Item FROSTIUM_BOOTS = registerItem("frostium_boots",
            settings -> new Item(settings.armor(Armor.FROSTIUM_ARMOR_MATERIAL, EquipmentType.BOOTS)));

    //* ---------------------- //

    public static void registerFrostiumItems() {
        MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Frostium Items");
    }
}
