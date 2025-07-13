package dev.meowlounge.mythicminerals;

import dev.meowlounge.mythicminerals.block.FrostiumBlocks;
import dev.meowlounge.mythicminerals.block.StellariumBlocks;
import dev.meowlounge.mythicminerals.block.VoidstoneBlocks;
import dev.meowlounge.mythicminerals.item.DebugItems;
import dev.meowlounge.mythicminerals.item.FrostiumItems;
import dev.meowlounge.mythicminerals.item.StellariumItems;
import dev.meowlounge.mythicminerals.item.VoidstoneItems;
import dev.meowlounge.mythicminerals.world.gen.WorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MythicMinerals implements ModInitializer {
	public static final String MOD_ID = "mythicminerals";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path) {
		if (path == null || path.isEmpty()) {
			throw new IllegalArgumentException("Identifier path cannot be null or empty");
		}
		return Identifier.of(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		ItemGroup.registerItemGroup();
		WorldGeneration.generateWorldGen();

		//? init ores
		FrostiumItems.registerFrostiumItems();
		FrostiumBlocks.registerFrostiumBlocks();

		VoidstoneItems.registerVoidstoneItems();
		VoidstoneBlocks.registerVoidstoneBlocks();

		StellariumItems.registerStellariumItems();
		StellariumBlocks.registerStellariumBlocks();

		DebugItems.registerDEBUGItems();
	}
}
