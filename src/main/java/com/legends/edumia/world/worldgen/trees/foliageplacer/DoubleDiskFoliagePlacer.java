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

public class DoubleDiskFoliagePlacer extends FoliagePlacer {
    public static final Codec<DoubleDiskFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillFoliagePlacerFields(instance).apply(instance, DoubleDiskFoliagePlacer::new));
    public DoubleDiskFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.DOUBLE_DISK_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int radius, int offset) {
        boolean flag = foliage.isGiantTrunk();
        BlockPos pos = foliage.getCenter().up(offset);

        generateSquare(world, leaves, random, config, pos, radius + foliage.getFoliageRadius() - 1, -3, flag);
        generateSquare(world, leaves, random, config, pos, radius + foliage.getFoliageRadius(), -1, flag);
        generateSquare(world, leaves, random, config, pos, radius + foliage.getFoliageRadius() - 1, 0, flag);
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        if (y == 0) return (dx > 1 || dz > 1) && dx != 0 && dz != 0;
        return dx == radius && dz == radius && radius > 0;
    }
}
