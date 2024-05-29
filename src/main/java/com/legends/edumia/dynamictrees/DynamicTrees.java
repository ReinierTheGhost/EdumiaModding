package com.legends.edumia.dynamictrees;

public final class DynamicTrees {

    public static final String DYNAMIC_TREES = "dynamictrees";


    public enum AxeDamage {
        VANILLA,
        THICKNESS,
        VOLUME
    }

    public enum DestroyMode {
        IGNORE,
        SLOPPY,
        SET_RADIUS,
        HARVEST,
        ROT,
        OVERFLOW
    }

    public enum SwampOakWaterState {
        ROOTED,
        SUNK,
        DISABLED
    }

    public DynamicTrees() {

    }


}
