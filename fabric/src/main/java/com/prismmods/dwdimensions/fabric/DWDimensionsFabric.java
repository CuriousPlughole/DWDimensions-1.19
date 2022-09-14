package com.prismmods.dwdimensions.fabric;

import com.prismmods.dwdimensions.DWDimensions;
import net.dwdimensions.dwdimensions;
import net.fabricmc.api.ModInitializer;

public class dwdimensionsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        DWDimensions.init();
    }
}
