package net.owen.AOTMod.networking.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraftforge.network.NetworkEvent;
import net.owen.AOTMod.client.menus.PlayerStatMenu;
import net.owen.AOTMod.client.menus.RaceSelectionScreen;

import java.util.function.Supplier;

public class OpenRaceMenuResponsePacket {
    private final boolean hasRace;

    public OpenRaceMenuResponsePacket(boolean hasRace) {
        this.hasRace = hasRace;
    }

    public OpenRaceMenuResponsePacket(FriendlyByteBuf buf) {
        this.hasRace = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBoolean(hasRace);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            if (!hasRace) {
                Minecraft.getInstance().setScreen(new RaceSelectionScreen(Component.literal("Select Your Race")));
            } else {
                Minecraft.getInstance().setScreen(new PlayerStatMenu(Minecraft.getInstance().player));
            }
        });
        return true;
    }
}