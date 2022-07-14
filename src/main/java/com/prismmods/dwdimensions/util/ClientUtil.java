package com.prismmods.dwdimensions.util;

import com.prismmods.dwdimensions.client.models.DWDModels;
import com.prismmods.dwdimensions.client.models.entity.HandmineRightModel;
import com.prismmods.dwdimensions.client.renders.blockentities.TardisRenderer;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.blockentities.DWDBlockEntities;
import com.prismmods.dwdimensions.common.entity.custom.HandmineEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

public class ClientUtil {

    public enum HandmineSide {LEFT, RIGHT}
    public static final Map<HandmineSide, EntityModel<HandmineEntity>> MODEL_MAP = new HashMap<>();
    public static EntityModel<HandmineEntity> getModelForHandmine(HandmineSide side) {
        if(MODEL_MAP.isEmpty()) {
            EntityModelSet theBakerMan = Minecraft.getInstance().getEntityModels();
            MODEL_MAP.put(HandmineSide.RIGHT, new HandmineRightModel(theBakerMan.bakeLayer(DWDModels.RIGHT_HANDMINE)));
            MODEL_MAP.put(HandmineSide.LEFT, new HandmineRightModel(theBakerMan.bakeLayer(DWDModels.RIGHT_HANDMINE)));
        }
        return MODEL_MAP.get(side);
    }


}
