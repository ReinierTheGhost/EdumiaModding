package com.legends.edumia.block;

import com.legends.edumia.utils.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

public class EdumiaPillarBlock extends PillarBlock {

    public static final BooleanProperty ABOVE = EdumiaBlockStates.PILLAR_ABOVE;
    public static final BooleanProperty BELOW = EdumiaBlockStates.PILLAR_BELOW;
    public EdumiaPillarBlock(Settings properties) {
        super(properties);
        //this.registerDefaultState(this.defaultBlockState().setValue(ABOVE, false).setValue(BELOW, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(new Property[]{ABOVE});
        builder.add(new Property[]{BELOW});
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState state = super.getPlacementState(context);
        BlockPos pos = context.getBlockPos();
        WorldAccess world = context.getWorld();
        Direction[] var5 = Direction.values();
        int var6 = var5.length;

        for (int var7 = 0; var7 < var6; ++var7){
            Direction dir = var5[var7];
            BlockPos facingPos = pos.offset(dir);
            state = this.checkAdjacentPillars(state, dir, world.getBlockState(facingPos), world, pos, facingPos);
        }

        return  state;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction dir, BlockState facingState, WorldAccess level,
                                  BlockPos currentPos, BlockPos facingPos) {
        return this.checkAdjacentPillars(state, dir, facingState, level, currentPos, facingPos);
    }

    private BlockState checkAdjacentPillars(BlockState state, Direction dir, BlockState facingState, WorldAccess world,
                                            BlockPos pos, BlockPos facingPos) {
        Direction.Axis pillarAxis = state.get(AXIS);
        if (dir.getAxis() == pillarAxis){
            Direction.AxisDirection axisDir = dir.getDirection();
            boolean matchDir = false;
            if (facingState.isIn(ModTags.Blocks.PILLARS)){
                if (facingState.contains(AXIS)){
                    matchDir = facingState.get(AXIS) == pillarAxis;
                } else{
                    matchDir = true;
                }
            }
            if (axisDir == Direction.AxisDirection.POSITIVE){
                return state.with(ABOVE, matchDir);
            }

            if (axisDir == Direction.AxisDirection.NEGATIVE) {
                return state.with(BELOW, matchDir);
            }
        }
        return state;
    }
}
