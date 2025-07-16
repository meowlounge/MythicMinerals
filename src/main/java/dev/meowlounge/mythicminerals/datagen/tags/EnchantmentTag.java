package dev.meowlounge.mythicminerals.datagen.tags;

import dev.meowlounge.mythicminerals.enchantment.Enchantments;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EnchantmentTags;

import java.util.concurrent.CompletableFuture;

public class EnchantmentTag extends FabricTagProvider<Enchantment> {
	public EnchantmentTag(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, RegistryKeys.ENCHANTMENT, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup provider) {
		builder(EnchantmentTags.IN_ENCHANTING_TABLE)
				.add(Enchantments.LAVA_WALKER);
//
//		builder(EnchantmentTags.TREASURE)
//				.add(Enchantments.LAVA_WALKER);
//
//		builder(EnchantmentTags.BOOTS_EXCLUSIVE_SET)
//				.add(Enchantments.LAVA_WALKER);
//
//		builder(EnchantmentTags.ON_RANDOM_LOOT)
//				.add(Enchantments.LAVA_WALKER);
	}
}
