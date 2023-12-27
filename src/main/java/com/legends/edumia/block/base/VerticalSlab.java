package com.legends.edumia.block.base;

import com.legends.edumia.block.util.PlacementHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class VerticalSlab extends WaterloggedHorizontalDirectionalShape {

    private BlockState parent = null;
    public static final IntProperty LAYERS = IntProperty.of("layer", 1, 4);
    public static final VoxelShape[] EAST_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0, 0.0, 0.0, 2.0, 16.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 4.0, 16.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 16.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 12.0, 16.0, 16.0)};
    public static final VoxelShape[] WEST_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(14.0, 0.0, 0.0, 16.0, 16.0, 16.0),
            Block.createCuboidShape(12.0, 0.0, 0.0, 16.0, 16.0, 16.0),
            Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 16.0),
            Block.createCuboidShape(4.0, 0.0, 0.0, 16.0, 16.0, 16.0)};
    public static final VoxelShape[] SOUTH_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 2.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 4.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 8.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 12.0)};
    public static final VoxelShape[] NORTH_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0, 0.0, 14.0, 16.0, 16.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 12.0, 16.0, 16.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 8.0, 16.0, 16.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 4.0, 16.0, 16.0, 16.0)};
    private Block fullBlock;

    public VerticalSlab(Settings props) {
        super(props);
        this.setDefaultState(((this.stateManager.getDefaultState()).with(DIRECTION, Direction.NORTH)).with(WATERLOGGED, false));
        this.fullBlock = getParent().getBlock();
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.get(DIRECTION)) {
            case NORTH:
            default:
                return NORTH_SHAPE[state.get(LAYERS) - 1];
            case SOUTH:
                return SOUTH_SHAPE[state.get(LAYERS) - 1];
            case WEST:
                return WEST_SHAPE[state.get(LAYERS) - 1];
            case EAST:
                return EAST_SHAPE[state.get(LAYERS) - 1];
        }
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        int i = (Integer)state.get(LAYERS);
        if (context.getStack().getItem() == this.asItem() && i <= 4) {
            if (PlacementHelper.replacingClickedOnBlock(context)) {
                return context.getSide() == state.get(DIRECTION);
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState blockstate = context.getWorld().getBlockState(context.getBlockPos());
        if (blockstate.getBlock() == this) {
            int i = (Integer)blockstate.get(LAYERS);
            return i == 4 ? this.fullBlock.getDefaultState() : (BlockState)blockstate.with(LAYERS, Math.min(4, i + 1));
        } else {
            return super.getPlacementState(context);
        }
    }

    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{LAYERS});
    }

    public BlockState getParent() throws InitializationException {
        if (this.parent == null) {
            throw new InitializationException("Parent state is null");
        } else {
            return this.parent;
        }
    }
}
