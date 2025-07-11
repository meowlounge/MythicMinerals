package dev.meowlounge.mythicminerals.datagen.recipe;

import dev.meowlounge.mythicminerals.block.StellariumBlocks;
import dev.meowlounge.mythicminerals.item.StellariumItems;
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

public class StellariumRecipes extends FabricRecipeProvider {
	public StellariumRecipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter exporter) {
		return new RecipeGenerator(wrapperLookup, exporter) {
			@Override
			public void generate() {
				List<ItemConvertible> STELLARIUM_SMELTABLES = List.of(
						StellariumItems.RAW_STELLARIUM,
						StellariumBlocks.STELLARIUM_ORE,
						StellariumBlocks.RAW_STELLARIUM_BLOCK
				);

				offerSmelting(STELLARIUM_SMELTABLES, RecipeCategory.MISC, StellariumItems.STELLARIUM, 0.25f, 200, "stellarium");
				offerBlasting(STELLARIUM_SMELTABLES, RecipeCategory.MISC, StellariumItems.STELLARIUM, 0.25f, 100, "stellarium");

				offerReversibleCompactingRecipes(RecipeCategory.MISC, StellariumItems.STELLARIUM, RecipeCategory.BUILDING_BLOCKS, StellariumBlocks.STELLARIUM_BLOCK);

				createShaped(RecipeCategory.BUILDING_BLOCKS, StellariumBlocks.RAW_STELLARIUM_BLOCK)
						.pattern("###")
						.pattern("###")
						.pattern("###")
						.input('#', StellariumItems.RAW_STELLARIUM)
						.criterion(hasItem(StellariumItems.RAW_STELLARIUM), conditionsFromItem(StellariumItems.RAW_STELLARIUM))
						.offerTo(exporter);

				createShapeless(RecipeCategory.MISC, StellariumItems.RAW_STELLARIUM, 9)
						.input(StellariumBlocks.RAW_STELLARIUM_BLOCK)
						.criterion(hasItem(StellariumBlocks.RAW_STELLARIUM_BLOCK), conditionsFromItem(StellariumBlocks.RAW_STELLARIUM_BLOCK))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, StellariumItems.STELLARIUM_SWORD)
						.pattern("#")
						.pattern("#")
						.pattern("X")
						.input('#', StellariumItems.STELLARIUM)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, StellariumItems.STELLARIUM_HOE)
						.pattern("## ")
						.pattern(" X ")
						.pattern(" X ")
						.input('#', StellariumItems.STELLARIUM)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.DIAMOND_HOE), conditionsFromItem(Items.DIAMOND_HOE))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, StellariumItems.STELLARIUM_AXE)
						.pattern("## ")
						.pattern("#X ")
						.pattern(" X ")
						.input('#', StellariumItems.STELLARIUM)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.DIAMOND_AXE), conditionsFromItem(Items.DIAMOND_AXE))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, StellariumItems.STELLARIUM_PICKAXE)
						.pattern("###")
						.pattern(" X ")
						.pattern(" X ")
						.input('#', StellariumItems.STELLARIUM)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.DIAMOND_PICKAXE), conditionsFromItem(Items.DIAMOND_PICKAXE))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, StellariumItems.STELLARIUM_SHOVEL)
						.pattern("#")
						.pattern("X")
						.pattern("X")
						.input('#', StellariumItems.STELLARIUM)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.DIAMOND_SHOVEL), conditionsFromItem(Items.DIAMOND_SHOVEL))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, StellariumItems.STELLARIUM_HELMET)
						.pattern("###")
						.pattern("# #")
						.input('#', StellariumItems.STELLARIUM)
						.criterion(hasItem(Items.DIAMOND_HELMET), conditionsFromItem(Items.DIAMOND_HELMET))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, StellariumItems.STELLARIUM_CHESTPLATE)
						.pattern("# #")
						.pattern("###")
						.pattern("###")
						.input('#', StellariumItems.STELLARIUM)
						.criterion(hasItem(Items.DIAMOND_CHESTPLATE), conditionsFromItem(Items.DIAMOND_CHESTPLATE))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, StellariumItems.STELLARIUM_LEGGINGS)
						.pattern("###")
						.pattern("# #")
						.pattern("# #")
						.input('#', StellariumItems.STELLARIUM)
						.criterion(hasItem(Items.DIAMOND_LEGGINGS), conditionsFromItem(Items.DIAMOND_LEGGINGS))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, StellariumItems.STELLARIUM_BOOTS)
						.pattern("# #")
						.pattern("# #")
						.input('#', StellariumItems.STELLARIUM)
						.criterion(hasItem(Items.DIAMOND_BOOTS), conditionsFromItem(Items.DIAMOND_BOOTS))
						.offerTo(exporter);
			}
		};
	}

	@Override
	public String getName() {
		return "⛏️ [MythicMinerals]: Registering Phantomium Recipes";
	}
}
