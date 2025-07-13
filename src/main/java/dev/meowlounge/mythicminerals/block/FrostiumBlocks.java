package dev.meowlounge.mythicminerals.block;

import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static dev.meowlounge.mythicminerals.providers.RegisterProvider.registerBlock;

public class FrostiumBlocks {

	public static final Block FROSTIUM_ORE = registerBlock("frostium_ore",
			properties -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
					properties.strength(3f).requiresTool()));
	public static final Block DEEPSLATE_FROSTIUM_ORE = registerBlock("deepslate_frostium_ore",
			properties -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 8),
					properties.strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
	public static final Block RAW_FROSTIUM_BLOCK = registerBlock("raw_frostium_block",
			properties -> new ExperienceDroppingBlock(UniformIntProvider.create(0, 0),
					properties.strength(4f).requiresTool()));
	public static final Block FROSTIUM_BLOCK = registerBlock("frostium_block",
			properties -> new ExperienceDroppingBlock(UniformIntProvider.create(0, 0),
					properties.strength(4f).requiresTool().sounds(BlockSoundGroup.IRON)));

	public static void registerFrostiumBlocks() {
		MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Frostium Blocks");
	}
}
