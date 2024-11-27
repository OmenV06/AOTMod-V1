package net.omen.AOTMod.race.ackerman;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AckermanPower {

    public static final Attribute ACKERMAN_POWER = new RangedAttribute("attribute.aotmod.ackerman_power", 1.0, 1.0, 1.0).setSyncable(true);
    private static final UUID ATTACK_DAMAGE_MODIFIER_ID = UUID.fromString("c8b26db0-9c0b-11ec-b909-0242ac120001");
    private static final UUID EXTRA_HEALTH_MODIFIER_ID = UUID.fromString("c8b26db0-9c0b-11ec-b909-0242ac120002");
    private static final UUID ATTACK_SPEED_MODIFIER_ID = UUID.fromString("c8b26db0-9c0b-11ec-b909-0242ac120003");
    private static final UUID ARMOR_POINT_MODIFIER_ID = UUID.fromString("c8b26db0-9c0b-11ec-b909-0242ac120004");
    private static final UUID ARMOR_TOUGHNESS_MODIFIER_ID = UUID.fromString("c8b26db0-9c0b-11ec-b909-0242ac120005");

    // Deferred register for attributes
    private static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, "aotmod");

    // Registry object to hold the attribute
    public static final RegistryObject<Attribute> ACKERMAN_POWER_ATTRIBUTE = ATTRIBUTES.register("ackerman_power", () -> ACKERMAN_POWER);

    public static void registerAttributes() {
        // This is where the DeferredRegister is attached to the event bus
        ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Method to apply Ackerman specific powers
    public static void applyPowers(ServerPlayer player) {
        // Apply specific powers/effects for Ackerman race
        AttributeModifier attackDamageModifier = new AttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Ackerman attack boost", 3, AttributeModifier.Operation.ADDITION);
        player.getAttribute(Attributes.ATTACK_DAMAGE).addTransientModifier(attackDamageModifier);

        AttributeModifier extraHealthModifier = new AttributeModifier(EXTRA_HEALTH_MODIFIER_ID, "Ackerman extra health", 10, AttributeModifier.Operation.ADDITION);
        player.getAttribute(Attributes.MAX_HEALTH).addTransientModifier(extraHealthModifier);

        AttributeModifier attackSpeedModifier = new AttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Ackerman attack speed", 2, AttributeModifier.Operation.ADDITION);
        player.getAttribute(Attributes.ATTACK_SPEED).addTransientModifier(attackSpeedModifier);

        AttributeModifier armorPointModifer = new AttributeModifier(ARMOR_POINT_MODIFIER_ID, "Ackerman armor boost", 5, AttributeModifier.Operation.ADDITION);
        player.getAttribute(Attributes.ARMOR).addTransientModifier(armorPointModifer);

        AttributeModifier armorToughnessModifer = new AttributeModifier(ARMOR_TOUGHNESS_MODIFIER_ID, "Ackerman armor toughness", 2, AttributeModifier.Operation.ADDITION);
        player.getAttribute(Attributes.ARMOR_TOUGHNESS).addTransientModifier(armorToughnessModifer);

        //Can be exploited, will need to be changed eventually
        player.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 2));
        // Add more effects as needed
    }

    // Method to remove Ackerman specific powers
    public static void removePowers(ServerPlayer player) {
        // Remove specific powers/effects for Ackerman race
        player.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ATTACK_DAMAGE_MODIFIER_ID);
        player.getAttribute(Attributes.MAX_HEALTH).removeModifier(EXTRA_HEALTH_MODIFIER_ID);
        player.getAttribute(Attributes.ATTACK_SPEED).removeModifier(ATTACK_SPEED_MODIFIER_ID);
        player.getAttribute(Attributes.ARMOR).removeModifier(ARMOR_POINT_MODIFIER_ID);
        player.getAttribute(Attributes.ARMOR_TOUGHNESS).removeModifier(ARMOR_TOUGHNESS_MODIFIER_ID);
        // Remove other effects as needed
    }
}