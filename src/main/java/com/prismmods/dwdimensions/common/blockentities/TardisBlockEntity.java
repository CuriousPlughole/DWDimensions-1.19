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
import org.jetbrains.annotations.NotNull;

public class TardisBlockEntity extends BlockEntity implements BlockEntityTicker<TardisBlockEntity> {

    private boolean lightsOn = true;
    private int tardisID = 0;
    private String doorState = "closed";
    private float rotationInDeg = 0;

    //Snow stuff, dont have textures for this so leaving for now
    //private boolean isSnowy = false;
    //private int snowCoolDown = 0;

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
    NBT DATA HANDLING
     */

    public String getDoorState() {return doorState;}
    public float getRotationInDeg() {return rotationInDeg;}
    public void setDoorState(String state) {this.doorState = state;}

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        this.tardisID = (tag.getInt("tardisID"));
        this.lightsOn = (tag.getBoolean("lightsOn"));
        this.doorState = (tag.getString("doorStatus"));
        this.rotationInDeg = (tag.getFloat("rotation"));
    }
    @Override
    public void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putString("doorStatus", doorState);
        tag.putBoolean("lightsOn", lightsOn);
        tag.putInt("tardisID", tardisID);
        tag.putFloat("rotation", rotationInDeg);

        //tag.putBoolean("snow", isSnowy);
        //tag.putInt("snow_cooldown", snowCoolDown);
    }
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }



    @Override
    public @NotNull CompoundTag getUpdateTag() {
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
