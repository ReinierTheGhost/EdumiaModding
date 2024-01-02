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

public class OakFoliagePlacer extends FoliagePlacer {
    public static final Codec<OakFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            fillFoliagePlacerFields(instance).and(Codec.intRange(0, 16).fieldOf("foliage_heiht").forGetter((foliage) ->
                    foliage.foliageHeight)
            ).apply(instance, OakFoliagePlacer::new));

    private final int foliageHeight;

    public OakFoliagePlacer(IntProvider radius, IntProvider offset, int foliageHeight) {
        super(radius, offset);
        this.foliageHeight = foliageHeight;
    }


    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.OAK_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int foliageMaxWidth, int foliageOffset) {
        for (int y = foliageOffset; y >= foliageOffset - foliageHeight; y--) {
            int layerWidth = foliageMaxWidth + foliage.getFoliageRadius() - y;
            this.generateSquare(world, leaves, random, config, foliage.getCenter(), layerWidth, y, foliage.isGiantTrunk());
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
    protected boolean isInvalidForLeaves(Random random, int absX, int layerY, int absZ, int layerWidth, boolean bool6) {
        int dSq = absX * absX + absZ * absZ;
        if (dSq > (layerWidth - 1) * (layerWidth - 1))
            return (dSq > layerWidth * layerWidth || random.nextInt(4) == 0);
        return false;
    }
}
