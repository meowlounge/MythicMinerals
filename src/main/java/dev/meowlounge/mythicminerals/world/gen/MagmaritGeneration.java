package dev.meowlounge.mythicminerals.world.gen;

import dev.meowlounge.mythicminerals.world.PlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class MagmaritGeneration {
	public static void generateOres() {
		BiomeModifications.addFeature(
				BiomeSelectors.foundInTheNether(),
				GenerationStep.Feature.RAW_GENERATION,
				PlacedFeatures.MAGMARIT_PLACED_KEY
		);
	}
}
