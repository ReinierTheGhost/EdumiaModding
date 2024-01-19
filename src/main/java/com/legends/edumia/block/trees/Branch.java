package com.legends.edumia.block.trees;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class Branch extends BranchLarge{

    private final VoxelShape[] wallUpShapes = this.makeUpShapes(3.0f, 3.0f,16.0f, 10.0f, 16.0f);
    private final VoxelShape[] wallRegularShapes = this.makeUpShapes(3.0f, 3.0f,16.0f, 10.0f, 16.0f);
    public Branch(Settings settings) {
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
