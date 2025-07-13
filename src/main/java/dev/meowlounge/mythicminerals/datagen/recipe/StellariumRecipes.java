package dev.meowlounge.mythicminerals.datagen.recipe;

import dev.meowlounge.mythicminerals.block.StellariumBlocks;
import dev.meowlounge.mythicminerals.item.StellariumItems;
import dev.meowlounge.mythicminerals.item.VoidstoneItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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
						StellariumBlocks.STELLARIUM_ORE
				);

				offerSmelting(STELLARIUM_SMELTABLES, RecipeCategory.MISC, StellariumItems.STELLARIUM_SCRAP, 0.25f, 300, "stellarium");
				offerBlasting(STELLARIUM_SMELTABLES, RecipeCategory.MISC, StellariumItems.STELLARIUM_SCRAP, 0.25f, 150, "stellarium");

				createShapeless(RecipeCategory.MISC, StellariumItems.STELLARIUM, 1)
						.input(StellariumItems.STELLARIUM_SCRAP, 4)
						.input(VoidstoneItems.VOIDSTONE, 4)
						.criterion(hasItem(StellariumItems.STELLARIUM_SCRAP), conditionsFromItem(StellariumItems.STELLARIUM_SCRAP))
						.offerTo(exporter);


				createShaped(RecipeCategory.BUILDING_BLOCKS, StellariumBlocks.STELLARIUM_BLOCK, 1)
						.pattern("###")
						.pattern("###")
						.pattern("###")
						.input('#', StellariumItems.STELLARIUM)
						.criterion(hasItem(StellariumBlocks.STELLARIUM_BLOCK), conditionsFromItem(StellariumBlocks.STELLARIUM_BLOCK))
						.offerTo(exporter);

				createShaped(RecipeCategory.MISC, StellariumItems.STELLARIUM_UPGRADE_SMITHING_TEMPLATE, 2)
						.pattern("#X#")
						.pattern("#*#")
						.pattern("###")
						.input('#', Items.END_STONE)
						.input('X', VoidstoneItems.VOIDSTONE)
						.input('*', StellariumItems.STELLARIUM_UPGRADE_SMITHING_TEMPLATE)
						.criterion(hasItem(StellariumItems.STELLARIUM_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(StellariumItems.STELLARIUM_UPGRADE_SMITHING_TEMPLATE))
						.offerTo(exporter);

				SmithingTransformRecipeJsonBuilder.create(
								Ingredient.ofItems(StellariumItems.STELLARIUM_UPGRADE_SMITHING_TEMPLATE),
								Ingredient.ofItems(Items.NETHERITE_SWORD),
								Ingredient.ofItems(StellariumItems.STELLARIUM),
								RecipeCategory.COMBAT,
								StellariumItems.STELLARIUM_SWORD
						).criterion("has_netherite_sword", conditionsFromItem(Items.NETHERITE_SWORD))
						.offerTo(exporter, "stellarium_sword_upgrade");

				SmithingTransformRecipeJsonBuilder.create(
								Ingredient.ofItems(StellariumItems.STELLARIUM_UPGRADE_SMITHING_TEMPLATE),
								Ingredient.ofItems(Items.NETHERITE_PICKAXE),
								Ingredient.ofItems(StellariumItems.STELLARIUM),
								RecipeCategory.TOOLS,
								StellariumItems.STELLARIUM_PICKAXE
						).criterion("has_netherite_pickaxe", conditionsFromItem(Items.NETHERITE_PICKAXE))
						.offerTo(exporter, "stellarium_pickaxe_upgrade");

				SmithingTransformRecipeJsonBuilder.create(
								Ingredient.ofItems(StellariumItems.STELLARIUM_UPGRADE_SMITHING_TEMPLATE),
								Ingredient.ofItems(Items.NETHERITE_AXE),
								Ingredient.ofItems(StellariumItems.STELLARIUM),
								RecipeCategory.TOOLS,
								StellariumItems.STELLARIUM_AXE
						).criterion("has_netherite_axe", conditionsFromItem(Items.NETHERITE_AXE))
						.offerTo(exporter, "stellarium_axe_upgrade");

				SmithingTransformRecipeJsonBuilder.create(
								Ingredient.ofItems(StellariumItems.STELLARIUM_UPGRADE_SMITHING_TEMPLATE),
								Ingredient.ofItems(Items.NETHERITE_HOE),
								Ingredient.ofItems(StellariumItems.STELLARIUM),
								RecipeCategory.TOOLS,
								StellariumItems.STELLARIUM_HOE
						).criterion("has_netherite_hoe", conditionsFromItem(Items.NETHERITE_HOE))
						.offerTo(exporter, "stellarium_hoe_upgrade");

				SmithingTransformRecipeJsonBuilder.create(
								Ingredient.ofItems(StellariumItems.STELLARIUM_UPGRADE_SMITHING_TEMPLATE),
								Ingredient.ofItems(Items.NETHERITE_SHOVEL),
								Ingredient.ofItems(StellariumItems.STELLARIUM),
								RecipeCategory.TOOLS,
								StellariumItems.STELLARIUM_SHOVEL
						).criterion("has_netherite_shovel", conditionsFromItem(Items.NETHERITE_SHOVEL))
						.offerTo(exporter, "stellarium_shovel_upgrade");

				SmithingTransformRecipeJsonBuilder.create(
								Ingredient.ofItems(StellariumItems.STELLARIUM_UPGRADE_SMITHING_TEMPLATE),
								Ingredient.ofItems(Items.NETHERITE_CHESTPLATE),
								Ingredient.ofItems(StellariumItems.STELLARIUM),
								RecipeCategory.COMBAT,
								StellariumItems.STELLARIUM_CHESTPLATE
						).criterion("has_netherite_chestplate", conditionsFromItem(Items.NETHERITE_CHESTPLATE))
						.offerTo(exporter, "stellarium_chestplate_upgrade");

				SmithingTransformRecipeJsonBuilder.create(
								Ingredient.ofItems(StellariumItems.STELLARIUM_UPGRADE_SMITHING_TEMPLATE),
								Ingredient.ofItems(Items.NETHERITE_HELMET),
								Ingredient.ofItems(StellariumItems.STELLARIUM),
								RecipeCategory.COMBAT,
								StellariumItems.STELLARIUM_HELMET
						).criterion("has_netherite_helmet", conditionsFromItem(Items.NETHERITE_HELMET))
						.offerTo(exporter, "stellarium_helmet_upgrade");

				SmithingTransformRecipeJsonBuilder.create(
								Ingredient.ofItems(StellariumItems.STELLARIUM_UPGRADE_SMITHING_TEMPLATE),
								Ingredient.ofItems(Items.NETHERITE_LEGGINGS),
								Ingredient.ofItems(StellariumItems.STELLARIUM),
								RecipeCategory.COMBAT,
								StellariumItems.STELLARIUM_LEGGINGS
						).criterion("has_netherite_leggings", conditionsFromItem(Items.NETHERITE_LEGGINGS))
						.offerTo(exporter, "stellarium_leggings_upgrade");

				SmithingTransformRecipeJsonBuilder.create(
								Ingredient.ofItems(StellariumItems.STELLARIUM_UPGRADE_SMITHING_TEMPLATE),
								Ingredient.ofItems(Items.NETHERITE_BOOTS),
								Ingredient.ofItems(StellariumItems.STELLARIUM),
								RecipeCategory.COMBAT,
								StellariumItems.STELLARIUM_BOOTS
						).criterion("has_netherite_boots", conditionsFromItem(Items.NETHERITE_BOOTS))
						.offerTo(exporter, "stellarium_boots_upgrade");

			}
		};

	}


	@Override
	public String getName() {
		return "⛏️ [MythicMinerals]: Registering Stellarium Recipes";
	}
}
