package net.omen.AOTMod.util.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.omen.AOTMod.race.eldian.TitanDataHandler;
import net.omen.AOTMod.race.eldian.TitanNames;

public class CheckTitanCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("AOTMod")
                .then(Commands.literal("Titan")
                        .then(Commands.literal("Check")
                                .then(Commands.argument("player", StringArgumentType.string())
                                        .executes(CheckTitanCommand::execute))
                        )
                ));
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        String playerName = StringArgumentType.getString(context, "player");
        ServerPlayer player = context.getSource().getServer().getPlayerList().getPlayerByName(playerName);

        if (player != null) {
            TitanDataHandler titanData = TitanDataHandler.get(player.getLevel());
            String playerUUID = player.getStringUUID();
            StringBuilder titanList = new StringBuilder();

            for (String titanName : TitanNames.TITAN_NAMES) {
                if (playerUUID.equals(titanData.getTitanHolder(titanName))) {
                    if (titanList.length() > 0) {
                        titanList.append(", ");
                    }
                    titanList.append(titanName);
                }
            }

            String result = titanList.length() > 0 ? titanList.toString() : "None";
            context.getSource().sendSuccess(Component.literal(playerName + "Holds: " + result), false);
        } else {
            context.getSource().sendFailure(Component.literal("Player not found"));
        }

        return 1; // Command success
    }
}
