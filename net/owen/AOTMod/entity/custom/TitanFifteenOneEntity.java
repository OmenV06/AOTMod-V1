package net.owen.AOTMod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.owen.AOTMod.entity.custom.brain.TitanAttackableTargetGoal;
import net.owen.AOTMod.entity.custom.brain.TitanRandomStrollGoal;
import net.owen.AOTMod.entity.custom.brain.TitanSleepGoal;
import net.owen.AOTMod.sounds.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class TitanFifteenOneEntity extends Animal {
    public TitanFifteenOneEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.maxUpStep = 5;

    }

    private boolean isFirstTimeSpawned = true;

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();

        if (!this.level.isClientSide && isFirstTimeSpawned) {

            this.level.explode(this, this.getX(), this.getY(), this.getZ(), 4.0F, Explosion.BlockInteraction.NONE);
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
                .add(Attributes.MAX_HEALTH, 400)
                .add(Attributes.MOVEMENT_SPEED, 0.4)
                .add(Attributes.ARMOR, 15f)
                .add(Attributes.ARMOR_TOUGHNESS, 5f)
                .add(Attributes.ATTACK_DAMAGE, 22f)
                .add(Attributes.ATTACK_KNOCKBACK, 3f)
                .add(Attributes.FOLLOW_RANGE, 100)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0f);
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

            destroyCollidingBlocks();

        }
    }

    // Method to check and destroy colliding blocks (wood and leaves)
    private void destroyCollidingBlocks() {
        // Define a custom radius around the Titan to check for colliding blocks
        int xRadius = 4; // 4 blocks in the X direction
        int yRadius = 15; // 15 blocks in the Y direction
        int zRadius = 4; // 4 blocks in the Z direction

        // Check blocks in the defined 3D space around the Titan
        for (int x = -xRadius; x <= xRadius; x++) {
            for (int y = -yRadius; y <= yRadius; y++) {
                for (int z = -zRadius; z <= zRadius; z++) {
                    // Get the block at the current position
                    BlockPos blockPos = this.blockPosition().offset(x, y, z);
                    BlockState blockState = level.getBlockState(blockPos);

                    // Check if the block is part of a category of blocks (e.g., logs or leaves)
                    if (blockState.is(TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("minecraft", "logs"))) ||
                            blockState.is(TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("minecraft", "leaves")))) {
                        // Destroy the block and trigger particles/sounds
                        level.destroyBlock(blockPos, false); // true to drop items
                        level.playSound(null, blockPos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
                    }
                }
            }
        }
    }

    private void performRegeneration() {

        if (this.getHealth() < this.getMaxHealth()) {
            this.heal(1);
            spawnRegenerationParticles(this);
        }
    }

    private static void spawnRegenerationParticles(TitanFifteenOneEntity titan) {

        double particleY = titan.getY() + 6.75D;

        ((ServerLevel)titan.level).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                titan.getX(), particleY, titan.getZ(),
                35, 1.4D, 4.25D, 1.4D, 0.0D);
    }

    @Override
    public void die(DamageSource cause) {
        super.die(cause);
        if (!this.level.isClientSide) {
            spawnFormSteamParticles();
        }
    }

    private void spawnFormSteamParticles() {
        final int particleCount = 750;
        final double radius = 5.0;
        Random random = new Random();

        for (int i = 0; i < particleCount; i++) {
            double offsetX = (random.nextDouble() * 2 - 1) * radius;
            double offsetY = (random.nextDouble() * 3.5) * radius;
            double offsetZ = (random.nextDouble() * 2 - 1) * radius;

            ((ServerLevel)this.level).sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,
                    this.getX() + offsetX, this.getY() + offsetY, this.getZ() + offsetZ,
                    1, 0, 0, 0, 0.0D);
        }
    }

    private void spawnWaterSteamParticles() {
        final int particleCount = 2;
        final double radius = 5.0;
        Random random = new Random();

        for (int i = 0; i < particleCount; i++) {
            double offsetX = (random.nextDouble() * 2 - 1) * radius;
            double offsetY = (random.nextDouble() * 0.5) * radius;
            double offsetZ = (random.nextDouble() * 2 - 1) * radius;

            ((ServerLevel)this.level).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                    this.getX() + offsetX, this.getY() + offsetY, this.getZ() + offsetZ,
                    1, 0, 0, 0, 0.0D);
        }
    }

}
