package com.legends.edumia.world.worldgen.trees.trunkplacers;

import com.google.common.collect.ImmutableList;
import com.legends.edumia.world.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class BirchTrunkPlacer extends TrunkPlacer {
    public static final Codec<BirchTrunkPlacer> CODEC = RecordCodecBuilder.create(pineTrunkPlacerInstance ->
            fillTrunkPlacerFields(pineTrunkPlacerInstance).apply(pineTrunkPlacerInstance, BirchTrunkPlacer::new));

    public BirchTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return EdumiaTrunkPlacerTypes.BIRCH_TREE_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        Direction direction = Direction.Type.HORIZONTAL.random(random);

        setToDirt(world, replacer, random, startPos.down(), config);

        java.util.Random rand = new java.util.Random();

        int branchHeightRange = 5 - 4 + 1;
        int branchHeight =  random.nextInt(branchHeightRange) + 4;

        for(int i = 0; i < height; i++) {
            getAndSetState(world, replacer, random, startPos.up(i), config);

            if (height > 7) {
                if(i % 2 == 0 && random.nextBoolean()) {
                    if(random.nextFloat() > 0.25f) {
                        for (int x = 1; x < 2; x++) {
                            replacer.accept(startPos.up(height - branchHeight).offset(direction, x), ((BlockState)
                                    Function.identity().apply(config.trunkProvider.get(random, startPos).with(PillarBlock.AXIS, direction.getAxis()))));
                        }
                    }
                }
            }
        }

        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(height), 0, false));
    }
}
