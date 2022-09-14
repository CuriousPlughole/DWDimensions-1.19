package com.prismmods.dwdimensions.world.feature;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.world.feature.asteroids.AsteroidFeature;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class DWDFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, DWDimensions.MOD_ID);

    public static final RegistryObject<Feature> LARGE_IRON_ASTEROID = FEATURES.register("large_iron_asteroid",
            () -> new AsteroidFeature(NoneFeatureConfiguration.CODEC, 4, 7, List.of(Blocks.IRON_ORE, Blocks.STONE)));
    public static final RegistryObject<Feature> SMALL_IRON_ASTEROID = FEATURES.register("small_iron_asteroid",
            () -> new AsteroidFeature(NoneFeatureConfiguration.CODEC, 2, 4, List.of(Blocks.RAW_IRON_BLOCK, Blocks.SANDSTONE)));

    public static void register(IEventBus bus) {FEATURES.register(bus);}

}
