package dev.meowlounge.mythicminerals.logic;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import org.jetbrains.annotations.Nullable;

import static dev.meowlounge.mythicminerals.item.FrostiumItems.*;

public class FrostiumLogic extends Item {
	private static final int RADIUS = 5;
	private static final StatusEffectInstance SLOWNESS = new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 1, true, false);

	public FrostiumLogic(Settings settings) {
		super(settings);
	}

	@Override
	public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
		if (!world.isClient() && entity instanceof PlayerEntity player) {
			if (hasFullFrostiumArmorOn(player)) {
				System.out.println("[FROSTIUM] " + player.getName().getString() + " is wearing full Frostium armor.");
				applySlownessToNearbyMobs(world, player);
			}
		}

		super.inventoryTick(stack, world, entity, slot);
	}

	private void applySlownessToNearbyMobs(ServerWorld world, PlayerEntity player) {
		Box box = new Box(player.getBlockPos()).expand(RADIUS);
		for (MobEntity mob : world.getEntitiesByClass(MobEntity.class, box, mob -> mob.isAlive() && !mob.hasStatusEffect(StatusEffects.SLOWNESS))) {
			mob.addStatusEffect(SLOWNESS);
			System.out.println("[FROSTIUM] Applied slowness to mob: " + mob.getName().getString() + " at " + mob.getBlockPos());
		}
	}

	private boolean hasFullFrostiumArmorOn(PlayerEntity player) {
		ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
		ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
		ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
		ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);

		if (boots.isEmpty() || leggings.isEmpty() || chestplate.isEmpty() || helmet.isEmpty()) {
			return false;
		}

		return boots.getItem() == FROSTIUM_BOOTS &&
				leggings.getItem() == FROSTIUM_LEGGINGS &&
				chestplate.getItem() == FROSTIUM_CHESTPLATE &&
				helmet.getItem() == FROSTIUM_HELMET;
	}
}