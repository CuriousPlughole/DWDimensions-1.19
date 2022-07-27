package com.prismmods.dwdimensions.world.feature.tree;

import com.google.common.collect.ImmutableList;
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
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class DWDConfiguredTrees {

    /**
     * PETRIFIED TREE
     */
    //Spawning from sapling
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> PETRIFIED_TREE =
            FeatureUtils.register("petrified", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(DWDBlocks.PETRIFIED_LOG.get()),new ForkingTrunkPlacer(5, 2, 2),
                    BlockStateProvider.simple(DWDBlocks.PETRIFIED_LEAVES.get()), new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                    new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(DWDBlocks.SKARO_DIRT.get())).ignoreVines().build());
    //Check if the sapling can survive in the place we want to spawn a tree
    public static final Holder<PlacedFeature> PETRIFIED_CHECKED =
            PlacementUtils.register("petrified_checked", PETRIFIED_TREE,
                    PlacementUtils.filteredByBlockSurvival(DWDBlocks.PETRIFIED_SAPLING.get()));
    //Spawn tree in world
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> PETRIFIED_SPAWN =
            FeatureUtils.register("petrified_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PETRIFIED_CHECKED, 0.5f)), PETRIFIED_CHECKED));

    /**
     * PETRIFIED JUNGLE TREE
     */

    //Normal size
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> PETRIFIED_JUNGLE_TREE =
            FeatureUtils.register("petrified_jungle", Feature.TREE, createPetrifiedJungleTree()
                    .decorators(ImmutableList.of(TrunkVineDecorator.INSTANCE,
                            new LeaveVineDecorator(0.25F))).ignoreVines().build());
    public static final Holder<PlacedFeature> PETRIFIED_JUNGLE_CHECKED =
            PlacementUtils.register("petrified_jungle_checked", PETRIFIED_JUNGLE_TREE,
                    PlacementUtils.filteredByBlockSurvival(DWDBlocks.PETRIFIED_JUNGLE_SAPLING.get()));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> PETRIFIED_JUNGLE_SPAWN =
            FeatureUtils.register("petrified_jungle_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PETRIFIED_JUNGLE_CHECKED, 0.5f)), PETRIFIED_JUNGLE_CHECKED));
    //Mega
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> MEGA_PETRIFIED_JUNGLE_TREE =
            FeatureUtils.register("mega_petrified_jungle", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(DWDBlocks.PETRIFIED_JUNGLE_LOG.get()), new MegaJungleTrunkPlacer(10, 2, 19),
                    BlockStateProvider.simple(DWDBlocks.PETRIFIED_JUNGLE_LEAVES.get()), new MegaJungleFoliagePlacer(ConstantInt.of(2),
                    ConstantInt.of(0), 2), new TwoLayersFeatureSize(1, 1, 2))
                    .decorators(ImmutableList.of(TrunkVineDecorator.INSTANCE, new LeaveVineDecorator(0.25F))).build());
    public static final Holder<PlacedFeature> MEGA_PETRIFIED_JUNGLE_CHECKED =
            PlacementUtils.register("mega_petrified_jungle_checked", MEGA_PETRIFIED_JUNGLE_TREE,
                    PlacementUtils.filteredByBlockSurvival(DWDBlocks.PETRIFIED_JUNGLE_SAPLING.get()));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MEGA_PETRIFIED_JUNGLE_SPAWN =
            FeatureUtils.register("mega_petrified_jungle_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(MEGA_PETRIFIED_JUNGLE_CHECKED, 0.5f)), MEGA_PETRIFIED_JUNGLE_CHECKED));


    /**
     * GENERIC METHODS
     */

    //Just guessing what these parameters are
    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block trunk, Block leaves, int minHeight, int maxHeight, int varation1, int variation2) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(trunk), new StraightTrunkPlacer(minHeight, maxHeight, varation1), BlockStateProvider.simple(leaves), new BlobFoliagePlacer(ConstantInt.of(variation2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createPetrifiedJungleTree() {
        return createStraightBlobTree(DWDBlocks.PETRIFIED_JUNGLE_LOG.get(), DWDBlocks.PETRIFIED_JUNGLE_LEAVES.get(), 4, 8, 0, 2);
    }

}
