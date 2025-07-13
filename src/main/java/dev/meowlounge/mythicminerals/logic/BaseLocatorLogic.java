package dev.meowlounge.mythicminerals.logic;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.DisplayEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AffineTransformation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.HashSet;
import java.util.Set;

public abstract class BaseLocatorLogic extends Item {
	protected static final int RADIUS = 64;
	protected static final int MAX_MARKERS = 128;

	public BaseLocatorLogic(Settings settings) {
		super(settings);
	}

	protected abstract Block[] getTargetBlocks();
	protected abstract String getDisplayName();

	@Override
	public ActionResult use(World world, PlayerEntity user, Hand hand) {
		if (world.isClient) return ActionResult.PASS;

		ServerWorld serverWorld = (ServerWorld) world;
		Set<Block> targetBlockSet = Set.of(getTargetBlocks());
		String label = getDisplayName();

		BlockPos origin = user.getBlockPos();
		BlockPos.Mutable mutablePos = new BlockPos.Mutable();
		Set<BlockPos> foundPositions = new HashSet<>(MAX_MARKERS);

		outer:
		for (int dx = -RADIUS; dx <= RADIUS; dx++) {
			for (int dy = -RADIUS; dy <= RADIUS; dy++) {
				for (int dz = -RADIUS; dz <= RADIUS; dz++) {
					mutablePos.set(origin.getX() + dx, origin.getY() + dy, origin.getZ() + dz);
					BlockState state = serverWorld.getBlockState(mutablePos);
					if (targetBlockSet.contains(state.getBlock())) {
						foundPositions.add(mutablePos.toImmutable());
						if (foundPositions.size() >= MAX_MARKERS) break outer;
					}
				}
			}
		}

		if (foundPositions.isEmpty()) {
			user.sendMessage(Text.of("§cNo " + label + " found within " + RADIUS + " blocks."), false);
		} else {
			for (BlockPos pos : foundPositions) {
				BlockState state = serverWorld.getBlockState(pos);
				Block block = state.getBlock();
				var marker = new OreMarkerDisplay(serverWorld, pos, block, state);
				serverWorld.spawnEntity(marker);
			}
			user.sendMessage(Text.of("§aFound " + foundPositions.size() + " " + label + " block(s)."), true);
		}

		return ActionResult.SUCCESS;
	}

	public static class OreMarkerDisplay extends DisplayEntity.BlockDisplayEntity {
		private final BlockPos watchedPos;
		private final Block target;
		private int ticks = 0;

		public OreMarkerDisplay(ServerWorld world, BlockPos watchedPos, Block target, BlockState displayState) {
			super(EntityType.BLOCK_DISPLAY, world);
			this.watchedPos = watchedPos;
			this.target = target;

			setPosition(Vec3d.ofCenter(watchedPos));
			setBlockState(displayState);
			setGlowing(true);

			Vector3f translation = new Vector3f(-0.25f, -0.25f, -0.25f);
			Quaternionf leftRotation = new Quaternionf();
			Vector3f scale = new Vector3f(0.5f, 0.5f, 0.5f);
			Quaternionf rightRotation = new Quaternionf();

			AffineTransformation transformation = new AffineTransformation(translation, leftRotation, scale, rightRotation);
			this.setTransformation(transformation);
		}

		@Override
		public void tick() {
			super.tick();
			ticks++;
			//? let block entitys life for 30 seconds before they are gone
			if (ticks > 600 || !getWorld().getBlockState(watchedPos).isOf(target)) {
				this.discard();
			}
		}
	}
}
