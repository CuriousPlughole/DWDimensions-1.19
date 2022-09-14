package com.prismmods.dwdimensions.util;

import com.prismmods.dwdimensions.DWDimensions;
import net.minecraft.core.Registry;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class DWDTags {

    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(new ResourceLocation(DWDimensions.MOD_ID, name));
        }

        public static final TagKey<Block> SKARO_GRIT = createTag("skaro_grit");
        public static final TagKey<Block> SKARO_SOIL = createTag("skaro_soil");

        private static TagKey<Block> createForgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {

        public static final TagKey<Item> PETRIFIED_LOGS = createTag("petrified_logs");
        public static final TagKey<Item> PETRIFIED_JUNGLE_LOGS = createTag("petrified_jungle_logs");
        public static final TagKey<Item> LASERS = createTag("lasers");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(new ResourceLocation(DWDimensions.MOD_ID, name));
        }

        private static TagKey<Item> createForgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Entities {
        public static final TagKey<EntityType<?>> RADIATION_IMMUNE = createTag("radiation_immune");
        public static final TagKey<EntityType<?>> SPACE_IMMUNE = createTag("space_immune");
        private static TagKey<EntityType<?>> createTag(String name) {
            return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(DWDimensions.MOD_ID, name));
        }

    }


}
