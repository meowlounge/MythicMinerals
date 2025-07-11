package dev.meowlounge.mythicminerals.datagen.recipe;

import dev.meowlounge.mythicminerals.block.StellariumBlocks;
import dev.meowlounge.mythicminerals.item.StellariumItems;
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

                createShaped(RecipeCategory.MISC, StellariumItems.STELLARIUM_SMITHING_TEMPLATE, 2)
                        .pattern("#X#")
                        .pattern("#*#")
                        .pattern("###")
                        .input('#', Items.END_STONE)
                        .input('X', VoidstoneItems.VOIDSTONE)
                        .input('*', StellariumItems.STELLARIUM_SMITHING_TEMPLATE)
                        .criterion(hasItem(StellariumItems.STELLARIUM_SMITHING_TEMPLATE), conditionsFromItem(StellariumItems.STELLARIUM_SMITHING_TEMPLATE))
                        .offerTo(exporter);

            }
        };

    }

    @Override
    public String getName() {
        return "⛏️ [MythicMinerals]: Registering Stellarium Recipes";
    }
}
