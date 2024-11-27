package net.owen.AOTMod.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.owen.AOTMod.AOTMod;
import net.owen.AOTMod.entity.ModEntities;
import net.owen.AOTMod.entity.custom.*;

@Mod.EventBusSubscriber(modid = AOTMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TITAN_FOUR_ONE.get(), TitanFourOneEntity.createAttributes().build());
        event.put(ModEntities.TITAN_FOUR_TWO.get(), TitanFourTwoEntity.createAttributes().build());
        event.put(ModEntities.TITAN_THREE_ONE.get(), TitanThreeOneEntity.createAttributes().build());
        event.put(ModEntities.TITAN_EIGHT_ONE.get(), TitanEightOneEntity.createAttributes().build());
        event.put(ModEntities.TITAN_FIFTEEN_ONE.get(), TitanFifteenOneEntity.createAttributes().build());
        event.put(ModEntities.BEAST_TITAN.get(), BeastTitanTestEntity.createAttributes().build());
    }

}
