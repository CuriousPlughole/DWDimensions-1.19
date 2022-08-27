package com.prismmods.dwdimensions.common.entity.villager;

import com.google.common.collect.ImmutableSet;
import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class DWDVillagers {

    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, DWDimensions.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, DWDimensions.MOD_ID);

    //RADIOTHERAPIST - pills, suit, potions

    public static final RegistryObject<PoiType> RADIOTHERAPY_CABINET_POI = POI_TYPES.register("radiotherapy_cabinet_poi",
            () -> new PoiType(ImmutableSet.copyOf(DWDBlocks.RADIOTHERAPY_CABINET.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> RADIOTHERAPIST = VILLAGER_PROFESSIONS.register("radiotherapist",
            () -> new VillagerProfession("radiotherapist", x -> x.get() == RADIOTHERAPY_CABINET_POI.get(),
                    x -> x.get() == RADIOTHERAPY_CABINET_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_CLERIC));

    public static void registerPOIs() {
        System.out.println("POIS REGISTERED!");
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, RADIOTHERAPY_CABINET_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus bus) {
        POI_TYPES.register(bus);
        VILLAGER_PROFESSIONS.register(bus);
    }

}
