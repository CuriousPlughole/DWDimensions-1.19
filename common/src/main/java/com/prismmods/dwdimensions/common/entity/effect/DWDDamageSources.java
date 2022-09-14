package com.prismmods.dwdimensions.common.entity.effect;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.entity.custom.projectile.AbstractLaser;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

public class DWDDamageSources {

    public static final DamageSource RADIATION_SICKNESS = new DamageSource(DWDimensions.MOD_ID + ".radiation.sickness").bypassArmor().setScalesWithDifficulty().bypassEnchantments();
    public static final DamageSource SPACE = new DamageSource(DWDimensions.MOD_ID + ".space").bypassArmor().setScalesWithDifficulty().bypassEnchantments();
    public static final DamageSource TOXIC_MERCURY = new DamageSource(DWDimensions.MOD_ID + ".toxic.mercury").bypassArmor().setScalesWithDifficulty().bypassEnchantments();;

    public static final DamageSource laser(AbstractLaser laser, @Nullable Entity source) {
        return (new IndirectEntityDamageSource(DWDimensions.MOD_ID + ".laser", laser, source)).setProjectile();
    }

}
