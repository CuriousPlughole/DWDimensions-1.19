package com.prismmods.dwdimensions.common.blockentities.tardis;

public enum Chameleon {
    WHITTAKER("whittaker"), CAPALDI("capaldi"), SMITH_7B("smith_7b"), SMITH_SCORCHED("smith_scorched"),
    SMITH("smith"), TENNANT("tennant"), ECCLESTON("eccleston");

    private final String nbtName;

    Chameleon(String nbtName) {
        this.nbtName = nbtName;
    }
    public String getNbtName() {
        return nbtName;
    }
    public static Chameleon getChameleonValue(String nbtName){
        for (Chameleon value : Chameleon.values()) {
            if(value.getNbtName().equalsIgnoreCase(nbtName)){
                return value;
            }
        }
        return Chameleon.WHITTAKER;
    }

    public static Chameleon nextChameleon(Chameleon old) {
        int index = old.ordinal();
        int nextIndex = index+1;
        Chameleon[] chameleons = Chameleon.values();
        nextIndex %= chameleons.length;
        return chameleons[nextIndex];
    }

}
