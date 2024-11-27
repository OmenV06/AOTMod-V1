package net.owen.AOTMod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.owen.AOTMod.race.eldian.TitanDataHandler;
import net.owen.AOTMod.util.PlayerDataHandler;

public class AttackTitanSerumItem extends Item {

    public AttackTitanSerumItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!world.isClientSide && player instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) player;

            // Check if the player has the Eldian or Royal Eldian race
            String playerRace = PlayerDataHandler.getPlayerRace(serverPlayer);
            if (!"Eldian".equals(playerRace) && !"Royal Eldian".equals(playerRace)) {
                return InteractionResultHolder.fail(player.getItemInHand(hand));
            }

            TitanDataHandler titanData = TitanDataHandler.get(serverPlayer.getLevel());
            String currentHolder = titanData.getTitanHolder("Attack");
            if (currentHolder.isEmpty() || currentHolder.equals(serverPlayer.getStringUUID())) {
                titanData.setTitanHolder("Attack", serverPlayer.getStringUUID());

                // Consume the item
                player.getItemInHand(hand).shrink(1);

                // Apply any additional effects or powers here

                return InteractionResultHolder.success(player.getItemInHand(hand));
            }
        }
        return InteractionResultHolder.fail(player.getItemInHand(hand));
    }
}