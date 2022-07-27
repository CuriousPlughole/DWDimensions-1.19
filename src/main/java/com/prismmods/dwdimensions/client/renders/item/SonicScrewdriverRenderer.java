package com.prismmods.dwdimensions.client.renders.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.prismmods.dwdimensions.common.item.custom.SonicScrewdriverItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.world.item.ItemStack;

public class SonicScrewdriverRenderer extends BlockEntityWithoutLevelRenderer {
    public SonicScrewdriverRenderer(BlockEntityRenderDispatcher renderDispatcher, EntityModelSet modelSet) {
        super(renderDispatcher, modelSet);
    }



    @Override
    public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {

        if(stack == null) {
            return;
        }

       // Minecraft.getInstance().getItemRenderer().getModel()

        LocalPlayer player = Minecraft.getInstance().player;

        if(stack.getItem() instanceof SonicScrewdriverItem) {
            SonicScrewdriverItem.setScrewdriverModel(stack, SonicScrewdriverItem.ScrewdriverModel.CAPALDI);
        }

        //poseStack.pushPose();
        //Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND, combinedLight, combinedOverlay, poseStack, buffer, player.getId());



    }
}
