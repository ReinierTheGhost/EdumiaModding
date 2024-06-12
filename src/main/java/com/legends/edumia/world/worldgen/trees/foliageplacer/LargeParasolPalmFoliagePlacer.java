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

public class LargeParasolPalmFoliagePlacer extends FoliagePlacer {

    public static final Codec<LargeParasolPalmFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            fillFoliagePlacerFields(instance).apply(instance, LargeParasolPalmFoliagePlacer::new));
    protected LargeParasolPalmFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    public LargeParasolPalmFoliagePlacer() {
        this(ConstantIntProvider.create(0), ConstantIntProvider.create(0));
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.LARGE_PARASOL_PALM_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int radius, int offset) {
        BlockPos pos = foliage.getCenter();

        generateLeaf(world, leaves, pos.add( 0, -1,  -7), random, config);
        generateLeaf(world, leaves, pos.add( -1, -1,  -6), random, config);
        generateLeaf(world, leaves, pos.add( 1, -1,  -6), random, config);
        generateLeaf(world, leaves, pos.add( -5, -1,  -5), random, config);
        generateLeaf(world, leaves, pos.add( 5, -1,  -5), random, config);
        generateLeaf(world, leaves, pos.add( -6, -1,  -1), random, config);
        //placeLog(world, leaves, pos.add( 0, 1,  -1), random, config);
        generateLeaf(world, leaves, pos.add( 6, -1,  -1), random, config);
        generateLeaf(world, leaves, pos.add( -7, -1,  0), random, config);
        //placeLog(world, leaves, pos.add( -1, 1,  0), random, config);
        //placeLog(world, leaves, pos.add( 0, 1,  0), random, config);
        //placeLog(world, leaves, pos.add( 1, 1,  0), random, config);
        generateLeaf(world, leaves, pos.add(  7, -1,  0), random, config);
        generateLeaf(world, leaves, pos.add(  -6, -1,  1), random, config);
        //placeLog(world, leaves, pos.add( i + 0, 1,  1), random, config);
        generateLeaf(world, leaves, pos.add( 6, -1,  1), random, config);
        generateLeaf(world, leaves, pos.add( -5, -1,  5), random, config);
        generateLeaf(world, leaves, pos.add( 5, -1,  5), random, config);
        generateLeaf(world, leaves, pos.add( -1, -1,  6), random, config);
        generateLeaf(world, leaves, pos.add( 1, -1,  6), random, config);
        generateLeaf(world, leaves, pos.add( 0, -1,  7), random, config);
        generateLeaf(world, leaves, pos.add( 0, 0,  -6), random, config);
        generateLeaf(world, leaves, pos.add( -4, 0,  -5), random, config);
        generateLeaf(world, leaves, pos.add( -1, 0,  -5), random, config);
        generateLeaf(world, leaves, pos.add( 1, 0,  -5), random, config);
        generateLeaf(world, leaves, pos.add( 4, 0,  -5), random, config);
        generateLeaf(world, leaves, pos.add( -5, 0,  -4), random, config);
        generateLeaf(world, leaves, pos.add( -3, 0,  -4), random, config);
        generateLeaf(world, leaves, pos.add( -1, 0,  -4), random, config);
        generateLeaf(world, leaves, pos.add( 1, 0,  -4), random, config);
        generateLeaf(world, leaves, pos.add( 3, 0,  -4), random, config);
        generateLeaf(world, leaves, pos.add( 5, 0,  -4), random, config);
        generateLeaf(world, leaves, pos.add( -4, 0,  -3), random, config);
        generateLeaf(world, leaves, pos.add( -2, 0,  -3), random, config);
        generateLeaf(world, leaves, pos.add( -1, 0,  -3), random, config);
        generateLeaf(world, leaves, pos.add( 1, 0,  -3), random, config);
        generateLeaf(world, leaves, pos.add( 2, 0,  -3), random, config);
        generateLeaf(world, leaves, pos.add( 4, 0,  -3), random, config);
        generateLeaf(world, leaves, pos.add( -3, 0,  -2), random, config);
        generateLeaf(world, leaves, pos.add( -1, 0,  -2), random, config);
        generateLeaf(world, leaves, pos.add( 1, 0,  -2), random, config);
        generateLeaf(world, leaves, pos.add( 3, 0,  -2), random, config);
        generateLeaf(world, leaves, pos.add( -5, 0,  -1), random, config);
        generateLeaf(world, leaves, pos.add( -4, 0,  -1), random, config);
        generateLeaf(world, leaves, pos.add( -3, 0,  -1), random, config);
        generateLeaf(world, leaves, pos.add( -2, 0,  -1), random, config);
        generateLeaf(world, leaves, pos.add( -1, 0,  -1), random, config);
        generateLeaf(world, leaves, pos.add( 0, 0,  -1), random, config);
        generateLeaf(world, leaves, pos.add( 1, 0,  -1), random, config);
        generateLeaf(world, leaves, pos.add( 2, 0,  -1), random, config);
        generateLeaf(world, leaves, pos.add( 3, 0,  -1), random, config);
        generateLeaf(world, leaves, pos.add( 4, 0,  -1), random, config);
        generateLeaf(world, leaves, pos.add( 5, 0,  -1), random, config);
        generateLeaf(world, leaves, pos.add( -6, 0,  0), random, config);
        generateLeaf(world, leaves, pos.add( -1, 0,  0), random, config);
        generateLeaf(world, leaves, pos.add( 0, 0,  0), random, config);
        generateLeaf(world, leaves, pos.add( 1, 0,  0), random, config);
        generateLeaf(world, leaves, pos.add( 6, 0,  0), random, config);
        generateLeaf(world, leaves, pos.add( -5, 0,  1), random, config);
        generateLeaf(world, leaves, pos.add( -4, 0,  1), random, config);
        generateLeaf(world, leaves, pos.add( -3, 0,  1), random, config);
        generateLeaf(world, leaves, pos.add( -2, 0,  1), random, config);
        generateLeaf(world, leaves, pos.add( -1, 0,  1), random, config);
        generateLeaf(world, leaves, pos.add( 0, 0,  1), random, config);
        generateLeaf(world, leaves, pos.add( 1, 0,  1), random, config);
        generateLeaf(world, leaves, pos.add( 2, 0,  1), random, config);
        generateLeaf(world, leaves, pos.add( 3, 0,  1), random, config);
        generateLeaf(world, leaves, pos.add( 4, 0,  1), random, config);
        generateLeaf(world, leaves, pos.add( 5, 0,  1), random, config);
        generateLeaf(world, leaves, pos.add( -3, 0,  2), random, config);
        generateLeaf(world, leaves, pos.add( -1, 0,  2), random, config);
        generateLeaf(world, leaves, pos.add( 1, 0,  2), random, config);
        generateLeaf(world, leaves, pos.add( 3, 0,  2), random, config);
        generateLeaf(world, leaves, pos.add( -4, 0,  3), random, config);
        generateLeaf(world, leaves, pos.add( -2, 0,  3), random, config);
        generateLeaf(world, leaves, pos.add( -1, 0,  3), random, config);
        generateLeaf(world, leaves, pos.add( 1, 0,  3), random, config);
        generateLeaf(world, leaves, pos.add( 2, 0,  3), random, config);
        generateLeaf(world, leaves, pos.add( 4, 0,  3), random, config);
        generateLeaf(world, leaves, pos.add( -5, 0,  4), random, config);
        generateLeaf(world, leaves, pos.add( -3, 0,  4), random, config);
        generateLeaf(world, leaves, pos.add( -1, 0,  4), random, config);
        generateLeaf(world, leaves, pos.add( 1, 0,  4), random, config);
        generateLeaf(world, leaves, pos.add( 3, 0,  4), random, config);
        generateLeaf(world, leaves, pos.add( 5, 0,  4), random, config);
        generateLeaf(world, leaves, pos.add( -4, 0,  5), random, config);
        generateLeaf(world, leaves, pos.add( -1, 0,  5), random, config);
        generateLeaf(world, leaves, pos.add( 1, 0,  5), random, config);
        generateLeaf(world, leaves, pos.add( 4, 0,  5), random, config);
        generateLeaf(world, leaves, pos.add( 0, 0,  6), random, config);
        generateLeaf(world, leaves, pos.add( 0, 1,  -5), random, config);
        generateLeaf(world, leaves, pos.add( -4, 1,  -4), random, config);
        generateLeaf(world, leaves, pos.add( 0, 1,  -4), random, config);
        generateLeaf(world, leaves, pos.add( 4, 1,  -4), random, config);
        generateLeaf(world, leaves, pos.add( -3, 1,  -3), random, config);
        generateLeaf(world, leaves, pos.add( 0, 1,  -3), random, config);
        generateLeaf(world, leaves, pos.add( 3, 1,  -3), random, config);
        generateLeaf(world, leaves, pos.add( -2, 1,  -2), random, config);
        generateLeaf(world, leaves, pos.add( 0, 1,  -2), random, config);
        generateLeaf(world, leaves, pos.add( 2, 1,  -2), random, config);
        generateLeaf(world, leaves, pos.add( -1, 1,  -1), random, config);
        generateLeaf(world, leaves, pos.add( 0, 1,  -1), random, config);
        generateLeaf(world, leaves, pos.add( 1, 1,  -1), random, config);
        generateLeaf(world, leaves, pos.add( -5, 1,  0), random, config);
        generateLeaf(world, leaves, pos.add( -4, 1,  0), random, config);
        generateLeaf(world, leaves, pos.add( -3, 1,  0), random, config);
        generateLeaf(world, leaves, pos.add( -2, 1,  0), random, config);
        generateLeaf(world, leaves, pos.add( -1, 1,  0), random, config);
        generateLeaf(world, leaves, pos.add( 1, 1,  0), random, config);
        generateLeaf(world, leaves, pos.add( 2, 1,  0), random, config);
        generateLeaf(world, leaves, pos.add( 3, 1,  0), random, config);
        generateLeaf(world, leaves, pos.add( 4, 1,  0), random, config);
        generateLeaf(world, leaves, pos.add( 5, 1,  0), random, config);
        generateLeaf(world, leaves, pos.add( -1, 1,  1), random, config);
        generateLeaf(world, leaves, pos.add( 0, 1,  1), random, config);
        generateLeaf(world, leaves, pos.add( 1, 1,  1), random, config);
        generateLeaf(world, leaves, pos.add( -2, 1,  2), random, config);
        generateLeaf(world, leaves, pos.add( 0, 1,  2), random, config);
        generateLeaf(world, leaves, pos.add( 2, 1,  2), random, config);
        generateLeaf(world, leaves, pos.add( -3, 1,  3), random, config);
        generateLeaf(world, leaves, pos.add( 0, 1,  3), random, config);
        generateLeaf(world, leaves, pos.add( 3, 1,  3), random, config);
        generateLeaf(world, leaves, pos.add( -4, 1,  4), random, config);
        generateLeaf(world, leaves, pos.add( 0, 1,  4), random, config);
        generateLeaf(world, leaves, pos.add( 4, 1,  4), random, config);
        generateLeaf(world, leaves, pos.add( 0, 1,  5), random, config);

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
}
