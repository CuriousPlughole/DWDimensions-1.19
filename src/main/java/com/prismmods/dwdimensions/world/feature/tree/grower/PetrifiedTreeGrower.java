package com.prismmods.dwdimensions.world.feature.tree.grower;

import com.prismmods.dwdimensions.world.feature.DWDConfiguredFeatures;
import com.prismmods.dwdimensions.world.feature.tree.DWDConfiguredTrees;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class PetrifiedTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_, boolean p_222911_) {
        return DWDConfiguredTrees.PETRIFIED_TREE;
    }
}
