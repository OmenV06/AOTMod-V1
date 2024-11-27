package net.omen.AOTMod.networking;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.omen.AOTMod.AOTMod;
import net.omen.AOTMod.networking.packet.*;
import net.omen.AOTMod.race.eldian.royal.SummonTitansPacket;

public class ModPackets {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(AOTMod.MOD_ID, "packets"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(RaceC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(RaceC2SPacket::new)
                .encoder(RaceC2SPacket::toBytes)
                .consumerMainThread(RaceC2SPacket::handle)
                .add();

        net.messageBuilder(OpenRaceMenuPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(OpenRaceMenuPacket::new)
                .encoder(OpenRaceMenuPacket::toBytes)
                .consumerMainThread(OpenRaceMenuPacket::handle)
                .add();

        net.messageBuilder(OpenRaceMenuResponsePacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(OpenRaceMenuResponsePacket::new)
                .encoder(OpenRaceMenuResponsePacket::toBytes)
                .consumerMainThread(OpenRaceMenuResponsePacket::handle)
                .add();

        net.messageBuilder(SyncPlayerRacePacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(SyncPlayerRacePacket::new)
                .encoder(SyncPlayerRacePacket::toBytes)
                .consumerMainThread(SyncPlayerRacePacket::handle)
                .add();

        net.messageBuilder(SummonTitansPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(SummonTitansPacket::new)
                .encoder(SummonTitansPacket::toBytes)
                .consumerMainThread(SummonTitansPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

}
