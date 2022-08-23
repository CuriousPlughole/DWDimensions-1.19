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
                .with(SoundDefinitionsProvider.sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/player/snap"))));
        this.add(DWDSounds.HANDMINE_EMERGES.get(), definition().subtitle("sound.entity.handmine.emerge")
                .with(SoundDefinitionsProvider.sound(new ResourceLocation(DWDimensions.MOD_ID, "entity/handmine/emerge"))));

        this.add(DWDSounds.SONIC_10_EXTEND.get(), definition().subtitle("sound.sonic.extends")
                .with(SoundDefinitionsProvider.sound(new ResourceLocation(DWDimensions.MOD_ID, "sonic/tennant/extend"))));
        this.add(DWDSounds.SONIC_11_EXTEND.get(), definition().subtitle("sound.sonic.extends")
                .with(SoundDefinitionsProvider.sound(new ResourceLocation(DWDimensions.MOD_ID, "sonic/smith/extend"))));
        this.add(DWDSounds.SONIC_11_RETRACT.get(), definition().subtitle("sound.sonic.retracts")
                .with(SoundDefinitionsProvider.sound(new ResourceLocation(DWDimensions.MOD_ID, "sonic/smith/retract"))));
        this.add(DWDSounds.SONIC_11_USE_SHORT.get(), definition().subtitle("sound.sonic.used")
                .with(SoundDefinitionsProvider.sound(new ResourceLocation(DWDimensions.MOD_ID, "sonic/smith/use_short"))));

        this.add(DWDSounds.TARDIS_DOOR_CLOSE.get(), definition().subtitle("sound.tardis.door.close")
                .with(SoundDefinitionsProvider.sound(new ResourceLocation(DWDimensions.MOD_ID, "block/tardis/door_close"))));
        this.add(DWDSounds.TARDIS_DOOR_CLOSE_SQUEAKY.get(), definition().subtitle("sound.tardis.door.close")
                .with(SoundDefinitionsProvider.sound(new ResourceLocation(DWDimensions.MOD_ID, "block/tardis/door_close_squeaky"))));
        this.add(DWDSounds.TARDIS_DOOR_OPEN_1.get(), definition().subtitle("sound.tardis.door.open")
                .with(SoundDefinitionsProvider.sound(new ResourceLocation(DWDimensions.MOD_ID, "block/tardis/door_open_1"))));
        this.add(DWDSounds.TARDIS_DOOR_OPEN_2.get(), definition().subtitle("sound.tardis.door.open")
                .with(SoundDefinitionsProvider.sound(new ResourceLocation(DWDimensions.MOD_ID, "block/tardis/door_open_2"))));
        this.add(DWDSounds.TARDIS_DOOR_OPEN_SQUEAKY.get(), definition().subtitle("sound.tardis.door.open")
                .with(SoundDefinitionsProvider.sound(new ResourceLocation(DWDimensions.MOD_ID, "block/tardis/door_open_squeaky"))));

    }
}
