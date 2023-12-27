package com.legends.edumia.block.directional;

import com.legends.edumia.block.base.HorizontalDirectionalShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class HalfDirectional extends HorizontalDirectionalShape {
    public static final EnumProperty<BlockHalf> TYPE_UPDOWN = EnumProperty.of("type", BlockHalf.class);
    private static final VoxelShape BOTTOM_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0);
    private static final VoxelShape TOP_SHAPE = Block.createCuboidShape(0.0, 8.0, 0.0, 16.0, 16.0, 16.0);

    public HalfDirectional(Settings properties) {
        super(properties);
        this.setDefaultState(((this.stateManager.getDefaultState())
                .with(DIRECTION, Direction.NORTH)).with(TYPE_UPDOWN, BlockHalf.BOTTOM));
    }

    public VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        return this.getShape(state);
    }

    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction facingHorizontal = context.getHorizontalPlayerFacing().getOpposite();
        BlockState state2 = ((this.getDefaultState().with(DIRECTION, facingHorizontal))
                .with(TYPE_UPDOWN, BlockHalf.BOTTOM));
        Direction facing = context.getSide();
        return facing == Direction.DOWN || facing != Direction.UP && context.getHitPos().y - context.getHitPos().getY() > 0.5 ?
                state2.with(TYPE_UPDOWN, BlockHalf.TOP) : state2;
    }

    protected void addProperties(StateManager.Builder<Block, BlockState> container) {
        container.add(new Property[]{TYPE_UPDOWN});
    }

    public VoxelShape getShape(BlockState state) {
        return state.get(TYPE_UPDOWN) == BlockHalf.BOTTOM ? BOTTOM_SHAPE : TOP_SHAPE;
    }
}
