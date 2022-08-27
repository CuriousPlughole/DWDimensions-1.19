package com.prismmods.dwdimensions.client.models.entity.dalek;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.prismmods.dwdimensions.client.animations.DalekAnimations;
import com.prismmods.dwdimensions.common.entity.custom.dalek.DalekEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;


public class MediumDalekModel extends HierarchicalModel<DalekEntity> {

    private final ModelPart dalek;
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart eyestalk;

    public MediumDalekModel(ModelPart root) {
        this.dalek = root.getChild("dalek");
        this.root = root;
        this.head = dalek.getChild("head");
        this.eyestalk = head.getChild("eyestalk");
    }

    @Override
    public ModelPart root() {
        return root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition dalek = partdefinition.addOrReplaceChild("dalek", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition collar = dalek.addOrReplaceChild("collar", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition collar1 = collar.addOrReplaceChild("collar1", CubeListBuilder.create().texOffs(89, 17).addBox(6.0F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(27, 71).addBox(6.0F, -1.5F, -1.25F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(27, 71).addBox(6.0653F, -1.9957F, 2.75F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(27, 71).addBox(6.0326F, -1.7479F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(6.0F, -2.5F, 1.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(6.0F, -2.5F, -2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(6.0F, -2.5F, -4.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(6.0F, -2.5F, -6.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(6.0F, -2.5F, 3.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -20.2F, 1.75F, 0.0F, 0.0F, -0.1309F));

        PartDefinition collar2 = collar.addOrReplaceChild("collar2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.25F, -20.95F, 4.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r1 = collar2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(89, 17).addBox(4.4543F, 0.347F, 1.25F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -2.5F, -1.75F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r2 = collar2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(89, 17).addBox(4.4543F, 0.347F, 1.25F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -2.5F, -1.75F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r3 = collar2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(27, 71).addBox(4.4458F, 1.4775F, -4.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(27, 71).addBox(4.511F, 0.9818F, -0.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(27, 71).addBox(4.3479F, 2.2211F, 3.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(4.4543F, 0.347F, 1.25F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -2.5F, -1.75F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r4 = collar2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(89, 17).addBox(4.4543F, 0.347F, 1.25F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -2.5F, -1.75F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r5 = collar2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(89, 17).addBox(4.4543F, 0.347F, 1.25F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -2.5F, -1.75F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r6 = collar2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(89, 17).addBox(4.4543F, 0.347F, 1.25F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -2.5F, -1.75F, 0.0F, -1.5708F, 0.0F));

        PartDefinition collar3 = collar.addOrReplaceChild("collar3", CubeListBuilder.create().texOffs(89, 17).addBox(-5.5F, -2.3333F, 4.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(-5.5F, -2.3333F, 2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(-5.5F, -2.3333F, 0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(27, 71).addBox(-6.5F, -1.3333F, 2.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(27, 71).addBox(-6.5979F, -2.0769F, -2.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(27, 71).addBox(-6.4674F, -1.0855F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(-5.5F, -2.3333F, -1.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(-5.5F, -2.3333F, -3.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 17).addBox(-5.5F, -2.3333F, -5.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -20.5167F, 0.75F, 0.0F, 0.0F, 0.1309F));

        PartDefinition collar4 = collar.addOrReplaceChild("collar4", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.55F, -21.0F, 2.9F, -0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r7 = collar4.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(84, 17).addBox(-8.2456F, 0.0169F, 1.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.65F, -1.5F, -0.9F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r8 = collar4.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(84, 17).addBox(-8.1465F, 0.0039F, -0.75F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(27, 71).addBox(-9.213F, 0.2648F, -6.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(27, 71).addBox(-9.213F, 0.2648F, 2.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(27, 71).addBox(-9.1151F, 1.0084F, -2.25F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(84, 17).addBox(-8.2456F, 0.0169F, 1.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.65F, -1.5F, -0.9F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r9 = collar4.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(75, 6).addBox(-5.2431F, 2.334F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(75, 15).addBox(-5.7456F, -1.4831F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, 0.0F, -3.4F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r10 = collar4.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(84, 17).addBox(-8.1465F, 0.0039F, 3.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(84, 17).addBox(-8.2456F, 0.0169F, 1.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.35F, -1.5F, -0.9F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r11 = collar4.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(84, 17).addBox(-8.2456F, 0.0169F, 1.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.35F, -1.5F, -0.9F, 0.0F, -1.5708F, 0.0F));

        PartDefinition body = dalek.addOrReplaceChild("body", CubeListBuilder.create().texOffs(100, 69).addBox(-17.0F, 14.5F, -10.0F, 16.0F, 3.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(26, 42).addBox(-15.5F, 2.5F, -7.0F, 13.0F, 6.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(30, 17).addBox(-16.0F, 0.5F, -7.5F, 14.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(46, 7).addBox(-6.25F, -3.5F, -7.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(59, 44).addBox(-5.25F, -2.5F, -7.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(81, 94).addBox(-15.5F, -1.5F, -5.75F, 13.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(81, 17).addBox(-15.5F, -4.5F, -5.75F, 13.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(80, 34).addBox(-15.0F, -3.5F, -5.25F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(124, 116).addBox(-15.0F, -6.5F, -5.25F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(85, 59).addBox(-14.5F, -11.5F, -2.25F, 11.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(124, 100).addBox(-15.0F, -8.45F, -5.25F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(124, 100).addBox(-15.0F, -10.5F, -5.25F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(45, 39).addBox(-14.0F, -11.5F, -4.25F, 10.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(85, 59).addBox(-14.5F, -11.5F, 2.75F, 11.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(85, 49).addBox(-7.0F, -11.5F, -4.75F, 1.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(85, 49).addBox(-12.0F, -11.5F, -4.75F, 1.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(46, 7).addBox(-15.75F, -3.5F, -7.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(59, 44).addBox(-14.75F, -2.5F, -7.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-15.0F, 3.25F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-11.65F, 3.25F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-8.35F, 3.25F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-5.0F, 3.25F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-8.35F, 6.0F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-11.65F, 6.0F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-15.0F, 6.0F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-15.0F, 9.0F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-11.65F, 9.0F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-8.35F, 9.0F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-5.0F, 9.0F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-8.35F, 11.75F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-5.0F, 11.75F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-11.65F, 11.75F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-15.0F, 11.75F, -8.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 81).addBox(-16.0F, 8.5F, -8.0F, 14.0F, 6.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-5.0F, 6.0F, -7.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, -17.5F, 0.0F));

        PartDefinition cube_r12 = body.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.25F, 8.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r13 = body.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(4.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-2.65F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 8.5F, 0.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r14 = body.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 8.5F, 8.75F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r15 = body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.75F, 8.5F, -2.85F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r16 = body.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-6.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.75F, 8.5F, 1.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r17 = body.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-6.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, 8.5F, -1.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r18 = body.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(0.65F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(0.65F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 8.5F, 7.75F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r19 = body.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-2.65F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, 8.5F, -0.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r20 = body.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(4.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(4.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-2.65F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-6.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 8.5F, 7.751F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r21 = body.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(75, 23).addBox(0.65F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.751F, 8.5F, -0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r22 = body.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(75, 23).addBox(0.65F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(0.65F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, 8.5F, 0.5F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r23 = body.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.751F, 8.5F, -1.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r24 = body.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, 3.25F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(4.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, 8.5F, 1.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r25 = body.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.75F, 8.5F, -1.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r26 = body.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(75, 23).addBox(0.65F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.75F, 8.5F, -0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r27 = body.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, 0.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.75F, 8.5F, 0.5F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r28 = body.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.25F, 8.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r29 = body.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-6.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 8.5F, 0.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r30 = body.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(0.65F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 8.5F, 8.751F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r31 = body.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-2.65F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.251F, 8.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r32 = body.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 8.5F, 0.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r33 = body.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 8.5F, 8.751F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r34 = body.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(75, 23).addBox(0.65F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.25F, 8.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r35 = body.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(75, 23).addBox(0.65F, -2.5F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(0.65F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 8.5F, 0.25F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r36 = body.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(0.65F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.251F, 8.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r37 = body.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(75, 23).addBox(4.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(75, 23).addBox(-6.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 8.5F, 8.751F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r38 = body.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(75, 23).addBox(0.65F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 8.5F, 8.751F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r39 = body.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(75, 23).addBox(-2.65F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 8.5F, 8.751F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r40 = body.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(75, 23).addBox(-6.0F, -5.25F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.251F, 8.5F, 0.25F, 0.0F, 1.5708F, 0.0F));

        PartDefinition head = dalek.addOrReplaceChild("head", CubeListBuilder.create().texOffs(110, 50).addBox(-5.0F, -3.5F, -5.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(69, 68).addBox(-6.0F, -1.5F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(125, 20).addBox(-0.5F, -3.4882F, -5.4847F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -30.5F, 0.75F));

        PartDefinition cube_r41 = head.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(153, 64).addBox(-1.5F, 0.375F, -0.875F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.8F, -4.95F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r42 = head.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(153, 64).addBox(-1.5F, 0.375F, -0.875F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.3659F, -5.1912F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r43 = head.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(153, 64).addBox(-1.5F, 0.375F, -0.875F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1F, -5.45F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r44 = head.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(123, 17).addBox(-0.5F, -1.8273F, -0.8621F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, -5.125F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r45 = head.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(29, 165).addBox(-1.5F, -0.625F, -0.875F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(157, 71).addBox(-3.5F, -0.142F, -0.7456F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(152, 60).addBox(0.5F, -3.625F, -0.875F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(157, 75).addBox(1.5F, -0.142F, -0.7456F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(152, 60).addBox(-1.5F, -3.625F, -0.875F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, -5.45F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r46 = head.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(124, 101).addBox(-1.5F, -0.625F, -0.875F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.35F, -5.45F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r47 = head.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(145, 17).addBox(4.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(136, 17).addBox(4.0F, -2.0F, 0.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.8F, -0.25F, -0.75F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r48 = head.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(145, 17).addBox(4.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(136, 17).addBox(4.0F, -2.0F, 0.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.567F, -4.0768F, -0.75F, 0.0F, 0.0F, 0.3927F));

        PartDefinition eyestalk = head.addOrReplaceChild("eyestalk", CubeListBuilder.create().texOffs(139, 26).addBox(-1.0F, -1.0F, -3.4833F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
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
                .texOffs(141, 29).addBox(-0.5F, -0.5F, -8.4833F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(136, 29).addBox(-0.75F, -0.25F, -8.3833F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(136, 28).addBox(-0.5F, -0.5F, -8.0833F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(143, 41).addBox(-1.5F, -1.0F, -8.3333F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(141, 42).addBox(-1.0F, 0.5F, -8.3333F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -4.4167F));

        PartDefinition gun = dalek.addOrReplaceChild("gun", CubeListBuilder.create().texOffs(143, 49).addBox(-0.5F, -0.5F, -6.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(154, 46).addBox(0.0F, -1.0F, -6.25F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(148, 45).addBox(-1.0F, 0.0F, -6.25F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(126, 170).addBox(-0.5F, -0.5F, -6.5F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(4.75F, -19.0F, -7.75F));

        PartDefinition cube_r49 = gun.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(154, 46).addBox(0.0F, -1.0F, -6.25F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r50 = gun.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(154, 46).addBox(0.0F, -1.0F, -6.25F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition plunger = dalek.addOrReplaceChild("plunger", CubeListBuilder.create().texOffs(151, 24).addBox(-0.5F, -0.5F, -11.5F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(93, 111).addBox(-2.0F, -0.5F, -9.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(93, 111).addBox(-0.5F, -2.0F, -9.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(97, 118).addBox(-1.5F, -1.5F, -12.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(104, 9).addBox(-1.0F, -1.0F, -11.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(104, 9).addBox(-0.5F, -1.6F, -11.95F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(104, 9).addBox(-0.5F, 0.6F, -11.95F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(104, 9).addBox(0.5F, -1.6F, -11.95F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(104, 9).addBox(0.5F, 0.6F, -11.95F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(99, 120).addBox(-1.5F, -1.5F, -6.25F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(93, 111).addBox(-0.5F, 1.0F, -9.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(93, 112).addBox(1.0F, -0.5F, -9.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(132, 36).addBox(-1.0F, -1.0F, -11.25F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(132, 36).addBox(-1.5F, -1.5F, -11.75F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(159, 37).addBox(0.0F, -2.0F, -13.25F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(159, 37).addBox(-0.1F, -2.0F, -13.25F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(159, 37).addBox(0.1F, -2.0F, -13.25F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(132, 36).addBox(-1.5F, -2.0F, -12.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(132, 36).addBox(-2.0F, -1.5F, -12.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(132, 36).addBox(-1.5F, 1.0F, -12.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(132, 36).addBox(1.0F, -1.5F, -12.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(169, 12).addBox(-1.0F, -1.0F, -11.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.75F, -19.0F, -7.75F));

        PartDefinition cube_r51 = plunger.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(17, 21).addBox(0.0F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.0F, -12.2071F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r52 = plunger.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(18, 20).addBox(-1.0F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6253F, -1.65F, -12.2071F, 0.7854F, 0.0F, -1.0472F));

        PartDefinition cube_r53 = plunger.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(18, 20).addBox(-1.0F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.65F, 1.666F, -12.2071F, 0.7854F, 0.0F, 2.0944F));

        PartDefinition cube_r54 = plunger.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(169, 28).addBox(-1.0F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4956F, 1.3852F, -12.3043F, 2.0944F, 0.0F, 2.0944F));

        PartDefinition cube_r55 = plunger.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(169, 28).addBox(-1.0F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 0.666F, -10.7071F, 0.7854F, 0.0F, 2.0944F));

        PartDefinition cube_r56 = plunger.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(18, 20).addBox(-1.0F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1253F, 0.8F, -12.2071F, 0.7854F, 0.0F, -2.0944F));

        PartDefinition cube_r57 = plunger.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(169, 28).addBox(-1.0F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, -0.2F, -10.7071F, 0.7854F, 0.0F, -2.0944F));

        PartDefinition cube_r58 = plunger.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(169, 28).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3626F, 0.7022F, -13.1704F, 2.0944F, 0.0F, -2.0944F));

        PartDefinition cube_r59 = plunger.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(18, 20).addBox(-1.0F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.15F, -0.784F, -12.2071F, 0.7854F, 0.0F, 1.0472F));

        PartDefinition cube_r60 = plunger.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(18, 20).addBox(-1.0F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.0F, -12.2071F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r61 = plunger.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(169, 28).addBox(-1.0F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.8883F, -12.3043F, 2.0944F, 0.0F, 0.0F));

        PartDefinition cube_r62 = plunger.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(169, 28).addBox(-1.0F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.45F, -10.7071F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r63 = plunger.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(108, 113).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9393F, 0.0F, -9.8536F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r64 = plunger.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(108, 113).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9393F, 0.0F, -2.1464F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r65 = plunger.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(108, 113).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9393F, -9.8536F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r66 = plunger.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(108, 113).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.9393F, -2.1464F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r67 = plunger.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(108, 113).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5858F, -10.2071F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r68 = plunger.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(108, 113).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.2929F, -2.5F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r69 = plunger.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(104, 9).addBox(0.0F, -0.5F, -1.5F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 0.501F, -10.45F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r70 = plunger.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(104, 9).addBox(0.0F, -0.5F, -1.5F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, 0.501F, -10.45F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r71 = plunger.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(104, 9).addBox(0.0F, -0.5F, -1.5F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, -0.499F, -10.45F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r72 = plunger.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(104, 9).addBox(0.0F, -0.5F, -1.5F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, -0.499F, -10.45F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r73 = plunger.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(108, 113).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9393F, 0.0F, -9.8536F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r74 = plunger.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(108, 113).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9393F, 0.0F, -2.1464F, 0.0F, 0.7854F, 0.0F));

        return LayerDefinition.create(meshdefinition, 200, 200);
    }

    @Override
    public void setupAnim(DalekEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(entity.encumberedAnimationState, DalekAnimations.MEDIUM_ENCUMBERED, ageInTicks, 2.0f);
        this.animateHeadLookTarget(netHeadYaw, headPitch);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        dalek.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    private void animateHeadLookTarget(float netYaw, float pitch) {
        this.eyestalk.xRot = pitch * ((float)Math.PI / 180F);
        this.head.yRot = netYaw * ((float)Math.PI / 180F);
    }
}
