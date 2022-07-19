package com.prismmods.dwdimensions.util;

import com.prismmods.dwdimensions.common.block.DWDBlocks;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.GrassColor;

public class DWDColorManager {


    public static synchronized void onBlockColorsInit(BlockColors blockColors) {
        blockColors.register((unknown, lightReader, pos, unknown2) -> lightReader != null && pos != null ? BiomeColors.getAverageGrassColor(lightReader, pos) : GrassColor.get(0.5D, 1.0D), DWDBlocks.SKARO_GRASS.get());

    }

}
