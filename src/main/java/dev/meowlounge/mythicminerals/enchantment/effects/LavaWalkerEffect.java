package dev.meowlounge.mythicminerals.enchantment.effects;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.event.GameEvent;

import static dev.meowlounge.mythicminerals.block.IceObsidian.ICE_OBSIDIAN;

public class LavaWalkerEffect implements EnchantmentEntityEffect {
	public static final MapCodec<LavaWalkerEffect> CODEC = MapCodec.unit(LavaWalkerEffect::new);

	public LavaWalkerEffect() {
	}

	@Override
	public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
		if (!(user instanceof PlayerEntity) || world.isClient || !user.isOnGround()) {
			return;
		}

		float radius = MathHelper.clamp(3.0F + (level - 1) * 1.0F, 0.0F, 8.0F);
		int maxDx = MathHelper.floor(radius);
		BlockPos centerBelow = BlockPos.ofFloored(pos).down();

		for (int dx = -maxDx; dx <= maxDx; dx++) {
			for (int dz = -maxDx; dz <= maxDx; dz++) {
				if (dx * dx + dz * dz <= radius * radius) {
					BlockPos target = centerBelow.add(dx, 0, dz);
					BlockPos above = target.up();
					if (world.getBlockState(target).isOf(Blocks.LAVA) && world.getBlockState(above).isAir()) {
						world.setBlockState(target, ICE_OBSIDIAN.getDefaultState());
						world.emitGameEvent(GameEvent.BLOCK_PLACE, target, GameEvent.Emitter.of(user));

						int delay = MathHelper.nextInt(world.getRandom(), 30, 60);
						world.scheduleBlockTick(target, ICE_OBSIDIAN, delay);
					}
				}
			}
		}
	}

	@Override
	public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
		return CODEC;
	}
}