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

public class CitrusFoliagePlacer extends FoliagePlacer {
    public static final Codec<CitrusFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
         fillFoliagePlacerFields(instance).apply(instance, CitrusFoliagePlacer::new));
    public CitrusFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.CITRUS_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        this.generateSquare(world, leaves, random, config, treeNode.getCenter(), 1, 1, treeNode.isGiantTrunk());
        this.generateSquare(world, leaves, random, config, treeNode.getCenter(), 2, 0, treeNode.isGiantTrunk());

        if (treeNode.getFoliageRadius() == 1) {
            // Center leaf cluster, add another layer at the bottom
            this.generateSquare(world, leaves, random, config, treeNode.getCenter(), 3, -1, treeNode.isGiantTrunk());
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return radius != 0 && dx == radius && dz == radius && random.nextInt(2) == 0;
    }
}
