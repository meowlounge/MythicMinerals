package dev.meowlounge.mythicminerals;

import dev.meowlounge.mythicminerals.datagen.ItemModel;
import dev.meowlounge.mythicminerals.datagen.RegistryData;
import dev.meowlounge.mythicminerals.datagen.lang.LangDE;
import dev.meowlounge.mythicminerals.datagen.lang.LangEN;
import dev.meowlounge.mythicminerals.datagen.loot_table.FrostiumLoot;
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
		pack.addProvider(FrostiumLoot::new);
		pack.addProvider(RegistryData::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlacedFeatures::bootstrap);
	}
}
