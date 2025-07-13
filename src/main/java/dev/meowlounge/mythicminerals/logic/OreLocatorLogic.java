package dev.meowlounge.mythicminerals.logic;

import dev.meowlounge.mythicminerals.block.StellariumBlocks;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OreLocatorLogic extends Item {
	public OreLocatorLogic(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult use(World world, PlayerEntity user, Hand hand) {
		if (world.isClient) {
			return ActionResult.PASS;
		}

		final int radius = 96;
		BlockPos origin = user.getBlockPos();
		boolean found = false;

		outer:
		for (int x = -radius; x <= radius; x++) {
			for (int y = -radius; y <= radius; y++) {
				for (int z = -radius; z <= radius; z++) {
					BlockPos pos = origin.add(x, y, z);
					if (world.getBlockState(pos).getBlock() == StellariumBlocks.STELLARIUM_ORE) {
						OreMarkerStand stand = new OreMarkerStand((ServerWorld) world,
								pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, pos);
						world.spawnEntity(stand);

						user.sendMessage(Text.of("§aFound Stellarium Ore at: §e" + pos.toShortString()), false);

						found = true;
						break outer;
					}
				}
			}
		}

		if (!found) {
			user.sendMessage(Text.of("§cNo Stellarium Ore found within " + radius + " blocks."), false);
		}

		return ActionResult.SUCCESS;
	}

	public static class OreMarkerStand extends ArmorStandEntity {
		private final BlockPos watchedPos;
		private int ticks = 0;

		public OreMarkerStand(ServerWorld world, double x, double y, double z, BlockPos watchedPos) {
			super(world, x, y, z);
			this.watchedPos = watchedPos;
			this.setInvisible(true);
			this.setNoGravity(true);
			this.setGlowing(true);
			this.setCustomName(Text.of("§bStellarium Ore"));
			this.setCustomNameVisible(true);
		}

		@Override
		public void tick() {
			super.tick();
			ticks++;

			if (ticks > 200 || !this.getWorld().getBlockState(watchedPos).isOf(StellariumBlocks.STELLARIUM_ORE)) {
				this.discard();
			}
		}
	}
}
