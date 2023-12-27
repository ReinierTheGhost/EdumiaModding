package com.legends.edumia.block.plants;

import com.legends.edumia.block.EdumiaBlockStates;

import com.legends.edumia.utils.ModTags;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;

public class ReedsBlock extends Block implements Waterloggable, Fertilizable {

    public static final EnumProperty<Type> REEDS_TYPE = EdumiaBlockStates.REEDS_TYPE;

    public static final IntProperty AGE = Properties.AGE_15;
    private static final int MAX_AGE = 15;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
    private final boolean canReedGrow;
    private final boolean canPlaceByIce;

    protected ReedsBlock(Settings properties, boolean canGrow) {
        super(properties);
        this.setDefaultState(((this.getDefaultState().with(REEDS_TYPE, Type.ONE))
                .with(AGE, 0))
                .with(WATERLOGGED, false));
        this.canReedGrow = canGrow;
        this.canPlaceByIce = !canGrow;
    }

    protected ReedsBlock(boolean canGrow){
        this(Settings.create().noCollision().ticksRandomly().strength(0.0F).sounds(BlockSoundGroup.GRASS), canGrow);
    }

    public ReedsBlock(){
        this(true);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{REEDS_TYPE, AGE, WATERLOGGED});
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState placeState = this.getDefaultState();
        World level = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState belowState = level.getBlockState(pos.down());
        if (belowState.getBlock() == this){
            Type reedType = belowState.get(REEDS_TYPE);
            if (reedType == Type.ONE){
                placeState = placeState.with(REEDS_TYPE, Type.TWO_TOP);
            } else if (reedType == Type.TWO_TOP) {
                placeState = placeState.with(REEDS_TYPE, Type.THREE_TOP);
            }
        }

