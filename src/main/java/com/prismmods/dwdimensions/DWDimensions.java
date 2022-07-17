package com.prismmods.dwdimensions;

import com.mojang.logging.LogUtils;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.blockentities.DWDBlockEntities;
import com.prismmods.dwdimensions.common.entity.DWDEntityTypes;
import com.prismmods.dwdimensions.common.item.DWDItems;
import com.prismmods.dwdimensions.common.sound.DWDSounds;
import com.prismmods.dwdimensions.world.feature.DWDPlacedFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(DWDimensions.MOD_ID)
public class DWDimensions {
    public static final String MOD_ID = "dwdimensions";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DWDimensions() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DWDSounds.register(modEventBus);
        DWDItems.register(modEventBus);
        DWDBlocks.register(modEventBus);
        DWDEntityTypes.register(modEventBus);
        DWDBlockEntities.register(modEventBus);


        DWDPlacedFeatures.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        //DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> modEventBus.addListener(this::doClientStuff));

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DWDBlocks.SKARO_PETRIFIED_FLOWER_1.getId(), DWDBlocks.POTTED_SKARO_PETRIFIED_FLOWER_1);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DWDBlocks.SKARO_PETRIFIED_FLOWER_2.getId(), DWDBlocks.POTTED_SKARO_PETRIFIED_FLOWER_2);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DWDBlocks.SKARO_PETRIFIED_FUNGUS.getId(), DWDBlocks.POTTED_SKARO_PETRIFIED_FUNGUS);
        });

    }
}
