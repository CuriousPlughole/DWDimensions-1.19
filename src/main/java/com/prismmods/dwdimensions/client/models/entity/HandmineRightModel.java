package com.prismmods.dwdimensions.client.models.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.prismmods.dwdimensions.common.entity.custom.HandmineEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class HandmineRightModel extends EntityModel<HandmineEntity> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    private final ModelPart bone2;

    public HandmineRightModel(ModelPart root) {
        this.bone2 = root.getChild("bone2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -1.0F));

        PartDefinition bone = bone2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(12, 17).addBox(-2.2167F, 0.1667F, -1.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 13).addBox(-0.3167F, 1.8716F, -1.3012F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(23, 13).addBox(-1.1167F, 1.8716F, -1.3012F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(31, 13).addBox(-0.7167F, 1.9003F, -1.3422F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2167F, -4.6667F, 3.0F, -0.6981F, 0.0F, 0.0F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(13, 20).addBox(-2.0F, -0.501F, -1.4564F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2833F, 4.7824F, 0.5337F, 0.5672F, 0.0F, 0.0F));

        PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(15, 14).addBox(-1.0F, 0.2159F, -0.2244F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2167F, 2.4413F, -0.2422F, -1.0036F, 0.0F, 0.0F));

        PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(14, 13).addBox(-1.0F, -0.5742F, -1.1808F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2167F, 2.4413F, -0.2422F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(14, 17).addBox(-0.9654F, -0.9258F, -0.9426F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2996F, 3.8377F, 0.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(25, 18).addBox(-0.314F, -3.7248F, -0.5751F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9167F, 0.4167F, 0.0F, 0.5236F, -0.0665F, -0.1615F));

        PartDefinition cube_r6 = bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(30, 18).addBox(-2.0F, -4.0F, 1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7833F, 4.6667F, -1.5F, 0.2618F, 0.0F, 0.4363F));

        PartDefinition cube_r7 = bone.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(40, 18).addBox(-0.6444F, -3.7869F, -0.4893F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3833F, 0.4167F, 0.0F, 0.6109F, 0.0F, 0.1309F));

        PartDefinition cube_r8 = bone.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(35, 18).addBox(-0.5161F, -4.7996F, -0.5001F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2833F, 0.4167F, 0.0F, 0.6981F, 0.0113F, 0.0421F));

        PartDefinition cube_r9 = bone.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(30, 18).addBox(-0.4212F, -4.4976F, -0.5031F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8167F, 0.4167F, 0.0F, 0.6109F, -0.0113F, -0.0421F));

        return LayerDefinition.create(meshdefinition, 200, 200);
    }

    @Override
    public void setupAnim(HandmineEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}