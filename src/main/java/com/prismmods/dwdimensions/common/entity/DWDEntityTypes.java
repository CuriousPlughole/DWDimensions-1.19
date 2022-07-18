package com.prismmods.dwdimensions.common.entity;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.entity.custom.HandmineEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DWDEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, DWDimensions.MOD_ID);

    public static final RegistryObject<EntityType<HandmineEntity>> HANDMINE = ENTITY_TYPES.register("handmine",
            () -> EntityType.Builder.of(HandmineEntity::new, MobCategory.MONSTER).sized(0.3f, 0.3f).build(new ResourceLocation(DWDimensions.MOD_ID, "handmine").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}