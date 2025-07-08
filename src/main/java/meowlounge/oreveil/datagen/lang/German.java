package meowlounge.oreveil.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class German extends FabricLanguageProvider {
	public German(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, "de_de", registryLookup);
	}

	@Override
	public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
		translationBuilder.add("block.oreveil.frostium_ore", "Frostium Erz");
		translationBuilder.add("block.oreveil.deepslate_frostium_ore", "Tiefenschiefer Frostium Erz");
		translationBuilder.add("block.oreveil.raw_frostium_block", "Rohfrostiumblock");
		translationBuilder.add("block.oreveil.frostium_block", "Frostium Block");

		translationBuilder.add("item.oreveil.frostium", "Frostium");
		translationBuilder.add("item.oreveil.raw_frostium", "Rhoes Frostium");

		translationBuilder.add("oreveil.item_group_ore", "Oreveil Erz");
	}

	@Override
	public String getName() {
		return "German Translation Generator";
	}
}
