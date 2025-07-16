package dev.meowlounge.mythicminerals.world.biome.region;

import com.mojang.datafixers.util.Pair;
import dev.meowlounge.mythicminerals.world.biome.Biomes;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

public class OverworldRegion extends Region {
	public OverworldRegion(Identifier name, int weight) {
		super(name, RegionType.OVERWORLD, weight);
	}

	@Override
	public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
		VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
		new ParameterPointListBuilder()
				.temperature(Temperature.span(Temperature.WARM, Temperature.HOT))
				.humidity(Humidity.span(Humidity.HUMID, Humidity.WET))
				.continentalness(Continentalness.FULL_RANGE)
				.depth(Depth.UNDERGROUND)
				.build().forEach(point -> builder.add(point, Biomes.FOG_CAVE));

		new ParameterPointListBuilder()
				.temperature(Temperature.HOT)
				.humidity(Humidity.DRY)
				.continentalness(Continentalness.MID_INLAND)
				.erosion(Erosion.EROSION_0)
				.depth(Depth.SURFACE)
				.weirdness(Weirdness.PEAK_VARIANT)
				.build().forEach(point -> builder.add(point, Biomes.VOLCANIC_HIGHLANDS));

		builder.build().forEach(mapper);
	}
}