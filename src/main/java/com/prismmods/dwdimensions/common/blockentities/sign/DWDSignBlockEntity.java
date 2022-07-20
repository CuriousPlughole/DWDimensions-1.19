package com.prismmods.dwdimensions.common.blockentities.sign;

import com.prismmods.dwdimensions.common.blockentities.DWDBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DWDSignBlockEntity extends SignBlockEntity {
    public DWDSignBlockEntity(BlockPos p_155700_, BlockState p_155701_) {
        super(p_155700_, p_155701_);
    }

    @Override
    public BlockEntityType<?> getType() {
        return DWDBlockEntities.SIGN_BLOCK_ENTITIES.get();
    }
}
