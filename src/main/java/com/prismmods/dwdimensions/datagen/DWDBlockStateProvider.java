package com.prismmods.dwdimensions.datagen;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.data.DataGenerator;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class DWDBlockStateProvider extends BlockStateProvider {
    public DWDBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, DWDimensions.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(DWDBlocks.ZEITON_ORE.get());
        simpleBlock(DWDBlocks.DEEPSLATE_ZEITON_ORE.get());

        //SKARO
        logBlock((RotatedPillarBlock) DWDBlocks.STRIPPED_PETRIFIED_LOG.get());
        logBlock((RotatedPillarBlock) DWDBlocks.PETRIFIED_LOG.get());
        logBlock((RotatedPillarBlock) DWDBlocks.PETRIFIED_JUNGLE_LOG.get());
        logBlock((RotatedPillarBlock) DWDBlocks.STRIPPED_PETRIFIED_JUNGLE_LOG.get());
        axisBlock((RotatedPillarBlock) DWDBlocks.PETRIFIED_WOOD.get(), blockTexture(DWDBlocks.PETRIFIED_LOG.get()), blockTexture(DWDBlocks.PETRIFIED_LOG.get()));
        axisBlock((RotatedPillarBlock) DWDBlocks.PETRIFIED_JUNGLE_WOOD.get(), blockTexture(DWDBlocks.PETRIFIED_JUNGLE_LOG.get()), blockTexture(DWDBlocks.PETRIFIED_JUNGLE_LOG.get()));
        axisBlock((RotatedPillarBlock) DWDBlocks.STRIPPED_PETRIFIED_WOOD.get(), new ResourceLocation(DWDimensions.MOD_ID, "block/stripped_petrified_log"), new ResourceLocation(DWDimensions.MOD_ID, "block/stripped_petrified_log"));
        axisBlock((RotatedPillarBlock) DWDBlocks.STRIPPED_PETRIFIED_JUNGLE_WOOD.get(), new ResourceLocation(DWDimensions.MOD_ID, "block/stripped_petrified_jungle_log"), new ResourceLocation(DWDimensions.MOD_ID, "block/stripped_petrified_jungle_log"));

        simpleBlock(DWDBlocks.PETRIFIED_PLANKS.get());
        simpleBlock(DWDBlocks.PETRIFIED_LEAVES.get());
        simpleBlock(DWDBlocks.PETRIFIED_JUNGLE_LEAVES.get());
        simpleBlock(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get());
        simpleBlock(DWDBlocks.SKARO_BUSH.get());
        simpleBlock(DWDBlocks.SKARO_DIRT.get());
        simpleBlock(DWDBlocks.SKARO_SAND.get());
        simpleBlock(DWDBlocks.SKARO_MUD.get());
        simpleBlock(DWDBlocks.SKARO_STONE.get());
        simpleBlock(DWDBlocks.SKARO_COBBLESTONE.get());
        simpleBlock(DWDBlocks.SKARO_PACKED_MUD.get());
        simpleBlock(DWDBlocks.SKARO_QUICKSAND.get());
        simpleBlock(DWDBlocks.SKARO_GRAVEL.get());
        simpleBlock(DWDBlocks.SKARO_PETRIFIED_SHRUB.get(), models().cross(ForgeRegistries.BLOCKS.getKey(DWDBlocks.SKARO_PETRIFIED_SHRUB.get()).getPath(), blockTexture(DWDBlocks.SKARO_PETRIFIED_SHRUB.get())));
        simpleBlock(DWDBlocks.SKARO_SHRUB.get(), models().cross(ForgeRegistries.BLOCKS.getKey(DWDBlocks.SKARO_SHRUB.get()).getPath(), blockTexture(DWDBlocks.SKARO_SHRUB.get())));
        simpleBlock(DWDBlocks.SKARO_SHRUB_SMALL.get(), models().cross(ForgeRegistries.BLOCKS.getKey(DWDBlocks.SKARO_SHRUB_SMALL.get()).getPath(), blockTexture(DWDBlocks.SKARO_SHRUB_SMALL.get())));
        simpleBlock(DWDBlocks.SKARO_DEAD_SHRUB.get(), models().cross(ForgeRegistries.BLOCKS.getKey(DWDBlocks.SKARO_DEAD_SHRUB.get()).getPath(), blockTexture(DWDBlocks.SKARO_DEAD_SHRUB.get())));
        simpleBlock(DWDBlocks.SKARO_DEAD_SHRUB_SMALL.get(), models().cross(ForgeRegistries.BLOCKS.getKey(DWDBlocks.SKARO_DEAD_SHRUB_SMALL.get()).getPath(), blockTexture(DWDBlocks.SKARO_DEAD_SHRUB_SMALL.get())));
        simpleBlock(DWDBlocks.SKARO_TALL_GRASS.get(), models().cross(ForgeRegistries.BLOCKS.getKey(DWDBlocks.SKARO_TALL_GRASS.get()).getPath(), blockTexture(DWDBlocks.SKARO_TALL_GRASS.get())));
        simpleBlock(DWDBlocks.SKARO_PETRIFIED_FLOWER_1.get(), models().cross(ForgeRegistries.BLOCKS.getKey(DWDBlocks.SKARO_PETRIFIED_FLOWER_1.get()).getPath(), blockTexture(DWDBlocks.SKARO_PETRIFIED_FLOWER_1.get())));
        simpleBlock(DWDBlocks.SKARO_PETRIFIED_FLOWER_2.get(), models().cross(ForgeRegistries.BLOCKS.getKey(DWDBlocks.SKARO_PETRIFIED_FLOWER_2.get()).getPath(), blockTexture(DWDBlocks.SKARO_PETRIFIED_FLOWER_2.get())));
        simpleBlock(DWDBlocks.SKARO_PETRIFIED_FUNGUS.get(), models().cross(ForgeRegistries.BLOCKS.getKey(DWDBlocks.SKARO_PETRIFIED_FUNGUS.get()).getPath(), blockTexture(DWDBlocks.SKARO_PETRIFIED_FUNGUS.get())));
        simpleBlock(DWDBlocks.PETRIFIED_SAPLING.get(), models().cross(ForgeRegistries.BLOCKS.getKey(DWDBlocks.PETRIFIED_SAPLING.get()).getPath(), blockTexture(DWDBlocks.PETRIFIED_SAPLING.get())));
        simpleBlock(DWDBlocks.PETRIFIED_JUNGLE_SAPLING.get(), models().cross(ForgeRegistries.BLOCKS.getKey(DWDBlocks.PETRIFIED_JUNGLE_SAPLING.get()).getPath(), blockTexture(DWDBlocks.PETRIFIED_JUNGLE_SAPLING.get())));
        simpleBlock(DWDBlocks.HANDMINE_TRAP.get());
        simpleBlock(DWDBlocks.SKARO_HIGHLANDS_STONE.get());
        simpleBlock(DWDBlocks.SKARO_HIGHLANDS_COBBLESTONE.get());

        fenceBlock((FenceBlock) DWDBlocks.PETRIFIED_PLANK_FENCE.get(), blockTexture(DWDBlocks.PETRIFIED_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) DWDBlocks.PETRIFIED_PLANK_FENCE_GATE.get(), blockTexture(DWDBlocks.PETRIFIED_PLANKS.get()));
        stairsBlock((StairBlock) DWDBlocks.PETRIFIED_PLANK_STAIRS.get(), blockTexture(DWDBlocks.PETRIFIED_PLANKS.get()));
        slabBlock((SlabBlock) DWDBlocks.PETRIFIED_PLANK_SLAB.get(), blockTexture(DWDBlocks.PETRIFIED_PLANKS.get()), blockTexture(DWDBlocks.PETRIFIED_PLANKS.get()));
        doorBlock((DoorBlock) DWDBlocks.PETRIFIED_PLANK_DOOR.get(), new ResourceLocation(DWDimensions.MOD_ID, "block/petrified_plank_door_bottom"),  new ResourceLocation(DWDimensions.MOD_ID, "block/petrified_plank_door_top"));
        trapdoorBlock((TrapDoorBlock) DWDBlocks.PETRIFIED_PLANK_TRAPDOOR.get(), blockTexture(DWDBlocks.PETRIFIED_PLANK_TRAPDOOR.get()),true);
        buttonBlock((ButtonBlock) DWDBlocks.PETRIFIED_PLANK_BUTTON.get(), blockTexture(DWDBlocks.PETRIFIED_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) DWDBlocks.PETRIFIED_PLANK_PRESSURE_PLATE.get(), blockTexture(DWDBlocks.PETRIFIED_PLANKS.get()));
        signBlock((StandingSignBlock)DWDBlocks.PETRIFIED_PLANK_SIGN.get(), (WallSignBlock) DWDBlocks.PETRIFIED_PLANK_WALL_SIGN.get(), blockTexture(DWDBlocks.PETRIFIED_PLANKS.get()));

        fenceBlock((FenceBlock) DWDBlocks.PETRIFIED_JUNGLE_PLANK_FENCE.get(), blockTexture(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) DWDBlocks.PETRIFIED_JUNGLE_PLANK_FENCE_GATE.get(), blockTexture(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get()));
        stairsBlock((StairBlock) DWDBlocks.PETRIFIED_JUNGLE_PLANK_STAIRS.get(), blockTexture(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get()));
        slabBlock((SlabBlock) DWDBlocks.PETRIFIED_JUNGLE_PLANK_SLAB.get(), blockTexture(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get()), blockTexture(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get()));
        doorBlock((DoorBlock) DWDBlocks.PETRIFIED_JUNGLE_PLANK_DOOR.get(), new ResourceLocation(DWDimensions.MOD_ID, "block/petrified_jungle_plank_door_bottom"),  new ResourceLocation(DWDimensions.MOD_ID, "block/petrified_jungle_plank_door_top"));
        trapdoorBlock((TrapDoorBlock) DWDBlocks.PETRIFIED_JUNGLE_PLANK_TRAPDOOR.get(), blockTexture(DWDBlocks.PETRIFIED_JUNGLE_PLANK_TRAPDOOR.get()),true);
        buttonBlock((ButtonBlock) DWDBlocks.PETRIFIED_JUNGLE_PLANK_BUTTON.get(), blockTexture(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) DWDBlocks.PETRIFIED_JUNGLE_PLANK_PRESSURE_PLATE.get(), blockTexture(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get()));
        signBlock((StandingSignBlock)DWDBlocks.PETRIFIED_JUNGLE_PLANK_SIGN.get(), (WallSignBlock) DWDBlocks.PETRIFIED_JUNGLE_PLANK_WALL_SIGN.get(), blockTexture(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get()));


    }
}
