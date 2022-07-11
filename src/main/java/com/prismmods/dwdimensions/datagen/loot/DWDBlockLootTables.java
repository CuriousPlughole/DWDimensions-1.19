package com.prismmods.dwdimensions.datagen.loot;

import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.item.DWDItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class DWDBlockLootTables extends BlockLoot {

    private static final float[] LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

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
        this.add(DWDBlocks.PETRIFIED_LEAVES.get(), (block) -> createLeavesDrops(DWDBlocks.PETRIFIED_LEAVES.get(), DWDBlocks.PETRIFIED_SAPLING.get())); //blocks may be other way around
        this.add(DWDBlocks.TARDIS.get(), noDrop());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return DWDBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
