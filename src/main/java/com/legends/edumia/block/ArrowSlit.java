package com.legends.edumia.block;

import com.legends.edumia.block.base.WaterloggedHorizontalDirectionalShape;
import com.legends.edumia.block.properties.ModWaterloggable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class ArrowSlit  extends WaterloggedHorizontalDirectionalShape implements ModWaterloggable {
    private static final VoxelShape EAST_FR = Block.createCuboidShape(0.0, 0.0, 9.0,
            1.0, 16.0, 13.0);
    private static final VoxelShape EAST_FL = Block.createCuboidShape(0.0, 0.0, 3.0,
            1.0, 16.0, 7.0);
    private static final VoxelShape EAST_SR = Block.createCuboidShape(0.0, 0.0, 13.0,
            8.0, 16.0, 16.0);
    private static final VoxelShape EAST_SL = Block.createCuboidShape(0.0, 0.0, 0.0,
            8.0, 16.0, 3.0);
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape WEST_FR;
    private static final VoxelShape WEST_FL;
    private static final VoxelShape WEST_SR;
    private static final VoxelShape WEST_SL;
    private static final VoxelShape WEST_SHAPE;
    private static final VoxelShape NORTH_FR;
    private static final VoxelShape NORTH_FL;
    private static final VoxelShape NORTH_SR;
    private static final VoxelShape NORTH_SL;
    private static final VoxelShape NORTH_SHAPE;
    private static final VoxelShape SOUTH_FR;
    private static final VoxelShape SOUTH_FL;
    private static final VoxelShape SOUTH_SR;
    private static final VoxelShape SOUTH_SL;
    private static final VoxelShape SOUTH_SHAPE;

    public ArrowSlit(Settings properties) {
        super(properties);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState())
                .with(DIRECTION, Direction.NORTH)).with(WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{DIRECTION, WATERLOGGED});
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch ((Direction)state.get(DIRECTION)) {
            case NORTH:
            default:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case EAST:
                return EAST_SHAPE;
        }
    }

    static {
        EAST_SHAPE = VoxelShapes.union(VoxelShapes.union(EAST_FR, EAST_FL), VoxelShapes.union(EAST_SR, EAST_SL));
        WEST_FR = Block.createCuboidShape(15.0, 0.0, 9.0, 16.0, 16.0, 13.0);
        WEST_FL = Block.createCuboidShape(15.0, 0.0, 3.0, 16.0, 16.0, 7.0);
        WEST_SR = Block.createCuboidShape(8.0, 0.0, 13.0, 16.0, 16.0, 16.0);
        WEST_SL = Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 3.0);
        WEST_SHAPE = VoxelShapes.union(VoxelShapes.union(WEST_FR, WEST_FL), VoxelShapes.union(WEST_SR, WEST_SL));
        NORTH_FR = Block.createCuboidShape(9.0, 0.0, 15.0, 13.0, 16.0, 16.0);
        NORTH_FL = Block.createCuboidShape(3.0, 0.0, 15.0, 7.0, 16.0, 16.0);
        NORTH_SR = Block.createCuboidShape(13.0, 0.0, 8.0, 16.0, 16.0, 16.0);
        NORTH_SL = Block.createCuboidShape(0.0, 0.0, 8.0, 3.0, 16.0, 16.0);
        NORTH_SHAPE = VoxelShapes.union(VoxelShapes.union(NORTH_FR, NORTH_FL), VoxelShapes.union(NORTH_SR, NORTH_SL));
        SOUTH_FR = Block.createCuboidShape(9.0, 0.0, 0.0, 13.0, 16.0, 1.0);
        SOUTH_FL = Block.createCuboidShape(3.0, 0.0, 0.0, 7.0, 16.0, 1.0);
        SOUTH_SR = Block.createCuboidShape(13.0, 0.0, 0.0, 16.0, 16.0, 8.0);
        SOUTH_SL = Block.createCuboidShape(0.0, 0.0, 0.0, 3.0, 16.0, 8.0);
        SOUTH_SHAPE = VoxelShapes.union(VoxelShapes.union(SOUTH_FR, SOUTH_FL), VoxelShapes.union(SOUTH_SR, SOUTH_SL));
    }
}
