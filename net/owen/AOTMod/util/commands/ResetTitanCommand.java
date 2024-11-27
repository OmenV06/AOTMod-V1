package net.owen.AOTMod.util.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.owen.AOTMod.race.eldian.TitanDataHandler;
import net.owen.AOTMod.race.eldian.TitanNames;

public class ResetTitanCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("AOTMod")
                .then(Commands.literal("Titan")
                        .then(Commands.literal("Reset")
                                .then(Commands.argument("player", StringArgumentType.string())
                                        .executes(ResetTitanCommand::execute))
                        )
                ));
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        String playerName = StringArgumentType.getString(context, "player");
        ServerPlayer player = context.getSource().getServer().getPlayerList().getPlayerByName(playerName);

        if (player != null) {
            TitanDataHandler titanData = TitanDataHandler.get(player.getLevel());
            boolean resetPerformed = false;

            for (String titanName : TitanNames.TITAN_NAMES) {
                if (player.getStringUUID().equals(titanData.getTitanHolder(titanName))) {
                    titanData.setTitanHolder(titanName, "");
                    resetPerformed = true;
                }
            }

            if (resetPerformed) {
                context.getSource().sendSuccess(Component.literal(playerName + "'s Titan has been reset"), false);
            } else {
                context.getSource().sendSuccess(Component.literal(playerName + " does not hold any Titan power"), false);
            }
        } else {
            context.getSource().sendFailure(Component.literal("Player not found"));
        }

        return 1; // Command success
    }
}