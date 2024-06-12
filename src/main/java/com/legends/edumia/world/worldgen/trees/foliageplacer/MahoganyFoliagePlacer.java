package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class MahoganyFoliagePlacer extends FoliagePlacer {
    public static final Codec<MahoganyFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            fillFoliagePlacerFields(instance).and(Codec.intRange(0, 16).fieldOf("foliage_height").forGetter((foliage) ->
                    foliage.foliageHeight)).apply(instance, MahoganyFoliagePlacer::new));
    private final int foliageHeight;

    public MahoganyFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.foliageHeight = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.MAHOGANY_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight,
                            TreeNode treeNode, int foliageHeight, int radius, int offset) {
        int leafTop = offset;
        int leafBottom = offset - foliageHeight - treeNode.getFoliageRadius();

        for (int y = leafTop; y >= leafBottom; --y){
            int layerWidth = radius + treeNode.getFoliageRadius() - y;
            this.generateSquareWithHangingLeaves(world, placer, random, config, treeNode.getCenter(), layerWidth, y, treeNode.isGiantTrunk(), 50.0f, 45.0f);
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
    protected boolean isInvalidForLeaves(Random random, int absX, int layerY, int absZ, int layerWidth, boolean giantTrunk) {
        int dSq = absX * absX + absZ * absZ;
        return dSq > layerWidth * layerWidth;
    }


}
