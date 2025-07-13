package dev.meowlounge.mythicminerals.world.biome;

import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.world.biome.region.OverworldRegion;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import terrablender.api.EndBiomeRegistry;
import net.minecraft.world.biome.Biome;
import terrablender.api.Regions;

public class Biomes {
    public static final RegistryKey<Biome> FOG_CAVE = registerBiomeKey("fog_cave");

    public static void registerBiomes() {
        Regions.register(new OverworldRegion(Identifier.of(MythicMinerals.MOD_ID, "mythicminerals_overworld"), 20));

    }

    public static void bootstrap(Registerable<Biome> context) {
        var carver = context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);
        var placedFeatures = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        register(context, FOG_CAVE, OverworldBiome.fogCave(placedFeatures, carver));
    }


    private static void register(Registerable<Biome> context, RegistryKey<Biome> key, Biome biome) {
        context.register(key, biome);
    }

    private static RegistryKey<Biome> registerBiomeKey(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, Identifier.of(MythicMinerals.MOD_ID, name));
    }
}