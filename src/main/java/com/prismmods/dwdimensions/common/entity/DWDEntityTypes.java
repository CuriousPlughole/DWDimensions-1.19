package com.prismmods.dwdimensions.common.entity;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.entity.custom.dalek.DalekEntity;
import com.prismmods.dwdimensions.common.entity.custom.FallingTardisEntity;
import com.prismmods.dwdimensions.common.entity.custom.GiantSkaroEelEntity;
import com.prismmods.dwdimensions.common.entity.custom.HandmineEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DWDEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DWDimensions.MOD_ID);

    public static final RegistryObject<EntityType<HandmineEntity>> HANDMINE = ENTITY_TYPES.register("handmine",
            () -> EntityType.Builder.of(HandmineEntity::new, MobCategory.MONSTER).sized(0.3f, 0.3f).build(new ResourceLocation(DWDimensions.MOD_ID, "handmine").toString()));

    public static final RegistryObject<EntityType<FallingTardisEntity>> FALLING_TARDIS = ENTITY_TYPES.register("falling_tardis",
            () -> EntityType.Builder.of(FallingTardisEntity::new, MobCategory.MISC).sized(1.0f, 1.0f).build(new ResourceLocation(DWDimensions.MOD_ID, "falling_tardis").toString()));


    public static final RegistryObject<EntityType<GiantSkaroEelEntity>> GIANT_SKARO_EEL = ENTITY_TYPES.register("giant_skaro_eel",
            () -> EntityType.Builder.of(GiantSkaroEelEntity::new, MobCategory.CREATURE).sized(1.0f, 6.0f).build(new ResourceLocation(DWDimensions.MOD_ID, "giant_skaro_eel").toString()));

    public static final RegistryObject<EntityType<DalekEntity>> DALEK = ENTITY_TYPES.register("dalek",
            () -> EntityType.Builder.of(DalekEntity::new, MobCategory.MONSTER).sized(0.7f, 1.8f).build(new ResourceLocation(DWDimensions.MOD_ID, "dalek").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
