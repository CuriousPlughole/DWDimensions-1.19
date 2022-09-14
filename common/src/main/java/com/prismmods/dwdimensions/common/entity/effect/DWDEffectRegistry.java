package com.prismmods.dwdimensions.common.entity.effect;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.DWDCreativeTabs;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DWDEffectRegistry {

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DWDimensions.MOD_ID);
    public static void register(IEventBus eventbus) { EFFECTS.register(eventbus);}

    public static final RegistryObject<MobEffect> RADIATION_SICKNESS = EFFECTS.register("radiation_sickness",
            () -> new DWDEffect(MobEffectCategory.HARMFUL, 13209599).addAttributeModifier(Attributes.MAX_HEALTH,
                    "87138eb6-64ab-11eb-ae93-0242ac130002", 0.0D, AttributeModifier.Operation.ADDITION));

    public static final RegistryObject<MobEffect> RADIOACTIVE = EFFECTS.register("radioactive",
            () -> new DWDEffect(MobEffectCategory.HARMFUL, 1880661).addAttributeModifier(Attributes.MAX_HEALTH,
                    "b2284b14-99ee-11eb-a8b3-0242ac130003", -1.0D, AttributeModifier.Operation.ADDITION));

}
