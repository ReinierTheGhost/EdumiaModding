package com.legends.edumia.block.util;

import net.minecraft.item.AutomaticItemPlacementContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class PlacementHelper {

    public PlacementHelper() {
    }

    public static boolean replacingClickedOnBlock(ItemPlacementContext context) {
        return context instanceof AutomaticItemPlacementContext ? false : context.canReplaceExisting();
    }

    public static Direction getHitVecHorizontalAxisDirection(Direction facing, BlockPos pos, ItemPlacementContext context) {
        switch (facing) {
            case NORTH:
                return !(context.getHitPos().x - (double)pos.getX() > 0.5) ? facing.rotateYCounterclockwise() : facing;
            case SOUTH:
                return !(context.getHitPos().x - (double)pos.getX() < 0.5) ? facing.rotateYCounterclockwise() : facing;
            case EAST:
                return !(context.getHitPos().z - (double)pos.getZ() > 0.5) ? facing.rotateYCounterclockwise() : facing;
            default:
                return !(context.getHitPos().z - (double)pos.getZ() < 0.5) ? facing.rotateYCounterclockwise() : facing;
        }
    }
}
