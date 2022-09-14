package net.dwdimensions.fabric;

import net.dwdimensions.dwdimensions;
import net.fabricmc.api.ModInitializer;

public class dwdimensionsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        dwdimensions.init();
    }
}
