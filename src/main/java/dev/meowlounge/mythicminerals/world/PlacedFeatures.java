package dev.meowlounge.mythicminerals.world;

import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class PlacedFeatures {
	public static final RegistryKey<PlacedFeature> FROSTIUM_PLACED_KEY = registerKey("frostium_ore_placed");
	public static final RegistryKey<PlacedFeature> VOIDSTONE_PLACED_KEY = registerKey("voidstone_ore_placed");
	public static final RegistryKey<PlacedFeature> STELLARIUM_PLACED_KEY = registerKey("stellarium_ore_placed");
	public static final RegistryKey<PlacedFeature> FOGSTONE_PLACED_KEY = registerKey("fogstone_ore_placed");
	public static final RegistryKey<PlacedFeature> PYROSTONE_PLACED_KEY = registerKey("pyrostone_ore_placed");
	public static final RegistryKey<PlacedFeature> MAGMARIT_PLACED_KEY = registerKey("magmarit_ore_placed");

	public static void bootstrap(Registerable<PlacedFeature> context) {
		var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

		// Frostium
		register(context, FROSTIUM_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.FROSTIUM_ORE_KEY),
				OrePlacement.modifiersWithCount(4,
						HeightRangePlacementModifier.trapezoid(YOffset.fixed(-20), YOffset.fixed(30))));

		// Voidstone
		register(context, VOIDSTONE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.VOIDSTONE_ORE_KEY),
				OrePlacement.modifiersWithCount(7,
						HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(50))));

		// Stellarium
		register(context, STELLARIUM_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.STELLARIUM_ORE_KEY),
				OrePlacement.modifiersWithCount(2,
						HeightRangePlacementModifier.trapezoid(YOffset.fixed(-10), YOffset.fixed(20))));

		// Fogstone
		register(context, FOGSTONE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.FOGSTONE_ORE_KEY),
				OrePlacement.modifiersWithCount(8,
						HeightRangePlacementModifier.trapezoid(YOffset.fixed(-40), YOffset.fixed(40))));

		// Pyrostone
		register(context, PYROSTONE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.PYROSTONE_ORE_KEY),
				OrePlacement.modifiersWithCount(3,
						HeightRangePlacementModifier.trapezoid(YOffset.fixed(12), YOffset.fixed(80))));

		// Magmarit
		register(context, MAGMARIT_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.MAGMARIT_ORE_KEY),
				List.of(
						CountPlacementModifier.of(10), // Anzahl der Versuche pro Chunk
						SquarePlacementModifier.of(), // Verteilung im Chunk
						HeightRangePlacementModifier.uniform(YOffset.fixed(2), YOffset.fixed(125)), // Höhenbereich im Nether
						BlockFilterPlacementModifier.of(BlockPredicate.matchingBlocks(Blocks.LAVA)) // Nur in Lava
				));
	}

	public static RegistryKey<PlacedFeature> registerKey(String name) {
		return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MythicMinerals.MOD_ID, name));
	}

	private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
								 List<PlacementModifier> modifiers) {
		context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
	}

	@SuppressWarnings("unused")
	private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
																				   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
																				   PlacementModifier... modifiers) {
		register(context, key, configuration, List.of(modifiers));
	}
}