package dev.meowlounge.mythicminerals.logic.locator;

import net.minecraft.block.Block;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;

public abstract class BaseLocatorLogic extends Item {
	protected static final int RADIUS = 64;
	protected static final int MAX_MARKERS = 32;

	public BaseLocatorLogic(Settings settings) {
		super(settings);
	}

	protected abstract Block getTargetBlock();
	protected abstract String getDisplayName();

	@Override
	public ActionResult use(World world, PlayerEntity user, Hand hand) {
		if (world.isClient) return ActionResult.PASS;

		ServerWorld serverWorld = (ServerWorld) world;
		Block target = getTargetBlock();
		String label = getDisplayName();

		BlockPos origin = user.getBlockPos();
		Set<BlockPos> foundOres = new HashSet<>();

		BlockPos.Mutable searchPos = new BlockPos.Mutable();
		search:
		for (int dx = -RADIUS; dx <= RADIUS; dx++) {
			for (int dy = -RADIUS; dy <= RADIUS; dy++) {
				for (int dz = -RADIUS; dz <= RADIUS; dz++) {
					searchPos.set(origin.getX() + dx, origin.getY() + dy, origin.getZ() + dz);
					if (serverWorld.getBlockState(searchPos).isOf(target)) {
						foundOres.add(searchPos.toImmutable());
						if (foundOres.size() >= MAX_MARKERS) break search;
					}
				}
			}
		}

		if (foundOres.isEmpty()) {
			user.sendMessage(Text.of("§cNo " + label + " found within " + RADIUS + " blocks."), false);
			user.playSound(SoundEvents.BLOCK_NOTE_BLOCK_BASS.value(), 0.5F, 0.4F);
		} else {
			for (BlockPos pos : foundOres) {
				OreMarkerStand marker = new OreMarkerStand(serverWorld, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, pos, target, label);
				serverWorld.spawnEntity(marker);
			}
			user.sendMessage(Text.of("§aFound " + foundOres.size() + " " + label + " block(s)."), false);
			user.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 0.5F, 2.0F);
		}

		return ActionResult.SUCCESS;
	}

	public static class OreMarkerStand extends ArmorStandEntity {
		private final BlockPos watchedPos;
		private final Block target;
		private int ticks = 0;

		public OreMarkerStand(ServerWorld world, double x, double y, double z, BlockPos watchedPos, Block target, String label) {
			super(world, x, y, z);
			this.watchedPos = watchedPos;
			this.target = target;

			this.setInvisible(true);
			this.setNoGravity(true);
			this.setGlowing(true);
			this.setCustomName(Text.of(label));
			this.setCustomNameVisible(true);
		}

		@Override
		public void tick() {
			super.tick();
			ticks++;
			if (ticks > 200 || !getWorld().getBlockState(watchedPos).isOf(target)) {
				this.discard();
			}
		}
	}
}
