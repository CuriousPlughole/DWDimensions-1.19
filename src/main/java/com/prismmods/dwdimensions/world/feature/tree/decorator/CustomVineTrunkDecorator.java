package com.prismmods.dwdimensions.world.feature.tree.decorator;

import com.mojang.serialization.Codec;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraftforge.registries.ForgeRegistries;

public class CustomVineTrunkDecorator extends TreeDecorator {
    public static final Codec<CustomVineTrunkDecorator> CODEC = Codec.unit(() -> {
        return CustomVineTrunkDecorator.INSTANCE;
    });
    public static final CustomVineTrunkDecorator INSTANCE = new CustomVineTrunkDecorator();


    @Override
    protected TreeDecoratorType<?> type() {
        //return DWDTreeDecorators.VINE_TRUNK_DECORATOR.get();
        return TreeDecoratorType.TRUNK_VINE;
    }

    @Override
    public void place(TreeDecorator.Context context) {
        RandomSource randomsource = context.random();
        context.logs().forEach((p_226075_) -> {
            if (randomsource.nextInt(3) > 0) {
                BlockPos blockpos = p_226075_.west();
                if (context.isAir(blockpos)) {
                    context.setBlock(blockpos, DWDBlocks.SKARO_VINES.get().defaultBlockState().setValue(VineBlock.EAST, Boolean.valueOf(true)));
                }
            }

            if (randomsource.nextInt(3) > 0) {
                BlockPos blockpos1 = p_226075_.east();
                if (context.isAir(blockpos1)) {
                    context.setBlock(blockpos1, DWDBlocks.SKARO_VINES.get().defaultBlockState().setValue(VineBlock.WEST, Boolean.valueOf(true)));
                }
            }

            if (randomsource.nextInt(3) > 0) {
                BlockPos blockpos2 = p_226075_.north();
                if (context.isAir(blockpos2)) {
                    context.setBlock(blockpos2, DWDBlocks.SKARO_VINES.get().defaultBlockState().setValue(VineBlock.SOUTH, Boolean.valueOf(true)));
                }
            }

            if (randomsource.nextInt(3) > 0) {
                BlockPos blockpos3 = p_226075_.south();
                if (context.isAir(blockpos3)) {
                    context.setBlock(blockpos3, DWDBlocks.SKARO_VINES.get().defaultBlockState().setValue(VineBlock.NORTH, Boolean.valueOf(true)));
                }
            }
        });
    }
}
