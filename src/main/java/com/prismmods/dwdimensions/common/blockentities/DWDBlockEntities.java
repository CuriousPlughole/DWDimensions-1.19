package com.prismmods.dwdimensions.common.blockentities;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DWDBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, DWDimensions.MOD_ID);

    public static final RegistryObject<BlockEntityType<TardisBlockEntity>> TARDIS = BLOCK_ENTITIES.register("tardis",
            () -> registerBlockEntity(TardisBlockEntity::new, DWDBlocks.TARDIS.get()));

    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(BlockEntityType.BlockEntitySupplier<T> blockEntity, Block validBlock) {
        return BlockEntityType.Builder.of(blockEntity, validBlock).build(null);

    }

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
