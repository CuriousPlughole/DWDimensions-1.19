package com.prismmods.dwdimensions.util;

import com.prismmods.dwdimensions.client.models.DWDModelLayers;
import com.prismmods.dwdimensions.client.models.entity.HandmineLeftModel;
import com.prismmods.dwdimensions.client.models.entity.HandmineRightModel;
import com.prismmods.dwdimensions.common.blockentities.tardis.Chameleon;
import com.prismmods.dwdimensions.common.entity.custom.HandmineEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;

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

    public static final Map<Chameleon, ModelPart> TARDIS_MODEL_MAP = new HashMap<>();
    public static ModelPart getTardisModel(Chameleon model) {
        if(TARDIS_MODEL_MAP.isEmpty()) {
            EntityModelSet theBaker = Minecraft.getInstance().getEntityModels();
            TARDIS_MODEL_MAP.put(Chameleon.WHITTAKER, theBaker.bakeLayer(DWDModelLayers.TARDIS_WHITTAKER));
            TARDIS_MODEL_MAP.put(Chameleon.CAPALDI, theBaker.bakeLayer(DWDModelLayers.TARDIS_SMITH_CAPALDI));
            TARDIS_MODEL_MAP.put(Chameleon.SMITH_SCORCHED, theBaker.bakeLayer(DWDModelLayers.TARDIS_SMITH_CAPALDI));
            TARDIS_MODEL_MAP.put(Chameleon.SMITH_7B, theBaker.bakeLayer(DWDModelLayers.TARDIS_SMITH_CAPALDI));
            TARDIS_MODEL_MAP.put(Chameleon.SMITH, theBaker.bakeLayer(DWDModelLayers.TARDIS_SMITH_CAPALDI));
            TARDIS_MODEL_MAP.put(Chameleon.TENNANT, theBaker.bakeLayer(DWDModelLayers.TARDIS_TENNANT_ECCLESTON));
            TARDIS_MODEL_MAP.put(Chameleon.ECCLESTON, theBaker.bakeLayer(DWDModelLayers.TARDIS_TENNANT_ECCLESTON));

        }
        return TARDIS_MODEL_MAP.get(model);
    }


    public class RadiationData {
        private static int livingEntityRadiation;
        public static void set(int radiation) {
            RadiationData.livingEntityRadiation = radiation;
        }
        public static int getLivingEntityRadiation() {
            return livingEntityRadiation;
        }
    }

}
