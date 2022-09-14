package com.prismmods.dwdimensions.network.messages;

import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.blockentities.tardis.DoorStatus;
import com.prismmods.dwdimensions.common.blockentities.tardis.TardisBlockEntity;
import com.prismmods.dwdimensions.common.sound.DWDSounds;
import com.prismmods.dwdimensions.util.ClientUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class RadiationDataMessage {
    private int radiation;
    public RadiationDataMessage(int rad) {
        this.radiation = rad;
    }

    public static RadiationDataMessage decode(FriendlyByteBuf buffer) {
        return new RadiationDataMessage(buffer.readInt());
    }

    public static void encode(RadiationDataMessage message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.radiation);
    }

    public static class Handler {
        public static void handle(RadiationDataMessage message, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ClientUtil.RadiationData.set(message.radiation);
            });
            ctx.get().setPacketHandled(true);
        }
    }
}
