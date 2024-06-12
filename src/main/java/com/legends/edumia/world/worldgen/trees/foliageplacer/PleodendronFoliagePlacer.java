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

public class PleodendronFoliagePlacer extends FoliagePlacer {
    public static final Codec<PleodendronFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
        fillFoliagePlacerFields(instance)
                .and(Codec.intRange(0, 16).fieldOf("height").forGetter((placer) -> placer.height))
                .apply(instance, PleodendronFoliagePlacer::new));
    protected final int height;

    public PleodendronFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.PLEODENDRON_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int radius, int offset) {
        int i = foliage.isGiantTrunk() ? offset : 2;

        for(int j = offset; j >= offset - i; --j) {
            int k = foliageHeight + foliage.getFoliageRadius() + 1 - j;
            this.generateSquare(world, leaves, random, config, foliage.getCenter(), k, j, foliage.isGiantTrunk());
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        if (dx + dz >= 7) {
            return true;
        } else {
            return dx * dx + dz * dz > radius * radius;
        }
    }
}
