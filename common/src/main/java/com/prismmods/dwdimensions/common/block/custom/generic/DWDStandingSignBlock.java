package com.prismmods.dwdimensions.common.block.custom.generic;

import com.prismmods.dwdimensions.common.blockentities.sign.DWDSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class DWDStandingSignBlock extends StandingSignBlock {
    public DWDStandingSignBlock(Properties p_56990_, WoodType p_56991_) {
        super(p_56990_, p_56991_);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new DWDSignBlockEntity(pPos, pState);
    }
}
