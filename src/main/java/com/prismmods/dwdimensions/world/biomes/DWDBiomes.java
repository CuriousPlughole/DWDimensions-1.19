package com.prismmods.dwdimensions.world.biomes;

import com.prismmods.dwdimensions.DWDimensions;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DWDBiomes {

    public static ResourceKey<Biome> SKARO_DESERT_KEY;
    public static ResourceKey<Biome> SKARO_MINEFIELD_KEY;
    public static ResourceKey<Biome> SKARO_PLAINS_KEY;
    public static ResourceKey<Biome> SKARO_JUNGLE_KEY;

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, DWDimensions.MOD_ID);

    public static void registerBiomeKeys() {
        SKARO_DESERT_KEY = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DWDimensions.MOD_ID, "skaro_desert"));
        SKARO_MINEFIELD_KEY = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DWDimensions.MOD_ID, "skaro_minefield"));
        SKARO_PLAINS_KEY = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DWDimensions.MOD_ID, "skaro_plains"));
        SKARO_JUNGLE_KEY = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DWDimensions.MOD_ID, "skaro_jungle"));
    }

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }

}
