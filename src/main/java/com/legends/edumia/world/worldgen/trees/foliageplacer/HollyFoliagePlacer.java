package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.google.common.math.IntMath;
import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class HollyFoliagePlacer extends FoliagePlacer {
    public static final Codec<HollyFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            fillFoliagePlacerFields(instance).and(IntProvider.createValidatingCodec(0, 24).fieldOf("trunk_height").forGetter((foliage) ->
                    foliage.trunkHeightSpread)).apply(instance, HollyFoliagePlacer::new));

    private final IntProvider trunkHeightSpread;
    public HollyFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider trunkHeightSpread) {
        super(radius, offset);
        this.trunkHeightSpread = trunkHeightSpread;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.HOLLY_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int foliageMaxWidth, int foliageOffset) {
        int layerWidth = 0;
        for (int y = foliageOffset; y >= foliageOffset - foliageHeight; y--) {
            if (y == foliageOffset) {
                layerWidth = 0;
            } else if (y >= foliageOffset - 2 || y == foliageOffset - foliageHeight) {
                layerWidth = 1;
            } else {
                layerWidth = foliageMaxWidth;
            }
            this.generateSquare(world, leaves, random, config, foliage.getCenter(), layerWidth + foliage.getFoliageRadius(), y, foliage.isGiantTrunk());
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return Math.max(4, trunkHeight - this.trunkHeightSpread.get(random));
    }

    @Override
    public int getRandomRadius(Random random, int baseHeight) {
        return super.getRandomRadius(random, baseHeight);
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        if (radius > 0 && IntMath.mod(y, 2) == 1){
            return dx == radius && dz == radius;
        }else{
            return false;
        }
    }
}
