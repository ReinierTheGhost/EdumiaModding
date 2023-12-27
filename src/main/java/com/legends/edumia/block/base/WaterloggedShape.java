package com.legends.edumia.block.base;

import com.legends.edumia.block.properties.ModWaterloggable;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;

public abstract class WaterloggedShape extends Shape implements ModWaterloggable {
    public WaterloggedShape(Settings properties) {
        super(properties);
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState fluid = context.getWorld().getFluidState(context.getBlockPos());
        BlockState base = super.getPlacementState(context);
        if (base == null) {
            base = this.getDefaultState();
        }

        return base.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    protected final void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{WATERLOGGED});
        this.addProperties(builder);
    }

    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
    }

}
