package dev.meowlounge.mythicminerals.logic.armor.frostium;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;

public class FrostiumAura {
	private static final float DAMAGE = 1.5F;
	private static final int RANGE = 3;

	public static void apply(PlayerEntity player, ServerWorld serverWorld) {
		Box area = player.getBoundingBox().expand(RANGE);

		for (Entity entity : serverWorld.getOtherEntities(player, area, e ->
				e instanceof LivingEntity living && !living.isTeammate(player) && !living.isPlayer())) {

			entity.damage(serverWorld, serverWorld.getDamageSources().freeze(), DAMAGE);
		}
	}
}
