package com.prismmods.dwdimensions.common;

import com.prismmods.dwdimensions.common.item.DWDItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class DWDCreativeTabs {
    //Probably just a temporary tab, can rearrange things later
    public static final CreativeModeTab DWDMaterials = new CreativeModeTab("dwdmaterialstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DWDItems.ZEITON_7.get());
        }
    };

    public static final CreativeModeTab DWDSkaro = new CreativeModeTab("dwdskarotab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.LAVA_BUCKET);
        }
    };
}
