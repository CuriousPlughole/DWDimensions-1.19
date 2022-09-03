package com.prismmods.dwdimensions.datagen.loot;

import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.block.custom.VargaPlant;
import com.prismmods.dwdimensions.common.item.DWDItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

public class DWDBlockLootTables extends BlockLoot {

    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    @Override
    protected void addTables() {

        //GALLIFREY
        this.add(DWDBlocks.ZEITON_ORE.get(), (block) -> createOreDrop(DWDBlocks.ZEITON_ORE.get(), DWDItems.ZEITON_7.get()));
        this.add(DWDBlocks.DEEPSLATE_ZEITON_ORE.get(), (block) -> createOreDrop(DWDBlocks.DEEPSLATE_ZEITON_ORE.get(), DWDItems.ZEITON_7.get()));
        this.add(DWDBlocks.TARDIS.get(), noDrop());
        this.add(DWDBlocks.MERCURY_VAPOUR.get(), noDrop());

        //SKARO
        this.dropSelf(DWDBlocks.DALEK_WALL_COMPUTER.get());
        this.dropSelf(DWDBlocks.RADIOTHERAPY_CABINET.get());
        this.dropSelf(DWDBlocks.PETRIFIED_LOG.get());
        this.dropSelf(DWDBlocks.STRIPPED_PETRIFIED_LOG.get());
        this.dropSelf(DWDBlocks.STRIPPED_PETRIFIED_WOOD.get());
        this.dropSelf(DWDBlocks.PETRIFIED_JUNGLE_LOG.get());
        this.dropSelf(DWDBlocks.PETRIFIED_JUNGLE_WOOD.get());
        this.dropSelf(DWDBlocks.PETRIFIED_WOOD.get());
        this.dropSelf(DWDBlocks.PETRIFIED_PLANKS.get());
        this.dropSelf(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get());
        this.dropSelf(DWDBlocks.PETRIFIED_SAPLING.get());
        this.dropSelf(DWDBlocks.PETRIFIED_JUNGLE_SAPLING.get());
        this.dropSelf(DWDBlocks.SKARO_DIRT.get());
        this.dropSelf(DWDBlocks.SKARO_SAND.get());
        this.dropSelf(DWDBlocks.HANDMINE_TRAP.get());
        this.dropSelf(DWDBlocks.SKARO_COBBLESTONE.get());
        this.dropSelf(DWDBlocks.SKARO_MUD.get());
        this.dropSelf(DWDBlocks.SKARO_PACKED_MUD.get());
        this.dropSelf(DWDBlocks.SKARO_GRAVEL.get());
        this.dropSelf(DWDBlocks.SKARO_QUICKSAND.get());
        this.dropSelf(DWDBlocks.SKARO_HIGHLANDS_STONE.get());
        this.dropSelf(DWDBlocks.SKARO_HIGHLANDS_COBBLESTONE.get());
        this.dropSelf(DWDBlocks.STRIPPED_PETRIFIED_JUNGLE_WOOD.get());
        this.dropSelf(DWDBlocks.STRIPPED_PETRIFIED_JUNGLE_LOG.get());
        this.dropSelf(DWDBlocks.PETRIFIED_PLANK_STAIRS.get());
        this.dropSelf(DWDBlocks.PETRIFIED_PLANK_SLAB.get());
        this.dropSelf(DWDBlocks.PETRIFIED_PLANK_FENCE.get());
        this.dropSelf(DWDBlocks.PETRIFIED_PLANK_FENCE_GATE.get());
        this.dropSelf(DWDBlocks.PETRIFIED_PLANK_BUTTON.get());
        this.dropSelf(DWDBlocks.PETRIFIED_PLANK_PRESSURE_PLATE.get());
        this.dropSelf(DWDBlocks.PETRIFIED_PLANK_DOOR.get());
        this.dropSelf(DWDBlocks.PETRIFIED_PLANK_TRAPDOOR.get());
        this.dropSelf(DWDBlocks.PETRIFIED_JUNGLE_PLANK_STAIRS.get());
        this.dropSelf(DWDBlocks.PETRIFIED_JUNGLE_PLANK_SLAB.get());
        this.dropSelf(DWDBlocks.PETRIFIED_JUNGLE_PLANK_FENCE.get());
        this.dropSelf(DWDBlocks.PETRIFIED_JUNGLE_PLANK_FENCE_GATE.get());
        this.dropSelf(DWDBlocks.PETRIFIED_JUNGLE_PLANK_BUTTON.get());
        this.dropSelf(DWDBlocks.PETRIFIED_JUNGLE_PLANK_PRESSURE_PLATE.get());
        this.dropSelf(DWDBlocks.PETRIFIED_JUNGLE_PLANK_DOOR.get());
        this.dropSelf(DWDBlocks.PETRIFIED_JUNGLE_PLANK_TRAPDOOR.get());
        this.dropSelf(DWDBlocks.SKARO_SANDSTONE.get());
        this.dropSelf(DWDBlocks.DALEKANIUM_BLOCK.get());
        this.dropSelf(DWDBlocks.LOW_GRADE_STRUCTURAL_DALEKANIUM.get());
        this.dropSelf(DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM.get());
        this.dropSelf(DWDBlocks.MILITARY_GRADE_STRUCTURAL_DALEKANIUM.get());

        this.dropSelf(DWDBlocks.LOW_GRADE_STRUCTURAL_DALEKANIUM_SLAB.get());
        this.dropSelf(DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM_SLAB.get());
        this.dropSelf(DWDBlocks.MILITARY_GRADE_STRUCTURAL_DALEKANIUM_SLAB.get());
        this.dropSelf(DWDBlocks.LOW_GRADE_STRUCTURAL_DALEKANIUM_STAIRS.get());
        this.dropSelf(DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM_STAIRS.get());
        this.dropSelf(DWDBlocks.MILITARY_GRADE_STRUCTURAL_DALEKANIUM_STAIRS.get());
        this.dropSelf(DWDBlocks.LOW_GRADE_STRUCTURAL_DALEKANIUM_WALL.get());
        this.dropSelf(DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM_WALL.get());
        this.dropSelf(DWDBlocks.MILITARY_GRADE_STRUCTURAL_DALEKANIUM_WALL.get());

        this.dropSelf(DWDBlocks.SKARO_COBBLESTONE_SLAB.get());
        this.dropSelf(DWDBlocks.SKARO_COBBLESTONE_STAIRS.get());
        this.dropSelf(DWDBlocks.SKARO_COBBLESTONE_WALL.get());
        this.dropSelf(DWDBlocks.SKARO_HIGHLANDS_COBBLESTONE_SLAB.get());
        this.dropSelf(DWDBlocks.SKARO_HIGHLANDS_COBBLESTONE_STAIRS.get());
        this.dropSelf(DWDBlocks.SKARO_HIGHLANDS_COBBLESTONE_WALL.get());
        this.dropSelf(DWDBlocks.SKARO_HIGHLANDS_STONE_SLAB.get());
        this.dropSelf(DWDBlocks.SKARO_HIGHLANDS_STONE_STAIRS.get());
        this.dropSelf(DWDBlocks.SKARO_HIGHLANDS_STONE_WALL.get());
        this.dropSelf(DWDBlocks.SKARO_STONE_SLAB.get());
        this.dropSelf(DWDBlocks.SKARO_STONE_STAIRS.get());
        this.dropSelf(DWDBlocks.SKARO_STONE_WALL.get());

        this.dropSelf(DWDBlocks.SKARO_PETRIFIED_FLOWER_1.get());
        this.dropSelf(DWDBlocks.SKARO_PETRIFIED_FLOWER_2.get());
        this.dropSelf(DWDBlocks.SKARO_PETRIFIED_FUNGUS.get());
        this.dropPottedContents(DWDBlocks.POTTED_SKARO_PETRIFIED_FLOWER_1.get());
        this.dropPottedContents(DWDBlocks.POTTED_SKARO_PETRIFIED_FLOWER_2.get());
        this.dropPottedContents(DWDBlocks.POTTED_SKARO_PETRIFIED_FUNGUS.get());
        this.add(DWDBlocks.SKARO_GRASS.get(), (block) -> createSingleItemTableWithSilkTouch(block, DWDBlocks.SKARO_DIRT.get()));
        this.add(DWDBlocks.PETRIFIED_LEAVES.get(), (block) -> createLeavesDrops(block, DWDBlocks.PETRIFIED_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(DWDBlocks.PETRIFIED_JUNGLE_LEAVES.get(), (block) -> createLeavesDrops(block, DWDBlocks.PETRIFIED_JUNGLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(DWDBlocks.SKARO_SHRUB.get(), (block) -> createShearsOnlyDrop(block));
        this.add(DWDBlocks.SKARO_SHRUB_SMALL.get(), (block) -> createShearsOnlyDrop(block));
        this.add(DWDBlocks.SKARO_PETRIFIED_SHRUB.get(), (block) -> createShearsOnlyDrop(block));
        this.add(DWDBlocks.SKARO_TALL_GRASS.get(), (block) -> createShearsOnlyDrop(block));
        this.add(DWDBlocks.SKARO_DEAD_SHRUB.get(), (block) -> createShearsDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))));
        this.add(DWDBlocks.SKARO_DEAD_SHRUB_SMALL.get(), (block) -> createShearsDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))));
        this.add(DWDBlocks.SKARO_BUSH.get(), (block) -> createShearsDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))));
        this.add(DWDBlocks.VARGA_BUSH.get(), (block) -> applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(DWDBlocks.VARGA_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(VargaPlant.AGE, 3))).add(LootItem.lootTableItem(DWDItems.VARGA_BERRIES.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(DWDBlocks.VARGA_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(VargaPlant.AGE, 2))).add(LootItem.lootTableItem(DWDItems.VARGA_BERRIES.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
        this.add(DWDBlocks.SKARO_STONE.get(), (block) -> createSingleItemTableWithSilkTouch(block, DWDBlocks.SKARO_COBBLESTONE.get()));
        this.add(DWDBlocks.PETRIFIED_PLANK_SIGN.get(), (block) -> createSingleItemTable(DWDItems.PETRIFIED_PLANK_SIGN.get()));
        this.add(DWDBlocks.PETRIFIED_PLANK_WALL_SIGN.get(), (block) -> createSingleItemTable(DWDItems.PETRIFIED_PLANK_SIGN.get()));
        this.add(DWDBlocks.PETRIFIED_JUNGLE_PLANK_SIGN.get(), (block) -> createSingleItemTable(DWDItems.PETRIFIED_JUNGLE_PLANK_SIGN.get()));
        this.add(DWDBlocks.PETRIFIED_JUNGLE_PLANK_WALL_SIGN.get(), (block) -> createSingleItemTable(DWDItems.PETRIFIED_JUNGLE_PLANK_SIGN.get()));
        this.add(DWDBlocks.MERCURY_GEYSER.get(), (block) -> createSingleItemTableWithSilkTouch(block, DWDBlocks.SKARO_STONE.get()));
        this.add(DWDBlocks.SKARO_VINES.get(), (block) -> createShearsOnlyDrop(block));
        this.add(DWDBlocks.DALEKANIUM_ORE.get(), (block) -> createOreDrop(DWDBlocks.DALEKANIUM_ORE.get(), DWDItems.RAW_DALEKANIUM.get()));
        this.add(DWDBlocks.DEEPSLATE_DALEKANIUM_ORE.get(), (block) -> createOreDrop(DWDBlocks.DEEPSLATE_DALEKANIUM_ORE.get(), DWDItems.RAW_DALEKANIUM.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return DWDBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
