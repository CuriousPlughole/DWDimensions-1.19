package com.prismmods.dwdimensions.common.capability.radiation;

import net.minecraft.nbt.CompoundTag;

public class RadiationCapability {

    private int radiation;
    private static final int max_radiation = 21;
    private final int min_radiation = 0;

    public int getRadiation() {
        return radiation;
    }

    //For now this will be just 21. In future pass entities into this method etc for the maximum radiation that entity can take;
    // ie larger mob can suffer more radiation than a small mob
    public static int getMaxRadiation() {
        return max_radiation;
    }

    public void addRadiation(int i) {
        this.radiation = Math.min(radiation + i, max_radiation);
    }

    public void subRadiation(int i) {
        this.radiation = Math.max(radiation - i, min_radiation);
    }

    public void copyFrom(RadiationCapability source) {
        this.radiation = source.radiation;
    }

    public void saveData(CompoundTag nbt) {
        nbt.putInt("radiation", radiation);
    }

    public void loadData(CompoundTag nbt) {
        radiation = nbt.getInt("radiation");
    }


}
