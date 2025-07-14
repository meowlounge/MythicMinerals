package dev.meowlounge.mythicminerals.logic.locator;

import dev.meowlounge.mythicminerals.block.FogstoneBlocks;
import dev.meowlounge.mythicminerals.logic.BaseLocatorLogic;
import net.minecraft.block.Block;

public class FogstoneLocator extends BaseLocatorLogic {
	public FogstoneLocator(Settings settings) {
		super(settings);
	}

	@Override
	protected Block[] getTargetBlocks() {
		return new Block[]{
				FogstoneBlocks.FOGSTONE_ORE,
				FogstoneBlocks.DEEPSLATE_FOGSTONE_ORE
		};
	}

	@Override
	protected String getDisplayName() {
		return "§3Fogstone Ore";
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
