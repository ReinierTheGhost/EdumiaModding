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

public class GhostGumFoliagePlacer extends FoliagePlacer {
    public static final Codec<GhostGumFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
                fillFoliagePlacerFields(instance).and(Codec.intRange(0, 16).fieldOf("height")
                        .forGetter((foliage) -> foliage.foliageHeight
                        )).apply(instance, GhostGumFoliagePlacer::new));

    private final int foliageHeight;


    public GhostGumFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.foliageHeight = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.GHOST_GUM_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight,
                            TreeNode treeNode, int foliageHeight, int radius, int offset) {
        for (int y = offset; y >= offset - foliageHeight; --y){
            int foliageExtraWidth = treeNode.getFoliageRadius();
            int layerWidth = radius + foliageExtraWidth -1;
            if (y > offset - foliageHeight){
                layerWidth -= y /2;
            }

            layerWidth = Math.max(layerWidth, 0);
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
    protected boolean isInvalidForLeaves(Random random, int absX, int layerY, int absZ, int radius, boolean giantTrunk) {
        int dch = absX + absZ;
        int cornerDCh = radius * 2;

        return dch >= cornerDCh || dch >= cornerDCh - 1 && (random.nextInt(3) == 0 || layerY == 0);
    }
}
