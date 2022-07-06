package com.prismmods.dwdimensions.datagen;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, DWDimensions.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.ZEITON_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_ZEITON_ORE.get());

        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_PETRIFIED_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.PETRIFIED_LOG.get());
        simpleBlock(ModBlocks.PETRIFIED_PLANKS.get());

        
    }





}
