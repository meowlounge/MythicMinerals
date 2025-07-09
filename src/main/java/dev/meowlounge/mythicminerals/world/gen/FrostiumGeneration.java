package dev.meowlounge.mythicminerals.world.gen;

import dev.meowlounge.mythicminerals.world.PlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class FrostiumGeneration {
	public static void generateOres() {
		BiomeModifications.addFeature(
				BiomeSelectors.foundInOverworld().and(context -> {
					var biome = context.getBiome();
					return biome.getTemperature() <= 0.2F; // ez way to get the biomes...
				}),
				GenerationStep.Feature.UNDERGROUND_ORES,
				PlacedFeatures.FROSTIUM_PLACED_KEY
		);
	}
}
