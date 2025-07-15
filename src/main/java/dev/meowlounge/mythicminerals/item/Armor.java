package dev.meowlounge.mythicminerals.item;

import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.providers.TagsProvider;
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
	static final RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY =
			RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));

	//* ---------------------- //

	public static final RegistryKey<EquipmentAsset> FOGSTONE_KEY =
			RegistryKey.of(REGISTRY_KEY, Identifier.of(MythicMinerals.MOD_ID, "fogstone"));

	public static final ArmorMaterial FOGSTONE_ARMOR_MATERIAL = new ArmorMaterial(
			15,
			Util.make(new EnumMap<>(EquipmentType.class), map -> {
				map.put(EquipmentType.BOOTS, 1);
				map.put(EquipmentType.CHESTPLATE, 3);
				map.put(EquipmentType.HELMET, 2);
				map.put(EquipmentType.LEGGINGS, 2);
				map.put(EquipmentType.BODY, 2);
			}),
			10,
			SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
			0.0f,
			0.0f,
			TagsProvider.Items.FOGSTONE_REPAIR,
			FOGSTONE_KEY
	);


	//* ---------------------- //

	public static final RegistryKey<EquipmentAsset> FROSTIUM_KEY =
			RegistryKey.of(REGISTRY_KEY, Identifier.of(MythicMinerals.MOD_ID, "frostium"));

	public static final ArmorMaterial FROSTIUM_ARMOR_MATERIAL = new ArmorMaterial(
			25,
			Util.make(new EnumMap<>(EquipmentType.class), map -> {
				map.put(EquipmentType.BOOTS, 2);
				map.put(EquipmentType.CHESTPLATE, 5);
				map.put(EquipmentType.HELMET, 3);
				map.put(EquipmentType.LEGGINGS, 4);
				map.put(EquipmentType.BODY, 4);
			}),
			15,
			SoundEvents.ITEM_ARMOR_EQUIP_IRON,
			0.0f,
			0.05f,
			TagsProvider.Items.FROSTIUM_REPAIR,
			FROSTIUM_KEY
	);

	//* ---------------------- //

	public static final RegistryKey<EquipmentAsset> PYROSTONE_KEY =
			RegistryKey.of(REGISTRY_KEY, Identifier.of(MythicMinerals.MOD_ID, "pyrostone"));

	public static final ArmorMaterial PYROSTONE_ARMOR_MATERIAL = new ArmorMaterial(
			20,
			Util.make(new EnumMap<>(EquipmentType.class), map -> {
				map.put(EquipmentType.BOOTS, 1);
				map.put(EquipmentType.CHESTPLATE, 3);
				map.put(EquipmentType.HELMET, 1);
				map.put(EquipmentType.LEGGINGS, 2);
				map.put(EquipmentType.BODY, 2);
			}),
			15,
			SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
			0.0f,
			0.05f,
			TagsProvider.Items.PYROSTONE_REPAIR,
			PYROSTONE_KEY
	);

	//* ---------------------- //

	public static final RegistryKey<EquipmentAsset> VOIDSTONE_KEY =
			RegistryKey.of(REGISTRY_KEY, Identifier.of(MythicMinerals.MOD_ID, "voidstone"));

	public static final ArmorMaterial VOIDSTONE_ARMOR_MATERIAL = new ArmorMaterial(
			37,
			Util.make(new EnumMap<>(EquipmentType.class), map -> {
				map.put(EquipmentType.BOOTS, 3);
				map.put(EquipmentType.CHESTPLATE, 6);
				map.put(EquipmentType.HELMET, 4);
				map.put(EquipmentType.LEGGINGS, 5);
				map.put(EquipmentType.BODY, 5);
			}),
			20,
			SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
			1.0f,
			0.1f,
			TagsProvider.Items.VOIDSTONE_REPAIR,
			VOIDSTONE_KEY
	);

	//* ---------------------- //

	public static final RegistryKey<EquipmentAsset> STELLARIUM_KEY =
			RegistryKey.of(REGISTRY_KEY, Identifier.of(MythicMinerals.MOD_ID, "stellarium"));

	public static final ArmorMaterial STELLARIUM_ARMOR_MATERIAL = new ArmorMaterial(
			60,
			Util.make(new EnumMap<>(EquipmentType.class), map -> {
				map.put(EquipmentType.BOOTS, 4);
				map.put(EquipmentType.CHESTPLATE, 8);
				map.put(EquipmentType.HELMET, 5);
				map.put(EquipmentType.LEGGINGS, 6);
				map.put(EquipmentType.BODY, 6);
			}),
			8,
			SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
			2.0f,
			0.25f,
			TagsProvider.Items.STELLARIUM_REPAIR,
			STELLARIUM_KEY
	);
}
