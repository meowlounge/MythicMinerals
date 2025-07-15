package dev.meowlounge.mythicminerals.datagen.recipe;

import dev.meowlounge.mythicminerals.block.VoidstoneBlocks;
import dev.meowlounge.mythicminerals.item.VoidstoneItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class VoidstoneRecipes extends FabricRecipeProvider {
	public VoidstoneRecipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter exporter) {
		return new RecipeGenerator(wrapperLookup, exporter) {
			@Override
			public void generate() {
				List<ItemConvertible> VOIDSTONE_SMELTABLES = List.of(
						VoidstoneItems.RAW_VOIDSTONE,
						VoidstoneBlocks.VOIDSTONE_ORE
				);

				offerSmelting(VOIDSTONE_SMELTABLES, RecipeCategory.MISC, VoidstoneItems.VOIDSTONE, 0.25f, 200, "voidstone");
				offerBlasting(VOIDSTONE_SMELTABLES, RecipeCategory.MISC, VoidstoneItems.VOIDSTONE, 0.25f, 100, "voidstone");

				offerReversibleCompactingRecipes(RecipeCategory.MISC, VoidstoneItems.VOIDSTONE, RecipeCategory.BUILDING_BLOCKS, VoidstoneBlocks.VOIDSTONE_BLOCK);

				createShaped(RecipeCategory.BUILDING_BLOCKS, VoidstoneBlocks.RAW_VOIDSTONE_BLOCK)
						.pattern("###")
						.pattern("###")
						.pattern("###")
						.input('#', VoidstoneItems.RAW_VOIDSTONE)
						.criterion(hasItem(VoidstoneItems.RAW_VOIDSTONE), conditionsFromItem(VoidstoneItems.RAW_VOIDSTONE))
						.offerTo(exporter);

				createShapeless(RecipeCategory.MISC, VoidstoneItems.RAW_VOIDSTONE, 9)
						.input(VoidstoneBlocks.RAW_VOIDSTONE_BLOCK)
						.criterion(hasItem(VoidstoneBlocks.RAW_VOIDSTONE_BLOCK), conditionsFromItem(VoidstoneBlocks.RAW_VOIDSTONE_BLOCK))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, VoidstoneItems.VOIDSTONE_SWORD)
						.pattern("#")
						.pattern("#")
						.pattern("X")
						.input('#', VoidstoneItems.VOIDSTONE)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, VoidstoneItems.VOIDSTONE_HOE)
						.pattern("## ")
						.pattern(" X ")
						.pattern(" X ")
						.input('#', VoidstoneItems.VOIDSTONE)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.DIAMOND_HOE), conditionsFromItem(Items.DIAMOND_HOE))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, VoidstoneItems.VOIDSTONE_AXE)
						.pattern("## ")
						.pattern("#X ")
						.pattern(" X ")
						.input('#', VoidstoneItems.VOIDSTONE)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.DIAMOND_AXE), conditionsFromItem(Items.DIAMOND_AXE))
						.offerTo(exporter);


				createShaped(RecipeCategory.TOOLS, VoidstoneItems.VOIDSTONE_PICKAXE)
						.pattern("###")
						.pattern(" X ")
						.pattern(" X ")
						.input('#', VoidstoneItems.VOIDSTONE)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.DIAMOND_PICKAXE), conditionsFromItem(Items.DIAMOND_PICKAXE))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, VoidstoneItems.VOIDSTONE_SHOVEL)
						.pattern("#")
						.pattern("X")
						.pattern("X")
						.input('#', VoidstoneItems.VOIDSTONE)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.DIAMOND_SHOVEL), conditionsFromItem(Items.DIAMOND_SHOVEL))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, VoidstoneItems.VOIDSTONE_HELMET)
						.pattern("###")
						.pattern("# #")
						.input('#', VoidstoneItems.VOIDSTONE)
						.criterion(hasItem(Items.DIAMOND_HELMET), conditionsFromItem(Items.DIAMOND_HELMET))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, VoidstoneItems.VOIDSTONE_CHESTPLATE)
						.pattern("# #")
						.pattern("###")
						.pattern("###")
						.input('#', VoidstoneItems.VOIDSTONE)
						.criterion(hasItem(Items.DIAMOND_CHESTPLATE), conditionsFromItem(Items.DIAMOND_CHESTPLATE))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, VoidstoneItems.VOIDSTONE_LEGGINGS)
						.pattern("###")
						.pattern("# #")
						.pattern("# #")
						.input('#', VoidstoneItems.VOIDSTONE)
						.criterion(hasItem(Items.DIAMOND_LEGGINGS), conditionsFromItem(Items.DIAMOND_LEGGINGS))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, VoidstoneItems.VOIDSTONE_BOOTS)
						.pattern("# #")
						.pattern("# #")
						.input('#', VoidstoneItems.VOIDSTONE)
						.criterion(hasItem(Items.DIAMOND_BOOTS), conditionsFromItem(Items.DIAMOND_BOOTS))
						.offerTo(exporter);
			}
		};
	}

	@Override
	public String getName() {
		return "⛏️ [MythicMinerals]: Registering Voidstone Recipes";
	}
}
