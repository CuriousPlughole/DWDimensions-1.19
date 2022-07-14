package com.prismmods.dwdimensions.client.models;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.client.models.entity.HandmineRightModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class DWDModels {

    public static ModelLayerLocation TARDIS_WHITTAKER = new ModelLayerLocation(new ResourceLocation(DWDimensions.MOD_ID, "model"), "whittaker");

    public static final ModelLayerLocation RIGHT_HANDMINE = new ModelLayerLocation(new ResourceLocation(DWDimensions.MOD_ID, "model"), "righthandmine");


    /*
    public static void init(EntityRenderersEvent.RegisterLayerDefinitions registerLayerDefinitions) {
        registerLayerDefinitions.registerLayerDefinition(TARDIS_WHITTAKER, TardisWhittakerModel::getModelData);
        registerLayerDefinitions.registerLayerDefinition(RIGHT_HANDMINE, HandmineRightModel::createBodyLayer);
    }*/

}
