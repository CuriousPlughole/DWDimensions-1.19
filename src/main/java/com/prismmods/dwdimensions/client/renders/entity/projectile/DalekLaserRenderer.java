package com.prismmods.dwdimensions.client.renders.entity.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.client.models.DWDModelLayers;
import com.prismmods.dwdimensions.client.models.entity.HandmineRightModel;
import com.prismmods.dwdimensions.client.models.entity.projectile.DalekLaserModel;
import com.prismmods.dwdimensions.common.entity.custom.projectile.DalekLaser;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class DalekLaserRenderer extends EntityRenderer<DalekLaser> {

    private static ModelPart laserModel;

    public DalekLaserRenderer(EntityRendererProvider.Context context) {
        super(context);
        laserModel = context.bakeLayer(DWDModelLayers.DALEK_LASER);
    }

    @Override
    public void render(DalekLaser laser, float yaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLight) {



        super.render(laser, yaw, partialTicks, matrixStackIn, bufferIn, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(DalekLaser laser) {
        ResourceLocation TEXTURE = new ResourceLocation(DWDimensions.MOD_ID, "textures/entity/laser/dalek_laser.png");
        return TEXTURE;
    }
}
