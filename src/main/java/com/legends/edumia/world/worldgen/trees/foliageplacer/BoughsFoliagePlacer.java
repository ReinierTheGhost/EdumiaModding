package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.legends.edumia.world.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class BoughsFoliagePlacer extends FoliagePlacer {
    public static final Codec<BoughsFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            fillFoliagePlacerFields(instance).and(Codec.intRange(0, 16).fieldOf("foliage_height").forGetter((foliage) ->
                    foliage.foliageHeight)).apply(instance, BoughsFoliagePlacer::new));
    private final int foliageHeight;

    public BoughsFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.foliageHeight = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.BOUGHS_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight,
                            TreeNode treeNode, int foliageHeight, int radius, int offset) {
        for (int y = foliageHeight; y >= offset - foliageHeight; --y){
            int leafRangeAdd = -2;
            if (y >= -2){
                leafRangeAdd -= y;
            }

            int layerWidth = foliageHeight + leafRangeAdd + treeNode.getFoliageRadius();
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
    protected boolean isInvalidForLeaves(Random random, int absX, int layerY, int absZ, int layerWidth, boolean giantTrunk) {
        int dSq = absX * absX + absZ * absZ;
        int dCh = absX + Math.abs(layerY - -2) + absZ;
        if (dSq < layerWidth * layerWidth && dCh <= 7){
            return (absX == layerWidth - 1 || absZ == layerWidth - 1) && random.nextInt(4) == 0;
        }else {
            return true;
        }
    }
}
