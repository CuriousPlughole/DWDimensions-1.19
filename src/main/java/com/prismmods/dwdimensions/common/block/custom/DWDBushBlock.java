package com.prismmods.dwdimensions.common.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DWDBushBlock extends BushBlock {
    protected static final VoxelShape LARGE_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
    protected static final VoxelShape SMALL_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 7.0D, 14.0D);

    String size;

    public DWDBushBlock(Properties p_51021_, String size) {
        super(p_51021_);
        this.size = size;
    }

    public VoxelShape getShape(BlockState p_52419_, BlockGetter p_52420_, BlockPos p_52421_, CollisionContext p_52422_) {
        if(size == "small") {
            return SMALL_SHAPE;
        } else {
            return LARGE_SHAPE;
        }
    }
}
