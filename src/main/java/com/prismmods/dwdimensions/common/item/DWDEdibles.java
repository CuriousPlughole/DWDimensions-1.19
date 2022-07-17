package com.prismmods.dwdimensions.common.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class DWDEdibles {
    public static final FoodProperties VARGA_BERRIES = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.5F)
            .effect(new MobEffectInstance(MobEffects.POISON, 200, 2), 1.0F).build();
}
