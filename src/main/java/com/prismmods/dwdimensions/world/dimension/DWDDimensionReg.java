package com.prismmods.dwdimensions.world.dimension;

import com.prismmods.dwdimensions.DWDimensions;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.registries.RegistryObject;

public class DWDDimensionReg {

    public static final ResourceKey<Level> SKARO_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(DWDimensions.MOD_ID, "skaro"));
    public static final ResourceKey<DimensionType> SKARO_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(DWDimensions.MOD_ID, "skaro"));

    public static final ResourceKey<Level> SPACE_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(DWDimensions.MOD_ID, "space"));
    public static final ResourceKey<DimensionType> SPACE_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(DWDimensions.MOD_ID, "space"));

    public static void register() {
        System.out.println("ModDimensions registered for " + DWDimensions.MOD_ID);
    }

}
