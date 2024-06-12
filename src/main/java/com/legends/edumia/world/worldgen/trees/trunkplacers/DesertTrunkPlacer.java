package com.legends.edumia.world.worldgen.trees.trunkplacers;

import com.legends.edumia.world.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public class DesertTrunkPlacer extends ExtendedTrunkPlacer {
    public static final Codec<DesertTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) ->
            baseCodecWithWood(instance).apply(instance, DesertTrunkPlacer::new));
    protected DesertTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, Optional<BlockStateProvider> woodProvider, Optional<BlockStateProvider> strippedLogProvider, Optional<BlockStateProvider> branchProvider) {
        super(baseHeight, heightRandA, heightRandB, woodProvider, strippedLogProvider, branchProvider);
    }

    public DesertTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, BlockState wood){
        this(baseHeight, heightRandA, heightRandB, Optional.of(BlockStateProvider.of(wood)), Optional.empty(), Optional.empty());
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return EdumiaTrunkPlacerTypes.DESERT_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> trunk, Random random, int trunkHeight, BlockPos basePos, TreeFeatureConfig config) {
        canReplace(world, basePos.down());

        for (int y = 0; y < trunkHeight; ++y){
            getAndSetState(world, trunk, random, basePos.up(y), config);
        }

        List<FoliagePlacer.TreeNode> foliage = new ArrayList<>();
        int trunkTopOffset = 0;
        int branches = 4;
        for (Direction branchDir : Direction.Type.HORIZONTAL) {
            int branchLength = 1 + random.nextInt(3);
            int branchHeight = trunkHeight - trunkTopOffset - 1 - random.nextInt(2);
            BlockPos.Mutable branchPos = (new BlockPos.Mutable()).set(basePos, 0, branchHeight, 0);
            for (int l = 0; l < branchLength; l++) {
                if (random.nextInt(3) != 0){
                    branchPos.move(Direction.UP);
                }

                if (random.nextInt(3) != 0){
                    branchPos.move(branchDir);
                }

                if (!getAndSetState(world, trunk, random, branchPos, config)) {
                    break;
                }
            }
            foliage.add(new FoliagePlacer.TreeNode(branchPos.up(), 0, false));
        }

        return foliage;
    }
}
