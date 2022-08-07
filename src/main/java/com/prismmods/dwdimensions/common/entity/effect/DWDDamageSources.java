package com.prismmods.dwdimensions.common.entity.effect;

import com.prismmods.dwdimensions.DWDimensions;
import net.minecraft.world.damagesource.DamageSource;

public class DWDDamageSources {

    public static final DamageSource RADIATION_SICKNESS = new DamageSource(DWDimensions.MOD_ID + ".radiation.sickness").bypassArmor().setScalesWithDifficulty().bypassEnchantments();

    public static final DamageSource TOXIC_MERCURY = new DamageSource(DWDimensions.MOD_ID + ".toxic.mercury").bypassArmor().setScalesWithDifficulty().bypassEnchantments();;

}
