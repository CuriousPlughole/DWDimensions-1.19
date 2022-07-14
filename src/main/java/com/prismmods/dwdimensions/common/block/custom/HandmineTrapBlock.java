package com.prismmods.dwdimensions.common.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class HandmineTrapBlock extends Block {

    public HandmineTrapBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        RandomSource rand = RandomSource.create();

        int numToSpawn = 6 + rand.nextInt(3); // A random number of handmines between 6 and 9
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        if(entity instanceof Player) {
            for (int i = 0; i < numToSpawn; i++) {

            }
        }


        super.stepOn(level, pos, state, entity);
    }
}
