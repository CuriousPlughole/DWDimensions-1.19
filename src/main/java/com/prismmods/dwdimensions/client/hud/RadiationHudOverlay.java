package com.prismmods.dwdimensions.client.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.util.ClientUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class RadiationHudOverlay {

    //Three levels of radiation - irradiated, sick, and radioactive

    private static final ResourceLocation IRRADIATED = new ResourceLocation(DWDimensions.MOD_ID,
            "textures/gui/radiation/irradiated.png");
    private static final ResourceLocation SICKNESS = new ResourceLocation(DWDimensions.MOD_ID,
            "textures/gui/radiation/sickness.png");
    private static final ResourceLocation RADIOACTIVE = new ResourceLocation(DWDimensions.MOD_ID,
            "textures/gui/radiation/radioactive.png");

    public static final IGuiOverlay HUD_RADIATION = ((gui, poseStack, partialTick, width, height) -> {
        int x = width/2;
        int y = height;

       if(Minecraft.getInstance().player.isCreative() || Minecraft.getInstance().player.isSpectator()) {
           //Dont render anything in creative or spectator
       } else {

           RenderSystem.setShader(GameRenderer::getPositionTexShader);
           RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);

           RenderSystem.setShaderTexture(0, IRRADIATED);
           for (int i = 0; i < 7; i++) {
               if (ClientUtil.RadiationData.getLivingEntityRadiation() > i) {
                   GuiComponent.blit(poseStack, x + 80 - (i * 12), y - 52, 0, 0, 12, 12,
                           12, 12);
               } else {
                   break;
               }
           }
           RenderSystem.setShaderTexture(0, SICKNESS);
           for (int i = 0; i < 7; i++) {
               if (ClientUtil.RadiationData.getLivingEntityRadiation() > i + 7) {
                   GuiComponent.blit(poseStack, x + 80 - (i * 12), y - 52, 0, 0, 12, 12,
                           12, 12);
               } else {
                   break;
               }
           }
           RenderSystem.setShaderTexture(0, RADIOACTIVE);
           for (int i = 0; i < 7; i++) {
               if (ClientUtil.RadiationData.getLivingEntityRadiation() > i + 14) {
                   GuiComponent.blit(poseStack, x + 80 - (i * 12), y - 52, 0, 0, 12, 12,
                           12, 12);
               } else {
                   break;
               }
           }
       }
    });


}
