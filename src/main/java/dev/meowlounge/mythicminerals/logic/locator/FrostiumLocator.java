package dev.meowlounge.mythicminerals.logic.locator;

import dev.meowlounge.mythicminerals.block.FrostiumBlocks;
import dev.meowlounge.mythicminerals.logic.BaseLocatorLogic;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class FrostiumLocator extends BaseLocatorLogic {
	public FrostiumLocator(Settings settings) {
		super(settings);
	}

	@Override
	protected Block[] getTargetBlocks() {
		return new Block[] {
				FrostiumBlocks.FROSTIUM_ORE,
				FrostiumBlocks.DEEPSLATE_FROSTIUM_ORE
		};
	}


	@Override
	protected String getDisplayName() {
		return "§3Frostium Ore";
	}

	//* keeping default value.
	@Override
	protected int getRadius() {
		return super.getRadius();
	}

	@Override
	protected int getMaxMarkers() {
		return 32;
	}

	@Override
	protected Identifier getDimension() {
		return World.OVERWORLD.getValue();
	}
}
