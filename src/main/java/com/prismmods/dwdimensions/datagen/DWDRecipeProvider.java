package com.prismmods.dwdimensions.datagen;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.item.DWDItems;
import com.prismmods.dwdimensions.util.DWDTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class DWDRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public DWDRecipeProvider(DataGenerator p_125973_) {
        super(p_125973_);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

        RecipeProvider.planksFromLogs(pFinishedRecipeConsumer, DWDBlocks.PETRIFIED_PLANKS.get(), DWDTags.Items.PETRIFIED_LOGS);
        RecipeProvider.planksFromLogs(pFinishedRecipeConsumer, DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get(), DWDTags.Items.PETRIFIED_JUNGLE_LOGS);
        RecipeProvider.woodFromLogs(pFinishedRecipeConsumer, DWDBlocks.PETRIFIED_WOOD.get(), DWDBlocks.PETRIFIED_LOG.get());
        RecipeProvider.woodFromLogs(pFinishedRecipeConsumer, DWDBlocks.STRIPPED_PETRIFIED_WOOD.get(), DWDBlocks.STRIPPED_PETRIFIED_LOG.get());
        RecipeProvider.woodFromLogs(pFinishedRecipeConsumer, DWDBlocks.PETRIFIED_JUNGLE_WOOD.get(), DWDBlocks.PETRIFIED_JUNGLE_LOG.get());
        RecipeProvider.woodFromLogs(pFinishedRecipeConsumer, DWDBlocks.STRIPPED_PETRIFIED_JUNGLE_WOOD.get(), DWDBlocks.STRIPPED_PETRIFIED_JUNGLE_LOG.get());
        RecipeProvider.slab(pFinishedRecipeConsumer, DWDBlocks.PETRIFIED_PLANK_SLAB.get(), DWDBlocks.PETRIFIED_PLANKS.get().asItem());
        RecipeProvider.stairBuilder(DWDBlocks.PETRIFIED_PLANK_STAIRS.get(), Ingredient.of(DWDBlocks.PETRIFIED_PLANKS.get().asItem()))
                .unlockedBy("has_petrified_planks", has(DWDBlocks.PETRIFIED_PLANKS.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "petrified_plank_stairs"));
        RecipeProvider.fenceBuilder(DWDBlocks.PETRIFIED_PLANK_FENCE.get(), Ingredient.of(DWDBlocks.PETRIFIED_PLANKS.get().asItem()))
                .unlockedBy("has_petrified_planks", has(DWDBlocks.PETRIFIED_PLANKS.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "petrified_plank_fence"));
        RecipeProvider.fenceGateBuilder(DWDBlocks.PETRIFIED_PLANK_FENCE_GATE.get(), Ingredient.of(DWDBlocks.PETRIFIED_PLANKS.get().asItem()))
                .unlockedBy("has_petrified_planks", has(DWDBlocks.PETRIFIED_PLANKS.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "petrified_plank_fence_gate"));
        RecipeProvider.buttonBuilder(DWDBlocks.PETRIFIED_PLANK_BUTTON.get(), Ingredient.of(DWDBlocks.PETRIFIED_PLANKS.get().asItem()))
                .unlockedBy("has_petrified_planks", has(DWDBlocks.PETRIFIED_PLANKS.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "petrified_plank_button"));
        RecipeProvider.pressurePlate(pFinishedRecipeConsumer, DWDBlocks.PETRIFIED_PLANK_PRESSURE_PLATE.get(), DWDBlocks.PETRIFIED_PLANKS.get().asItem());
        RecipeProvider.doorBuilder(DWDBlocks.PETRIFIED_PLANK_DOOR.get(), Ingredient.of(DWDBlocks.PETRIFIED_PLANKS.get().asItem()))
                .unlockedBy("has_petrified_planks", has(DWDBlocks.PETRIFIED_PLANKS.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "petrified_plank_door"));
        RecipeProvider.trapdoorBuilder(DWDBlocks.PETRIFIED_PLANK_TRAPDOOR.get(), Ingredient.of(DWDBlocks.PETRIFIED_PLANKS.get().asItem()))
                .unlockedBy("has_petrified_planks", has(DWDBlocks.PETRIFIED_PLANKS.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "petrified_plank_trapdoor"));
        RecipeProvider.signBuilder(DWDItems.PETRIFIED_PLANK_SIGN.get(), Ingredient.of(DWDBlocks.PETRIFIED_PLANKS.get().asItem()))
                .unlockedBy("has_petrified_planks", has(DWDBlocks.PETRIFIED_PLANKS.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "petrified_plank_sign"));
        RecipeProvider.slab(pFinishedRecipeConsumer, DWDBlocks.PETRIFIED_JUNGLE_PLANK_SLAB.get(), DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem());
        RecipeProvider.stairBuilder(DWDBlocks.PETRIFIED_JUNGLE_PLANK_STAIRS.get(), Ingredient.of(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem()))
                .unlockedBy("has_petrified_jungle_planks", has(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "petrified_jungle_plank_stair"));
        RecipeProvider.fenceBuilder(DWDBlocks.PETRIFIED_JUNGLE_PLANK_FENCE.get(), Ingredient.of(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem()))
                .unlockedBy("has_petrified_jungle_planks", has(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "petrified_jungle_plank_fence"));
        RecipeProvider.fenceGateBuilder(DWDBlocks.PETRIFIED_JUNGLE_PLANK_FENCE_GATE.get(), Ingredient.of(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem()))
                .unlockedBy("has_petrified_jungle_planks", has(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "petrified_jungle_plank_fence_gate"));
        RecipeProvider.buttonBuilder(DWDBlocks.PETRIFIED_JUNGLE_PLANK_BUTTON.get(), Ingredient.of(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem()))
                .unlockedBy("has_petrified_jungle_planks", has(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "petrified_jungle_plank_button"));
        RecipeProvider.pressurePlate(pFinishedRecipeConsumer, DWDBlocks.PETRIFIED_JUNGLE_PLANK_PRESSURE_PLATE.get(), DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem());
        RecipeProvider.doorBuilder(DWDBlocks.PETRIFIED_JUNGLE_PLANK_DOOR.get(), Ingredient.of(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem()))
                .unlockedBy("has_petrified_jungle_planks", has(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "petrified_jungle_plank_door"));
        RecipeProvider.trapdoorBuilder(DWDBlocks.PETRIFIED_JUNGLE_PLANK_TRAPDOOR.get(), Ingredient.of(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem()))
                .unlockedBy("has_petrified_jungle_planks", has(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "petrified_jungle_plank_trapdoor"));
        RecipeProvider.signBuilder(DWDItems.PETRIFIED_JUNGLE_PLANK_SIGN.get(), Ingredient.of(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem()))
                .unlockedBy("has_petrified_jungle_planks", has(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "petrified_jungle_plank_sign"));

        RecipeProvider.slab(pFinishedRecipeConsumer, DWDBlocks.SKARO_COBBLESTONE_SLAB.get(), DWDBlocks.SKARO_COBBLESTONE.get().asItem());
        RecipeProvider.slab(pFinishedRecipeConsumer, DWDBlocks.SKARO_HIGHLANDS_COBBLESTONE_SLAB.get(), DWDBlocks.SKARO_HIGHLANDS_COBBLESTONE.get().asItem());
        RecipeProvider.slab(pFinishedRecipeConsumer, DWDBlocks.SKARO_STONE_SLAB.get(), DWDBlocks.SKARO_STONE.get().asItem());
        RecipeProvider.slab(pFinishedRecipeConsumer, DWDBlocks.SKARO_HIGHLANDS_STONE_SLAB.get(), DWDBlocks.SKARO_HIGHLANDS_STONE.get().asItem());
        RecipeProvider.wall(pFinishedRecipeConsumer, DWDBlocks.SKARO_COBBLESTONE_WALL.get(), DWDBlocks.SKARO_COBBLESTONE.get().asItem());
        RecipeProvider.wall(pFinishedRecipeConsumer, DWDBlocks.SKARO_STONE_WALL.get(), DWDBlocks.SKARO_STONE.get().asItem());
        RecipeProvider.wall(pFinishedRecipeConsumer, DWDBlocks.SKARO_HIGHLANDS_COBBLESTONE_WALL.get(), DWDBlocks.SKARO_HIGHLANDS_COBBLESTONE.get().asItem());
        RecipeProvider.wall(pFinishedRecipeConsumer, DWDBlocks.SKARO_HIGHLANDS_STONE_WALL.get(), DWDBlocks.SKARO_HIGHLANDS_STONE.get().asItem());
        RecipeProvider.stairBuilder(DWDBlocks.SKARO_COBBLESTONE_STAIRS.get(), Ingredient.of(DWDBlocks.SKARO_COBBLESTONE.get().asItem()))
                .unlockedBy("has_skaro_cobblestone", has(DWDBlocks.SKARO_COBBLESTONE.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "skaro_cobblestone_stair"));
        RecipeProvider.stairBuilder(DWDBlocks.SKARO_STONE_STAIRS.get(), Ingredient.of(DWDBlocks.SKARO_STONE.get().asItem()))
                .unlockedBy("has_skaro_stone", has(DWDBlocks.SKARO_STONE.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "skaro_stone_stair"));
        RecipeProvider.stairBuilder(DWDBlocks.SKARO_HIGHLANDS_STONE_STAIRS.get(), Ingredient.of(DWDBlocks.SKARO_HIGHLANDS_STONE.get().asItem()))
                .unlockedBy("has_skaro_highlands_stone", has(DWDBlocks.SKARO_HIGHLANDS_STONE.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "skaro_highlands_stone_stair"));
        RecipeProvider.stairBuilder(DWDBlocks.SKARO_HIGHLANDS_COBBLESTONE_STAIRS.get(), Ingredient.of(DWDBlocks.SKARO_HIGHLANDS_COBBLESTONE.get().asItem()))
                .unlockedBy("has_skaro_highlands_cobblestone", has(DWDBlocks.SKARO_HIGHLANDS_COBBLESTONE.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "skaro_highlands_cobblestone_stair"));

        RecipeProvider.slab(pFinishedRecipeConsumer, DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM_SLAB.get(), DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM.get().asItem());
        RecipeProvider.slab(pFinishedRecipeConsumer, DWDBlocks.LOW_GRADE_STRUCTURAL_DALEKANIUM_SLAB.get(), DWDBlocks.LOW_GRADE_STRUCTURAL_DALEKANIUM.get().asItem());
        RecipeProvider.slab(pFinishedRecipeConsumer, DWDBlocks.MILITARY_GRADE_STRUCTURAL_DALEKANIUM_SLAB.get(), DWDBlocks.MILITARY_GRADE_STRUCTURAL_DALEKANIUM.get().asItem());
        RecipeProvider.wall(pFinishedRecipeConsumer, DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM_WALL.get(), DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM.get().asItem());
        RecipeProvider.wall(pFinishedRecipeConsumer, DWDBlocks.LOW_GRADE_STRUCTURAL_DALEKANIUM_WALL.get(), DWDBlocks.LOW_GRADE_STRUCTURAL_DALEKANIUM.get().asItem());
        RecipeProvider.wall(pFinishedRecipeConsumer, DWDBlocks.MILITARY_GRADE_STRUCTURAL_DALEKANIUM_WALL.get(), DWDBlocks.MILITARY_GRADE_STRUCTURAL_DALEKANIUM.get().asItem());
        RecipeProvider.stairBuilder(DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM_STAIRS.get(), Ingredient.of(DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM.get().asItem()))
                .unlockedBy("has_high_grade_structural_dalekanium", has(DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "structural_dalekanium_high_stair"));
        RecipeProvider.stairBuilder(DWDBlocks.LOW_GRADE_STRUCTURAL_DALEKANIUM_STAIRS.get(), Ingredient.of(DWDBlocks.LOW_GRADE_STRUCTURAL_DALEKANIUM.get().asItem()))
                .unlockedBy("has_low_grade_structural_dalekanium", has(DWDBlocks.LOW_GRADE_STRUCTURAL_DALEKANIUM.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "structural_dalekanium_low_stair"));
        RecipeProvider.stairBuilder(DWDBlocks.MILITARY_GRADE_STRUCTURAL_DALEKANIUM_STAIRS.get(), Ingredient.of(DWDBlocks.MILITARY_GRADE_STRUCTURAL_DALEKANIUM.get().asItem()))
                .unlockedBy("has_military_grade_structural_dalekanium", has(DWDBlocks.MILITARY_GRADE_STRUCTURAL_DALEKANIUM.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "structural_dalekanium_military_stair"));

        ShapedRecipeBuilder.shaped(DWDBlocks.LOW_GRADE_STRUCTURAL_DALEKANIUM.get(), 8).define('R', DWDItems.RAW_DALEKANIUM.get()).define('S', DWDBlocks.SKARO_STONE.get())
                .pattern("SSS")
                .pattern("SRS")
                .pattern("SSS")
                .unlockedBy("has_raw_dalekanium", has(DWDItems.RAW_DALEKANIUM.get())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM.get(), 8).define('R', DWDItems.DALEKANIUM_INGOT.get()).define('S', DWDBlocks.SKARO_STONE.get())
                .pattern("SSS")
                .pattern("SRS")
                .pattern("SSS")
                .unlockedBy("has_dalekanium_ingot", has(DWDItems.DALEKANIUM_INGOT.get())).save(pFinishedRecipeConsumer);

        RecipeProvider.nineBlockStorageRecipes(pFinishedRecipeConsumer, DWDItems.DALEKANIUM_INGOT.get(), DWDBlocks.DALEKANIUM_BLOCK.get());

        //Parameters: item to smelt, result, experience gained, cooking time.
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DWDBlocks.ZEITON_ORE.get().asItem()), DWDItems.ZEITON_7.get(), 0.1F, 200)
                .unlockedBy("has_zeiton_ore", inventoryTrigger(ItemPredicate.Builder.item().of(DWDBlocks.ZEITON_ORE.get()).build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "smelt_zeiton_ore"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(DWDBlocks.ZEITON_ORE.get().asItem()), DWDItems.ZEITON_7.get(), 0.1F, 100)
                .unlockedBy("has_zeiton_ore", inventoryTrigger(ItemPredicate.Builder.item().of(DWDBlocks.ZEITON_ORE.get()).build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "blast_zeiton_ore"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DWDBlocks.DEEPSLATE_ZEITON_ORE.get().asItem()), DWDItems.ZEITON_7.get(), 0.1F, 200)
                .unlockedBy("has_deepslate_zeiton_ore", inventoryTrigger(ItemPredicate.Builder.item().of(DWDBlocks.DEEPSLATE_ZEITON_ORE.get()).build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "smelt_deepslate_zeiton_ore"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(DWDBlocks.DEEPSLATE_ZEITON_ORE.get().asItem()), DWDItems.ZEITON_7.get(), 0.1F, 100)
                .unlockedBy("has_deepslate_zeiton_ore", inventoryTrigger(ItemPredicate.Builder.item().of(DWDBlocks.DEEPSLATE_ZEITON_ORE.get()).build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "blast_deepslate_zeiton_ore"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DWDBlocks.DALEKANIUM_ORE.get().asItem()), DWDItems.DALEKANIUM_INGOT.get(), 0.2F, 200)
                .unlockedBy("has_dalekanium_ore", has(DWDBlocks.DALEKANIUM_ORE.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "smelt_dalekanium_ore"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(DWDBlocks.DALEKANIUM_ORE.get().asItem()), DWDItems.DALEKANIUM_INGOT.get(), 0.2F, 100)
                .unlockedBy("has_dalekanium_ore", has(DWDBlocks.DALEKANIUM_ORE.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "blast_dalekanium_ore"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DWDBlocks.DEEPSLATE_DALEKANIUM_ORE.get().asItem()), DWDItems.DALEKANIUM_INGOT.get(), 0.3F, 200)
                .unlockedBy("has_deepslate_dalekanium_ore", has(DWDBlocks.DEEPSLATE_DALEKANIUM_ORE.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "smelt_deepslate_dalekanium_ore"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(DWDBlocks.DEEPSLATE_DALEKANIUM_ORE.get().asItem()), DWDItems.DALEKANIUM_INGOT.get(), 0.3F, 100)
                .unlockedBy("has_deepslate_dalekanium_ore", has(DWDBlocks.DEEPSLATE_DALEKANIUM_ORE.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "blast_deepslate_dalekanium_ore"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM.get().asItem()), DWDBlocks.MILITARY_GRADE_STRUCTURAL_DALEKANIUM.get(), 0.1F, 100)
                .unlockedBy("has_high_grade_structural_dalekanium", has(DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "smelt_high_grade_structural_dalekanium"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM.get().asItem()), DWDBlocks.MILITARY_GRADE_STRUCTURAL_DALEKANIUM.get(), 0.1F, 50)
                .unlockedBy("has_high_grade_structural_dalekanium", has(DWDBlocks.HIGH_GRADE_STRUCTURAL_DALEKANIUM.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "blast_high_grade_structural_dalekanium"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DWDItems.RAW_DALEKANIUM.get()), DWDItems.DALEKANIUM_INGOT.get(), 0.1F, 200)
                .unlockedBy("has_raw_dalekanium", has(DWDItems.RAW_DALEKANIUM.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "smelt_raw_dalekanium"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(DWDItems.RAW_DALEKANIUM.get()), DWDItems.DALEKANIUM_INGOT.get(), 0.1F, 100)
                .unlockedBy("has_raw_dalekanium", has(DWDItems.RAW_DALEKANIUM.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "blast_raw_dalekanium"));



    }
}
