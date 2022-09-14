package com.prismmods.dwdimensions.event;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.api.RadiationHandler;
import com.prismmods.dwdimensions.common.capability.radiation.RadiationCapability;
import com.prismmods.dwdimensions.common.capability.radiation.RadiationCapabilityProvider;
import com.prismmods.dwdimensions.common.entity.custom.dalek.DalekEntity;
import com.prismmods.dwdimensions.common.entity.effect.DWDEffectRegistry;
import com.prismmods.dwdimensions.common.entity.villager.DWDVillagers;
import com.prismmods.dwdimensions.common.item.DWDItems;
import com.prismmods.dwdimensions.common.sound.DWDSounds;
import com.prismmods.dwdimensions.network.Network;
import com.prismmods.dwdimensions.network.messages.RadiationDataMessage;
import com.prismmods.dwdimensions.util.DWDTags;
import com.prismmods.dwdimensions.world.dimension.DWDDimensionReg;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = DWDimensions.MOD_ID)
public class DWDEvents {

    /**
     * VILLAGERS
     */

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == DWDVillagers.RADIOTHERAPIST.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(DWDItems.ANTI_RADIATION_PILL.get(), 16);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2), //cost
                    stack,10,8,0.02F)); //Max uses, villager xp, multiplier for price
        }
    }

    /**
     * Other
     */
    @SubscribeEvent
    public static void onDeath(LivingHurtEvent event) {
        if(event.getEntity() instanceof DalekEntity) {
            DalekEntity dalek = (DalekEntity) event.getEntity();
            if(dalek.getHealth() - event.getAmount() <=0 && dalek.getSpecialState() != 0.5f) {

                dalek.playSound(DWDSounds.DALEK_EMERGENCY.get());

                event.setCanceled(true);
                event.setAmount(0);
                dalek.setHealth(0.5f);
                dalek.setSpecialState(0.5f);
                dalek.setSpeed(0.0f);
                dalek.removeFreeWill();
            }
        }
    }

    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinLevelEvent event) {
        if(!event.getLevel().isClientSide()) {
            //Attempt to reduce sound spam. More stuff probably needed
            if(event.getEntity() instanceof DalekEntity) {
                int nearbyDaleks = event.getLevel().getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT, (DalekEntity)event.getEntity(), event.getEntity().getBoundingBox().inflate(20.0d, 8.0d, 20.0d)).size();
                if(nearbyDaleks > 6) {
                    event.getEntity().setSilent(true);
                }
            }
        }
    }

}
