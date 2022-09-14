package com.prismmods.dwdimensions.network.messages;

import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.block.custom.TardisBlock;
import com.prismmods.dwdimensions.common.blockentities.tardis.DoorStatus;
import com.prismmods.dwdimensions.common.blockentities.tardis.TardisBlockEntity;
import com.prismmods.dwdimensions.common.sound.DWDSounds;
import com.prismmods.dwdimensions.network.Network;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class TardisDoorSnapMessage {

    private BlockPos blockPos;

    public TardisDoorSnapMessage(BlockPos pos) {
        this.blockPos = pos;
    }

    public static TardisDoorSnapMessage decode(FriendlyByteBuf buffer) {
        return new TardisDoorSnapMessage(buffer.readBlockPos());
    }

    public static void encode(TardisDoorSnapMessage message, FriendlyByteBuf buffer) {
        buffer.writeBlockPos(message.blockPos);
    }

    public static class Handler {
        public static void handle(TardisDoorSnapMessage message, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ServerPlayer sender = ctx.get().getSender();
                if(!sender.isCrouching()) {
                    Level level = sender.getLevel();
                    sender.swing(InteractionHand.MAIN_HAND, true);
                    //If the player is within an area of 4 blocks either side of the tardis, or 3 blocks above or below
                    for(int x = -5; x < 5; x++) {
                        for(int z = -5; z < 5; z++) {
                            for(int y = -3; y < 5; y++) {
                                BlockPos checkingPos = message.blockPos.offset(x,y,z);
                                if(level.getBlockState(checkingPos).getBlock().equals(DWDBlocks.TARDIS.get())) {
                                    BlockEntity blockEntity = level.getBlockEntity(checkingPos);
                                    if(blockEntity instanceof TardisBlockEntity) {

                                        TardisBlockEntity tardisBlockEntity = (TardisBlockEntity) blockEntity;
                                        //Add owner checks from tardis ID etc here
                                        SoundEvent doorSound;

                                        if (tardisBlockEntity.getDoorState() == DoorStatus.CLOSED) {
                                            tardisBlockEntity.setDoorState(DoorStatus.OPEN);
                                            doorSound = DWDSounds.TARDIS_DOOR_OPEN_SQUEAKY.get();
                                        } else {
                                            tardisBlockEntity.setDoorState(DoorStatus.CLOSED);
                                            doorSound = DWDSounds.TARDIS_DOOR_CLOSE_SQUEAKY.get();
                                        }

                                        level.playSound(null, message.blockPos, DWDSounds.FINGER_SNAP.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
                                        level.playSound(null, checkingPos, doorSound, SoundSource.BLOCKS, 1.0f, 1.0f);
                                        level.sendBlockUpdated(checkingPos, level.getBlockState(checkingPos), level.getBlockState(checkingPos), 2);

                                    }
                                    break;
                                }
                            }

                        }
                    }
                }

            });
            ctx.get().setPacketHandled(true);
        }
    }
}
