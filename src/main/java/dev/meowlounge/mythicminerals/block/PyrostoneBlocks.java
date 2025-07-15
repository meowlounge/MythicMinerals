package dev.meowlounge.mythicminerals.block;

import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static dev.meowlounge.mythicminerals.providers.RegisterProvider.registerBlock;

public class PyrostoneBlocks {

	public static final Block PYROSTONE_ORE = registerBlock("pyrostone_ore",
			properties -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
					properties.strength(3f).requiresTool()));
	public static final Block RAW_PYROSTONE_BLOCK = registerBlock("raw_pyrostone_block",
			properties -> new ExperienceDroppingBlock(UniformIntProvider.create(0, 0),
					properties.strength(4f).requiresTool()));
	public static final Block PYROSTONE_BLOCK = registerBlock("pyrostone_block",
			properties -> new ExperienceDroppingBlock(UniformIntProvider.create(0, 0),
					properties.strength(4f).requiresTool().sounds(BlockSoundGroup.IRON)));

	public static void registerPyrostoneBlocks() {
		MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Pyrostone Blocks");
	}
}
