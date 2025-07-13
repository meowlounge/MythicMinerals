package dev.meowlounge.mythicminerals.logic.locator;

import dev.meowlounge.mythicminerals.block.VoidstoneBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.block.Block;

public class VoidstoneLocator extends BaseLocatorLogic {
	public VoidstoneLocator(Settings settings) {
		super(settings);
	}

	@Override
	protected Block getTargetBlock() {
		return VoidstoneBlocks.VOIDSTONE_ORE;
	}

	@Override
	protected String getDisplayName() {
		return "§3Voidstone Ore";
	}
}
