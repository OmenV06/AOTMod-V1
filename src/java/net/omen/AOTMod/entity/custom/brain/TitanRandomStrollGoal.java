package net.omen.AOTMod.entity.custom.brain;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;

public class TitanRandomStrollGoal extends RandomStrollGoal {
    private final Mob mob;

    public TitanRandomStrollGoal(PathfinderMob mob, double speed) {
        super(mob, speed);
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
        return super.canUse() && mob.getTarget() == null;
    }
}