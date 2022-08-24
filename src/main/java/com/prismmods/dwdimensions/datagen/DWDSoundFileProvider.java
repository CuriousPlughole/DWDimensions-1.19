package com.prismmods.dwdimensions.datagen;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.sound.DWDSounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class DWDSoundFileProvider extends SoundDefinitionsProvider {

    protected DWDSoundFileProvider(DataGenerator generator, String modId, ExistingFileHelper helper) {
        super(generator, modId, helper);
    }

    @Override
    public void registerSounds() {
        this.add(DWDSounds.FINGER_SNAP.get(), definition().subtitle("sound.entity.player.snap")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/player/snap"))));
        this.add(DWDSounds.HANDMINE_EMERGES.get(), definition().subtitle("sound.entity.handmine.emerge")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/handmine/emerge"))));

        this.add(DWDSounds.DALEK_DRIVES.get(), definition().subtitle("sound.entity.dalek.drive")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/drive_long"))));
        this.add(DWDSounds.DALEK_EXTERMINATE_VOCAL.get(), definition().subtitle("sound.entity.dalek.exterminate")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/exterminate"))));
        this.add(DWDSounds.DALEK_SHOOT.get(), definition().subtitle("sound.entity.dalek.shoot")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/shoot"))));
        this.add(DWDSounds.DALEK_SCREAM.get(), definition().subtitle("sound.entity.dalek.scream")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/scream"))));
        this.add(DWDSounds.DALEK_EYESTALK.get(), definition().subtitle("sound.entity.dalek.mechanical")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/eyestalk")).weight(4),
                        sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/eyestalk_long"))));
        this.add(DWDSounds.DALEK_EYESTALK_SLOW.get(), definition().subtitle("sound.entity.dalek.mechanical")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/eyestalk_slow"))));
        this.add(DWDSounds.DALEK_AIM_GUN.get(), definition().subtitle("sound.entity.dalek.mechanical")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/gun_aim"))));
        this.add(DWDSounds.DALEK_HOVER_START.get(), definition().subtitle("sound.entity.dalek.hover")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/hover_start"))));
        this.add(DWDSounds.DALEK_HOVER_LOOP.get(), definition().subtitle("sound.entity.dalek.hover")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/hover_loop"))));
        this.add(DWDSounds.DALEK_HOVER_END.get(), definition().subtitle("sound.entity.dalek.hover")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/hover_stop"))));
        this.add(DWDSounds.DALEK_MECHANICAL.get(), definition().subtitle("sound.entity.dalek.mechanical")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/mechanical_a")).weight(1),
                        sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/mechanical_b")).weight(1),
                        sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/mechanical_c")).weight(1),
                        sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/mechanical_d")).weight(1),
                        sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/mechanical_e")).weight(1),
                        sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/mechanical_f")).weight(1)));
        this.add(DWDSounds.DALEK_MECHANICAL_LONG.get(), definition().subtitle("sound.entity.dalek.mechanical")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/mechanical_long"))));
        this.add(DWDSounds.DALEK_TEA.get(), definition().subtitle("sound.entity.dalek.tea")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/tea"))));
        this.add(DWDSounds.DALEK_ATTACKED.get(), definition().subtitle("sound.entity.dalek.attacked")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/casing_hit"))));
        this.add(DWDSounds.DALEK_EMERGENCY.get(), definition().subtitle("sound.entity.dalek.attacked")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/dalek/emergency"))));

        this.add(DWDSounds.SONIC_10_EXTEND.get(), definition().subtitle("sound.sonic.extends")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "sonic/tennant/extend"))));
        this.add(DWDSounds.SONIC_11_EXTEND.get(), definition().subtitle("sound.sonic.extends")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "sonic/smith/extend"))));
        this.add(DWDSounds.SONIC_11_RETRACT.get(), definition().subtitle("sound.sonic.retracts")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "sonic/smith/retract"))));
        this.add(DWDSounds.SONIC_11_USE_SHORT.get(), definition().subtitle("sound.sonic.used")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "sonic/smith/use_short"))));

        this.add(DWDSounds.TARDIS_DOOR_CLOSE.get(), definition().subtitle("sound.tardis.door.close")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "block/tardis/door_close"))));
        this.add(DWDSounds.TARDIS_DOOR_CLOSE_SQUEAKY.get(), definition().subtitle("sound.tardis.door.close")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "block/tardis/door_close_squeaky"))));
        this.add(DWDSounds.TARDIS_DOOR_OPEN_1.get(), definition().subtitle("sound.tardis.door.open")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "block/tardis/door_open_1"))));
        this.add(DWDSounds.TARDIS_DOOR_OPEN_2.get(), definition().subtitle("sound.tardis.door.open")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "block/tardis/door_open_2"))));
        this.add(DWDSounds.TARDIS_DOOR_OPEN_SQUEAKY.get(), definition().subtitle("sound.tardis.door.open")
                .with(sound(new ResourceLocation(DWDimensions.MOD_ID, "block/tardis/door_open_squeaky"))));

    }
}
