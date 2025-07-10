package dev.meowlounge.mythicminerals.datagen.loot_table;

import dev.meowlounge.mythicminerals.block.FrostiumBlocks;
import dev.meowlounge.mythicminerals.block.PhantomiumBlocks;
import dev.meowlounge.mythicminerals.item.FrostiumItems;
import dev.meowlounge.mythicminerals.item.PhantomiumItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class OreLoot extends FabricBlockLootTableProvider {
	public OreLoot(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, registryLookup);
	}

	@Override
	public void generate() {
		addDrop(FrostiumBlocks.FROSTIUM_BLOCK);
		addDrop(FrostiumBlocks.RAW_FROSTIUM_BLOCK);

		addDrop(FrostiumBlocks.FROSTIUM_ORE, oreDrops(FrostiumBlocks.FROSTIUM_ORE, FrostiumItems.RAW_FROSTIUM));
		addDrop(FrostiumBlocks.DEEPSLATE_FROSTIUM_ORE, multipleOreDrops(FrostiumBlocks.DEEPSLATE_FROSTIUM_ORE, FrostiumItems.RAW_FROSTIUM, 1, 1));
		addDrop(PhantomiumBlocks.PHANTOMIUM_BLOCK);
		addDrop(PhantomiumBlocks.RAW_PHANTOMIUM_BLOCK);

		addDrop(PhantomiumBlocks.PHANTOMIUM_ORE, oreDrops(PhantomiumBlocks.PHANTOMIUM_ORE, PhantomiumItems.RAW_PHANTOMIUM));
	}

	public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
		RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
		return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
				ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
				.apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
	}
}