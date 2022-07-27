package com.prismmods.dwdimensions.util;

import com.prismmods.dwdimensions.common.item.custom.SonicScrewdriverItem;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.Nullable;

//This is deprecated but will do for now. In future may need to look into BEWLR
//https://forge.gemwire.uk/wiki/BlockEntityWithoutLevelRenderer

public class SonicPropertyFunction implements ItemPropertyFunction {

    //Return floats that are used in the json file predicates.

    @Override
    public float call(ItemStack stack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity entity, int dontKnowWhatThisIntIs) {

        //MODEL
        if(SonicScrewdriverItem.getScrewdriverModel(stack) == SonicScrewdriverItem.ScrewdriverModel.WHITTAKER) {
            return 0.01f;
        }
        if(SonicScrewdriverItem.getScrewdriverModel(stack) == SonicScrewdriverItem.ScrewdriverModel.CAPALDI) {
            return 0.02f;
        }

        //SETTING
        if(SonicScrewdriverItem.getMode(stack) == SonicScrewdriverItem.Setting.BLOCK) {
            return 0.1f;
        }
        if(SonicScrewdriverItem.getMode(stack) == SonicScrewdriverItem.Setting.ENTITY) {
            return 0.2f;
        }

        return 0;
    }
}
