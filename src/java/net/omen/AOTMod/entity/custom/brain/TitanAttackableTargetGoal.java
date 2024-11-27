package net.omen.AOTMod.entity.custom.brain;

import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class TitanAttackableTargetGoal extends TargetGoal {
    private final Class<? extends LivingEntity> targetClass;
    private final double targetRange;
    private int recheckDelay;

    public TitanAttackableTargetGoal(Mob mob, Class<? extends LivingEntity> targetClass, double targetRange) {
        super(mob, false, false);
        this.targetClass = targetClass;
        this.targetRange = targetRange;
        this.recheckDelay = 400;
    }

    @Override
    public boolean canUse() {
        return findNewTarget();
    }

    @Override
    public boolean canContinueToUse() {
        LivingEntity currentTarget = mob.getTarget();
        return currentTarget != null && currentTarget.isAlive() && mob.distanceToSqr(currentTarget) <= targetRange * targetRange;
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void tick() {
        if (--recheckDelay <= 0) {
            recheckDelay = 400;
            findNewTarget();
        }
    }

    private boolean findNewTarget() {
        List<? extends LivingEntity> potentialTargets = mob.level.getEntitiesOfClass(targetClass,
                mob.getBoundingBox().inflate(targetRange), this::isSuitableTarget);

        if (potentialTargets.isEmpty()) {
            return false;
        }


        LivingEntity closestTarget = null;
        double closestDistance = Double.MAX_VALUE;
        for (LivingEntity potentialTarget : potentialTargets) {
            double distance = mob.distanceToSqr(potentialTarget);
            if (distance < closestDistance) {
                closestTarget = potentialTarget;
                closestDistance = distance;
            }
        }

        if (closestTarget != null && closestTarget != mob.getTarget()) {
            mob.setTarget(closestTarget);
            return true;
        }
        return false;
    }

    private boolean isSuitableTarget(LivingEntity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            return !player.isCreative() && !player.isSpectator();
        } else if (entity instanceof Witch) {

            return mob.hasLineOfSight(entity);
        }
        return true;
    }
}