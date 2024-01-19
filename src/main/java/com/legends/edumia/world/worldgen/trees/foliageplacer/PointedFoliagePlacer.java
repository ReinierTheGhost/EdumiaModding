package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class PointedFoliagePlacer extends FoliagePlacer {
    public static final Codec<PointedFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillFoliagePlacerFields(instance).and(
                    Codec.BOOL.fieldOf("tall").forGetter(placer -> placer.tall))
            .apply(instance, PointedFoliagePlacer::new));
    private final boolean tall;

    public PointedFoliagePlacer(IntProvider radius, IntProvider offset, boolean tall) {
        super(radius, offset);
        this.tall = tall;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.POINTED_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int radius, int offset) {
        BlockPos pos = foliage.getCenter();

        if (tall) {
            generateSquare(world, leaves, random, config, pos, 0, 3, false);
            generateSquare(world, leaves, random, config, pos, 0, 2, false);
            generateSquare(world, leaves, random, config, pos, 0, 1, false);
            generateSquare(world, leaves, random, config, pos, 1, 0, false);
            generateSquare(world, leaves, random, config, pos, 1, -1, false);
            generateSquare(world, leaves, random, config, pos, 1, -2, false);
            generateSquare(world, leaves, random, config, pos, 1, -3, false);
            generateSquare(world, leaves, random, config, pos, 2, -4, false);
            generateSquare(world, leaves, random, config, pos, 2, -5, false);
            generateSquare(world, leaves, random, config, pos, 2, -6, false);
            generateSquare(world, leaves, random, config, pos, 2, -7, false);
            generateSquare(world, leaves, random, config, pos, 1, -8, false);
            generateSquare(world, leaves, random, config, pos, 1, -9, false);
            generateSquare(world, leaves, random, config, pos, 1, -10, false);
        } else {
            if (random.nextBoolean()) generateSquare(world, leaves, random, config, pos, 0, 2, false);
            generateSquare(world, leaves, random, config, pos, 0, 1, false);
            generateSquare(world, leaves, random, config, pos, 1, 0, false);
            generateSquare(world, leaves, random, config, pos, 1, -1, false);
            generateSquare(world, leaves, random, config, pos, 2, -2, false);
            generateSquare(world, leaves, random, config, pos, 2, -3, false);
            generateSquare(world, leaves, random, config, pos, 2, -4, false);
            generateSquare(world, leaves, random, config, pos, 1, -5, false);
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return tall ? 4 : 2;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        if (tall && (y == -3 || y == -8)) return false;
        return dx * dx + dz * dz > radius * radius;
    }
}
