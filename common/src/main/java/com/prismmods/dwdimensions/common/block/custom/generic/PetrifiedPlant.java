package com.prismmods.dwdimensions.common.block.custom.generic;

import com.mojang.math.Vector3d;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.injection.selectors.ISelectorContext;

public class PetrifiedPlant extends FlowerBlock {

    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    public PetrifiedPlant(MobEffect susStewEffect, int durationInSeconds, Properties properties) {
        super(susStewEffect, durationInSeconds, properties);
    }

    public VoxelShape getShape(BlockState p_52419_, BlockGetter p_52420_, BlockPos p_52421_, CollisionContext p_52422_) {
        return SHAPE;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
        super.animateTick(state, level, pos, rand);

        if(rand.nextInt(10) == 0) {
            level.addParticle(ParticleTypes.WARPED_SPORE, pos.getX() + rand.nextDouble(), pos.getY() + 0.5D, pos.getZ() + rand.nextDouble(), 0.0D, 0.0D, 0.0D);
        }


    }
}
