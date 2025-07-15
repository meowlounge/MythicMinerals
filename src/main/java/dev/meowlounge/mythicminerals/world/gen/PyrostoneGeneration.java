package dev.meowlounge.mythicminerals.world.gen;

import dev.meowlounge.mythicminerals.world.PlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class PyrostoneGeneration {
	public static void generateOres() {
		BiomeModifications.addFeature(
				BiomeSelectors.includeByKey(
						BiomeKeys.NETHER_WASTES,
						BiomeKeys.CRIMSON_FOREST,
						BiomeKeys.BASALT_DELTAS
				),
				GenerationStep.Feature.RAW_GENERATION,
				PlacedFeatures.PYROSTONE_PLACED_KEY
		);
	}
}
