package meowlounge.oreveil;

import meowlounge.oreveil.datagen.ItemModel;
import meowlounge.oreveil.datagen.lang.English;
import meowlounge.oreveil.datagen.lang.German;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class OreveilDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ItemModel::new);
		pack.addProvider(German::new);
		pack.addProvider(English::new);
	}
}
