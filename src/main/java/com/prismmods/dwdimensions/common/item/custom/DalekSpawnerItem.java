package com.prismmods.dwdimensions.common.item.custom;

import com.prismmods.dwdimensions.common.entity.DWDEntityTypes;
import com.prismmods.dwdimensions.common.entity.custom.dalek.DalekEntity;
import com.prismmods.dwdimensions.common.entity.custom.dalek.DalekSpawnType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class DalekSpawnerItem extends Item {
    public DalekSpawnerItem(Properties properties) {
        super(properties);
    }

    public static ItemStack setDalekType(ItemStack stack, DalekSpawnType type) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putString("type", type.name());
        return stack;
    }

    public static DalekSpawnType getDalekType(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        String dalekType = tag.getString("type");
        dalekType = dalekType.isEmpty() ? DalekSpawnType.TIME_WAR.name() : dalekType;
        return DalekSpawnType.valueOf(dalekType);
    }

    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> items) {
        if(allowedIn(tab)) {
            for (DalekSpawnType type : DalekSpawnType.values()) {
                ItemStack stack = new ItemStack(this);
                setDalekType(stack, type);
                items.add(stack);
            }
        }
    }

    /*@Override
    public @NotNull Component getName(@NotNull ItemStack stack) {
        return Component.translatable(this.getDescriptionId(stack), getDalekType(stack).getReadable());
    }*/
    //Make name mapper and use this for json predicates

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();

        if(!level.isClientSide) {
            DalekEntity dalek = new DalekEntity(DWDEntityTypes.DALEK.get(), level);

            dalek.setPos(pos.getX() + 0.5, pos.getY()+ 1, pos.getZ() + 0.5);
            level.addFreshEntity(dalek);
            dalek.setDalekType(DalekSpawnType.getRandomVariant(getDalekType(context.getItemInHand())));

            if(!player.isCreative()) {
                context.getItemInHand().shrink(1);
            }
        }
        return super.useOn(context);
    }
}
