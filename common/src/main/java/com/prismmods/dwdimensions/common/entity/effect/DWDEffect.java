package com.prismmods.dwdimensions.common.entity.effect;

import com.prismmods.dwdimensions.common.capability.radiation.RadiationCapabilityProvider;
import com.prismmods.dwdimensions.common.particle.DWDParticles;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class DWDEffect extends MobEffect {

    public DWDEffect(MobEffectCategory typeIn, int color) {
        super(typeIn, color);
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity target, int amplifier, double health) {
        this.applyEffectTick(target, amplifier);
    }

    @Override
    public boolean isDurationEffectTick(int p_19455_, int p_19456_) {
        return true;
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        float difficultyModifier;
        switch(entity.level.getDifficulty()) {
            case PEACEFUL -> difficultyModifier = 0.5f;
            case EASY -> difficultyModifier = 0.5f;
            case NORMAL -> difficultyModifier = 1.0f;
            case HARD -> difficultyModifier = 2.0f;
            default -> difficultyModifier = 1.0f;
        }
        if(this == DWDEffectRegistry.RADIATION_SICKNESS.get()) {
            if(entity.getRandom().nextFloat() < 0.2) {
                entity.hurt(DWDDamageSources.RADIATION_SICKNESS, (1.0f*difficultyModifier));
            }
        }
        if(this == DWDEffectRegistry.RADIOACTIVE.get()) {
            if(entity.getRandom().nextFloat() < 0.4) {
                entity.hurt(DWDDamageSources.RADIATION_SICKNESS, (2.0f * difficultyModifier));
                if(entity.level.isClientSide) {
                    if(entity.getRandom().nextFloat() < 0.5) {
                        entity.level.addParticle(DWDParticles.RADIOACTIVE_PARTICLES.get(),
                                entity.getRandomX(0.5D), entity.getRandomY(), entity.getRandomZ(0.5D),
                                0, 0, 0);
                    }
                }
            }
        }
    }
}
