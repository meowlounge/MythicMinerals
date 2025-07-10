package dev.meowlounge.mythicminerals.datagen.recipe;

import dev.meowlounge.mythicminerals.block.PhantomiumBlocks;
import dev.meowlounge.mythicminerals.item.PhantomiumItems;
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

public class PhantomiumRecipes extends FabricRecipeProvider {
	public PhantomiumRecipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter exporter) {
		return new RecipeGenerator(wrapperLookup, exporter) {
			@Override
			public void generate() {
				List<ItemConvertible> PHANTOMIUM_SMELTABLES = List.of(
						PhantomiumItems.RAW_PHANTOMIUM,
						PhantomiumBlocks.PHANTOMIUM_ORE,
						PhantomiumBlocks.RAW_PHANTOMIUM_BLOCK
				);

				offerSmelting(PHANTOMIUM_SMELTABLES, RecipeCategory.MISC, PhantomiumItems.PHANTOMIUM, 0.25f, 200, "phantomium");
				offerBlasting(PHANTOMIUM_SMELTABLES, RecipeCategory.MISC, PhantomiumItems.PHANTOMIUM, 0.25f, 100, "phantomium");

				offerReversibleCompactingRecipes(RecipeCategory.MISC, PhantomiumItems.PHANTOMIUM, RecipeCategory.BUILDING_BLOCKS, PhantomiumBlocks.PHANTOMIUM_BLOCK);

				createShaped(RecipeCategory.BUILDING_BLOCKS, PhantomiumBlocks.RAW_PHANTOMIUM_BLOCK)
						.pattern("###")
						.pattern("###")
						.pattern("###")
						.input('#', PhantomiumItems.RAW_PHANTOMIUM)
						.criterion(hasItem(PhantomiumItems.RAW_PHANTOMIUM), conditionsFromItem(PhantomiumItems.RAW_PHANTOMIUM))
						.offerTo(exporter);

				createShapeless(RecipeCategory.MISC, PhantomiumItems.RAW_PHANTOMIUM, 9)
						.input(PhantomiumBlocks.RAW_PHANTOMIUM_BLOCK)
						.criterion(hasItem(PhantomiumBlocks.RAW_PHANTOMIUM_BLOCK), conditionsFromItem(PhantomiumBlocks.RAW_PHANTOMIUM_BLOCK))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, PhantomiumItems.PHANTOMIUM_SWORD)
						.pattern("#")
						.pattern("#")
						.pattern("X")
						.input('#', PhantomiumItems.PHANTOMIUM)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, PhantomiumItems.PHANTOMIUM_HOE)
						.pattern("## ")
						.pattern(" X ")
						.pattern(" X ")
						.input('#', PhantomiumItems.PHANTOMIUM)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.DIAMOND_HOE), conditionsFromItem(Items.DIAMOND_HOE))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, PhantomiumItems.PHANTOMIUM_AXE)
						.pattern("## ")
						.pattern("#X ")
						.pattern(" X ")
						.input('#', PhantomiumItems.PHANTOMIUM)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.DIAMOND_AXE), conditionsFromItem(Items.DIAMOND_AXE))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, PhantomiumItems.PHANTOMIUM_PICKAXE)
						.pattern("###")
						.pattern(" X ")
						.pattern(" X ")
						.input('#', PhantomiumItems.PHANTOMIUM)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.DIAMOND_PICKAXE), conditionsFromItem(Items.DIAMOND_PICKAXE))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, PhantomiumItems.PHANTOMIUM_SHOVEL)
						.pattern("#")
						.pattern("X")
						.pattern("X")
						.input('#', PhantomiumItems.PHANTOMIUM)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.DIAMOND_SHOVEL), conditionsFromItem(Items.DIAMOND_SHOVEL))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, PhantomiumItems.PHANTOMIUM_HELMET)
						.pattern("###")
						.pattern("# #")
						.input('#', PhantomiumItems.PHANTOMIUM)
						.criterion(hasItem(Items.DIAMOND_HELMET), conditionsFromItem(Items.DIAMOND_HELMET))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, PhantomiumItems.PHANTOMIUM_CHESTPLATE)
						.pattern("# #")
						.pattern("###")
						.pattern("###")
						.input('#', PhantomiumItems.PHANTOMIUM)
						.criterion(hasItem(Items.DIAMOND_CHESTPLATE), conditionsFromItem(Items.DIAMOND_CHESTPLATE))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, PhantomiumItems.PHANTOMIUM_LEGGINGS)
						.pattern("###")
						.pattern("# #")
						.pattern("# #")
						.input('#', PhantomiumItems.PHANTOMIUM)
						.criterion(hasItem(Items.DIAMOND_LEGGINGS), conditionsFromItem(Items.DIAMOND_LEGGINGS))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, PhantomiumItems.PHANTOMIUM_BOOTS)
						.pattern("# #")
						.pattern("# #")
						.input('#', PhantomiumItems.PHANTOMIUM)
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
