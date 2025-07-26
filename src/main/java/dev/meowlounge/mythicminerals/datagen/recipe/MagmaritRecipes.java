package dev.meowlounge.mythicminerals.datagen.recipe;

import dev.meowlounge.mythicminerals.block.MagmaritBlocks;
import dev.meowlounge.mythicminerals.item.MagmaritItems;
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

public class MagmaritRecipes extends FabricRecipeProvider {
	public MagmaritRecipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter exporter) {
		return new RecipeGenerator(wrapperLookup, exporter) {
			@Override
			public void generate() {
				List<ItemConvertible> MAGMARIT_SMELTABLES = List.of(
						MagmaritItems.RAW_MAGMARIT,
						MagmaritBlocks.MAGMARIT_ORE
				);

				offerBlasting(MAGMARIT_SMELTABLES, RecipeCategory.MISC, MagmaritItems.MAGMARIT, 0.4F, 200, "magmarit");

				offerReversibleCompactingRecipes(RecipeCategory.MISC, MagmaritItems.MAGMARIT, RecipeCategory.BUILDING_BLOCKS, MagmaritBlocks.MAGMARIT_BLOCK);

				createShaped(RecipeCategory.BUILDING_BLOCKS, MagmaritBlocks.RAW_MAGMARIT_BLOCK)
						.pattern("###")
						.pattern("###")
						.pattern("###")
						.input('#', MagmaritItems.RAW_MAGMARIT)
						.criterion(hasItem(MagmaritItems.RAW_MAGMARIT), conditionsFromItem(MagmaritItems.RAW_MAGMARIT))
						.offerTo(exporter);

				createShapeless(RecipeCategory.MISC, MagmaritItems.RAW_MAGMARIT, 9)
						.input(MagmaritBlocks.RAW_MAGMARIT_BLOCK)
						.criterion(hasItem(MagmaritBlocks.RAW_MAGMARIT_BLOCK), conditionsFromItem(MagmaritBlocks.RAW_MAGMARIT_BLOCK))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, MagmaritItems.MAGMARIT_SWORD)
						.pattern("#")
						.pattern("#")
						.pattern("X")
						.input('#', MagmaritItems.MAGMARIT)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.IRON_SWORD), conditionsFromItem(Items.IRON_SWORD))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, MagmaritItems.MAGMARIT_HOE)
						.pattern("## ")
						.pattern(" # ")
						.pattern(" X ")
						.input('#', MagmaritItems.MAGMARIT)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.IRON_HOE), conditionsFromItem(Items.IRON_HOE))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, MagmaritItems.MAGMARIT_AXE)
						.pattern("## ")
						.pattern("#X ")
						.pattern(" X ")
						.input('#', MagmaritItems.MAGMARIT)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.IRON_AXE), conditionsFromItem(Items.IRON_AXE))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, MagmaritItems.MAGMARIT_PICKAXE)
						.pattern("###")
						.pattern(" X ")
						.pattern(" X ")
						.input('#', MagmaritItems.MAGMARIT)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.IRON_PICKAXE), conditionsFromItem(Items.IRON_PICKAXE))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, MagmaritItems.MAGMARIT_SHOVEL)
						.pattern("#")
						.pattern("X")
						.pattern("X")
						.input('#', MagmaritItems.MAGMARIT)
						.input('X', Items.STICK)
						.criterion(hasItem(Items.IRON_SHOVEL), conditionsFromItem(Items.IRON_SHOVEL))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, MagmaritItems.MAGMARIT_HELMET)
						.pattern("###")
						.pattern("# #")
						.input('#', MagmaritItems.MAGMARIT)
						.criterion(hasItem(Items.IRON_HELMET), conditionsFromItem(Items.IRON_HELMET))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, MagmaritItems.MAGMARIT_CHESTPLATE)
						.pattern("# #")
						.pattern("###")
						.pattern("###")
						.input('#', MagmaritItems.MAGMARIT)
						.criterion(hasItem(Items.IRON_CHESTPLATE), conditionsFromItem(Items.IRON_CHESTPLATE))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, MagmaritItems.MAGMARIT_LEGGINGS)
						.pattern("###")
						.pattern("# #")
						.pattern("# #")
						.input('#', MagmaritItems.MAGMARIT)
						.criterion(hasItem(Items.IRON_LEGGINGS), conditionsFromItem(Items.IRON_LEGGINGS))
						.offerTo(exporter);

				createShaped(RecipeCategory.COMBAT, MagmaritItems.MAGMARIT_BOOTS)
						.pattern("# #")
						.pattern("# #")
						.input('#', MagmaritItems.MAGMARIT)
						.criterion(hasItem(Items.IRON_BOOTS), conditionsFromItem(Items.IRON_BOOTS))
						.offerTo(exporter);
			}
		};
	}

	@Override
	public String getName() {
		return "⛏️ [MythicMinerals]: Registering Magmarit Recipes";
	}
}
