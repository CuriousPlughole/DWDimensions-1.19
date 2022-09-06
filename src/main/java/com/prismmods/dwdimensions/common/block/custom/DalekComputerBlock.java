package com.prismmods.dwdimensions.common.block.custom;

import com.prismmods.dwdimensions.common.blockentities.DalekComputerBlockEntity;
import com.prismmods.dwdimensions.common.item.DWDItems;
import com.prismmods.dwdimensions.common.item.custom.StattenheimRemoteItem;
import com.prismmods.dwdimensions.common.item.custom.sonic.SonicScrewdriverItem;
import com.prismmods.dwdimensions.common.sound.DWDSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class DalekComputerBlock extends BaseEntityBlock {

    public static final BooleanProperty ALARMING = BlockStateProperties.LIT;
    public static final BooleanProperty IN_USE = BlockStateProperties.OCCUPIED;
    public static final BooleanProperty DISABLED = BlockStateProperties.DISARMED;

    public DalekComputerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ALARMING);
        builder.add(IN_USE);
        builder.add(DISABLED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context)
                .setValue(ALARMING, false)
                .setValue(IN_USE, false)
                .setValue(DISABLED, false);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof DalekComputerBlockEntity computerBlockEntity) {

                Boolean isAlarmDisabled = computerBlockEntity.isAlarmDisabled();
                Boolean isAlarming = computerBlockEntity.isAlarming();

                if(player.getItemInHand(hand).is(DWDItems.SONIC_SCREWDRIVER.get())) {
                    ItemStack itemStack = player.getItemInHand(hand);
                    SonicScrewdriverItem screwdriver = (SonicScrewdriverItem)itemStack.getItem();
                    SonicScrewdriverItem.Setting mode = screwdriver.getMode(itemStack);

                    //If sonic is in block mode, deactivate the computer alarm system, if it's not already been triggered
                    if(mode == SonicScrewdriverItem.Setting.BLOCK && !player.isCrouching()) {
                        if(!isAlarming) {
                            level.playSound(null, blockPos,
                                    SonicScrewdriverItem.getSoundForModel(SonicScrewdriverItem.getScrewdriverModel(itemStack), SonicScrewdriverItem.Action.USE),
                                    SoundSource.PLAYERS, 1.0f, 1.0f);
                            computerBlockEntity.disableAlarmableFor(600); //Alarm not triggerable for 30 seconds
                            isAlarmDisabled = true;

                        }
                    } else {
                        //If the sonic is in the wrong mode, the alarm should trigger
                        computerBlockEntity.setAlarming(true);
                        isAlarming = true;
                        isAlarmDisabled = false;
                    }
                } else {
                    //If the computer is activated by hand or anything else, we want to trigger the alarm if it isnt disabled & already alarming
                    if (!isAlarmDisabled && !isAlarming) {
                        computerBlockEntity.setAlarming(true);
                        isAlarming = true;
                        isAlarmDisabled = false;
                    } else {
                        //TODO: In future have this open a GUI or give coordinates of dalek city or something
                        if(!isAlarming) {
                            System.out.println("Computer accessed!");
                            computerBlockEntity.setAlarming(false);
                            isAlarming = false;
                            isAlarmDisabled = true;
                        }
                    }
                    //No action to be taken if the system is already alarming
                }

                computerBlockEntity.sendUpdates();
                //System.out.println("ALARMING:" + isAlarming+ " DISABLED: " + isAlarmDisabled);
                BlockState newState = blockState.setValue(ALARMING, isAlarming).setValue(DISABLED, isAlarmDisabled).setValue(IN_USE, false);
                //level.sendBlockUpdated(blockPos, blockState, blockState, 3);
                level.setBlockAndUpdate(blockPos, newState);
                return InteractionResult.CONSUME;
            } else {
                return InteractionResult.FAIL;
            }
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DalekComputerBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return (level1, blockPos, blockState, t) -> {
            if(t instanceof DalekComputerBlockEntity computerBlockEntity) {
                computerBlockEntity.tick(level, blockPos, blockState, computerBlockEntity);
            }
        };
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
        if(rand.nextInt(100) == 0) {
            level.playLocalSound(pos.getX()+0.5, pos.getY()+0.5, pos.getZ()+0.5, DWDSounds.DALEK_AMBIENT_HUM.get(), SoundSource.BLOCKS, 2.0f, 1.0f, false);
        }
    }
}
