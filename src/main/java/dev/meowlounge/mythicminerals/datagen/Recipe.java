package dev.meowlounge.mythicminerals.datagen;

import dev.meowlounge.mythicminerals.block.FrostiumBlocks;
import dev.meowlounge.mythicminerals.item.FrostiumItems;
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

public class Recipe extends FabricRecipeProvider {
    public Recipe(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> FROSTIUM_SMELTABLES = List.of(FrostiumItems.RAW_FROSTIUM, FrostiumBlocks.FROSTIUM_ORE,
                        FrostiumBlocks.DEEPSLATE_FROSTIUM_ORE, FrostiumBlocks.RAW_FROSTIUM_BLOCK);

                offerSmelting(FROSTIUM_SMELTABLES, RecipeCategory.MISC, FrostiumItems.FROSTIUM, 0.25f, 200, "frostium");
                offerBlasting(FROSTIUM_SMELTABLES, RecipeCategory.MISC, FrostiumItems.FROSTIUM, 0.25f, 100, "frostium");

                offerReversibleCompactingRecipes(RecipeCategory.MISC, FrostiumItems.FROSTIUM, RecipeCategory.BUILDING_BLOCKS, FrostiumBlocks.FROSTIUM_BLOCK);

                createShaped(RecipeCategory.BUILDING_BLOCKS, FrostiumBlocks.RAW_FROSTIUM_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', FrostiumItems.RAW_FROSTIUM)
                        .criterion(hasItem(FrostiumItems.RAW_FROSTIUM), conditionsFromItem(FrostiumItems.RAW_FROSTIUM))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, FrostiumItems.RAW_FROSTIUM, 9)
                        .input(FrostiumBlocks.RAW_FROSTIUM_BLOCK)
                        .criterion(hasItem(FrostiumBlocks.RAW_FROSTIUM_BLOCK), conditionsFromItem(FrostiumBlocks.RAW_FROSTIUM_BLOCK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, FrostiumItems.FROSTIUM_SWORD)
                        .pattern("#")
                        .pattern("#")
                        .pattern("x")
                        .input('#', FrostiumItems.FROSTIUM)
                        .input('x', Items.STICK)
                        .criterion(hasItem(Items.IRON_SWORD), conditionsFromItem(Items.IRON_SWORD))
                        .offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, FrostiumItems.FROSTIUM_HOE)
                        .pattern("## ")
                        .pattern(" # ")
                        .pattern(" x ")
                        .input('#', FrostiumItems.FROSTIUM)
                        .input('x', Items.STICK)
                        .criterion(hasItem(Items.IRON_HOE), conditionsFromItem(Items.IRON_HOE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, FrostiumItems.FROSTIUM_AXE)
                        .pattern("## ")
                        .pattern("#x ")
                        .pattern(" x ")
                        .input('#', FrostiumItems.FROSTIUM)
                        .input('x', Items.STICK)
                        .criterion(hasItem(Items.IRON_AXE), conditionsFromItem(Items.IRON_AXE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, FrostiumItems.FROSTIUM_PICKAXE)
                        .pattern("###")
                        .pattern(" x ")
                        .pattern(" x ")
                        .input('#', FrostiumItems.FROSTIUM)
                        .input('x', Items.STICK)
                        .criterion(hasItem(Items.IRON_PICKAXE), conditionsFromItem(Items.IRON_PICKAXE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, FrostiumItems.FROSTIUM_SHOVEL)
                        .pattern("#")
                        .pattern("x")
                        .pattern("x")
                        .input('#', FrostiumItems.FROSTIUM)
                        .input('x', Items.STICK)
                        .criterion(hasItem(Items.IRON_SHOVEL), conditionsFromItem(Items.IRON_SHOVEL))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, FrostiumItems.FROSTIUM_HELMET)
                        .pattern("###")
                        .pattern("# #")
                        .input('#', FrostiumItems.FROSTIUM)
                        .criterion(hasItem(Items.IRON_HELMET), conditionsFromItem(Items.IRON_HELMET))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, FrostiumItems.FROSTIUM_CHESTPLATE)
                        .pattern("# #")
                        .pattern("###")
                        .pattern("###")
                        .input('#', FrostiumItems.FROSTIUM)
                        .criterion(hasItem(Items.IRON_CHESTPLATE), conditionsFromItem(Items.IRON_CHESTPLATE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, FrostiumItems.FROSTIUM_LEGGINGS)
                        .pattern("###")
                        .pattern("# #")
                        .pattern("# #")
                        .input('#', FrostiumItems.FROSTIUM)
                        .criterion(hasItem(Items.IRON_LEGGINGS), conditionsFromItem(Items.IRON_LEGGINGS))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, FrostiumItems.FROSTIUM_BOOTS)
                        .pattern("# #")
                        .pattern("# #")
                        .input('#', FrostiumItems.FROSTIUM)
                        .criterion(hasItem(Items.IRON_BOOTS), conditionsFromItem(Items.IRON_BOOTS))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Meowlounge Recipes";
    }
}