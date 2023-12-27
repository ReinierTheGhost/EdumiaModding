package com.legends.edumia.block.base;

import com.legends.edumia.block.properties.BidirectionalShape;
import com.legends.edumia.block.properties.ModWaterloggable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;

public abstract class WaterloggedBidirectionalShape extends Shape implements ModWaterloggable {
    public static final EnumProperty DIRECTION = EnumProperty.of("direction", BidirectionalShape.class);

    public WaterloggedBidirectionalShape(Settings builder) {
        super(builder);
    }

    public BlockState rotate(BlockState state, BlockRotation rot) {
        return state.get(DIRECTION) == BidirectionalShape.NORTH_SOUTH ? state.with(DIRECTION, BidirectionalShape.EAST_WEST) :
                state.with(DIRECTION, BidirectionalShape.NORTH_SOUTH);
    }

    public BlockState mirror(BlockState state, BlockMirror mirrorIn) {
        return state;
    }

    @NotNull
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BidirectionalShape facing = BidirectionalShape.EAST_WEST;
        if (context.getHorizontalPlayerFacing() == Direction.NORTH || context.getHorizontalPlayerFacing() == Direction.SOUTH) {
            facing = BidirectionalShape.NORTH_SOUTH;
        }

        FluidState fluid = context.getWorld().getFluidState(context.getBlockPos());
        return (super.getPlacementState(context).with(DIRECTION, facing)).with(WATERLOGGED, fluid.getFluid() ==
                Fluids.WATER);
    }

    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    protected final void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{DIRECTION, WATERLOGGED});
        this.addProperties(builder);
    }

    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
    }
}
