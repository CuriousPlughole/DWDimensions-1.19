package com.prismmods.dwdimensions.api;

import com.prismmods.dwdimensions.common.item.DWDItems;
import com.prismmods.dwdimensions.util.DWDTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

public class OxygenHandler {

    public static boolean isProtectedFromNoOxygen(LivingEntity entity) {
        if(entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == DWDItems.SPACE_SUIT_HELMET.get()
                && entity.getItemBySlot(EquipmentSlot.CHEST).getItem() == DWDItems.SPACE_SUIT.get()
                && entity.getItemBySlot(EquipmentSlot.LEGS).getItem() == DWDItems.SPACE_SUIT_BOTTOM.get()) {
            return true;
        }

        if((entity.getType().is(DWDTags.Entities.SPACE_IMMUNE))) {
            return true;
        }


        return false;
    }

}
