package com.prismmods.dwdimensions.util;

import com.prismmods.dwdimensions.client.models.DWDModelLayers;
import com.prismmods.dwdimensions.client.models.entity.HandmineLeftModel;
import com.prismmods.dwdimensions.client.models.entity.HandmineRightModel;
import com.prismmods.dwdimensions.common.entity.custom.HandmineEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;

import java.util.HashMap;
import java.util.Map;

public class ClientUtil {

    public enum HandmineSide {LEFT, RIGHT}
    public static final Map<HandmineSide, EntityModel<HandmineEntity>> MODEL_MAP = new HashMap<>();
    public static EntityModel<HandmineEntity> getModelForHandmine(HandmineSide side) {
        if(MODEL_MAP.isEmpty()) {
            EntityModelSet theBakerMan = Minecraft.getInstance().getEntityModels();
            MODEL_MAP.put(HandmineSide.RIGHT, new HandmineRightModel(theBakerMan.bakeLayer(DWDModelLayers.RIGHT_HANDMINE)));
            MODEL_MAP.put(HandmineSide.LEFT, new HandmineLeftModel(theBakerMan.bakeLayer(DWDModelLayers.LEFT_HANDMINE)));
        }
        return MODEL_MAP.get(side);
    }


}
