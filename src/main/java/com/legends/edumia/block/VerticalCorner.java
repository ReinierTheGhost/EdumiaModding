package com.legends.edumia.block;

import com.legends.edumia.block.base.VerticalSlab;
import com.legends.edumia.block.base.WaterloggedHorizontalDirectionalShape;
import com.legends.edumia.block.properties.ModWaterloggable;
import com.legends.edumia.block.util.PlacementHelper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class VerticalCorner extends WaterloggedHorizontalDirectionalShape implements ModWaterloggable {
    public static final IntProperty LAYERS = IntProperty.of("layer", 1, 4);
    public static final VoxelShape[] EAST_SHAPE;
    public static final VoxelShape[] WEST_SHAPE;
    public static final VoxelShape[] NORTH_SHAPE;
    public static final VoxelShape[] SOUTH_SHAPE;
    private Block fullBlock;

    public VerticalCorner(Settings properties) {
        super(properties);
        this.setDefaultState(((this.stateManager.getDefaultState()).with(DIRECTION, Direction.NORTH))
                .with(WATERLOGGED, false));
        this.fullBlock = getDefaultState().getBlock();
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirrorIn) {
        switch (mirrorIn) {
            case FRONT_BACK:
                switch (state.get(DIRECTION)) {
                    case NORTH:
                        return state.with(DIRECTION, Direction.EAST);
                    case EAST:
                        return state.with(DIRECTION, Direction.NORTH);
                    case SOUTH:
                        return state.with(DIRECTION, Direction.WEST);
                    case WEST:
                        return state.with(DIRECTION, Direction.SOUTH);
                    default:
                        return super.mirror(state, mirrorIn);
                }
            case LEFT_RIGHT:
                switch (state.get(DIRECTION)) {
                    case NORTH:
                        return state.with(DIRECTION, Direction.WEST);
                    case EAST:
                        return state.with(DIRECTION, Direction.SOUTH);
                    case SOUTH:
                        return state.with(DIRECTION, Direction.EAST);
                    case WEST:
                        return state.with(DIRECTION, Direction.NORTH);
                    default:
                        return super.mirror(state, mirrorIn);
                }
            default:
                return super.mirror(state, mirrorIn);
        }
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.get(DIRECTION)) {
            case NORTH:
            default:
                return NORTH_SHAPE[state.get(LAYERS) - 1];
            case EAST:
                return EAST_SHAPE[state.get(LAYERS) - 1];
            case SOUTH:
                return SOUTH_SHAPE[state.get(LAYERS) - 1];
            case WEST:
                return WEST_SHAPE[state.get(LAYERS) - 1];
        }
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        int i = state.get(LAYERS);
        if (context.getStack().getItem() == this.asItem() && i <= 4) {
            if (!PlacementHelper.replacingClickedOnBlock(context)) {
                return true;
            } else {
                return context.getSide() == state.get(DIRECTION) || context.getSide() == (state.get(DIRECTION))
                        .rotateYClockwise();
            }
        } else {
            return false;
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos blockpos = context.getBlockPos();
        Direction facing = PlacementHelper.getHitVecHorizontalAxisDirection(context.getHorizontalPlayerFacing().getOpposite(),
                blockpos, context);
        BlockState blockstate = context.getWorld().getBlockState(context.getBlockPos());
        if (blockstate.getBlock() == this) {
            int i = blockstate.get(LAYERS);
            return i == 4 ? this.fullBlock.getDefaultState() : (BlockState)blockstate.with(LAYERS, Math.min(4, i + 1));
        } else {
            return (BlockState)super.getPlacementState(context).with(DIRECTION, facing);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION);
        builder.add(WATERLOGGED);
        builder.add(LAYERS);
    }



    static {
        EAST_SHAPE = new VoxelShape[]{
                VoxelShapes.union(VerticalSlab.EAST_SHAPE[0], VerticalSlab.NORTH_SHAPE[0]),
                VoxelShapes.union(VerticalSlab.EAST_SHAPE[1], VerticalSlab.NORTH_SHAPE[1]),
                VoxelShapes.union(VerticalSlab.EAST_SHAPE[2], VerticalSlab.NORTH_SHAPE[2]),
                VoxelShapes.union(VerticalSlab.EAST_SHAPE[3], VerticalSlab.NORTH_SHAPE[3])};
        WEST_SHAPE = new VoxelShape[]{
                VoxelShapes.union(VerticalSlab.WEST_SHAPE[0], VerticalSlab.SOUTH_SHAPE[0]),
                VoxelShapes.union(VerticalSlab.WEST_SHAPE[1], VerticalSlab.SOUTH_SHAPE[1]),
                VoxelShapes.union(VerticalSlab.WEST_SHAPE[2], VerticalSlab.SOUTH_SHAPE[2]),
                VoxelShapes.union(VerticalSlab.WEST_SHAPE[3], VerticalSlab.SOUTH_SHAPE[3])};
        NORTH_SHAPE = new VoxelShape[]{
                VoxelShapes.union(VerticalSlab.NORTH_SHAPE[0], VerticalSlab.WEST_SHAPE[0]),
                VoxelShapes.union(VerticalSlab.NORTH_SHAPE[1], VerticalSlab.WEST_SHAPE[1]),
                VoxelShapes.union(VerticalSlab.NORTH_SHAPE[2], VerticalSlab.WEST_SHAPE[2]),
                VoxelShapes.union(VerticalSlab.NORTH_SHAPE[3], VerticalSlab.WEST_SHAPE[3])};
        SOUTH_SHAPE = new VoxelShape[]{
                VoxelShapes.union(VerticalSlab.SOUTH_SHAPE[0], VerticalSlab.EAST_SHAPE[0]),
                VoxelShapes.union(VerticalSlab.SOUTH_SHAPE[1], VerticalSlab.EAST_SHAPE[1]),
                VoxelShapes.union(VerticalSlab.SOUTH_SHAPE[2], VerticalSlab.EAST_SHAPE[2]),
                VoxelShapes.union(VerticalSlab.SOUTH_SHAPE[3], VerticalSlab.EAST_SHAPE[3])};
    }
}
