package dev.meowlounge.mythicminerals.logic.locator;

import dev.meowlounge.mythicminerals.MythicMinerals;
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
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.world.World;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

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
	private static final ConcurrentHashMap<OreMarkerDisplay, Long> activeMarkers = new ConcurrentHashMap<>();

	/**
	 * Registers a server tick callback to handle despawning of OreMarkerDisplay entities.
	 * Call this during mod initialization.
	 */
	public static void registerTickHandler() {
		MythicMinerals.LOGGER.info("Registering server tick handler for OreMarkerDisplay despawning");
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			long currentTime = server.getOverworld().getTime();
			MythicMinerals.LOGGER.debug("Server tick: checking {} active markers at world time {}", activeMarkers.size(), currentTime);
			Iterator<ConcurrentHashMap.Entry<OreMarkerDisplay, Long>> iterator = activeMarkers.entrySet().iterator();
			while (iterator.hasNext()) {
				ConcurrentHashMap.Entry<OreMarkerDisplay, Long> entry = iterator.next();
				OreMarkerDisplay marker = entry.getKey();
				long creationTime = entry.getValue();
				long ticksElapsed = currentTime - creationTime;

				if (ticksElapsed >= 300 || !marker.getWorld().getBlockState(marker.watchedPos).isOf(marker.target)) {
					if (!marker.isRemoved()) {
						MythicMinerals.LOGGER.debug("Despawning marker at {} (ID: {}, ticks elapsed: {}, block present: {})",
								marker.watchedPos, marker.getId(), ticksElapsed,
								marker.getWorld().getBlockState(marker.watchedPos).isOf(marker.target));
						marker.discard();
					} else {
						MythicMinerals.LOGGER.debug("Marker at {} (ID: {}) already removed", marker.watchedPos, marker.getId());
					}
					iterator.remove();
				}
			}
			MythicMinerals.LOGGER.debug("Post-tick: {} markers remain active", activeMarkers.size());
		});
	}

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
		if (world.isClient) {
			MythicMinerals.LOGGER.debug("Item use called on client side, passing");
			return ActionResult.PASS;
		}

		ServerWorld serverWorld = (ServerWorld) world;
		Set<Block> targetBlockSet = Set.of(getTargetBlocks());
		String label = getDisplayName();
		MythicMinerals.LOGGER.info("Player {} used locator item ({}), searching for blocks: {}",
				user.getName().getString(), label, targetBlockSet);

		BlockPos origin = user.getBlockPos();
		BlockPos.Mutable mutablePos = new BlockPos.Mutable();
		Set<BlockPos> foundPositions = new HashSet<>(getMaxMarkers());

		final int radius = getRadius();
		final int maxMarkers = getMaxMarkers();
		MythicMinerals.LOGGER.debug("Searching within radius {} blocks, max markers {}", radius, maxMarkers);

		//* search in the radius that was selected and mark the block we search.
		outer:
		for (int dx = -radius; dx <= radius; dx++) {
			for (int dy = -radius; dy <= radius; dy++) {
				for (int dz = -radius; dz <= radius; dz++) {
					mutablePos.set(origin.getX() + dx, origin.getY() + dy, origin.getZ() + dz);
					BlockState state = serverWorld.getBlockState(mutablePos);
					if (targetBlockSet.contains(state.getBlock())) {
						foundPositions.add(mutablePos.toImmutable());
						MythicMinerals.LOGGER.debug("Found target block at {}", mutablePos);
						if (foundPositions.size() >= maxMarkers) break outer;
					}
				}
			}
		}

		if (foundPositions.isEmpty()) {
			user.sendMessage(Text.of("§cNo " + label + " found within " + radius + " blocks."), false);
			MythicMinerals.LOGGER.info("No {} blocks found within {} blocks for player {}", label, radius, user.getName().getString());
		} else {
			for (BlockPos pos : foundPositions) {
				BlockState state = serverWorld.getBlockState(pos);
				Block block = state.getBlock();
				var marker = new OreMarkerDisplay(serverWorld, pos, block, state);
				serverWorld.spawnEntity(marker);
				MythicMinerals.LOGGER.debug("Spawned marker at {} for block {}", pos, block);
			}
			user.sendMessage(Text.of("§aFound " + foundPositions.size() + " " + label + " block(s)."), true);
			MythicMinerals.LOGGER.info("Found and marked {} {} block(s) for player {}", foundPositions.size(), label, user.getName().getString());
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

		/**
		 * Constructor for the block display marker entity.
		 *
		 * @param world        the server world
		 * @param watchedPos   the position of the block being tracked
		 * @param target       the target block to verify presence
		 * @param displayState the block state to display visually
		 */
		public OreMarkerDisplay(ServerWorld world, BlockPos watchedPos, Block target, BlockState displayState) {
			super(EntityType.BLOCK_DISPLAY, world);
			this.watchedPos = watchedPos;
			this.target = target;

			setPosition(Vec3d.ofCenter(watchedPos));
			setBlockState(displayState);
			setGlowing(true);

			// Scale block display and move to middle of block.
			Vector3f translation = new Vector3f(-0.25f, -0.25f, -0.25f);
			Quaternionf leftRotation = new Quaternionf();
			Vector3f scale = new Vector3f(0.5f, 0.5f, 0.5f);
			Quaternionf rightRotation = new Quaternionf();

			AffineTransformation transformation = new AffineTransformation(translation, leftRotation, scale, rightRotation);
			this.setTransformation(transformation);

			// Add to global tracking with creation time
			activeMarkers.put(this, world.getTime());
			MythicMinerals.LOGGER.debug("Created marker at {} (ID: {}, block: {})", watchedPos, getId(), target);
		}

		/**
		 * Tick method to update the entity each game tick.
		 * Discards the entity if the block no longer exists.
		 */
		@Override
		public void tick() {
			super.tick();
			if (!getWorld().getBlockState(watchedPos).isOf(target)) {
				MythicMinerals.LOGGER.debug("Marker at {} (ID: {}) discarded: target block {} no longer present",
						watchedPos, getId(), target);
				this.discard();
				activeMarkers.remove(this);
			}
		}

		/**
		 * Called when the entity is removed, to clean up tracking.
		 */
		@Override
		public void onRemoved() {
			super.onRemoved();
			activeMarkers.remove(this);
			MythicMinerals.LOGGER.debug("Marker at {} (ID: {}) removed from tracking", watchedPos, getId());
		}
	}
}