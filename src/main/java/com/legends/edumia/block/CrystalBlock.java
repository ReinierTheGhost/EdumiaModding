package com.legends.edumia.block;

import com.legends.edumia.utils.EdumiaUtil;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.function.ToIntFunction;

public class CrystalBlock extends Block implements Waterloggable, Stainable {
    public static final EnumProperty<Direction> CRYSTAL_FACING = Properties.FACING;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final VoxelShape SHAPE_UP = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 15.0, 14.0);
    private static final VoxelShape SHAPE_DOWN= Block.createCuboidShape(2.0, 1.0, 2.0, 14.0, 16.0, 14.0);;
    private static final VoxelShape SHAPE_WEST= Block.createCuboidShape(1.0, 2.0, 2.0, 16.0, 14.0, 14.0);;
    private static final VoxelShape SHAPE_EAST = Block.createCuboidShape(0.0, 2.0, 2.0, 15.0, 14.0, 14.0);;
    private static final VoxelShape SHAPE_NORTH= Block.createCuboidShape(2.0, 2.0, 1.0, 14.0, 14.0, 16.0);;
    private static final VoxelShape SHAPE_SOUTH= Block.createCuboidShape(2.0, 2.0, 0.0, 14.0, 14.0, 15.0);;
    private final DyeColor beaconBeamColor;

    public CrystalBlock(Settings settings, DyeColor color) {
        super(settings);
        this.setDefaultState((this.getDefaultState().with(CRYSTAL_FACING, Direction.UP).with(WATERLOGGED, false)));
        this.beaconBeamColor = color;
    }

    public CrystalBlock(int light, int harvestLvl, DyeColor color){
        this(Settings.create().requiresTool().strength(3.0f, 3.0f).nonOpaque().luminance(constantLight(light)).sounds(BlockSoundGroup.GLASS), color);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{CRYSTAL_FACING, WATERLOGGED});
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction crystalFacing = state.get(CRYSTAL_FACING);
        switch (crystalFacing){
            case UP:
            default:
                return SHAPE_UP;
            case DOWN:
                return SHAPE_DOWN;
            case WEST:
                return SHAPE_WEST;
            case EAST:
                return SHAPE_EAST;
            case NORTH:
                return SHAPE_NORTH;
            case SOUTH:
                return SHAPE_SOUTH;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState fluid = context.getWorld().getFluidState(context.getBlockPos());
        return (this.getDefaultState().with(CRYSTAL_FACING, context.getSide())).with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)){
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        Direction crystalFacing = state.get(CRYSTAL_FACING);
        return direction == crystalFacing.getOpposite() && !this.canPlaceAt(state, world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction crystalFacing = state.get(CRYSTAL_FACING);
        BlockPos supportPos = pos.offset(crystalFacing.getOpposite());
        return EdumiaUtil.hasSolidSide(world, supportPos, crystalFacing);
    }


    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(CRYSTAL_FACING, rotation.rotate(state.get(CRYSTAL_FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(CRYSTAL_FACING)));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public DyeColor getColor() {
        return this.beaconBeamColor;
    }

    public static ToIntFunction<BlockState> constantLight(int light){
        return (state) ->
                light;
    }
}
