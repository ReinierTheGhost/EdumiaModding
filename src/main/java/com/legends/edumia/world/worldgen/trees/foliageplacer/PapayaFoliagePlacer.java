package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class PapayaFoliagePlacer extends FoliagePlacer {
    private static final Direction[] DIRECTIONS = new Direction[] { Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST };
    public static final Codec<PapayaFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
        fillFoliagePlacerFields(instance).apply(instance, PapayaFoliagePlacer::new));
    public PapayaFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.PAPAYA_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        // Top + shape
        this.generateSquare(world, leaves, random, config, treeNode.getCenter(), 1, 1, treeNode.isGiantTrunk());

        BlockPos origin = treeNode.getCenter();
        // Center leaves
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                for (int y = -1; y <= 0; y++) {
                    if (y == -1 && (Math.abs(x) == 1 && Math.abs(z) == 1) && random.nextBoolean()) {
                        continue;
                    }

                    BlockPos local = origin.add(x, y, z);
                    set(world, local, random, config);
                }
            }
        }

        // Arms
        for (Direction direction : DIRECTIONS) {
            set(world, origin.offset(direction, 2), random, config);
            set(world, origin.offset(direction, 3), random, config);
            set(world, origin.offset(direction, 3).down(), random, config);
            set(world, origin.offset(direction, 4).down(), random, config);
        }
    }

    private static void set(TestableWorld world, BlockPos pos, Random random, TreeFeatureConfig config) {
        if (TreeFeature.isAirOrLeaves(world, pos)) {
            ((ModifiableTestableWorld)world).setBlockState(pos, config.foliageProvider.get(random, pos), 19);
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return radius != 0 && dx == radius && dz == radius;
    }
}
