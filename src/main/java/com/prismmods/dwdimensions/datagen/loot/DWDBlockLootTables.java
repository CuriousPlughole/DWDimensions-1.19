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

    @Override
    protected void addTables() {
        this.dropSelf(DWDBlocks.PETRIFIED_LOG.get());
        this.dropSelf(DWDBlocks.STRIPPED_PETRIFIED_LOG.get());
        this.dropSelf(DWDBlocks.STRIPPED_PETRIFIED_WOOD.get());
        this.dropSelf(DWDBlocks.PETRIFIED_WOOD.get());
        this.dropSelf(DWDBlocks.PETRIFIED_PLANKS.get());
        this.add(DWDBlocks.ZEITON_ORE.get(), (block) -> createOreDrop(DWDBlocks.ZEITON_ORE.get(), DWDItems.ZEITON_7.get()));
        this.add(DWDBlocks.DEEPSLATE_ZEITON_ORE.get(), (block) -> createOreDrop(DWDBlocks.DEEPSLATE_ZEITON_ORE.get(), DWDItems.ZEITON_7.get()));
        this.dropSelf(DWDBlocks.PETRIFIED_SAPLING.get());
        this.add(DWDBlocks.PETRIFIED_LEAVES.get(), (block) -> createLeavesDrops(DWDBlocks.PETRIFIED_LEAVES.get(), DWDBlocks.PETRIFIED_SAPLING.get())); //blocks may be other way around. Need to check this
        this.add(DWDBlocks.TARDIS.get(), noDrop());
        this.dropSelf(DWDBlocks.SKARO_DIRT.get());
        this.add(DWDBlocks.SKARO_GRASS.get(), (block) -> createSingleItemTableWithSilkTouch(block, DWDBlocks.SKARO_DIRT.get()));
        this.dropSelf(DWDBlocks.SKARO_SAND.get());
        this.dropSelf(DWDBlocks.HANDMINE_TRAP.get());

        this.dropPottedContents(DWDBlocks.POTTED_SKARO_PETRIFIED_FLOWER_1.get());
        this.dropPottedContents(DWDBlocks.POTTED_SKARO_PETRIFIED_FLOWER_2.get());
        this.dropPottedContents(DWDBlocks.POTTED_SKARO_PETRIFIED_FUNGUS.get());
        this.dropSelf(DWDBlocks.SKARO_PETRIFIED_FLOWER_1.get());
        this.dropSelf(DWDBlocks.SKARO_PETRIFIED_FLOWER_2.get());
        this.dropSelf(DWDBlocks.SKARO_PETRIFIED_FUNGUS.get());

        this.add(DWDBlocks.SKARO_SHRUB.get(), (block) -> createShearsOnlyDrop(block));
        this.add(DWDBlocks.SKARO_SHRUB_SMALL.get(), (block) -> createShearsOnlyDrop(block));
        this.add(DWDBlocks.SKARO_PETRIFIED_SHRUB.get(), (block) -> createShearsOnlyDrop(block));
        this.add(DWDBlocks.SKARO_TALL_GRASS.get(), (block) -> createShearsOnlyDrop(block));

        this.add(DWDBlocks.SKARO_DEAD_SHRUB.get(), (block) -> createShearsDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))));
        this.add(DWDBlocks.SKARO_DEAD_SHRUB_SMALL.get(), (block) -> createShearsDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))));
        this.add(DWDBlocks.VARGA_BUSH.get(), (block) -> applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(DWDBlocks.VARGA_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(VargaPlant.AGE, 3))).add(LootItem.lootTableItem(DWDItems.VARGA_BERRIES.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(DWDBlocks.VARGA_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(VargaPlant.AGE, 2))).add(LootItem.lootTableItem(DWDItems.VARGA_BERRIES.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return DWDBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
