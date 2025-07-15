package dev.meowlounge.mythicminerals.logic.locator;

import dev.meowlounge.mythicminerals.block.PyrostoneBlocks;
import dev.meowlounge.mythicminerals.logic.BaseLocatorLogic;
import net.minecraft.block.Block;

public class PyrostoneLocator extends BaseLocatorLogic {
	public PyrostoneLocator(Settings settings) {
		super(settings);
	}

	@Override
	protected Block[] getTargetBlocks() {
		return new Block[]{
				PyrostoneBlocks.PYROSTONE_ORE
		};
	}

	@Override
	protected String getDisplayName() {
		return "§3Pyrostone Ore";
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
