package com.prismmods.dwdimensions.util;

import com.prismmods.dwdimensions.client.models.DWDModelLayers;
import com.prismmods.dwdimensions.client.models.entity.HandmineLeftModel;
import com.prismmods.dwdimensions.client.models.entity.HandmineRightModel;
import com.prismmods.dwdimensions.client.models.entity.dalek.BigDalekModel;
import com.prismmods.dwdimensions.client.models.entity.dalek.MediumDalekModel;
import com.prismmods.dwdimensions.client.models.entity.dalek.SmallDalekModel;
import com.prismmods.dwdimensions.common.blockentities.tardis.Chameleon;
import com.prismmods.dwdimensions.common.entity.custom.DalekEntity;
import com.prismmods.dwdimensions.common.entity.custom.HandmineEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public class DalekModelGetter {

        //For any type that doesn't use the medium model
        public enum DalekModelType {
            SMALL, MEDIUM, BIG
        }

        public static final Map<DalekModelType, EntityModel<DalekEntity>> DALEK_MODEL_MAP = new HashMap<>();
        public static EntityModel<DalekEntity> getDalekModel(DalekModelType type) {
            if(DALEK_MODEL_MAP.isEmpty()) {
                EntityModelSet theBaker = Minecraft.getInstance().getEntityModels();
                DALEK_MODEL_MAP.put(DalekModelType.SMALL, new SmallDalekModel(theBaker.bakeLayer(DWDModelLayers.SMALL_DALEK)));
                DALEK_MODEL_MAP.put(DalekModelType.MEDIUM, new MediumDalekModel(theBaker.bakeLayer(DWDModelLayers.MEDIUM_DALEK)));
                DALEK_MODEL_MAP.put(DalekModelType.BIG, new BigDalekModel(theBaker.bakeLayer(DWDModelLayers.BIG_DALEK)));
            }
            return DALEK_MODEL_MAP.get(type);
        }

        public static List<String> big_model_types = new ArrayList<>();
        public static List<String> small_model_types = new ArrayList<>();

        //TODO Someone needs to finish adding all the daleks for big and small models

        public static void setupLists() {
            big_model_types.add("strategist");
            big_model_types.add("drone");
            small_model_types.add("chase_1965");
            small_model_types.add("emperor_1967");
        }

        public static DalekModelType getModelFromString(String dalekType) {
            if(big_model_types.contains(dalekType)) {
                return DalekModelType.BIG;
            } else if(small_model_types.contains(dalekType)) {
                return DalekModelType.SMALL;
            } else {
                return DalekModelType.MEDIUM;
            }
        }

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
