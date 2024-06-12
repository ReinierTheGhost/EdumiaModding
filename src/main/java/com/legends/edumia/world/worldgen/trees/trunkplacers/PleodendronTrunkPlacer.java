package com.legends.edumia.world.worldgen.trees.trunkplacers;

import com.legends.edumia.utils.Util;
import com.legends.edumia.world.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public class PleodendronTrunkPlacer extends ExtendedTrunkPlacer{
    public static final Codec<PleodendronTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
        fillTrunkPlacerFields(instance)
                .apply(instance, PleodendronTrunkPlacer::new));


    public PleodendronTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB, Optional.empty(), Optional.empty(), Optional.empty());
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return EdumiaTrunkPlacerTypes.PLEODENDRON_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> trunk, Random random, int height, BlockPos basePos, TreeFeatureConfig config) {
        setToDirt(world, trunk, random, basePos.down(), config);
        List<FoliagePlacer.TreeNode> leafNodes = new ArrayList<>();

        for (int i = 0; i < height; ++i) {
            getAndSetState(world, trunk, random, basePos.up(i), config);
        }

        leafNodes.add(new FoliagePlacer.TreeNode(basePos.up(height + 1), -1, false));

        for (int i = 5; i < height - 4; ++i) {
            if (random.nextInt(4) == 0) {
                growBranches((ModifiableTestableWorld) world, trunk, random, basePos.up(i), config, leafNodes);
            }
        }

        return leafNodes;
    }

    private void growBranches(TestableWorld world, BiConsumer<BlockPos, BlockState> trunk, Random random, BlockPos basePos, TreeFeatureConfig config, List<FoliagePlacer.TreeNode> leafNodes) {
        int count = random.nextInt(2) + 1;
        double thetaOffset = random.nextDouble() * 2 * Math.PI;

        // Place 1-2 branches
        for (int i = 0; i < count; i++) {
            // Get angle of this branch
            double theta = (((double) i / count) * 2 * Math.PI) + thetaOffset;

            // Add a random offset to the theta
            theta += random.nextDouble() * Math.PI * 0.15;

            // Make branches 3-4 blocks long
            int dist = random.nextInt(3) == 0 ? 4 : 3;

            for (int j = 1; j <= dist; j++) {
                int x = (int) (Math.cos(theta) * j);
                int z = (int) (Math.sin(theta) * j);
                BlockPos local = basePos.add(x, 0, z);

                // Get axis based on position
                Direction.Axis axis = Util.getAxisBetween(basePos, local);

                // Place branch and add to logs
                trunk.accept(local, config.trunkProvider.get(random, local).with(PillarBlock.AXIS, axis));

                // Add leaves around the branch
                if (j == dist) {
                    leafNodes.add(new FoliagePlacer.TreeNode(local.up(1), -2, false));
                }
            }
        }
    }
}
