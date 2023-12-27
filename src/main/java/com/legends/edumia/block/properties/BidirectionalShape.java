package com.legends.edumia.block.properties;

import net.minecraft.util.StringIdentifiable;

public enum BidirectionalShape implements StringIdentifiable {
    NORTH_SOUTH("northsouth"),
    EAST_WEST("eastwest");

    private final String name;

    BidirectionalShape(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String asString() {
        return this.name;
    }
}
