package com.legends.edumia.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;

public abstract class HorizontalDirectionalShape extends Shape {
    public static final DirectionProperty DIRECTION;

    public HorizontalDirectionalShape(Settings builder) {
        super(builder);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rot) {
        return state.with(DIRECTION, rot.rotate(state.get(DIRECTION)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.get(DIRECTION)));
    }

    @Override
    @NotNull
    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction facing = context.getHorizontalPlayerFacing().getOpposite();
        return (BlockState)super.getPlacementState(context).with(DIRECTION, facing);
    }

    @Override
    protected final void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{DIRECTION});
        this.addProperties(builder);
    }

    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
    }

    static {
        DIRECTION = Properties.HORIZONTAL_FACING;
    }
}
