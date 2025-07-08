package meowlounge.oreveil.datagen;

import meowlounge.oreveil.ModItems;
import meowlounge.oreveil.block.ModBlocks;
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
		BlockStateModelGenerator.BlockTexturePool FrostiumBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FROSTIUM_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_FROSTIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FROSTIUM_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_FROSTIUM_BLOCK); }


	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(ModItems.RAW_FROSTIUM, Models.GENERATED);
		itemModelGenerator.register(ModItems.FROSTIUM, Models.GENERATED);
	}
}