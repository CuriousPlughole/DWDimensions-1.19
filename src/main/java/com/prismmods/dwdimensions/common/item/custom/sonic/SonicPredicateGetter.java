package com.prismmods.dwdimensions.common.item.custom.sonic;

public class SonicPredicateGetter {

    public static int getModelPredicate(SonicScrewdriverItem.ScrewdriverModel model) {
        int predicate;
        switch (model) {
            case CAPALDI -> predicate = 0;
            case WHITTAKER -> predicate = 1;
            default -> predicate = 0;
        }
        return predicate;
    }

    public static int getSettingPredicate(SonicScrewdriverItem.Setting setting) {
        int predicate;
        switch (setting) {
            case BLOCK -> predicate = 0;
            case ENTITY -> predicate = 1;
            default -> predicate = 0;
        }
        return predicate;
    }

}
