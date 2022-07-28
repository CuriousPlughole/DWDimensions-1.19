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

        //EXAMPLE RECIPE BUILDER FOR ULANDA DOOR. (ULANDA WOOD NOT YET ADDED, JUST SHOWING A SHAPED RECIPE EXAMPLE)
        /*
        ShapedRecipeBuilder.shaped(ModBlocks.ULANDA_DOOR.get()).define('E', ModBlocks.ULANDA_PLANKS.get())
                .pattern("EE")
                .pattern("EE")
                .pattern("EE")
                .unlockedBy("has_ulanda_planks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.ULANDA_PLANKS.get()).build()))
                .save(pFinishedRecipeConsumer);*/

        RecipeProvider.planksFromLogs(pFinishedRecipeConsumer, DWDBlocks.PETRIFIED_PLANKS.get(), DWDTags.Items.PETRIFIED_LOGS);
        RecipeProvider.planksFromLogs(pFinishedRecipeConsumer, DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get(), DWDTags.Items.PETRIFIED_JUNGLE_LOGS);
        RecipeProvider.woodFromLogs(pFinishedRecipeConsumer, DWDBlocks.PETRIFIED_WOOD.get(), DWDBlocks.PETRIFIED_LOG.get());
        RecipeProvider.woodFromLogs(pFinishedRecipeConsumer, DWDBlocks.STRIPPED_PETRIFIED_WOOD.get(), DWDBlocks.STRIPPED_PETRIFIED_LOG.get());
        RecipeProvider.woodFromLogs(pFinishedRecipeConsumer, DWDBlocks.PETRIFIED_JUNGLE_WOOD.get(), DWDBlocks.PETRIFIED_JUNGLE_LOG.get());
        RecipeProvider.woodFromLogs(pFinishedRecipeConsumer, DWDBlocks.STRIPPED_PETRIFIED_JUNGLE_WOOD.get(), DWDBlocks.STRIPPED_PETRIFIED_JUNGLE_LOG.get());

        RecipeProvider.slabBuilder(DWDBlocks.PETRIFIED_PLANK_SLAB.get(), Ingredient.of(DWDBlocks.PETRIFIED_PLANKS.get().asItem()));
        RecipeProvider.stairBuilder(DWDBlocks.PETRIFIED_PLANK_STAIRS.get(), Ingredient.of(DWDBlocks.PETRIFIED_PLANKS.get().asItem()));
        RecipeProvider.fenceBuilder(DWDBlocks.PETRIFIED_PLANK_FENCE.get(), Ingredient.of(DWDBlocks.PETRIFIED_PLANKS.get().asItem()));
        RecipeProvider.fenceGateBuilder(DWDBlocks.PETRIFIED_PLANK_FENCE_GATE.get(), Ingredient.of(DWDBlocks.PETRIFIED_PLANKS.get().asItem()));
        RecipeProvider.buttonBuilder(DWDBlocks.PETRIFIED_PLANK_BUTTON.get(), Ingredient.of(DWDBlocks.PETRIFIED_PLANKS.get().asItem()));
        RecipeProvider.pressurePlateBuilder(DWDBlocks.PETRIFIED_PLANK_PRESSURE_PLATE.get(), Ingredient.of(DWDBlocks.PETRIFIED_PLANKS.get().asItem()));
        RecipeProvider.doorBuilder(DWDBlocks.PETRIFIED_PLANK_DOOR.get(), Ingredient.of(DWDBlocks.PETRIFIED_PLANKS.get().asItem()));
        RecipeProvider.trapdoorBuilder(DWDBlocks.PETRIFIED_PLANK_TRAPDOOR.get(), Ingredient.of(DWDBlocks.PETRIFIED_PLANKS.get().asItem()));
        RecipeProvider.signBuilder(DWDItems.PETRIFIED_PLANK_SIGN.get(), Ingredient.of(DWDBlocks.PETRIFIED_PLANKS.get().asItem()));

        RecipeProvider.slabBuilder(DWDBlocks.PETRIFIED_JUNGLE_PLANK_SLAB.get(), Ingredient.of(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem()));
        RecipeProvider.stairBuilder(DWDBlocks.PETRIFIED_JUNGLE_PLANK_STAIRS.get(), Ingredient.of(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem()));
        RecipeProvider.fenceBuilder(DWDBlocks.PETRIFIED_JUNGLE_PLANK_FENCE.get(), Ingredient.of(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem()));
        RecipeProvider.fenceGateBuilder(DWDBlocks.PETRIFIED_JUNGLE_PLANK_FENCE_GATE.get(), Ingredient.of(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem()));
        RecipeProvider.buttonBuilder(DWDBlocks.PETRIFIED_JUNGLE_PLANK_BUTTON.get(), Ingredient.of(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem()));
        RecipeProvider.pressurePlateBuilder(DWDBlocks.PETRIFIED_JUNGLE_PLANK_PRESSURE_PLATE.get(), Ingredient.of(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem()));
        RecipeProvider.doorBuilder(DWDBlocks.PETRIFIED_JUNGLE_PLANK_DOOR.get(), Ingredient.of(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem()));
        RecipeProvider.trapdoorBuilder(DWDBlocks.PETRIFIED_JUNGLE_PLANK_TRAPDOOR.get(), Ingredient.of(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem()));
        RecipeProvider.signBuilder(DWDItems.PETRIFIED_JUNGLE_PLANK_SIGN.get(), Ingredient.of(DWDBlocks.PETRIFIED_JUNGLE_PLANKS.get().asItem()));

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

    }
}
