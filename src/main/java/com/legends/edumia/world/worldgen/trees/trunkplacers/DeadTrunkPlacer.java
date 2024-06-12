package com.legends.edumia.world.worldgen.trees.trunkplacers;

import com.google.common.collect.ImmutableList;
import com.legends.edumia.world.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public class DeadTrunkPlacer extends ExtendedTrunkPlacer {
    public static final Codec<DeadTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) ->
            baseCodecWithWood(instance).apply(instance, DeadTrunkPlacer::new));
    protected DeadTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, Optional<BlockStateProvider> woodProvider, Optional<BlockStateProvider> strippedLogProvider, Optional<BlockStateProvider> branchProvider) {
        super(baseHeight, heightRandA, heightRandB, woodProvider, strippedLogProvider, branchProvider);
    }

    public DeadTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, BlockState wood, BlockState branch){
        this(baseHeight, heightRandA, heightRandB, Optional.of(BlockStateProvider.of(wood)), Optional.empty(), Optional.of(BlockStateProvider.of(branch)));
    }



    @Override
    protected TrunkPlacerType<?> getType() {
        return EdumiaTrunkPlacerTypes.DEATH_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> trunk, Random random, int trunkHeight, BlockPos basePos, TreeFeatureConfig config) {
        canReplace(world, basePos.down());

        for (int y = 0; y < trunkHeight; ++y){
            BlockPos trunkPos = basePos.up(y);
            getAndSetState(world, trunk, random, trunkPos, config);
            if (random.nextInt(6) == 0){
                this.placeRandomSurroundingBranch(world, random, trunkPos, trunk, config);
            }
        }

        if (trunkHeight >= 3){
            BlockPos.Mutable branchPos = new BlockPos.Mutable();
            Iterator var16 = Direction.Type.HORIZONTAL.iterator();

            while (var16.hasNext()){
                Direction dir = (Direction) var16.next();
                int branchLength = 2 + random.nextInt(4);
                int branchOut = 0;
                int branchUp = trunkHeight - random.nextInt(3);

                for (int l = 0; l < branchLength; ++l){
                    if (random.nextInt(4) == 0){
                        ++branchOut;
                    }

                    if (l > 0 && random.nextInt(3) != 0){
                        ++branchUp;
                    }

                    if (branchOut > 2 && branchUp == 0){
                        ++branchUp;
                    }

                    branchPos.set(basePos.up(branchUp).offset(dir, branchOut));
                    this.placeWood(world, random, branchPos, trunk, config, Direction.Axis.Y);
                    if (random.nextInt(8) == 0 && world.testBlockState(branchPos, AbstractBlock.AbstractBlockState::isAir)){
                        this.placeRandomSurroundingBranch(world, random, branchPos, trunk, config);
                    }
                }
            }
        }

        return ImmutableList.of();
    }

    private boolean placeRandomSurroundingBranch(TestableWorld world, Random random, BlockPos pos, BiConsumer<BlockPos, BlockState> trunk, TreeFeatureConfig config){
        return this.placeBranch(world, random, pos.offset(Direction.Type.HORIZONTAL.random(random)), trunk, config);
    }
}
