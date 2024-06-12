package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class CypressFoliagePlacer extends FoliagePlacer {
    public static final Codec<CypressFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
           fillFoliagePlacerFields(instance).and(IntProvider.createValidatingCodec(0, 24).fieldOf("trunk_height").forGetter((foliage) ->
                   foliage.trunkHeightSpread)).apply(instance, CypressFoliagePlacer::new));
    private final IntProvider trunkHeightSpread;

    public CypressFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider trunkHeightSpread) {
        super(radius, offset);
        this.trunkHeightSpread = trunkHeightSpread;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.CYPRESS_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int foliageMaxWidth, int foliageOffset) {
        int topCrossY = foliageOffset - 2;
        int bottomCrossesHighestY = foliageOffset - foliageHeight + random.nextInt(3);
        for (int y = foliageOffset; y >= foliageOffset - foliageHeight; y--) {
            int layerWidth = foliage.getFoliageRadius();
            if (y < topCrossY && y > bottomCrossesHighestY){
                ++layerWidth;
            }

            this.generateSquare(world, leaves, random, config, foliage.getCenter(), layerWidth, y, foliage.isGiantTrunk());
            if (y == topCrossY || y <= bottomCrossesHighestY){
                for (Direction dir : Direction.Type.HORIZONTAL){
                    this.generateSquare(world, leaves, random, config, foliage.getCenter().offset(dir), layerWidth, y, foliage.isGiantTrunk());
                }

            }
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
        return false;
    }
}
