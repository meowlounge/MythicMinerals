package dev.meowlounge.mythicminerals.logic.locator;

import dev.meowlounge.mythicminerals.block.StellariumBlocks;
import net.minecraft.block.Block;

public class StellariumLocator extends BaseLocatorLogic {
	public StellariumLocator(Settings settings) {
		super(settings);
	}

	@Override
	protected Block getTargetBlock() {
		return StellariumBlocks.STELLARIUM_ORE;
	}

	@Override
	protected String getDisplayName() {
		return "§3Stellarium Ore";
	}
}
