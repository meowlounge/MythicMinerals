package dev.meowlounge.mythicminerals;

import dev.meowlounge.mythicminerals.datagen.tags.Block;
import dev.meowlounge.mythicminerals.datagen.ItemModel;
import dev.meowlounge.mythicminerals.datagen.Recipe;
import dev.meowlounge.mythicminerals.datagen.tags.Item;
import dev.meowlounge.mythicminerals.datagen.lang.LangEN;
import dev.meowlounge.mythicminerals.datagen.lang.LangDE;
import dev.meowlounge.mythicminerals.datagen.RegistryData;
import dev.meowlounge.mythicminerals.datagen.loot_table.OreLoot;
import dev.meowlounge.mythicminerals.world.ConfiguredFeatures;
import dev.meowlounge.mythicminerals.world.PlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class MythicMineralsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ItemModel::new);
		pack.addProvider(LangDE::new);
		pack.addProvider(LangEN::new);
		pack.addProvider(Recipe::new);
		pack.addProvider(Item::new);
		pack.addProvider(Block::new);
		pack.addProvider(OreLoot::new);
		pack.addProvider(RegistryData::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlacedFeatures::bootstrap);
	}
}
