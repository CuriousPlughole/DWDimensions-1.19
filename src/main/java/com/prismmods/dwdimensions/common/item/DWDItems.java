package com.prismmods.dwdimensions.common.item;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.DWDCreativeTabs;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DWDItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DWDimensions.MOD_ID);
    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }

    public static final RegistryObject<Item> ZEITON_7 = ITEMS.register("zeiton_7", () -> new Item(new Item.Properties().tab(DWDCreativeTabs.DWDMaterials)));
    public static final RegistryObject<Item> HANDMINE = ITEMS.register("handmine", () -> new Item(new Item.Properties().tab(DWDCreativeTabs.DWDSkaro)));
    public static final RegistryObject<Item> VARGA_BERRIES = ITEMS.register("varga_berries", () -> new ItemNameBlockItem(DWDBlocks.VARGA_BUSH.get(), (new Item.Properties().food(DWDEdibles.VARGA_BERRIES))));


}
