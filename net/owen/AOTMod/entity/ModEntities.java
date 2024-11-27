package net.owen.AOTMod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.owen.AOTMod.AOTMod;
import net.owen.AOTMod.entity.custom.*;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AOTMod.MOD_ID);


    public static final RegistryObject<EntityType<TSProjectileEntity>> TS_PROJECTILE =
            ENTITY_TYPES.register("ts_projectile", () -> EntityType.Builder.<TSProjectileEntity>of(TSProjectileEntity::new, MobCategory.MISC)
                    .sized(0.25f, 0.25f).build("ts_projectile"));

    public static final RegistryObject<EntityType<TitanFourOneEntity>> TITAN_FOUR_ONE =
            ENTITY_TYPES.register("titan_four_one", () -> EntityType.Builder.of(TitanFourOneEntity::new, MobCategory.MISC)
                    .sized(0.95f, 3.95f).build("titan_four_one"));

    public static final RegistryObject<EntityType<TitanFourTwoEntity>> TITAN_FOUR_TWO =
            ENTITY_TYPES.register("titan_four_two", () -> EntityType.Builder.of(TitanFourTwoEntity::new, MobCategory.MISC)
                    .sized(1.25f, 3.95f).build("titan_four_two"));

    public static final RegistryObject<EntityType<TitanThreeOneEntity>> TITAN_THREE_ONE =
            ENTITY_TYPES.register("titan_three_one", () -> EntityType.Builder.of(TitanThreeOneEntity::new, MobCategory.MISC)
                    .sized(0.80f, 2.95f).build("titan_three_one"));

    public static final RegistryObject<EntityType<TitanEightOneEntity>> TITAN_EIGHT_ONE =
            ENTITY_TYPES.register("titan_eight_one", () -> EntityType.Builder.of(TitanEightOneEntity::new, MobCategory.MISC)
                    .sized(1.90f, 7.95f).build("titan_eight_one"));

    public static final RegistryObject<EntityType<TitanFifteenOneEntity>> TITAN_FIFTEEN_ONE =
            ENTITY_TYPES.register("titan_fifteen_one", () -> EntityType.Builder.of(TitanFifteenOneEntity::new, MobCategory.MISC)
                    .sized(3.20f, 14.95f).build("titan_fifteen_one"));

    public static final RegistryObject<EntityType<BeastTitanTestEntity>> BEAST_TITAN =
            ENTITY_TYPES.register("beast_titan", () -> EntityType.Builder.of(BeastTitanTestEntity::new, MobCategory.MISC)
                    .sized(3.20f, 16.95f).build("beast_titan"));

    public static void register(IEventBus eventBus) { ENTITY_TYPES.register(eventBus); }
}
