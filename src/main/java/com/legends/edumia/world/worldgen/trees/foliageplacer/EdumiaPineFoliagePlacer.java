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

public class EdumiaPineFoliagePlacer extends FoliagePlacer {
    public static final Codec<EdumiaPineFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            fillFoliagePlacerFields(instance).and(IntProvider.createValidatingCodec(0, 24).fieldOf("foliage_height").forGetter((foliage) ->
                    foliage.heightSpread)
            ).apply(instance, EdumiaPineFoliagePlacer::new));


    private final IntProvider heightSpread;
    public EdumiaPineFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider heightSpread) {
        super(radius, offset);
        this.heightSpread = heightSpread;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.PINE_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int foliageMaxWidth, int foliageOffset) {
        int layerWidth = random.nextInt(2);
        int nextMaxLayerWidth = 1;
        int nextStartingLayerWidth = 0;

        for (int y = foliageOffset; y >= foliageOffset - foliageHeight; --y){
            this.generateSquare(world, leaves, random, config, foliage.getCenter(), layerWidth, y, foliage.isGiantTrunk());
            if (layerWidth >= nextMaxLayerWidth){
                layerWidth = nextStartingLayerWidth;
                nextStartingLayerWidth = 1;
                nextMaxLayerWidth = Math.min(nextMaxLayerWidth + 1, foliageMaxWidth);
            }else{
                ++layerWidth;
            }
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.heightSpread.get(random);
    }

    @Override
    public int getRandomRadius(Random random, int baseHeight) {
        return super.getRandomRadius(random, baseHeight);
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return dx == radius && dz == radius && radius > 0;
    }
}
