package dev.meowlounge.mythicminerals.logic.armor;

import dev.meowlounge.mythicminerals.item.FrostiumItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FrostiumLogic extends Item {
	public FrostiumLogic(Settings settings) {
		super(settings);
	}

	@Override
	public void inventoryTick(ItemStack stack, ServerWorld world, net.minecraft.entity.Entity entity, @Nullable EquipmentSlot slot) {
		if (!(entity instanceof PlayerEntity player)) return;
		if (world.isClient) return;
		if (!hasFullFrostiumArmorOn(player)) return;

		if (world.getRegistryKey() == ServerWorld.END) return;

		if (isInColdBiome(world, player.getBlockPos())) {
			applyColdBiomeBuffs(player);
		} else {
			applyOverworldDebuffs(player, world);
		}

		super.inventoryTick(stack, world, entity, slot);
	}

	private void applyColdBiomeBuffs(@NotNull PlayerEntity player) {
		player.extinguish();
		player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1, 2));
		player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1, 1));
	}

	private void applyOverworldDebuffs(@NotNull PlayerEntity player, ServerWorld world) {
		player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 1, 0));
		player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 1, 0));
		//* damage player every 120 ticks.
		if (player.age % 120 == 0) {
			player.damage(world, world.getDamageSources().magic(), 0.5F);
		}
	}

	private boolean isInColdBiome(@NotNull ServerWorld world, BlockPos pos) {
		Biome biome = world.getBiome(pos).value();
		return biome.isCold(pos, world.getSeaLevel());
	}

	private boolean hasFullFrostiumArmorOn(@NotNull PlayerEntity player) {
		ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
		ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
		ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
		ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);

		return boots.getItem() == FrostiumItems.FROSTIUM_BOOTS &&
				leggings.getItem() == FrostiumItems.FROSTIUM_LEGGINGS &&
				chestplate.getItem() == FrostiumItems.FROSTIUM_CHESTPLATE &&
				helmet.getItem() == FrostiumItems.FROSTIUM_HELMET;
	}
}