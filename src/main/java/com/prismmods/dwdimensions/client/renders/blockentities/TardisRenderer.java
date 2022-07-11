package com.prismmods.dwdimensions.client.renders.blockentities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.client.models.DWDModels;
import com.prismmods.dwdimensions.common.blockentities.TardisBlockEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class TardisRenderer implements BlockEntityRenderer<TardisBlockEntity>, BlockEntityRendererProvider<TardisBlockEntity> {

    private static ModelPart tardisModel;

    public TardisRenderer(Context context) {
        tardisModel = context.bakeLayer(DWDModels.TARDIS_WHITTAKER);
    }

    @Override
    public void render(TardisBlockEntity blockEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {

        float rotation = blockEntityIn.getRotation();

        matrixStackIn.pushPose();
        matrixStackIn.translate(0.5f, 1.5f, 0.5f);
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);

        matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180));
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(rotation));

        /*
        switch (objectChameleon) {
            case TENNANT:
                if (lightsOn) {
                    TEXTURE = new ResourceLocation(DWDimensions.MOD_ID, "textures/blocks/tardis/exterior/tennant_on.png");
                } else {
                    TEXTURE = new ResourceLocation(DWDimensions.MOD_ID, "textures/blocks/tardis/exterior/tennant_off.png");
                }
                IVertexBuilder renderBufferE = bufferIn.getBuffer(modelA.getRenderType(TEXTURE));
                modelA.render(matrixStackIn, renderBufferE, combinedLightIn, combinedOverlayIn, 1.0f, 1.0f, 1.0f, 1.0f, intDoorState, isSnowy);
                break;
            default:
                System.out.println("Unexpected chameleon: " + objectChameleon);
        }*/

        ResourceLocation texture = new ResourceLocation(DWDimensions.MOD_ID, "textures/blocks/tardis/exterior/13th_doctor_tardis_exterior_on.png");
        tardisModel.render(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutout(texture)), combinedLightIn, combinedOverlayIn, 1.0f, 1.0f, 1.0f, 1.0f);

        matrixStackIn.popPose();

    }

    public ResourceLocation getTexture() {
        return new ResourceLocation(DWDimensions.MOD_ID, "textures/blocks/tardis/exterior/13th_doctor_tardis_exterior_on.png");
    }

    @Override
    public @NotNull BlockEntityRenderer<TardisBlockEntity> create(@NotNull Context context) {

        return new TardisRenderer(context);
    }

}
