package net.owen.AOTMod.entity.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.owen.AOTMod.entity.custom.brain.TitanAttackableTargetGoal;
import net.owen.AOTMod.entity.custom.brain.TitanRandomStrollGoal;
import net.owen.AOTMod.entity.custom.brain.TitanSleepGoal;
import net.owen.AOTMod.sounds.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class TitanFourOneEntity extends Animal {
    public TitanFourOneEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

    }

    private boolean isFirstTimeSpawned = true;

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();

        if (!this.level.isClientSide && isFirstTimeSpawned) {

            this.level.explode(this, this.getX(), this.getY(), this.getZ(), 2.0F, Explosion.BlockInteraction.NONE);
            spawnFormSteamParticles();

            this.playSound(ModSounds.TITAN_TRANSFORMATION_SOUND.get(), 6F, 1F);

            if (this.level instanceof ServerLevel) {
                ServerLevel serverLevel = (ServerLevel) this.level;
                LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(serverLevel);
                if (lightningBolt != null) {
                    lightningBolt.moveTo(this.getX(), this.getY(), this.getZ());
                    lightningBolt.setVisualOnly(true);
                    serverLevel.addFreshEntity(lightningBolt);
                }
            }
                isFirstTimeSpawned = false;
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("IsFirstTimeSpawned", isFirstTimeSpawned);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("IsFirstTimeSpawned")) {
            isFirstTimeSpawned = compound.getBoolean("IsFirstTimeSpawned");
        }
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(0, new TitanSleepGoal(this));

        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.20, false));

        this.goalSelector.addGoal(2, new TitanAttackableTargetGoal(this, Player.class, 100));
        this.goalSelector.addGoal(2, new TitanAttackableTargetGoal(this, AbstractVillager.class, 100));
        this.goalSelector.addGoal(2, new TitanAttackableTargetGoal(this, Witch.class, 100));
        this.goalSelector.addGoal(2, new TitanAttackableTargetGoal(this, Pillager.class, 100));
        this.goalSelector.addGoal(2, new TitanAttackableTargetGoal(this, Evoker.class, 100));
        this.goalSelector.addGoal(2, new TitanAttackableTargetGoal(this, Vindicator.class, 100));
        this.goalSelector.addGoal(2, new TitanAttackableTargetGoal(this, WanderingTrader.class, 100));
        this.goalSelector.addGoal(2, new TitanAttackableTargetGoal(this, Illusioner.class, 100));

        this.goalSelector.addGoal(3, new TitanRandomStrollGoal(this, 1));

        this.goalSelector.addGoal(4, new FloatGoal(this));

        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 15f, 1f));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Mob.class, 15f, 1f));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 100)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ARMOR, 15f)
                .add(Attributes.ARMOR_TOUGHNESS, 5f)
                .add(Attributes.ATTACK_DAMAGE, 8f)
                .add(Attributes.ATTACK_KNOCKBACK, 1f)
                .add(Attributes.FOLLOW_RANGE, 100)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.7f);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {

        if (source == DamageSource.DROWN) {
            return true;
        }

        return super.isInvulnerableTo(source);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.RAVAGER_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.RAVAGER_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.RAVAGER_DEATH;
    }

    private int regenCooldown = 0;

    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.level.isClientSide) {
            if (regenCooldown <= 0) {
                this.regenCooldown = 20;
                this.performRegeneration();
            } else {
                regenCooldown--;
            }


            if (this.isInWater()) {

                this.setSwimming(true);
                this.setSpeed(5.0F);


                spawnWaterSteamParticles();
            } else {
                this.setSwimming(false);
            }

        }
    }


    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return 3.75F;
    }

    private void performRegeneration() {

        if (this.getHealth() < this.getMaxHealth()) {
            this.heal(1);
            spawnRegenerationParticles(this);
        }
    }

    private static void spawnRegenerationParticles(TitanFourOneEntity titan) {

        double particleY = titan.getY() + 2.75D;

        ((ServerLevel)titan.level).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                titan.getX(), particleY, titan.getZ(),
                15, 0.5D, 1.0D, 0.5D, 0.0D);
    }

    @Override
    public void die(DamageSource cause) {
        super.die(cause);
        if (!this.level.isClientSide) {
            spawnFormSteamParticles();
        }
    }

    private void spawnFormSteamParticles() {
        final int particleCount = 200;
        final double radius = 2.5;
        Random random = new Random();

        for (int i = 0; i < particleCount; i++) {
            double offsetX = (random.nextDouble() * 2 - 1) * radius;
            double offsetY = (random.nextDouble() * 2) * radius;
            double offsetZ = (random.nextDouble() * 2 - 1) * radius;

            ((ServerLevel)this.level).sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,
                    this.getX() + offsetX, this.getY() + offsetY, this.getZ() + offsetZ,
                    1, 0, 0, 0, 0.0D);
        }
    }

    private void spawnWaterSteamParticles() {
        final int particleCount = 2;
        final double radius = 2.0;
        Random random = new Random();

        for (int i = 0; i < particleCount; i++) {
            double offsetX = (random.nextDouble() * 2 - 1) * radius;
            double offsetY = (random.nextDouble() * 1) * radius;
            double offsetZ = (random.nextDouble() * 2 - 1) * radius;

            ((ServerLevel)this.level).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                    this.getX() + offsetX, this.getY() + offsetY, this.getZ() + offsetZ,
                    1, 0, 0, 0, 0.0D);
        }
    }

}
