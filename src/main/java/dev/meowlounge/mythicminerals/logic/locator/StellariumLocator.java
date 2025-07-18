package dev.meowlounge.mythicminerals.logic.locator;

import dev.meowlounge.mythicminerals.block.StellariumBlocks;
import net.minecraft.block.Block;

public class StellariumLocator extends BaseLocatorLogic {

	public StellariumLocator(Settings settings) {
		super(settings);
	}

	@Override
	protected Block[] getTargetBlocks() {
		return new Block[]{
				StellariumBlocks.STELLARIUM_ORE,
		};
	}

	@Override
	protected String getDisplayName() {
		return "§3Stellarium Ore";
	}

	@Override
	protected int getRadius() {
		return 128;
	}

	@Override
	protected int getMaxMarkers() {
		return 16;
	}
}
