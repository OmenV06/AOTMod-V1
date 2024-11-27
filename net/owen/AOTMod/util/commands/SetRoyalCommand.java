package net.owen.AOTMod.util.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.owen.AOTMod.util.PlayerDataHandler;

public class SetRoyalCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("AOTMod")
                .then(Commands.literal("Race")
                        .then(Commands.literal("Royal")
                                .then(Commands.argument("setRoyal", BoolArgumentType.bool())
                                        .then(Commands.argument("player", StringArgumentType.string())
                                                .executes(SetRoyalCommand::execute))
                                )
                        )
                )
        );
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        boolean setRoyal = BoolArgumentType.getBool(context, "setRoyal");
        String playerName = StringArgumentType.getString(context, "player");
        ServerPlayer player = context.getSource().getServer().getPlayerList().getPlayerByName(playerName);

        if (player != null) {
            String currentRace = PlayerDataHandler.getPlayerRace(player);
            if ("Eldian".equals(currentRace) && setRoyal) {
                PlayerDataHandler.setPlayerRace(player, "Royal Eldian");
                context.getSource().sendSuccess(Component.literal("Player " + playerName + " is now Royal Eldian"), false);
            } else if ("Royal Eldian".equals(currentRace) && !setRoyal) {
                PlayerDataHandler.setPlayerRace(player, "Eldian");
                context.getSource().sendSuccess(Component.literal("Player " + playerName + " is now Eldian"), false);
            } else {
                context.getSource().sendFailure(Component.literal("Incorrect Command Usage"));
            }
        } else {
            context.getSource().sendFailure(Component.literal("Player not found"));
        }

        return 1;
    }
}