package com.legends.edumia.block;


import com.legends.edumia.block.base.WaterloggedShape;
import com.legends.edumia.block.util.PlacementHelper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class Layer extends WaterloggedShape {
    public static final IntProperty LAYERS;
    private static final VoxelShape[] BOTTOM_SHAPE;
    public static final VoxelShape SPECIAL_FULL_SHAPE_COLLISION;

    public Layer(Settings props) {
        super(props);
        this.setDefaultState(((this.getStateManager().getDefaultState()).with(LAYERS, 1)).with(WATERLOGGED, false));
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return BOTTOM_SHAPE[state.get(LAYERS) - 1];
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(LAYERS) == 8 ? SPECIAL_FULL_SHAPE_COLLISION : BOTTOM_SHAPE[state.get(LAYERS) - 1];
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        if (!PlacementHelper.replacingClickedOnBlock(context)) {
            return false;
        } else {
            ItemStack item = context.getStack();
            if (item.getItem() == this.asItem() && (Integer)state.get(LAYERS) != 8) {
                return context.getSide() == Direction.UP;
            } else {
                return false;
            }
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState state = context.getWorld().getBlockState(context.getBlockPos());
        if (state.getBlock() == this) {
            int i = state.get(LAYERS);
            return state.with(LAYERS, Math.min(8, i + 1));
        } else {
            FluidState fluid = context.getWorld().getFluidState(context.getBlockPos());
            BlockState state2 = this.getDefaultState().with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
            return state2;
        }
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> container) {
        container.add(new Property[]{LAYERS});
    }

    static {
        LAYERS = Properties.LAYERS;
        BOTTOM_SHAPE = new VoxelShape[]{
                Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
                Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
                Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),
                Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
                Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
                Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 12.0, 16.0),
                Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),
                Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)};
        SPECIAL_FULL_SHAPE_COLLISION = Block.createCuboidShape(0.0, 2.0, 0.0, 16.0, 16.0, 16.0);
    }
}