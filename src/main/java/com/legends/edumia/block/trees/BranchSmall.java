package com.legends.edumia.block.trees;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class BranchSmall extends BranchLarge{

    private final VoxelShape[] wallUpShapes = this.makeUpShapes(2.0f, 2.0f,16.0f, 12.0f, 16.0f);
    private final VoxelShape[] wallRegularShapes = this.makeUpShapes(2.0f, 2.0f,16.0f, 12.0f, 16.0f);
    public BranchSmall(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(UP) ? this.wallUpShapes[this.getShapeIndex(state)] : this.wallRegularShapes[this.getShapeIndex(state)];
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(UP) ? this.wallUpShapes[this.getShapeIndex(state)] : this.wallRegularShapes[this.getShapeIndex(state)];
    }
}
