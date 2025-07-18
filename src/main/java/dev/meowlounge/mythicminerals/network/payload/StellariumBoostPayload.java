package dev.meowlounge.mythicminerals.network.payload;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

import static dev.meowlounge.mythicminerals.MythicMinerals.id;

public record StellariumBoostPayload() implements CustomPayload {
	public static final Id<StellariumBoostPayload> ID = new Id<>(id("stellarium_boost"));

	public static final CustomPayload.Type<PacketByteBuf, StellariumBoostPayload> TYPE =
			new Type<>(ID, PacketCodec.of(
					(buf, payload) -> {
					},
					buf -> new StellariumBoostPayload()
			));

	@Override
	public Id<? extends CustomPayload> getId() {
		return ID;
	}
}
