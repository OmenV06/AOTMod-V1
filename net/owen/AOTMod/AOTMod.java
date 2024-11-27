package net.owen.AOTMod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.owen.AOTMod.block.ModBlocks;
import net.owen.AOTMod.entity.ModEntities;
import net.owen.AOTMod.entity.models.*;
import net.owen.AOTMod.item.ModItems;
import net.owen.AOTMod.networking.ModPackets;
import net.owen.AOTMod.sounds.ModSounds;
import net.owen.AOTMod.util.commands.*;
import org.slf4j.Logger;

@Mod(AOTMod.MOD_ID)
public class AOTMod
{
    public static final String MOD_ID = "aotmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AOTMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModSounds.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

     }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            ModPackets.register();

        });


    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(ModEntities.TS_PROJECTILE.get(), ThrownItemRenderer::new);

            EntityRenderers.register(ModEntities.TITAN_FOUR_ONE.get(), TitanFourOneRenderer::new);
            EntityRenderers.register(ModEntities.TITAN_FOUR_TWO.get(), TitanFourTwoRenderer::new);
            EntityRenderers.register(ModEntities.TITAN_THREE_ONE.get(), TitanThreeOneRenderer::new);
            EntityRenderers.register(ModEntities.TITAN_EIGHT_ONE.get(), TitanEightOneRenderer::new);
            EntityRenderers.register(ModEntities.TITAN_FIFTEEN_ONE.get(), TitanFifteenOneRenderer::new);
            EntityRenderers.register(ModEntities.BEAST_TITAN.get(), BeastTitanRenderer::new);

        }
    }

    @Mod.EventBusSubscriber
    public class CommandRegister {

        @SubscribeEvent
        public static void onRegisterCommandsEvent(RegisterCommandsEvent event) {
            // Register your command here
            CheckRaceCommand.register(event.getDispatcher());
            ResetRaceCommand.register(event.getDispatcher());
            SetRoyalCommand.register(event.getDispatcher());
            CheckTitanCommand.register(event.getDispatcher());
            ResetTitanCommand.register(event.getDispatcher());

        }
    }
}