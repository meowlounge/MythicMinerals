package dev.meowlounge.mythicminerals.block;

import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static dev.meowlounge.mythicminerals.block.BlockUtils.*;

public class StellariumBlocks {
    public static final Block STELLARIUM_ORE = registerBlock("stellarium_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    properties.strength(3f).requiresTool()));
    public static final Block STELLARIUM_BLOCK = registerBlock("stellarium_block",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(0, 0),
                    properties.strength(4f).requiresTool().sounds(BlockSoundGroup.IRON)));

    public static void registerStellariumBlocks() {
        MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Stellarium Blocks");
    }
}
