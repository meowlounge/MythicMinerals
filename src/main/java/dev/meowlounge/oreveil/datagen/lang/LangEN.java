package dev.meowlounge.oreveil.datagen.lang;

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
		translationBuilder.add("block.oreveil.frostium_ore", "Frostium Ore");
		translationBuilder.add("block.oreveil.deepslate_frostium_ore", "Deepslate Frostium Ore");
		translationBuilder.add("block.oreveil.raw_frostium_block", "Raw Frostium Block");
		translationBuilder.add("block.oreveil.frostium_block", "Frostium Block");

		translationBuilder.add("item.oreveil.frostium", "Frostium");
		translationBuilder.add("item.oreveil.raw_frostium", "Raw Frostium");

		translationBuilder.add("oreveil.item_group_ore", "Oreveil Ores");
	}

	@Override
	public String getName() {
		return "English Translation Generator";
	}
}
