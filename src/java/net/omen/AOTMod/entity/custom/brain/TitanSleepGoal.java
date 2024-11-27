package net.omen.AOTMod.entity.custom.brain;

import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import java.util.EnumSet;

public class TitanSleepGoal extends Goal {
    private final Mob mob;

    public TitanSleepGoal(Mob mob) {
        this.mob = mob;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
    }

    @Override
    public boolean canUse() {

        return !mob.level.isDay() || mob.level.getDifficulty() == Difficulty.PEACEFUL;
    }

    @Override
    public boolean canContinueToUse() {

        return !mob.level.isDay() || mob.level.getDifficulty() == Difficulty.PEACEFUL;
    }

    @Override
    public void start() {
        // Custom logic to initiate sleeping behavior
        // For example, setting the entity to a resting position
        // mob.setPose(Pose.SLEEPING); // Example: set the mob's pose to sleeping (if applicable)
    }

    @Override
    public void stop() {
        // Custom logic to stop sleeping behavior
        // mob.setPose(Pose.STANDING); // Reset the pose to standing (if applicable)
    }

    @Override
    public void tick() {

        mob.getNavigation().stop();
    }
}