package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.Optional;

public class ColossalPalmFoliagePlacer extends FoliagePlacer {

    protected final BlockStateProvider nerfProvider;

    public static final Codec<ColossalPalmFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            fillFoliagePlacerFields(instance).and(BlockStateProvider.TYPE_CODEC.fieldOf("nerf_provider").forGetter(
                    nerf -> nerf.nerfProvider)).apply(instance, ColossalPalmFoliagePlacer::new));
    protected ColossalPalmFoliagePlacer(IntProvider radius, IntProvider offset, BlockStateProvider nerfProvider) {
        super(radius, offset);
        this.nerfProvider = nerfProvider;
    }

    public ColossalPalmFoliagePlacer(BlockStateProvider nerfProvider) {
        this(ConstantIntProvider.create(0), ConstantIntProvider.create(0), nerfProvider);

    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.COLOSSAL_PALM_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int radius, int offset) {
        BlockPos pos = foliage.getCenter();

        int leave = random.nextInt(10);
        //north
        generateNerf(world, leaves, pos.add( 0, -1,  -1), random, config);
        generateNerf(world, leaves, pos.add( 0, 0,  -1), random, config);

        generateNerf(world, leaves, pos.add( 0, 1,  -2), random, config);
        generateNerf(world, leaves, pos.add( 0, 2,  -2), random, config);

        generateNerf(world, leaves, pos.add( 0, 2,  -3), random, config);
        generateNerf(world, leaves, pos.add( 0, 3,  -3), random, config);
        generateNerf(world, leaves, pos.add( 0, 4,  -3), random, config);

        generateNerf(world, leaves, pos.add( 0, 5,  -4), random, config);

        generateNerf(world, leaves, pos.add( 0, 6,  -5), random, config);
        generateNerf(world, leaves, pos.add( 0, 6,  -6), random, config);
        generateNerf(world, leaves, pos.add( 0, 6,  -7), random, config);

        generateNerf(world, leaves, pos.add( 0, 7,  -8), random, config);
        generateNerf(world, leaves, pos.add( 0, 7,  -9), random, config);
        generateNerf(world, leaves, pos.add( 0, 7,  -10), random, config);
        generateNerf(world, leaves, pos.add( 0, 7,  -11), random, config);

        generateNerf(world, leaves, pos.add( 0, 8,  -12), random, config);
        generateNerf(world, leaves, pos.add( 0, 8,  -13), random, config);
        generateNerf(world, leaves, pos.add( 0, 8,  -14), random, config);
        generateNerf(world, leaves, pos.add( 0, 8,  -15), random, config);

        generateNerf(world, leaves, pos.add( 0, 9,  -16), random, config);
        generateNerf(world, leaves, pos.add( 0, 9,  -17), random, config);
        generateNerf(world, leaves, pos.add( 0, 9,  -18), random, config);
        generateNerf(world, leaves, pos.add( 0, 9,  -19), random, config);
        generateNerf(world, leaves, pos.add( 0, 9,  -20), random, config);
        generateNerf(world, leaves, pos.add( 0, 9,  -21), random, config);
        generateNerf(world, leaves, pos.add( 0, 9,  -22), random, config);

        generateNerf(world, leaves, pos.add( 0, -2,  -2), random, config);
        generateNerf(world, leaves, pos.add( 0, -2,  -3), random, config);
        generateNerf(world, leaves, pos.add( 2, -2,  -3), random, config);
        generateNerf(world, leaves, pos.add( 0, -2,  -4), random, config);
        generateNerf(world, leaves, pos.add( 1, -2,  -4), random, config);
        generateNerf(world, leaves, pos.add( 0, -2,  -5), random, config);
        generateNerf(world, leaves, pos.add( 0, -2,  -6), random, config);
        generateNerf(world, leaves, pos.add( 0, -2,  -7), random, config);

        generateNerf(world, leaves, pos.add( 0, -1,  -8), random, config);
        generateNerf(world, leaves, pos.add( 0, -1,  -9), random, config);
        generateNerf(world, leaves, pos.add( 0, -1,  -10), random, config);
        generateNerf(world, leaves, pos.add( 0, -1,  -11), random, config);
        generateNerf(world, leaves, pos.add( 0, -1,  -12), random, config);
        generateNerf(world, leaves, pos.add( 0, -1,  -13), random, config);
        generateNerf(world, leaves, pos.add( 0, -1,  -14), random, config);
        generateNerf(world, leaves, pos.add( 0, -1,  -15), random, config);

        generateNerf(world, leaves, pos.add( 0, -2,  -16), random, config);
        generateNerf(world, leaves, pos.add( 0, -2,  -17), random, config);
        generateNerf(world, leaves, pos.add( 0, -2,  -18), random, config);

        generateNerf(world, leaves, pos.add( 0, -3,  -18), random, config);
        generateNerf(world, leaves, pos.add( 0, -3,  -19), random, config);
        generateNerf(world, leaves, pos.add( 0, -3,  -20), random, config);
        generateNerf(world, leaves, pos.add( 0, -3,  -21), random, config);
        generateNerf(world, leaves, pos.add( 0, -3,  -22), random, config);
        generateNerf(world, leaves, pos.add( 0, -3,  -23), random, config);

        generateNerf(world, leaves, pos.add( 0, -4,  -22), random, config);
        generateNerf(world, leaves, pos.add( 0, -4,  -23), random, config);
        generateNerf(world, leaves, pos.add( 0, -4,  -24), random, config);
        generateNerf(world, leaves, pos.add( 0, -4,  -25), random, config);
        generateNerf(world, leaves, pos.add( 0, -4,  -26), random, config);

        generateNerf(world, leaves, pos.add( 0, -5,  -26), random, config);
        generateNerf(world, leaves, pos.add( 0, -5,  -27), random, config);
        generateNerf(world, leaves, pos.add( 0, -5,  -28), random, config);

        generateNerf(world, leaves, pos.add( 0, -6,  -29), random, config);
        generateNerf(world, leaves, pos.add( 0, -6,  -30), random, config);

        //east
        generateLeaf(world, leaves, pos.add( 1, 0,  0), random, config);
        generateLeaf(world, leaves, pos.add( 2, 1,  0), random, config);
        generateLeaf(world, leaves, pos.add( 2, 2,  0), random, config);

        //south
        generateLeaf(world, leaves, pos.add( 0, -3,  2), random, config);
        generateLeaf(world, leaves, pos.add( 0, -4,  2), random, config);
        generateLeaf(world, leaves, pos.add( 0, -5,  2), random, config);
        generateLeaf(world, leaves, pos.add( 0, -3,  3), random, config);


        //west
        generateLeaf(world, leaves, pos.add( -2, -2,  0), random, config);
        generateLeaf(world, leaves, pos.add( -2, -3,  0), random, config);



    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }

    private void generateLeaf(TestableWorld seedReader, BlockPlacer leaves, BlockPos pos, Random random, TreeFeatureConfig config) {
        if (TreeFeature.isAirOrLeaves(seedReader, pos)) {
            leaves.placeBlock(pos, config.foliageProvider.get(random, pos).with(LeavesBlock.PERSISTENT, true));
        }
    }

    private void generateNerf(TestableWorld seedReader, BlockPlacer leaves, BlockPos pos, Random random, TreeFeatureConfig config) {
        if (TreeFeature.isAirOrLeaves(seedReader, pos)) {
            leaves.placeBlock(pos, this.nerfProvider.get(random, pos).with(LeavesBlock.PERSISTENT, true));
        }
    }
}