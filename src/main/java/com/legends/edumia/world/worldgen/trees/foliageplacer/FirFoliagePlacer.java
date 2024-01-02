package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class FirFoliagePlacer extends FoliagePlacer {
    public static final Codec<FirFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            fillFoliagePlacerFields(instance).and(IntProvider.createValidatingCodec(0, 24).fieldOf("foliae_height").forGetter((foliage) ->
                    foliage.heightSpread)).apply(instance, FirFoliagePlacer::new));
    private final IntProvider heightSpread;

    public FirFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider heightSpread) {
        super(radius, offset);
        this.heightSpread = heightSpread;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.FIR_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int foliageMaxWidth, int foliageOffset) {
        int baseFoliageWidth = foliage.getFoliageRadius();
        this.generateSquare(world, leaves, random, config, foliage.getCenter(), baseFoliageWidth, foliageOffset, foliage.isGiantTrunk());
        this.generateSquare(world, leaves, random, config, foliage.getCenter(), baseFoliageWidth, foliageOffset - 1, foliage.isGiantTrunk());
        int leafBottom = foliageOffset - foliageHeight;
        int topY = foliageOffset - 2;
        int leafLayers = topY - leafBottom + 1;
        int sections = foliageMaxWidth;
        int sectionHeight = MathHelper.ceil((float) leafLayers / (float) sections);
        int curSectionWidth = 1;
        int curSectionHeight = 0;
        for (int y = topY; y >= leafBottom; y--) {
            this.generateSquare(world, leaves, random, config, foliage.getCenter(), baseFoliageWidth + curSectionWidth, y, foliage.isGiantTrunk());
            curSectionHeight++;
            if (curSectionHeight >= sectionHeight) {
                curSectionWidth++;
                curSectionHeight = 0;
            }
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return Math.min(this.heightSpread.get(random), trunkHeight - 1);
    }

    @Override
    public int getRandomRadius(Random random, int baseHeight) {
        return super.getRandomRadius(random, baseHeight);
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        int taxicab = dx + dz;
        return taxicab > radius && radius > 0;
    }
}
