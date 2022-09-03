package com.prismmods.dwdimensions.common.blockentities;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.blockentities.sign.DWDSignBlockEntity;
import com.prismmods.dwdimensions.common.blockentities.tardis.TardisBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DWDBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DWDimensions.MOD_ID);

    public static final RegistryObject<BlockEntityType<TardisBlockEntity>> TARDIS = BLOCK_ENTITIES.register("tardis",
            () -> registerBlockEntity(TardisBlockEntity::new, DWDBlocks.TARDIS.get()));

    public static final RegistryObject<BlockEntityType<DalekComputerBlockEntity>> DALEK_WALL_COMPUTER = BLOCK_ENTITIES.register("dalek_wall_computer",
            () -> registerBlockEntity(DalekComputerBlockEntity::new, DWDBlocks.DALEK_WALL_COMPUTER.get()));

    public static final RegistryObject<BlockEntityType<DWDSignBlockEntity>> SIGN_BLOCK_ENTITIES = BLOCK_ENTITIES.register("sign_block_entity",
            () -> BlockEntityType.Builder.of(DWDSignBlockEntity::new, DWDBlocks.PETRIFIED_PLANK_WALL_SIGN.get(), DWDBlocks.PETRIFIED_PLANK_SIGN.get(),
                    DWDBlocks.PETRIFIED_JUNGLE_PLANK_WALL_SIGN.get(), DWDBlocks.PETRIFIED_JUNGLE_PLANK_SIGN.get()).build(null));


    /*
    REGISTRY
     */
    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(BlockEntityType.BlockEntitySupplier<T> blockEntity, Block validBlock) {
        return BlockEntityType.Builder.of(blockEntity, validBlock).build(null);
    }
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
