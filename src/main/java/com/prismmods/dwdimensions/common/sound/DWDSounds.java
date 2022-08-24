package com.prismmods.dwdimensions.common.sound;

import com.prismmods.dwdimensions.DWDimensions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DWDSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DWDimensions.MOD_ID);

    public static final RegistryObject<SoundEvent> FINGER_SNAP = registerSoundEvent("entity.player.snap");
    public static final RegistryObject<SoundEvent> HANDMINE_EMERGES = registerSoundEvent("entity.handmine.emerge");

    public static final RegistryObject<SoundEvent> DALEK_DRIVES = registerSoundEvent("entity.dalek.drive");
    public static final RegistryObject<SoundEvent> DALEK_EXTERMINATE_VOCAL = registerSoundEvent("entity.dalek.exterminate");
    public static final RegistryObject<SoundEvent> DALEK_SHOOT = registerSoundEvent("entity.dalek.shoot");
    public static final RegistryObject<SoundEvent> DALEK_SCREAM = registerSoundEvent("entity.dalek.scream");
    public static final RegistryObject<SoundEvent> DALEK_EYESTALK = registerSoundEvent("entity.dalek.eyestalk");
    public static final RegistryObject<SoundEvent> DALEK_EYESTALK_SLOW = registerSoundEvent("entity.dalek.eyestalk_slow");
    public static final RegistryObject<SoundEvent> DALEK_AIM_GUN = registerSoundEvent("entity.dalek.gun");
    public static final RegistryObject<SoundEvent> DALEK_HOVER_START = registerSoundEvent("entity.dalek.hover_start");
    public static final RegistryObject<SoundEvent> DALEK_HOVER_LOOP = registerSoundEvent("entity.dalek.hover_loop");
    public static final RegistryObject<SoundEvent> DALEK_HOVER_END = registerSoundEvent("entity.dalek.hover_end");
    public static final RegistryObject<SoundEvent> DALEK_MECHANICAL = registerSoundEvent("entity.dalek.mechanical");
    public static final RegistryObject<SoundEvent> DALEK_MECHANICAL_LONG = registerSoundEvent("entity.dalek.mechanical_long");
    public static final RegistryObject<SoundEvent> DALEK_TEA = registerSoundEvent("entity.dalek.tea");
    public static final RegistryObject<SoundEvent> DALEK_ATTACKED = registerSoundEvent("entity.dalek.attacked");
    public static final RegistryObject<SoundEvent> DALEK_EMERGENCY = registerSoundEvent("entity.dalek.emergency");

    public static final RegistryObject<SoundEvent> SONIC_11_EXTEND = registerSoundEvent("sonic.smith.extend");
    public static final RegistryObject<SoundEvent> SONIC_11_RETRACT = registerSoundEvent("sonic.smith.retract");
    public static final RegistryObject<SoundEvent> SONIC_11_USE_SHORT = registerSoundEvent("sonic.smith.use_short");
    public static final RegistryObject<SoundEvent> SONIC_10_EXTEND = registerSoundEvent("sonic.tennant.extend");

    public static final RegistryObject<SoundEvent> TARDIS_DOOR_OPEN_1 = registerSoundEvent("block.tardis.door_open_1");
    public static final RegistryObject<SoundEvent> TARDIS_DOOR_OPEN_2 = registerSoundEvent("block.tardis.door_open_2");
    public static final RegistryObject<SoundEvent> TARDIS_DOOR_OPEN_SQUEAKY = registerSoundEvent("block.tardis.door_open_squeaky");
    public static final RegistryObject<SoundEvent> TARDIS_DOOR_CLOSE_SQUEAKY = registerSoundEvent("block.tardis.door_close_squeaky");
    public static final RegistryObject<SoundEvent> TARDIS_DOOR_CLOSE = registerSoundEvent("block.tardis.door_close");


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(DWDimensions.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
