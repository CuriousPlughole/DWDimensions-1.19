package com.prismmods.dwdimensions.world.feature.tree.decorator;

import com.prismmods.dwdimensions.DWDimensions;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DWDTreeDecorators {

    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, DWDimensions.MOD_ID);

    //FIXME: Fix this
    //public static final RegistryObject<TreeDecoratorType<CustomVineTrunkDecorator>> VINE_TRUNK_DECORATOR = TREE_DECORATORS.register("custom_vine_trunk_decorator", new TreeDecoratorType<>(CustomVineTrunkDecorator.CODEC));

    public static void register(IEventBus bus) {
        TREE_DECORATORS.register(bus);
    }

}
