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
import java.util.function.Function;

public class SmallRedwoodTrunkPlacer extends ExtendedTrunkPlacer{
    public static final Codec<SmallRedwoodTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) ->
            baseCodecWithWood(instance).apply(instance, SmallRedwoodTrunkPlacer::new));

    protected SmallRedwoodTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, Optional<BlockStateProvider> woodProvider, Optional<BlockStateProvider> strippedLogProvider, Optional<BlockStateProvider> branchProvider) {
        super(baseHeight, heightRandA, heightRandB, woodProvider, strippedLogProvider, branchProvider);
    }

    public SmallRedwoodTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, BlockState wood){
        this(baseHeight, heightRandA, heightRandB, Optional.empty(), Optional.empty(), Optional.of(BlockStateProvider.of(wood)));
    }

    public SmallRedwoodTrunkPlacer(BlockState wood){
        this(30, 15, 0, Optional.empty(), Optional.empty(), Optional.of(BlockStateProvider.of(wood)));
    }
    @Override
    protected TrunkPlacerType<?> getType() {
        return EdumiaTrunkPlacerTypes.SMALL_REDWOOD_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        BlockPos blockPos = startPos.down();
        setToDirt(world, replacer, random, blockPos, config);
        setToDirt(world, replacer, random, blockPos.east(), config);
        setToDirt(world, replacer, random, blockPos.south(), config);
        setToDirt(world, replacer, random, blockPos.south().east(), config);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int i = 0; i < height; ++i) {
            this.setLog(world, replacer, random, mutable, config, startPos, 0, i, 0);
            if (i >= height - 1) continue; // makes the log on the position of the sapling 1 higher than the rest
            this.setLog(world, replacer, random, mutable, config, startPos, 1, i, 0);
            this.setLog(world, replacer, random, mutable, config, startPos, 1, i, 1);
            this.setLog(world, replacer, random, mutable, config, startPos, 0, i, 1);
        }

        BlockPos.Mutable rootPos1 = (new BlockPos.Mutable()).set(startPos, 0, random.nextBetween(1, 3), -1);
        BlockPos.Mutable rootPos2 = (new BlockPos.Mutable()).set(startPos, -1, random.nextBetween(1, 3), 0);
        BlockPos.Mutable rootPos3 = (new BlockPos.Mutable()).set(startPos, 1, random.nextBetween(1, 3), -1);
        BlockPos.Mutable rootPos4 = (new BlockPos.Mutable()).set(startPos, -1, random.nextBetween(1, 3), 1);
        BlockPos.Mutable rootPos5 = (new BlockPos.Mutable()).set(startPos, 0, random.nextBetween(1, 3), 2);
        BlockPos.Mutable rootPos6 = (new BlockPos.Mutable()).set(startPos, 2, random.nextBetween(1, 3), 0);
        BlockPos.Mutable rootPos7 = (new BlockPos.Mutable()).set(startPos, 2, random.nextBetween(1, 3), 1);
        BlockPos.Mutable rootPos8 = (new BlockPos.Mutable()).set(startPos, 1, random.nextBetween(1, 3), 2);

        int rootLength = 4 + random.nextInt(3);
        this.growRootsDown(world, random, rootPos1, rootLength, replacer, config);
        this.growRootsDown(world, random, rootPos2, rootLength, replacer, config);
        this.growRootsDown(world, random, rootPos3, rootLength, replacer, config);
        this.growRootsDown(world, random, rootPos4, rootLength, replacer, config);
        this.growRootsDown(world, random, rootPos5, rootLength, replacer, config);
        this.growRootsDown(world, random, rootPos6, rootLength, replacer, config);
        this.growRootsDown(world, random, rootPos7, rootLength, replacer, config);
        this.growRootsDown(world, random, rootPos8, rootLength, replacer, config);



        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(height), 0, true));
    }

    private void setLog(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos.Mutable tmpPos, TreeFeatureConfig config, BlockPos startPos, int dx, int dy, int dz) {
        tmpPos.set(startPos, dx, dy, dz);
        this.trySetState(world, replacer, random, tmpPos, config);
    }

}
