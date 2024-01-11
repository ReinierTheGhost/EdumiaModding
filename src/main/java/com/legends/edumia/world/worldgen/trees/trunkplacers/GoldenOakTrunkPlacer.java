package com.legends.edumia.world.worldgen.trees.trunkplacers;

import com.google.common.collect.ImmutableList;
import com.legends.edumia.world.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;


import java.util.List;
import java.util.function.BiConsumer;

public class GoldenOakTrunkPlacer extends TrunkPlacer {
    public static final Codec<GoldenOakTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) ->
            fillTrunkPlacerFields(instance).apply(instance, GoldenOakTrunkPlacer::new));

    public GoldenOakTrunkPlacer(int height, int heightRandA, int heightRandB) {
        super(height, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return EdumiaTrunkPlacerTypes.GOLDEN_OAK_TRUNK_PLACER;
    }

    /**
     * Randomly places logs in Golden Oak Trees branching out from the center until they reach the edge of the leaves.
     * @param world The {@link TestableWorld}.
     * @param trunk The {@link BiConsumer} of a {@link BlockPos} and {@link BlockState} used for block placement.
     * @param random The {@link Random}.
     * @param trunkHeight The {@link Integer} height of the tree.
     * @param basePos The initial {@link BlockPos} for placement.
     * @param config The {@link TreeFeatureConfig}.
     * @return A {@link List} of {@link FoliagePlacer.TreeNode}s for the tree.
     */
    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> trunk, Random random,
                                                 int trunkHeight, BlockPos basePos, TreeFeatureConfig config) {
        TrunkPlacer.setToDirt(world, trunk, random, basePos.down(), config);
        for (int i = 0; i < trunkHeight; ++i) {
            if (i > 4 && random.nextInt(3) > 0 && i < 9) {
                this.branch(world, random, trunk, basePos.getX(), basePos.getY() + i, basePos.getZ(), i / 4 - 1, config);
            }

            this.getAndSetState(world, trunk, random, basePos.up(i), config);
        }
        return ImmutableList.of(new FoliagePlacer.TreeNode(basePos.up(trunkHeight), 0, false));
    }

    /**
     * Places a branch.
     * @param world The {@link TestableWorld}.
     * @param random The {@link Random}.
     * @param trunk The {@link BiConsumer} of a {@link BlockPos} and {@link BlockState} used for block placement.
     * @param i The x {@link Integer} position.
     * @param j The y {@link Integer} position.
     * @param k The z {@link Integer} position.
     * @param slant The {@link Integer} value for the branch slant.
     * @param config The {@link TreeFeatureConfig}.
     */
    public void branch(TestableWorld world, Random random, BiConsumer<BlockPos, BlockState> trunk, int i, int j, int k, int slant, TreeFeatureConfig config) {
        int directionX = random.nextInt(3) - 1;
        int directionZ = random.nextInt(3) - 1;

        for (int n = 0; n < random.nextInt(2) + 1; ++n) {
            i += directionX;
            j += slant;
            k += directionZ;
            this.getAndSetState(world, trunk, random, new BlockPos(i, j, k), config);
        }
    }
}
