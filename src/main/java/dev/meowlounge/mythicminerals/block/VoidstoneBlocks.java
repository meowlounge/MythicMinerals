package dev.meowlounge.mythicminerals.block;

import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static dev.meowlounge.mythicminerals.providers.RegisterProvider.registerBlock;

public class VoidstoneBlocks {
	public static final Block VOIDSTONE_ORE = registerBlock("voidstone_ore",
			properties -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
					properties.strength(3f).requiresTool()));
	public static final Block RAW_VOIDSTONE_BLOCK = registerBlock("raw_voidstone_block",
			properties -> new ExperienceDroppingBlock(UniformIntProvider.create(0, 0),
					properties.strength(4f).requiresTool()));
	public static final Block VOIDSTONE_BLOCK = registerBlock("voidstone_block",
			properties -> new ExperienceDroppingBlock(UniformIntProvider.create(0, 0),
					properties.strength(4f).requiresTool().sounds(BlockSoundGroup.IRON)));

	public static void registerVoidstoneBlocks() {
		MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Voidstone Blocks");
	}
}
