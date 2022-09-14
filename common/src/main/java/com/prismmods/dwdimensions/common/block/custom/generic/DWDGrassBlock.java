package com.prismmods.dwdimensions.common.block.custom.generic;

import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.world.feature.DWDPlacedFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.lighting.LayerLightEngine;

import java.util.List;
import java.util.function.Supplier;

public class DWDGrassBlock extends Block implements BonemealableBlock {

    private Supplier<Block> baseDirt;

    public DWDGrassBlock(Properties properties, Supplier<Block> dirt) {
        super(properties);
        this.baseDirt = dirt;
    }

    //Determine whether the dirt block can become grass block
    private static boolean canBeGrass(BlockState state, LevelReader levelReader, BlockPos pos) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = levelReader.getBlockState(blockpos);
        if (blockstate.getFluidState().getAmount() == 8) {
            return false;
        } else {
            int i = LayerLightEngine.getLightBlockInto(levelReader, state, pos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(levelReader, blockpos));
            return i < levelReader.getMaxLightLevel();
        }
    }

    private static boolean canPropagate(BlockState p_56828_, LevelReader p_56829_, BlockPos p_56830_) {
        BlockPos blockpos = p_56830_.above();
        return canBeGrass(p_56828_, p_56829_, p_56830_) && !p_56829_.getFluidState(blockpos).is(FluidTags.WATER);
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource randomSource) {
        if (!canBeGrass(state, level, pos)) {
            if (!level.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            level.setBlockAndUpdate(pos, baseDirt.get().defaultBlockState());
        } else {
            if (!level.isAreaLoaded(pos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            if (level.getMaxLocalRawBrightness(pos.above()) >= 9) {
                BlockState blockstate = this.defaultBlockState();

                for(int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.offset(randomSource.nextInt(3) - 1, randomSource.nextInt(5) - 3, randomSource.nextInt(3) - 1);
                    if (level.getBlockState(blockpos).is(baseDirt.get()) && canPropagate(blockstate, level, blockpos)) {
                        level.setBlockAndUpdate(blockpos, blockstate);//blockstate.setValue(SNOWY, Boolean.valueOf(level.getBlockState(blockpos.above()).is(Blocks.SNOW))));
                    }
                }
            }

        }
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter p_50897_, BlockPos p_50898_, BlockState p_50899_, boolean p_50900_) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level p_220878_, RandomSource p_220879_, BlockPos p_220880_, BlockState p_220881_) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos pos, BlockState state) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = DWDBlocks.SKARO_TALL_GRASS.get().defaultBlockState(); //The tallgrass to grow ontop

        label46:
        for(int i = 0; i < 128; ++i) {
            BlockPos blockpos1 = blockpos;

            for(int j = 0; j < i / 16; ++j) {
                blockpos1 = blockpos1.offset(randomSource.nextInt(3) - 1, (randomSource.nextInt(3) - 1) * randomSource.nextInt(3) / 2, randomSource.nextInt(3) - 1);
                if (!level.getBlockState(blockpos1.below()).is(this) || level.getBlockState(blockpos1).isCollisionShapeFullBlock(level, blockpos1)) {
                    continue label46;
                }
            }

            BlockState blockstate1 = level.getBlockState(blockpos1);
            //if (blockstate1.is(blockstate.getBlock()) && randomSource.nextInt(10) == 0) {
            //    ((BonemealableBlock)blockstate.getBlock()).performBonemeal(level, randomSource, blockpos1, blockstate1);
            //}

            if (blockstate1.isAir()) {
                Holder<PlacedFeature> holder;

                //Can add more stuff to determine flowers etc here
                //holder = DWDPlacedFeatures.SKARO_GRASS_PATCH_PLACED.getHolder().get();
                //holder = VegetationPlacements.GRASS_BONEMEAL;
                holder = DWDPlacedFeatures.SKARO_GRASS_BONEMEAL.getHolder().get();
                System.out.println("aaaa");

                holder.value().placeWithBiomeCheck(level, level.getChunkSource().getGenerator(), randomSource, blockpos1);
            }
        }

    }
}
