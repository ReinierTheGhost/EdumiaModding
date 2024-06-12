package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class NewPalmFoliagePlacer extends FoliagePlacer {
    public static final Codec<NewPalmFoliagePlacer> CODEC = RecordCodecBuilder.create((placer) ->
            fillFoliagePlacerFields(placer).apply(placer, NewPalmFoliagePlacer::new));
    public NewPalmFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.NEW_PALM_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        BlockPos pos = treeNode.getCenter();

        generateLeaf(world, placer, pos.add(2, -2, 0), random, config);
        generateLeaf(world, placer, pos.add(-2, -2, 0), random, config);
        generateLeaf(world, placer, pos.add(0, -2, 2), random, config);
        generateLeaf(world, placer, pos.add(0, -2, -2), random, config);

        generateLeaf(world, placer, pos.add(2, -1, 0), random, config);
        generateLeaf(world, placer, pos.add(-2, -1, 0), random, config);
        generateLeaf(world, placer, pos.add(0, -1, 2), random, config);
        generateLeaf(world, placer, pos.add(0, -1, -2), random, config);
        generateLeaf(world, placer, pos.add(1, -1, 0), random, config);
        generateLeaf(world, placer, pos.add(-1, -1, 0), random, config);
        generateLeaf(world, placer, pos.add(0, -1, 1), random, config);
        generateLeaf(world, placer, pos.add(0, -1, -1), random, config);

        generateLeaf(world, placer, pos.add(1, 0, 0), random, config);
        generateLeaf(world, placer, pos.add(-1, 0, 0), random, config);
        generateLeaf(world, placer, pos.add(0, 0, 1), random, config);
        generateLeaf(world, placer, pos.add(0, 0, -1), random, config);
        generateLeaf(world, placer, pos.add(1, 0, 1), random, config);
        generateLeaf(world, placer, pos.add(-1, 0, -1), random, config);
        generateLeaf(world, placer, pos.add(-1, 0, 1), random, config);
        generateLeaf(world, placer, pos.add(1, 0, -1), random, config);
        generateLeaf(world, placer, pos.add(2, 0, 2), random, config);
        generateLeaf(world, placer, pos.add(-2, 0, -2), random, config);
        generateLeaf(world, placer, pos.add(2, 0, -2), random, config);
        generateLeaf(world, placer, pos.add(-2, 0, 2), random, config);

        generateLeaf(world, placer, pos.add(2, 1, 2), random, config);
        generateLeaf(world, placer, pos.add(-2, 1, -2), random, config);
        generateLeaf(world, placer, pos.add(-2, 1, 2), random, config);
        generateLeaf(world, placer, pos.add(1, 1, -1), random, config);
        generateLeaf(world, placer, pos.add(-1, 1, 1), random, config);
        generateLeaf(world, placer, pos.add(1, 1, 1), random, config);
        generateLeaf(world, placer, pos.add(-1, 1, -1), random, config);
        generateLeaf(world, placer, pos.add(0, 1, 0), random, config);
        generateLeaf(world, placer, pos.add(-2, 1, 1), random, config);
        generateLeaf(world, placer, pos.add(2, 1, 1), random, config);
        generateLeaf(world, placer, pos.add(-2, 1, -1), random, config);
        generateLeaf(world, placer, pos.add(2, 1, -1), random, config);
        generateLeaf(world, placer, pos.add(-1, 1, 2), random, config);
        generateLeaf(world, placer, pos.add(1, 1, 2), random, config);
        generateLeaf(world, placer, pos.add(-1, 1, -2), random, config);
        generateLeaf(world, placer, pos.add(1, 1, -2), random, config);

        generateLeaf(world, placer, pos.add(1, 2, 1), random, config);
        generateLeaf(world, placer, pos.add(-1, 2, -1), random, config);
        generateLeaf(world, placer, pos.add(-1, 2, 1), random, config);
        generateLeaf(world, placer, pos.add(1, 2, -1), random, config);
    }

    private void generateLeaf(TestableWorld seedReader, BlockPlacer leaves, BlockPos pos, Random random, TreeFeatureConfig config) {
        if (TreeFeature.isAirOrLeaves(seedReader, pos)) {
            leaves.placeBlock(pos, config.foliageProvider.get(random, pos).with(LeavesBlock.PERSISTENT, true));
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}
