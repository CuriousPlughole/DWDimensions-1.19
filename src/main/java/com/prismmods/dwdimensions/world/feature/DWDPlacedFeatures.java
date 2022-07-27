package com.prismmods.dwdimensions.world.feature;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.world.feature.tree.DWDConfiguredTrees;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class DWDPlacedFeatures {

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, DWDimensions.MOD_ID);

    //Placing the tree in the world
    public static final RegistryObject<PlacedFeature> PETRIFIED_PLACED = PLACED_FEATURES.register("petrified_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>) DWDConfiguredTrees.PETRIFIED_SPAWN,
            VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2)))); //base number of spawns, chance to spawn:, x more

    public static final RegistryObject<PlacedFeature> PETRIFIED_JUNGLE_PLACED = PLACED_FEATURES.register("petrified_jungle_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>) DWDConfiguredTrees.PETRIFIED_JUNGLE_SPAWN,
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2)))); //base number of spawns, chance to spawn:, x more

    public static final RegistryObject<PlacedFeature> SKARO_GRASS_PATCH_PLACED = PLACED_FEATURES.register("skaro_patch_grass_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>) DWDConfiguredFeatures.NORMAL_PATCH_SKARO_GRASS,
                    List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> SKARO_GRASS_BONEMEAL = PLACED_FEATURES.register("skaro_grass_bonemeal",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>) DWDConfiguredFeatures.SINGLE_PIECE_OF_SKARO_GRASS,
                    List.of(RarityFilter.onAverageOnceEvery(1))));

    public static void register(IEventBus bus) {
        PLACED_FEATURES.register(bus);
    }

}
