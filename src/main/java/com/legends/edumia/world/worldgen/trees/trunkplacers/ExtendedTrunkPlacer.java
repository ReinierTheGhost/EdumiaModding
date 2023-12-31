package com.legends.edumia.world.worldgen.trees.trunkplacers;

import com.legends.edumia.world.worldgen.EdumiaFeatures;
import com.mojang.datafixers.Products;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.TrunkPlacer;

import java.util.Optional;
import java.util.function.BiConsumer;

public abstract class ExtendedTrunkPlacer extends TrunkPlacer {

    protected final Optional<BlockStateProvider> woodProvider;

    protected final Optional<BlockStateProvider> strippedLogProvider;

    protected final Optional<BlockStateProvider> branchProvider;

    protected static <P extends ExtendedTrunkPlacer> Products.P6<RecordCodecBuilder.Mu<P>, Integer, Integer, Integer,
            Optional<BlockStateProvider>, Optional<BlockStateProvider>, Optional<BlockStateProvider>> baseCodecWithWood(
                    RecordCodecBuilder.Instance<P> instance) {
        return fillTrunkPlacerFields(instance).and(instance.group(BlockStateProvider.TYPE_CODEC
                .optionalFieldOf("wood_provider").forGetter(trunk -> trunk.woodProvider), BlockStateProvider.TYPE_CODEC
                .optionalFieldOf("stripped_log_provider").forGetter(trunk -> trunk.strippedLogProvider), BlockStateProvider.TYPE_CODEC
                .optionalFieldOf("branch_provider").forGetter(trunk -> trunk.branchProvider)));
    }
    public ExtendedTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, Optional<BlockStateProvider> woodProvider,
                               Optional<BlockStateProvider> strippedLogProvider, Optional<BlockStateProvider> branchProvider) {
        super(baseHeight, heightRandA, heightRandB);
        this.woodProvider = woodProvider;
        this.strippedLogProvider = strippedLogProvider;
        this.branchProvider = branchProvider;
    }

    /**
     * to place logs with a rotation
     * @param world
     * @param random
     * @param pos
     * @param trunk
     * @param config
     * @param axis
     * @return
     */
    protected boolean placeLogWithAxis(TestableWorld world, Random random, BlockPos pos, BiConsumer<BlockPos, BlockState> trunk,
                                       TreeFeatureConfig config, Direction.Axis axis){
        if (TreeFeature.canReplace(world, pos)){
            BlockState logState = config.trunkProvider.get(random, pos);
            if (logState.contains(PillarBlock.AXIS)){
                logState = logState.with(PillarBlock.AXIS, axis);
            }

            trunk.accept(pos, logState);
            return  true;
        } else {
            return false;
        }
    }

    /**
     * To place wood blocks
     * @param world
     * @param random
     * @param pos
     * @param trunk
     * @param config
     * @param axis
     * @return
     */
    protected boolean placeWood(TestableWorld world, Random random, BlockPos pos, BiConsumer<BlockPos, BlockState> trunk,
                                TreeFeatureConfig config, Direction.Axis axis){
        if (TreeFeature.canReplace(world, pos)){
            BlockState woodState = (this.woodProvider.orElseThrow(() -> {
                return  new IllegalStateException("Wood blockstate provider is not set!");
            })).get(random, pos);
            if (woodState.contains(PillarBlock.AXIS)){
                woodState = woodState.with(PillarBlock.AXIS, axis);
            }

            trunk.accept(pos, woodState);
            return true;
        } else{
            return false;
        }
    }

    /**
     * To place stripped logs
     * @param world
     * @param random
     * @param pos
     * @param trunk
     * @param config
     * @param axis
     * @return
     */

    protected boolean placeStrippedLog(TestableWorld world, Random random, BlockPos pos, BiConsumer<BlockPos, BlockState> trunk,
                                TreeFeatureConfig config, Direction.Axis axis){
        if (TreeFeature.canReplace(world, pos)){
            BlockState strippedLogState = (this.strippedLogProvider.orElseThrow(() -> {
                return  new IllegalStateException("Stripped log blockstate provider is not set!");
            })).get(random, pos);
            if (strippedLogState.contains(PillarBlock.AXIS)){
                strippedLogState = strippedLogState.with(PillarBlock.AXIS, axis);
            }

            trunk.accept(pos, strippedLogState);
            return true;
        } else{
            return false;
        }
    }

    protected boolean placeBranch(TestableWorld world, Random random, BlockPos pos, BiConsumer<BlockPos, BlockState> trunk,
                                       TreeFeatureConfig config){
        if (TreeFeature.canReplace(world, pos)){
            BlockState branchState = (this.branchProvider.orElseThrow(() -> {
                return  new IllegalStateException("Branch blockstate provider is not set!");
            })).get(random, pos);
            if (branchState.contains(Properties.WATERLOGGED)){
                branchState = branchState.with(Properties.WATERLOGGED, world.testBlockState(pos, (state) ->{
                    return state.getFluidState().getFluid() == Fluids.WATER;
                }));
            }

            WorldAccess worldProper;
            if (world instanceof WorldAccess){
                worldProper = (WorldAccess) world;
                branchState = EdumiaFeatures.getBlockStateInContext(branchState, worldProper, pos);
            }

            trunk.accept(pos, branchState);
            if (world instanceof WorldAccess){
                worldProper = (WorldAccess) world;
                this.updateNeighboursAfterGeneration(worldProper, pos);
            }

            return true;
        } else{
            return false;
        }
    }

    /**
     * to let roots grow downwards in to the ground
     * This method is a cut down of
     * {@linkplain #growRootsDownBranchingOut(TestableWorld, Random, BlockPos.Mutable, int, Direction, int, BiConsumer, TreeFeatureConfig)}
     * @param world
     * @param random
     * @param rootPos
     * @param rootLength
     * @param trunk
     * @param config
     */
    protected void growRootsDown(TestableWorld world, Random random, BlockPos.Mutable rootPos, int rootLength,
                                 BiConsumer<BlockPos, BlockState> trunk, TreeFeatureConfig config){
        this.growRootsDownBranchingOut(world, random, rootPos, rootLength, (Direction) null, 0, trunk, config);
    }

    /**
     * This Method is used to let roots grown down and branch outwards
     * @param world
     * @param random
     * @param rootPos
     * @param rootLength
     * @param outwardsDir
     * @param outwardsInterval
     * @param trunk
     * @param config
     */
    protected void growRootsDownBranchingOut(TestableWorld world, Random random, BlockPos.Mutable rootPos, int rootLength,
                                             Direction outwardsDir, int outwardsInterval,
                                             BiConsumer<BlockPos, BlockState> trunk, TreeFeatureConfig config){
        int roots = 0;
        int outwardsStartAt = outwardsInterval > 0 ? random.nextInt(outwardsInterval) : 0;

        while (rootPos.getY() >= 0 && TreeFeature.canReplace(world, rootPos) && this.placeBranch(world, random, rootPos, trunk, config)){
            if (outwardsDir != null && outwardsInterval > 0 && roots %  outwardsInterval == outwardsStartAt){
                rootPos.move(outwardsDir);
            }else {
                rootPos.move(Direction.DOWN);
            }

            ++roots;
            if (roots > rootLength){
                break;
            }
        }
    }

    /**
     *
     * @param world
     * @param random
     * @param rootPos
     * @param rootLength
     * @param outwardsDir
     * @param maxOut
     * @param trunk
     * @param config
     */
    protected void growRootsDownAndThanOut(TestableWorld world, Random random, BlockPos.Mutable rootPos, int rootLength,
                                             Direction outwardsDir, int maxOut,
                                             BiConsumer<BlockPos, BlockState> trunk, TreeFeatureConfig config){
        int roots = 0;
        int numOut = 0;

        while (rootPos.getY() >= 0 && TreeFeature.canReplace(world, rootPos) && this.placeBranch(world, random, rootPos, trunk, config)){
            if (world.testBlockState(rootPos.down(), AbstractBlock.AbstractBlockState::isOpaque)){
                rootPos.move(outwardsDir);
                ++numOut;
                if (numOut > maxOut){
                    break;

                }
            }else{
                rootPos.move(Direction.DOWN);
            }

            ++roots;
            if (roots > rootLength){
                break;
            }
        }

    }


    private void updateNeighboursAfterGeneration(WorldAccess world, BlockPos pos){
        Direction[] var3 = Direction.values();
        int var4 = var3.length;

        for (int var5 = 0; var5 < var4; ++var5){
            Direction dir = var3[var5];
            BlockPos adjacentPos = pos.offset(dir);
            BlockState state = world.getBlockState(adjacentPos);
            BlockState updateShape = EdumiaFeatures.getBlockStateInContext(state, world, adjacentPos);
            world.setBlockState(adjacentPos, updateShape, 19);
        }
    }
}
