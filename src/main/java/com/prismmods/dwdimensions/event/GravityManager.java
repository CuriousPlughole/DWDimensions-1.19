package com.prismmods.dwdimensions.event;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.world.dimension.DWDDimensionReg;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DWDimensions.MOD_ID)
public class GravityManager {

    @SubscribeEvent
    public static void jumpGravityModifier(LivingEvent.LivingJumpEvent event) {
        LivingEntity entity = event.getEntity();
        if(entity.getLevel().dimension() == DWDDimensionReg.SPACE_KEY) {
                Vec3 motion = entity.getDeltaMovement();
                if(entity instanceof Player) {
                    if(((Player)entity).getAbilities().flying) {
                        //ignore
                    } else {
                        entity.setDeltaMovement(motion.x, motion.y +0.2, motion.z);
                    }
                } else {
                    entity.setDeltaMovement(motion.x, motion.y +0.2, motion.z);
                }
            }
        }

    @SubscribeEvent
    public static void inAirGravityModifier(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        if(entity.getLevel().dimension() == DWDDimensionReg.SPACE_KEY) {
            if(!entity.isOnGround()) {
                Vec3 motion = entity.getDeltaMovement();
                if(entity instanceof Player) {
                    if(((Player)entity).getAbilities().flying) {
                        //ignore
                    } else {
                        entity.setDeltaMovement(motion.x, motion.y +0.07, motion.z);
                    }
                } else {
                    entity.setDeltaMovement(motion.x, motion.y +0.07, motion.z);
                }
            }
        }
    }

    @SubscribeEvent
    public static void cancelFallDamage(LivingFallEvent event) {
        LivingEntity entity = event.getEntity();
        if(entity.getLevel().dimension() == DWDDimensionReg.SPACE_KEY) {
            event.setCanceled(true);
        }
    }


}
