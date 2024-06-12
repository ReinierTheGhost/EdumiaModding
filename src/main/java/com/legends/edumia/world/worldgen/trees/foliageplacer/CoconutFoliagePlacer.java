package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class CoconutFoliagePlacer extends FoliagePlacer {
    public static final Codec<CoconutFoliagePlacer> CODEC = RecordCodecBuilder.create((placer) ->
            fillFoliagePlacerFields(placer).apply(placer, CoconutFoliagePlacer::new));

    public CoconutFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }


    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.COCONUT_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int radius, int offset) {
        BlockPos startingPos = foliage.getCenter();

        placeFoliageBlock(world, leaves, random, config, startingPos);

        generateLeaves(Direction.NORTH, startingPos, world, leaves, random, config);
        generateLeaves(Direction.EAST, startingPos, world, leaves, random, config);
        generateLeaves(Direction.SOUTH, startingPos, world, leaves, random, config);
        generateLeaves(Direction.WEST, startingPos, world, leaves, random, config);
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }

    private static void generateLeaves(Direction direction, BlockPos startingPos, TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config) {
        BlockPos.Mutable pos = startingPos.mutableCopy();

        pos.move(direction);
        placeFoliageBlock(world, leaves, random, config, pos);

        if (random.nextInt(2) == 0) {
            if (world.testBlockState(pos.down(), AbstractBlock.AbstractBlockState::isAir)) {
                leaves.placeBlock(pos.down(), Blocks.COCOA.getDefaultState());
            }
        }
        if (random.nextInt(2) == 0) {
            if (world.testBlockState(pos.down().offset(direction.rotateYCounterclockwise()), AbstractBlock.AbstractBlockState::isAir)) {
                leaves.placeBlock(pos.down().offset(direction.rotateYCounterclockwise()), Blocks.COCOA.getDefaultState());
            }
        }

        for (int i = 0; i < 2; i++) {
            pos.move(direction);
            placeFoliageBlock(world, leaves, random, config, pos);
            pos.move(Direction.DOWN);
            placeFoliageBlock(world, leaves, random, config, pos);
        }

        pos.set(startingPos);
        pos.move(direction).move(direction.rotateYCounterclockwise());
        placeFoliageBlock(world, leaves, random, config, pos);
        pos.move(Direction.DOWN).move(direction.rotateYCounterclockwise());
        placeFoliageBlock(world, leaves, random, config, pos);
        pos.move(direction);
        placeFoliageBlock(world, leaves, random, config, pos.offset(direction.rotateYClockwise()));
        for (int i = 0; i < 3; i++) {
            placeFoliageBlock(world, leaves, random, config, pos);
            pos.move(Direction.DOWN);
        }
    }
}