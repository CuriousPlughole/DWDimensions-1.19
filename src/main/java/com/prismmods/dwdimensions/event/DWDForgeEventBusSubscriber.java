package com.prismmods.dwdimensions.event;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.capability.radiation.RadiationCapabilityProvider;
import com.prismmods.dwdimensions.common.entity.effect.DWDEffectRegistry;
import com.prismmods.dwdimensions.util.KeyboardHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DWDimensions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class DWDForgeEventBusSubscriber {

    @SubscribeEvent
    public static void onTickEvent(TickEvent.ClientTickEvent event) {
        KeyboardHelper.tickKeybinds();
    }

    //FIXME

    @SubscribeEvent
    public static void onColorFog(ViewportEvent.ComputeFogColor e) {
        Entity viewer = Minecraft.getInstance().getCameraEntity();
        if(viewer != null) {
            if(viewer instanceof LivingEntity) {
                viewer.getCapability(RadiationCapabilityProvider.LIVING_ENTITY_RADIATION).ifPresent(radiation -> {
                    if(radiation.getRadiation() > 14) {
                        e.setRed(0.25f);
                        e.setBlue(0.05f);
                        e.setGreen(0.0f);
                    }
                });
            }
        }
    }

    @SubscribeEvent
    public static void onSetupFogDensity(ViewportEvent.RenderFog e) {
        Entity viewer = Minecraft.getInstance().getCameraEntity();
        if(viewer != null) {
            if(viewer instanceof LivingEntity) {
                viewer.getCapability(RadiationCapabilityProvider.LIVING_ENTITY_RADIATION).ifPresent(radiation -> {
                    if(radiation.getRadiation() > 14) {
                        e.setCanceled(true);
                        e.setNearPlaneDistance(0.01f);
                        e.setFarPlaneDistance(0.07f);
                    }
                });
            }
        }
    }
}
