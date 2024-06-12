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

public class ParasolPalmFoliagePlacer extends FoliagePlacer {

    public static final Codec<ParasolPalmFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            fillFoliagePlacerFields(instance).apply(instance, ParasolPalmFoliagePlacer::new));
    protected ParasolPalmFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    public ParasolPalmFoliagePlacer() {
        this(ConstantIntProvider.create(0), ConstantIntProvider.create(0));
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.PARASOL_PALM_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int radius, int offset) {
        BlockPos pos = foliage.getCenter();
        
        generateLeaf(world, leaves, pos.add(0, 0, 0), random, config);
        generateLeaf(world, leaves, pos.add(0, -1,  1), random, config);
        generateLeaf(world, leaves, pos.add(0, -1,  2), random, config);
        generateLeaf(world, leaves, pos.add(0, -1,  3), random, config);
        generateLeaf(world, leaves, pos.add(0, -2,  4), random, config);
        generateLeaf(world, leaves, pos.add(1, -1, 0), random, config);
        generateLeaf(world, leaves, pos.add(2, -1, 0), random, config);
        generateLeaf(world, leaves, pos.add(3, -1, 0), random, config);
        generateLeaf(world, leaves, pos.add( 4, -2, 0), random, config);
        generateLeaf(world, leaves, pos.add(0, -1, -1), random, config);
        generateLeaf(world, leaves, pos.add(0, -1, -2), random, config);
        generateLeaf(world, leaves, pos.add(0, -1, -3), random, config);
        generateLeaf(world, leaves, pos.add(0, -2, -4), random, config);
        generateLeaf(world, leaves, pos.add(-1, -1, 0), random, config);
        generateLeaf(world, leaves, pos.add(-1, -1, -1), random, config);
        generateLeaf(world, leaves, pos.add(-1, -1,  1), random, config);
        generateLeaf(world, leaves, pos.add(1, -1, -1), random, config);
        generateLeaf(world, leaves, pos.add(1, -1,  1), random, config);
        generateLeaf(world, leaves, pos.add(-2, -1, 0), random, config);
        generateLeaf(world, leaves, pos.add(-3, -1, 0), random, config);
        generateLeaf(world, leaves, pos.add(-4, -2, 0), random, config);
        generateLeaf(world, leaves, pos.add(2, -1,  2), random, config);
        generateLeaf(world, leaves, pos.add(2, -1, -2), random, config);
        generateLeaf(world, leaves, pos.add(-2, -1,  2), random, config);
        generateLeaf(world, leaves, pos.add(-2, -1, -2), random, config);
        generateLeaf(world, leaves, pos.add(3, -2,  3), random, config);
        generateLeaf(world, leaves, pos.add(3, -2, -3), random, config);
        generateLeaf(world, leaves, pos.add(-3, -2,  3), random, config);
        generateLeaf(world, leaves, pos.add(-3, -2, -3), random, config);
        
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
