package com.legends.edumia.block.trees;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalConnectingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class BranchLarge extends HorizontalConnectingBlock {

    public static final BooleanProperty UP = Properties.UP;
    private final VoxelShape[] wallUpShapes;
    private final VoxelShape[] wallRegularShapes;
    public BranchLarge(Settings settings) {
        super(0.0F, 3.0F, 8.0F, 16.0F, 16.0F, settings);
        this.setDefaultState(((((((this.stateManager.getDefaultState()).with(UP, true)).with(NORTH, false)).with(EAST, false))
                .with(SOUTH, false)).with(WEST, false)).with(WATERLOGGED, false));
        this.wallUpShapes = this.makeUpShapes(4.0f, 3.0f, 16.0f, 8.0f, 16.0f);
        this.wallRegularShapes = this.makeRegularShapes(4.0f, 3.0f, 16.0f, 8.0f, 16.0f);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(UP) ? this.wallUpShapes[this.getShapeIndex(state)] : this.wallRegularShapes[this.getShapeIndex(state)];
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(UP) ? this.wallUpShapes[this.getShapeIndex(state)] : this.wallRegularShapes[this.getShapeIndex(state)];
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        WorldView worldView = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        FluidState fluidState = context.getWorld().getFluidState(context.getBlockPos());
        BlockPos north = blockPos.north();
        BlockPos east = blockPos.east();
        BlockPos south = blockPos.south();
        BlockPos west = blockPos.west();
        BlockState northState = worldView.getBlockState(north);
        BlockState eastState = worldView.getBlockState(east);
        BlockState southState = worldView.getBlockState(south);
        BlockState westState = worldView.getBlockState(west);
        BlockState blockStateDown = context.getWorld().getBlockState(context.getBlockPos().down());
        boolean flagDown = false;
        if (blockStateDown.isOpaque()){
            flagDown = true;
        }

        boolean northFlag = this.getConnection(northState);
        boolean eastFlag = this.getConnection(eastState);
        boolean southFlag = this.getConnection(southState);
        boolean westFlag = this.getConnection(westState);

        return ((((( this.getDefaultState().with(UP, flagDown)).with(NORTH, northFlag)).with(EAST, eastFlag)).with(SOUTH, southFlag))
                .with(WEST, westFlag)).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
    }

    public boolean allowsMovement(BlockState state, BlockView world, BlockPos pos, NavigationType type){
        return false;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState facingState, WorldAccess world, BlockPos currentPos, BlockPos facingPos) {
        Direction direction = facing.getOpposite();
        if (state.get(WATERLOGGED)){
            world.scheduleFluidTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        boolean flag;
        if (facing != Direction.DOWN){
            flag = facing == Direction.NORTH ? this.getConnection(facingState) : state.get(NORTH);
            boolean flag1 = facing == Direction.EAST ? this.getConnection(facingState) : state.get(EAST);
            boolean flag2 = facing == Direction.SOUTH ? this.getConnection(facingState) : state.get(SOUTH);
            boolean flag3 = facing == Direction.WEST ? this.getConnection(facingState) : state.get(WEST);
            return (((state.with(NORTH, flag)).with(EAST, flag1)).with(SOUTH, flag2)).with(WEST, flag3);
        }else {
            flag = facingState.isSideSolidFullSquare(world, facingPos, direction) || facingState.getBlock() instanceof BranchLarge ||
                    facingState.getBlock() instanceof Branch || facingState.getBlock() instanceof BranchSmall;
            return super.getStateForNeighborUpdate(state, facing, facingState, world, currentPos, facingPos).with(UP, flag);
        }
    }

    private boolean getConnection(BlockState state){
        Block block = state.getBlock();
        boolean flag = block instanceof BranchLarge || block instanceof Branch || block instanceof BranchSmall;
        return flag;
    }
    protected VoxelShape[] makeUpShapes(float nodeWidth, float extensionWidth, float nodeHeight, float extensionBeginning, float extensionHeight){
        float f = 8.0f - nodeWidth;
        float f1 = 8.0f + nodeWidth;
        float f2 = 8.0f - extensionWidth;
        float f3 = 8.0f + extensionWidth;
        VoxelShape voxelShape = Block.createCuboidShape(f, 0.0, f, f1, nodeHeight, f1);
        VoxelShape voxelShape1 = Block.createCuboidShape(f2, extensionBeginning, 0.0, f3, extensionHeight, f3);
        VoxelShape voxelShape2 = Block.createCuboidShape(f2, extensionBeginning, f2, f3, extensionHeight, 16.0);
        VoxelShape voxelShape3 = Block.createCuboidShape( 0.0, extensionBeginning, f2, f3, extensionHeight, f3);
        VoxelShape voxelShape4 = Block.createCuboidShape(f2, extensionBeginning, f2, 16.0, extensionHeight, f3);
        VoxelShape voxelShape5 = VoxelShapes.union(voxelShape1, voxelShape4);
        VoxelShape voxelShape6 = VoxelShapes.union(voxelShape2, voxelShape3);
        VoxelShape[] aVoxelShape = new VoxelShape[]{voxelShape, voxelShape2, voxelShape3, voxelShape6, voxelShape1, VoxelShapes.union(voxelShape2, voxelShape1),
                VoxelShapes.union(voxelShape3, voxelShape1), voxelShape4, VoxelShapes.union(voxelShape2, voxelShape4), VoxelShapes.union(voxelShape3, voxelShape4),
                VoxelShapes.union(voxelShape6, voxelShape4), voxelShape5, VoxelShapes.union(voxelShape2, voxelShape5), VoxelShapes.union(voxelShape3, voxelShape5),
                VoxelShapes.union(voxelShape6, voxelShape5)};

        for (int i = 0; i < 16; ++i){
            aVoxelShape[i] = VoxelShapes.union(voxelShape, aVoxelShape);
        }

        return aVoxelShape;

    }

    protected VoxelShape[] makeRegularShapes(float nodeWidth, float extensionWidth, float nodeHeight, float extensionBeginning, float extensionHeight){
        float f = 8.0f - nodeWidth;
        float f1 = 8.0f + nodeWidth;
        float f2 = 8.0f - extensionWidth;
        float f3 = 8.0f + extensionWidth;
        VoxelShape voxelShape = Block.createCuboidShape(f, 0.0, f, f1, nodeHeight, f1);
        VoxelShape voxelShape1 = Block.createCuboidShape(f2, extensionBeginning, 0.0, f3, extensionHeight, f3);
        VoxelShape voxelShape2 = Block.createCuboidShape(f2, extensionBeginning, f2, f3, extensionHeight, 16.0);
        VoxelShape voxelShape3 = Block.createCuboidShape( 0.0, extensionBeginning, f2, f3, extensionHeight, f3);
        VoxelShape voxelShape4 = Block.createCuboidShape(f2, extensionBeginning, f2, 16.0, extensionHeight, f3);
        VoxelShape voxelShape5 = VoxelShapes.union(voxelShape1, voxelShape4);
        VoxelShape voxelShape6 = VoxelShapes.union(voxelShape2, voxelShape3);
        VoxelShape[] aVoxelShape = new VoxelShape[]{voxelShape, voxelShape2, voxelShape3, voxelShape6, voxelShape1, VoxelShapes.union(voxelShape2, voxelShape1),
                VoxelShapes.union(voxelShape3, voxelShape1), voxelShape4, VoxelShapes.union(voxelShape2, voxelShape4), VoxelShapes.union(voxelShape3, voxelShape4),
                VoxelShapes.union(voxelShape6, voxelShape4), voxelShape5, VoxelShapes.union(voxelShape2, voxelShape5), VoxelShapes.union(voxelShape3, voxelShape5),
                VoxelShapes.union(voxelShape6, voxelShape5)};

        return aVoxelShape;

    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{UP, NORTH, EAST, WEST, SOUTH, WATERLOGGED});
    }
}
