package dev.meowlounge.mythicminerals.enchantment;

import com.mojang.serialization.MapCodec;
import dev.meowlounge.mythicminerals.MythicMinerals;
import dev.meowlounge.mythicminerals.enchantment.custom.LavaWalkerEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EnchantmentEffects {
	public static final MapCodec<? extends EnchantmentEntityEffect> LAVA_WALKER =
			registerEntityEffect();


	private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect() {
		return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(MythicMinerals.MOD_ID, "lava_walker"), (MapCodec<? extends EnchantmentEntityEffect>) LavaWalkerEnchantmentEffect.CODEC);
	}

	@SuppressWarnings("EmptyMethod")
	public static void registerEnchantmentEffects() {
		//? registration triggered on class load
	}
}
