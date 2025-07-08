package meowlounge.oreveil.block;

import meowlounge.oreveil.Oreveil;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Function;

public class ModBlocks {
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Oreveil.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(Oreveil.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Oreveil.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Oreveil.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        Oreveil.LOGGER.info("Registering Mod Blocks for " + Oreveil.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.FROSTIUM_ORE);
            entries.add(ModBlocks.DEEPSLATE_FROSTIUM_ORE);
        });
    }
    public static final Block FROSTIUM_ORE = registerBlock("frostium_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    properties.strength(3f).requiresTool()));

    public static final Block DEEPSLATE_FROSTIUM_ORE = registerBlock("deepslate_frostium_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    properties.strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
}
