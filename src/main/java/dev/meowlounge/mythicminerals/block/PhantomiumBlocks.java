package dev.meowlounge.mythicminerals.block;

import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static dev.meowlounge.mythicminerals.block.Utils.registerBlock;

public class PhantomiumBlocks {
    public static void registerPhantomiumBlocks() {
        MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Phantomium Blocks");
    }
    public static final Block PHANTOMIUM_ORE = registerBlock("phantomium_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    properties.strength(3f).requiresTool()));

    public static final Block RAW_PHANTOMIUM_BLOCK = registerBlock("raw_phantomium_block",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(0, 0),
                    properties.strength(4f).requiresTool()));

    public static final Block PHANTOMIUM_BLOCK = registerBlock("phantomium_block",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(0, 0),
                    properties.strength(4f).requiresTool().sounds(BlockSoundGroup.IRON)));
}
