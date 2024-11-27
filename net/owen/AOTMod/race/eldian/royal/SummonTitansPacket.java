package net.owen.AOTMod.race.eldian.royal;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;
import net.owen.AOTMod.entity.ModEntities;
import net.owen.AOTMod.entity.custom.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class SummonTitansPacket {


    public SummonTitansPacket() {

    }

    public SummonTitansPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {

            ServerPlayer player = context.getSender();
            if (player != null) {
                Level world = player.level;
                List<LivingEntity> entities = world.getEntitiesOfClass(
                        LivingEntity.class,
                        player.getBoundingBox().inflate(100.0),
                        this::canTransform
                );

                entities.forEach(this::transformEntity);
            }


        });
        return true;
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