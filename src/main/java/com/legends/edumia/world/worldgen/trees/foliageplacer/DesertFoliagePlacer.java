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

public class DesertFoliagePlacer extends FoliagePlacer {
    public static final Codec<DesertFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            fillFoliagePlacerFields(instance).and(Codec.intRange(0, 16).fieldOf("foliage_height").forGetter((foliage) ->
                    foliage.foliageHeight)).apply(instance, DesertFoliagePlacer::new));

    private final int foliageHeight;
    public DesertFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.foliageHeight = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.DESERT_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        int leafRangeMin = 0 + treeNode.getFoliageRadius();

        for (int y = offset; y >= offset - foliageHeight; --y){
            int layerWidth = leafRangeMin + 1 - (y + 2) / 2;
            this.generateSquare(world, placer, random, config, treeNode.getCenter(), layerWidth, y, treeNode.isGiantTrunk());
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.foliageHeight;
    }

    @Override
    public int getRandomRadius(Random random, int baseHeight) {
        return super.getRandomRadius(random, baseHeight);
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return dx >= radius && dz >= radius && (y == -1 || random.nextInt(2) == 0);
    }
}
