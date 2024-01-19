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

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public class ColossalTrunkPlacer extends ExtendedTrunkPlacer{
    public static final Codec<ColossalTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(Codec.intRange(0, 60).fieldOf("base_height").forGetter(placer -> placer.baseHeight),
                            Codec.intRange(0, 24).fieldOf("height_rand_a").forGetter(placer -> placer.heightRandA),
                            Codec.intRange(0, 24).fieldOf("height_rand_b").forGetter(placer -> placer.heightRandB))
                    .apply(instance, ColossalTrunkPlacer::new));
    protected final int baseHeight;
    protected final int heightRandA;
    protected final int heightRandB;
    public ColossalTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB, Optional.empty(), Optional.empty(), Optional.empty());
        this.baseHeight = baseHeight;
        this.heightRandA = heightRandA;
        this.heightRandB = heightRandB;
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return EdumiaTrunkPlacerTypes.COLOSSAL_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> trunk, Random random, int height, BlockPos basePos, TreeFeatureConfig config) {
        for (int i = 1; i <= 2; i++) {
            BlockPos dirtPos = basePos.offset(Direction.DOWN, i);
            setToDirt(world, trunk, random, dirtPos, config);
            setToDirt(world, trunk, random, dirtPos.east(), config);
            setToDirt(world, trunk, random, dirtPos.east().east(), config);
            setToDirt(world, trunk, random, dirtPos.south(), config);
            setToDirt(world, trunk, random, dirtPos.south().east(), config);
            setToDirt(world, trunk, random, dirtPos.south().east().east(), config);
            setToDirt(world, trunk, random, dirtPos.south().south(), config);
            setToDirt(world, trunk, random, dirtPos.south().south().east(), config);
            setToDirt(world, trunk, random, dirtPos.south().south().east().east(), config);
            setToDirt(world, trunk, random, dirtPos.south().west(), config);
            setToDirt(world, trunk, random, dirtPos.north().east(), config);
            setToDirt(world, trunk, random, dirtPos.south().south().south().east(), config);
            setToDirt(world, trunk, random, dirtPos.south().east().east().east(), config);
        }
        BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable();

        int root = 3 + random.nextInt(5);
        int base = root + 4 + random.nextInt(5);
        int top = 3 + random.nextInt(3);
        for (int i = 0; i < height; ++i) {
            if (i < root) {
                placeLogIfFreeWithOffset(world, trunk, random, mutableBlockPos, config, basePos, 1, i, -1);
                placeLogIfFreeWithOffset(world, trunk, random, mutableBlockPos, config, basePos, -1, i, 1);
                placeLogIfFreeWithOffset(world, trunk, random, mutableBlockPos, config, basePos, 1, i, 3);
                placeLogIfFreeWithOffset(world, trunk, random, mutableBlockPos, config, basePos, 3, i, 1);
            }
            if (i < base) {
                placeLogIfFreeWithOffset(world, trunk, random, mutableBlockPos, config, basePos, 0, i, 0);
                placeLogIfFreeWithOffset(world, trunk, random, mutableBlockPos, config, basePos, 2, i, 0);
                placeLogIfFreeWithOffset(world, trunk, random, mutableBlockPos, config, basePos, 0, i, 2);
                placeLogIfFreeWithOffset(world, trunk, random, mutableBlockPos, config, basePos, 2, i, 2);
            }
            if (i < height - top) {
                placeLogIfFreeWithOffset(world, trunk, random, mutableBlockPos, config, basePos, 1, i, 0);
                placeLogIfFreeWithOffset(world, trunk, random, mutableBlockPos, config, basePos, 0, i, 1);
                placeLogIfFreeWithOffset(world, trunk, random, mutableBlockPos, config, basePos, 2, i, 1);
                placeLogIfFreeWithOffset(world, trunk, random, mutableBlockPos, config, basePos, 1, i, 2);
            }
            placeLogIfFreeWithOffset(world, trunk, random, mutableBlockPos, config, basePos, 1, i, 1);
        }

        return ImmutableList.of(new FoliagePlacer.TreeNode(basePos.up(height).south().east(), 0, false));
    }

    private void placeLogIfFreeWithOffset(TestableWorld world, BiConsumer<BlockPos, BlockState> trunk, Random random, BlockPos.Mutable basePos, TreeFeatureConfig config, BlockPos origin, int x, int y, int z) {
        basePos.set(origin, x, y, z);
        this.trySetState(world, trunk, random, basePos, config);
    }
}
