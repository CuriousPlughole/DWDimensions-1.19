package com.prismmods.dwdimensions.world.feature;

import com.google.common.base.Suppliers;
import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class DWDConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, DWDimensions.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> CONFIGURED_LARGE_IRON_ASTEROID = CONFIGURED_FEATURES.register("large_iron_asteroid",
            ()-> new ConfiguredFeature<>(DWDFeatures.LARGE_IRON_ASTEROID.get(), new ProbabilityFeatureConfiguration(0.5F)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> CONFIGURED_SMALL_IRON_ASTEROID = CONFIGURED_FEATURES.register("small_iron_asteroid",
            ()-> new ConfiguredFeature<>(DWDFeatures.SMALL_IRON_ASTEROID.get(), new ProbabilityFeatureConfiguration(0.3F)));

    /**
     * ORES
     */
    public static final Supplier<List<OreConfiguration.TargetBlockState>> SKARO_DALEKANIUM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, DWDBlocks.DALEKANIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, DWDBlocks.DEEPSLATE_DALEKANIUM_ORE.get().defaultBlockState())));
    //If no tag available, use "new BlockMatchTest(DWDBlocks.block)" etc

    //int is vein size
    public static final RegistryObject<ConfiguredFeature<?,?>> DALEKANIUM_ORE = CONFIGURED_FEATURES.register("dalekanium_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SKARO_DALEKANIUM_ORES.get(), 6)));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> SKARO_URANIUM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, DWDBlocks.SKARO_URANIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, DWDBlocks.SKARO_DEEPSLATE_URANIUM_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?,?>> SKARO_URANIUM_ORE = CONFIGURED_FEATURES.register("skaro_uranium_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SKARO_URANIUM_ORES.get(), 4)));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> SKARO_IRON_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, DWDBlocks.SKARO_IRON_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?,?>> SKARO_IRON_ORE = CONFIGURED_FEATURES.register("skaro_iron_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SKARO_IRON_ORES.get(), 8)));


    /**
     * VEGETATION
     */

    public static final RegistryObject<ConfiguredFeature<?, ?>> NORMAL_PATCH_SKARO_GRASS = CONFIGURED_FEATURES.register("skaro_patch_grass",
            ()-> new ConfiguredFeature<>(Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(DWDBlocks.SKARO_TALL_GRASS.get()), 32)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SINGLE_PIECE_OF_SKARO_GRASS = CONFIGURED_FEATURES.register("single_piece_of_skaro_grass",
            ()-> new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(DWDBlocks.SKARO_TALL_GRASS.get().defaultBlockState()))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> PETRIFIED_FLOWERS_ALL = CONFIGURED_FEATURES.register("petrified_flowers_all",
            ()-> new ConfiguredFeature<>(Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(DWDBlocks.SKARO_PETRIFIED_FUNGUS.get().defaultBlockState(), 2).add(DWDBlocks.SKARO_PETRIFIED_FLOWER_1.get().defaultBlockState(), 1)
                    .add(DWDBlocks.SKARO_PETRIFIED_FLOWER_2.get().defaultBlockState(), 1)), 64)));



    /**
     * GENERIC METHODS
     */
    private static RandomPatchConfiguration grassPatch(BlockStateProvider stateProvider, int i) {
        return FeatureUtils.simpleRandomPatchConfiguration(i, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(stateProvider)));
    }

    public static void register(IEventBus bus) {
        CONFIGURED_FEATURES.register(bus);
    }


}
