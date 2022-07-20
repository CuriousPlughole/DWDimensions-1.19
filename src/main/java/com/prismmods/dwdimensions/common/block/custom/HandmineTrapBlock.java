package com.prismmods.dwdimensions.common.block.custom;

import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.entity.DWDEntityTypes;
import com.prismmods.dwdimensions.common.entity.custom.HandmineEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class HandmineTrapBlock extends Block {

    public HandmineTrapBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof Player) {

            RandomSource rand = RandomSource.create();
            int numToSpawn = 14 + rand.nextInt(8); // A random number of handmines between 8 and 12. May be less because of spawn checking
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();

            HashMap<Integer, Integer> occupiedBlocks = new HashMap<>();

            for (int i = 0; i < numToSpawn; i++) {
                HandmineEntity handmine = new HandmineEntity(DWDEntityTypes.HANDMINE.get(), level);

                boolean positiveX = rand.nextBoolean();
                boolean positiveZ = rand.nextBoolean();
                boolean offsetX = rand.nextBoolean();
                int spawnX;
                int spawnZ;

                if (offsetX) {
                    spawnX = (positiveX) ? x + 1 + rand.nextInt(3) : x - 1 - rand.nextInt(2);
                    spawnZ = (positiveZ) ? z  + rand.nextInt(3) : z  - rand.nextInt(2);
                } else {
                    spawnX = (positiveX) ? x + rand.nextInt(3) : x - rand.nextInt(2);
                    spawnZ = (positiveZ) ? z + 1 + rand.nextInt(3) : z - 1 - rand.nextInt(2);
                }

                boolean shouldSpawn;

                //check if available
                if(occupiedBlocks.containsKey(spawnX)) {
                    if(occupiedBlocks.get(spawnX).intValue() != spawnZ) {
                        //Has same xcoord but different z, so valid. Can spawn.
                        shouldSpawn = true;
                        occupiedBlocks.put(spawnX, spawnZ);
                    } else { //Same X and same Z. Already occupied so don't spawn.
                        shouldSpawn = false;
                    }
                } else {
                    //Different X so must be valid. can spawn.
                    shouldSpawn = true;
                    occupiedBlocks.put(spawnX, spawnZ);
                }

                if(shouldSpawn) {

                    double modifiedSpawnX = (positiveX) ? spawnX + rand.nextDouble() : spawnX - rand.nextDouble();
                    double modifiedSpawnZ = (positiveZ) ? spawnZ + rand.nextDouble() : spawnZ - rand.nextDouble();

                    if (level.getBlockState(new BlockPos(spawnX, y + 1, spawnZ)) == Blocks.AIR.defaultBlockState()) {
                        handmine.setPos(modifiedSpawnX, y+1, modifiedSpawnZ);
                        if(!level.isClientSide) {
                            level.addFreshEntity(handmine);
                        }
                        level.addParticle(ParticleTypes.SQUID_INK, spawnX, y+1, spawnZ, 0,0,0);
                    }
                }

            }
            //Need custom emerging sound
            level.playSound((Player)entity, pos, SoundEvents.SPIDER_STEP, SoundSource.BLOCKS, 0.7f, 1.0f);

            //trap activated so just change to dirt
            level.setBlock(pos, DWDBlocks.SKARO_MUD.get().defaultBlockState(), 3);
        }
        super.stepOn(level, pos, state, entity);
    }
}