        FluidState fluid = context.getWorld().getFluidState(context.getBlockPos());
        return placeState.with(WATERLOGGED, fluid.streamTags() == Fluids.WATER);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState facingState, WorldAccess world,
                                                BlockPos currentPos,
                                  BlockPos facingPos) {
        if (!state.canPlaceAt(world, currentPos)){
            world.scheduleBlockTick(currentPos, this, 1);
        }else if (facing == Direction.UP){
            Type thisReedType = state.get(REEDS_TYPE);
            if (facingState.getBlock() == this){
                Type aboveReedType = facingState.get(REEDS_TYPE);

                if (thisReedType == Type.ONE && aboveReedType == Type.TWO_TOP){
                    return state.with(REEDS_TYPE, Type.TWO_BOTTOM);
                }

                if (thisReedType == Type.TWO_TOP && aboveReedType == Type.THREE_TOP){
                    return state.with(REEDS_TYPE, Type.THREE_MIDDLE);
                }

                if (thisReedType == Type.TWO_BOTTOM && aboveReedType == Type.THREE_MIDDLE){
                    return state.with(REEDS_TYPE, Type.THREE_BOTTOM);
                }

                if (thisReedType == Type.THREE_BOTTOM && aboveReedType == Type.TWO_TOP){
                    return state.with(REEDS_TYPE, Type.TWO_BOTTOM);
                }
            }else {
                if (thisReedType == Type.TWO_BOTTOM || thisReedType == Type.THREE_BOTTOM){
                    return state.with(REEDS_TYPE, Type.ONE);
                }

                if (thisReedType == Type.THREE_MIDDLE){
                    return state.with(REEDS_TYPE, Type.TWO_TOP);
                }
            }
        }

        if (state.get(WATERLOGGED)){
            world.scheduleFluidTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, facing, facingState, world, currentPos, facingPos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Type reedType = state.get(REEDS_TYPE);
        BlockPos belowPos = pos.down();
        BlockState belowState = world.getBlockState(belowPos);
        if (reedType != Type.ONE && reedType != Type.TWO_BOTTOM && reedType != Type.THREE_BOTTOM){
            if (reedType == Type.THREE_TOP && state.get(WATERLOGGED)){
                return false;
            } else {
                return belowState.getBlock() == this;
            }
        } else {
            if (belowState.isIn(ModTags.Blocks.REEDS_PLACEABLE_ON)){
                if (world.getFluidState(pos).getFluid() == Fluids.WATER){
                    boolean canPotentiallyReachAir = false;
                    if(this.isAirOrReedsInAir(world, pos.up())){
                        canPotentiallyReachAir = true;
                    }else if (this.isWaterOrReedsInWater(world, pos.up()) && this.isAirOrReedsInAir(world, pos.up(2))){
                        canPotentiallyReachAir = true;
                    }

                    return canPotentiallyReachAir;
                }

                Iterator var7 = Direction.Type.HORIZONTAL.iterator();

                while (var7.hasNext()){
                    Direction horizontalDir = (Direction)var7.next();
                    BlockState adjacentBelowState = world.getBlockState(belowPos.offset(horizontalDir));
                    FluidState fluid = adjacentBelowState.getFluidState();
                    if (fluid.isIn(FluidTags.WATER) || adjacentBelowState.getBlock() == Blocks.FROSTED_ICE ||
                            this.canPlaceByIce && adjacentBelowState.getProperties() == Blocks.ICE){
                        return true;
                    }
                }
            }

            return false;
        }
    }

    private boolean isAirOrReedsInAir(WorldView world, BlockPos pos) {
        if (world.isAir(pos)){
            return true;
        }else {
            BlockState state = world.getBlockState(pos);
            return state.getBlock() == this && !(Boolean)state.get(WATERLOGGED);
        }
    }

    private boolean isWaterOrReedsInWater(WorldView world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.getFluidState().getFluid() == Fluids.WATER){
            return true;
        } else {
            return state.getBlock() == this && state.get(WATERLOGGED);
        }
    }


    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        if (!state.canPlaceAt(world, pos)){
            world.breakBlock(pos, true);
        } else if (this.canReedGrow && this.canReedGrowUpwards(world, pos, state)) {
            int age = state.get(AGE);
//            if (ForgeHooks.onCropsGrowPre(world, pos, state, true)){
//                if (age == 15){
//                    this.growReedAbove(world, pos, state);
//                }else {
//                    world.setBlock(pos, state.with(AGE, age + 1), 4);
//                }
//
//                ForgeHooks.onCropsGrowPost(world, pos, state);
//            }

        }
    }


    private boolean canReedGrowUpwards(WorldView world, BlockPos pos, BlockState state) {
        Type reedType = state.get(REEDS_TYPE);
        if (reedType == Type.ONE || reedType == Type.TWO_TOP){
            BlockPos abovePos = pos.up();
            if (world.getBlockState(abovePos).isAir()){
                return true;
            }

            BlockPos twoAbovePos = abovePos.up();
            if (world.getFluidState(abovePos).getFluid() == Fluids.WATER && world.getBlockState(twoAbovePos).isAir()){
                return true;
            }
        }

        return false;
    }

    private void growReedAbove(ServerWorld world, BlockPos pos, BlockState state) {
        BlockPos abovePos = pos.up();
        BlockState growAboveState = this.getDefaultState().with(WATERLOGGED, world.getFluidState(abovePos).getFluid() == Fluids.WATER);
        Type reedType = state.get(REEDS_TYPE);
        if (reedType == Type.ONE){
            world.setBlockState(pos.up(), growAboveState.with(REEDS_TYPE, Type.TWO_TOP));
        } else if (reedType == Type.TWO_TOP) {
            world.setBlockState(pos.up(), growAboveState.with(REEDS_TYPE, Type.THREE_TOP));
        }

        BlockState updateStateHere = world.getBlockState(pos);
        world.setBlockState(pos, updateStateHere.with(AGE, 0), 4);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return this.canReedGrow && this.canReedGrowUpwards(world, pos, state);
    }

    @Override
    public boolean canGrow(World world, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
        int age = state.get(AGE);
        age += MathHelper.nextInt(rand, 7, 15);
        if (age >= 15){
            this.growReedAbove(world, pos, state);
            int ageRemaining = age - 15;
            if (ageRemaining > 0){
                BlockPos abovePos = pos.up();
                BlockState aboveState = world.getBlockState(abovePos);
                if (this.canReedGrowUpwards(world, abovePos, aboveState)){
                    int aboveAge = aboveState.get(AGE);
                    aboveAge += ageRemaining;
                    world.setBlockState(abovePos, aboveState.with(AGE, aboveAge), 4);
                }
            }
        } else {
            world.setBlockState(pos, state.with(AGE, age), 4);
        }
    }

    public static enum Type implements StringIdentifiable {
        ONE("1"),
        TWO_BOTTOM("2_bottom"),
        TWO_TOP("2_top"),
        THREE_BOTTOM("3_bottom"),
        THREE_MIDDLE("3_middle"),
        THREE_TOP("3_top");

        private final String typeName;

        private Type(String s){
            this.typeName = s;
        }

        @Override
        public String asString() {
            return this.typeName;
        }
    }
}
