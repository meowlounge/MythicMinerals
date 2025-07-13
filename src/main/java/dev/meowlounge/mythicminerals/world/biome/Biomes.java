package dev.meowlounge.mythicminerals.world.biome;

import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.world.biome.region.OverworldRegion;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import terrablender.api.Regions;

public class Biomes {
	public static final RegistryKey<Biome> FOG_CAVE = registerBiomeKey();

	public static void registerBiomes() {
		Regions.register(new OverworldRegion(Identifier.of(MythicMinerals.MOD_ID, "mythicminerals_overworld"), 20));

	}

	public static void bootstrap(Registerable<Biome> context) {
		var carver = context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);
		var placedFeatures = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

		register(context, OverworldBiome.fogCave(placedFeatures, carver));
	}


	private static void register(Registerable<Biome> context, Biome biome) {
		context.register(Biomes.FOG_CAVE, biome);
	}

	private static RegistryKey<Biome> registerBiomeKey() {
		return RegistryKey.of(RegistryKeys.BIOME, Identifier.of(MythicMinerals.MOD_ID, "fog_cave"));
	}
}