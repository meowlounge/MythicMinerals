package dev.meowlounge.mythicminerals.item;

import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class Frostium {
    public static final ToolMaterial FROSTIUM_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 2.0F, 14, ItemTags.IRON_TOOL_MATERIALS
    );

    public static final Item FROSTIUM_SWORD = registerItem("frostium_sword",
            settings -> new Item(settings.sword(Frostium.FROSTIUM_TOOL_MATERIAL,4,-2.4F)));
    public static final Item FROSTIUM_SHOVEL = registerItem("frostium_shovel",
            settings -> new ShovelItem(Frostium.FROSTIUM_TOOL_MATERIAL,-1,-3, settings));
    public static final Item FROSTIUM_PICKAXE = registerItem("frostium_pickaxe",
            settings -> new Item(settings.sword(Frostium.FROSTIUM_TOOL_MATERIAL,-1,-3)));
    public static final Item FROSTIUM_AXE = registerItem("frostium_axe",
            settings -> new AxeItem(Frostium.FROSTIUM_TOOL_MATERIAL,5,-3.1F, settings));
    public static final Item FROSTIUM_HOE = registerItem("frostium_hoe",
            settings -> new HoeItem(Frostium.FROSTIUM_TOOL_MATERIAL,-1,-3, settings));
    public static final Item FROSTIUM_HELMET = registerItem("frostium_helmet",
            settings -> new Item(settings.armor(Armor.FROSTIUM_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item FROSTIUM_CHESTPLATE = registerItem("frostium_chestplate",
            settings -> new Item(settings.armor(Armor.FROSTIUM_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item FROSTIUM_LEGGINGS = registerItem("frostium_leggings",
            settings -> new Item(settings.armor(Armor.FROSTIUM_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item FROSTIUM_BOOTS = registerItem("frostium_boots",
            settings -> new Item(settings.armor(Armor.FROSTIUM_ARMOR_MATERIAL, EquipmentType.BOOTS)));



    public static final Item RAW_FROSTIUM = registerItem("raw_frostium", Item::new);
    public static final Item FROSTIUM = registerItem("frostium", Item::new);

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(MythicMinerals.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MythicMinerals.MOD_ID, name)))));
    }

    public static void registerModItems() {
        MythicMinerals.LOGGER.info("⛏️ [OREVEIL]: Registering Items");
    }
}
