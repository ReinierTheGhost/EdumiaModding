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

public class OliveFoliagePlacer extends FoliagePlacer {
    public static final Codec<OliveFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillFoliagePlacerFields(instance).apply(instance, OliveFoliagePlacer::new));
    public OliveFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.OLIVE_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        int leafStart = foliageHeight - (2 + random.nextInt(2));
        int leafTop = foliageHeight;

        for (int m = leafStart; m <= leafTop; m++) {
            int leafRange = 0;
            if (m == leafTop) {
                leafRange = 2;
            } else if (m == leafStart) {
                leafRange = 1;
            } else {
                leafRange = 3;
            }

            this.generateSquare(world, placer, random, config, treeNode.getCenter(), leafRange, m, treeNode.isGiantTrunk());
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        int dch = dx + dz;
        int cornerDCh = radius * 2;
       return random.nextInt(3) == 0 && (radius == dx || radius == dz) ||
               dch >= cornerDCh - 1 && (dx == 3 || dz == 3 || dx == -3 || dz == -3);
    }
}
