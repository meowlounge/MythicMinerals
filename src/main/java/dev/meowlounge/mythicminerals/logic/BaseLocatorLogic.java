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
import net.minecraft.util.Identifier;
import net.minecraft.util.math.AffineTransformation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.HashSet;
import java.util.Set;

/**
 * Abstract base class for ore locator items that search for specific blocks in a given radius,
 * display block markers in the world, and restrict usage to a configured dimension.
 * <p>
 * Extend this class and override key methods to customize:
 * - Target blocks to locate
 * - Display name for user messages
 * - Search radius and maximum displayed markers
 * - Dimension where the locator is functional
 */
public abstract class BaseLocatorLogic extends Item {

	/**
	 * Constructor passing item settings to the superclass.
	 *
	 * @param settings item settings
	 */
	public BaseLocatorLogic(Settings settings) {
		super(settings);
	}

	/**
	 * Get the radius in blocks within which to search for target blocks.
	 * Override to provide custom radius.
	 *
	 * @return search radius (default 64)
	 */
	protected int getRadius() {
		return 64;
	}

	/**
	 * Get the maximum number of markers to display simultaneously.
	 * Override to provide custom max count.
	 *
	 * @return maximum markers (default 128)
	 */
	protected int getMaxMarkers() {
		return 128;
	}

	/**
	 * Get the dimension identifier where this locator item is allowed to function.
	 * Players outside this dimension will not be able to use the locator.
	 * Must be overridden.
	 *
	 * @return the dimension's Identifier
	 */
	protected abstract Identifier getDimension();

	/**
	 * Get the blocks this locator is searching for.
	 * Must be overridden.
	 *
	 * @return array of target blocks
	 */
	protected abstract Block[] getTargetBlocks();

	/**
	 * Get the display name for the locator, used in player messages.
	 * Must be overridden.
	 *
	 * @return display name string (e.g. "§3Stellarium Ore")
	 */
	protected abstract String getDisplayName();

	/**
	 * Handles item usage: searches for target blocks within radius,
	 * verifies dimension, spawns display markers, and sends feedback to player.
	 */
	@Override
	public ActionResult use(World world, PlayerEntity user, Hand hand) {
		if (world.isClient) return ActionResult.PASS;

		//* check if player is in the same dimension.
		if (!world.getRegistryKey().getValue().equals(getDimension())) {
			user.sendMessage(Text.of("§cYou are in the wrong dimension for this locator."), false);
			return ActionResult.FAIL;
		}

		ServerWorld serverWorld = (ServerWorld) world;
		Set<Block> targetBlockSet = Set.of(getTargetBlocks());
		String label = getDisplayName();

		BlockPos origin = user.getBlockPos();
		BlockPos.Mutable mutablePos = new BlockPos.Mutable();
		Set<BlockPos> foundPositions = new HashSet<>(getMaxMarkers());

		final int radius = getRadius();
		final int maxMarkers = getMaxMarkers();

		//* search in the radius that was selected and mark the block we search.
		outer:
		for (int dx = -radius; dx <= radius; dx++) {
			for (int dy = -radius; dy <= radius; dy++) {
				for (int dz = -radius; dz <= radius; dz++) {
					mutablePos.set(origin.getX() + dx, origin.getY() + dy, origin.getZ() + dz);
					BlockState state = serverWorld.getBlockState(mutablePos);
					if (targetBlockSet.contains(state.getBlock())) {
						foundPositions.add(mutablePos.toImmutable());
						if (foundPositions.size() >= maxMarkers) break outer;
					}
				}
			}
		}

		if (foundPositions.isEmpty()) {
			user.sendMessage(Text.of("§cNo " + label + " found within " + radius + " blocks."), false);
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

	/**
	 * A BlockDisplayEntity that visually marks a located ore block.
	 * Displays the block with reduced scale and glowing effect.
	 * Automatically despawns after 15 seconds or if the block is removed.
	 */
	public static class OreMarkerDisplay extends DisplayEntity.BlockDisplayEntity {
		private final BlockPos watchedPos;
		private final Block target;
		private int ticks = 0;

		/**
		 * Constructor for the block display marker entity.
		 *
		 * @param world         the server world
		 * @param watchedPos    the position of the block being tracked
		 * @param target        the target block to verify presence
		 * @param displayState  the block state to display visually
		 */
		public OreMarkerDisplay(ServerWorld world, BlockPos watchedPos, Block target, BlockState displayState) {
			super(EntityType.BLOCK_DISPLAY, world);
			this.watchedPos = watchedPos;
			this.target = target;

			setPosition(Vec3d.ofCenter(watchedPos));
			setBlockState(displayState);
			setGlowing(true);

			//* scale block display and move to middle of block.
			Vector3f translation = new Vector3f(-0.25f, -0.25f, -0.25f);
			Quaternionf leftRotation = new Quaternionf();
			Vector3f scale = new Vector3f(0.5f, 0.5f, 0.5f);
			Quaternionf rightRotation = new Quaternionf();

			AffineTransformation transformation = new AffineTransformation(translation, leftRotation, scale, rightRotation);
			this.setTransformation(transformation);
		}

		/**
		 * Tick method to update the entity each game tick.
		 * Discards the entity after 300 ticks (15 seconds) or if the block no longer exists.
		 */
		@Override
		public void tick() {
			super.tick();
			ticks++;
			if (ticks > 300 || !getWorld().getBlockState(watchedPos).isOf(target)) {
				this.discard();
			}
		}
	}
}
