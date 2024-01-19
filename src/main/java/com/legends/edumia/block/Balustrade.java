package com.legends.edumia.block;

import com.legends.edumia.block.properties.ModWaterloggable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class Balustrade extends PillarBlock implements ModWaterloggable {
    public static final VoxelShape field_196436_c = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 4.0, 14.0);
    public static final VoxelShape field_196439_y = Block.createCuboidShape(3.0, 4.0, 4.0, 13.0, 5.0, 12.0);
    public static final VoxelShape field_196440_z = Block.createCuboidShape(4.0, 5.0, 6.0, 12.0, 10.0, 10.0);
    public static final VoxelShape field_196434_A = Block.createCuboidShape(0.0, 10.0, 3.0, 16.0, 16.0, 13.0);
    public static final VoxelShape field_196435_B = Block.createCuboidShape(4.0, 4.0, 3.0, 12.0, 5.0, 13.0);
    public static final VoxelShape field_196437_C = Block.createCuboidShape(6.0, 5.0, 4.0, 10.0, 10.0, 12.0);
    public static final VoxelShape field_196438_D = Block.createCuboidShape(3.0, 10.0, 0.0, 13.0, 16.0, 16.0);
    public static final VoxelShape X_AXIS_AABB;
    public static final VoxelShape Z_AXIS_AABB;
    public static final VoxelShape Y_BASE;
    public static final VoxelShape Y_LOWER;
    public static final VoxelShape Y_MIDDLE;
    public static final VoxelShape Y_TOP;
    public static final VoxelShape Y_AXIS_AABB;

    public Balustrade(Settings properties) {
        super(properties);
        this.setDefaultState(((this.stateManager.getDefaultState()).with(AXIS,
                Direction.Axis.Y)).with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getOutlineShape (BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        switch (state.get(AXIS)) {
            case X:
            default:
                return X_AXIS_AABB;
            case Y:
                return Y_AXIS_AABB;
            case Z:
                return Z_AXIS_AABB;
        }
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{AXIS, WATERLOGGED});
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState fluidstate = context.getWorld().getFluidState(context.getBlockPos());
        return (super.getPlacementState(context).with(AXIS, context.getSide().getAxis()))
                .with(WATERLOGGED, fluidstate.getFluid() == Fluids.WATER);
    }

    static {
        X_AXIS_AABB = VoxelShapes.union(field_196436_c, VoxelShapes.union(field_196439_y, VoxelShapes.union(field_196440_z, field_196434_A)));
        Z_AXIS_AABB = VoxelShapes.union(field_196436_c, VoxelShapes.union(field_196435_B, VoxelShapes.union(field_196437_C, field_196438_D)));
        Y_BASE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 4.0, 14.0);
        Y_LOWER = Block.createCuboidShape(3.0, 4.0, 3.0, 13.0, 5.0, 13.0);
        Y_MIDDLE = Block.createCuboidShape(4.0, 5.0, 4.0, 12.0, 11.0, 12.0);
        Y_TOP = Block.createCuboidShape(2.0, 11.0, 2.0, 14.0, 16.0, 14.0);
        Y_AXIS_AABB = VoxelShapes.union(Y_BASE, VoxelShapes.union(Y_LOWER, VoxelShapes.union(Y_MIDDLE, Y_TOP)));
    }

}
