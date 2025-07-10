package dev.meowlounge.mythicminerals.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class LangEN extends FabricLanguageProvider {
	public LangEN(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, "en_us", registryLookup);
	}

	@Override
	public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
		translationBuilder.add("block.mythicminerals.frostium_ore", "Frostium Ore");
		translationBuilder.add("block.mythicminerals.deepslate_frostium_ore", "Deepslate Frostium Ore");
		translationBuilder.add("block.mythicminerals.raw_frostium_block", "Raw Frostium Block");
		translationBuilder.add("block.mythicminerals.frostium_block", "Frostium Block");

		translationBuilder.add("item.mythicminerals.frostium", "Frostium");
		translationBuilder.add("item.mythicminerals.raw_frostium", "Raw Frostium");
		translationBuilder.add("item.mythicminerals.frostium_sword", "Frostium Sword");
		translationBuilder.add("item.mythicminerals.frostium_shovel", "Frostium Shovel");
		translationBuilder.add("item.mythicminerals.frostium_pickaxe", "Frostium Pickaxe");
		translationBuilder.add("item.mythicminerals.frostium_axe", "Frostium Axe");
		translationBuilder.add("item.mythicminerals.frostium_hoe", "Frostium Hoe");
		translationBuilder.add("item.mythicminerals.frostium_helmet", "Frostium Helmet");
		translationBuilder.add("item.mythicminerals.frostium_chestplate", "Frostium Chestplate");
		translationBuilder.add("item.mythicminerals.frostium_leggings", "Frostium Leggings");
		translationBuilder.add("item.mythicminerals.frostium_boots", "Frostium Boots");

		translationBuilder.add("block.mythicminerals.phantomium_ore", "Phantomium Ore");
		translationBuilder.add("block.mythicminerals.deepslate_phantomium_ore", "Deepslate Phantomium Ore");
		translationBuilder.add("block.mythicminerals.raw_phantomium_block", "Raw Phantomium Block");
		translationBuilder.add("block.mythicminerals.phantomium_block", "Phantomium Block");

		translationBuilder.add("item.mythicminerals.phantomium", "Phantomium");
		translationBuilder.add("item.mythicminerals.raw_phantomium", "Raw Phantomium");
		translationBuilder.add("item.mythicminerals.phantomium_sword", "Phantomium Sword");
		translationBuilder.add("item.mythicminerals.phantomium_shovel", "Phantomium Shovel");
		translationBuilder.add("item.mythicminerals.phantomium_pickaxe", "Phantomium Pickaxe");
		translationBuilder.add("item.mythicminerals.phantomium_axe", "Phantomium Axe");
		translationBuilder.add("item.mythicminerals.phantomium_hoe", "Phantomium Hoe");
		translationBuilder.add("item.mythicminerals.phantomium_helmet", "Phantomium Helmet");
		translationBuilder.add("item.mythicminerals.phantomium_chestplate", "Phantomium Chestplate");
		translationBuilder.add("item.mythicminerals.phantomium_leggings", "Phantomium Leggings");
		translationBuilder.add("item.mythicminerals.phantomium_boots", "Phantomium Boots");

		translationBuilder.add("mythicminerals.item_group_ore", "MythicMinerals");
	}

	@Override
	public String getName() {
		return "English Translation Generator";
	}
}
