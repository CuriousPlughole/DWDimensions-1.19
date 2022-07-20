package com.prismmods.dwdimensions.common.block.custom.generic;

import com.prismmods.dwdimensions.common.blockentities.sign.DWDSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class DWDWallSignBlock extends WallSignBlock {
    public DWDWallSignBlock(Properties p_58068_, WoodType p_58069_) {
        super(p_58068_, p_58069_);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new DWDSignBlockEntity(pPos, pState);
    }
}
