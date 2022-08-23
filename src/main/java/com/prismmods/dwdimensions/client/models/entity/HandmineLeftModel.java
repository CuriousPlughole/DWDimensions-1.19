package com.prismmods.dwdimensions.client.models.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.prismmods.dwdimensions.client.animations.HandmineAnimations;
import com.prismmods.dwdimensions.common.entity.custom.HandmineEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class HandmineLeftModel extends HierarchicalModel<HandmineEntity> {

    private final ModelPart hand;
    private final ModelPart root;

    public HandmineLeftModel(ModelPart root) {
        this.root = root;
        this.hand = root.getChild("hand");
    }

    @Override
    public ModelPart root() {
        return root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition hand = partdefinition.addOrReplaceChild("hand", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition main = hand.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition thumb = main.addOrReplaceChild("thumb", CubeListBuilder.create().texOffs(8, 9).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.0F, 0.0F, 0.0F, -0.3054F, 0.0F));

        PartDefinition thumb_middle = thumb.addOrReplaceChild("thumb_middle", CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.5F, -0.5F, -0.3208F, -0.2253F, 0.6121F));

        PartDefinition thumb_end = thumb_middle.addOrReplaceChild("thumb_end", CubeListBuilder.create().texOffs(11, 13).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, -0.1919F, 0.1175F, -0.0992F));

        PartDefinition pinky_finger = main.addOrReplaceChild("pinky_finger", CubeListBuilder.create().texOffs(15, 12).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -5.0F, 0.0F, 0.2426F, -0.0169F, -0.1274F));

        PartDefinition pinky_middle = pinky_finger.addOrReplaceChild("pinky_middle", CubeListBuilder.create().texOffs(14, 8).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.25F, 0.0F, -0.5707F, -0.0093F, -0.0074F));

        PartDefinition pinky_end = pinky_middle.addOrReplaceChild("pinky_end", CubeListBuilder.create().texOffs(10, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.75F, 0.0F, -0.3491F, 0.0279F, 0.0002F));

        PartDefinition ring_finger = main.addOrReplaceChild("ring_finger", CubeListBuilder.create().texOffs(16, 3).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -5.0F, 0.0F, 0.5236F, -0.0072F, -0.043F));

        PartDefinition ring_middle = ring_finger.addOrReplaceChild("ring_middle", CubeListBuilder.create().texOffs(3, 16).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.25F, 0.0F, -0.5672F, 0.0F, 0.0F));

        PartDefinition ring_end = ring_middle.addOrReplaceChild("ring_end", CubeListBuilder.create().texOffs(14, 15).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.75F, 0.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition middle_finger = main.addOrReplaceChild("middle_finger", CubeListBuilder.create().texOffs(7, 13).addBox(-0.5F, -2.25F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -5.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition middle_middle = middle_finger.addOrReplaceChild("middle_middle", CubeListBuilder.create().texOffs(6, 18).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, -0.1309F, 0.0F, 0.0F));

        PartDefinition middle_end = middle_middle.addOrReplaceChild("middle_end", CubeListBuilder.create().texOffs(0, 18).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition index_finger = main.addOrReplaceChild("index_finger", CubeListBuilder.create().texOffs(17, 17).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -5.0F, 0.0F, 0.2182F, 0.0094F, 0.0426F));

        PartDefinition index_middle = index_finger.addOrReplaceChild("index_middle", CubeListBuilder.create().texOffs(10, 16).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.25F, 0.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition index_end = index_middle.addOrReplaceChild("index_end", CubeListBuilder.create().texOffs(12, 3).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.75F, 0.0F, -0.3054F, -0.0131F, 0.0416F));

        PartDefinition eye = main.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(10, 5).addBox(-1.0F, -3.0F, -0.64F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 0).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition lower_eyelid_r1 = eye.addOrReplaceChild("lower_eyelid_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-1.0F, 0.5F, -1.4F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, 0.6109F, 0.0F, 0.0F));

        PartDefinition upper_eyelid_r1 = eye.addOrReplaceChild("upper_eyelid_r1", CubeListBuilder.create().texOffs(12, 0).addBox(-1.0F, -1.5F, -1.4F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, -0.6109F, 0.0F, 0.0F));

        PartDefinition wrist = hand.addOrReplaceChild("wrist", CubeListBuilder.create().texOffs(0, 7).addBox(-1.5F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(HandmineEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(entity.emergeAnimationState, HandmineAnimations.LeftEmerge(entity.getEmergingModifier()), ageInTicks,2.16f);

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        hand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}

