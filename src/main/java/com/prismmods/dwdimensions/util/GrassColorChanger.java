package com.prismmods.dwdimensions.util;

import com.prismmods.dwdimensions.common.block.custom.generic.DWDGrassBlock;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class GrassColorChanger implements BlockColor {

    @Override
    public int getColor(BlockState state, @Nullable BlockAndTintGetter getter, @Nullable BlockPos pos, int tint) {
        /*
        if(state.getBlock() instanceof DWDGrassBlock) {
            return reader != null && pos != null ? colorShift(BiomeColors.getAverageGrassColor(reader, pos), 20, (int)(-3*(Math.floor(pos.getY()/10)))+25, 0) : colorShift(GrassColor.get(0.5D, 1.0D), 20, 5, 0);
        } else {
            return reader != null && pos != null ? BiomeColors.getAverageGrassColor(reader, pos) : GrassColor.get(0.5D, 1.0D);
        }*/
        if(getter instanceof LevelReader reader) {
            float temp = reader.getBiome(pos).value().getBaseTemperature();
            float humidity = reader.getBiome(pos).value().getDownfall();
            return reader.getBiome(pos).value().getGrassColor(temp, humidity);
        } else {
            return 0xAF5CED92;
        }
    }

    private int colorShift(int color, int redShift, int greenShift, int blueShift) {
        float r = redShift;
        float g = greenShift;
        float b = blueShift;
        Color col = new Color(color);
        r += (col.getRed());
        g += (col.getGreen());
        b += (col.getBlue());
        int rgb = Math.round(Math.min(r,255));
        rgb = (rgb << 8) +  Math.round(Math.min(g,255));
        rgb = (rgb << 8) +  Math.round(Math.min(b,255));
        return rgb;
    }
}
