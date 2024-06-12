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

public class WillowFoliagePlacer extends FoliagePlacer {
    public static final Codec<WillowFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillFoliagePlacerFields(instance)
                    .apply(instance, WillowFoliagePlacer::new));
    public WillowFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.WILLOW_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int radius, int offset) {
        int i = foliage.isGiantTrunk() ? foliageHeight : 1 + random.nextInt(2);

        for (int j = offset; j >= offset - i; --j) {
            int k = radius + foliage.getFoliageRadius() + 1 - j;
            generateSquareWithHangingLeaves(world, leaves, random, config, foliage.getCenter(), k, j, foliage.isGiantTrunk(), 0.3F, 0.8F);
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 2;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return dx * dx + dz * dz > radius * radius;
    }
}
