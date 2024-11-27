package net.owen.AOTMod.events;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.owen.AOTMod.AOTMod;
import net.owen.AOTMod.client.abilitybar.AbilityBarHandler;
import net.owen.AOTMod.entity.models.*;
import net.owen.AOTMod.networking.ModPackets;
import net.owen.AOTMod.networking.packet.OpenRaceMenuPacket;
import net.owen.AOTMod.race.eldian.royal.SummonTitansPacket;
import net.owen.AOTMod.util.KeyBindings;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = AOTMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {

            if(KeyBindings.GEAR_BOOST.consumeClick()) {

            }
            if (KeyBindings.RACE_MENU.consumeClick()) {
                // Send packet to the server to request opening the race menu
                // Make sure you have a method to send packets in your mod
                ModPackets.sendToServer(new OpenRaceMenuPacket());
            }

            if (KeyBindings.ABILITY_BAR.consumeClick()) {

                AbilityBarHandler.toggleAbilityBar();

            }

            if (KeyBindings.ABILITY_ONE.consumeClick()) {
                if (AbilityBarHandler.isAbilityBarActive()) {

                } else {
                    Minecraft.getInstance().player.getInventory().selected = 0;
                }
            }

            if (KeyBindings.ABILITY_TWO.consumeClick()) {
                if (AbilityBarHandler.isAbilityBarActive()) {

                } else {
                    Minecraft.getInstance().player.getInventory().selected = 1;
                }
            }

            if (KeyBindings.ABILITY_THREE.consumeClick()) {
                if (AbilityBarHandler.isAbilityBarActive()) {

                } else {
                    Minecraft.getInstance().player.getInventory().selected = 2;
                }
            }

            if (KeyBindings.ABILITY_FOUR.consumeClick()) {
                if (AbilityBarHandler.isAbilityBarActive()) {

                } else {
                    Minecraft.getInstance().player.getInventory().selected = 3;
                }
            }

            if (KeyBindings.ABILITY_FIVE.consumeClick()) {
                if (AbilityBarHandler.isAbilityBarActive()) {

                } else {
                    Minecraft.getInstance().player.getInventory().selected = 4;
                }
            }

            if (KeyBindings.ABILITY_SIX.consumeClick()) {
                if (AbilityBarHandler.isAbilityBarActive()) {

                } else {
                    Minecraft.getInstance().player.getInventory().selected = 5;
                }
            }

            if (KeyBindings.ABILITY_SEVEN.consumeClick()) {
                if (AbilityBarHandler.isAbilityBarActive()) {

                } else {
                    Minecraft.getInstance().player.getInventory().selected = 6;
                }
            }

            if (KeyBindings.ABILITY_EIGHT.consumeClick()) {
                if (AbilityBarHandler.isAbilityBarActive()) {

                } else {
                    Minecraft.getInstance().player.getInventory().selected = 7;
                }
            }

            if (KeyBindings.ABILITY_NINE.consumeClick()) {
                if (AbilityBarHandler.isAbilityBarActive()) {
                    ModPackets.sendToServer(new SummonTitansPacket());
                } else {
                    Minecraft.getInstance().player.getInventory().selected = 8;
                }
            }


        }
    }

    @Mod.EventBusSubscriber(modid = AOTMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModBusEvents {

        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBindings.GEAR_BOOST);
            event.register(KeyBindings.RACE_MENU);

            event.register(KeyBindings.ABILITY_BAR);
            event.register(KeyBindings.ABILITY_ONE);
            event.register(KeyBindings.ABILITY_TWO);
            event.register(KeyBindings.ABILITY_THREE);
            event.register(KeyBindings.ABILITY_FOUR);
            event.register(KeyBindings.ABILITY_FIVE);
            event.register(KeyBindings.ABILITY_SIX);
            event.register(KeyBindings.ABILITY_SEVEN);
            event.register(KeyBindings.ABILITY_EIGHT);
            event.register(KeyBindings.ABILITY_NINE);
        }

        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(ModModelLayers.TITAN_FOUR_ONE_LAYER, TitanFourOneModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.TITAN_FOUR_TWO_LAYER, TitanFourTwoModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.TITAN_THREE_ONE_LAYER, TitanThreeOneModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.TITAN_EIGHT_ONE_LAYER, TitanEightOneModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.TITAN_FIFTEEN_ONE_LAYER, TitanFifteenOneModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.BEAST_TITAN_LAYER, BeastTitanModel::createBodyLayer);
        }

    }
}
