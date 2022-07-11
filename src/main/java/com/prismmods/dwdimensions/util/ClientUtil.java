package com.prismmods.dwdimensions.util;

import com.prismmods.dwdimensions.client.renders.blockentities.TardisRenderer;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.blockentities.DWDBlockEntities;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class ClientUtil {

    public static void doClientStuff() {
        //BlockEntityRenderers.register(DWDBlockEntities.TARDIS.get(), TardisRenderer::new);

        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.PETRIFIED_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.PETRIFIED_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_SHRUB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_SHRUB_SMALL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_DEAD_SHRUB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_DEAD_SHRUB_SMALL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_TALL_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_PETRIFIED_SHRUB.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_PETRIFIED_FLOWER_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.POTTED_SKARO_PETRIFIED_FLOWER_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_PETRIFIED_FLOWER_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.POTTED_SKARO_PETRIFIED_FLOWER_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.SKARO_PETRIFIED_FUNGUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DWDBlocks.POTTED_SKARO_PETRIFIED_FUNGUS.get(), RenderType.cutout());

    }
}
