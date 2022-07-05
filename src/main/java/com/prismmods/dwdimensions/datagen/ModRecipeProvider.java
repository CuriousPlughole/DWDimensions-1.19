package com.prismmods.dwdimensions.datagen;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.block.ModBlocks;
import com.prismmods.dwdimensions.common.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(DataGenerator p_125973_) {
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

        //Parameters: item to smelt, result, experience gained, cooking time.
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.ZEITON_ORE.get().asItem()), ModItems.ZEITON_7.get(), 0.1F, 200)
                .unlockedBy("has_zeiton_ore", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.ZEITON_ORE.get()).build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "smelt_zeiton_ore"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.ZEITON_ORE.get().asItem()), ModItems.ZEITON_7.get(), 0.1F, 100)
                .unlockedBy("has_zeiton_ore", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.ZEITON_ORE.get()).build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "blast_zeiton_ore"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.DEEPSLATE_ZEITON_ORE.get().asItem()), ModItems.ZEITON_7.get(), 0.1F, 200)
                .unlockedBy("has_deepslate_zeiton_ore", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.DEEPSLATE_ZEITON_ORE.get()).build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "smelt_deepslate_zeiton_ore"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.DEEPSLATE_ZEITON_ORE.get().asItem()), ModItems.ZEITON_7.get(), 0.1F, 100)
                .unlockedBy("has_deepslate_zeiton_ore", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.DEEPSLATE_ZEITON_ORE.get()).build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DWDimensions.MOD_ID, "blast_deepslate_zeiton_ore"));

    }
}
