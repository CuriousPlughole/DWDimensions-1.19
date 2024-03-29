package com.prismmods.dwdimensions.common.item;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.DWDCreativeTabs;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.item.custom.*;
import com.prismmods.dwdimensions.common.item.custom.sonic.SonicScrewdriverItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DWDItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DWDimensions.MOD_ID);
    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }

    //Icons. May have some functionality in future, but using as just tab icons for now.
    public static final RegistryObject<Item> SKARO_DISK = ITEMS.register("skaro_disk", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DEVICES_ICON = ITEMS.register("devices_icon", () -> new Item(new Item.Properties()));

    //Items

    public static final RegistryObject<Item> SPACE_SUIT_HELMET = ITEMS.register("space_suit_helmet", () -> new ClothingItem(ArmorMaterials.LEATHER, EquipmentSlot.HEAD, new Item.Properties().tab(DWDCreativeTabs.DWDWIPTab)));
    public static final RegistryObject<Item> SPACE_SUIT = ITEMS.register("space_suit", () -> new ClothingItem(ArmorMaterials.LEATHER, EquipmentSlot.CHEST, new Item.Properties().tab(DWDCreativeTabs.DWDWIPTab)));
    public static final RegistryObject<Item> SPACE_SUIT_BOTTOM = ITEMS.register("space_suit_bottom", () -> new ClothingItem(ArmorMaterials.LEATHER, EquipmentSlot.LEGS, new Item.Properties().tab(DWDCreativeTabs.DWDWIPTab)));
    public static final RegistryObject<Item> GRAVITY_BOOTS = ITEMS.register("gravity_boots", () -> new ClothingItem(ArmorMaterials.IRON, EquipmentSlot.FEET, new Item.Properties().tab(DWDCreativeTabs.DWDWIPTab)));

    public static final RegistryObject<Item> ZEITON_7 = ITEMS.register("zeiton_7", () -> new Item(new Item.Properties().tab(DWDCreativeTabs.DWDMaterialsTab)));
    public static final RegistryObject<Item> RAW_DALEKANIUM = ITEMS.register("raw_dalekanium", () -> new Item(new Item.Properties().tab(DWDCreativeTabs.DWDMaterialsTab)));
    public static final RegistryObject<Item> DALEKANIUM_INGOT = ITEMS.register("dalekanium_ingot", () -> new Item(new Item.Properties().tab(DWDCreativeTabs.DWDMaterialsTab)));

    public static final RegistryObject<Item> RAW_URANIUM = ITEMS.register("raw_uranium", () -> new Item(new Item.Properties().tab(DWDCreativeTabs.DWDMaterialsTab)));
    public static final RegistryObject<Item> REFINED_URANIUM = ITEMS.register("refined_uranium", () -> new Item(new Item.Properties().tab(DWDCreativeTabs.DWDMaterialsTab)));

    public static final RegistryObject<Item> HANDMINE = ITEMS.register("handmine", () -> new Item(new Item.Properties().tab(DWDCreativeTabs.DWDSkaro)));
    public static final RegistryObject<Item> VARGA_BERRIES = ITEMS.register("varga_berries", () -> new ItemNameBlockItem(DWDBlocks.VARGA_BUSH.get(), (new Item.Properties().food(DWDEdibles.VARGA_BERRIES))));
    public static final RegistryObject<Item> PETRIFIED_PLANK_SIGN = ITEMS.register("petrified_plank_sign", ()-> new SignItem(new Item.Properties().tab(DWDCreativeTabs.DWDSkaro).stacksTo(16), DWDBlocks.PETRIFIED_PLANK_SIGN.get(), DWDBlocks.PETRIFIED_PLANK_WALL_SIGN.get()));
    public static final RegistryObject<Item> PETRIFIED_JUNGLE_PLANK_SIGN = ITEMS.register("petrified_jungle_plank_sign", ()-> new SignItem(new Item.Properties().tab(DWDCreativeTabs.DWDSkaro).stacksTo(16), DWDBlocks.PETRIFIED_JUNGLE_PLANK_SIGN.get(), DWDBlocks.PETRIFIED_JUNGLE_PLANK_WALL_SIGN.get()));
    public static final RegistryObject<Item> SONIC_SCREWDRIVER = ITEMS.register("sonic_screwdriver", () -> new SonicScrewdriverItem(new Item.Properties().tab(DWDCreativeTabs.DWDWIPTab)));
    public static final RegistryObject<Item> ANTI_RADIATION_PILL = ITEMS.register("anti_radiation_pill", () -> new AntiRadiationPillItem(new Item.Properties().tab(DWDCreativeTabs.DWDWIPTab)));
    public static final RegistryObject<Item> DALEK_SPAWN_EGG = ITEMS.register("dalek_spawn_egg", () -> new DalekSpawnerItem(new Item.Properties().tab(DWDCreativeTabs.DWDSpawnEggs)));
    public static final RegistryObject<Item> DALEK_GUNSTICK = ITEMS.register("dalek_gunstick", () -> new DalekGunstick(new Item.Properties().tab(DWDCreativeTabs.DWDWIPTab)));

    //Temporary functionality. For dev purposes
    public static final RegistryObject<Item> STATTENHEIM_REMOTE = ITEMS.register("stattenheim_remote", () -> new StattenheimRemoteItem(new Item.Properties().stacksTo(1).tab(DWDCreativeTabs.DWDWIPTab)));
    public static final RegistryObject<Item> ROCKET_LAUNCHER = ITEMS.register("rocket_launcher", () -> new RocketLauncher(new Item.Properties().stacksTo(1)));


}
