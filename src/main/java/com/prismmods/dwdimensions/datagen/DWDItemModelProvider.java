package com.prismmods.dwdimensions.datagen;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.item.DWDItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DWDItemModelProvider extends ItemModelProvider {

    public DWDItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, DWDimensions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(DWDItems.ZEITON_7);

        blockItemModel(DWDBlocks.DEEPSLATE_ZEITON_ORE);
        blockItemModel(DWDBlocks.ZEITON_ORE);
        blockItemModel(DWDBlocks.PETRIFIED_LEAVES);
        blockItemModel(DWDBlocks.PETRIFIED_LOG);
        blockItemModel(DWDBlocks.PETRIFIED_PLANKS);
        blockItemModel(DWDBlocks.PETRIFIED_WOOD);
        blockItemModel(DWDBlocks.SKARO_DIRT);
        blockItemModel(DWDBlocks.SKARO_GRASS);
        blockItemModel(DWDBlocks.SKARO_SAND);
        blockItemModel(DWDBlocks.STRIPPED_PETRIFIED_WOOD);
        blockItemModel(DWDBlocks.STRIPPED_PETRIFIED_LOG);
        plantItem(DWDBlocks.SKARO_PETRIFIED_FLOWER_1);
        plantItem(DWDBlocks.SKARO_PETRIFIED_FLOWER_2);
        plantItem(DWDBlocks.SKARO_PETRIFIED_FUNGUS);
        plantItem(DWDBlocks.PETRIFIED_SAPLING);
        plantItem(DWDBlocks.SKARO_DEAD_SHRUB);
        plantItem(DWDBlocks.SKARO_DEAD_SHRUB_SMALL);
        plantItem(DWDBlocks.SKARO_TALL_GRASS);
        plantItem(DWDBlocks.SKARO_PETRIFIED_SHRUB);
        plantItem(DWDBlocks.SKARO_SHRUB);
        plantItem(DWDBlocks.SKARO_SHRUB_SMALL);


        /* Method for automatically registering blockItems. Probably gonna cause more issues than its worth though.
        Just add manually.
        for (RegistryObject<Item> entry : DWDItems.ITEMS.getEntries()) {
            if (entry.get() instanceof BlockItem blockItem) {
                blockItemModel(blockItem);
            }
        }*/
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DWDimensions.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(DWDimensions.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder plantItem(RegistryObject<Block> block) {
        return withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DWDimensions.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder blockItemModel(RegistryObject<Block> block) {
        try {
            return withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                    new ResourceLocation(DWDimensions.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
        } catch(Exception e) {
            System.out.println("**** Attention required for item model: "+ block);
            return null;
        }

    }



}


