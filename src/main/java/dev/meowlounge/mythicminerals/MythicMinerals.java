package dev.meowlounge.mythicminerals;

import dev.meowlounge.mythicminerals.block.FrostiumBlocks;
import dev.meowlounge.mythicminerals.block.StellariumBlocks;
import dev.meowlounge.mythicminerals.item.FrostiumItems;
import dev.meowlounge.mythicminerals.item.StellariumItems;
import dev.meowlounge.mythicminerals.world.gen.WorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MythicMinerals implements ModInitializer {
	public static final String MOD_ID = "mythicminerals";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ItemGroup.registerItemGroup();
		WorldGeneration.generateWorldGen();

		//? init ores
		FrostiumItems.registerFrostiumItems();
		FrostiumBlocks.registerFrostiumBlocks();

		StellariumItems.registerStellariumItems();
		StellariumBlocks.registerStellariumBlocks();
	}
}
