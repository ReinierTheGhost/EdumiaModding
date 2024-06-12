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

public class RedwoodFoliagePlacer extends FoliagePlacer {
    public static final Codec<RedwoodFoliagePlacer> CODEC = RecordCodecBuilder.create(instance -> fillFoliagePlacerFields(instance).and(
                    instance.group(IntProvider.createValidatingCodec(0, 15).fieldOf("mid_segments").forGetter(placer -> placer.midSegments),
                            Codec.intRange(1, 3).fieldOf("trunk_width").forGetter(placer -> placer.trunkWidth)))
            .apply(instance, RedwoodFoliagePlacer::new));
    private final IntProvider midSegments;
    private final int trunkWidth;

    public RedwoodFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider midStages, int trunkWidth) {
        super(radius, offset);
        this.midSegments = midStages;
        this.trunkWidth = trunkWidth;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.REDWOOD_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int foliageMaxWidth, int foliageOffset) {
        BlockPos pos = foliage.getCenter();

        if (trunkWidth == 1) createNormal(world, leaves, random, config, pos);
        if (trunkWidth == 2) createMega(world, leaves, random, config, pos);
        if (trunkWidth == 3) createUltra(world, leaves, random, config, pos);
    }

    private void createNormal(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, BlockPos pos) {
        int y = -4;

        generateSquare(world, leaves, random, config, pos, 0, 1, false);
        generateSquare(world, leaves, random, config, pos, 0, 0, false);
        generateSquare(world, leaves, random, config, pos, 1, -1, false);
        generateSquare(world, leaves, random, config, pos, 1, -2, false);

        for (int s = 1; s <= midSegments.get(random); s++) {
            generateSquare(world, leaves, random, config, pos, 1, y, false);
            generateSquare(world, leaves, random, config, pos, 2, y - 1, false);
            y -= 3;
        }

        generateSquare(world, leaves, random, config, pos, 1, y, false);
    }

    private void createMega(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, BlockPos pos) {
        int y = -6;

        generateSquare(world, leaves, random, config, pos, 0, 1, true);
        generateSquare(world, leaves, random, config, pos, 0, 0, true);
        generateSquare(world, leaves, random, config, pos, 1, -1, true);
        generateSquare(world, leaves, random, config, pos, 1, -2, true);
        generateSquare(world, leaves, random, config, pos, 2, -3, true);
        generateSquare(world, leaves, random, config, pos, 1, -4, true);

        for (int s = 1; s <= midSegments.get(random); s++) {
            generateSquare(world, leaves, random, config, pos, 2, y, true);
            generateSquare(world, leaves, random, config, pos, 3, y - 1, true);
            generateSquare(world, leaves, random, config, pos, 1, y - 2, true);
            y -= 4;
        }

        generateSquare(world, leaves, random, config, pos, 1, y, true);
        generateSquare(world, leaves, random, config, pos, 2, y - 1, true);
    }

    private void createUltra(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, BlockPos pos) {
        boolean variant = random.nextBoolean();
        int y = -10;

        generateSquare(world, leaves, random, config, pos, 0, 2, false);
        generateSquare(world, leaves, random, config, pos, 0, 1, false);
        generateSquare(world, leaves, random, config, pos, 1, 0, false);
        generateSquare(world, leaves, random, config, pos, 1, -1, false);
        generateSquare(world, leaves, random, config, pos, 1, -2, false);
        generateSquare(world, leaves, random, config, pos, 2, -3, false);
        generateSquare(world, leaves, random, config, pos, 2, -4, false);
        generateSquare(world, leaves, random, config, pos, variant ? 2 : 3, -5, false);
        generateSquare(world, leaves, random, config, pos, variant ? 3 : 2, -6, false);
        generateSquare(world, leaves, random, config, pos, variant ? 3 : 2, -7, false);
        generateSquare(world, leaves, random, config, pos, variant ? 2 : 3, -8, false);

        for (int s = 1; s <= midSegments.get(random); s++) {
            int i = random.nextInt(2);
            generateSquare(world, leaves, random, config, pos, i + 1, y, false);
            generateSquare(world, leaves, random, config, pos, i + 3, y - 1, false);
            generateSquare(world, leaves, random, config, pos, i + 4, y - 2, false);
            generateSquare(world, leaves, random, config, pos, i + 2 + random.nextInt(2), y - 3, false);
            y -= 5;
        }

        generateSquare(world, leaves, random, config, pos, 3, y, false);
        generateSquare(world, leaves, random, config, pos, 4, y - 1, false);
        generateSquare(world, leaves, random, config, pos, 2, y - 2, false);

        generateSquare(world, leaves, random, config, pos, 2, y - 4, false);
        generateSquare(world, leaves, random, config, pos, 3, y - 5, false);
    }

    @Override
    public int getRandomHeight(Random random, int height, TreeFeatureConfig config) {
        return 2;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int x, int y, int z, int range, boolean large) {
        return x * x + z * z > range * range;
    }
}
