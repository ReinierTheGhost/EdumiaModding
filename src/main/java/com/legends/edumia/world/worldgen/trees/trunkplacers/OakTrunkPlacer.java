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
import java.util.Set;
import java.util.function.BiConsumer;

public class OakTrunkPlacer extends ExtendedTrunkPlacer {
    public static final Codec<OakTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) ->
            baseCodecWithWood(instance).apply(instance, OakTrunkPlacer::new));

    private final boolean isDead = false;

    private final int trunkWidth = 0;

    private final boolean hasRoots = true;
    public OakTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, Optional<BlockStateProvider> woodProvider, Optional<BlockStateProvider> strippedLogProvider, Optional<BlockStateProvider> branchProvider) {
        super(baseHeight, heightRandA, heightRandB, woodProvider, strippedLogProvider, branchProvider);
    }

    public OakTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, BlockState wood, BlockState branch) {
        this(baseHeight, heightRandA, heightRandB, Optional.of(BlockStateProvider.of(wood)), Optional.empty(), Optional.of(BlockStateProvider.of(branch)));
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return EdumiaTrunkPlacerTypes.OAK_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> trunk, Random random, int trunkHeight, BlockPos basePos, TreeFeatureConfig config) {
        this.canReplace(world, basePos.down());
        for (int y = 0; y < trunkHeight; y++)
            this.getAndSetState(world, trunk, random, basePos.up(y), config); //builds the log of the tree

        List<FoliagePlacer.TreeNode> foliage = new ArrayList<>(); //Instance to foliage placer

        addLeafCanopy(world, random, basePos.up(trunkHeight - 1), trunk, foliage, config);
        int roots = 4 + random.nextInt(1);
        for (int l = 0; l < roots; l++) {
            BlockPos.Mutable rootPos = (new BlockPos.Mutable()).set(basePos).move(Direction.UP, 1 + random.nextInt(1));
            int rootLength = 4 + random.nextInt(4);
            Direction rootDir = Direction.Type.HORIZONTAL.random(random);
            rootPos.move(rootDir, 1);
            growRootsDownBranchingOut(world, random, rootPos, rootLength, rootDir, 3, trunk, config);
        }
        return foliage;
    }

    private void addLeafCanopy(TestableWorld world, Random rand, BlockPos pos, BiConsumer<BlockPos, BlockState> trunk, List<FoliagePlacer.TreeNode> foliage, TreeFeatureConfig config) {
        int leafStart = 2;
        int leafTop = leafStart + 3;
        int baseMaxRange = 3;
        int addMaxRange = rand.nextInt(2);
        int maxRange = baseMaxRange + addMaxRange;
        foliage.add(new FoliagePlacer.TreeNode(pos.up(leafTop), addMaxRange, false));
        List<BlockPos> woodPositions = new ArrayList<>();
        for (int l = 0; l <= leafStart; l++) {
            BlockPos layerPos = pos.up(l);
            woodPositions.add(layerPos);
            addLateralOffsets(woodPositions, layerPos, l + 1);
            if (l > 0) {
                addDiagonalOffsets(woodPositions, layerPos, l);
                if (l == leafStart && addMaxRange > 0) {
                    addLateralOffsets(woodPositions, layerPos, l + 2);
                    addDiagonalOffsets(woodPositions, layerPos, l + 1);
                }
            }
        }
        woodPositions.forEach(woodPos -> placeWood(world, rand, woodPos, trunk, config, Direction.Axis.Y));
    }

    private static void addLateralOffsets(List<BlockPos> list, BlockPos midPos, int offset) {
        Direction.Type.HORIZONTAL.forEach(dir -> list.add(midPos.offset(dir, offset)));
    }
    private static void addDiagonalOffsets(List<BlockPos> list, BlockPos midPos, int offset) {
        list.add(midPos.add(-offset, 0, -offset));
        list.add(midPos.add(-offset, 0, offset));
        list.add(midPos.add(offset, 0, -offset));
        list.add(midPos.add(offset, 0, offset));
    }
}
