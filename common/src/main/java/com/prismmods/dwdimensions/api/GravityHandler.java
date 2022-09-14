package com.prismmods.dwdimensions.api;

import com.prismmods.dwdimensions.common.item.DWDItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

public class GravityHandler {

    //Gravity boots should eventually have multiple modes so this may be adjusted in future
    public static boolean shouldUseNormalGravity(LivingEntity entity) {
        if(entity.getItemBySlot(EquipmentSlot.FEET).getItem() == DWDItems.GRAVITY_BOOTS.get()){
            return true;
        }
        return false;
    }

}
