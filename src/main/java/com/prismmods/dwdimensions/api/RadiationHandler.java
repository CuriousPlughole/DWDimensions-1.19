package com.prismmods.dwdimensions.api;

import com.prismmods.dwdimensions.common.capability.radiation.RadiationCapability;
import com.prismmods.dwdimensions.common.capability.radiation.RadiationCapabilityProvider;
import com.prismmods.dwdimensions.common.item.DWDItems;
import com.prismmods.dwdimensions.network.Network;
import com.prismmods.dwdimensions.network.messages.RadiationDataMessage;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class RadiationHandler {

    /**
     @param entity The living entity to apply radiation to
     @param radiationRate A float to stop radiation being applied too rapidly. This value will vary depending on how often the method is called. e.g. on for skaro background count it has the value 0.001, called in LivingTickEvent
     **/
    public static void applyRadiation(LivingEntity entity, float radiationRate) {
        entity.getCapability(RadiationCapabilityProvider.LIVING_ENTITY_RADIATION).ifPresent(radiation -> {
            if(radiation.getRadiation() < RadiationCapability.getMaxRadiation() && entity.getRandom().nextFloat() < radiationRate) {
                radiation.addRadiation(1);
                if(entity instanceof Player) {
                    Network.sendToClient(new RadiationDataMessage(radiation.getRadiation()), (ServerPlayer) entity);
                }
            }
        });
    }

    public static boolean isProtectedFromBackgroundRadiation(LivingEntity entity) {
        if(entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == DWDItems.SPACE_SUIT_HELMET.get()
                && entity.getItemBySlot(EquipmentSlot.CHEST).getItem() == DWDItems.SPACE_SUIT.get()
                && entity.getItemBySlot(EquipmentSlot.LEGS).getItem() == DWDItems.SPACE_SUIT_BOTTOM.get()) {
            return true;
        }
        return false;
    }

}
