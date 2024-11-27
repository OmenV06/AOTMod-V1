package net.owen.AOTMod.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.owen.AOTMod.race.ackerman.AckermanPower;
import net.owen.AOTMod.race.eldian.EldianPower;
import net.owen.AOTMod.race.marleyan.MarleyanPower;
import net.owen.AOTMod.util.PlayerDataHandler;

import java.util.UUID;
import java.util.function.Supplier;

public class RaceC2SPacket {
    private UUID playerUUID;
    private String race;

    public RaceC2SPacket(UUID playerUUID, String race) {
        this.playerUUID = playerUUID;
        this.race = race;
    }

    public RaceC2SPacket(FriendlyByteBuf buf) {
        this.playerUUID = buf.readUUID();
        this.race = buf.readUtf(32767); // Read a string from the buffer
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeUUID(playerUUID);
        buf.writeUtf(race);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender().getServer().getPlayerList().getPlayer(this.playerUUID);

            if (player != null) {
                PlayerDataHandler.setPlayerRace(player, this.race); // Delegate to PlayerDataHandler
            }
        });
        return true;
    }
}
