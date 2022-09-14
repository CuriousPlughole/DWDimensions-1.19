package com.prismmods.dwdimensions.common.block.custom;

import com.prismmods.dwdimensions.common.block.custom.generic.PetrifiedPlant;
import com.prismmods.dwdimensions.common.entity.DWDEntityTypes;
import com.prismmods.dwdimensions.common.item.DWDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VargaPlant extends PetrifiedPlant implements BonemealableBlock {
    private static final float HURT_SPEED_THRESHOLD = 0.003F;
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape SAPLING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    private static final VoxelShape MID_GROWTH_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public VargaPlant(MobEffect susStewEffect, int durationInSeconds, Properties properties) {
        super(susStewEffect, durationInSeconds, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return new ItemStack(DWDItems.VARGA_BERRIES.get());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        if (state.getValue(AGE) == 0) {
            return SAPLING_SHAPE;
        } else {
            return state.getValue(AGE) < 3 ? MID_GROWTH_SHAPE : super.getShape(state, getter, pos, context);
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 3;
    }

    public void randomTick(BlockState p_222563_, ServerLevel p_222564_, BlockPos p_222565_, RandomSource p_222566_) {
        int i = p_222563_.getValue(AGE);
        if (i < 3 && p_222564_.getRawBrightness(p_222565_.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(p_222564_, p_222565_, p_222563_, p_222566_.nextInt(5) == 0)) {
            BlockState blockstate = p_222563_.setValue(AGE, Integer.valueOf(i + 1));
            p_222564_.setBlock(p_222565_, blockstate, 2);
            p_222564_.gameEvent(GameEvent.BLOCK_CHANGE, p_222565_, GameEvent.Context.of(blockstate));
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(p_222564_, p_222565_, p_222563_);
        }

    }

    public void entityInside(BlockState p_57270_, Level p_57271_, BlockPos p_57272_, Entity entity) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE && entity.getType() != DWDEntityTypes.HANDMINE.get()) {
            entity.makeStuckInBlock(p_57270_, new Vec3((double)0.8F, 0.75D, (double)0.8F));
            if (!p_57271_.isClientSide && p_57270_.getValue(AGE) > 0 && (entity.xOld != entity.getX() || entity.zOld != entity.getZ())) {
                double d0 = Math.abs(entity.getX() - entity.xOld);
                double d1 = Math.abs(entity.getZ() - entity.zOld);
                if (d0 >= (double)0.003F || d1 >= (double)0.003F) {
                    entity.hurt(DamageSource.SWEET_BERRY_BUSH, 1.0F); //Fine for now, may want custom damage source in future. (Low priority)
                }
            }

        }
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        int i = state.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            int j = 1 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(DWDItems.VARGA_BERRIES.get(), j + (flag ? 1 : 0)));
            level.playSound((Player)null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            BlockState blockstate = state.setValue(AGE, Integer.valueOf(1));
            level.setBlock(pos, blockstate, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockstate));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.use(state, level, pos, player, hand, result);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_57282_) {
        p_57282_.add(AGE);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter getter, BlockPos pos, BlockState state, boolean p_50900_) {
        return state.getValue(AGE) < 3;
    }
    @Override
    public boolean isBonemealSuccess(Level p_220878_, RandomSource p_220879_, BlockPos p_220880_, BlockState p_220881_) {
        return true;
    }
    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource rand, BlockPos pos, BlockState state) {
        int i = Math.min(3, state.getValue(AGE) + 1);
        serverLevel.setBlock(pos, state.setValue(AGE, Integer.valueOf(i)), 2);
    }
}
