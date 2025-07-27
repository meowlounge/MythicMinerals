package dev.meowlounge.mythicminerals.world;

import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.block.*;
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
	public static final RegistryKey<ConfiguredFeature<?, ?>> FOGSTONE_ORE_KEY = registerKey("fogstone_ore_key");
	public static final RegistryKey<ConfiguredFeature<?, ?>> PYROSTONE_ORE_KEY = registerKey("pyrostone_ore_key");
	public static final RegistryKey<ConfiguredFeature<?, ?>> MAGMARIT_ORE_KEY = registerKey("magmarit_ore_key");

	public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
		RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
		RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
		RuleTest endstoneReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);
		RuleTest netherrackReplaceables = new BlockMatchRuleTest(Blocks.NETHERRACK);

		// Frostium
		List<OreFeatureConfig.Target> FrostiumOres =
				List.of(OreFeatureConfig.createTarget(stoneReplaceables, FrostiumBlocks.FROSTIUM_ORE.getDefaultState()),
						OreFeatureConfig.createTarget(deepslateReplaceables, FrostiumBlocks.DEEPSLATE_FROSTIUM_ORE.getDefaultState()));
		register(context, FROSTIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(FrostiumOres, 6));

		// Voidstone
		List<OreFeatureConfig.Target> VoidstoneOres =
				List.of(OreFeatureConfig.createTarget(endstoneReplaceables, VoidstoneBlocks.VOIDSTONE_ORE.getDefaultState()));
		register(context, VOIDSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(VoidstoneOres, 4));

		// Stellarium
		List<OreFeatureConfig.Target> StellariumOres =
				List.of(OreFeatureConfig.createTarget(endstoneReplaceables, StellariumBlocks.STELLARIUM_ORE.getDefaultState()));
		register(context, STELLARIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(StellariumOres, 3));

		// Fogstone
		List<OreFeatureConfig.Target> FogstoneOres =
				List.of(OreFeatureConfig.createTarget(stoneReplaceables, FogstoneBlocks.FOGSTONE_ORE.getDefaultState()),
						OreFeatureConfig.createTarget(deepslateReplaceables, FogstoneBlocks.DEEPSLATE_FOGSTONE_ORE.getDefaultState()));
		register(context, FOGSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(FogstoneOres, 6));

		// Pyrostone
		List<OreFeatureConfig.Target> PyrostoneOres =
				List.of(OreFeatureConfig.createTarget(netherrackReplaceables, PyrostoneBlocks.PYROSTONE_ORE.getDefaultState()));
		register(context, PYROSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(PyrostoneOres, 8));

		// Magmarit (nur in Lava)
		List<OreFeatureConfig.Target> MagmaritOres =
				List.of(OreFeatureConfig.createTarget(netherrackReplaceables, MagmaritBlocks.MAGMARIT_ORE.getDefaultState()));
		register(context, MAGMARIT_ORE_KEY, Feature.ORE, new OreFeatureConfig(MagmaritOres, 4)); // Größe der Erzlager
	}

	public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
		return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MythicMinerals.MOD_ID, name));
	}

	@SuppressWarnings("unused")
	private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
																				   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
		context.register(key, new ConfiguredFeature<>(feature, configuration));
	}
}