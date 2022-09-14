package com.prismmods.dwdimensions.common.block.custom;

import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.entity.effect.DWDDamageSources;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Optional;

public class MercuryVapourBlock extends Block implements BucketPickup {

    public MercuryVapourBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        BlockState blockstate = reader.getBlockState(pos.below());
        return blockstate.is(DWDBlocks.MERCURY_GEYSER.get()) || blockstate.is(DWDBlocks.MERCURY_VAPOUR.get());
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return Shapes.empty();
    }

    /*@Override
    public RenderShape getRenderShape(BlockState p_60550_) {
        return RenderShape.INVISIBLE;
    }*/

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(!level.isClientSide) {
            ServerLevel serverLevel = (ServerLevel) level;

            //entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, 0.2D, 0.0D));
            entity.hurt(DWDDamageSources.TOXIC_MERCURY, 2.0f);
            if(entity instanceof Player) {
                entity.hurtMarked = true;
            }

            for(int i=0;i<2;++i) {
                serverLevel.addParticle(ParticleTypes.ASH,  pos.getX() + level.random.nextDouble(),
                        pos.getY() + 1 + level.random.nextDouble(), pos.getZ() + level.random.nextDouble(),
                        0.0D,0.01D,0.0D);
            }
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
        updateVapourColumn(level, pos);
    }


    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        updateVapourColumn(level, pos.above());
    }

    public static void updateVapourColumn(LevelAccessor levelAccessor, BlockPos pos) {
        if(canExistIn(levelAccessor.getBlockState(pos))) {
            int max = 3 + levelAccessor.getRandom().nextInt(8);
            int min = 1;
            for(int i = min; i<max;i++) {
                if(levelAccessor.getBlockState(pos.below(i)) == DWDBlocks.MERCURY_GEYSER.get().defaultBlockState()) {
                    levelAccessor.setBlock(pos, DWDBlocks.MERCURY_VAPOUR.get().defaultBlockState(), 2);

                }
            }

        }
    }

    private static boolean canExistIn(BlockState state) {
        return state.is(DWDBlocks.MERCURY_VAPOUR.get()) || state.is(Blocks.AIR);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
        double d0 = pos.getX();
        double d1 = pos.getY();
        double d2 = pos.getZ();

        //TODO: Temporary particles, make custom ones
        level.addAlwaysVisibleParticle(ParticleTypes.SMOKE, d0 + 0.5D, d1, d2 + 0.5D, 0.0D, 0.04D, 0.0D);
        for (int i = 0; i < 5; i++) {
            level.addAlwaysVisibleParticle(ParticleTypes.CLOUD, d0 + (double) rand.nextFloat(),
                    d1 + (double) rand.nextFloat(), d2 + (double) rand.nextFloat(), 0.0D, 0.04D, 0.0D);
        }

        //TODO: Add some custom sounds
        switch (rand.nextInt(100)) {
            case 0 -> level.playLocalSound(d0,d1,d2, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.2f + rand.nextFloat() * 0.2f,
                    0.9f+rand.nextFloat()*0.15f, false);
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState facingState, LevelAccessor levelAccessor, BlockPos pos, BlockPos facingPos) {
        if(!state.canSurvive(levelAccessor, pos)) {
            return Blocks.AIR.defaultBlockState();
        }
        else {
            if(direction == Direction.DOWN) {
                levelAccessor.setBlock(pos, DWDBlocks.MERCURY_VAPOUR.get().defaultBlockState(), 2);
            } else if (direction == Direction.UP && !facingState.is(DWDBlocks.MERCURY_VAPOUR.get()) && canExistIn(facingState)) {
                levelAccessor.scheduleTick(pos, this, 5);
            }
        }

        return super.updateShape(state, direction, facingState, levelAccessor, pos, facingPos);
    }

    //FIXME: Return liquid mercury here when added
    @Override
    public ItemStack pickupBlock(LevelAccessor levelAccessor, BlockPos pos, BlockState state) {
        levelAccessor.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);
        return new ItemStack(Items.WATER_BUCKET);
    }

    @Override
    public Optional<SoundEvent> getPickupSound() {
        return  Fluids.WATER.getPickupSound();
    }
}
