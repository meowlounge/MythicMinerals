package dev.meowlounge.mythicminerals.logic.armor.frostium;

import dev.meowlounge.mythicminerals.item.FrostiumItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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

public class FrostiumArmor extends Item {

	private static final int TICK_INTERVAL = 20;

	public FrostiumArmor(Settings settings) {
		super(settings);
	}

	@Override
	public void inventoryTick(ItemStack stack, ServerWorld world, net.minecraft.entity.Entity entity, @Nullable EquipmentSlot slot) {
		if (!(entity instanceof PlayerEntity player) || world.isClient) return;
		if (!hasFullFrostiumArmorOn(player)) return;
		if (world.getRegistryKey() == ServerWorld.END) return;

		if (player.age % TICK_INTERVAL != 0) return;

		BlockPos pos = player.getBlockPos();
		Biome biome = world.getBiome(pos).value();

		if (biome.isCold(pos, world.getSeaLevel())) {
			applyColdBiomeBuffs(player, world);
		} else {
			applyHotBiomeDebuffs(player);
		}
	}

	private void applyColdBiomeBuffs(@NotNull PlayerEntity player, ServerWorld world) {
		player.extinguish();

		//? +40% Mining Speed → simulate with Haste II
		player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, TICK_INTERVAL + 1, 1, true, false));

		//? +15% Speed on Ice/Snow
		if (isOnIceOrSnow(player.getBlockStateAtPos())) {
			player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, TICK_INTERVAL + 40, 1, true, false));
		}

		//? Slowness I if standing in water
		if (player.isTouchingWater()) {
			player.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, TICK_INTERVAL + 20, 2, true, false));
		}

		if (player.age % 60 == 0) {
			FrostiumAura.apply(player, world);
		}
	}

	private void applyHotBiomeDebuffs(@NotNull PlayerEntity player) {
		//? -20% Mining Speed in non-cold biomes → simulate with Mining Fatigue I
		player.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, TICK_INTERVAL + 1, 0, true, false));

		//? Slowness I if standing in water
		if (player.isTouchingWater()) {
			player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, TICK_INTERVAL + 1, 0, true, false));
		}
	}

	private boolean isOnIceOrSnow(@NotNull BlockState state) {
		Block block = state.getBlock();
		return block == Blocks.ICE ||
				block == Blocks.PACKED_ICE ||
				block == Blocks.BLUE_ICE ||
				block == Blocks.SNOW ||
				block == Blocks.SNOW_BLOCK;
	}

	private boolean hasFullFrostiumArmorOn(@NotNull PlayerEntity player) {
		return player.getEquippedStack(EquipmentSlot.HEAD).getItem() == FrostiumItems.FROSTIUM_HELMET &&
				player.getEquippedStack(EquipmentSlot.CHEST).getItem() == FrostiumItems.FROSTIUM_CHESTPLATE &&
				player.getEquippedStack(EquipmentSlot.LEGS).getItem() == FrostiumItems.FROSTIUM_LEGGINGS &&
				player.getEquippedStack(EquipmentSlot.FEET).getItem() == FrostiumItems.FROSTIUM_BOOTS;
	}
}
