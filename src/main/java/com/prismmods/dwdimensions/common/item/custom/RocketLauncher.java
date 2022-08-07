package com.prismmods.dwdimensions.common.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class RocketLauncher extends Item {
    public RocketLauncher(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        PrimedTnt tnt = new PrimedTnt(level, player.xo, player.yo, player.zo, player);
        Vec3 lookAt = player.getLookAngle();
        tnt.setDeltaMovement(lookAt.multiply(5,5,5));
        tnt.setFuse(30);

        level.addFreshEntity(tnt);


        return super.use(level, player, hand);
    }
}
