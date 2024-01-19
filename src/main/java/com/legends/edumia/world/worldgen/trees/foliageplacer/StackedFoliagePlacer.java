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

public class StackedFoliagePlacer extends FoliagePlacer {
    public static final Codec<StackedFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillFoliagePlacerFields(instance).and(
                    Codec.intRange(1, 5).fieldOf("stacks").forGetter(placer -> placer.stacks))
            .apply(instance, StackedFoliagePlacer::new));
    private final int stacks;

    public StackedFoliagePlacer(IntProvider radius, IntProvider offset, int stacks) {
        super(radius, offset);
        this.stacks = stacks;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.STACKED_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int radius, int offset) {
        boolean flag = foliage.isGiantTrunk();
        BlockPos blockPos = foliage.getCenter().up(offset);
        int r = radius + foliage.getFoliageRadius();
        int h = -stacks * 4;
        generateSquare(world, leaves, random, config, blockPos, r - 2, h - 1, flag);
        generateSquare(world, leaves, random, config, blockPos, r - 1, h, flag);

        for (int i = 0; i < stacks; i++) {
            int j = -4 * i;
            generateSquare(world, leaves, random, config, blockPos, r, j - 3, flag);
            generateSquare(world, leaves, random, config, blockPos, r, j - 2, flag);
            generateSquare(world, leaves, random, config, blockPos, r, j - 1, flag);
            generateSquare(world, leaves, random, config, blockPos, r - 1, j, flag);
        }

        generateSquare(world, leaves, random, config, blockPos, r - 2, 1, flag);
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return dx + dz > radius || dx > 2 || dz > 2;
    }
}
