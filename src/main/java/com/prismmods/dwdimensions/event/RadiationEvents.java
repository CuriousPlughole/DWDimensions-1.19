package com.prismmods.dwdimensions.event;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.api.RadiationHandler;
import com.prismmods.dwdimensions.common.capability.radiation.RadiationCapability;
import com.prismmods.dwdimensions.common.capability.radiation.RadiationCapabilityProvider;
import com.prismmods.dwdimensions.common.entity.custom.dalek.DalekEntity;
import com.prismmods.dwdimensions.common.entity.effect.DWDEffectRegistry;
import com.prismmods.dwdimensions.network.Network;
import com.prismmods.dwdimensions.network.messages.RadiationDataMessage;
import com.prismmods.dwdimensions.util.DWDTags;
import com.prismmods.dwdimensions.world.dimension.DWDDimensionReg;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DWDimensions.MOD_ID)
public class RadiationEvents {

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof LivingEntity) {
            if (!(event.getObject().getType().is(DWDTags.Entities.RADIATION_IMMUNE))) {
                if (!event.getObject().getCapability(RadiationCapabilityProvider.LIVING_ENTITY_RADIATION).isPresent()) {
                    event.addCapability(new ResourceLocation(DWDimensions.MOD_ID, "properties"), new RadiationCapabilityProvider());
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(RadiationCapabilityProvider.LIVING_ENTITY_RADIATION).ifPresent(oldStore -> {
                event.getOriginal().getCapability(RadiationCapabilityProvider.LIVING_ENTITY_RADIATION).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(RadiationCapability.class);
    }

    @SubscribeEvent
    public static void onLivingEntityTick(LivingEvent.LivingTickEvent event) {
        if(!event.getEntity().level.isClientSide) {
            if(event.getEntity() instanceof Player && (((Player) event.getEntity()).isCreative() || event.getEntity().isSpectator())) {
                //If not in survival, do nothing
            } else {
                event.getEntity().getCapability(RadiationCapabilityProvider.LIVING_ENTITY_RADIATION).ifPresent(radiation -> {
                    LivingEntity entity = event.getEntity();

                    //No effect up to 3 "rads". Then nausea randomly applied every few seconds for random length
                    if(radiation.getRadiation() > 3 && radiation.getRadiation() <= 7 && entity.getRandom().nextFloat() < 0.03f) {
                        if(!entity.hasEffect(MobEffects.CONFUSION)) {
                            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, entity.getRandom().nextInt(120, 160), 1));
                        }
                    } //Above this, nausea stops and damage taken
                    if(radiation.getRadiation() > 7 && entity.getRandom().nextFloat() < 0.014f) {
                        if (!entity.hasEffect(DWDEffectRegistry.RADIATION_SICKNESS.get())) {
                            entity.addEffect(new MobEffectInstance(DWDEffectRegistry.RADIATION_SICKNESS.get(), entity.getRandom().nextInt(140), 0, true, true));
                        }
                    } //Damage from radiation sickness continues, and then above 14 (becomes radioactive)
                    if(radiation.getRadiation() > 14) {
                        if (!entity.hasEffect(DWDEffectRegistry.RADIOACTIVE.get())) {
                            entity.addEffect(new MobEffectInstance(DWDEffectRegistry.RADIOACTIVE.get(), entity.getRandom().nextInt(320), 0, true, true));
                        }
                    }


                    if(entity.getLevel().dimension() == DWDDimensionReg.SKARO_KEY) {
                        //TODO: Play around with the maths involved here.
                        float surfaceRadiationRate = 0.001f;
                        BlockPos pos = entity.getOnPos();
                        int seaLevel = entity.getLevel().getSeaLevel();
                        int heightModifier = 1 + (1-(pos.getY()/seaLevel));
                        //After y=126 is reached, heightModifier becomes 0, then negative as pos increases.
                        //Hence no radiation occurs above y=126

                        if(!RadiationHandler.isProtectedFromBackgroundRadiation(entity)) {
                            RadiationHandler.applyRadiation(entity, (surfaceRadiationRate * heightModifier));
                        }
                    }
                });
            }
        }

    }

    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinLevelEvent event) {
        if(!event.getLevel().isClientSide()) {
            if(event.getEntity() instanceof ServerPlayer player) {
                player.getCapability(RadiationCapabilityProvider.LIVING_ENTITY_RADIATION).ifPresent(radiation -> {
                    Network.sendToClient(new RadiationDataMessage(radiation.getRadiation()), player);
                });
            }
        }
    }

}
