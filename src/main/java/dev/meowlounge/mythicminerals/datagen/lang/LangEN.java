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

		translationBuilder.add("mythicminerals.item_group_ore", "MythicMinerals Ores");
	}

	@Override
	public String getName() {
		return "English Translation Generator";
	}
}
