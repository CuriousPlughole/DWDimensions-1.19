package com.prismmods.dwdimensions.world.feature;

import com.prismmods.dwdimensions.common.block.DWDBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class DWDConfiguredFeatures {

    //TREE
    //Spawning from sapling
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> PETRIFIED_TREE =
            FeatureUtils.register("petrified", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(DWDBlocks.PETRIFIED_LOG.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(DWDBlocks.PETRIFIED_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(DWDBlocks.SKARO_DIRT.get())).build());
    //Check if the sapling can survive in the place we want to spawn a tree
    public static final Holder<PlacedFeature> PETRIFIED_CHECKED =
            PlacementUtils.register("petrified_checked", PETRIFIED_TREE,
                    PlacementUtils.filteredByBlockSurvival(DWDBlocks.PETRIFIED_SAPLING.get()));
    //Spawn tree in world
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> PETRIFIED_SPAWN =
            FeatureUtils.register("petrified_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PETRIFIED_CHECKED, 0.5f)), PETRIFIED_CHECKED));

    //SKARO VEGETATION
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> NORMAL_PATCH_SKARO_GRASS =
            FeatureUtils.register("skaro_patch_grass", Feature.RANDOM_PATCH, new RandomPatchConfiguration(32, 6, 6,
                    PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(DWDBlocks.SKARO_TALL_GRASS.get())))));

    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> SINGLE_PIECE_OF_SKARO_GRASS =
            FeatureUtils.register("single_piece_of_skaro_grass", Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(DWDBlocks.SKARO_TALL_GRASS.get().defaultBlockState())));



}
