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

}
