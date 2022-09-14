package com.prismmods.dwdimensions.client.renders.blockentities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.client.models.DWDModelLayers;
import com.prismmods.dwdimensions.common.blockentities.tardis.Chameleon;
import com.prismmods.dwdimensions.common.blockentities.tardis.DoorStatus;
import com.prismmods.dwdimensions.common.blockentities.tardis.TardisBlockEntity;
import com.prismmods.dwdimensions.util.ClientUtil;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.RenderTypeHelper;
import org.codehaus.plexus.util.dag.Vertex;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class TardisRenderer implements BlockEntityRenderer<TardisBlockEntity>, BlockEntityRendererProvider<TardisBlockEntity> {

    private static ModelPart tardisModel;

    public TardisRenderer(Context context) {
        tardisModel = context.bakeLayer(DWDModelLayers.TARDIS_WHITTAKER);
    }

    @Override
    public void render(TardisBlockEntity blockEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {

        float rotation = blockEntityIn.getRotationInDeg();
        boolean lights = blockEntityIn.getLightState();

        tardisModel = ClientUtil.getTardisModel(blockEntityIn.getChameleon());

        //DOOR STUFF
        ModelPart rightDoor = tardisModel.getChild("right_door");
        ModelPart leftDoor = tardisModel.getChild("left_door");
        if(blockEntityIn.getDoorState() == DoorStatus.HALF_OPEN) {
            rightDoor.yRot = 0f;
            leftDoor.yRot = 20.0f;
        }
        if(blockEntityIn.getDoorState() == DoorStatus.OPEN) {
            rightDoor.yRot = -20.0f;
            leftDoor.yRot = 20.0f;
        }
        if(blockEntityIn.getDoorState() == DoorStatus.CLOSED) {
            rightDoor.yRot = 0.0f;
            leftDoor.yRot = 0.0f;
        }

        matrixStackIn.pushPose();
        matrixStackIn.scale(0.62f, 0.62f, 0.62f);
        matrixStackIn.translate(0.8f, 1.5f, 0.8f);

        matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180));
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(rotation));

        tardisModel.render(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutout(getTexture(lights, blockEntityIn.getChameleon()))), combinedLightIn, combinedOverlayIn, 1.0f, 1.0f, 1.0f, 1.0f);

        matrixStackIn.popPose();
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

    @Override
    public @NotNull BlockEntityRenderer<TardisBlockEntity> create(@NotNull Context context) {
        return new TardisRenderer(context);
    }


}

