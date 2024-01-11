package com.legends.edumia.world.worldgen.trees.trunkplacers;

import com.google.common.collect.ImmutableList;
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

public class DragonBloodTrunkPlacer extends ExtendedTrunkPlacer{
    public static final Codec<DragonBloodTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) ->
            baseCodecWithWood(instance).apply(instance, DragonBloodTrunkPlacer::new));
    public DragonBloodTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, Optional<BlockStateProvider> woodProvider, Optional<BlockStateProvider> strippedLogProvider, Optional<BlockStateProvider> branchProvider) {
        super(baseHeight, heightRandA, heightRandB, woodProvider, strippedLogProvider, branchProvider);
    }

    public DragonBloodTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, BlockState wood, BlockState roots){
        this(baseHeight, heightRandA, heightRandB, Optional.of(BlockStateProvider.of(wood)), Optional.empty(), Optional.of(BlockStateProvider.of(roots)));
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return EdumiaTrunkPlacerTypes.DRAGON_BLOOD_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> trunk, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        setToDirt(world, trunk, random, startPos.down(), config);

        List<FoliagePlacer.TreeNode> foliage = new ArrayList<>();



        for (int i = 0; i <= height; i++){
            getAndSetState(world, trunk, random, startPos.up(i), config);
        }
        addLeafCanopy(world, random, startPos.up(height - 1), trunk, foliage, config);

        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                if (Math.abs(x) != Math.abs(z)) {
                    BlockPos.Mutable rootPos = (new BlockPos.Mutable()).set(startPos, x, random.nextInt(2), z);
                    int rootLength = 4 + random.nextInt(3);
                    this.growRootsDown(world, random, rootPos, rootLength, trunk, config);
                }
            }
        }

        return foliage;
    }

    private void addLeafCanopy(TestableWorld world, Random rand, BlockPos pos, BiConsumer<BlockPos, BlockState> trunk, List<FoliagePlacer.TreeNode> foliage, TreeFeatureConfig config) {
        int leafStart = 2;
        int leafTop = leafStart + 2;
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
                    addLateralOffsets(woodPositions, layerPos, l + 1);
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
