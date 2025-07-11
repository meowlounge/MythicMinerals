package dev.meowlounge.mythicminerals.item;

import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.TagsProvider;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class Armor {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> FROSTIUM_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(MythicMinerals.MOD_ID, "frostium"));
    public static final ArmorMaterial FROSTIUM_ARMOR_MATERIAL = new ArmorMaterial(20, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 2);
        map.put(EquipmentType.CHESTPLATE, 5);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.LEGGINGS, 5);
        map.put(EquipmentType.BODY, 5);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2, 1, TagsProvider.Items.FROSTIUM_REPAIR, FROSTIUM_KEY);
    public static final RegistryKey<EquipmentAsset> VOIDSTONE_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(MythicMinerals.MOD_ID, "voidstone"));
    public static final ArmorMaterial VOIDSTONE_ARMOR_MATERIAL = new ArmorMaterial(40, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 3);
        map.put(EquipmentType.CHESTPLATE, 6);
        map.put(EquipmentType.HELMET, 4);
        map.put(EquipmentType.LEGGINGS, 6);
        map.put(EquipmentType.BODY, 7);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4, 2, TagsProvider.Items.VOIDSTONE_REPAIR, VOIDSTONE_KEY);
    public static final RegistryKey<EquipmentAsset> STELLARIUM_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(MythicMinerals.MOD_ID, "stellarium"));
    public static final ArmorMaterial STELLARIUM_ARMOR_MATERIAL = new ArmorMaterial(70, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 11);
        map.put(EquipmentType.CHESTPLATE, 16);
        map.put(EquipmentType.HELMET, 12);
        map.put(EquipmentType.LEGGINGS, 13);
        map.put(EquipmentType.BODY, 16);
    }), 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 8, 4, TagsProvider.Items.STELLARIUM_REPAIR, STELLARIUM_KEY);
}
