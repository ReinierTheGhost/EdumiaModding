package com.legends.edumia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.Fluids;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class FallenLeavesBlock extends Block {
    public static final List<FallenLeavesBlock> ALL_FALLEN_LEAVES = new ArrayList<>();
    public static final Map<Block, FallenLeavesBlock> LEAVES_TO_FALLEN_LEAVES = new HashMap<>();
    private static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0);
    private final Block baseLeaveBlock;

    public FallenLeavesBlock(Block leaf, Settings settings) {
        super(settings);
        this.baseLeaveBlock = leaf;
        ALL_FALLEN_LEAVES.add(this);
        LEAVES_TO_FALLEN_LEAVES.put(this.baseLeaveBlock, this);
    }

    public FallenLeavesBlock(Block leaf){
        this(leaf, Settings.create().strength(0.1f).sounds(BlockSoundGroup.GRASS).noCollision().nonOpaque());
    }

    public FallenLeavesBlock(Supplier<Block> leaf){
        this(leaf.get());
    }

    public Block getBaseLeaveBlock() {
        return baseLeaveBlock;
    }

    public static FallenLeavesBlock getFallenLeavesFor(Block leafBlock){
        return LEAVES_TO_FALLEN_LEAVES.get(leafBlock);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos belowPos = pos.down();
        return world.getBlockState(belowPos).isSideSolidFullSquare(world, belowPos, Direction.UP) || world.getFluidState(belowPos).getFluid() == Fluids.WATER;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState facingState, WorldAccess world, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !state.canPlaceAt(world, currentPos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, facing, facingState, world, currentPos, facingPos);
    }
}
