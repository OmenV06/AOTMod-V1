package net.owen.AOTMod.entity.custom.brain;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.owen.AOTMod.entity.custom.*;

import java.util.List;

@Mod.EventBusSubscriber
public class TitanEntityInteraction {

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof Pillager) {
            setupPillagerAI((Pillager) event.getEntity());
        }
        else if (event.getEntity() instanceof Vindicator) {
            setupVindicatorAI((Vindicator) event.getEntity());
        }
        else if (event.getEntity() instanceof Evoker) {
            setupEvokerAI((Evoker) event.getEntity());
        }
        else if (event.getEntity() instanceof Witch) {
            setupWitchAI((Witch) event.getEntity());
        }
        else if (event.getEntity() instanceof Illusioner) {
            setupIllusionerAI((Illusioner) event.getEntity());
        }

    }

    private static final List<Class<? extends Mob>> TITAN_CLASSES = List.of(
            TitanFourOneEntity.class,
            TitanFourTwoEntity.class,
            TitanThreeOneEntity.class,
            TitanEightOneEntity.class,
            TitanFifteenOneEntity.class
    );

    private static void setupPillagerAI(Pillager mob) {
        TITAN_CLASSES.forEach(titanClass ->
                mob.targetSelector.addGoal(3, new NearestAttackableTargetGoal(mob, titanClass, true)));
    }

    private static void setupVindicatorAI(Vindicator mob) {
        TITAN_CLASSES.forEach(titanClass ->
                mob.targetSelector.addGoal(3, new NearestAttackableTargetGoal(mob, titanClass, true)));
    }

    private static void setupEvokerAI(Evoker mob) {
        TITAN_CLASSES.forEach(titanClass ->
                mob.targetSelector.addGoal(3, new NearestAttackableTargetGoal(mob, titanClass, true)));
    }

    private static void setupWitchAI(Witch mob) {
        TITAN_CLASSES.forEach(titanClass ->
                mob.targetSelector.addGoal(2, new NearestAttackableTargetGoal(mob, titanClass, true)));
    }

    private static void setupIllusionerAI(Illusioner mob) {
        TITAN_CLASSES.forEach(titanClass ->
                mob.targetSelector.addGoal(3, new NearestAttackableTargetGoal(mob, titanClass, true)));
    }

}