package com.prismmods.dwdimensions.common.entity.custom.dalek;

import java.util.Random;

public enum DalekSpawnType {

    //FIXME: Rest need to be assigned!

    TIME_WAR(new String[]{"time_war","vault", "timewar_scientist_c", "timewar_scientist_b", "timewar_scientist_a", "assault"}),
    TIME_SQUAD(new String[]{"timewar_time_scientist", "time_squad_drone", "time_commander"}),
    AXIS_STRIKE(new String []{"axis_strike_a", "axis_strike_b", "buzz_saw"}),
    EMPEROR_GUARD(new String[]{"emperor_guard", "emperor_guard_2"}),
    WARRIOR(new String[]{"warrior_1979","warrior_1974","warrior_1972"});

    private final String[] variants;

    DalekSpawnType(String[] variants) {
        this.variants = variants;
    }

    public static String getRandomVariant(DalekSpawnType type) {
        int rnd = new Random().nextInt(type.variants.length);
        return type.variants[rnd];
    }

    public static String getCategoryName(DalekSpawnType type) {
        String name;
        switch(type) {
            case WARRIOR -> name = "warrior";
            case TIME_SQUAD -> name = "time_squad";
            case AXIS_STRIKE -> name = "axis_strike";
            case EMPEROR_GUARD -> name = "emperor_guard";
            default -> name = "time_war";
        }
        return name;
    }

    public static String getReadable(DalekSpawnType type) {
        String name;
        switch(type) {
            case WARRIOR -> name = "Warrior Dalek";
            case TIME_SQUAD -> name = "Time Squad Dalek";
            case AXIS_STRIKE -> name = "Axis Strike Dalek";
            case EMPEROR_GUARD -> name = "Emperor Guard Dalek";
            default -> name = "Time War Dalek";
        }
        return name;
    }

}
