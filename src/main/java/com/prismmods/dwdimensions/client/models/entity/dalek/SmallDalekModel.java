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



public class SmallDalekModel extends HierarchicalModel<DalekEntity> {

    private final ModelPart plunger;
    private final ModelPart gun;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart collar;
    private final ModelPart root;

    public SmallDalekModel(ModelPart root) {
        this.plunger = root.getChild("plunger");
        this.gun = root.getChild("gun");
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.collar = root.getChild("collar");
        this.root = root;
    }



    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition plunger = partdefinition.addOrReplaceChild("plunger", CubeListBuilder.create().texOffs(151, 24).addBox(-0.5F, -0.5F, -11.5F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(132, 36).addBox(-1.0F, -1.0F, -11.25F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(132, 36).addBox(-1.5F, -1.5F, -11.75F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(132, 36).addBox(-1.5F, -2.0F, -12.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(132, 36).addBox(-2.0F, -1.5F, -12.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(132, 36).addBox(-1.5F, 1.0F, -12.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(132, 36).addBox(1.0F, -1.5F, -12.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.75F, 6.0F, -7.75F));

        PartDefinition gun = partdefinition.addOrReplaceChild("gun", CubeListBuilder.create().texOffs(143, 49).addBox(-0.5F, -0.5F, -6.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(154, 46).addBox(0.0F, -1.0F, -6.25F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(148, 45).addBox(-1.0F, 0.0F, -6.25F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(126, 170).addBox(-0.5F, -0.5F, -6.5F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(4.75F, 6.0F, -7.75F));

        PartDefinition cube_r1 = gun.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(154, 46).addBox(0.0F, -1.0F, -6.25F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r2 = gun.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(154, 46).addBox(0.0F, -1.0F, -6.25F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r3 = gun.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(154, 46).addBox(0.0F, -1.0F, -2.25F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.25F, 0.0F, -0.5F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r4 = gun.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(154, 46).addBox(0.0F, -1.0F, -2.25F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.25F, 0.0F, -2.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r5 = gun.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(154, 46).addBox(0.0F, -1.0F, -2.25F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.25F, 0.0F, -4.1F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r6 = gun.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(154, 46).addBox(0.0F, -1.0F, -2.25F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.25F, 0.0F, -6.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(110, 50).addBox(-5.0F, -2.5F, -5.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(69, 68).addBox(-6.0F, -0.5F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(125, 20).addBox(-0.5F, -2.4882F, -5.4847F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.5F, 0.75F));

        PartDefinition cube_r7 = head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(123, 17).addBox(-0.5F, -1.8273F, -0.8621F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -5.125F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r8 = head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(145, 17).addBox(4.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.8F, 0.75F, -0.75F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r9 = head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(145, 17).addBox(4.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.567F, -3.0768F, -0.75F, 0.0F, 0.0F, 0.3927F));

        PartDefinition EyeStalk = head.addOrReplaceChild("EyeStalk", CubeListBuilder.create().texOffs(139, 26).addBox(-1.0F, -1.0F, -3.4833F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(139, 26).addBox(-1.0F, -1.0F, -3.8833F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(139, 26).addBox(-1.0F, -1.0F, -4.2833F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(118, 37).addBox(-0.5F, -0.5F, -7.3333F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(139, 26).addBox(-1.0F, -1.0F, -4.6833F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(139, 26).addBox(-1.0F, -1.0F, -5.0833F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(141, 41).addBox(-1.0F, -1.0F, -7.3333F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(141, 42).addBox(-1.0F, -1.5F, -8.3333F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(143, 41).addBox(0.5F, -1.0F, -8.3333F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(136, 29).addBox(-0.25F, -0.75F, -8.3833F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(136, 29).addBox(-0.25F, -0.25F, -8.3833F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(136, 29).addBox(-0.75F, -0.75F, -8.3833F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(136, 29).addBox(-0.75F, -0.25F, -8.3833F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(136, 28).addBox(-0.5F, -0.5F, -8.0833F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(143, 41).addBox(-1.5F, -1.0F, -8.3333F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(141, 42).addBox(-1.0F, 0.5F, -8.3333F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -4.4167F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(100, 69).addBox(-17.0F, 15.5F, -10.0F, 16.0F, 2.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(26, 42).addBox(-15.5F, 3.5F, -7.0F, 13.0F, 6.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(30, 17).addBox(-16.0F, 1.5F, -7.5F, 14.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(46, 7).addBox(-6.25F, -2.5F, -7.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(59, 44).addBox(-5.25F, -1.5F, -7.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(81, 94).addBox(-15.5F, -0.5F, -5.75F, 13.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(81, 17).addBox(-15.5F, -3.5F, -5.75F, 13.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(80, 34).addBox(-15.0F, -2.5F, -5.25F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(124, 116).addBox(-15.0F, -5.5F, -5.25F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(85, 59).addBox(-14.5F, -10.5F, -2.25F, 11.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(124, 100).addBox(-15.0F, -7.45F, -5.25F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(124, 100).addBox(-15.0F, -9.5F, -5.25F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(45, 39).addBox(-14.0F, -10.5F, -4.25F, 10.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(85, 59).addBox(-14.5F, -10.5F, 2.75F, 11.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(85, 49).addBox(-7.0F, -10.5F, -4.75F, 1.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(85, 49).addBox(-12.0F, -10.5F, -4.75F, 1.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(46, 7).addBox(-15.75F, -2.5F, -7.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(59, 44).addBox(-14.75F, -1.5F, -7.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-15.0F, 4.25F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-11.65F, 4.25F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-8.35F, 4.25F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-5.0F, 4.25F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-8.35F, 7.0F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-11.65F, 7.0F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-15.0F, 7.0F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-15.0F, 10.0F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-11.65F, 10.0F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-8.35F, 10.0F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-5.0F, 10.0F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-8.35F, 12.75F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-5.0F, 12.75F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-11.65F, 12.75F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-15.0F, 12.75F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 81).addBox(-16.0F, 9.5F, -8.0F, 14.0F, 6.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-5.0F, 7.0F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 6.5F, 0.0F));

        PartDefinition cube_r10 = body.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.25F, 9.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r11 = body.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(4.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-2.65F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 9.5F, 0.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r12 = body.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 9.5F, 8.75F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r13 = body.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.75F, 9.5F, -2.85F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r14 = body.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-6.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.75F, 9.5F, 1.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r15 = body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-6.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, 9.5F, -1.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r16 = body.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(0.65F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(0.65F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 9.5F, 7.75F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r17 = body.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-2.65F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, 9.5F, -0.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r18 = body.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(4.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(4.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-2.65F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-6.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 9.5F, 7.751F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r19 = body.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(75, 23).addBox(0.65F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.751F, 9.5F, -0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r20 = body.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(75, 23).addBox(0.65F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(0.65F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, 9.5F, 0.5F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r21 = body.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.751F, 9.5F, -1.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r22 = body.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(4.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, 9.5F, 1.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r23 = body.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.75F, 9.5F, -1.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r24 = body.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(75, 23).addBox(0.65F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.75F, 9.5F, -0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r25 = body.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.75F, 9.5F, 0.5F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r26 = body.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.25F, 9.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r27 = body.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-6.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 9.5F, 0.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r28 = body.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(0.65F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 9.5F, 8.751F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r29 = body.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-2.65F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.251F, 9.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r30 = body.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 9.5F, 0.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r31 = body.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 9.5F, 8.751F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r32 = body.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(75, 23).addBox(0.65F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.25F, 9.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r33 = body.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(75, 23).addBox(0.65F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(0.65F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 9.5F, 0.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r34 = body.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(0.65F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.251F, 9.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r35 = body.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-6.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 9.5F, 8.751F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r36 = body.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(75, 23).addBox(0.65F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 9.5F, 8.751F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r37 = body.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 9.5F, 8.751F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r38 = body.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.251F, 9.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition collar = partdefinition.addOrReplaceChild("collar", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition collar1 = collar.addOrReplaceChild("collar1", CubeListBuilder.create().texOffs(89, 17).addBox(5.8695F, -1.5086F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(5.8695F, -1.5086F, 1.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(5.8695F, -1.5086F, -2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(5.8695F, -1.5086F, -4.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(5.8695F, -1.5086F, -6.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(5.8695F, -1.5086F, 3.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -20.2F, 1.75F, 0.0F, 0.0F, -0.1309F));

        PartDefinition collar2 = collar.addOrReplaceChild("collar2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.25F, -20.95F, 4.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r39 = collar2.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(89, 17).addBox(4.3238F, 1.3385F, 1.25F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -2.5F, -1.75F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r40 = collar2.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(89, 17).addBox(4.3238F, 1.3385F, 1.25F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -2.5F, -1.75F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r41 = collar2.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(89, 17).addBox(4.3238F, 1.3385F, 1.25F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -2.5F, -1.75F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r42 = collar2.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(89, 17).addBox(4.3238F, 1.3385F, 1.25F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -2.5F, -1.75F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r43 = collar2.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(89, 17).addBox(4.3238F, 1.3385F, 1.25F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -2.5F, -1.75F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r44 = collar2.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(89, 17).addBox(4.3238F, 1.3385F, 1.25F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -2.5F, -1.75F, 0.0F, -1.5708F, 0.0F));

        PartDefinition collar3 = collar.addOrReplaceChild("collar3", CubeListBuilder.create().texOffs(89, 17).addBox(-5.3695F, -1.3419F, 4.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(-5.3695F, -1.3419F, 2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(-5.3695F, -1.3419F, 0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(-5.3695F, -1.3419F, -1.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(-5.3695F, -1.3419F, -3.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(-5.3695F, -1.3419F, -5.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -20.5167F, 0.75F, 0.0F, 0.0F, 0.1309F));

        PartDefinition collar4 = collar.addOrReplaceChild("collar4", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.55F, -21.0F, 2.9F, -0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r45 = collar4.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(84, 17).addBox(-8.1151F, 1.0084F, 1.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.65F, -1.5F, -0.9F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r46 = collar4.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(84, 17).addBox(-8.0159F, 0.9953F, -0.75F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(27, 71).addBox(-9.0825F, 1.2562F, -6.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(27, 71).addBox(-9.0825F, 1.2562F, 2.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(27, 71).addBox(-8.9846F, 1.9998F, -2.25F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(84, 17).addBox(-8.1151F, 1.0084F, 1.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.65F, -1.5F, -0.9F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r47 = collar4.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(75, 6).addBox(-5.1126F, 3.3254F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(75, 15).addBox(-5.6151F, -0.4916F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, 0.0F, -3.4F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r48 = collar4.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(84, 17).addBox(-8.0159F, 0.9953F, 3.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(84, 17).addBox(-8.1151F, 1.0084F, 1.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.35F, -1.5F, -0.9F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r49 = collar4.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(84, 17).addBox(-8.1151F, 1.0084F, 1.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.35F, -1.5F, -0.9F, 0.0F, -1.5708F, 0.0F));

        return LayerDefinition.create(meshdefinition, 200, 200);
    }


    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        plunger.render(poseStack, buffer, packedLight, packedOverlay);
        gun.render(poseStack, buffer, packedLight, packedOverlay);
        head.render(poseStack, buffer, packedLight, packedOverlay);
        body.render(poseStack, buffer, packedLight, packedOverlay);
        collar.render(poseStack, buffer, packedLight, packedOverlay);
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(DalekEntity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

    }
}