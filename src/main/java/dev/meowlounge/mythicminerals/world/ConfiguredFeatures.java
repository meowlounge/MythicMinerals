package dev.meowlounge.mythicminerals.world;

import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.block.FrostiumBlocks;
import dev.meowlounge.mythicminerals.block.StellariumBlocks;
import dev.meowlounge.mythicminerals.block.VoidstoneBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> FROSTIUM_ORE_KEY = registerKey("frostium_ore_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> VOIDSTONE_ORE_KEY = registerKey("voidstone_ore_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> STELLARIUM_ORE_KEY = registerKey("stellarium_ore_key");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest endstoneReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> FrostiumOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, FrostiumBlocks.FROSTIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, FrostiumBlocks.DEEPSLATE_FROSTIUM_ORE.getDefaultState()));

        register(context, FROSTIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(FrostiumOres, 2));

        List<OreFeatureConfig.Target> VoidstoneOres =
                List.of(OreFeatureConfig.createTarget(endstoneReplaceables, VoidstoneBlocks.VOIDSTONE_ORE.getDefaultState()));

        register(context, VOIDSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(VoidstoneOres, 4));

        List<OreFeatureConfig.Target> StellariumOres =
                List.of(OreFeatureConfig.createTarget(endstoneReplaceables, StellariumBlocks.STELLARIUM_ORE.getDefaultState()));

        register(context, STELLARIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(StellariumOres, 10));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MythicMinerals.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
