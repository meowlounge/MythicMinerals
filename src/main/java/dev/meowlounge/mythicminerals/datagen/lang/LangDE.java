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
		translationBuilder.add("block.mythicminerals.frostium_ore", "Frostium Erz");
		translationBuilder.add("block.mythicminerals.deepslate_frostium_ore", "Tiefenschiefer Frostium Erz");
		translationBuilder.add("block.mythicminerals.raw_frostium_block", "Rohfrostiumblock");
		translationBuilder.add("block.mythicminerals.frostium_block", "Frostium Block");

		translationBuilder.add("item.mythicminerals.frostium", "Frostium");
		translationBuilder.add("item.mythicminerals.raw_frostium", "Rhoes Frostium");

		translationBuilder.add("mythicminerals.item_group_ore", "MythicMinerals Erz");
	}

	@Override
	public String getName() {
		return "German Translation Generator";
	}
}
