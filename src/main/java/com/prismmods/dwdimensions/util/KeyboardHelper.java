package com.prismmods.dwdimensions.util;

import com.mojang.blaze3d.platform.InputConstants;
import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.network.Network;
import com.prismmods.dwdimensions.network.messages.TardisDoorSnapMessage;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.controls.KeyBindsList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;
import javax.swing.text.JTextComponent;

@Mod.EventBusSubscriber(modid = DWDimensions.MOD_ID, value = Dist.CLIENT)
public class KeyboardHelper {

    public static KeyMapping tardisDoor = new KeyMapping("key.dwdimensions.tardis_door", GLFW.GLFW_KEY_P, "key.categories.dwdimensions");

    public static void tickKeybinds() {
        if(Minecraft.getInstance().level == null) return;
        if(tardisDoor.consumeClick()) {
            Network.sendToServer(new TardisDoorSnapMessage(Minecraft.getInstance().player.blockPosition()));
        }
    }


}
