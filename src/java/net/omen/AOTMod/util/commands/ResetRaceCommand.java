package net.omen.AOTMod.util.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.omen.AOTMod.util.PlayerDataHandler;

public class ResetRaceCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("AOTMod")
                .then(Commands.literal("Race")
                        .then(Commands.literal("Reset")
                                .then(Commands.argument("player", StringArgumentType.string())
                                        .executes(ResetRaceCommand::execute))
                        )
                ));
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        String playerName = StringArgumentType.getString(context, "player");
        ServerPlayer player = context.getSource().getServer().getPlayerList().getPlayerByName(playerName);

        if (player != null) {
            // Reset the player's race using PlayerDataHandler
            PlayerDataHandler.setPlayerRace(player, "None");
            context.getSource().sendSuccess(Component.literal(playerName + "'s race has been reset to: None"), false);
        } else {
            context.getSource().sendFailure(Component.literal("Player not found"));
        }

        return 1; // Command success
    }
}