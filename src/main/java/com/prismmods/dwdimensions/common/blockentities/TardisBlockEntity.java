package com.prismmods.dwdimensions.common.blockentities;

import com.prismmods.dwdimensions.common.block.custom.TardisBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class TardisBlockEntity extends BlockEntity implements BlockEntityTicker<TardisBlockEntity> {

    private boolean lightsOn = true;
    private int tardisID = 0;
    private String doorState = "closed";
    private float rotationInDeg = 0;

    //For animation; testing/WIP
    private float doorProgress;
    private float doorProgressOld;
    //private DoorStatus animationStatus = DoorStatus.CLOSED;
    //Snow stuff, dont have textures for this so leaving for now
    //private boolean isSnowy = false;
    private int snowCoolDown = 0;

    public TardisBlockEntity(BlockPos pos, BlockState state) {
        super(DWDBlockEntities.TARDIS.get(), pos, state);
    }


    @Override
    public void onLoad() {
        Direction dir = this.getBlockState().getValue(TardisBlock.FACING);
        switch (dir) {
            case NORTH:
                rotationInDeg = 0.0f;
                break;
            case SOUTH:
                rotationInDeg = 180.0f;
                break;
            case EAST:
                rotationInDeg = 90.0f;
                break;
            case WEST:
                rotationInDeg = 270.0f;
                break;
            default:
                rotationInDeg = 0.0f;
                break;
        }
    }

    /*
        DATA SETTERS AND GETTERS
         */
    public int getTardisID() {return tardisID;}
    public void setTardisID(int id) {this.tardisID = id;}
    public boolean getLightsStatus() {return lightsOn;}
    public void setLightsStatus(Boolean on) {this.lightsOn = on;}
    public String getDoorState() {return doorState;}
    public void setDoorState(String state) {this.doorState = state;} //May need some other stuff besides this
    public float getRotationInDeg() {return rotationInDeg;}
    public void setRotationInDeg(float rot) {this.rotationInDeg = rot;}

    /*
    NBT DATA
     */
    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        setTardisID(tag.getInt("tardisID"));
        setLightsStatus(tag.getBoolean("lightsOn"));
        setDoorState(tag.getString("doorStatus"));
        setRotationInDeg(tag.getFloat("rotation"));
    }
    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putString("doorStatus", doorState);
        tag.putBoolean("lightsOn", lightsOn);
        tag.putInt("tardisID", tardisID);
        tag.putFloat("rotation", rotationInDeg);

        //tag.putBoolean("snow", isSnowy);
        //tag.putInt("snow_cooldown", snowCoolDown);
    }
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        tag.putString("doorStatus", doorState);
        tag.putBoolean("lightsOn", lightsOn);
        tag.putInt("tardisID", tardisID);
        tag.putFloat("rotation", rotationInDeg);
        return tag;
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


    }

}
