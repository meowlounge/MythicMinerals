package meowlounge.oreveil;

import meowlounge.oreveil.block.ModBlocks;
import meowlounge.oreveil.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Oreveil implements ModInitializer {
	public static final String MOD_ID = "oreveil";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
	}
}
