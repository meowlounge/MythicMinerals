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

		// ---------------------- //

		translationBuilder.add("block.mythicminerals.stellarium_ore", "Stellarium Ore");
		translationBuilder.add("block.mythicminerals.deepslate_stellarium_ore", "Deepslate Stellarium Ore");
		translationBuilder.add("block.mythicminerals.raw_stellarium_block", "Block of Raw Stellarium");
		translationBuilder.add("block.mythicminerals.stellarium_block", "Stellarium Block");

		translationBuilder.add("item.mythicminerals.stellarium", "Stellarium");
		translationBuilder.add("item.mythicminerals.raw_stellarium", "Raw Stellarium");
		translationBuilder.add("item.mythicminerals.stellarium_sword", "Stellarium Sword");
		translationBuilder.add("item.mythicminerals.stellarium_shovel", "Stellarium Shovel");
		translationBuilder.add("item.mythicminerals.stellarium_pickaxe", "Stellarium Pickaxe");
		translationBuilder.add("item.mythicminerals.stellarium_axe", "Stellarium Axe");
		translationBuilder.add("item.mythicminerals.stellarium_hoe", "Stellarium Hoe");
		translationBuilder.add("item.mythicminerals.stellarium_helmet", "Stellarium Helmet");
		translationBuilder.add("item.mythicminerals.stellarium_chestplate", "Stellarium Chestplate");
		translationBuilder.add("item.mythicminerals.stellarium_leggings", "Stellarium Leggings");
		translationBuilder.add("item.mythicminerals.stellarium_boots", "Stellarium Boots");

		// ---------------------- //

		translationBuilder.add("mythicminerals.item_group_ore", "MythicMinerals");
	}

	@Override
	public String getName() {
		return "⛏️ [MythicMinerals]: English Lang Generator";
	}
}
