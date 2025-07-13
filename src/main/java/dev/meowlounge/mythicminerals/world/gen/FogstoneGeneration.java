package dev.meowlounge.mythicminerals.world.gen;

import dev.meowlounge.mythicminerals.world.PlacedFeatures;
import dev.meowlounge.mythicminerals.world.biome.Biomes;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class FogstoneGeneration {
	public static void generateOres() {
		BiomeModifications.addFeature(
				BiomeSelectors.includeByKey(
						Biomes.FOG_CAVE
				),
				GenerationStep.Feature.UNDERGROUND_ORES,
				PlacedFeatures.FROSTIUM_PLACED_KEY
		);
	}
}
