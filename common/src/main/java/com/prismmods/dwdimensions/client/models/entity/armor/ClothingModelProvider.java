package com.prismmods.dwdimensions.client.models.entity.armor;

import com.prismmods.dwdimensions.client.models.DWDModelLayers;
import com.prismmods.dwdimensions.common.item.DWDItems;
import com.prismmods.dwdimensions.util.ClientUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Objects;

/*
Robbed from: https://github.com/Suff99/Regeneration/blob/b1d8d4482c695604c06483b318a3b07b1f243a53/src/main/java/craig/software/mc/regen/util/ClientUtil.java
thx craig
 */

public class ClothingModelProvider {

    public static HashMap<Item, HumanoidModel<?>> CLOTHING_MODELS = new HashMap<>();
    public static HashMap<Item, HumanoidModel<?>> CLOTHING_MODELS_ALEX = new HashMap<>();

    public static void setupModels() {

        if (!CLOTHING_MODELS.isEmpty()) return;

        ModelPart bakedSpaceSuit = Minecraft.getInstance().getEntityModels().bakeLayer(DWDModelLayers.SPACE_SUIT);
        SpaceSuitModel spaceSuitHelmet = new SpaceSuitModel(bakedSpaceSuit, EquipmentSlot.HEAD);
        SpaceSuitModel spaceSuit = new SpaceSuitModel(bakedSpaceSuit, EquipmentSlot.CHEST);
        SpaceSuitModel spaceSuitBottom = new SpaceSuitModel(bakedSpaceSuit, EquipmentSlot.LEGS);

        ModelPart bakedGravityBoots = Minecraft.getInstance().getEntityModels().bakeLayer(DWDModelLayers.GRAVITY_BOOTS);
        GravityBootsModel gravityBoots = new GravityBootsModel(bakedGravityBoots, EquipmentSlot.FEET);

        CLOTHING_MODELS.put(DWDItems.SPACE_SUIT_HELMET.get(), spaceSuitHelmet);
        CLOTHING_MODELS.put(DWDItems.SPACE_SUIT.get(), spaceSuit);
        CLOTHING_MODELS.put(DWDItems.SPACE_SUIT_BOTTOM.get(), spaceSuitBottom);
        CLOTHING_MODELS.put(DWDItems.GRAVITY_BOOTS.get(), gravityBoots);
    }



    public static HumanoidModel<?> getArmorModel(ItemStack itemStack, LivingEntity livingEntity) {

        /*if (livingEntity instanceof AbstractClientPlayer player) {

            boolean isSlim = (Objects.equals(ClientUtil.getPlayerInfo(player).skinModel, "slim"));
            if (isSlim) {
                return getHumanoidModel(itemStack, false);
            }
        }*/

        return getHumanoidModel(itemStack, true);
    }


    private static HumanoidModel<?> getHumanoidModel(ItemStack itemStack, boolean trySteve) {
        if (trySteve) {
            if (CLOTHING_MODELS.containsKey(itemStack.getItem())) {
                return CLOTHING_MODELS.get(itemStack.getItem());
            }
        }

        if (!CLOTHING_MODELS_ALEX.containsKey(itemStack.getItem())) {
            throw new UnsupportedOperationException("No model registered for: " + itemStack.getItem());
        }
        return CLOTHING_MODELS_ALEX.get(itemStack.getItem());
    }




}
