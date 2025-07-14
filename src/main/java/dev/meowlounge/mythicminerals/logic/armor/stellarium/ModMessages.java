package dev.meowlounge.mythicminerals.logic.armor.stellarium;

import dev.meowlounge.mythicminerals.network.payload.StellariumBoostPayload;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class ModMessages {
	public static void registerC2SPackets() {
		ServerPlayNetworking.registerGlobalReceiver(StellariumBoostPayload.ID, (payload, context) -> {
			StellariumLogic.tryBoost(context.player());
		});
	}
}