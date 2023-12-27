package com.legends.edumia.block;

import com.legends.edumia.utils.EdumiaLog;
import net.minecraft.block.*;
import net.minecraft.block.enums.SlabType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.function.Supplier;

public class AxialSlabBlock extends EdumiaSlabBlock{
    public static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0,
            16.0, 16.0, 8.0);
    public static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 8.0,
            16.0, 16.0, 16.0);
    public static final VoxelShape WEST_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0,
            8.0, 16.0, 16.0);
    public static final VoxelShape EAST_SHAPE = Block.createCuboidShape(8.0, 0.0, 0.0,
            16.0, 16.0, 16.0);
    public AxialSlabBlock(Block block) {
        super(block);
        Direction.Axis defaultAxis = this.getSlabAxisProperty().getValues().contains(Direction.Axis.Y)
                ? Direction.Axis.Y : Direction.Axis.X;
        this.setDefaultState(this.getDefaultState().with(this.getSlabAxisProperty(), defaultAxis));
    }

    public AxialSlabBlock(Supplier<Block> block){
        this(block.get());
    }

    protected EnumProperty<Direction.Axis> getSlabAxisProperty(){
        return EdumiaBlockStates.SLAB_AXIS;
    }

    protected boolean canDoubleSlabBeWatterLogged(){
        return  false;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(new Property[]{this.getSlabAxisProperty()});
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        SlabType slabType = state.get(TYPE);
        if (slabType == SlabType.DOUBLE){
            return VoxelShapes.fullCube();
        }else {
            boolean top = slabType == SlabType.TOP;
            Direction.Axis axis = state.get(this.getSlabAxisProperty());
            if (axis == Direction.Axis.Y){
                return top ? SlabBlock.TOP_SHAPE : SlabBlock.BOTTOM_SHAPE;
            }else if (axis == Direction.Axis.X){
                return top ? EAST_SHAPE : WEST_SHAPE;
            } else if (axis == Direction.Axis.Z){
                return top ? SOUTH_SHAPE : NORTH_SHAPE;
            } else{
                return VoxelShapes.fullCube();
            }
        }
    }

    private static Direction.Axis getSlabAxis(BlockState state){
        Block block = state.getBlock();
        if (block instanceof SlabBlock){
            Iterator var2 = state.getProperties().iterator();

            Property prop;
            do {
                if (!var2.hasNext()){
                    if (block.getClass() == SlabBlock.class){
                        return Direction.Axis.Y;
                    }

                    EdumiaLog.warn("Unknown SlabBlock subclass: %s with no axis-based property. Assuming axis = Y",
                            new Object[]{block.getClass().toString()});
                    return Direction.Axis.Y;
                }

                prop = (Property) var2.next();
            }while (!(prop instanceof EnumProperty) || (prop).getType() != Direction.Axis.class);

            return (Direction.Axis)state.get(prop);
        }else {
            throw new IllegalArgumentException("this method should only get called on known instances of SlabBlock");
        }
    }

    protected boolean isSameSlab(SlabBlock otherSlab){
        return otherSlab == this;
    }

    protected final boolean isSameSlab(BlockState otherBlockState){
        Block otherBlock = otherBlockState.getBlock();
        return otherBlock instanceof SlabBlock && this.isSameSlab((SlabBlock) otherBlock);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        AxialSlabPlacement placement = this.getSlabPlacmentState(context);
        return ((this.getDefaultState().with(this.getSlabAxisProperty(), placement.axis))
                .with(TYPE, placement.type)).with(WATERLOGGED, placement.waterlogged);
    }

    protected AxialSlabPlacement getSlabPlacmentState(ItemPlacementContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);
        Direction dir = context.getSide();
        Direction.Axis axis = dir.getAxis();
        FluidState fluid = context.getWorld().getFluidState(pos);
        boolean waterlogged = fluid.getFluid() == Fluids.WATER;
        if (this.isSameSlab(state)){
            waterlogged &= this.canDoubleSlabBeWatterLogged();
            return AxialSlabPlacement.of(getSlabAxis(state), SlabType.DOUBLE, waterlogged);
        }else {
            BlockPos clickedPos = pos.offset(dir.getOpposite());
            BlockState clickedState = world.getBlockState(clickedPos);
            boolean sneaking = context.shouldCancelInteraction();
            if (sneaking){
                if (axis.isHorizontal()){
                    axis = Direction.Axis.Y;
                }else if (axis.isVertical() && (!isSingleSlab(clickedState) || !getSlabAxis(clickedState).isHorizontal())){
                    dir = context.getHorizontalPlayerFacing();
                    axis = dir.getAxis();
                }
            }else if (isSingleSlab(clickedState)){
                axis = getSlabAxis(clickedState);
            }

            Direction axisPosDir = Direction.get(Direction.AxisDirection.POSITIVE, axis);
            Direction axisNegDir = Direction.get(Direction.AxisDirection.NEGATIVE, axis);
            double relevantHitVerCoord = axis.choose(context.getHitPos().x, context.getHitPos().y,
                    context.getHitPos().z);
            double relevantPosCoord = axis.choose(pos.getX(), pos.getY(), pos.getZ());
            return dir == axisNegDir || dir != axisPosDir && relevantHitVerCoord - relevantPosCoord > 0.5 ?
                    AxialSlabPlacement.of(axis, SlabType.TOP, waterlogged) : AxialSlabPlacement.of(axis, SlabType.BOTTOM, waterlogged);
        }
    }

    private static boolean isSingleSlab(BlockState state) {
        return state.getBlock() instanceof SlabBlock && state.get(TYPE) != SlabType.DOUBLE;
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return this.isSlabReplaceable(state, context);
    }

    private boolean isSlabReplaceable(BlockState state, ItemPlacementContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        ItemStack itemStack = context.getStack();
        boolean holdingSameSlab = false;
        if (itemStack.getItem() instanceof BlockItem){
            Block itemBlock = ((BlockItem)itemStack.getItem()).getBlock();
            if (itemBlock instanceof SlabBlock){
                holdingSameSlab = this.isSameSlab((SlabBlock) itemBlock);
            }
        }

        Direction dir = context.getSide();
        boolean sneaking = context.shouldCancelInteraction();
        SlabType slabType = state.get(TYPE);
        Direction.Axis existingAxis = getSlabAxis(state);
        if (sneaking && existingAxis != Direction.Axis.Y){
            BlockPos offsetPos = pos.offset(dir);
            if (world.getBlockState(offsetPos).canReplace(AxialSlabUseContext
                    .makeReplacementContext(context, offsetPos, dir))){
                return false;
            }
        }
        if (slabType != SlabType.DOUBLE && holdingSameSlab){
            if (context.canReplaceExisting()){
                double relevantHitVecCoord = existingAxis.choose(context.getHitPos().x, context.getHitPos().y,
                        context.getHitPos().z);
                double relevantPosCoord = existingAxis.choose(pos.getX(), pos.getY(), pos.getZ());
                boolean flag = relevantHitVecCoord - relevantPosCoord > 0.5;
                if (slabType == SlabType.BOTTOM){
                    return dir == Direction.get(Direction.AxisDirection.POSITIVE, existingAxis) || flag && dir.getAxis() != existingAxis;
                }else{
                    return dir == Direction.get(Direction.AxisDirection.NEGATIVE, existingAxis) || !flag && dir.getAxis() != existingAxis;
                }
            }else{
                return true;
            }
        } else{
            return false;
        }
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rot) {
        SlabType slabType = state.get(TYPE);
        Direction.Axis axis = state.get(this.getSlabAxisProperty());
        Direction.AxisDirection axisDir = slabType == SlabType.BOTTOM ? Direction.AxisDirection.NEGATIVE : Direction.AxisDirection.POSITIVE;
        Direction dir = Direction.from(axis, axisDir);
        Direction rotatedDir = rot.rotate(dir);
        Direction.Axis rotatedAxis = rotatedDir.getAxis();
        Direction.AxisDirection rotatedAxisDir = rotatedDir.getDirection();
        if (this.getSlabAxisProperty().getValues().contains(rotatedAxis)){
            SlabType rotatedSlabType = slabType == SlabType.DOUBLE ? slabType : (rotatedAxisDir == Direction.AxisDirection.NEGATIVE ?
                    SlabType.BOTTOM : (rotatedAxisDir == Direction.AxisDirection.POSITIVE ? SlabType.TOP : slabType));
            return (state.with(this.getSlabAxisProperty(), rotatedAxis)).with(TYPE, rotatedSlabType);
        }else{
            return state;
        }
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        Direction.Axis axis = state.get(this.getSlabAxisProperty());
        SlabType type = state.get(TYPE);
        if (mirror == BlockMirror.LEFT_RIGHT && axis == Direction.Axis.Z || mirror == BlockMirror.FRONT_BACK && axis == Direction.Axis.X){
            if (type == SlabType.BOTTOM) {
                type = SlabType.TOP;
            } else if (type == SlabType.TOP){
                type = SlabType.BOTTOM;
            }
        }

        return state.with(TYPE, type);
    }

    @Override
    public boolean tryFillWithFluid(WorldAccess level, BlockPos pos, BlockState state, FluidState fluidState) {
        return this.canDoubleSlabBeWatterLogged() ? (new DefaultImplWaterLoggable()).tryFillWithFluid(level, pos, state, fluidState)
                : super.tryFillWithFluid(level, pos, state, fluidState);
    }

    @Override
    public boolean canFillWithFluid(BlockView level, BlockPos pos, BlockState blockState, Fluid fluid) {
        return this.canDoubleSlabBeWatterLogged() ? (new DefaultImplWaterLoggable()).canFillWithFluid(level, pos, blockState, fluid)
                : super.canFillWithFluid(level, pos, blockState, fluid);
    }

    private final class DefaultImplWaterLoggable implements Waterloggable {

        private DefaultImplWaterLoggable(){

        }
    }
    protected static class AxialSlabUseContext extends ItemPlacementContext{
        protected AxialSlabUseContext(World w, PlayerEntity pl, Hand h, ItemStack stack, BlockHitResult rayTrace) {
            super(w, pl, h, stack, rayTrace);
            BlockState state = this.getWorld().getBlockState(rayTrace.getBlockPos());
            if (state.getBlock() instanceof SlabBlock){
                SlabBlock slabBlock = (SlabBlock) state.getBlock();
                VerticalOnlySlabBlock verticalSlab = VerticalOnlySlabBlock.getVerticalSlabFor(slabBlock);
                if (verticalSlab != null){
                    this.canReplaceExisting = verticalSlab.canReplace(state, this);
                }
            }
        }

        public AxialSlabUseContext(ItemUsageContext context){
            super(context);
        }

        public static AxialSlabUseContext makeReplacementContext(ItemPlacementContext context, BlockPos pos, Direction dir){
            Vec3d blockVec = new Vec3d((double) pos.getX() + 0.5 + (double)dir.getOffsetY() * 0.5,
                    (double) pos.getY() + 0.5 + (double)dir.getOffsetX() * 0.5,
                    (double) pos.getZ() + 0.5 + (double)dir.getOffsetZ() * 0.5);
            BlockHitResult rayTrace = new BlockHitResult(blockVec, dir, pos, false);
            return new AxialSlabUseContext(context.getWorld(), context.getPlayer(), context.getHand(), context.getStack(), rayTrace);
        }
    }

    public static class AxialSlabPlacement {
        public final Direction.Axis axis;
        public final SlabType type;
        public final boolean waterlogged;
        private AxialSlabPlacement(Direction.Axis ax, SlabType type, boolean water){
            this.axis = ax;
            this.type = type;
            this.waterlogged = water;
        }

        public static AxialSlabPlacement of(Direction.Axis ax, SlabType type, boolean water){
            return new AxialSlabPlacement(ax, type, water);
        }
    }
}
