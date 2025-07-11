package dev.meowlounge.mythicminerals.logic;

import dev.meowlounge.mythicminerals.item.FrostiumItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

public class FrostiumLogic extends Item {
	public FrostiumLogic(Settings settings) {
		super(settings);
	}

	@Override
	public void inventoryTick(ItemStack stack, ServerWorld world, net.minecraft.entity.Entity entity, @Nullable EquipmentSlot slot) {
		if (!(entity instanceof PlayerEntity player)) return;
		if (world.isClient) return;

		if (hasFullFrostiumArmorOn(player)) {
			grantColdArmorEffects(player);

//			if (isInNether(world)) {
//				applyNetherPenalties(player);
//			}
		}

		super.inventoryTick(stack, world, entity, slot);
	}

	private void grantColdArmorEffects(PlayerEntity player) {
		//* player cant burn since the armor cools him down.
		player.setOnFireFor(0);
	}

//	TODO: add logic to debuff player in nether when frostium armor is on.
//	private void applyNetherPenalties(PlayerEntity player) {
//		player.setOnFireFor(0);
//	}

//	private boolean isInNether(ServerWorld world) {
//		return world.getRegistryKey().getRegistry().getPath().equals("the_nether");
//	}

	private boolean hasFullFrostiumArmorOn(PlayerEntity player) {
		ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
		ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
		ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
		ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);

		return boots.getItem() == FrostiumItems.FROSTIUM_BOOTS &&
				leggings.getItem() == FrostiumItems.FROSTIUM_LEGGINGS &&
				chestplate.getItem() == FrostiumItems.FROSTIUM_CHESTPLATE &&
				helmet.getItem() == FrostiumItems.FROSTIUM_HELMET;
	}
}
