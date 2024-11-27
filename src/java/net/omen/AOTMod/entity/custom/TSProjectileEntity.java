package net.omen.AOTMod.entity.custom;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.omen.AOTMod.entity.ModEntities;
import net.omen.AOTMod.item.ModItems;

import java.util.HashMap;
import java.util.Map;

public class TSProjectileEntity extends ThrowableItemProjectile {
    private int explosionPower = 3;
    public ExplosionDamageCalculator dmg;

    public TSProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public TSProjectileEntity(Level pLevel) {
        super(ModEntities.TS_PROJECTILE.get(), pLevel);
    }

    public TSProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.TS_PROJECTILE.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.THUNDER_SPEAR.get();
    }

    @Override
    protected void onHit(HitResult pResult) {
        if(!this.level.isClientSide()) {
            this.level.broadcastEntityEvent(this, ((byte) 3));
            this.level.explode(this, DamageSource.GENERIC, dmg, this.getX(), this.getY(), this.getZ(),
                    explosionPower, true, Explosion.BlockInteraction.DESTROY);
        }

        this.discard();
        super.onHit(pResult);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (!this.level.isClientSide) {
            Entity entity = pResult.getEntity();
            float damage = ENTITY_DAMAGE_MAP.getOrDefault(entity.getType(), 100F);

            entity.hurt(DamageSource.GENERIC, damage);
        }

        this.discard();
    }

    private static final Map<EntityType<?>, Float> ENTITY_DAMAGE_MAP = new HashMap<>();

    static {

        ENTITY_DAMAGE_MAP.put(ModEntities.TITAN_THREE_ONE.get(), 100.0f);
        ENTITY_DAMAGE_MAP.put(ModEntities.TITAN_FOUR_ONE.get(), 125.0f);
        ENTITY_DAMAGE_MAP.put(ModEntities.TITAN_FOUR_TWO.get(), 150.0f);
        ENTITY_DAMAGE_MAP.put(ModEntities.TITAN_EIGHT_ONE.get(), 250.0f);
        ENTITY_DAMAGE_MAP.put(ModEntities.TITAN_FIFTEEN_ONE.get(), 600.0f);
    }

}
