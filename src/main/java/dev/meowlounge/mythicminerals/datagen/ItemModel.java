package dev.meowlounge.mythicminerals.datagen;

import dev.meowlounge.mythicminerals.block.FrostiumBlocks;
import dev.meowlounge.mythicminerals.block.PhantomiumBlocks;
import dev.meowlounge.mythicminerals.item.Armor;
import dev.meowlounge.mythicminerals.item.FrostiumItems;
import dev.meowlounge.mythicminerals.item.PhantomiumItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;


public class ItemModel extends FabricModelProvider {
	public ItemModel(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		BlockStateModelGenerator.BlockTexturePool FrostiumBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(FrostiumBlocks.FROSTIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(FrostiumBlocks.DEEPSLATE_FROSTIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(FrostiumBlocks.FROSTIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(FrostiumBlocks.RAW_FROSTIUM_BLOCK);

		BlockStateModelGenerator.BlockTexturePool PhantomiumBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(PhantomiumBlocks.PHANTOMIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(PhantomiumBlocks.PHANTOMIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(PhantomiumBlocks.RAW_PHANTOMIUM_BLOCK);
	}

	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(FrostiumItems.RAW_FROSTIUM, Models.GENERATED);
		itemModelGenerator.register(FrostiumItems.FROSTIUM, Models.GENERATED);
		itemModelGenerator.register(FrostiumItems.FROSTIUM_SWORD, Models.HANDHELD);
		itemModelGenerator.register(FrostiumItems.FROSTIUM_SHOVEL, Models.HANDHELD);
		itemModelGenerator.register(FrostiumItems.FROSTIUM_AXE, Models.HANDHELD);
		itemModelGenerator.register(FrostiumItems.FROSTIUM_PICKAXE, Models.HANDHELD);
		itemModelGenerator.register(FrostiumItems.FROSTIUM_HOE, Models.HANDHELD);
		itemModelGenerator.registerArmor(FrostiumItems.FROSTIUM_CHESTPLATE, Armor.FROSTIUM_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
		itemModelGenerator.registerArmor(FrostiumItems.FROSTIUM_LEGGINGS, Armor.FROSTIUM_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
		itemModelGenerator.registerArmor(FrostiumItems.FROSTIUM_BOOTS, Armor.FROSTIUM_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
		itemModelGenerator.registerArmor(FrostiumItems.FROSTIUM_HELMET, Armor.FROSTIUM_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);

		// ---------------------- //
		
		itemModelGenerator.register(PhantomiumItems.RAW_PHANTOMIUM, Models.GENERATED);
		itemModelGenerator.register(PhantomiumItems.PHANTOMIUM, Models.GENERATED);
		itemModelGenerator.register(PhantomiumItems.PHANTOMIUM_SWORD, Models.HANDHELD);
		itemModelGenerator.register(PhantomiumItems.PHANTOMIUM_SHOVEL, Models.HANDHELD);
		itemModelGenerator.register(PhantomiumItems.PHANTOMIUM_AXE, Models.HANDHELD);
		itemModelGenerator.register(PhantomiumItems.PHANTOMIUM_PICKAXE, Models.HANDHELD);
		itemModelGenerator.register(PhantomiumItems.PHANTOMIUM_HOE, Models.HANDHELD);
		itemModelGenerator.registerArmor(PhantomiumItems.PHANTOMIUM_CHESTPLATE, Armor.PHANTOMIUM_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
		itemModelGenerator.registerArmor(PhantomiumItems.PHANTOMIUM_LEGGINGS, Armor.PHANTOMIUM_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
		itemModelGenerator.registerArmor(PhantomiumItems.PHANTOMIUM_BOOTS, Armor.PHANTOMIUM_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
		itemModelGenerator.registerArmor(PhantomiumItems.PHANTOMIUM_HELMET, Armor.PHANTOMIUM_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
	}
}
