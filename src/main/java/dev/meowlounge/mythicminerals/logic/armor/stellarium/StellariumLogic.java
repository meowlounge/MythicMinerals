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
	private static final Map<UUID, Vec3d> lockedDirections = new HashMap<>();
	private static final Map<UUID, Integer> invulnerabilityTicks = new HashMap<>();

	//TODO: DEBUG MODE ONLY. DONT SET TO TRUE WHEN PUSHED TO PROD.
	private static final boolean DEBUG_BYPASS_COOLDOWN = true;
	private static final long COOLDOWN_MS = 16_000;
	private static final int BOOST_TICKS = 8;
	private static final int INVULNERABILITY_DURATION = 60;
	private static final double BOOST_SPEED = 6;
	private static final double BOOST_DECELERATION = 0.7;

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
		if (boostingPlayers.contains(id)) return;

		if (!DEBUG_BYPASS_COOLDOWN) {
			long now = System.currentTimeMillis();
			long lastUse = cooldowns.getOrDefault(id, 0L);
			if (now - lastUse < COOLDOWN_MS) return;
		}

		boostingPlayers.add(id);
		boostTicks.put(id, 0);
		invulnerabilityTicks.put(id, 0);

		Vec3d lookDir = player.getRotationVec(1.0f).normalize();
		lockedDirections.put(id, lookDir);

		Vec3d initialVelocity = lookDir.multiply(BOOST_SPEED);
		player.setVelocity(initialVelocity);
		player.velocityModified = true;
	}

	public static void onServerTick(MinecraftServer server) {
		if (boostingPlayers.isEmpty()) return;

		for (ServerWorld world : server.getWorlds()) {
			for (ServerPlayerEntity player : world.getPlayers()) {
				UUID playerId = player.getUuid();
				if (!boostingPlayers.contains(playerId)) continue;
				if (hasFullStellariumArmorOn(player)) {
					stopBoost(playerId);
					continue;
				}

				processBoost(world, player, playerId);
				handleInvulnerability(player, playerId);
			}
		}
	}

	private static void processBoost(ServerWorld world, ServerPlayerEntity player, UUID playerId) {
		int ticks = boostTicks.getOrDefault(playerId, 0);

		if (ticks >= BOOST_TICKS) {
			endBoost(playerId);
			return;
		}

		applyBoostVelocity(player, ticks);
		spawnParticleTrail(world, player);

		if (ticks % 4 == 0) {
			playBoostSound(world, player);
		}

		boostTicks.put(playerId, ticks + 1);
	}

	private static void applyBoostVelocity(ServerPlayerEntity player, int ticks) {
		Vec3d lookDir = lockedDirections.get(player.getUuid());
		if (lookDir == null) return;

		double progressRatio = (double) ticks / BOOST_TICKS;
		double currentSpeed = BOOST_SPEED * Math.pow(BOOST_DECELERATION, progressRatio * 3);

		Vec3d currentVelocity = player.getVelocity();
		Vec3d boostVelocity = lookDir.multiply(currentSpeed);

		Vec3d playerInput = new Vec3d(
				currentVelocity.x * 0.1,
				0,
				currentVelocity.z * 0.1
		);

		Vec3d finalVelocity = boostVelocity.add(playerInput);
		finalVelocity = new Vec3d(finalVelocity.x, currentVelocity.y, finalVelocity.z);

		player.setVelocity(finalVelocity);
		player.velocityModified = true;
	}

	private static void handleInvulnerability(ServerPlayerEntity player, UUID playerId) {
		int invulnTicks = invulnerabilityTicks.getOrDefault(playerId, 0);

		if (invulnTicks < INVULNERABILITY_DURATION) {
			player.setInvulnerable(true);
			player.fallDistance = 0f;
			invulnerabilityTicks.put(playerId, invulnTicks + 1);
		} else {
			player.setInvulnerable(false);
			invulnerabilityTicks.remove(playerId);
		}
	}

	private static void spawnParticleTrail(ServerWorld world, ServerPlayerEntity player) {
		Vec3d lookDir = player.getRotationVec(1.0f).normalize();
		Vec3d behindPos = player.getPos().subtract(lookDir.multiply(0.6));

		double px = behindPos.x;
		double py = behindPos.y + 0.1;
		double pz = behindPos.z;

		spawnFlameParticles(world, px, py, pz);
		spawnSmokeParticles(world, px, py, pz);
	}

	private static void spawnFlameParticles(ServerWorld world, double px, double py, double pz) {
		for (int i = 0; i < 6; i++) {
			double offsetX = (Math.random() - 0.5) * 0.3;
			double offsetY = Math.random() * 0.2;
			double offsetZ = (Math.random() - 0.5) * 0.3;
			double velocityX = (Math.random() - 0.5) * 0.01;
			double velocityY = Math.random() * 0.01;
			double velocityZ = (Math.random() - 0.5) * 0.01;

			world.spawnParticles(ParticleTypes.FLAME, px + offsetX, py + offsetY, pz + offsetZ, 1, velocityX, velocityY, velocityZ, 0.02);
		}
	}

	private static void spawnSmokeParticles(ServerWorld world, double px, double py, double pz) {
		for (int i = 0; i < 3; i++) {
			double offsetX = (Math.random() - 0.5) * 0.2;
			double offsetY = Math.random() * 0.1;
			double offsetZ = (Math.random() - 0.5) * 0.2;

			world.spawnParticles(ParticleTypes.SMOKE, px + offsetX, py + offsetY, pz + offsetZ, 1, 0, 0.01, 0, 0.01);
		}
	}

	private static void playBoostSound(ServerWorld world, ServerPlayerEntity player) {
		world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.PLAYERS, 0.2f, 1.0f + (float) (Math.random() * 0.1));
	}

	private static void endBoost(UUID playerId) {
		stopBoost(playerId);

		cooldowns.put(playerId, System.currentTimeMillis());
	}

	private static void stopBoost(UUID id) {
		boostingPlayers.remove(id);
		boostTicks.remove(id);
		lockedDirections.remove(id);
		invulnerabilityTicks.remove(id);
	}
}