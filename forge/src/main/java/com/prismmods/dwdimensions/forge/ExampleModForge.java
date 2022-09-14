package com.prismmods.dwdimensions.forge;

import dev.architectury.platform.forge.EventBuses;
import net.dwdimensions.dwdimensions;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(dwdimensions.MOD_ID)
public class dwdimensionsForge {
    public dwdimensionsForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(dwdimensions.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        dwdimensions.init();
    }
}
