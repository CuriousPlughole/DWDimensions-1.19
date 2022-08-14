package com.prismmods.dwdimensions.world.feature;

import com.prismmods.dwdimensions.common.block.DWDBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class DWDConfiguredFeatures {

    /**
     * VEGETATION
     */

    //SKARO
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> NORMAL_PATCH_SKARO_GRASS =
            FeatureUtils.register("skaro_patch_grass", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(DWDBlocks.SKARO_TALL_GRASS.get()), 32));

    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> SINGLE_PIECE_OF_SKARO_GRASS =
            FeatureUtils.register("single_piece_of_skaro_grass", Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(DWDBlocks.SKARO_TALL_GRASS.get().defaultBlockState())));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PETRIFIED_FLOWERS_ALL =
            FeatureUtils.register("petrified_flowers_all", Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(DWDBlocks.SKARO_PETRIFIED_FUNGUS.get().defaultBlockState(), 2).add(DWDBlocks.SKARO_PETRIFIED_FLOWER_1.get().defaultBlockState(), 1)
                    .add(DWDBlocks.SKARO_PETRIFIED_FLOWER_2.get().defaultBlockState(), 1)), 64));


    /**
     * GENERIC METHODS
     */
    private static RandomPatchConfiguration grassPatch(BlockStateProvider stateProvider, int i) {
        return FeatureUtils.simpleRandomPatchConfiguration(i, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(stateProvider)));
    }


}
