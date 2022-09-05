package com.prismmods.dwdimensions.common.entity.custom.dalek.goals;

import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.block.custom.DalekComputerBlock;
import com.prismmods.dwdimensions.common.blockentities.DalekComputerBlockEntity;
import com.prismmods.dwdimensions.common.entity.custom.dalek.DalekEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

public class DalekUseComputerGoal extends MoveToBlockGoal {

    private DalekComputerBlockEntity computer;

    public DalekUseComputerGoal(DalekEntity entity, double speedModifier, int searchRange) {
        super(entity, speedModifier, searchRange);
    }

    @Override
    protected BlockPos getMoveToTarget() {
        return this.blockPos;
    }

    @Override
    protected boolean isValidTarget(LevelReader reader, BlockPos pos) {
        if (reader.getBlockState(pos).getBlock() == DWDBlocks.DALEK_WALL_COMPUTER.get()) {
            BlockEntity targetBlockEntity = reader.getBlockEntity(pos);
            if (targetBlockEntity instanceof DalekComputerBlockEntity) {
                this.computer = (DalekComputerBlockEntity) targetBlockEntity;
                if (!computer.isInUse() && computer.getUseCooldown() <=0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void start() {
        System.out.println("STARTING COMPUTER USAGE");
        computer.setInUse(true);
        super.start();
        //play mechanical_long

    }

    @Override
    public boolean canContinueToUse() {
        return super.canContinueToUse();
    }

    @Override
    public void stop() {
        System.out.println("STOPPING COMPUTER USAGE");
        computer.setInUse(false);
        computer.putUseCooldown(400);
        super.stop();
    }
}
