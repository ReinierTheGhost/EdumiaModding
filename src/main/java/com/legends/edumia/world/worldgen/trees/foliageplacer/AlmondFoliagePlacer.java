package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class AlmondFoliagePlacer extends FoliagePlacer {
    public static final Codec<AlmondFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillFoliagePlacerFields(instance).apply(instance, AlmondFoliagePlacer::new));
    protected AlmondFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    public AlmondFoliagePlacer() {
        this(ConstantIntProvider.create(0), ConstantIntProvider.create(0));
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.ALMOND_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config,
                            int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        int leafStart = foliageHeight - 3;
        int leafTop = foliageHeight;
        for (int m = leafStart; m <= leafTop; m++) {
            int leafRange = 0;
            int maxRange = 2;
            int j2 = leafTop - m;
            if (j2 == 0) {
                leafRange = 1;
            } else if (j2 == 1) {
                leafRange = 2;
            } else if (j2 == 2) {
                leafRange = 2;
            } else {
                leafRange = 1;
            }

            this.generateSquare(world, placer, random, config, treeNode.getCenter(), leafRange, m, treeNode.isGiantTrunk());
        }

    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int absX, int y, int absZ, int radius, boolean giantTrunk) {
        int dch = absX + absZ;
        int cornerDCh = radius * 2;

        return dch >= cornerDCh && (y == 0 || y == -3 || y == -2) || dch >= cornerDCh - 1 && (y == -1) ;
    }
}
