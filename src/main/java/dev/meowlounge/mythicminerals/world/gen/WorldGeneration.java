package dev.meowlounge.mythicminerals.world.gen;

public class WorldGeneration {
	public static void generateWorldGen() {
		FrostiumGeneration.generateOres();
		VoidstoneGeneration.generateOres();
		StellariumGeneration.generateOres();
		PyrostoneGeneration.generateOres();
		MagmaritGeneration.generateOres();
	}
}
