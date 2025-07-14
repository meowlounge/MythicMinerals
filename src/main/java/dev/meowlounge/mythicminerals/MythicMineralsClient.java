package dev.meowlounge.mythicminerals;

import dev.meowlounge.mythicminerals.logic.armor.stellarium.ModMessages;
import dev.meowlounge.mythicminerals.logic.armor.stellarium.StellariumLogic;
import dev.meowlounge.mythicminerals.network.payload.StellariumBoostPayload;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class MythicMineralsClient implements ClientModInitializer {
	private static KeyBinding boostKey;

	@Override
	public void onInitializeClient() {
		boostKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.mythicminerals.boost",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_X,
				"mythicminerals"
		));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (boostKey.wasPressed()) {
				ClientPlayNetworking.send(new StellariumBoostPayload());
				ServerTickEvents.END_SERVER_TICK.register(StellariumLogic::onServerTick);
			}
		});
	}
}