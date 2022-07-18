package com.prismmods.dwdimensions.common.item.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StattenheimRemoteItem extends Item {
    public StattenheimRemoteItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(player.isCrouching()) {
            ItemStack itemstack = player.getItemInHand(hand);
            Mode oldMode = getMode(itemstack);
            Mode newMode;
            String message;
            if (oldMode == Mode.CHAMELEON) {
                newMode = Mode.LIGHTS;
                message = "item.dwdimensions.stattenheim_remote.lights";
            } else {
                newMode = Mode.CHAMELEON;
                message = "item.dwdimensions.stattenheim_remote.chameleon";
            }
            setMode(itemstack, newMode);
            if (level.isClientSide) {
                player.sendSystemMessage(Component.translatable(message));
            }
        }
        return super.use(level, player, hand);
    }

    //DATA

    public static ItemStack setMode(ItemStack stack, Mode mode) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putString("mode", mode.nbtName); //possibly getNBTname()
        return stack;
    }

    public static Mode getMode(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        String mode = tag.getString("mode");
        return Mode.getModeValue(mode);
    }

    public enum Mode {
        CHAMELEON("chameleon"), LIGHTS("lights");

        private final String nbtName;
        Mode(String nbtName) {
            this.nbtName = nbtName;
        }
        public String getNbtName() {
            return nbtName;
        }

        public static Mode getModeValue(String nbtName){
            for (Mode value : Mode.values()) {
                if(value.getNbtName().equalsIgnoreCase(nbtName)){
                    return value;
                }
            }
            return Mode.CHAMELEON;
        }
    }





}


