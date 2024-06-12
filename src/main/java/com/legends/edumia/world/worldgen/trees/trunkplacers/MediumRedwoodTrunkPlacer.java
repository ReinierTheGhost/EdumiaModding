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
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public class MediumRedwoodTrunkPlacer extends ExtendedTrunkPlacer{
    public static final Codec<MediumRedwoodTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) ->
            baseCodecWithWood(instance).apply(instance, MediumRedwoodTrunkPlacer::new));

    protected MediumRedwoodTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, Optional<BlockStateProvider> woodProvider, Optional<BlockStateProvider> strippedLogProvider, Optional<BlockStateProvider> branchProvider) {
        super(baseHeight, heightRandA, heightRandB, woodProvider, strippedLogProvider, branchProvider);
    }

    public MediumRedwoodTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, BlockState wood){
        this(baseHeight, heightRandA, heightRandB, Optional.empty(), Optional.empty(), Optional.of(BlockStateProvider.of(wood)));
    }
    public MediumRedwoodTrunkPlacer(BlockState wood){
        this(32, 24, 0, Optional.empty(), Optional.empty(), Optional.of(BlockStateProvider.of(wood)));
    }
    @Override
    protected TrunkPlacerType<?> getType() {
        return EdumiaTrunkPlacerTypes.MEDIUM_REDWOOD_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> trunk, Random random,
                                                 int trunkHeight, BlockPos basePos, TreeFeatureConfig config) {
        BlockPos blockPos = basePos.down();
        setToDirt(world, trunk, random, blockPos, config);

        setToDirt(world, trunk, random, blockPos.north(), config);
        setToDirt(world, trunk, random, blockPos.west(), config);
        setToDirt(world, trunk, random, blockPos.east(), config);
        setToDirt(world, trunk, random, blockPos.south(), config);
        setToDirt(world, trunk, random, blockPos.north().east(), config);
        setToDirt(world, trunk, random, blockPos.north().west(), config);
        setToDirt(world, trunk, random, blockPos.south().east(), config);
        setToDirt(world, trunk, random, blockPos.south().west(), config);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int i = 0; i < trunkHeight + 30; ++i) {
            this.setLog(world, trunk, random, mutable, config, basePos, 0, i, 0);
            if (i >= trunkHeight - 1) continue; // makes the log on the position of the sapling 1 higher than the rest
            this.setLog(world, trunk, random, mutable, config, basePos, 1, i, 0);
            this.setLog(world, trunk, random, mutable, config, basePos, 1, i, 1);
            this.setLog(world, trunk, random, mutable, config, basePos, 0, i, 1);

            this.setLog(world, trunk, random, mutable, config, basePos, -1, i, 1);
            this.setLog(world, trunk, random, mutable, config, basePos, -1, i, 0);
            this.setLog(world, trunk, random, mutable, config, basePos, -1, i, -1);
            this.setLog(world, trunk, random, mutable, config, basePos, 1, i, -1);
            this.setLog(world, trunk, random, mutable, config, basePos, 0, i, -1);
        }

        BlockPos.Mutable rootPos1 = (new BlockPos.Mutable()).set(basePos, -1, random.nextBetween(1, 3), -2);
        BlockPos.Mutable rootPos2 = (new BlockPos.Mutable()).set(basePos, 0, random.nextBetween(1, 3), -2);
        BlockPos.Mutable rootPos3 = (new BlockPos.Mutable()).set(basePos, 1, random.nextBetween(1, 3), -2);

        BlockPos.Mutable rootPos4 = (new BlockPos.Mutable()).set(basePos, -1, random.nextBetween(1, 3), 2);
        BlockPos.Mutable rootPos5 = (new BlockPos.Mutable()).set(basePos, 0, random.nextBetween(1, 3), 2);
        BlockPos.Mutable rootPos6 = (new BlockPos.Mutable()).set(basePos, 1, random.nextBetween(1, 3), 2);

        BlockPos.Mutable rootPos7 = (new BlockPos.Mutable()).set(basePos, 2, random.nextBetween(1, 3), -1);
        BlockPos.Mutable rootPos8 = (new BlockPos.Mutable()).set(basePos, 2, random.nextBetween(1, 3), 0);
        BlockPos.Mutable rootPos9 = (new BlockPos.Mutable()).set(basePos, 2, random.nextBetween(1, 3), 1);

        BlockPos.Mutable rootPos10 = (new BlockPos.Mutable()).set(basePos, -2, random.nextBetween(1, 3), -1);
        BlockPos.Mutable rootPos11 = (new BlockPos.Mutable()).set(basePos, -2, random.nextBetween(1, 3), 0);
        BlockPos.Mutable rootPos12 = (new BlockPos.Mutable()).set(basePos, -2, random.nextBetween(1, 3), 1);

        int rootLength = 4 + random.nextInt(3);
        this.growRootsDown(world, random, rootPos1, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos2, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos3, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos4, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos5, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos6, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos7, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos8, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos9, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos10, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos11, rootLength, trunk, config);
        this.growRootsDown(world, random, rootPos12, rootLength, trunk, config);




        return ImmutableList.of(new FoliagePlacer.TreeNode(basePos.up(trunkHeight), 0, true));
    }

    private void setLog(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos.Mutable tmpPos, TreeFeatureConfig config, BlockPos startPos, int dx, int dy, int dz) {
        tmpPos.set(startPos, dx, dy, dz);
        this.trySetState(world, replacer, random, tmpPos, config);
    }
}
