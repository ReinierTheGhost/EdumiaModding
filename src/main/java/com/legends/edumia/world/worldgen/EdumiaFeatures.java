package com.legends.edumia.world.worldgen;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

public class EdumiaFeatures {

    public static BlockState getBlockStateInContext(BlockState state, WorldAccess worldAccess, BlockPos pos){
        return Block.postProcessState(state, worldAccess, pos);
    }


}
