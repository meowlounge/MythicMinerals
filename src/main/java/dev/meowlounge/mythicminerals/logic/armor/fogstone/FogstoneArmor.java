package dev.meowlounge.mythicminerals.logic.armor.fogstone;

import dev.meowlounge.mythicminerals.item.FogstoneItems;
import net.minecraft.block.Block;
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
import org.jetbrains.annotations.Nullable;

public class FogstoneArmor extends Item {
	private static final int CHECK_INTERVAL = 20; // Every 1 second
	private static final int CAMO_THRESHOLD_TICKS = 60; // 3 seconds
	private static final int CLIMB_SPEED_BOOST_LEVEL = 1;

	public FogstoneArmor(Settings settings) {
		super(settings);
	}

	@Override
	public void inventoryTick(ItemStack stack, ServerWorld world, net.minecraft.entity.Entity entity, @Nullable EquipmentSlot slot) {
		if (!(entity instanceof PlayerEntity player) || world.isClient) return;
		if (!hasFullFogstoneArmor(player)) return;
		if (player.age % CHECK_INTERVAL != 0) return;

		BlockPos pos = player.getBlockPos();
		Biome biome = world.getBiome(pos).value();

		boolean isHumid = isHumidBiome(biome);

		if (isHumid) {
			applyHumidBuffs(player, world, pos);
			handleCamouflage(player, biome);
		} else {
			applyDryDebuffs(player);
		}

		if (isInNether(world)) {
			increaseHunger(player);
		}

		handleMistWalker(player, world, pos);
	}

	private boolean isHumidBiome(Biome biome) {
		String name = biome.toString().toLowerCase();
		return name.contains("jungle") || name.contains("swamp") || name.contains("mangrove") || name.contains("rainforest");
	}

	private void applyHumidBuffs(PlayerEntity player, ServerWorld world, BlockPos pos) {
		if (world.isRaining()) {
			player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, CHECK_INTERVAL + 5, 0, true, false));
		}

		if (isOnClimbable(player)) {
			player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, CHECK_INTERVAL + 5, CLIMB_SPEED_BOOST_LEVEL, true, false));
		}
	}

	private void applyDryDebuffs(PlayerEntity player) {
		player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, CHECK_INTERVAL + 5, 0, true, false));
	}

	private void handleCamouflage(PlayerEntity player, Biome biome) {
		if (isJungleBiome(biome) && player.isOnGround() && player.getVelocity().lengthSquared() < 0.001) {
			if (player.age % CAMO_THRESHOLD_TICKS == 0) {
				player.setInvisible(true);
			}
		} else {
			if (player.isInvisible()) {
				player.setInvisible(false);
			}
		}
	}


	private void handleMistWalker(PlayerEntity player, ServerWorld world, BlockPos pos) {
		if (!player.isOnGround() && player.getVelocity().y < 0) {
			Block below = world.getBlockState(pos.down()).getBlock();
			if (isLeafOrVine(below)) {
				player.setVelocity(player.getVelocity().x, Math.max(player.getVelocity().y, -0.05), player.getVelocity().z);
			}
		}
	}

	private boolean isOnClimbable(PlayerEntity player) {
		return player.horizontalCollision && player.isClimbing();
	}

	private boolean isJungleBiome(Biome biome) {
		return biome.getClass().getName().toLowerCase().contains("jungle");
	}

	private boolean isLeafOrVine(Block block) {
		return block == Blocks.VINE || block == Blocks.TWISTING_VINES || block == Blocks.WEEPING_VINES ||
				block.getName().toString().contains("leaves");
	}

	private boolean isInNether(ServerWorld world) {
		return world.getRegistryKey().getValue().getPath().equals("the_nether");
	}

	private void increaseHunger(PlayerEntity player) {
		if (player.getHungerManager().isNotFull()) {
			player.getHungerManager().addExhaustion(0.025f);
		}
	}

	private boolean hasFullFogstoneArmor(PlayerEntity player) {
		return player.getEquippedStack(EquipmentSlot.HEAD).getItem() == FogstoneItems.FOGSTONE_HELMET &&
				player.getEquippedStack(EquipmentSlot.CHEST).getItem() == FogstoneItems.FOGSTONE_CHESTPLATE &&
				player.getEquippedStack(EquipmentSlot.LEGS).getItem() == FogstoneItems.FOGSTONE_LEGGINGS &&
				player.getEquippedStack(EquipmentSlot.FEET).getItem() == FogstoneItems.FOGSTONE_BOOTS;
	}
}
