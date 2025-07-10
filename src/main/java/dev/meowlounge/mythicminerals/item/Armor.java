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

/**
 * Holds custom {@link ArmorMaterial} definitions and their registry keys
 * for the Mythic Minerals mod.
 */
public class Armor {

    /**
     * The registry key for all equipment assets (armor model data).
     */
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY =
            RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));

    /**
     * Registry key for Frostium's {@link EquipmentAsset}.
     */
    public static final RegistryKey<EquipmentAsset> FROSTIUM_KEY =
            RegistryKey.of(REGISTRY_KEY, Identifier.of(MythicMinerals.MOD_ID, "frostium"));

    /**
     * Registry key for Stellarium's {@link EquipmentAsset}.
     */
    public static final RegistryKey<EquipmentAsset> STELLARIUM_KEY =
            RegistryKey.of(REGISTRY_KEY, Identifier.of(MythicMinerals.MOD_ID, "stellarium"));

    /**
     * The Frostium armor material.
     * <ul>
     *     <li>Durability multiplier: 20</li>
     *     <li>Protection: [Boots: 2, Chestplate: 5, Helmet: 3, Leggings: 5, Body: 5]</li>
     *     <li>Equip sound: Iron armor</li>
     *     <li>Repair ingredient: {@link TagsProvider.Items#FROSTIUM_REPAIR}</li>
     * </ul>
     */
    public static final ArmorMaterial FROSTIUM_ARMOR_MATERIAL = new ArmorMaterial(
            20,
            Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 2);
                map.put(EquipmentType.CHESTPLATE, 5);
                map.put(EquipmentType.HELMET, 3);
                map.put(EquipmentType.LEGGINGS, 5);
                map.put(EquipmentType.BODY, 5);
            }),
            20,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0,
            0,
            TagsProvider.Items.FROSTIUM_REPAIR,
            FROSTIUM_KEY
    );

    /**
     * The Stellarium armor material.
     * <ul>
     *     <li>Durability multiplier: 40</li>
     *     <li>Protection: [Boots: 3, Chestplate: 6, Helmet: 4, Leggings: 6, Body: 7]</li>
     *     <li>Equip sound: Iron armor</li>
     *     <li>Repair ingredient: {@link TagsProvider.Items#STELLARIUM_REPAIR}</li>
     * </ul>
     */
    public static final ArmorMaterial STELLARIUM_ARMOR_MATERIAL = new ArmorMaterial(
            40,
            Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 3);
                map.put(EquipmentType.CHESTPLATE, 6);
                map.put(EquipmentType.HELMET, 4);
                map.put(EquipmentType.LEGGINGS, 6);
                map.put(EquipmentType.BODY, 7);
            }),
            20,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0,
            0,
            TagsProvider.Items.STELLARIUM_REPAIR,
            STELLARIUM_KEY
    );
}
