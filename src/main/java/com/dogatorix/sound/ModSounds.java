package com.dogatorix.sound;

import com.dogatorix.Blahaj;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = 
        DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Blahaj.MOD_ID);

        public static final RegistryObject<SoundEvent> SQUEAK = registerSoundEvent("squeak");

        private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
           ResourceLocation id = new ResourceLocation(Blahaj.MOD_ID, name);
           return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
        }

        public static void register(IEventBus bus) {
            SOUND_EVENTS.register(bus);
        }
    }
