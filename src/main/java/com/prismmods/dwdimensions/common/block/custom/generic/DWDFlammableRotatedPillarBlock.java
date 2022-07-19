package com.prismmods.dwdimensions.common.block.custom.generic;

import com.prismmods.dwdimensions.common.block.DWDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class DWDFlammableRotatedPillarBlock extends RotatedPillarBlock {
    public DWDFlammableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    @Nullable
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {

        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(DWDBlocks.PETRIFIED_LOG.get()) || state.is(DWDBlocks.PETRIFIED_JUNGLE_LOG.get())) {
                return DWDBlocks.STRIPPED_PETRIFIED_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(DWDBlocks.PETRIFIED_WOOD.get()) || state.is(DWDBlocks.PETRIFIED_JUNGLE_WOOD.get())) {
                return DWDBlocks.STRIPPED_PETRIFIED_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }


}
