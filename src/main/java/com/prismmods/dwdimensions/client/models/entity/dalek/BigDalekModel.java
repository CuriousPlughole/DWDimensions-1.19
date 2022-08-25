package com.prismmods.dwdimensions.client.models.entity.dalek;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.prismmods.dwdimensions.common.entity.custom.DalekEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class BigDalekModel extends HierarchicalModel<DalekEntity> {

    private final ModelPart collar;
    private final ModelPart plunger;
    private final ModelPart gun;
    private final ModelPart head;
    private final ModelPart Body;
    private final ModelPart root;

    public BigDalekModel(ModelPart root) {
        this.collar = root.getChild("collar");
        this.plunger = root.getChild("plunger");
        this.gun = root.getChild("gun");
        this.head = root.getChild("head");
        this.Body = root.getChild("Body");
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition collar = partdefinition.addOrReplaceChild("collar", CubeListBuilder.create(), PartPose.offset(0.0F, 3.8F, 1.75F));

        PartDefinition collar1 = collar.addOrReplaceChild("collar1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition collar2 = collar.addOrReplaceChild("collar2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.25F, -0.75F, 2.25F, 0.1309F, 0.0F, 0.0F));

        PartDefinition collar3 = collar.addOrReplaceChild("collar3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -0.3167F, -1.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition collar4 = collar.addOrReplaceChild("collar4", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.55F, -0.8F, 1.15F, -0.1309F, 0.0F, 0.0F));

        PartDefinition plunger = partdefinition.addOrReplaceChild("plunger", CubeListBuilder.create().texOffs(146, 100).addBox(-0.5F, -0.5F, -10.75F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(125, 78).addBox(-1.5F, -2.0F, -12.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(125, 78).addBox(1.0F, -1.5F, -12.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(125, 78).addBox(-2.0F, -1.5F, -12.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(125, 78).addBox(-1.5F, 1.0F, -12.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(125, 78).addBox(-1.5F, -1.5F, -11.75F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(125, 78).addBox(-1.0F, -1.0F, -11.25F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.75F, 3.5F, -9.25F));

        PartDefinition gun = partdefinition.addOrReplaceChild("gun", CubeListBuilder.create().texOffs(141, 47).addBox(-0.5F, -0.5F, -9.25F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(154, 45).addBox(0.0F, -1.0F, -8.25F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(147, 44).addBox(-1.0F, 0.0F, -8.25F, 2.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(4.75F, 3.5F, -8.75F));

        PartDefinition cube_r1 = gun.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(154, 45).addBox(0.0F, -1.0F, -7.25F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r2 = gun.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(154, 45).addBox(0.0F, -1.0F, -7.25F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(110, 50).addBox(-5.0F, -4.5F, -5.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(69, 68).addBox(-6.0F, -2.5F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.5F, 0.75F));

        PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(29, 165).addBox(-1.5F, -0.625F, -0.875F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.4F, -5.45F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r4 = head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(136, 17).addBox(4.0F, -2.0F, 0.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.8F, -1.25F, -0.75F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r5 = head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(136, 17).addBox(4.0F, -2.0F, 0.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.567F, -5.0768F, -0.75F, 0.0F, 0.0F, 0.3927F));

        PartDefinition cube_r6 = head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(121, 75).addBox(-1.5F, -3.625F, -0.875F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.65F, -5.95F, -0.2618F, 0.0F, 0.0F));

        PartDefinition eyestalk = head.addOrReplaceChild("eyestalk", CubeListBuilder.create().texOffs(125, 77).addBox(-1.0025F, -0.995F, -1.6337F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(125, 77).addBox(-1.0025F, -0.995F, -2.0337F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(125, 77).addBox(-1.0025F, -0.995F, -2.4337F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(118, 37).addBox(-0.5025F, -0.495F, -5.4838F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(125, 77).addBox(-1.0025F, -0.995F, -2.8338F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(125, 77).addBox(-1.0025F, -0.995F, -3.2338F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(136, 32).addBox(-1.0025F, -0.995F, -5.2338F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(123, 78).addBox(-1.0025F, -1.495F, -6.6837F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(135, 39).addBox(-0.0025F, -1.845F, -7.4838F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(135, 39).addBox(-0.0025F, 0.855F, -7.4838F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(123, 78).addBox(0.4975F, -0.995F, -6.7338F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(136, 29).addBox(-0.5025F, -0.495F, -6.9838F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(123, 78).addBox(-1.5025F, -0.995F, -6.7338F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(123, 78).addBox(-1.0025F, 0.505F, -6.7338F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0025F, -3.005F, -6.2662F));

        PartDefinition cube_r7 = eyestalk.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(135, 39).addBox(0.0F, -0.5F, -0.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0475F, 1.055F, -6.9838F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r8 = eyestalk.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(135, 39).addBox(0.0F, -0.5F, -0.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0525F, -1.095F, -6.9838F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r9 = eyestalk.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(135, 39).addBox(0.0F, -0.5F, -0.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0525F, 1.055F, -6.9838F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r10 = eyestalk.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(135, 39).addBox(0.0F, -0.5F, -0.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0975F, -1.095F, -6.9838F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r11 = eyestalk.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(135, 39).addBox(0.0F, -0.5F, -0.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3525F, 0.005F, -6.9838F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r12 = eyestalk.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(135, 39).addBox(0.0F, -0.5F, -0.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3475F, 0.005F, -6.9838F, 0.0F, 0.0F, 1.5708F));

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(100, 69).addBox(-17.0F, 12.5F, -10.0F, 16.0F, 5.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(26, 42).addBox(-15.5F, 0.5F, -7.0F, 13.0F, 6.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(30, 17).addBox(-16.0F, -1.5F, -7.5F, 14.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(33, 127).addBox(-9.5F, -1.5F, 8.51F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(45, 4).addBox(-6.75F, -5.49F, -8.75F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(45, 5).addBox(-11.75F, -4.499F, -8.75F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(121, 76).addBox(-5.25F, -4.0F, -9.25F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(89, 110).addBox(-16.5F, -2.5F, -8.0F, 15.0F, 2.0F, 17.0F, new CubeDeformation(0.0F))
                .texOffs(89, 131).addBox(-16.5F, -5.5F, -8.0F, 15.0F, 2.0F, 17.0F, new CubeDeformation(0.0F))
                .texOffs(11, 121).addBox(-16.0F, -4.5F, -7.5F, 14.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(24, 87).addBox(-16.0F, -7.5F, -6.25F, 14.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(88, 158).addBox(-15.0F, -8.95F, -5.25F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(88, 158).addBox(-15.0F, -12.0F, -5.25F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(88, 158).addBox(-15.0F, -10.5F, -5.25F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(45, 39).addBox(-14.0F, -12.5F, -4.25F, 10.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(45, 4).addBox(-16.25F, -5.49F, -8.75F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(121, 76).addBox(-14.75F, -4.0F, -9.25F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-15.0F, 1.25F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-11.65F, 1.25F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-8.35F, 1.25F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-5.0F, 1.25F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-8.35F, 4.0F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-11.65F, 4.0F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-15.0F, 4.0F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-15.0F, 7.0F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-11.65F, 7.0F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-8.35F, 7.0F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-5.0F, 7.0F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-8.35F, 9.75F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-5.0F, 9.75F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-11.65F, 9.75F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-15.0F, 9.75F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 81).addBox(-16.0F, 6.5F, -8.0F, 14.0F, 6.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-5.0F, 4.0F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 6.5F, 0.0F));

        PartDefinition cube_r13 = Body.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.25F, 6.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r14 = Body.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(4.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-2.65F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 6.5F, 0.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r15 = Body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 6.5F, 8.75F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r16 = Body.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.75F, 6.5F, -2.85F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r17 = Body.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-6.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.75F, 6.5F, 1.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r18 = Body.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-6.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, 6.5F, -1.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r19 = Body.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 6.5F, 7.75F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r20 = Body.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-2.65F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, 6.5F, -0.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r21 = Body.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(75, 23).addBox(0.65F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.751F, 6.5F, -0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r22 = Body.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(75, 23).addBox(0.65F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(0.65F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, 6.5F, 0.5F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r23 = Body.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(149, 21).addBox(-2.35F, -4.75F, -1.0F, 4.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.35F, 6.0F, 7.25F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r24 = Body.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(46, 72).addBox(-3.35F, -4.75F, -1.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.85F, 5.0F, 7.75F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r25 = Body.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(43, 82).addBox(1.65F, -4.75F, -1.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.35F, 6.0F, 7.75F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r26 = Body.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.751F, 6.5F, -1.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r27 = Body.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(4.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, 6.5F, 1.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r28 = Body.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(4.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-6.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 6.5F, 7.751F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r29 = Body.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.75F, 6.5F, -1.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r30 = Body.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(75, 23).addBox(0.65F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.75F, 6.5F, -0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r31 = Body.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.75F, 6.5F, 0.5F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r32 = Body.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.25F, 6.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r33 = Body.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-6.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 6.5F, 0.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r34 = Body.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 6.5F, 8.751F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r35 = Body.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-2.65F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.251F, 6.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r36 = Body.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 6.5F, 0.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r37 = Body.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(75, 23).addBox(0.65F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.25F, 6.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r38 = Body.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(75, 23).addBox(0.65F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(0.65F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 6.5F, 0.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r39 = Body.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(0.65F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.251F, 6.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r40 = Body.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-6.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 6.5F, 8.751F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r41 = Body.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(43, 82).addBox(-2.65F, -5.25F, 0.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.65F, 6.5F, 8.751F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r42 = Body.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.251F, 6.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        return LayerDefinition.create(meshdefinition, 200, 200);
    }


    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        collar.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        plunger.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        gun.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(DalekEntity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

    }
}
