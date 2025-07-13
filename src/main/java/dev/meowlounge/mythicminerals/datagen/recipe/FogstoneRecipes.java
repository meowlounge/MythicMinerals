package dev.meowlounge.mythicminerals.datagen.recipe;

import dev.meowlounge.mythicminerals.block.FogstoneBlocks;
import dev.meowlounge.mythicminerals.item.FogstoneItems;
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

public class FogstoneRecipes extends FabricRecipeProvider {
	public FogstoneRecipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter exporter) {
		return new RecipeGenerator(wrapperLookup, exporter) {
			@Override
			public void generate() {
				List<ItemConvertible> FOGSTONE_SMELTABLES = List.of(
						FogstoneItems.RAW_FOGSTONE,
						FogstoneBlocks.FOGSTONE_ORE,
						FogstoneBlocks.DEEPSLATE_FOGSTONE_ORE,
						FogstoneBlocks.RAW_FOGSTONE_BLOCK
				);

				offerSmelting(FOGSTONE_SMELTABLES, RecipeCategory.MISC, FogstoneItems.FOGSTONE, 0.25F, 200, "fogstone");
				offerBlasting(FOGSTONE_SMELTABLES, RecipeCategory.MISC, FogstoneItems.FOGSTONE, 0.35F, 100, "fogstone");

				offerReversibleCompactingRecipes(RecipeCategory.MISC, FogstoneItems.FOGSTONE, RecipeCategory.BUILDING_BLOCKS, FogstoneBlocks.FOGSTONE_BLOCK);

				createShaped(RecipeCategory.BUILDING_BLOCKS, FogstoneBlocks.RAW_FOGSTONE_BLOCK)
						.pattern("###")
						.pattern("###")
						.pattern("###")
						.input('#', FogstoneItems.RAW_FOGSTONE)
						.criterion(hasItem(FogstoneItems.RAW_FOGSTONE), conditionsFromItem(FogstoneItems.RAW_FOGSTONE))
						.offerTo(exporter);

				createShapeless(RecipeCategory.MISC, FogstoneItems.RAW_FOGSTONE, 9)
						.input(FogstoneBlocks.RAW_FOGSTONE_BLOCK)
						.criterion(hasItem(FogstoneBlocks.RAW_FOGSTONE_BLOCK), conditionsFromItem(FogstoneBlocks.RAW_FOGSTONE_BLOCK))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, FogstoneItems.FOGSTONE_SWORD)
						.pattern("#")
						.pattern("#")
						.pattern("X")
						.input('#', FogstoneItems.FOGSTONE)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.IRON_SWORD), conditionsFromItem(Items.IRON_SWORD))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, FogstoneItems.FOGSTONE_HOE)
						.pattern("## ")
						.pattern(" # ")
						.pattern(" X ")
						.input('#', FogstoneItems.FOGSTONE)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.IRON_HOE), conditionsFromItem(Items.IRON_HOE))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, FogstoneItems.FOGSTONE_AXE)
						.pattern("## ")
						.pattern("#X ")
						.pattern(" X ")
						.input('#', FogstoneItems.FOGSTONE)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.IRON_AXE), conditionsFromItem(Items.IRON_AXE))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, FogstoneItems.FOGSTONE_PICKAXE)
						.pattern("###")
						.pattern(" X ")
						.pattern(" X ")
						.input('#', FogstoneItems.FOGSTONE)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.IRON_PICKAXE), conditionsFromItem(Items.IRON_PICKAXE))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, FogstoneItems.FOGSTONE_SHOVEL)
						.pattern("#")
						.pattern("X")
						.pattern("X")
						.input('#', FogstoneItems.FOGSTONE)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.IRON_SHOVEL), conditionsFromItem(Items.IRON_SHOVEL))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, FogstoneItems.FOGSTONE_HELMET)
						.pattern("###")
						.pattern("# #")
						.input('#', FogstoneItems.FOGSTONE)
						.criterion(hasItem(Items.IRON_HELMET), conditionsFromItem(Items.IRON_HELMET))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, FogstoneItems.FOGSTONE_CHESTPLATE)
						.pattern("# #")
						.pattern("###")
						.pattern("###")
						.input('#', FogstoneItems.FOGSTONE)
						.criterion(hasItem(Items.IRON_CHESTPLATE), conditionsFromItem(Items.IRON_CHESTPLATE))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, FogstoneItems.FOGSTONE_LEGGINGS)
						.pattern("###")
						.pattern("# #")
						.pattern("# #")
						.input('#', FogstoneItems.FOGSTONE)
						.criterion(hasItem(Items.IRON_LEGGINGS), conditionsFromItem(Items.IRON_LEGGINGS))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, FogstoneItems.FOGSTONE_BOOTS)
						.pattern("# #")
						.pattern("# #")
						.input('#', FogstoneItems.FOGSTONE)
						.criterion(hasItem(Items.IRON_BOOTS), conditionsFromItem(Items.IRON_BOOTS))
						.offerTo(exporter);
			}
		};
	}

	@Override
	public String getName() {
		return "⛏️ [MythicMinerals]: Registering Fogstone Recipes";
	}
}
