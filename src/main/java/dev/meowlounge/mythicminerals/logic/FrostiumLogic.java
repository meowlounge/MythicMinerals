package dev.meowlounge.mythicminerals.logic;

import dev.meowlounge.mythicminerals.item.Armor;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import org.jetbrains.annotations.Nullable;

public class FrostiumLogic extends Item {
	private static final int RADIUS = 3;
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
			mob.addStatusEffect(new StatusEffectInstance(SLOWNESS));
			System.out.println("[FROSTIUM] Applied slowness to mob: " + mob.getName().getString() + " at " + mob.getBlockPos());
		}
	}

	private boolean hasFullFrostiumArmorOn(PlayerEntity player) {
		ItemStack boots = player.getInventory().getStack(EquipmentSlot.FEET.getIndex());
		ItemStack leggings = player.getInventory().getStack(EquipmentSlot.LEGS.getIndex());
		ItemStack chestplate = player.getInventory().getStack(EquipmentSlot.CHEST.getIndex());
		ItemStack helmet = player.getInventory().getStack(EquipmentSlot.HEAD.getIndex());

		if (boots.isEmpty() || leggings.isEmpty() || chestplate.isEmpty() || helmet.isEmpty()) {
			return false;
		}

		EquippableComponent bootsComp = boots.getComponents().get(DataComponentTypes.EQUIPPABLE);
		EquippableComponent legsComp = leggings.getComponents().get(DataComponentTypes.EQUIPPABLE);
		EquippableComponent chestComp = chestplate.getComponents().get(DataComponentTypes.EQUIPPABLE);
		EquippableComponent helmetComp = helmet.getComponents().get(DataComponentTypes.EQUIPPABLE);

		if (bootsComp == null || legsComp == null || chestComp == null || helmetComp == null) {
			return false;
		}

		ArmorMaterial frostium = Armor.FROSTIUM_ARMOR_MATERIAL;

		return bootsComp.assetId().get().equals(frostium.assetId())
				&& legsComp.assetId().get().equals(frostium.assetId())
				&& chestComp.assetId().get().equals(frostium.assetId())
				&& helmetComp.assetId().get().equals(frostium.assetId());
	}
}
