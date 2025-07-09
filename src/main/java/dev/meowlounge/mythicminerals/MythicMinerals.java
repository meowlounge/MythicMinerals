package dev.meowlounge.mythicminerals;

import dev.meowlounge.mythicminerals.block.FrostiumBlocks;
import dev.meowlounge.mythicminerals.item.Frostium;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MythicMinerals implements ModInitializer {
	public static final String MOD_ID = "mythicminerals";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FrostiumBlocks.registerModBlocks();
		Frostium.registerModItems();
		ItemGroup.registerItemGroups();
	}
}
