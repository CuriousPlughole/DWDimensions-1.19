package com.prismmods.dwdimensions.common.capability.radiation;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RadiationCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static Capability<RadiationCapability> LIVING_ENTITY_RADIATION = CapabilityManager.get(new CapabilityToken<RadiationCapability>(){});

    private RadiationCapability radiation = null;
    private final LazyOptional<RadiationCapability> optional = LazyOptional.of(this::createLivingEntityRadiation);

    private RadiationCapability createLivingEntityRadiation() {
        if(this.radiation == null) {
            this.radiation = new RadiationCapability();
        }
        return this.radiation;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == LIVING_ENTITY_RADIATION) {
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createLivingEntityRadiation().saveData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createLivingEntityRadiation().loadData(nbt);
    }
}
