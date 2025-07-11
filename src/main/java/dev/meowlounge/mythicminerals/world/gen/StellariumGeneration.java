package dev.meowlounge.mythicminerals.world.gen;

import dev.meowlounge.mythicminerals.world.PlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class StellariumGeneration {
	public static void generateOres() {
		BiomeModifications.addFeature(
				BiomeSelectors.foundInTheEnd(),
				GenerationStep.Feature.UNDERGROUND_ORES,
				PlacedFeatures.STELLARIUM_PLACED_KEY
		);
	}
}
