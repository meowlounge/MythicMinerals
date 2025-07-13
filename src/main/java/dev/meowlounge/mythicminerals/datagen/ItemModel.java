package dev.meowlounge.mythicminerals.datagen;

import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.block.FrostiumBlocks;
import dev.meowlounge.mythicminerals.block.StellariumBlocks;
import dev.meowlounge.mythicminerals.block.VoidstoneBlocks;
import dev.meowlounge.mythicminerals.item.*;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;


public class ItemModel extends FabricModelProvider {
    public ItemModel(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(FrostiumBlocks.FROSTIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(FrostiumBlocks.DEEPSLATE_FROSTIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(FrostiumBlocks.FROSTIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(FrostiumBlocks.RAW_FROSTIUM_BLOCK);

        //* ---------------------- //

        blockStateModelGenerator.registerSimpleCubeAll(VoidstoneBlocks.VOIDSTONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(VoidstoneBlocks.VOIDSTONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(VoidstoneBlocks.RAW_VOIDSTONE_BLOCK);

        //* ---------------------- //

        blockStateModelGenerator.registerSimpleCubeAll(StellariumBlocks.STELLARIUM_BLOCK);
        blockStateModelGenerator.registerCubeWithCustomTextures(StellariumBlocks.STELLARIUM_ORE, null, (block, ignored) -> new TextureMap().put(TextureKey.PARTICLE, MythicMinerals.id("block/stellarium_ore_top")).put(TextureKey.TOP, MythicMinerals.id("block/stellarium_ore_top")).put(TextureKey.BOTTOM, MythicMinerals.id("block/stellarium_ore_top")).put(TextureKey.SIDE, MythicMinerals.id("block/stellarium_ore_side")));
    }

    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(FrostiumItems.RAW_FROSTIUM, Models.GENERATED);
        itemModelGenerator.register(FrostiumItems.FROSTIUM, Models.GENERATED);
        itemModelGenerator.register(FrostiumItems.FROSTIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(FrostiumItems.FROSTIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(FrostiumItems.FROSTIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(FrostiumItems.FROSTIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(FrostiumItems.FROSTIUM_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor(FrostiumItems.FROSTIUM_CHESTPLATE, Armor.FROSTIUM_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(FrostiumItems.FROSTIUM_LEGGINGS, Armor.FROSTIUM_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(FrostiumItems.FROSTIUM_BOOTS, Armor.FROSTIUM_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(FrostiumItems.FROSTIUM_HELMET, Armor.FROSTIUM_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);

        //* ---------------------- //

        itemModelGenerator.register(VoidstoneItems.RAW_VOIDSTONE, Models.GENERATED);
        itemModelGenerator.register(VoidstoneItems.VOIDSTONE, Models.GENERATED);
        itemModelGenerator.register(VoidstoneItems.VOIDSTONE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(VoidstoneItems.VOIDSTONE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(VoidstoneItems.VOIDSTONE_AXE, Models.HANDHELD);
        itemModelGenerator.register(VoidstoneItems.VOIDSTONE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(VoidstoneItems.VOIDSTONE_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor(VoidstoneItems.VOIDSTONE_CHESTPLATE, Armor.VOIDSTONE_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(VoidstoneItems.VOIDSTONE_LEGGINGS, Armor.VOIDSTONE_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(VoidstoneItems.VOIDSTONE_BOOTS, Armor.VOIDSTONE_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(VoidstoneItems.VOIDSTONE_HELMET, Armor.VOIDSTONE_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);

        //* ---------------------- //

        itemModelGenerator.register(StellariumItems.STELLARIUM_SCRAP, Models.GENERATED);
        itemModelGenerator.register(StellariumItems.STELLARIUM, Models.GENERATED);
        itemModelGenerator.register(StellariumItems.STELLARIUM_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(StellariumItems.STELLARIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(StellariumItems.STELLARIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(StellariumItems.STELLARIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(StellariumItems.STELLARIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(StellariumItems.STELLARIUM_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor(StellariumItems.STELLARIUM_CHESTPLATE, Armor.STELLARIUM_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(StellariumItems.STELLARIUM_LEGGINGS, Armor.STELLARIUM_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(StellariumItems.STELLARIUM_BOOTS, Armor.STELLARIUM_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(StellariumItems.STELLARIUM_HELMET, Armor.STELLARIUM_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);

        //* ---------------------- //

        itemModelGenerator.register(DebugItems.ORE_LOCATOR, Models.HANDHELD);
    }
}
