package com.prismmods.dwdimensions.common;

import com.prismmods.dwdimensions.common.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {
    //Probably just a temporary tab, can rearrange things later
    public static final CreativeModeTab DWDMaterials = new CreativeModeTab("dwdmaterialstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ZEITON_7.get());
        }
    };
}
