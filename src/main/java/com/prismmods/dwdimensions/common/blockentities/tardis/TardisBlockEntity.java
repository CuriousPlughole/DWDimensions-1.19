package com.prismmods.dwdimensions.common.blockentities.tardis;

import com.prismmods.dwdimensions.common.block.custom.TardisBlock;
import com.prismmods.dwdimensions.common.blockentities.DWDBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

public class TardisBlockEntity extends BlockEntity implements BlockEntityTicker<TardisBlockEntity> {

    private boolean lightsOn = true;
    private int tardisID = 0;
    private DoorStatus doorState = DoorStatus.CLOSED;
    private float rotationInDeg = 0;
    private Chameleon chameleon = Chameleon.WHITTAKER;

    //Snow stuff, dont have textures for this so leaving for now
    //private boolean isSnowy = false;
    //private int snowCoolDown = 0;

    public TardisBlockEntity(BlockPos pos, BlockState state) {
        super(DWDBlockEntities.TARDIS.get(), pos, state);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        Direction dir = this.getBlockState().getValue(TardisBlock.FACING);
        switch (dir) {
            case SOUTH -> rotationInDeg = 180.0f;
            case EAST -> rotationInDeg = 90.0f;
            case WEST -> rotationInDeg = 270.0f;
            default -> rotationInDeg = 0.0f;
        }
    }

    /*
    NBT DATA HANDLING
     */

    public DoorStatus getDoorState() {
        return doorState;
    }

    public void setDoorState(DoorStatus state) {
        this.doorState = state;
    }

    public Chameleon getChameleon() {
        return chameleon;
    }

    public void setChameleon(Chameleon skin) {this.chameleon = skin;}

    public float getRotationInDeg() {
        return rotationInDeg;
    }

    public boolean getLightState() {
        return lightsOn;
    }
    public void setLightState(Boolean state) {
        this.lightsOn = state;
    }


    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        this.tardisID = tag.getInt("tardisID");
        this.lightsOn = tag.getBoolean("lightsOn");
        this.doorState = DoorStatus.getDoorStatusValue(tag.getString("doorStatus"));
        this.rotationInDeg = tag.getFloat("rotation");
        this.chameleon = Chameleon.getChameleonValue(tag.getString("chameleon"));
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putString("doorStatus", doorState.getNbtName());
        tag.putBoolean("lightsOn", lightsOn);
        tag.putInt("tardisID", tardisID);
        tag.putFloat("rotation", rotationInDeg);
        tag.putString("chameleon", chameleon.getNbtName());

        //tag.putBoolean("snow", isSnowy);
        //tag.putInt("snow_cooldown", snowCoolDown);
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

    @Override
    public void tick(Level level, BlockPos pos, BlockState state, TardisBlockEntity tardis) {
        /*
        if(level.getBlockState(pos.below()) == Blocks.AIR.defaultBlockState()) {
            //Some flying animation perhaps
        }*/

    }

}
