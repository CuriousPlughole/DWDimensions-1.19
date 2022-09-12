package com.prismmods.dwdimensions.common.item.custom;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.client.renders.entity.armor.ClothingItemRenderer;
import com.prismmods.dwdimensions.common.item.DWDItems;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class ClothingItem extends ArmorItem {
    public ClothingItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {

        //FIXME: May need access transformers to see AbstractClientPlayer playerInfo to check steve/alex model for arm size
       /*
        if(entity instanceof AbstractClientPlayer player) {

        }
        String armSize = "";
        if(slot == EquipmentSlot.CHEST) {

        }*/
        if(ForgeRegistries.ITEMS.getKey(stack.getItem()).getPath() == "space_suit_helmet" || ForgeRegistries.ITEMS.getKey(stack.getItem()).getPath() == "space_suit_bottom") {
            return (DWDimensions.MOD_ID+ ":textures/entity/armor/space_suit.png");
        }

        return (DWDimensions.MOD_ID+ ":textures/entity/armor/"+ ForgeRegistries.ITEMS.getKey(stack.getItem()).getPath()+".png");
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new ClothingItemRenderer());
    }
}
