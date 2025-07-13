package dev.meowlounge.mythicminerals;

import dev.meowlounge.mythicminerals.block.FrostiumBlocks;
import dev.meowlounge.mythicminerals.block.StellariumBlocks;
import dev.meowlounge.mythicminerals.block.VoidstoneBlocks;
import dev.meowlounge.mythicminerals.item.FrostiumItems;
import dev.meowlounge.mythicminerals.item.StellariumItems;
import dev.meowlounge.mythicminerals.item.VoidstoneItems;
import dev.meowlounge.mythicminerals.world.biome.Biomes;
import dev.meowlounge.mythicminerals.world.gen.WorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.TerraBlenderApi;

public class MythicMinerals implements ModInitializer, TerraBlenderApi
{
    public static final String MOD_ID = "mythicminerals";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ItemGroup.registerItemGroup();
        WorldGeneration.generateWorldGen();

        //? init ores
        FrostiumItems.registerFrostiumItems();
        FrostiumBlocks.registerFrostiumBlocks();

        VoidstoneItems.registerVoidstoneItems();
        VoidstoneBlocks.registerVoidstoneBlocks();

        StellariumItems.registerStellariumItems();
        StellariumBlocks.registerStellariumBlocks();
    }

    @Override
    public void onTerraBlenderInitialized()
    {
        Biomes.registerBiomes();
    }
}
