package com.prismmods.dwdimensions.common.item;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.DWDCreativeTabs;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.item.custom.AntiRadiationPillItem;
import com.prismmods.dwdimensions.common.item.custom.RocketLauncher;
import com.prismmods.dwdimensions.common.item.custom.SonicScrewdriverItem;
import com.prismmods.dwdimensions.common.item.custom.StattenheimRemoteItem;
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
    public static final RegistryObject<Item> ZEITON_7 = ITEMS.register("zeiton_7", () -> new Item(new Item.Properties().tab(DWDCreativeTabs.DWDWIPTab)));
    public static final RegistryObject<Item> HANDMINE = ITEMS.register("handmine", () -> new Item(new Item.Properties().tab(DWDCreativeTabs.DWDSkaro)));
    public static final RegistryObject<Item> VARGA_BERRIES = ITEMS.register("varga_berries", () -> new ItemNameBlockItem(DWDBlocks.VARGA_BUSH.get(), (new Item.Properties().food(DWDEdibles.VARGA_BERRIES))));
    public static final RegistryObject<Item> PETRIFIED_PLANK_SIGN = ITEMS.register("petrified_plank_sign", ()-> new SignItem(new Item.Properties().tab(DWDCreativeTabs.DWDSkaro).stacksTo(16), DWDBlocks.PETRIFIED_PLANK_SIGN.get(), DWDBlocks.PETRIFIED_PLANK_WALL_SIGN.get()));
    public static final RegistryObject<Item> PETRIFIED_JUNGLE_PLANK_SIGN = ITEMS.register("petrified_jungle_plank_sign", ()-> new SignItem(new Item.Properties().tab(DWDCreativeTabs.DWDSkaro).stacksTo(16), DWDBlocks.PETRIFIED_JUNGLE_PLANK_SIGN.get(), DWDBlocks.PETRIFIED_JUNGLE_PLANK_WALL_SIGN.get()));
    public static final RegistryObject<Item> SONIC_SCREWDRIVER = ITEMS.register("sonic_screwdriver", () -> new SonicScrewdriverItem(new Item.Properties()));
    public static final RegistryObject<Item> ANTI_RADIATION_PILL = ITEMS.register("anti_radiation_pill", () -> new AntiRadiationPillItem(new Item.Properties().tab(DWDCreativeTabs.DWDWIPTab)));

    //Temporary functionality. For dev purposes
    public static final RegistryObject<Item> STATTENHEIM_REMOTE = ITEMS.register("stattenheim_remote", () -> new StattenheimRemoteItem(new Item.Properties().stacksTo(1).tab(DWDCreativeTabs.DWDWIPTab)));
    public static final RegistryObject<Item> ROCKET_LAUNCHER = ITEMS.register("rocket_launcher", () -> new RocketLauncher(new Item.Properties().stacksTo(1)));


}
