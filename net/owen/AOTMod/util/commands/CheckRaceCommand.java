package net.owen.AOTMod.util.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.owen.AOTMod.util.PlayerDataHandler;

public class CheckRaceCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("AOTMod")
                .then(Commands.literal("Race")
                        .then(Commands.literal("Check")
                                .then(Commands.argument("player", StringArgumentType.string())
                                        .executes(CheckRaceCommand::execute))
                        )
                ));
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        String playerName = StringArgumentType.getString(context, "player");
        ServerPlayer player = context.getSource().getServer().getPlayerList().getPlayerByName(playerName);

        if (player != null) {
            String race = PlayerDataHandler.getPlayerRace(player);
            race = race.isEmpty() ? "None" : race;
            context.getSource().sendSuccess(Component.literal(playerName + "'s race is: " + race), false);
        } else {
            context.getSource().sendFailure(Component.literal("Player not found"));
        }

        return 1; // Command success
    }
}
