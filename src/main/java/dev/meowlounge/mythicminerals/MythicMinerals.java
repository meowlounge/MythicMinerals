package dev.meowlounge.mythicminerals;

import dev.meowlounge.mythicminerals.block.*;
import dev.meowlounge.mythicminerals.enchantment.EnchantmentsEffects;
import dev.meowlounge.mythicminerals.group.DebugItemGroup;
import dev.meowlounge.mythicminerals.group.ItemGroup;
import dev.meowlounge.mythicminerals.item.*;
import dev.meowlounge.mythicminerals.logic.armor.stellarium.StellariumNetworking;
import dev.meowlounge.mythicminerals.logic.locator.BaseLocatorLogic;
import dev.meowlounge.mythicminerals.network.payload.StellariumBoostPayload;
import dev.meowlounge.mythicminerals.world.biome.Biomes;
import dev.meowlounge.mythicminerals.world.gen.WorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.TerraBlenderApi;

public class MythicMinerals implements ModInitializer, TerraBlenderApi {
	public static final String MOD_ID = "mythicminerals";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path) {
		if (path == null || path.isEmpty()) {
			throw new IllegalArgumentException("Identifier path cannot be null or empty");
		}
		return Identifier.of(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		//? init debug stuff
		DebugItemGroup.registerDebugItemGroup();
		DebugItems.registerDEBUGItems();

		//? init items and blocks
		FrostiumItems.registerFrostiumItems();
		FrostiumBlocks.registerFrostiumBlocks();

		MagmaritItems.registerMagmaritItems();
		MagmaritBlocks.registerMagmaritBlocks();

		PyrostoneItems.registerPyrostoneItems();
		PyrostoneBlocks.registerPyrostoneBlocks();

		VoidstoneItems.registerVoidstoneItems();
		VoidstoneBlocks.registerVoidstoneBlocks();

		StellariumItems.registerStellariumItems();
		StellariumBlocks.registerStellariumBlocks();

		FogstoneItems.registerFogstoneItems();
		FogstoneBlocks.registerFogstoneBlocks();

		IceObsidian.registerIceObsidian();

		//? init worldgen
		WorldGeneration.generateWorldGen();

		//? init other stuff
		ItemGroup.registerItemGroup();
		EnchantmentsEffects.registerEnchantmentEffects();

		//? init client side stuff
		PayloadTypeRegistry.playC2S().register(StellariumBoostPayload.ID, StellariumBoostPayload.TYPE.codec());
		StellariumNetworking.registerStellariumPayload();
		BaseLocatorLogic.registerTickHandler();
	}

	@Override
	public void onTerraBlenderInitialized() {
		Biomes.registerBiomes();
	}
}
