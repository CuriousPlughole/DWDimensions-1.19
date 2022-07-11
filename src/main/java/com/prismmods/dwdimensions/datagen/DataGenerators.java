package com.prismmods.dwdimensions.datagen;

import com.prismmods.dwdimensions.DWDimensions;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = DWDimensions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        //suspicious boolean
        generator.addProvider(true, new DWDRecipeProvider(generator));
        generator.addProvider(true, new DWDLootTableProvider(generator));
        generator.addProvider(true, new DWDBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(true, new DWDItemModelProvider(generator, existingFileHelper));
    }
}
