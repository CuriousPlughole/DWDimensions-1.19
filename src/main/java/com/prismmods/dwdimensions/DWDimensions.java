package com.prismmods.dwdimensions;

import com.mojang.logging.LogUtils;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.blockentities.DWDBlockEntities;
import com.prismmods.dwdimensions.common.blockentities.sign.DWDWoodTypes;
import com.prismmods.dwdimensions.common.entity.DWDEntityTypes;
import com.prismmods.dwdimensions.common.entity.custom.HandmineEntity;
import com.prismmods.dwdimensions.common.fluid.DWDFluids;
import com.prismmods.dwdimensions.common.item.DWDItems;
import com.prismmods.dwdimensions.common.sound.DWDSounds;
import com.prismmods.dwdimensions.network.Network;
import com.prismmods.dwdimensions.world.biomes.DWDBiomes;
import com.prismmods.dwdimensions.world.dimension.DWDDimensionReg;
import com.prismmods.dwdimensions.world.feature.DWDPlacedFeatures;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidInteractionRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

@Mod(DWDimensions.MOD_ID)
public class DWDimensions {
    public static final String MOD_ID = "dwdimensions";
    public static final Logger LOGGER = LogUtils.getLogger();

    public DWDimensions() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DWDSounds.register(modEventBus);
        DWDItems.register(modEventBus);
        DWDBlocks.register(modEventBus);
        DWDEntityTypes.register(modEventBus);
        DWDBlockEntities.register(modEventBus);
        DWDFluids.register(modEventBus);
        DWDPlacedFeatures.register(modEventBus);

        DWDBiomes.BIOMES.register(modEventBus);

        DWDDimensionReg.register();



        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::onAttributeAssign);
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final @NotNull FMLCommonSetupEvent event) {

        Network.registerMessages();

        //Lava onto radioactive water
        FluidInteractionRegistry.addInteraction(DWDFluids.RADIOACTIVE_WATER_TYPE.get(),
                new FluidInteractionRegistry.InteractionInformation(ForgeMod.LAVA_TYPE.get(), Blocks.STONE.defaultBlockState()));
        //Radioactive water onto lava
        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(),
                new FluidInteractionRegistry.InteractionInformation(DWDFluids.RADIOACTIVE_WATER_TYPE.get(), Blocks.OBSIDIAN.defaultBlockState()));

        //Radioactive water onto normal water
        FluidInteractionRegistry.addInteraction(ForgeMod.WATER_TYPE.get(),
                new FluidInteractionRegistry.InteractionInformation(DWDFluids.RADIOACTIVE_WATER_TYPE.get(), state -> state.isSource() ? Blocks.WATER.defaultBlockState() : Blocks.WATER.defaultBlockState()));


        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DWDBlocks.SKARO_PETRIFIED_FLOWER_1.getId(), DWDBlocks.POTTED_SKARO_PETRIFIED_FLOWER_1);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DWDBlocks.SKARO_PETRIFIED_FLOWER_2.getId(), DWDBlocks.POTTED_SKARO_PETRIFIED_FLOWER_2);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DWDBlocks.SKARO_PETRIFIED_FUNGUS.getId(), DWDBlocks.POTTED_SKARO_PETRIFIED_FUNGUS);
            Sheets.addWoodType(DWDWoodTypes.PETRIFIED);
            Sheets.addWoodType(DWDWoodTypes.PETRIFIED_JUNGLE);

            DWDBiomes.registerBiomeKeys();

        });
    }

    public void onAttributeAssign(EntityAttributeCreationEvent event) {
        event.put(DWDEntityTypes.HANDMINE.get(), HandmineEntity.createAttributes());
    }

}
