package com.prismmods.dwdimensions.common.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class MercuryGeyserBlock extends Block {
    public MercuryGeyserBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {

        if(!entity.fireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) {
            entity.hurt(DamageSource.HOT_FLOOR, 1.0f);
            entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, 0.1D, 0.0D));

            //TODO: custom particles here too
            double d0 = pos.getX();
            double d1 = pos.getY();
            double d2 = pos.getZ();
            Random rand = new Random();
            level.addAlwaysVisibleParticle(ParticleTypes.EXPLOSION, d0 + (double) rand.nextFloat(),
                    d1 + (double) rand.nextFloat(), d2 + (double) rand.nextFloat(), 0.0D, 0.04D, 0.0D);
            level.addAlwaysVisibleParticle(ParticleTypes.DRIPPING_WATER, d0 + (double) rand.nextFloat(),
                    d1 + (double) rand.nextFloat(), d2 + (double) rand.nextFloat(), 0.0D, 0.04D, 0.0D);
            level.playLocalSound(d0,d1,d2, SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 0.05f + rand.nextFloat() * 0.2f,
                    0.9f+rand.nextFloat()*0.15f, false);
        }
        super.stepOn(level, pos, state, entity);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource randomSource) {
        MercuryVapourBlock.updateVapourColumn(level, pos.above());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState facingState, LevelAccessor levelAccessor, BlockPos pos, BlockPos facingPos) {
        if(direction == Direction.UP && facingState.is(Blocks.AIR)) {
            levelAccessor.scheduleTick(pos, this, 20);
        }
        return super.updateShape(state, direction, facingState, levelAccessor, pos, facingPos);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        level.scheduleTick(pos, this, 20);
    }
}
