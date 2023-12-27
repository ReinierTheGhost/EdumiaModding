package com.legends.edumia.block.properties;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.Arrays;
import java.util.List;

public class BlockVoxelShapes {

    public static final List<VoxelShape> stairTopShapes;
    public static final List<VoxelShape> stairBottomShapes;

    public BlockVoxelShapes() {
    }

    static {
        stairTopShapes = Arrays.asList(
                VoxelShapes.union(Block.createCuboidShape(0.0, 0.0, 8.0, 16.0, 16.0, 16.0),
                        Block.createCuboidShape(0.0, 8.0, 0.0, 16.0, 16.0, 8.0)),
                VoxelShapes.union(Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 16.0, 16.0),
                        Block.createCuboidShape(8.0, 8.0, 0.0, 16.0, 16.0, 16.0)),
                VoxelShapes.union(Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 8.0),
                        Block.createCuboidShape(0.0, 8.0, 8.0, 16.0, 16.0, 16.0)),
                VoxelShapes.union(Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 16.0),
                        Block.createCuboidShape(0.0, 8.0, 0.0, 8.0, 16.0, 16.0)));
        stairBottomShapes = Arrays.asList(
                VoxelShapes.union(Block.createCuboidShape(0.0, 0.0, 8.0, 16.0, 16.0, 16.0),
                        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 8.0)),
                VoxelShapes.union(Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 16.0, 16.0),
                        Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 8.0, 16.0)),
                VoxelShapes.union(Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 8.0),
                        Block.createCuboidShape(0.0, 0.0, 8.0, 16.0, 8.0, 16.0)),
                VoxelShapes.union(Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 16.0),
                        Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 8.0, 16.0)));

    }
}
