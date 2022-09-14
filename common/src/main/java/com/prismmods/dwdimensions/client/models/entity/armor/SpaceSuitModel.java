package com.prismmods.dwdimensions.client.models.entity.armor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

public class SpaceSuitModel extends HumanoidModel<LivingEntity> {

    private final EquipmentSlot slot;

    public SpaceSuitModel(ModelPart part, EquipmentSlot slot) {
        super(part);
        this.slot = slot;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition collar = body.addOrReplaceChild("collar", CubeListBuilder.create().texOffs(24, 24).addBox(-4.0F, 1.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(60, 41).addBox(-5.0F, -1.0F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(56, 57).addBox(4.0F, -1.0F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition straps = body.addOrReplaceChild("straps", CubeListBuilder.create().texOffs(63, 67).addBox(-2.5F, 10.75F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(49, 67).addBox(0.5F, 10.75F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(68, 0).addBox(2.5F, 9.0F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(68, 19).addBox(-3.5F, 9.0F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(24, 0).addBox(-4.5F, 8.0F, -2.5F, 9.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(70, 26).addBox(-0.5F, 11.5F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(20, 69).addBox(-0.5F, 3.5F, -2.25F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition side = straps.addOrReplaceChild("side", CubeListBuilder.create().texOffs(24, 21).addBox(3.25F, 10.0F, -1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 21).addBox(-4.25F, 10.0F, -1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 21).addBox(-4.25F, 10.0F, 0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 6).addBox(3.25F, 12.0F, 1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 6).addBox(3.25F, 12.0F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 3).addBox(-4.25F, 12.0F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 6).addBox(-4.25F, 12.0F, 1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(70, 33).addBox(0.25F, 13.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(9, 64).addBox(-1.25F, 13.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(66, 57).addBox(1.25F, 12.75F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(40, 65).addBox(-3.25F, 12.75F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(24, 0).addBox(3.25F, 10.0F, 0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 21).addBox(3.25F, 9.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(-4.25F, 9.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 6).addBox(3.25F, 0.0F, -2.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 17).addBox(3.25F, 0.0F, 1.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 71).addBox(-4.25F, 0.0F, 1.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 71).addBox(-4.25F, 0.0F, -2.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(52, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(40, 33).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(52, 0).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(24, 33).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(5.0F, 2.0F, 0.0F));

        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(48, 49).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

        PartDefinition right_pouches = right_leg.addOrReplaceChild("right_pouches", CubeListBuilder.create().texOffs(0, 16).addBox(-4.9F, 7.0F, -3.2F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(52, 33).addBox(-5.4F, 8.0F, -3.2F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.8F, 0.0F, 0.0F));

        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(32, 49).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, 49).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(1.9F, 12.0F, 0.0F));

        PartDefinition left_pouches = left_leg.addOrReplaceChild("left_pouches", CubeListBuilder.create().texOffs(70, 41).addBox(-0.9F, 7.0F, -3.2F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(58, 67).addBox(-0.9F, 2.0F, -3.2F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(35, 65).addBox(-1.4F, 8.0F, -3.2F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(23, 65).addBox(-1.4F, 3.0F, -3.2F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition extra = hat.addOrReplaceChild("extra", CubeListBuilder.create().texOffs(56, 32).addBox(-1.5F, -9.5F, -2.5F, 3.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(64, 51).addBox(-1.5F, -10.5F, -2.5F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(24, 17).addBox(-5.5F, -3.5F, 4.5F, 11.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 65).addBox(-5.5F, -6.5F, -2.5F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(56, 41).addBox(4.5F, -6.5F, -2.5F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(4.5F, -3.5F, -2.5F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 64).addBox(-5.5F, -3.5F, -2.5F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.5F, -8.5F, 4.5F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition collar2 = hat.addOrReplaceChild("collar2", CubeListBuilder.create().texOffs(0, 29).addBox(-4.0F, 0.0F, 3.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 8).addBox(-4.0F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(33, 8).addBox(3.0F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(3, 27).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        if(slot == EquipmentSlot.HEAD) {
            hat.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        }

        if(slot == EquipmentSlot.CHEST) {
            body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        }

        if(slot  == EquipmentSlot.LEGS || slot == EquipmentSlot.FEET) {
            rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        }

    }


}
