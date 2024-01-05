package com.legends.edumia.world.worldgen.trees.trunkplacers;

import com.google.common.collect.Lists;
import com.legends.edumia.world.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public class PalmTrunkPlacer extends ExtendedTrunkPlacer{
    public static final Codec<PalmTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            baseCodecWithWood(instance).and(instance.group(
                    Codecs.POSITIVE_INT.optionalFieldOf("min_height_for_leaves", 1).forGetter(placer ->
                            placer.minHeightForLeaves),
                    IntProvider.createValidatingCodec(1, 64).fieldOf("bend_length").forGetter(placer ->
                            placer.bendLength))
            ).apply(instance, PalmTrunkPlacer::new));

    private final int minHeightForLeaves;
    private final IntProvider bendLength;
    public PalmTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, Optional<BlockStateProvider> woodProvider, Optional<BlockStateProvider> strippedLogProvider, Optional<BlockStateProvider> branchProvider, int minHeightForLeaves, IntProvider bendLength) {
        super(baseHeight, heightRandA, heightRandB, woodProvider, strippedLogProvider, branchProvider);
        this.minHeightForLeaves = minHeightForLeaves;
        this.bendLength = bendLength;
    }

    public PalmTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, BlockState wood, int minHeightForLeaves, IntProvider bendLength){
        this(baseHeight, heightRandA, heightRandB, Optional.of(BlockStateProvider.of(wood)), Optional.empty(), Optional.empty(),
                minHeightForLeaves, bendLength);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return EdumiaTrunkPlacerTypes.PALM_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        int j;
        Direction direction = Direction.Type.HORIZONTAL.random(random);
        int i = height - 1;
        BlockPos.Mutable mutable = startPos.mutableCopy();
        Vec3i blockPos = mutable.down();
        setToDirt(world, replacer, random, (BlockPos)blockPos, config);
        ArrayList<FoliagePlacer.TreeNode> list = Lists.newArrayList();
        for (j = 0; j <= i; ++j) {
            if (j + 1 >= i + random.nextInt(2)) {
                mutable.move(direction);
            }
            if (TreeFeature.canReplace(world, mutable)) {
                this.getAndSetState(world, replacer, random, mutable, config);
            }
            if (j >= this.minHeightForLeaves) {
                list.add(new FoliagePlacer.TreeNode(mutable.toImmutable(), 0, false));
            }
            mutable.move(Direction.UP);

            float trunkAngle = 6.2831855F * random.nextFloat();
            float trunkSin = MathHelper.sin(trunkAngle);
            float trunkCos = MathHelper.cos(trunkAngle);

            BlockPos.Mutable branchPos = new BlockPos.Mutable();
            BlockPos.Mutable woodPos = new BlockPos.Mutable();
            if (j == height){
                for (int k = -1; k <= 1; k++) {
                    for (int z = -1; z <= 1; z++) {
                        if ((k == 0 || z == 0) && k != z) {
                            woodPos.set(branchPos, k, 0, z);
                            placeWood(world, random, woodPos, replacer, config, Direction.Axis.Y);
                        }
                    }
                }
            }
        }
        j = this.bendLength.get(random);
        for (int k = 0; k <= j; ++k) {
            if (TreeFeature.canReplace(world, mutable)) {
                this.getAndSetState(world, replacer, random, mutable, config);
            }
            list.add(new FoliagePlacer.TreeNode(mutable.toImmutable(), 0, false));
            mutable.move(direction);
        }
        return list;
    }
}
