package com.prismmods.dwdimensions.common.item.custom.sonic;

import com.prismmods.dwdimensions.common.blockentities.tardis.DoorStatus;
import com.prismmods.dwdimensions.common.sound.DWDSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.util.NonNullLazy;

import java.util.Set;
import java.util.function.Consumer;

public class SonicScrewdriverItem extends Item {
    public SonicScrewdriverItem(Properties properties) {
        super(properties);
    }

    /**
    FUNCTIONALITY
     */

    //ENTITY MODE (Extended) [Higher pitch sound]
    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingTarget, InteractionHand hand) {
        Setting mode = getMode(itemStack);
        Level level = player.getLevel();
        BlockPos pos = player.blockPosition();

        if(mode == Setting.BLOCK) {
            //In block mode, so we don't want any interactions to work. Maybe add an "error sound" or message here to remind players
        }

        //In entity mode, so interactions can continue
        if(mode == Setting.ENTITY) {
            level.playSound(null, pos, getSoundForModel(getScrewdriverModel(itemStack), Action.USE), SoundSource.PLAYERS, 1.0f, (float) (1.0 + level.random.nextFloat() * (1.6 - 1.0)));

            //Detecting entity with no custom interaction
            if(level.isClientSide) {
                //This will do for now but maybe look into other ways of receiving data from the sonic. GUI?
                player.sendSystemMessage(Component.translatable("item.sonic.entity_detected" + livingTarget.toString()));
            }

            //Custom interactions
            if(livingTarget.isCurrentlyGlowing()) {
                livingTarget.setGlowingTag(false);
                if(level.isClientSide) {
                    player.sendSystemMessage(Component.translatable("item.sonic.entity_glowing_stopped"));
                }
            }

            //TODO: test creeper interaction
            if(livingTarget instanceof Creeper) {
                ((Creeper)livingTarget).setSwellDir(0);
            }
        }
        return super.interactLivingEntity(itemStack, player, livingTarget, hand);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        //TODO: May need packet for this. Test on server
        BlockPos pos = player.blockPosition();
        if(player.isCrouching()) {
            ItemStack itemstack = player.getItemInHand(hand);
            Setting oldSetting = getMode(itemstack);
            Setting newMode;
            if (oldSetting == Setting.BLOCK) {
                newMode = Setting.ENTITY;
                level.playSound(null, pos, getSoundForModel(getScrewdriverModel(itemstack), Action.EXTEND), SoundSource.PLAYERS, 1.0f, 1.0f);
            } else {
                newMode = Setting.BLOCK;
                level.playSound(null, pos, getSoundForModel(getScrewdriverModel(itemstack), Action.RETRACT), SoundSource.PLAYERS, 1.0f, 1.0f);
            }
            setMode(itemstack, newMode);
        }
        return super.use(level, player, hand);

    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack itemStack = context.getItemInHand();
        Setting mode = getMode(itemStack);

        player.getCooldowns().addCooldown(this, 10);

        if(mode == Setting.ENTITY) {
            //In entity mode, so we don't want any interactions to work. Maybe add an "error sound" or message here to remind players
        }

        //In block mode, so interactions can continue
        if(mode == Setting.BLOCK) {
            level.playSound(null, pos, getSoundForModel(getScrewdriverModel(itemStack), Action.USE), SoundSource.PLAYERS, 1.0f, (float) (0.7 + level.random.nextFloat() * (1.3 - 0.7)));

            //Detecting block with no custom interaction
            if(level.isClientSide) {
                //This will do for now but maybe look into other ways of receiving data from the sonic. GUI?
                player.sendSystemMessage(Component.translatable("item.dwdimensions.sonic.block_detected" + level.getBlockState(pos).getBlock().toString()));
            }

            //Custom interactions
            //etc
        }



            return super.useOn(context);
    }

    //Data for changing between modes. i.e. extending and retracting
    public static void setMode(ItemStack stack, Setting setting) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putString("setting", setting.getNbtName());
    }
    public static Setting getMode(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if(tag.contains("setting")) {
            return Setting.getSettingValue(tag.getString("setting"));
        } return Setting.BLOCK;
    }
    //May only need these two settings, but allows for expansion in future. eg red setting?
    public enum Setting {
        ENTITY("entity"), BLOCK("block");
        private final String nbtName;
        Setting(String nbtName) {
            this.nbtName = nbtName;
        }
        public String getNbtName() {
            return nbtName;
        }
        public static Setting getSettingValue(String nbtName){
            for (Setting value : Setting.values()) {
                if(value.getNbtName().equalsIgnoreCase(nbtName)){
                    return value;
                }
            }
            return Setting.BLOCK;
        }
    }

    /**
     SOUND
     */
    //FIXME: Currently has wrong sounds! Update when the actual sounds have been added.
    public static SoundEvent getSoundForModel(ScrewdriverModel model, Action action) {
        Holder<SoundEvent> SOUND = DWDSounds.DALEK_EMERGENCY.getHolder().get();
        if (action == Action.EXTEND) {
            switch (model) {
                case CAPALDI -> SOUND = DWDSounds.SONIC_10_EXTEND.getHolder().get();
                default -> SOUND = DWDSounds.SONIC_11_EXTEND.getHolder().get();
            }
        }
        if (action == Action.RETRACT) {
            switch (model) {
                case CAPALDI -> SOUND = DWDSounds.SONIC_11_RETRACT.getHolder().get();
                default -> SOUND = DWDSounds.SONIC_11_RETRACT.getHolder().get();
            }
        }
        if (action == Action.USE) {
            switch (model) {
                case CAPALDI -> SOUND = DWDSounds.SONIC_11_USE_SHORT.getHolder().get();
                default -> SOUND = DWDSounds.SONIC_11_USE_SHORT.getHolder().get();
            }
        }
        return SOUND.value();
    }
    public enum Action {
        EXTEND, RETRACT, USE
    }

    /**
    MODEL
     */
    //Use this method when creating screwdriver through tardis machine etc etc
    public static void setScrewdriverModel(ItemStack stack, ScrewdriverModel model) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putString("skin", model.getNbtName());
    }
    public static ScrewdriverModel getScrewdriverModel(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if(tag.contains("skin")) {
            return ScrewdriverModel.getScrewdriverModelValue(tag.getString("skin"));
        } return ScrewdriverModel.WHITTAKER;
    }
    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> items) {
        super.fillItemCategory(tab, items);
    }
    public enum ScrewdriverModel {
        WHITTAKER("whittaker"), CAPALDI("capaldi");

        private final String nbtName;
        ScrewdriverModel(String nbtName) {
            this.nbtName = nbtName;
        }
        public String getNbtName() {
            return nbtName;
        }
        public static ScrewdriverModel getScrewdriverModelValue(String nbtName){
            for (ScrewdriverModel value : ScrewdriverModel.values()) {
                if(value.getNbtName().equalsIgnoreCase(nbtName)){
                    return value;
                }
            }
            return ScrewdriverModel.WHITTAKER;
        }
    }
}


