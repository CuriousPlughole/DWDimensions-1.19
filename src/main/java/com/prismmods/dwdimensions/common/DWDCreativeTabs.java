package com.prismmods.dwdimensions.common;

import com.prismmods.dwdimensions.common.item.DWDItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class DWDCreativeTabs {
    //Probably just a temporary tab, can rearrange things later
    public static final CreativeModeTab DWDWIPTab = new CreativeModeTab("dwdwiptab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DWDItems.DEVICES_ICON.get());
        }
    };

    public static final CreativeModeTab DWDSkaro = new CreativeModeTab("dwdskarotab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DWDItems.SKARO_DISK.get());
        }
    };
}
