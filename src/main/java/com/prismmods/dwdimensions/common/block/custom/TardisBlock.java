package com.prismmods.dwdimensions.common.block.custom;

import com.prismmods.dwdimensions.common.blockentities.tardis.Chameleon;
import com.prismmods.dwdimensions.common.blockentities.tardis.DoorStatus;
import com.prismmods.dwdimensions.common.blockentities.tardis.TardisBlockEntity;
import com.prismmods.dwdimensions.common.item.DWDItems;
import com.prismmods.dwdimensions.common.item.custom.StattenheimRemoteItem;
import com.prismmods.dwdimensions.common.sound.DWDSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class TardisBlock extends BaseEntityBlock {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private static final VoxelShape block_shape = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 32.0D, 16.0D);

    public TardisBlock(Properties properties) {
        super(properties.noCollission());
    }

    @Override
    public VoxelShape getCollisionShape(BlockState blockState, BlockGetter getter, BlockPos pos, CollisionContext context) {
        BlockEntity tileentity = getter.getBlockEntity(pos);
        if (tileentity instanceof TardisBlockEntity tardisTileEntity) {
            if (tardisTileEntity.getDoorState() == DoorStatus.CLOSED) {
                return block_shape;
            } else {
                return Block.box(0,0,0,0,0,0);
            }
        }
        return block_shape;
    }

    @Override
    public boolean collisionExtendsVertically(BlockState state, BlockGetter level, BlockPos pos, Entity collidingEntity) {
        return true;
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(level.isClientSide) {
            return InteractionResult.SUCCESS;
        }  else {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof TardisBlockEntity tardisBlockEntity) {
                SoundEvent doorSound;
                DoorStatus doorState = tardisBlockEntity.getDoorState();
                Boolean lightsOn = tardisBlockEntity.getLightState();
                Chameleon chameleon = tardisBlockEntity.getChameleon();

                if(player.getItemInHand(hand).isEmpty()) {
                    if (doorState == DoorStatus.CLOSED) {
                        if (player.isCrouching()) {
                            doorState = DoorStatus.OPEN;
                            doorSound = DWDSounds.TARDIS_DOOR_OPEN_1.get();
                        } else {
                            doorState = DoorStatus.HALF_OPEN;
                            doorSound = DWDSounds.TARDIS_DOOR_OPEN_2.get();
                        }
                    } else {
                        doorState = DoorStatus.CLOSED;
                        doorSound = DWDSounds.TARDIS_DOOR_CLOSE.get();
                    }

                    tardisBlockEntity.setDoorState(doorState);
                    level.playSound(null, blockPos, doorSound, SoundSource.BLOCKS, 0.5f, 1.0f);
                }

                if(player.getItemInHand(hand).is(DWDItems.STATTENHEIM_REMOTE.get())) {
                    ItemStack itemStack = player.getItemInHand(hand);
                    StattenheimRemoteItem remoteItem = (StattenheimRemoteItem)itemStack.getItem();
                    StattenheimRemoteItem.Mode mode = remoteItem.getMode(itemStack);

                    if(mode == StattenheimRemoteItem.Mode.CHAMELEON) {
                        tardisBlockEntity.setChameleon(Chameleon.nextChameleon(chameleon));
                    }

                    if(mode == StattenheimRemoteItem.Mode.LIGHTS) {
                        Boolean newLightsState = (lightsOn) ? false : true;
                        tardisBlockEntity.setLightState(newLightsState);
                    }
                }
                tardisBlockEntity.sendUpdates();
                level.sendBlockUpdated(blockPos, blockState, blockState, 2);
                return InteractionResult.CONSUME;
            } else {
                return InteractionResult.FAIL;
            }
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
        builder.add(FACING);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.INVISIBLE;
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
        return super.rotate(state, level, pos, direction);
    }

    @Override
    public boolean addLandingEffects(BlockState state1, ServerLevel level, BlockPos pos, BlockState state2, LivingEntity entity, int numberOfParticles) {
        return false;
    }

    @Override
    public boolean addRunningEffects(BlockState state, Level level, BlockPos pos, Entity entity) {
        return false;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(LIT) ? 7:0;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TardisBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return (level1, blockPos, blockState, t) -> {
            if(t instanceof TardisBlockEntity tardisBlockEntity) {
                tardisBlockEntity.tick(level, blockPos, blockState, tardisBlockEntity);
            }
        };
    }
}
