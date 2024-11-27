package net.omen.AOTMod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.omen.AOTMod.entity.ModEntities;
import net.omen.AOTMod.entity.custom.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class TitanSerumItem extends Item {
    public TitanSerumItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        if (!player.level.isClientSide) {
            if (canTransform(target)) {
                transformEntity(target);
                stack.shrink(1); // Optional: consume the item
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    private boolean canTransform(LivingEntity entity) {
        // Define which entities can be transformed
        return entity instanceof Villager ||
                entity instanceof Pillager ||
                entity instanceof Vindicator ||
                entity instanceof Witch ||
                entity instanceof Evoker ||
                entity instanceof WanderingTrader;
    }

    private void transformEntity(LivingEntity entity) {
        Level world = entity.level;
        Entity newEntity = getRandomTitan(world);

        if (newEntity != null) {
            // Spawn new entity at the location of the original one
            newEntity.moveTo(entity.getX(), entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
            world.addFreshEntity(newEntity);
            entity.discard(); // Remove the original entity
        }
    }

    private Entity getRandomTitan(Level world) {
        List<Function<Level, ? extends Entity>> titanTypes = Arrays.asList(
                level -> new TitanFourOneEntity(ModEntities.TITAN_FOUR_ONE.get(), level),
                level -> new TitanFourTwoEntity(ModEntities.TITAN_FOUR_TWO.get(), level),
                level -> new TitanThreeOneEntity(ModEntities.TITAN_THREE_ONE.get(), level),
                level -> new TitanEightOneEntity(ModEntities.TITAN_EIGHT_ONE.get(), level),
                level -> new TitanFifteenOneEntity(ModEntities.TITAN_FIFTEEN_ONE.get(), level)
                // Add more Titan types here
        );

        Random random = new Random();
        Function<Level, ? extends Entity> titanCreator = titanTypes.get(random.nextInt(titanTypes.size()));
        return titanCreator.apply(world);
    }
}