package com.prismmods.dwdimensions.common.blockentities;

import com.prismmods.dwdimensions.common.block.custom.DalekComputerBlock;
import com.prismmods.dwdimensions.common.sound.DWDSounds;
import com.prismmods.dwdimensions.common.sound.instances.DalekAlarmSoundInstance;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.client.sounds.WeighedSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DalekComputerBlockEntity extends BlockEntity implements BlockEntityTicker<DalekComputerBlockEntity> {

    private boolean inUse = false;
    private boolean isAlarming = false;
    private int useCooldown = 0;
    private int deactivated = 0;
    private int alarmTicks = 0;
    private boolean changedFlag = false;

    public DalekComputerBlockEntity(BlockPos pos, BlockState state) {
        super(DWDBlockEntities.DALEK_WALL_COMPUTER.get(), pos, state);
    }

    @Override
    public void tick(Level level, BlockPos pos, BlockState state, DalekComputerBlockEntity computerBlockEntity) {

        //If the deactivated count is less than zero, the system is fully active.
        if(deactivated <= 0) {
            deactivated = 0;
            //If we're currently alarming, reduce the ticks until the alarm turns off
            if (isAlarming) {
                //Every 40 ticks, play the sound
                if(alarmTicks % 40 == 0) {
                    //TODO: Track the amount of sounds playing, or add some sort of check to prevent sound spam
                    level.playSound(null, pos, DWDSounds.DALEK_ALARM.get(), SoundSource.BLOCKS, 1.0f, 1.0f);
                }
                alarmTicks--;
            }
            if(alarmTicks <=0) {
                alarmTicks = 0;
                computerBlockEntity.setAlarming(false);
                computerBlockEntity.changedFlag = true;
            }
        }
        //The system is currently disabled, so reduce the ticks to the system coming back online
        else {
            deactivated--;
            if(!computerBlockEntity.isAlarmDisabled()) {
                computerBlockEntity.changedFlag = true;
            }
        }
        if(changedFlag) {
            BlockState newState = state.setValue(DalekComputerBlock.ALARMING, computerBlockEntity.isAlarming())
                    .setValue(DalekComputerBlock.DISABLED, computerBlockEntity.isAlarmDisabled())
                    .setValue(DalekComputerBlock.IN_USE, computerBlockEntity.isInUse());
            level.setBlockAndUpdate(pos, newState);
            changedFlag = false;
        }
    }

    /**
     * DATA HANDLING
     */

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        this.inUse = tag.getBoolean("inUse");
        this.isAlarming = tag.getBoolean("isAlarming");
        this.alarmTicks = tag.getInt("alarmTicks");
        this.useCooldown = tag.getInt("useCooldown");
        this.deactivated = tag.getInt("deactivated");
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putBoolean("inUse", inUse);
        tag.putBoolean("isAlarming", isAlarming);
        tag.putInt("alarmTicks", alarmTicks);
        tag.putInt("useCooldown", useCooldown);
        tag.putInt("deactivated", deactivated);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        CompoundTag compoundTag = new CompoundTag();
        saveAdditional(compoundTag);
        return compoundTag;
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
        handleUpdateTag(pkt.getTag());
    }
    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
    }

    public void sendUpdates() {
        level.updateNeighbourForOutputSignal(worldPosition, getBlockState().getBlock());
        level.sendBlockUpdated(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition), 3);
        setChanged();
    }

    //Getters and Setters
    public boolean isAlarmDisabled() {
        return deactivated > 0;
    }
    public void setAlarming(Boolean shouldAlarm) {
        this.isAlarming = shouldAlarm;
        this.alarmTicks = 400;
    }
    public boolean isAlarming() {
        return this.isAlarming;
    }

    public void disableAlarmableFor(int ticks) {
        this.deactivated = ticks;
    }

    public boolean isInUse() {
        return this.inUse;
    }


}
