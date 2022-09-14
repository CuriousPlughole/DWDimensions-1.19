package com.prismmods.dwdimensions.common.sound.instances;

import com.prismmods.dwdimensions.common.block.custom.DalekComputerBlock;
import com.prismmods.dwdimensions.common.blockentities.DalekComputerBlockEntity;
import com.prismmods.dwdimensions.common.sound.DWDSounds;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class DalekAlarmSoundInstance extends AbstractTickableSoundInstance {

    private final DalekComputerBlockEntity blockentity;

    public DalekAlarmSoundInstance(DalekComputerBlockEntity entity) {
        super(DWDSounds.DALEK_ALARM.get(), SoundSource.BLOCKS, SoundInstance.createUnseededRandom());
        this.blockentity = entity;
        this.looping = true;
        this.delay = 10;
        this.volume = 0.8f;

    }

    @Override
    public void tick() {
        if(this.blockentity.isAlarming()) {
            float f1 = 0.8F;
            if (this.volume > f1) {
                this.pitch = 1.0F + (this.volume - 0.8F);
            } else {
                this.pitch = 1.0F;
            }
        } else {
            this.stop();
        }


    }
}
