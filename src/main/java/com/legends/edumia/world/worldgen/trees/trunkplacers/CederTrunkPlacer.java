package com.legends.edumia.world.worldgen.trees.trunkplacers;

import com.google.common.collect.ImmutableList;
import com.legends.edumia.world.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
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

public class CederTrunkPlacer extends ExtendedTrunkPlacer {
    public static final Codec<CederTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) ->
            baseCodecWithWood(instance).apply(instance, CederTrunkPlacer::new));

    public CederTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, Optional<BlockStateProvider> woodProvider,
                            Optional<BlockStateProvider> strippedLogProvider, Optional<BlockStateProvider> branchProvider) {
        super(baseHeight, heightRandA, heightRandB, woodProvider, strippedLogProvider, branchProvider);
    }

    public CederTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, BlockState wood, BlockState roots){
        this(baseHeight, heightRandA, heightRandB, Optional.of(BlockStateProvider.of(wood)), Optional.empty(),
                Optional.of(BlockStateProvider.of(roots)));
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return EdumiaTrunkPlacerTypes.CEDER_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> trunk, Random random,
                                                 int trunkHeight, BlockPos basePos, TreeFeatureConfig config) {
        setToDirt(world, trunk, random, basePos.down(), config);

        for (int y = 0; y < trunkHeight; ++y){
            getAndSetState(world, trunk, random, basePos.up(y), config); //builds the trunk
        }

        List<FoliagePlacer.TreeNode> foliage = new ArrayList<>();
        foliage.add(new FoliagePlacer.TreeNode(basePos.up(trunkHeight), 0, false)); // places the leaves on top of the trunk

        int i;

        for (i = trunkHeight - 1; i > trunkHeight / 2; i -= 1 + random.nextInt(3)){
            int branches = 1 + random.nextInt(3);

            for (int b = 0; b < branches; ++b) {
                float angle = random.nextFloat() * 3.1415927F * 2.0F;
                int length = MathHelper.nextInt(random, 4, 7);
                int leafLayerLessWidth = 1;
                BlockPos.Mutable branchPos = new BlockPos.Mutable();

                for (int l = 0; l < length; ++l){
                    int branchX = Math.round(0.5F + MathHelper.cos(angle) * (l + 1));
                    int branchZ = Math.round(0.5F + MathHelper.sin(angle) * (l + 1));
                    int branchY = i - 3 + l / 2;
                    BlockPos prevBranchPos = branchPos.toImmutable();
                    branchPos.set(basePos, branchX, branchY, branchZ);
                    if (!branchPos.equals(prevBranchPos)){
                        if (placeWood(world, random, branchPos, trunk, config, Direction.Axis.Y)) {
                            if (l == length - 1 && leafLayerLessWidth <= 1) {
                                BlockPos.Mutable woodPos = new BlockPos.Mutable();

                                for (int j = -1; j <= 1; j++) {
                                    for (int z = -1; z <= 1; z++) {
                                        if ((j == 0 || z == 0) && j != z) {
                                            woodPos.set(branchPos, j, 0, z);
                                            placeWood(world, random, woodPos, trunk, config, Direction.Axis.Y);
                                        }
                                    }
                                }
                            }
                        }

                    }

                }
                foliage.add(new FoliagePlacer.TreeNode(branchPos.up(), -leafLayerLessWidth, false));
            }

        }
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                if (Math.abs(x) != Math.abs(z)) {
                    BlockPos.Mutable rootPos = (new BlockPos.Mutable()).set(basePos, x, random.nextInt(2), z);
                    int rootLength = 4 + random.nextInt(3);
                    this.growRootsDown(world, random, rootPos, rootLength, trunk, config);
                }
            }
        }

        return ImmutableList.of(new FoliagePlacer.TreeNode(basePos.up(trunkHeight), 0, false));
    }
}
