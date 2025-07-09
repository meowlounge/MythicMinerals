package dev.meowlounge.mythicminerals.world.gen;

import dev.meowlounge.mythicminerals.world.PlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class FrostiumGeneration {
	public static void generateOres() {
//		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
//				PlacedFeatures.FROSTIUM_PLACED_KEY);

		BiomeModifications.addFeature(BiomeSelectors.includeByKey(
						BiomeKeys.ICE_SPIKES, BiomeKeys.DEEP_FROZEN_OCEAN, BiomeKeys.JAGGED_PEAKS, BiomeKeys.SNOWY_SLOPES),
				GenerationStep.Feature.UNDERGROUND_ORES,
				PlacedFeatures.FROSTIUM_PLACED_KEY);
	}
}
