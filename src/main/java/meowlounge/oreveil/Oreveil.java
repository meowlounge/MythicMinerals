package meowlounge.oreveil;

import meowlounge.oreveil.block.ModBlocks;
import meowlounge.oreveil.item.ModItems;
import net.fabricmc.api.ModInitializer;

public class Oreveil implements ModInitializer {
	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		System.out.println("[oreveil] mod loaded!");
	}
}
