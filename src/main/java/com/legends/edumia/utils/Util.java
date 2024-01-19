package com.legends.edumia.utils;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class Util {

    // Returns the axis that a rotatable block should face based on a start and end position
    public static Direction.Axis getAxisBetween(BlockPos start, BlockPos end) {
        Direction.Axis axis = Direction.Axis.Y;
        int xOffset = Math.abs(end.getX() - start.getX());
        int zOffset = Math.abs(end.getZ() - start.getZ());
        int maxOffset = Math.max(xOffset, zOffset);

        if (maxOffset > 0) {
            if (xOffset == maxOffset) {
                axis = Direction.Axis.X;
            } else {
                axis = Direction.Axis.Z;
            }
        }

        return axis;
    }
}
