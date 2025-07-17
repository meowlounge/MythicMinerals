package dev.meowlounge.mythicminerals.enchantment;

import com.mojang.serialization.MapCodec;
import dev.meowlounge.mythicminerals.MythicMinerals;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EnchantmentsEffects {
	@SuppressWarnings({"SameParameterValue", "unused"})
	private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
																					MapCodec<? extends EnchantmentEntityEffect> codec) {
		return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(MythicMinerals.MOD_ID, name), codec);
	}

	public static void registerEnchantmentEffects() {
		MythicMinerals.LOGGER.info("Registering Mod Enchantment Effects for " + MythicMinerals.MOD_ID);
	}
}
