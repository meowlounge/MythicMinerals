package dev.meowlounge.mythicminerals;

import dev.meowlounge.mythicminerals.datagen.ItemModel;
import dev.meowlounge.mythicminerals.datagen.lang.LangEN;
import dev.meowlounge.mythicminerals.datagen.lang.LangDE;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MythicMineralsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ItemModel::new);
		pack.addProvider(LangDE::new);
		pack.addProvider(LangEN::new);
	}
}
