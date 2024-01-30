package com.legends.edumia.block.trees;

import com.legends.edumia.block.EdumiaLeavesBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class BlackOakLeavesBlock extends EdumiaLeavesBlock {
    public static final BooleanProperty DOWN = Properties.DOWN;


    public BlackOakLeavesBlock() {
        super();
        this.setDefaultState(this.getDefaultState().with(DOWN, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(new Property[]{DOWN});
    }

    private boolean hasDownState(WorldAccess world, BlockPos pos){
        BlockPos belowPos = pos.down();
        BlockState belowState = world.getBlockState(belowPos);
        return Block.isFaceFullSquare(belowState.getSidesShape(world, belowPos), Direction.UP);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(DOWN, this.hasDownState(ctx.getWorld(), ctx.getBlockPos()));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState facingState, WorldAccess world, BlockPos currentPos, BlockPos facingPos) {
        state = super.getStateForNeighborUpdate(state, facing, facingState, world, currentPos, facingPos);
        if (facing == Direction.DOWN){
            state = state.with(DOWN, this.hasDownState(world, currentPos));
        }

        return state;
    }

    @Override
    public int getOpacity(BlockState state, BlockView world, BlockPos pos) {
        return state.get(DOWN) ? 15 : super.getOpacity(state, world, pos);
    }
}
