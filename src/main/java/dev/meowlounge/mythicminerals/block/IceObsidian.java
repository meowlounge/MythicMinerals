package dev.meowlounge.mythicminerals.block;

import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import static dev.meowlounge.mythicminerals.providers.RegisterProvider.registerBlock;

public class IceObsidian extends Block {
	public static final IntProperty AGE = IntProperty.of("age", 0, 3);

	public IceObsidian(Settings settings) {
		super(settings);
		this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0));
	}

	public static final Block ICE_OBSIDIAN = registerBlock("ice_obsidian",
			settings -> new IceObsidian(settings
					.mapColor(MapColor.BLACK)
					.instrument(NoteBlockInstrument.BASEDRUM)
					.strength(50.0F, 1200.0F)
					.requiresTool()
					.sounds(BlockSoundGroup.NETHER_ORE)));

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
		if (!world.isClient) {
			ServerWorld serverWorld = (ServerWorld) world;
			int delay = MathHelper.nextInt(world.getRandom(), 30, 60);
			serverWorld.scheduleBlockTick(pos, this, delay);
		}
	}

	@Override
	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		int meltProbability = 4;
		if (!(random.nextInt(meltProbability) == 0 && this.slightlyMelt(state, world, pos))) {
			int delay = MathHelper.nextInt(random, 5, 20);
			world.scheduleBlockTick(pos, this, delay);
		}
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}

	private boolean slightlyMelt(BlockState state, ServerWorld world, BlockPos pos) {
		final int MAX_AGE = 3;
		int currentAge = state.get(AGE);

		if (currentAge < MAX_AGE) {
			world.setBlockState(pos, state.with(AGE, currentAge + 1), Block.NOTIFY_ALL);
			return false;
		} else {
			this.melt(world, pos);
			return true;
		}
	}

	private void melt(ServerWorld world, BlockPos pos) {
		world.setBlockState(pos, Blocks.LAVA.getDefaultState(), Block.NOTIFY_ALL);
	}

	public static void registerIceObsidian() {
		MythicMinerals.LOGGER.info("⛏️ [MythicMinerals]: Registering Ice Obsidian Block");
	}
}
