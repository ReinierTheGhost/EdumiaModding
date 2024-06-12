package com.legends.edumia.world.worldgen.trees.trunkplacers;

import com.google.common.collect.Lists;
import com.legends.edumia.world.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.BiConsumer;

public class CrossTrunkPlacer extends TrunkPlacer
{
    public static final Codec<CrossTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillTrunkPlacerFields(instance).apply(instance, CrossTrunkPlacer::new));



    public CrossTrunkPlacer(int baseHeight, int heightRandA, int heightRandB)
    {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> getType()
    {
        return EdumiaTrunkPlacerTypes.CROSS_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> trunk, Random random, int trunkHeight, BlockPos basePos, TreeFeatureConfig config)
    {
        setToDirt(world, trunk, random, basePos.down(), config);
        List<FoliagePlacer.TreeNode> list = Lists.newArrayList();
        BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable();
        int i = trunkHeight - random.nextInt(6) - 1;
        int j = 6 - random.nextInt(6);
        int k = basePos.getX();
        int l = basePos.getZ();
        int m = basePos.getX();
        int n = basePos.getZ();
        int p = 6 - random.nextInt(3);
        OptionalInt optionalInt = OptionalInt.empty();
        OptionalInt optionalInt1 = OptionalInt.empty();
        Direction direction = Direction.Type.HORIZONTAL.random(random);
        Direction direction1 = random.nextBoolean() ? direction.rotateYCounterclockwise() : direction.rotateYClockwise();

        for(int i1 = 0; i1 < trunkHeight; ++i1) {
            int j1 = basePos.getY() + i1;
            int k1 = j1 - p;
            if (i1 >= i && j > 0) {
                k += direction.getOffsetX();
                l += direction.getOffsetZ();
                m -= direction.getOffsetX();
                n -= direction.getOffsetZ();
                --j;
            }
            if (getAndSetState(world, trunk, random, mutableBlockPos.set(k, j1, l), config)) {
                optionalInt = OptionalInt.of(j1 + 1);
            }
            if (i1 > p) {
                if (getAndSetState(world, trunk, random, mutableBlockPos.set(m, k1, n), config)) {
                    optionalInt1 = OptionalInt.of(k1 + 1);
                }
            }
        }

        if (optionalInt.isPresent()) {
            list.add(new FoliagePlacer.TreeNode(new BlockPos(k, optionalInt.getAsInt(), l), 1, false));
        }
        if (optionalInt1.isPresent()) {
            list.add(new FoliagePlacer.TreeNode(new BlockPos(m, optionalInt1.getAsInt(), n), 1, false));
        }

        k = basePos.getX();
        l = basePos.getZ();
        m = basePos.getX();
        n = basePos.getZ();
        p = 6 - random.nextInt(3);

        int j2 = i - random.nextInt(2) - 1;
        int k2 = 1 + random.nextInt(3);
        optionalInt = OptionalInt.empty();
        optionalInt1 = OptionalInt.empty();

        for(int l1 = j2; l1 < trunkHeight && k2 > 0; --k2) {
            if (l1 >= 1) {
                int i2 = basePos.getY() + l1;
                int l2 = i2 - p;
                k += direction1.getOffsetX();
                l += direction1.getOffsetZ();
                m -= direction1.getOffsetX();
                n -= direction1.getOffsetZ();
                if (getAndSetState(world, trunk, random, mutableBlockPos.set(k, i2, l), config)) {
                    optionalInt = OptionalInt.of(i2 + 1);
                }
                if (l1 > p) {
                    if (getAndSetState(world, trunk, random, mutableBlockPos.set(m, l2, n), config)) {
                        optionalInt1 = OptionalInt.of(l2 + 1);
                    }
                }
            }

            ++l1;
        }

        if (optionalInt.isPresent()) {
            list.add(new FoliagePlacer.TreeNode(new BlockPos(k, optionalInt.getAsInt(), l), 0, false));
        }
        if (optionalInt1.isPresent()) {
            list.add(new FoliagePlacer.TreeNode(new BlockPos(m, optionalInt1.getAsInt(), n), 0, false));
        }

        return list;
    }
}
