package dev.meowlounge.mythicminerals.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class LangDE extends FabricLanguageProvider {
    public LangDE(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "de_de", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("block.mythicminerals.frostium_ore", "Frostiumerz");
        translationBuilder.add("block.mythicminerals.deepslate_frostium_ore", "Tiefenschiefer-Frostiumerz");
        translationBuilder.add("block.mythicminerals.raw_frostium_block", "Rohfrostiumblock");
        translationBuilder.add("block.mythicminerals.frostium_block", "Frostiumblock");

        translationBuilder.add("item.mythicminerals.frostium", "Frostium");
        translationBuilder.add("item.mythicminerals.raw_frostium", "Rohesfrostium");
        translationBuilder.add("item.mythicminerals.frostium_sword", "Frostiumschwert");
        translationBuilder.add("item.mythicminerals.frostium_shovel", "Frostiumschaufel");
        translationBuilder.add("item.mythicminerals.frostium_pickaxe", "Frostiumspitzhacke");
        translationBuilder.add("item.mythicminerals.frostium_axe", "Frostiumaxt");
        translationBuilder.add("item.mythicminerals.frostium_hoe", "Frostiumhacke");
        translationBuilder.add("item.mythicminerals.frostium_helmet", "Frostiumhelm");
        translationBuilder.add("item.mythicminerals.frostium_chestplate", "Frostiumharnisch");
        translationBuilder.add("item.mythicminerals.frostium_leggings", "Frostiumbeinschutz");
        translationBuilder.add("item.mythicminerals.frostium_boots", "Frostiumstiefel");

        //* ---------------------- //

        translationBuilder.add("block.mythicminerals.voidstone_ore", "Leerensteinerz");
        translationBuilder.add("block.mythicminerals.raw_voidstone_block", "Rohesleerensteinblock");
        translationBuilder.add("block.mythicminerals.voidstone_block", "Leerensteinblock");

        translationBuilder.add("item.mythicminerals.voidstone", "Leerenstein");
        translationBuilder.add("item.mythicminerals.raw_voidstone", "Rohesleerenstein");
        translationBuilder.add("item.mythicminerals.voidstone_sword", "Leerensteinschwert");
        translationBuilder.add("item.mythicminerals.voidstone_shovel", "Leerensteinschaufel");
        translationBuilder.add("item.mythicminerals.voidstone_pickaxe", "Leerensteinspitzhacke");
        translationBuilder.add("item.mythicminerals.voidstone_axe", "Leerensteinaxt");
        translationBuilder.add("item.mythicminerals.voidstone_hoe", "Leerensteinhacke");
        translationBuilder.add("item.mythicminerals.voidstone_helmet", "Leerensteinhelm");
        translationBuilder.add("item.mythicminerals.voidstone_chestplate", "Leerensteinharnisch");
        translationBuilder.add("item.mythicminerals.voidstone_leggings", "Leerensteinbeinschutz");
        translationBuilder.add("item.mythicminerals.voidstone_boots", "Leerensteinstiefel");

        //* ---------------------- //

        translationBuilder.add("block.mythicminerals.stellarium_ore", "Stellariumerz");
        translationBuilder.add("block.mythicminerals.stellarium_block", "Stellariumblock");

        translationBuilder.add("item.mythicminerals.stellarium", "Stellarium");
        translationBuilder.add("item.mythicminerals.stellarium_upgrade_smithing_template", "Stellariumschmiedevorlage");
        translationBuilder.add("item.mythicminerals.stellarium_scrap", "Stellariumplaten");
        translationBuilder.add("item.mythicminerals.stellarium_sword", "Stellariumschwert");
        translationBuilder.add("item.mythicminerals.stellarium_shovel", "Stellariumschaufel");
        translationBuilder.add("item.mythicminerals.stellarium_pickaxe", "Stellariumspitzhacke");
        translationBuilder.add("item.mythicminerals.stellarium_axe", "Stellariumaxt");
        translationBuilder.add("item.mythicminerals.stellarium_hoe", "Stellariumhacke");
        translationBuilder.add("item.mythicminerals.stellarium_helmet", "Stellariumhelm");
        translationBuilder.add("item.mythicminerals.stellarium_chestplate", "Stellariumharnisch");
        translationBuilder.add("item.mythicminerals.stellarium_leggings", "Stellariumbeinschutz");
        translationBuilder.add("item.mythicminerals.stellarium_boots", "Stellariumstiefel");

        //* ---------------------- //

        translationBuilder.add("mythicminerals.item_group_ore", "MythicMinerals");

        //* ---------------------- //

        translationBuilder.add("item.minecraft.smithing_template.applies_to.netherite", "Netheritausrüstung");
        translationBuilder.add("item.minecraft.smithing_template.base_slot_description", "Rüstungsteil, Werkzeug oder Schwert aus Netherit hinzufügen");
        translationBuilder.add("item.mythicminerals.stellarium_upgrade_smithing_template.additions_slot_description", "Stellarium hinzufügen");
    }

    @Override
    public String getName() {
        return "⛏️ [MythicMinerals]: German Lang Generator";
    }
}
