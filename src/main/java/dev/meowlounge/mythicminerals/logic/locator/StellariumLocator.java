package dev.meowlounge.mythicminerals.logic.locator;

import dev.meowlounge.mythicminerals.block.StellariumBlocks;
import dev.meowlounge.mythicminerals.logic.BaseLocatorLogic;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class StellariumLocator extends BaseLocatorLogic {

	public StellariumLocator(Settings settings) {
		super(settings);
	}

	@Override
	protected Block[] getTargetBlocks() {
		return new Block[] {
				StellariumBlocks.STELLARIUM_ORE,
		};
	}

	@Override
	protected String getDisplayName() {
		return "§3Stellarium Ore";
	}

	@Override
	protected int getRadius() {
		return 256;
	}

	@Override
	protected int getMaxMarkers() {
		return 32;
	}

	@Override
	protected Identifier getDimension() {
		return World.END.getValue();
	}
}
