package com.prismmods.dwdimensions.datagen.loot;

import com.prismmods.dwdimensions.common.block.ModBlocks;
import com.prismmods.dwdimensions.common.item.ModItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {

    @Override
    protected void addTables() {
        //this.dropSelf(ModBlocks.theblock.get());
        this.add(ModBlocks.ZEITON_ORE.get(), (block) -> createOreDrop(ModBlocks.ZEITON_ORE.get(), ModItems.ZEITON_7.get()));
        this.add(ModBlocks.DEEPSLATE_ZEITON_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_ZEITON_ORE.get(), ModItems.ZEITON_7.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
