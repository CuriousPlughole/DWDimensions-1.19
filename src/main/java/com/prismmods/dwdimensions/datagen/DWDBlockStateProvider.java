package com.prismmods.dwdimensions.datagen;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DWDBlockStateProvider extends BlockStateProvider {
    public DWDBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, DWDimensions.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(DWDBlocks.ZEITON_ORE.get());
        simpleBlock(DWDBlocks.DEEPSLATE_ZEITON_ORE.get());

        logBlock((RotatedPillarBlock) DWDBlocks.STRIPPED_PETRIFIED_LOG.get());
        logBlock((RotatedPillarBlock) DWDBlocks.PETRIFIED_LOG.get());
        simpleBlock(DWDBlocks.PETRIFIED_PLANKS.get());

        simpleBlock(DWDBlocks.PETRIFIED_LEAVES.get());



        
    }





}
