package dev.meowlounge.mythicminerals.datagen.recipe;

import dev.meowlounge.mythicminerals.block.PyrostoneBlocks;
import dev.meowlounge.mythicminerals.item.PyrostoneItems;
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

public class PyrostoneRecipes extends FabricRecipeProvider {
	public PyrostoneRecipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter exporter) {
		return new RecipeGenerator(wrapperLookup, exporter) {
			@Override
			public void generate() {
				List<ItemConvertible> PYROSTONE_SMELTABLES = List.of(
						PyrostoneItems.RAW_PYROSTONE,
						PyrostoneBlocks.PYROSTONE_ORE
				);

				offerSmelting(PYROSTONE_SMELTABLES, RecipeCategory.MISC, PyrostoneItems.PYROSTONE, 0.25F, 200, "fogstone");
				offerBlasting(PYROSTONE_SMELTABLES, RecipeCategory.MISC, PyrostoneItems.PYROSTONE, 0.35F, 100, "fogstone");

				offerReversibleCompactingRecipes(RecipeCategory.MISC, PyrostoneItems.PYROSTONE, RecipeCategory.BUILDING_BLOCKS, PyrostoneBlocks.PYROSTONE_BLOCK);

				createShaped(RecipeCategory.BUILDING_BLOCKS, PyrostoneBlocks.RAW_PYROSTONE_BLOCK)
						.pattern("###")
						.pattern("###")
						.pattern("###")
						.input('#', PyrostoneItems.RAW_PYROSTONE)
						.criterion(hasItem(PyrostoneItems.RAW_PYROSTONE), conditionsFromItem(PyrostoneItems.RAW_PYROSTONE))
						.offerTo(exporter);

				createShapeless(RecipeCategory.MISC, PyrostoneItems.RAW_PYROSTONE, 9)
						.input(PyrostoneBlocks.RAW_PYROSTONE_BLOCK)
						.criterion(hasItem(PyrostoneBlocks.RAW_PYROSTONE_BLOCK), conditionsFromItem(PyrostoneBlocks.RAW_PYROSTONE_BLOCK))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, PyrostoneItems.PYROSTONE_SWORD)
						.pattern("#")
						.pattern("#")
						.pattern("X")
						.input('#', PyrostoneItems.PYROSTONE)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.IRON_SWORD), conditionsFromItem(Items.IRON_SWORD))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, PyrostoneItems.PYROSTONE_HOE)
						.pattern("## ")
						.pattern(" # ")
						.pattern(" X ")
						.input('#', PyrostoneItems.PYROSTONE)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.IRON_HOE), conditionsFromItem(Items.IRON_HOE))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, PyrostoneItems.PYROSTONE_AXE)
						.pattern("## ")
						.pattern("#X ")
						.pattern(" X ")
						.input('#', PyrostoneItems.PYROSTONE)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.IRON_AXE), conditionsFromItem(Items.IRON_AXE))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, PyrostoneItems.PYROSTONE_PICKAXE)
						.pattern("###")
						.pattern(" X ")
						.pattern(" X ")
						.input('#', PyrostoneItems.PYROSTONE)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.IRON_PICKAXE), conditionsFromItem(Items.IRON_PICKAXE))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, PyrostoneItems.PYROSTONE_SHOVEL)
						.pattern("#")
						.pattern("X")
						.pattern("X")
						.input('#', PyrostoneItems.PYROSTONE)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.IRON_SHOVEL), conditionsFromItem(Items.IRON_SHOVEL))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, PyrostoneItems.PYROSTONE_HELMET)
						.pattern("###")
						.pattern("# #")
						.input('#', PyrostoneItems.PYROSTONE)
						.criterion(hasItem(Items.IRON_HELMET), conditionsFromItem(Items.IRON_HELMET))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, PyrostoneItems.PYROSTONE_CHESTPLATE)
						.pattern("# #")
						.pattern("###")
						.pattern("###")
						.input('#', PyrostoneItems.PYROSTONE)
						.criterion(hasItem(Items.IRON_CHESTPLATE), conditionsFromItem(Items.IRON_CHESTPLATE))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, PyrostoneItems.PYROSTONE_LEGGINGS)
						.pattern("###")
						.pattern("# #")
						.pattern("# #")
						.input('#', PyrostoneItems.PYROSTONE)
						.criterion(hasItem(Items.IRON_LEGGINGS), conditionsFromItem(Items.IRON_LEGGINGS))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, PyrostoneItems.PYROSTONE_BOOTS)
						.pattern("# #")
						.pattern("# #")
						.input('#', PyrostoneItems.PYROSTONE)
						.criterion(hasItem(Items.IRON_BOOTS), conditionsFromItem(Items.IRON_BOOTS))
						.offerTo(exporter);
			}
		};
	}

	@Override
	public String getName() {
		return "⛏️ [MythicMinerals]: Registering Pyrostone Recipes";
	}
}
