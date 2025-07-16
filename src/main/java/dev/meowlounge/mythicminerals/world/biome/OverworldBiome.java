package dev.meowlounge.mythicminerals.world.biome;

import dev.meowlounge.mythicminerals.world.PlacedFeatures;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;

public class OverworldBiome {
	private static void addFeature(GenerationSettings.LookupBackedBuilder builder, GenerationStep.Feature step, RegistryKey<PlacedFeature> feature) {
		builder.feature(step, feature);
	}

	public static Biome volcanicHighlands(RegistryEntryLookup<PlacedFeature> placedFeatureGetter, RegistryEntryLookup<ConfiguredCarver<?>> carverGetter) {
		GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(placedFeatureGetter, carverGetter);

		// Default terrain generation
		DefaultBiomeFeatures.addLandCarvers(biomeBuilder);
		//DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

		// Add lava lakes for flowing lava
//		addFeature(biomeBuilder, GenerationStep.Feature.SURFACE_STRUCTURES, PlacedFeatures.VOLCANO_PLACED_KEY);

		// Uncomment if MAGMARIT_PLACED_KEY is relevant for your mod
		// addFeature(biomeBuilder, GenerationStep.Feature.UNDERGROUND_ORES, PlacedFeatures.MAGMARIT_PLACED_KEY);

		SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
		DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

		return new Biome.Builder()
				.precipitation(false)
				.temperature(4.0F)
				.downfall(0.0F)
				.effects((new BiomeEffects.Builder())
						.waterColor(0xde4010)
						.waterFogColor(0x942401)
						.fogColor(0xc2673a)
						.skyColor(getSkyColor(4.0F))
						.particleConfig(new BiomeParticleConfig(ParticleTypes.ASH, 0.0075f)) // Increased particle density
						.moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP, 90000, 8, 2.0D))
						.music(MusicType.createIngameMusic(SoundEvents.MUSIC_NETHER_BASALT_DELTAS)) // Changed to basalt deltas music
						.build())
				.spawnSettings(spawnBuilder.build())
				.generationSettings(biomeBuilder.build())
				.build();
	}

	public static Biome fogCave(RegistryEntryLookup<PlacedFeature> placedFeatureGetter, RegistryEntryLookup<ConfiguredCarver<?>> carverGetter) {
		GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(placedFeatureGetter, carverGetter);

		DefaultBiomeFeatures.addLandCarvers(biomeBuilder);
		DefaultBiomeFeatures.addAmethystGeodes(biomeBuilder);
		DefaultBiomeFeatures.addDungeons(biomeBuilder);
		DefaultBiomeFeatures.addMineables(biomeBuilder);

		addFeature(biomeBuilder, GenerationStep.Feature.UNDERGROUND_ORES, PlacedFeatures.FOGSTONE_PLACED_KEY);

		SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
		DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

		return new Biome.Builder()
				.precipitation(false)
				.temperature(1.0F)
				.downfall(0.0F)
				.effects((new BiomeEffects.Builder())
						.waterColor(0x15423c)
						.waterFogColor(0x2a6f66)
						.fogColor(0x9ae1bd)
						.skyColor(getSkyColor(2.0F))
						.particleConfig(new BiomeParticleConfig(ParticleTypes.FIREFLY, 0.00525f))
						.moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP, 90000, 8, 2.0D))
						.music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_SWAMP))
						.build())
				.spawnSettings(spawnBuilder.build())
				.generationSettings(biomeBuilder.build())
				.build();
	}

	public static int getSkyColor(float temperature) {
		float f = temperature;
		f /= 3.0F;
		f = MathHelper.clamp(f, -1.0F, 1.0F);
		return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
	}
}