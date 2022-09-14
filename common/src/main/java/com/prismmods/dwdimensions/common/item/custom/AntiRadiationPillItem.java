package com.prismmods.dwdimensions.common.item.custom;

import com.prismmods.dwdimensions.common.capability.radiation.RadiationCapabilityProvider;
import com.prismmods.dwdimensions.network.Network;
import com.prismmods.dwdimensions.network.messages.RadiationDataMessage;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class AntiRadiationPillItem extends Item {
    public AntiRadiationPillItem(Properties p_41383_) {
        super(p_41383_);
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
        if (!level.isClientSide) {
            if(entity instanceof Player) {
                Player player = (Player)entity;
                player.getCapability(RadiationCapabilityProvider.LIVING_ENTITY_RADIATION).ifPresent(radiation -> {
                    if (radiation.getRadiation() > 0) {
                        radiation.subRadiation(1);
                        Network.sendToClient(new RadiationDataMessage(radiation.getRadiation()), (ServerPlayer) player);
                    }
                });
            }
        }

        if (entity instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, itemStack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (entity instanceof Player && !((Player)entity).getAbilities().instabuild) {
            itemStack.shrink(1);
        }

        return itemStack;
    }

    public int getUseDuration(ItemStack p_42933_) {
        return 16;
    }

    public UseAnim getUseAnimation(ItemStack p_42931_) {
        return UseAnim.EAT;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }

}
