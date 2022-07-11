package com.prismmods.dwdimensions.common.block;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.DWDCreativeTabs;
import com.prismmods.dwdimensions.common.block.custom.DWDBasicFlammableBlock;
import com.prismmods.dwdimensions.common.block.custom.DWDFlammableRotatedPillarBlock;
import com.prismmods.dwdimensions.common.block.custom.DWDLeavesBlock;
import com.prismmods.dwdimensions.common.item.DWDItems;
import com.prismmods.dwdimensions.world.feature.tree.PetrifiedTreeGrower;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DWDBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DWDimensions.MOD_ID);

    public static final RegistryObject<Block> TARDIS = registerBlock("tardis", () -> new TardisBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)), DWDCreativeTabs.DWDMaterials);

    public static final RegistryObject<Block> ZEITON_ORE = registerBlock("zeiton_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(0, 2)), DWDCreativeTabs.DWDMaterials);
    public static final RegistryObject<Block> DEEPSLATE_ZEITON_ORE = registerBlock("deepslate_zeiton_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(ZEITON_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(0, 2)), DWDCreativeTabs.DWDMaterials);

    public static final RegistryObject<Block> PETRIFIED_LOG = registerBlock("petrified_log",
            () -> new DWDFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> STRIPPED_PETRIFIED_LOG = registerBlock("stripped_petrified_log",
            () -> new DWDFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> PETRIFIED_WOOD = registerBlock("petrified_wood",
            () -> new DWDFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> STRIPPED_PETRIFIED_WOOD = registerBlock("stripped_petrified_wood",
            () -> new DWDFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> PETRIFIED_PLANKS = registerBlock("petrified_planks",
            () -> new DWDBasicFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), DWDCreativeTabs.DWDSkaro);

    public static final RegistryObject<Block> PETRIFIED_LEAVES = registerBlock("petrified_leaves",
            () -> new DWDLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> PETRIFIED_SAPLING = registerBlock("petrified_sapling",
            () -> new SaplingBlock(new PetrifiedTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), DWDCreativeTabs.DWDSkaro);





    //Registry Methods

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return DWDItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
