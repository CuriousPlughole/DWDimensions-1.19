package com.prismmods.dwdimensions.client.renders.entity.armor;

import com.prismmods.dwdimensions.client.models.entity.armor.ClothingModelProvider;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

public class ClothingItemRenderer implements IClientItemExtensions {

    @Override
    public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {

        ClothingModelProvider.setupModels();
        HumanoidModel<LivingEntity> model = (HumanoidModel<LivingEntity>) ClothingModelProvider.getArmorModel(itemStack, livingEntity);
        return model;
    }
}
