package net.omen.AOTMod.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.omen.AOTMod.networking.ModPackets;
import net.omen.AOTMod.util.PlayerDataHandler;

import java.util.function.Supplier;

public class OpenRaceMenuPacket {
    public OpenRaceMenuPacket() {}

    public OpenRaceMenuPacket(FriendlyByteBuf buf) {
        // No data needed for this packet
    }

    public void toBytes(FriendlyByteBuf buf) {
        // No data needed for this packet
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {

            ServerPlayer player = context.getSender();
            if (player != null) {
                String race = PlayerDataHandler.getPlayerRace(player);
                if (!race.equals("Eldian") && !race.equals("Ackerman") && !race.equals("Marleyan") && !race.equals("Royal Eldian")) {
                    // Send a packet back to the client to open the race menu
                    ModPackets.sendToPlayer(new OpenRaceMenuResponsePacket(false), player);
                } else {
                    ModPackets.sendToPlayer(new OpenRaceMenuResponsePacket(true), player);
                }
            }

        });
        return true;
    }
}