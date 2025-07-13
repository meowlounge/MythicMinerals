package dev.meowlounge.mythicminerals.logic.locator;

import dev.meowlounge.mythicminerals.block.VoidstoneBlocks;
import dev.meowlounge.mythicminerals.logic.BaseLocatorLogic;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class VoidstoneLocator extends BaseLocatorLogic {
	public VoidstoneLocator(Settings settings) {
		super(settings);
	}

	@Override
	protected Block[] getTargetBlocks() {
		return new Block[] {
				VoidstoneBlocks.VOIDSTONE_ORE,
		};
	}

	@Override
	protected String getDisplayName() {
		return "§3Voidstone Ore";
	}


	@Override
	protected int getRadius() {
		return 32;
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
