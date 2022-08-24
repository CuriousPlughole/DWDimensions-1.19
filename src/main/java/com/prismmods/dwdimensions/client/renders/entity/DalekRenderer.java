package com.prismmods.dwdimensions.client.renders.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.client.models.DWDModelLayers;
import com.prismmods.dwdimensions.client.models.entity.HandmineRightModel;
import com.prismmods.dwdimensions.client.models.entity.dalek.MediumDalekModel;
import com.prismmods.dwdimensions.common.entity.custom.DalekEntity;
import com.prismmods.dwdimensions.common.entity.custom.HandmineEntity;
import com.prismmods.dwdimensions.util.ClientUtil;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DalekRenderer extends MobRenderer<DalekEntity, EntityModel<DalekEntity>> {
    public DalekRenderer(EntityRendererProvider.Context context) {
        super(context, new MediumDalekModel(context.bakeLayer(DWDModelLayers.MEDIUM_DALEK)), 0.7f);
    }

    @Override
    public void render(DalekEntity entity, float entityYaw, float partialTicks, PoseStack stack, MultiBufferSource buffer, int packedLight) {

        model = ClientUtil.DalekModelGetter.getModelForType(entity.getDalekType());
        super.render(entity, entityYaw, partialTicks, stack, buffer, packedLight);

    }

    @Override
    public ResourceLocation getTextureLocation(DalekEntity entity) {
        String dalekType = entity.getDalekType();
        return new ResourceLocation(DWDimensions.MOD_ID, "textures/entity/dalek/dalek_"+dalekType+".png");
    }
}
