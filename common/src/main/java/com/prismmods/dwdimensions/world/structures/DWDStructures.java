package com.prismmods.dwdimensions.world.structures;

import com.prismmods.dwdimensions.DWDimensions;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DWDStructures {

    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(Registry.STRUCTURE_TYPE_REGISTRY, DWDimensions.MOD_ID);

    public static final RegistryObject<StructureType<SkyStructures>> SKY_STRUCTURES = STRUCTURE_TYPES.register("sky_structures", () -> () -> SkyStructures.CODEC);

    public static void register(IEventBus eventBus) {
        STRUCTURE_TYPES.register(eventBus);
    }

}
