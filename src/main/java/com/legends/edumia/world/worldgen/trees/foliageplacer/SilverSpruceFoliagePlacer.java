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

public class SilverSpruceFoliagePlacer extends FoliagePlacer {
    public static final Codec<SilverSpruceFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            fillFoliagePlacerFields(instance).and(IntProvider.createValidatingCodec(0, 24).fieldOf("trunk_height").forGetter((foliage) ->
                    foliage.trunkHeightSpread)
            ).apply(instance, SilverSpruceFoliagePlacer::new));

    private final IntProvider trunkHeightSpread;
    public SilverSpruceFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider trunkHeightSpread) {
        super(radius, offset);
        this.trunkHeightSpread = trunkHeightSpread;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.SILVER_SPRUCE_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int foliageMaxWidth, int foliageOffset) {
        int layerWidth = 0;
        for (int y = foliageOffset; y >= foliageOffset - foliageHeight; y--) {
            if (y >= foliageOffset - 1) {
                layerWidth = 0;
            } else {
                layerWidth++;
                if (layerWidth > foliageMaxWidth)
                    layerWidth = 1;
            }
            this.generateSquare(world, leaves, random, config, foliage.getCenter(), layerWidth + foliage.getFoliageRadius(), y, foliage.isGiantTrunk());
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return Math.max(3, trunkHeight - this.trunkHeightSpread.get(random));
    }

    @Override
    public int getRandomRadius(Random random, int baseHeight) {
        return super.getRandomRadius(random, baseHeight);
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return dx + dz > radius;
    }
}
