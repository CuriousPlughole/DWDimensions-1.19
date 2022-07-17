package com.prismmods.dwdimensions.common.blockentities;

public enum DoorStatus {
    OPEN("open"), HALF_OPEN("half_open"), CLOSED("closed");

    private final String nbtName;

    DoorStatus(String nbtName) {
        this.nbtName = nbtName;
    }

    public String getNbtName() {
        return nbtName;
    }

    public static DoorStatus getDoorStatusValue(String nbtName){
        for (DoorStatus value : DoorStatus.values()) {
            if(value.getNbtName().equalsIgnoreCase(nbtName)){
                return value;
            }
        }
        return DoorStatus.CLOSED;
    }
}