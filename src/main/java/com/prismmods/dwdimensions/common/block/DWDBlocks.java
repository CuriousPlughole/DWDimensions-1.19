package com.prismmods.dwdimensions.common.block;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.DWDCreativeTabs;
import com.prismmods.dwdimensions.common.block.custom.HandmineTrapBlock;
import com.prismmods.dwdimensions.common.block.custom.TardisBlock;
import com.prismmods.dwdimensions.common.block.custom.VargaPlant;
import com.prismmods.dwdimensions.common.block.custom.generic.*;
import com.prismmods.dwdimensions.common.block.custom.generic.flammable.*;
import com.prismmods.dwdimensions.common.blockentities.sign.DWDWoodTypes;
import com.prismmods.dwdimensions.common.item.DWDItems;
import com.prismmods.dwdimensions.world.feature.tree.PetrifiedTreeGrower;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
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

    /*
    SKARO
     */

    //TODO: Add some custom effects for petrified plants. Some blindness or something? Not all negative; maybe "adrenaline" -> gives haste/strength etc
    //TODO: Need custom tree grower for petrified jungle tree
    //TODO: Make custom class for quicksand
    //TODO: Special block types (Fences, stairs, slabs, etc)

    //Wood
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
    public static final RegistryObject<Block> PETRIFIED_JUNGLE_PLANKS = registerBlock("petrified_jungle_planks",
            () -> new DWDBasicFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> PETRIFIED_JUNGLE_LOG = registerBlock("petrified_jungle_log",
            () -> new DWDFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> STRIPPED_PETRIFIED_JUNGLE_LOG = registerBlock("stripped_petrified_jungle_log",
            () -> new DWDFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> PETRIFIED_JUNGLE_WOOD = registerBlock("petrified_jungle_wood",
            () -> new DWDFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> STRIPPED_PETRIFIED_JUNGLE_WOOD = registerBlock("stripped_petrified_jungle_wood",
            () -> new DWDFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), DWDCreativeTabs.DWDSkaro);
    //Wood shaped blocks [Stair, slab, fence, fence gate, trapdoor, door, button, pressure plate, sign] {boat - item/entity}
    public static final RegistryObject<Block> PETRIFIED_PLANK_STAIRS = registerBlock("petrified_plank_stairs",
            () -> new DWDFlammableStairBlock(()-> PETRIFIED_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> PETRIFIED_PLANK_SLAB = registerBlock("petrified_plank_slab",
            () -> new DWDFlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> PETRIFIED_PLANK_FENCE = registerBlock("petrified_plank_fence",
            () -> new DWDFlammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> PETRIFIED_PLANK_FENCE_GATE = registerBlock("petrified_plank_fence_gate",
            () -> new DWDFlammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> PETRIFIED_PLANK_TRAPDOOR = registerBlock("petrified_plank_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> PETRIFIED_PLANK_DOOR = registerBlock("petrified_plank_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> PETRIFIED_PLANK_BUTTON = registerBlock("petrified_plank_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> PETRIFIED_PLANK_PRESSURE_PLATE = registerBlock("petrified_plank_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING ,BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> PETRIFIED_PLANK_WALL_SIGN = registerBlockWithoutItem("petrified_plank_wall_sign",
            () -> new DWDWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), DWDWoodTypes.PETRIFIED));
    public static final RegistryObject<Block> PETRIFIED_PLANK_SIGN = registerBlockWithoutItem("petrified_plank_sign",
            () -> new DWDStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), DWDWoodTypes.PETRIFIED));

    //Vegetation
    public static final RegistryObject<Block> PETRIFIED_LEAVES = registerBlock("petrified_leaves", () -> new DWDLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> PETRIFIED_JUNGLE_LEAVES = registerBlock("petrified_jungle_leaves", () -> new DWDLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> PETRIFIED_SAPLING = registerBlock("petrified_sapling", () -> new SaplingBlock(new PetrifiedTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> PETRIFIED_JUNGLE_SAPLING = registerBlock("petrified_jungle_sapling", () -> new SaplingBlock(new PetrifiedTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_BUSH = registerBlock("skaro_bush", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_SHRUB = registerBlock("skaro_shrub", () -> new DWDBushBlock(BlockBehaviour.Properties.copy(Blocks.GRASS), "large"), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_SHRUB_SMALL = registerBlock("skaro_shrub_small", () -> new DWDBushBlock(BlockBehaviour.Properties.copy(Blocks.GRASS), "small"), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_DEAD_SHRUB = registerBlock("skaro_dead_shrub", () -> new DeadBushBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_DEAD_SHRUB_SMALL = registerBlock("skaro_dead_shrub_small", () -> new DeadBushBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_PETRIFIED_SHRUB = registerBlock("skaro_petrified_shrub", () -> new DeadBushBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_TALL_GRASS = registerBlock("skaro_tall_grass", () -> new DWDBushBlock(BlockBehaviour.Properties.copy(Blocks.GRASS), "small"), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_PETRIFIED_FLOWER_1 = registerBlock("petrified_flower_1", () -> new PetrifiedPlant(MobEffects.DAMAGE_BOOST, 6, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_PETRIFIED_FLOWER_2 = registerBlock("petrified_flower_2", () -> new PetrifiedPlant(MobEffects.DAMAGE_BOOST, 6, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_PETRIFIED_FUNGUS = registerBlock("petrified_fungus", () -> new PetrifiedPlant(MobEffects.DIG_SPEED, 6, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> POTTED_SKARO_PETRIFIED_FLOWER_1 = registerBlockWithoutItem("potted_petrified_flower_1", () -> new FlowerPotBlock(SKARO_PETRIFIED_FLOWER_1.get(),BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));
    public static final RegistryObject<Block> POTTED_SKARO_PETRIFIED_FLOWER_2 = registerBlockWithoutItem("potted_petrified_flower_2", () -> new FlowerPotBlock( SKARO_PETRIFIED_FLOWER_2.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));
    public static final RegistryObject<Block> POTTED_SKARO_PETRIFIED_FUNGUS = registerBlockWithoutItem("potted_petrified_fungus", () -> new FlowerPotBlock( SKARO_PETRIFIED_FUNGUS.get(),BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));
    public static final RegistryObject<Block> VARGA_BUSH = registerBlock("varga_bush", () -> new VargaPlant(MobEffects.DAMAGE_BOOST, 6, BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).noOcclusion()), DWDCreativeTabs.DWDSkaro);
    //Special Blocks
    public static final RegistryObject<Block> HANDMINE_TRAP = registerBlock("handmine_trap", () -> new HandmineTrapBlock(BlockBehaviour.Properties.copy(Blocks.DIRT)), DWDCreativeTabs.DWDSkaro);
    //Basic ground blocks
    public static final RegistryObject<Block> SKARO_DIRT = registerBlock("skaro_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_GRASS = registerBlock("skaro_grass",
            () -> new DWDGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK), () -> SKARO_DIRT.get()), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_SAND = registerBlock("skaro_sand",
            () -> new SandBlock(11098145, BlockBehaviour.Properties.copy(Blocks.SAND)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_COBBLESTONE = registerBlock("skaro_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_STONE = registerBlock("skaro_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_GRAVEL = registerBlock("skaro_gravel",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_MUD = registerBlock("skaro_mud",
            () -> new MudBlock(BlockBehaviour.Properties.copy(Blocks.MUD)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_PACKED_MUD = registerBlock("skaro_packed_mud",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PACKED_MUD)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_QUICKSAND = registerBlock("skaro_quicksand",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_HIGHLANDS_STONE = registerBlock("skaro_highlands_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)), DWDCreativeTabs.DWDSkaro);
    public static final RegistryObject<Block> SKARO_HIGHLANDS_COBBLESTONE = registerBlock("skaro_highlands_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)), DWDCreativeTabs.DWDSkaro);

    /*
    REGISTRY METHODS
     */

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return DWDItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
