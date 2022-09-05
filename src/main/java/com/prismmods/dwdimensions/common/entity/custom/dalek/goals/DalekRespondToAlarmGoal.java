package com.prismmods.dwdimensions.common.entity.custom.dalek.goals;

import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.blockentities.DalekComputerBlockEntity;
import com.prismmods.dwdimensions.common.entity.custom.dalek.DalekEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.Random;

public class DalekRespondToAlarmGoal extends MoveToBlockGoal {

    private DalekComputerBlockEntity computer;
    private Random rand;

    public DalekRespondToAlarmGoal(DalekEntity entity, double speedModifier, int searchRange) {
        super(entity, speedModifier, searchRange);
        this.rand = new Random();
    }

    @Override
    protected BlockPos getMoveToTarget() {
        return this.blockPos.offset(rand.nextInt(-1, 1),0,rand.nextInt(-1, 1));
    }

    @Override
    protected boolean isValidTarget(LevelReader reader, BlockPos pos) {
        if (reader.getBlockState(pos).getBlock() == DWDBlocks.DALEK_WALL_COMPUTER.get()) {
            BlockEntity targetBlockEntity = reader.getBlockEntity(pos);
            if (targetBlockEntity instanceof DalekComputerBlockEntity) {
                this.computer = (DalekComputerBlockEntity) targetBlockEntity;
                if (computer.isAlarming()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void start() {
        super.start();
        System.out.println("RESPONDING TO ALARM");
    }
}
