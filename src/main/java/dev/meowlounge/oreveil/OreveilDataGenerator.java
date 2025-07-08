package dev.meowlounge.oreveil;

import dev.meowlounge.oreveil.datagen.ItemModel;
import dev.meowlounge.oreveil.datagen.lang.LangEN;
import dev.meowlounge.oreveil.datagen.lang.LangDE;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class OreveilDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ItemModel::new);
		pack.addProvider(LangDE::new);
		pack.addProvider(LangEN::new);
	}
}
