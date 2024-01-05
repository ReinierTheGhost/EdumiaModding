package com.legends.edumia.utils;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class EdumiaUtil {
    public static boolean hasSolidSide(BlockView world, BlockPos pos, Direction side) {
        BlockState state = world.getBlockState(pos);
        return Block.isFaceFullSquare(state.getSidesShape(world, pos), side);
    }
}
