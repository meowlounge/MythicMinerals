package dev.meowlounge.mythicminerals.logic.armor.stellarium;

import dev.meowlounge.mythicminerals.item.StellariumItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;

import java.util.*;

public class StellariumLogic extends Item {
	private static final Map<UUID, Long> cooldowns = new HashMap<>();
	private static final Set<UUID> boostingPlayers = new HashSet<>();
	private static final Map<UUID, Integer> boostTicks = new HashMap<>();

	private static final long COOLDOWN_MS = 16_000;
	private static final boolean DEBUG = true;
	private static final int BOOST_TICKS = 8;
	private static final double BOOST_SPEED = 1;

	public StellariumLogic(Settings settings) {
		super(settings);
	}

	public static boolean hasFullStellariumArmorOn(PlayerEntity player) {
		ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
		ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
		ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
		ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);

		return boots.getItem() != StellariumItems.STELLARIUM_BOOTS ||
				leggings.getItem() != StellariumItems.STELLARIUM_LEGGINGS ||
				chestplate.getItem() != StellariumItems.STELLARIUM_CHESTPLATE ||
				helmet.getItem() != StellariumItems.STELLARIUM_HELMET;
	}

	public static void tryBoost(ServerPlayerEntity player) {
		if (hasFullStellariumArmorOn(player)) return;

		UUID id = player.getUuid();
		long now = System.currentTimeMillis();
		long cooldown = DEBUG ? 1 : COOLDOWN_MS;

		if (cooldowns.getOrDefault(id, 0L) + cooldown > now) return;
		if (boostingPlayers.contains(id)) return;

		cooldowns.put(id, now);
		boostingPlayers.add(id);
		boostTicks.put(id, 0);
	}

	/**
	 * Called from a server tick handler
	 */
	public static void onServerTick(MinecraftServer server) {
		if (boostingPlayers.isEmpty()) return;

		for (ServerWorld world : server.getWorlds()) {
			for (ServerPlayerEntity player : world.getPlayers()) {
				UUID id = player.getUuid();
				if (!boostingPlayers.contains(id)) continue;
				if (hasFullStellariumArmorOn(player)) {
					stopBoost(id);
					continue;
				}

				int ticks = boostTicks.getOrDefault(id, 0);
				if (ticks >= BOOST_TICKS) {
					stopBoost(id);
					player.setInvulnerable(false);
					player.fallDistance = 0f;
					continue;
				}

				Vec3d lookDir = player.getRotationVec(1.0f).normalize();
				Vec3d boostVelocity = lookDir.multiply(BOOST_SPEED);
				player.addVelocity(boostVelocity.x, boostVelocity.y, boostVelocity.z);
				player.velocityModified = true;

				// Calculate position behind player along opposite look direction
				Vec3d behindPos = player.getPos().subtract(lookDir.multiply(0.6)); // 0.6 blocks behind player
				double px = behindPos.x;
				double py = behindPos.y + 0.1; // Slightly above ground
				double pz = behindPos.z;

				// Flame particles with slight random spread
				for (int i = 0; i < 6; i++) {
					double offsetX = (Math.random() - 0.5) * 0.3;
					double offsetY = Math.random() * 0.2;
					double offsetZ = (Math.random() - 0.5) * 0.3;
					double velocityX = (Math.random() - 0.5) * 0.01;
					double velocityY = Math.random() * 0.01;
					double velocityZ = (Math.random() - 0.5) * 0.01;

					world.spawnParticles(ParticleTypes.FLAME, px + offsetX, py + offsetY, pz + offsetZ, 1, velocityX, velocityY, velocityZ, 0.02);
				}

				// Smoke particles drifting slightly up
				for (int i = 0; i < 3; i++) {
					double offsetX = (Math.random() - 0.5) * 0.2;
					double offsetY = Math.random() * 0.1;
					double offsetZ = (Math.random() - 0.5) * 0.2;
					world.spawnParticles(ParticleTypes.SMOKE, px + offsetX, py + offsetY, pz + offsetZ, 1, 0, 0.01, 0, 0.01);
				}

				if (ticks % 4 == 0) {
					world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.PLAYERS, 0.2f, 1.0f + (float)(Math.random() * 0.1));
				}

				if (!player.isOnGround()) {
					player.setInvulnerable(true);
				} else {
					player.setInvulnerable(true);
					player.fallDistance = 0f;
					boostTicks.put(id, ticks + 1);
					continue;
				}

				boostTicks.put(id, ticks + 1);
			}
		}
	}

	private static void stopBoost(UUID id) {
		boostingPlayers.remove(id);
		boostTicks.remove(id);
	}
}
