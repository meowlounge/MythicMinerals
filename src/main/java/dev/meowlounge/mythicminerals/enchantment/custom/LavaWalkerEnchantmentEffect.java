package dev.meowlounge.mythicminerals.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;

public record LavaWalkerEnchantmentEffect() implements EnchantmentEntityEffect {
	public static final MapCodec<LavaWalkerEnchantmentEffect> CODEC = MapCodec.unit(LavaWalkerEnchantmentEffect::new);
	private static final int RADIUS = 2;
	private static final int LIFESPAN_TICKS = 100; // 5 seconds

	@Override
	public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
		BlockPos center = user.getBlockPos().down();

		BlockPos.iterateOutwards(center, RADIUS, 1, RADIUS).forEach(blockPos -> {
			if (blockPos.getY() >= world.getBottomY() &&
					blockPos.getY() <= world.getTopY(Heightmap.Type.MOTION_BLOCKING, blockPos)) {
				if (canPlaceObsidian(world, blockPos)) {
					world.setBlockState(blockPos, Blocks.OBSIDIAN.getDefaultState());
					world.scheduleBlockTick(blockPos, Blocks.OBSIDIAN, LIFESPAN_TICKS);
				}
			}
		});
	}

	private boolean canPlaceObsidian(ServerWorld world, BlockPos pos) {
		Block current = world.getBlockState(pos).getBlock();
		Block above = world.getBlockState(pos.up()).getBlock();

		return current == Blocks.LAVA
				&& world.getFluidState(pos).isStill()
				&& above == Blocks.AIR;
	}

	@Override
	public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
		return CODEC;
	}
}
