package com.prismmods.dwdimensions.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class DWDPlacedFeatures {

    //Placing the tree in the world
    public static final Holder<PlacedFeature> PETRIFIED_PLACED = PlacementUtils.register("petrified_placed", DWDConfiguredFeatures.PETRIFIED_SPAWN,
            VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2))); //base number of spawns, chance to spawn:, x more
}
