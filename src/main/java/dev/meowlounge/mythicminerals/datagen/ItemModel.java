package dev.meowlounge.mythicminerals.datagen;

import dev.meowlounge.mythicminerals.block.FrostiumBlocks;
import dev.meowlounge.mythicminerals.item.FrostiumItems;
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
		blockStateModelGenerator.registerSimpleCubeAll(FrostiumBlocks.RAW_FROSTIUM_BLOCK); }


	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(Frostium.RAW_FROSTIUM, Models.GENERATED);
		itemModelGenerator.register(Frostium.FROSTIUM, Models.GENERATED);
		itemModelGenerator.register(Frostium.FROSTIUM_SWORD, Models.HANDHELD);
		itemModelGenerator.register(Frostium.FROSTIUM_SHOVEL, Models.HANDHELD);
		itemModelGenerator.register(Frostium.FROSTIUM_AXE, Models.HANDHELD);
		itemModelGenerator.register(Frostium.FROSTIUM_PICKAXE, Models.HANDHELD);
		itemModelGenerator.register(Frostium.FROSTIUM_HOE, Models.HANDHELD);
		itemModelGenerator.registerArmor(Frostium.FROSTIUM_CHESTPLATE, Armor.FROSTIUM_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
		itemModelGenerator.registerArmor(Frostium.FROSTIUM_LEGGINGS, Armor.FROSTIUM_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
		itemModelGenerator.registerArmor(Frostium.FROSTIUM_BOOTS, Armor.FROSTIUM_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
		itemModelGenerator.registerArmor(Frostium.FROSTIUM_HELMET, Armor.FROSTIUM_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);

	}
}