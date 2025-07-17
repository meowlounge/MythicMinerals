package dev.meowlounge.mythicminerals.logic.armor.magmarit;

import dev.meowlounge.mythicminerals.item.FrostiumItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MagmaritLogic extends Item {
	@SuppressWarnings("unused")
	public MagmaritLogic(Settings settings) {
		super(settings);
	}

	@Override
	public void inventoryTick(ItemStack stack, ServerWorld world, net.minecraft.entity.Entity entity, @Nullable EquipmentSlot slot) {
		if (!(entity instanceof PlayerEntity player)) return;
		if (world.isClient) return;
		if (!hasFullMagmaritArmorOn(player)) return;

		if (world.getRegistryKey() == ServerWorld.END) return;

		//? add logic for placing obsidian

		super.inventoryTick(stack, world, entity, slot);
	}

	private boolean hasFullMagmaritArmorOn(@NotNull PlayerEntity player) {
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