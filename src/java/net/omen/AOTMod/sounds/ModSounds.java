package net.omen.AOTMod.sounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.omen.AOTMod.AOTMod;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AOTMod.MOD_ID);

    public static final RegistryObject<SoundEvent> TITAN_TRANSFORMATION_SOUND = SOUNDS.register("titan_transformation",
            () -> new SoundEvent(new ResourceLocation(AOTMod.MOD_ID, "titan_transformation")));

    public static void register(IEventBus modEventBus) {
        SOUNDS.register(modEventBus);
    }
}
