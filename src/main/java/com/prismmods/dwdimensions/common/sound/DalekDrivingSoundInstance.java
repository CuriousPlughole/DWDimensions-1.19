package com.prismmods.dwdimensions.common.sound;

import com.prismmods.dwdimensions.common.entity.custom.dalek.DalekEntity;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

public class DalekDrivingSoundInstance extends AbstractTickableSoundInstance {

    private final DalekEntity dalek;

    public DalekDrivingSoundInstance(DalekEntity dalek) {
        super(DWDSounds.DALEK_DRIVES.get(), SoundSource.HOSTILE, SoundInstance.createUnseededRandom());
        this.dalek = dalek;
        this.looping = true;
        this.delay = 0;
        this.volume = 0.0F;
        this.x = (double)((float)dalek.getX());
        this.y = (double)((float)dalek.getY());
        this.z = (double)((float)dalek.getZ());
    }

    public boolean canPlaySound() {
        return !this.dalek.isSilent();
    }

    public boolean canStartSilent() {
        return true;
    }

    @Override
    public void tick() {
        float f = (float)this.dalek.getDeltaMovement().horizontalDistance();
        if(f > 0.02) {
            volume = 0.1f;
        } else {
            volume = 0;
        }

    }
}
