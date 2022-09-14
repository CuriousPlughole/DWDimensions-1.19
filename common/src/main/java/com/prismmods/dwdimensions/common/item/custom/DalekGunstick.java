package com.prismmods.dwdimensions.common.item.custom;

import com.prismmods.dwdimensions.common.entity.DWDEntityTypes;
import com.prismmods.dwdimensions.common.entity.custom.projectile.DalekLaser;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;


public class DalekGunstick extends Item {

    public static final int MAX_DRAW_DURATION = 10;
    public static final int DEFAULT_RANGE = 15;

    public DalekGunstick(Properties properties) {
        super(properties.stacksTo(1));
    }

    public static float getPowerForTime(int ticks) {
        float f = (float) ticks / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }
        return f;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        if (!(entity instanceof Player)) return;
        Player player = (Player) entity;

        int ticksSpentChargingUp = this.getUseDuration(stack) - timeLeft;

        float f = getPowerForTime(ticksSpentChargingUp);

        ItemStack heldItem = stack;

        if (!level.isClientSide) {
            DalekLaser laserEntity = new DalekLaser(level, entity);
            //laserEntity.setPos(entity.position()); //TODO: maybe remove this
            laserEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, 1.0F);
            level.addFreshEntity(laserEntity);
        }

        level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (entity.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.isCreative()) {
            heldItem.hurtAndBreak(1, player, (i) -> {
                i.broadcastBreakEvent(player.getUsedItemHand()); //Change this to prevent breaking in future. Charge with energy
            });
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public int getUseDuration(ItemStack p_41454_) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.BOW;
    }


}
