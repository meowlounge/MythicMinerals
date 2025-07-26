package dev.meowlounge.mythicminerals.block;

import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static dev.meowlounge.mythicminerals.providers.RegisterProvider.registerBlock;

public class MagmaritBlocks {

	public static final Block MAGMARIT_ORE = registerBlock("magmarit_ore",
			properties -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 9),
					properties.strength(3f).requiresTool().sounds(BlockSoundGroup.NETHER_ORE)));
	public static final Block RAW_MAGMARIT_BLOCK = registerBlock("raw_magmarit_block",
			properties -> new ExperienceDroppingBlock(UniformIntProvider.create(0, 0),
					properties.strength(4f).requiresTool()));
	public static final Block MAGMARIT_BLOCK = registerBlock("magmarit_block",
			properties -> new ExperienceDroppingBlock(UniformIntProvider.create(0, 0),
					properties.strength(4f).requiresTool().sounds(BlockSoundGroup.IRON)));

	public static void registerMagmaritBlocks() {
		MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Magmarit Blocks");
	}
}
