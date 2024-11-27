package net.owen.AOTMod.networking.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SyncPlayerRacePacket {
    private final String race;
    private static String clientPlayerRace = "None"; // Client-side race storage


    public SyncPlayerRacePacket(String race) {
        this.race = race;
    }

    public SyncPlayerRacePacket(FriendlyByteBuf buf) {
        this.race = buf.readUtf(32767);
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeUtf(race);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            Player clientPlayer = Minecraft.getInstance().player;
            if (clientPlayer != null) {
                clientPlayerRace = race; // Update client-side race storage
            }
        });
        return true;
    }

    public static String getClientPlayerRace() {
        return clientPlayerRace;
    }
}