package dev.meowlounge.mythicminerals.enchantment;

import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.enchantment.effects.LavaWalkerEffect;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class Enchantments {
	public static final RegistryKey<Enchantment> LAVA_WALKER =
			RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(MythicMinerals.MOD_ID, "lava_walker"));

	public static void bootstrap(Registerable<Enchantment> registerable) {
		var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
		var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

		register(registerable, LAVA_WALKER, Enchantment.builder(Enchantment.definition(
						items.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE), //? doof = good = food
						5,
						2,
						Enchantment.leveledCost(5, 7),
						Enchantment.leveledCost(25, 9),
						2,
						AttributeModifierSlot.FEET))
				.exclusiveSet(enchantments.getOrThrow(EnchantmentTags.BOOTS_EXCLUSIVE_SET))
				.addEffect(EnchantmentEffectComponentTypes.TICK,
						new LavaWalkerEffect()));
	}

	@SuppressWarnings("SameParameterValue")
	private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
		registry.register(key, builder.build(key.getValue()));
	}
}
