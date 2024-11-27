package net.owen.AOTMod.util;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.owen.AOTMod.networking.ModPackets;
import net.owen.AOTMod.networking.packet.SyncPlayerRacePacket;
import net.owen.AOTMod.race.ackerman.AckermanPower;

@Mod.EventBusSubscriber
public class PlayerDataHandler {

    private static final String PLAYER_RACE_TAG = "PlayerRace";

    public static void setPlayerRace(ServerPlayer player, String race) {
        CompoundTag playerData = player.getPersistentData();
        playerData.putString(PLAYER_RACE_TAG, race);
        applyRacePowers(player, race);
        ModPackets.sendToPlayer(new SyncPlayerRacePacket(race), player);
    }

    public static String getPlayerRace(ServerPlayer player) {
        CompoundTag playerData = player.getPersistentData();
        return playerData.getString(PLAYER_RACE_TAG);
    }


    private static void applyRacePowers(ServerPlayer player, String race) {
        switch (race) {
            case "Ackerman":
                AckermanPower.applyPowers(player);
                break;
            // Handle other races here
            default:
                // Optional: Remove all race powers if race is "None" or unrecognized
                AckermanPower.removePowers(player);
                // Remove powers for other races as needed
                break;
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            ServerPlayer oldPlayer = (ServerPlayer) event.getOriginal();
            ServerPlayer newPlayer = (ServerPlayer) event.getEntity();

            String race = getPlayerRace(oldPlayer);
            setPlayerRace(newPlayer, race);
        }
    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer) {
            ServerPlayer player = (ServerPlayer) event.getEntity();
            String race = PlayerDataHandler.getPlayerRace(player);
            PlayerDataHandler.applyRacePowers(player, race); // Reapply powers based on the race
            ModPackets.sendToPlayer(new SyncPlayerRacePacket(race), player);
        }
    }

}