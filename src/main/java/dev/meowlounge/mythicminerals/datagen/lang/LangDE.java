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

		translationBuilder.add("block.mythicminerals.phantomium_ore", "Phantomiumerz");
		translationBuilder.add("block.mythicminerals.deepslate_phantomium_ore", "Tiefenschiefer-Phantomiumerz");
		translationBuilder.add("block.mythicminerals.raw_phantomium_block", "Rohphantomiumblock");
		translationBuilder.add("block.mythicminerals.phantomium_block", "Phantomiumblock");

		translationBuilder.add("item.mythicminerals.phantomium", "Phantomium");
		translationBuilder.add("item.mythicminerals.raw_phantomium", "Rohesphantomium");
		translationBuilder.add("item.mythicminerals.phantomium_sword", "Phantomiumschwert");
		translationBuilder.add("item.mythicminerals.phantomium_shovel", "Phantomiumschaufel");
		translationBuilder.add("item.mythicminerals.phantomium_pickaxe", "Phantomiumspitzhacke");
		translationBuilder.add("item.mythicminerals.phantomium_axe", "Phantomiumaxt");
		translationBuilder.add("item.mythicminerals.phantomium_hoe", "Phantomiumhacke");
		translationBuilder.add("item.mythicminerals.phantomium_helmet", "Phantomiumhelm");
		translationBuilder.add("item.mythicminerals.phantomium_chestplate", "Phantomiumharnisch");
		translationBuilder.add("item.mythicminerals.phantomium_leggings", "Phantomiumbeinschutz");
		translationBuilder.add("item.mythicminerals.phantomium_boots", "Phantomiumstiefel");


		translationBuilder.add("mythicminerals.item_group_ore", "MythicMinerals");
	}

	@Override
	public String getName() {
		return "German Translation Generator";
	}
}
