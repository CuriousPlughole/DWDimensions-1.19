package com.prismmods.dwdimensions.common.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class QuicksandBlock extends Block {
    public QuicksandBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos blockPos, Entity entity) {
        super.entityInside(state, level, blockPos, entity);
        entity.makeStuckInBlock(state, new Vec3(0.35D, 0.09D, 0.35D));

    }
}
