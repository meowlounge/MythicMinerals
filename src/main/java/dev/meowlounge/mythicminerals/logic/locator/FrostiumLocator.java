package dev.meowlounge.mythicminerals.logic.locator;

import dev.meowlounge.mythicminerals.block.FrostiumBlocks;
import net.minecraft.block.Block;

public class FrostiumLocator extends BaseLocatorLogic {
	public FrostiumLocator(Settings settings) {
		super(settings);
	}

	@Override
	protected Block getTargetBlock() {
		return FrostiumBlocks.FROSTIUM_ORE;
	}

	@Override
	protected String getDisplayName() {
		return "§3Frostium Ore";
	}
}
