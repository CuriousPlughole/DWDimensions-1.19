package com.prismmods.dwdimensions.event;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.api.OxygenHandler;
import com.prismmods.dwdimensions.api.RadiationHandler;
import com.prismmods.dwdimensions.common.capability.radiation.RadiationCapabilityProvider;
import com.prismmods.dwdimensions.common.entity.effect.DWDDamageSources;
import com.prismmods.dwdimensions.common.entity.effect.DWDEffectRegistry;
import com.prismmods.dwdimensions.world.dimension.DWDDimensionReg;
import com.sun.jdi.connect.spi.TransportService;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DWDimensions.MOD_ID)
public class OxygenEvents {

    private static int ticksWithoutAir;

    @SubscribeEvent
    public static void onLivingEntityTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        if(!entity.level.isClientSide) {
            if(entity instanceof Player && (((Player) entity).isCreative() || entity.isSpectator())) {
                //If not in survival, do nothing
            } else {
                if(!OxygenHandler.isProtectedFromNoOxygen(entity)) {
                    if(entity.getLevel().dimension() == DWDDimensionReg.SPACE_KEY) {
                        ticksWithoutAir++;
                        if(ticksWithoutAir < 70) {
                            entity.setTicksFrozen(ticksWithoutAir*2);
                        } else {
                            entity.setTicksFrozen(140);
                            entity.setDeltaMovement(entity.getDeltaMovement().scale(0.8));
                        }
                        //Note: Vanilla code resets the air supply to 300 whenever not in water, so careful with this.
                        if(entity.getAirSupply() >= -30) {
                            entity.setAirSupply(entity.getAirSupply() - ticksWithoutAir/2);
                        } else {
                            //Fully out of air, so do damage
                            entity.setAirSupply(-30);
                            entity.hurt(DWDDamageSources.SPACE, 1.0f);
                        }
                    }
                } else {
                    ticksWithoutAir = 0;
                    entity.setAirSupply(300);
                }
            }
        }
        //Client side
        if(entity.getTicksFrozen() == 140) {
            RandomSource randomsource = entity.getRandom();
            entity.level.addAlwaysVisibleParticle(ParticleTypes.SNOWFLAKE, entity.getX(), entity.getEyeY()-0.05, entity.getZ(), (double)(Mth.randomBetween(randomsource, -1.0F, 1.0F) * 0.083333336F), (double)0.05F, (double)(Mth.randomBetween(randomsource, -1.0F, 1.0F) * 0.083333336F));
        }
    }
}
