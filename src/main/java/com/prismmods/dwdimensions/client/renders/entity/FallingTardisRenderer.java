package com.prismmods.dwdimensions.client.renders.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.client.models.DWDModelLayers;
import com.prismmods.dwdimensions.common.blockentities.tardis.Chameleon;
import com.prismmods.dwdimensions.common.blockentities.tardis.DoorStatus;
import com.prismmods.dwdimensions.common.entity.custom.FallingTardisEntity;
import com.prismmods.dwdimensions.common.entity.custom.HandmineEntity;
import com.prismmods.dwdimensions.util.ClientUtil;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.FallingBlockEntity;

public class FallingTardisRenderer extends EntityRenderer<FallingTardisEntity> {

    private static ModelPart tardisModel;

    public FallingTardisRenderer(EntityRendererProvider.Context context) {
        super(context);
        tardisModel = context.bakeLayer(DWDModelLayers.TARDIS_WHITTAKER);

    }

    @Override
    public void render(FallingTardisEntity fallingTardisEntity, float yaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLight) {

        tardisModel = ClientUtil.getTardisModel(Chameleon.getChameleonValue(fallingTardisEntity.getChameleon()));

        ModelPart rightDoor = tardisModel.getChild("right_door");
        ModelPart leftDoor = tardisModel.getChild("left_door");
        if(fallingTardisEntity.getDoorState() == DoorStatus.HALF_OPEN.getNbtName()) {
            rightDoor.yRot = 0f;
            leftDoor.yRot = 20.0f;
        }
        if(fallingTardisEntity.getDoorState() == DoorStatus.OPEN.getNbtName()) {
            rightDoor.yRot = -20.0f;
            leftDoor.yRot = 20.0f;
        }
        if(fallingTardisEntity.getDoorState() == DoorStatus.CLOSED.getNbtName()) {
            rightDoor.yRot = 0.0f;
            leftDoor.yRot = 0.0f;
        }


        matrixStackIn.pushPose();
        matrixStackIn.scale(0.62f, 0.62f, 0.62f);

        matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180));
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(fallingTardisEntity.getRotation()));

        tardisModel.render(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutout(getTextureLocation(fallingTardisEntity))), packedLight, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);

        matrixStackIn.popPose();

        super.render(fallingTardisEntity, yaw, partialTicks, matrixStackIn, bufferIn, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(FallingTardisEntity entity) {
        //return getTexture(entity.lightsOn, entity.chameleon);

        return getTexture(entity.getLights(), Chameleon.getChameleonValue(entity.getChameleon()));
    }

    public ResourceLocation getTexture(Boolean lightsOn, Chameleon chameleon) {
        String lights_modifier = (lightsOn) ? "_on" : "_off";
        String texture;
        switch (chameleon) {
            case CAPALDI -> texture = "12th_doctor_tardis_exterior";
            case SMITH_SCORCHED -> texture = "11th_doctor_tardis_exterior_scorched";
            case SMITH_7B -> texture = "11th_doctor_tardis_exterior_7b";
            case SMITH -> texture = "11th_doctor_tardis_exterior";
            case TENNANT -> texture = "10th_doctor_tardis_exterior";
            case ECCLESTON -> texture = "9th_doctor_tardis_exterior";
            default -> texture = "13th_doctor_tardis_exterior"; //WHITTAKER included here
        }
        return new ResourceLocation(DWDimensions.MOD_ID, "textures/block/tardis/"+texture+lights_modifier+".png");
    }

}

