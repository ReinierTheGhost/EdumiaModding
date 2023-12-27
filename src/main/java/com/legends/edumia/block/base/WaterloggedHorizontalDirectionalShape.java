package com.legends.edumia.block.base;

import com.legends.edumia.block.properties.ModWaterloggable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;

public abstract class WaterloggedHorizontalDirectionalShape extends Shape implements ModWaterloggable {
    public static final DirectionProperty DIRECTION;

    public WaterloggedHorizontalDirectionalShape(Settings builder) {
        super(builder);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rot) {
        return state.with(DIRECTION, rot.rotate(state.get(DIRECTION)));
    }
    @Override
    public BlockState mirror(BlockState state, BlockMirror mirrorIn) {
        return state.with(DIRECTION, mirrorIn.apply(state.get(DIRECTION)));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction facing = context.getHorizontalPlayerFacing().getOpposite();
        FluidState fluid = context.getWorld().getFluidState(context.getBlockPos());
        return (BlockState)((BlockState)super.getPlacementState(context).with(DIRECTION, facing))
                .with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    protected final void createBlockStateDefinition(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{DIRECTION, WATERLOGGED});
        this.addProperties(builder);
    }

    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
    }

    static {
        DIRECTION = Properties.HORIZONTAL_FACING;
    }
}
