package com.prismmods.dwdimensions.datagen;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.block.ModBlocks;
import com.prismmods.dwdimensions.common.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, DWDimensions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ZEITON_7);

        for (RegistryObject<Item> entry : ModItems.ITEMS.getEntries()) {
            if (entry.get() instanceof BlockItem blockItem) {
                blockItemModel(blockItem);
            }
        }

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

    private ItemModelBuilder blockItemModel(BlockItem blockItem) {
        try {
            return withExistingParent(ForgeRegistries.ITEMS.getKey(blockItem).getPath(),
                    new ResourceLocation(DWDimensions.MOD_ID, "block/" + ForgeRegistries.ITEMS.getValue(ForgeRegistries.ITEMS.getKey(blockItem))));
        } catch(Exception e) {
            System.out.println("**** Attention required for item model: "+ blockItem);
            return null;
        }

    }



}


