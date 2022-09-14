package com.prismmods.dwdimensions.client.renders.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.client.models.DWDModelLayers;
import com.prismmods.dwdimensions.client.models.entity.HandmineRightModel;
import com.prismmods.dwdimensions.common.entity.custom.HandmineEntity;
import com.prismmods.dwdimensions.util.ClientUtil;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HandmineRender extends MobRenderer<HandmineEntity, EntityModel<HandmineEntity>> {
    public HandmineRender(EntityRendererProvider.Context context) {
        super(context, new HandmineRightModel(context.bakeLayer(DWDModelLayers.RIGHT_HANDMINE)), 0.1f);
    }

    @Override
    public void render(HandmineEntity entity, float entityYaw, float partialTicks, PoseStack stack, MultiBufferSource buffer, int packedLight) {

        String side = entity.getSide();

        if(side == "left") {model = ClientUtil.getModelForHandmine(ClientUtil.HandmineSide.LEFT);}
        else {
            model = ClientUtil.getModelForHandmine(ClientUtil.HandmineSide.RIGHT);
        }

        super.render(entity, entityYaw, partialTicks, stack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(HandmineEntity entity) {
        ResourceLocation TEXTURE = new ResourceLocation(DWDimensions.MOD_ID, "textures/entity/new_handmine.png");
        return TEXTURE;
    }
}
