package com.prismmods.dwdimensions.datagen;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.fluid.DWDFluids;
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
        simpleItem(DWDItems.HANDMINE);
        simpleItem(DWDItems.VARGA_BERRIES);
        simpleItem(DWDItems.STATTENHEIM_REMOTE);
        simpleItem(DWDFluids.RADIOACTIVE_WATER_BUCKET);
        simpleItem(DWDItems.ANTI_RADIATION_PILL);
        simpleItem(DWDItems.SKARO_DISK);
        simpleItem(DWDItems.DEVICES_ICON);
        simpleItem(DWDItems.RAW_DALEKANIUM);
        simpleItem(DWDItems.DALEKANIUM_INGOT);

        blockItemModel(DWDBlocks.DALEK_WALL_COMPUTER);
        blockItemModel(DWDBlocks.RADIOTHERAPY_CABINET);
        blockItemModel(DWDBlocks.DALEKANIUM_BLOCK);
        blockItemModel(DWDBlocks.DALEKANIUM_ORE);
        blockItemModel(DWDBlocks.DEEPSLATE_DALEKANIUM_ORE);
        blockItemModel(DWDBlocks.LOW_GRADE_STRUCTURAL_DALEKANIUM);
        blockItemModel(DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM);
        blockItemModel(DWDBlocks.MILITARY_GRADE_STRUCTURAL_DALEKANIUM);
        blockItemModel(DWDBlocks.LOW_GRADE_STRUCTURAL_DALEKANIUM_SLAB);
        blockItemModel(DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM_SLAB);
        blockItemModel(DWDBlocks.MILITARY_GRADE_STRUCTURAL_DALEKANIUM_SLAB);
        blockItemModel(DWDBlocks.LOW_GRADE_STRUCTURAL_DALEKANIUM_STAIRS);
        blockItemModel(DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM_STAIRS);
        blockItemModel(DWDBlocks.MILITARY_GRADE_STRUCTURAL_DALEKANIUM_STAIRS);
        specialInventoryModel(DWDBlocks.MILITARY_GRADE_STRUCTURAL_DALEKANIUM_WALL);
        specialInventoryModel(DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM_WALL);
        specialInventoryModel(DWDBlocks.LOW_GRADE_STRUCTURAL_DALEKANIUM_WALL);

        blockItemModel(DWDBlocks.DEEPSLATE_ZEITON_ORE);
        blockItemModel(DWDBlocks.ZEITON_ORE);
        blockItemModel(DWDBlocks.PETRIFIED_LEAVES);
        blockItemModel(DWDBlocks.PETRIFIED_JUNGLE_LEAVES);
        blockItemModel(DWDBlocks.SKARO_BUSH);
        blockItemModel(DWDBlocks.PETRIFIED_LOG);
        blockItemModel(DWDBlocks.PETRIFIED_JUNGLE_LOG);
        blockItemModel(DWDBlocks.PETRIFIED_JUNGLE_WOOD);
        blockItemModel(DWDBlocks.PETRIFIED_PLANKS);
        blockItemModel(DWDBlocks.PETRIFIED_WOOD);
        blockItemModel(DWDBlocks.SKARO_DIRT);
        blockItemModel(DWDBlocks.SKARO_SAND);
        blockItemModel(DWDBlocks.STRIPPED_PETRIFIED_WOOD);
        blockItemModel(DWDBlocks.STRIPPED_PETRIFIED_LOG);
        blockItemModel(DWDBlocks.HANDMINE_TRAP);
        blockItemModel(DWDBlocks.SKARO_MUD);
        blockItemModel(DWDBlocks.SKARO_STONE);
        blockItemModel(DWDBlocks.SKARO_COBBLESTONE);
        blockItemModel(DWDBlocks.SKARO_PACKED_MUD);
        blockItemModel(DWDBlocks.SKARO_QUICKSAND);
        blockItemModel(DWDBlocks.SKARO_GRAVEL);
        blockItemModel(DWDBlocks.SKARO_HIGHLANDS_STONE);
        blockItemModel(DWDBlocks.SKARO_HIGHLANDS_COBBLESTONE);
        blockItemModel(DWDBlocks.STRIPPED_PETRIFIED_JUNGLE_WOOD);
        blockItemModel(DWDBlocks.STRIPPED_PETRIFIED_JUNGLE_LOG);
        blockItemModel(DWDBlocks.PETRIFIED_JUNGLE_PLANKS);
        blockItemModel(DWDBlocks.PETRIFIED_PLANK_STAIRS);
        blockItemModel(DWDBlocks.PETRIFIED_PLANK_SLAB);
        blockItemModel(DWDBlocks.PETRIFIED_PLANK_FENCE_GATE);
        blockItemModel(DWDBlocks.PETRIFIED_PLANK_PRESSURE_PLATE);
        blockItemModel(DWDBlocks.PETRIFIED_JUNGLE_PLANK_STAIRS);
        blockItemModel(DWDBlocks.PETRIFIED_JUNGLE_PLANK_SLAB);
        blockItemModel(DWDBlocks.PETRIFIED_JUNGLE_PLANK_FENCE_GATE);
        blockItemModel(DWDBlocks.PETRIFIED_JUNGLE_PLANK_PRESSURE_PLATE);
        blockItemModel(DWDBlocks.SKARO_SANDSTONE);

        blockItemModel(DWDBlocks.SKARO_STONE_SLAB);
        blockItemModel(DWDBlocks.SKARO_STONE_STAIRS);
        blockItemModel(DWDBlocks.SKARO_COBBLESTONE_STAIRS);
        blockItemModel(DWDBlocks.SKARO_COBBLESTONE_SLAB);
        blockItemModel(DWDBlocks.SKARO_HIGHLANDS_STONE_SLAB);
        blockItemModel(DWDBlocks.SKARO_HIGHLANDS_STONE_STAIRS);
        blockItemModel(DWDBlocks.SKARO_HIGHLANDS_COBBLESTONE_SLAB);
        blockItemModel(DWDBlocks.SKARO_HIGHLANDS_COBBLESTONE_STAIRS);
        specialInventoryModel(DWDBlocks.SKARO_COBBLESTONE_WALL);
        specialInventoryModel(DWDBlocks.SKARO_STONE_WALL);
        specialInventoryModel(DWDBlocks.SKARO_HIGHLANDS_COBBLESTONE_WALL);
        specialInventoryModel(DWDBlocks.SKARO_HIGHLANDS_STONE_WALL);

        flatItemfromBlock(DWDBlocks.MERCURY_GEYSER);

        specialInventoryModel(DWDBlocks.PETRIFIED_PLANK_BUTTON);
        flatItemfromBlock(DWDBlocks.PETRIFIED_PLANK_DOOR);
        trapdoorInventoryModel(DWDBlocks.PETRIFIED_PLANK_TRAPDOOR);
        specialInventoryModel(DWDBlocks.PETRIFIED_PLANK_FENCE);
        simpleItem(DWDItems.PETRIFIED_PLANK_SIGN);
        specialInventoryModel(DWDBlocks.PETRIFIED_JUNGLE_PLANK_BUTTON);
        flatItemfromBlock(DWDBlocks.PETRIFIED_JUNGLE_PLANK_DOOR);
        trapdoorInventoryModel(DWDBlocks.PETRIFIED_JUNGLE_PLANK_TRAPDOOR);
        specialInventoryModel(DWDBlocks.PETRIFIED_JUNGLE_PLANK_FENCE);
        simpleItem(DWDItems.PETRIFIED_JUNGLE_PLANK_SIGN);

        plantItem(DWDBlocks.SKARO_PETRIFIED_FLOWER_1);
        plantItem(DWDBlocks.SKARO_PETRIFIED_FLOWER_2);
        plantItem(DWDBlocks.SKARO_PETRIFIED_FUNGUS);
        plantItem(DWDBlocks.PETRIFIED_SAPLING);
        plantItem(DWDBlocks.SKARO_DEAD_SHRUB);
        plantItem(DWDBlocks.SKARO_DEAD_SHRUB_SMALL);
        flatItemfromBlock(DWDBlocks.SKARO_TALL_GRASS);
        plantItem(DWDBlocks.SKARO_PETRIFIED_SHRUB);
        plantItem(DWDBlocks.SKARO_SHRUB);
        plantItem(DWDBlocks.SKARO_SHRUB_SMALL);
        plantItem(DWDBlocks.PETRIFIED_JUNGLE_SAPLING);
        plantItem(DWDBlocks.SKARO_VINES);


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

    private ItemModelBuilder flatItemfromBlock(RegistryObject<Block> block) {
        return withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DWDimensions.MOD_ID, "item/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder blockItemModel(RegistryObject<Block> block) {
        try {
            return withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                    new ResourceLocation(DWDimensions.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
        } catch(Exception e) {
            System.out.println("**** Attention required for item model: "+ ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
            return null;
        }

    }

    private ItemModelBuilder specialInventoryModel(RegistryObject<Block> block) {
        try {
            return withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                    new ResourceLocation(DWDimensions.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()+"_inventory"));
        } catch(Exception e) {
            System.out.println("**** Attention required for item model: "+ ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
            return null;
        }
    }

    private ItemModelBuilder trapdoorInventoryModel(RegistryObject<Block> block) {
        try {
            return withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                    new ResourceLocation(DWDimensions.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()+"_bottom"));
        } catch(Exception e) {
            System.out.println("**** Attention required for item model: "+ ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
            return null;
        }
    }



}


