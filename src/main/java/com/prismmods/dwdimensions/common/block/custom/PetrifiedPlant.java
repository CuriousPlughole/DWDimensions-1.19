package com.prismmods.dwdimensions.common.block.custom;

import com.mojang.math.Vector3d;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.injection.selectors.ISelectorContext;

public class PetrifiedPlant extends FlowerBlock {

    public PetrifiedPlant(MobEffect susStewEffect, int durationInSeconds, Properties properties) {
        super(susStewEffect, durationInSeconds, properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
        super.animateTick(state, level, pos, rand);

        if(rand.nextInt(10) == 0) {
            level.addParticle(ParticleTypes.CRIT, pos.getX() + rand.nextDouble(), pos.getY() + 1.1D, pos.getZ() + rand.nextDouble(), 0.0D, 0.0D, 0.0D);
        }


    }
}
