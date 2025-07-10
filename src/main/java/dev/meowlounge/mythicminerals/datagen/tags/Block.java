package dev.meowlounge.mythicminerals.datagen.tags;

import dev.meowlounge.mythicminerals.block.FrostiumBlocks;
import dev.meowlounge.mythicminerals.block.StellariumBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class Block extends FabricTagProvider.BlockTagProvider {
    public Block(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(FrostiumBlocks.FROSTIUM_ORE)
                .add(FrostiumBlocks.RAW_FROSTIUM_BLOCK)
                .add(FrostiumBlocks.FROSTIUM_BLOCK)
                .add(FrostiumBlocks.DEEPSLATE_FROSTIUM_ORE)
                .add(StellariumBlocks.STELLARIUM_ORE)
                .add(StellariumBlocks.RAW_STELLARIUM_BLOCK)
                .add(StellariumBlocks.STELLARIUM_BLOCK);

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(FrostiumBlocks.FROSTIUM_ORE)
                .add(FrostiumBlocks.RAW_FROSTIUM_BLOCK)
                .add(FrostiumBlocks.FROSTIUM_BLOCK)
                .add(FrostiumBlocks.DEEPSLATE_FROSTIUM_ORE);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(StellariumBlocks.STELLARIUM_ORE)
                .add(StellariumBlocks.RAW_STELLARIUM_BLOCK)
                .add(StellariumBlocks.STELLARIUM_BLOCK);
    }

    @Override
    public String getName() {
        return "⛏️ [MythicMinerals]: Registering Block Tags";
    }
}

