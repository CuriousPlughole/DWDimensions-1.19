package com.prismmods.dwdimensions.util;

import com.prismmods.dwdimensions.DWDimensions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class DWDTags {

    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(new ResourceLocation(DWDimensions.MOD_ID, name));
        }

        private static TagKey<Block> createForgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {

        public static final TagKey<Item> PETRIFIED_LOGS = createTag("petrified_logs");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(new ResourceLocation(DWDimensions.MOD_ID, name));
        }

        private static TagKey<Item> createForgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
