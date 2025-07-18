package dev.meowlounge.mythicminerals.datagen.tags;

import dev.meowlounge.mythicminerals.block.*;
import dev.meowlounge.mythicminerals.providers.TagsProvider;
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
				.add(FogstoneBlocks.FOGSTONE_BLOCK)
				.add(FogstoneBlocks.RAW_FOGSTONE_BLOCK)
				.add(FogstoneBlocks.FOGSTONE_ORE)
				.add(FogstoneBlocks.DEEPSLATE_FOGSTONE_ORE)
				.add(VoidstoneBlocks.VOIDSTONE_ORE)
				.add(VoidstoneBlocks.RAW_VOIDSTONE_BLOCK)
				.add(VoidstoneBlocks.VOIDSTONE_BLOCK)
				.add(PyrostoneBlocks.PYROSTONE_ORE)
				.add(PyrostoneBlocks.RAW_PYROSTONE_BLOCK)
				.add(PyrostoneBlocks.PYROSTONE_BLOCK)
				.add(StellariumBlocks.STELLARIUM_ORE)
				.add(StellariumBlocks.STELLARIUM_BLOCK);

		valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
				.add(FogstoneBlocks.FOGSTONE_BLOCK)
				.add(FogstoneBlocks.RAW_FOGSTONE_BLOCK)
				.add(FogstoneBlocks.FOGSTONE_ORE)
				.add(FogstoneBlocks.DEEPSLATE_FOGSTONE_ORE)
				.add(FrostiumBlocks.FROSTIUM_ORE)
				.add(FrostiumBlocks.RAW_FROSTIUM_BLOCK)
				.add(FrostiumBlocks.FROSTIUM_BLOCK)
				.add(FrostiumBlocks.DEEPSLATE_FROSTIUM_ORE)
				.add(PyrostoneBlocks.PYROSTONE_ORE)
				.add(PyrostoneBlocks.RAW_PYROSTONE_BLOCK)
				.add(PyrostoneBlocks.PYROSTONE_BLOCK);

		valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
				.add(VoidstoneBlocks.VOIDSTONE_ORE)
				.add(VoidstoneBlocks.RAW_VOIDSTONE_BLOCK)
				.add(VoidstoneBlocks.VOIDSTONE_BLOCK);

		valueLookupBuilder(TagsProvider.Blocks.NEEDS_NETHERITE_TOOL)
				.add(StellariumBlocks.STELLARIUM_ORE)
				.add(StellariumBlocks.STELLARIUM_BLOCK);

		valueLookupBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
				.addTag(TagsProvider.Blocks.NEEDS_NETHERITE_TOOL);

		valueLookupBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL)
				.addTag(TagsProvider.Blocks.NEEDS_NETHERITE_TOOL);

		valueLookupBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL)
				.addTag(TagsProvider.Blocks.NEEDS_NETHERITE_TOOL);

		valueLookupBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
				.addTag(TagsProvider.Blocks.NEEDS_NETHERITE_TOOL);

		valueLookupBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
				.addTag(TagsProvider.Blocks.NEEDS_NETHERITE_TOOL);

		valueLookupBuilder(TagsProvider.Blocks.INCORRECT_FOR_FROSTIUM_TOOL)
				.addTag(TagsProvider.Blocks.NEEDS_NETHERITE_TOOL);
	}

	@Override
	public String getName() {
		return "⛏️ [MythicMinerals]: Registering Block Tags";
	}
}

