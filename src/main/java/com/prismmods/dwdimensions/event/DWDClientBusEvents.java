package com.prismmods.dwdimensions.event;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.client.models.DWDModels;
import com.prismmods.dwdimensions.client.models.TardisWhittakerModel;
import com.prismmods.dwdimensions.client.models.entity.HandmineRightModel;
import com.prismmods.dwdimensions.client.renders.blockentities.TardisRenderer;
import com.prismmods.dwdimensions.client.renders.entity.HandmineRender;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.blockentities.DWDBlockEntities;
import com.prismmods.dwdimensions.common.entity.DWDEntityTypes;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DWDimensions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DWDClientBusEvents {


    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(DWDBlockEntities.TARDIS.get(), TardisRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DWDModels.RIGHT_HANDMINE, HandmineRightModel::createBodyLayer);
        event.registerLayerDefinition(DWDModels.TARDIS_WHITTAKER, TardisWhittakerModel::getModelData);
    }


    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        //BlockEntityRenderers.register(DWDBlockEntities.TARDIS.get(), TardisRenderer::new);

        EntityRenderers.register(DWDEntityTypes.HANDMINE.get(), HandmineRender::new);

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
