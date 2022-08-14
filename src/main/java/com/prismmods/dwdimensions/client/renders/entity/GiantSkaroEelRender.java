package com.prismmods.dwdimensions.client.renders.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.client.models.DWDModelLayers;
import com.prismmods.dwdimensions.client.models.entity.GiantSkaroEelModel;
import com.prismmods.dwdimensions.common.entity.custom.GiantSkaroEelEntity;
import com.prismmods.dwdimensions.common.entity.custom.HandmineEntity;
import com.prismmods.dwdimensions.util.ClientUtil;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GiantSkaroEelRender extends MobRenderer<GiantSkaroEelEntity, EntityModel<GiantSkaroEelEntity>> {

    public GiantSkaroEelRender(EntityRendererProvider.Context context) {
        super(context, new GiantSkaroEelModel(context.bakeLayer(DWDModelLayers.GIANT_SKARO_EEL)), 0.1f);
    }

    @Override
    public void render(GiantSkaroEelEntity entity, float entityYaw, float partialTicks, PoseStack stack, MultiBufferSource buffer, int packedLight) {

        super.render(entity, entityYaw, partialTicks, stack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(GiantSkaroEelEntity p_114482_) {
        ResourceLocation TEXTURE = new ResourceLocation(DWDimensions.MOD_ID, "textures/entity/giant_skaro_eel.png");
        return TEXTURE;
    }
}
