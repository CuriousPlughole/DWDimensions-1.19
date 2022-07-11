package com.prismmods.dwdimensions.common.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;

public class TardisBlockEntity extends BlockEntity implements BlockEntityTicker<TardisBlockEntity> {

    private int snowCoolDown = 0;
    private boolean lightsOn = true;
    private boolean isSnowy = false;
    private int tardisID = 0;
    private float rotationInDeg = 0;
    //private EnumChameleon activeChameleon = EnumChameleon.TENNANT;
    //private EnumDoorState currentDoorState = EnumDoorState.CLOSED;

    public TardisBlockEntity(BlockPos pos, BlockState state) {
        super(DWDBlockEntities.TARDIS.get(), pos, state);

    }

    @Override
    public void tick(Level p_155253_, BlockPos p_155254_, BlockState p_155255_, TardisBlockEntity p_155256_) {

    }

    public float getRotation() {
        return 0.0f;
    }
}
