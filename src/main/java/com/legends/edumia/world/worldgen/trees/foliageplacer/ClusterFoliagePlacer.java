package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ClusterFoliagePlacer extends FoliagePlacer {
    public static final Codec<ClusterFoliagePlacer> CODEC = RecordCodecBuilder.create((instance)->
            fillFoliagePlacerFields(instance).apply(instance, ClusterFoliagePlacer::new));
    public ClusterFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.CLUSTER_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int foliageMaxWidth, int offset) {
        int sphereWidth = foliageMaxWidth + foliage.getFoliageRadius();
        int leafTop = sphereWidth;
        int leafBottom = -sphereWidth;

        for (int y = leafTop; y >= leafBottom; --y){
            this.generateSquare(world, placer, random, config, foliage.getCenter(), sphereWidth, y, foliage.isGiantTrunk());
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    public int getRandomRadius(Random random, int baseHeight) {
        return super.getRandomRadius(random, baseHeight);
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int absX, int layerY, int absZ, int layerWidth, boolean giantTrunk) {
        int dy = layerY;
        int dSq = absX * absX + dy * dy + absZ * absZ;
        if (dSq >= (layerWidth - 1) * (layerWidth - 1))
            return (dSq >= layerWidth * layerWidth || random.nextInt(3) == 0);
        return false;
    }
}
