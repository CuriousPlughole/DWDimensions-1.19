package com.prismmods.dwdimensions.client.models.blockentity.tardis;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class TardisTennantEcclestonModel extends EntityModel<Entity> {

    private final ModelPart left_door;
    private final ModelPart right_door;
    private final ModelPart body;

    public TardisTennantEcclestonModel(ModelPart root) {
        this.left_door = root.getChild("left_door");
        this.right_door = root.getChild("right_door");
        this.body = root.getChild("body");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition left_door = partdefinition.addOrReplaceChild("left_door", CubeListBuilder.create(), PartPose.offset(15.0F, 21.0F, -16.0F));

        PartDefinition cube_r1 = left_door.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(95, 208).addBox(-14.0F, -58.0F, -1.0F, 14.0F, 56.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition right_door = partdefinition.addOrReplaceChild("right_door", CubeListBuilder.create(), PartPose.offset(-15.0F, 21.0F, -16.0F));

        PartDefinition cube_r2 = right_door.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(60, 208).addBox(0.0F, -58.0F, -1.0F, 16.0F, 56.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(123, 137).addBox(15.0F, -65.0F, -19.0F, 4.0F, 64.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(87, 58).addBox(15.0F, -65.0F, 15.0F, 4.0F, 64.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(123, 137).addBox(-19.0F, -65.0F, -19.0F, 4.0F, 64.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(126, 208).addBox(-15.0F, -58.0F, -18.0F, 30.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(203, 148).addBox(-18.0F, -64.0F, -20.0F, 36.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(203, 158).addBox(-18.0F, -68.0F, -18.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(203, 158).addBox(15.0F, -68.0F, -18.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(203, 158).addBox(15.0F, -68.0F, 15.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(203, 158).addBox(-18.0F, -68.0F, 15.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(78, 346).addBox(-20.0F, -1.0F, -20.0F, 40.0F, 2.0F, 40.0F, new CubeDeformation(0.0F))
                .texOffs(140, 93).addBox(-17.0F, -69.0F, -17.0F, 34.0F, 5.0F, 34.0F, new CubeDeformation(0.0F))
                .texOffs(249, 160).addBox(-16.0F, -62.0F, -17.0F, 32.0F, 5.0F, 33.0F, new CubeDeformation(0.0F))
                .texOffs(94, 299).addBox(-15.0F, -72.0F, -15.0F, 30.0F, 3.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(126, 211).addBox(-4.0F, -74.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(141, 238).addBox(-2.0F, -75.0F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(137, 228).addBox(0.0F, -75.0F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(143, 228).addBox(-3.0F, -75.0F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(126, 211).addBox(2.0F, -81.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(139, 222).addBox(-1.0F, -84.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(126, 222).addBox(-2.0F, -81.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(126, 234).addBox(-2.5F, -83.0F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 0.0F));

        PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(126, 211).addBox(2.0F, -82.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(126, 211).addBox(2.0F, -82.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(203, 148).addBox(-18.0F, -65.0F, -20.0F, 36.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(126, 208).addBox(-15.0F, -59.0F, -18.0F, 30.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(126, 211).addBox(2.0F, -82.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(203, 148).addBox(-18.0F, -65.0F, -20.0F, 36.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(203, 148).addBox(-18.0F, -65.0F, -20.0F, 36.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(126, 208).addBox(-15.0F, -59.0F, -18.0F, 30.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r8 = body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(126, 208).addBox(-15.0F, -59.0F, -18.0F, 30.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r9 = body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(69, 58).addBox(-2.0F, -32.0F, -2.0F, 4.0F, 64.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, -33.0F, 17.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r10 = body.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(60, 148).addBox(-14.0F, -29.0F, -2.5F, 30.0F, 56.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.5F, -28.0F, 1.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r11 = body.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(294, 195).addBox(-15.0F, -29.0F, -1.5F, 30.0F, 56.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.5F, -28.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r12 = body.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(140, 148).addBox(-15.0F, -29.0F, -1.5F, 30.0F, 56.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.0F, 15.5F, -3.1416F, 0.0F, 3.1416F));

        return LayerDefinition.create(meshdefinition, 400, 400);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        left_door.render(poseStack, buffer, packedLight, packedOverlay);
        right_door.render(poseStack, buffer, packedLight, packedOverlay);
        body.render(poseStack, buffer, packedLight, packedOverlay);
    }
}