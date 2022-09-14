package com.prismmods.dwdimensions.world.feature.asteroids;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.BulkSectionAccess;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class AsteroidFeature extends Feature<NoneFeatureConfiguration> {

    private int minRadius;
    private int maxRadius;
    private List<Block> blockList;

    public AsteroidFeature(Codec<NoneFeatureConfiguration> codec, int minRad, int maxRad, List<Block> possibleBlocks) {
        super(codec);
        this.minRadius = minRad;
        this.maxRadius = maxRad;
        this.blockList = possibleBlocks;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel worldgenlevel = context.level();
        RandomSource random = context.random();
        BlockPos blockpos = context.origin();

        int radius = minRadius + random.nextInt(maxRadius - minRadius);
        for(int i = 0; radius >= 0 && i < 3; ++i) {
            int j = radius + random.nextInt(2);
            int k = radius + random.nextInt(2);
            int l = radius + random.nextInt(2);

            float f = (float) (j + k + l) * 0.333F + 0.5F;

            for (BlockPos pos : BlockPos.betweenClosed(blockpos.offset(-j, -k, -l), blockpos.offset(j, k, l))) {
                if (pos.distSqr(blockpos) <= (double) f * f) {
                    this.setBlock(worldgenlevel, pos, blockList.get(random.nextInt(blockList.size())).defaultBlockState());
                }
            }
            blockpos = blockpos.offset(-(radius + 1) + random.nextInt(2 + radius * 2), 0 - random.nextInt(2), -(radius + 1) + random.nextInt(2 + radius * 2));
        }
        return true;
    }

}
