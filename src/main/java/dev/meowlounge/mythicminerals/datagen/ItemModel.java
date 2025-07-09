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
		blockStateModelGenerator.registerSimpleCubeAll(FrostiumBlocks.RAW_FROSTIUM_BLOCK);
	}


	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(FrostiumItems.RAW_FROSTIUM, Models.GENERATED);
		itemModelGenerator.register(FrostiumItems.FROSTIUM, Models.GENERATED);
	}
}