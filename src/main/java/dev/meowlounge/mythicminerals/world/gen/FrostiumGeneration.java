package dev.meowlounge.mythicminerals.world.gen;

import dev.meowlounge.mythicminerals.world.PlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class FrostiumGeneration {
	public static void generateOres() {
		BiomeModifications.addFeature(
				BiomeSelectors.includeByKey(
						BiomeKeys.SNOWY_PLAINS,
						BiomeKeys.SNOWY_TAIGA,
						BiomeKeys.ICE_SPIKES,
						BiomeKeys.FROZEN_OCEAN,
						BiomeKeys.DEEP_FROZEN_OCEAN,
						BiomeKeys.FROZEN_RIVER,
						BiomeKeys.GROVE,
						BiomeKeys.SNOWY_SLOPES,
						BiomeKeys.JAGGED_PEAKS,
						BiomeKeys.FROZEN_PEAKS,
						BiomeKeys.STONY_PEAKS
				),
				GenerationStep.Feature.UNDERGROUND_ORES,
				PlacedFeatures.FROSTIUM_PLACED_KEY
		);
	}
}
