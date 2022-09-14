package com.prismmods.dwdimensions.world.feature.tree.grower;

import com.prismmods.dwdimensions.world.feature.tree.DWDConfiguredTrees;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class PetrifiedJungleTreeGrower extends AbstractMegaTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_, boolean p_222911_) {
        return DWDConfiguredTrees.PETRIFIED_JUNGLE_TREE;
    }

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource p_222904_) {
        return DWDConfiguredTrees.MEGA_PETRIFIED_JUNGLE_TREE;
    }
}
