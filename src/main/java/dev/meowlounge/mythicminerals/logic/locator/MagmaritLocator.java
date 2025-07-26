package dev.meowlounge.mythicminerals.logic.locator;

import dev.meowlounge.mythicminerals.block.MagmaritBlocks;
import net.minecraft.block.Block;

public class MagmaritLocator extends BaseLocatorLogic {
	public MagmaritLocator(Settings settings) {
		super(settings);
	}

	@Override
	protected Block[] getTargetBlocks() {
		return new Block[]{
				MagmaritBlocks.MAGMARIT_ORE
		};
	}

	@Override
	protected String getDisplayName() {
		return "§3Magmarit Ore";
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
