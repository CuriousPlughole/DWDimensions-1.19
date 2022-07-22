package com.prismmods.dwdimensions.network;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.network.messages.TardisDoorSnapMessage;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.server.ServerLifecycleHooks;

public class Network {

    private static final String protocol_version = Integer.toString(1);
    public static final SimpleChannel networkChannel = NetworkRegistry.newSimpleChannel(new ResourceLocation(DWDimensions.MOD_ID + "main_channel"), () -> protocol_version, protocol_version::equals, protocol_version::equals);
    public static int ID = 0;

    private static int nextID() {
        return ID++;
    }

    public static void registerMessages() {
        networkChannel.messageBuilder(TardisDoorSnapMessage.class, nextID(), NetworkDirection.PLAY_TO_SERVER)
                .encoder(TardisDoorSnapMessage::encode)
                .decoder(TardisDoorSnapMessage::decode)
                .consumer(TardisDoorSnapMessage.Handler::handle).add();
    }

    //Send packet to server. Called client side
    public static void sendToServer(Object packet) {
        networkChannel.sendToServer(packet);
    }

    //Send packet to a specific player. Called server side.
    public static void sendToClient(Object packet, ServerPlayer player) {
        if(!(player instanceof FakePlayer)) {
            networkChannel.sendTo(packet, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
        }
    }

    //Send packet to all players
    public static void sendToAll(Object packet) {
        for (ServerPlayer player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers()) {
            sendToClient(packet, player);
        }
    }

}
