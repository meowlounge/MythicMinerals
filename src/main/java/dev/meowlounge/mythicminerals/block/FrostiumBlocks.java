package dev.meowlounge.mythicminerals.block;

import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Function;

public class FrostiumBlocks {
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MythicMinerals.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(MythicMinerals.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MythicMinerals.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MythicMinerals.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        MythicMinerals.LOGGER.info("⛏️ [OREVEIL]: Registering Blocks");
    }
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
}
