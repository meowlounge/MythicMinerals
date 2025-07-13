package dev.meowlounge.mythicminerals.block;

import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static dev.meowlounge.mythicminerals.providers.RegisterProvider.registerBlock;

public class FogstoneBlocks {

	public static final Block FOGSTONE_ORE = registerBlock("fogstone_ore",
			properties -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
					properties.strength(3f).requiresTool()));
	public static final Block DEEPSLATE_FOGSTONE_ORE = registerBlock("deepslate_fogstone_ore",
			properties -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 8),
					properties.strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
	public static final Block RAW_FOGSTONE_BLOCK = registerBlock("raw_fogstone_block",
			properties -> new ExperienceDroppingBlock(UniformIntProvider.create(0, 0),
					properties.strength(4f).requiresTool()));
	public static final Block FOGSTONE_BLOCK = registerBlock("fogstone_block",
			properties -> new ExperienceDroppingBlock(UniformIntProvider.create(0, 0),
					properties.strength(4f).requiresTool().sounds(BlockSoundGroup.IRON)));

	public static void registerFogstoneBlocks() {
		MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Fogstone Blocks");
	}
}
