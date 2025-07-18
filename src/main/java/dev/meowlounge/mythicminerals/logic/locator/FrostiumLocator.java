package dev.meowlounge.mythicminerals.logic.locator;

import dev.meowlounge.mythicminerals.block.FrostiumBlocks;
import net.minecraft.block.Block;

public class FrostiumLocator extends BaseLocatorLogic {
	public FrostiumLocator(Settings settings) {
		super(settings);
	}

	@Override
	protected Block[] getTargetBlocks() {
		return new Block[]{
				FrostiumBlocks.FROSTIUM_ORE,
				FrostiumBlocks.DEEPSLATE_FROSTIUM_ORE
		};
	}

	@Override
	protected String getDisplayName() {
		return "§3Frostium Ore";
	}

	//* keeping default value. ( 64 )
	@Override
	protected int getRadius() {
		return super.getRadius();
	}

	@Override
	protected int getMaxMarkers() {
		return 32;
	}
}
