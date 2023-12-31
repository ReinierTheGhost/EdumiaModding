package com.legends.edumia.world.worldgen.trees.trunkplacers;

import com.legends.edumia.world.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.*;
import java.util.function.BiConsumer;

public class BoughsTrunkPlacer extends ExtendedTrunkPlacer {
    public static final Codec<BoughsTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) ->
            baseCodecWithWood(instance).apply(instance, BoughsTrunkPlacer::new));
    public BoughsTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, Optional<BlockStateProvider> woodProvider,
                             Optional<BlockStateProvider> strippedLogProvider, Optional<BlockStateProvider> branchProvider) {
        super(baseHeight, heightRandA, heightRandB, woodProvider, strippedLogProvider, branchProvider);
    }

    public BoughsTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, BlockState wood, BlockState branch){
        this(baseHeight, heightRandA, heightRandB, Optional.of(BlockStateProvider.of(wood)), Optional.empty(), Optional.of(BlockStateProvider.of(branch)));
    }



    @Override
    protected TrunkPlacerType<?> getType() {
        return EdumiaTrunkPlacerTypes.BOUGHS_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random,
                                                 int trunkHeight, BlockPos basePos, TreeFeatureConfig config) {
        canReplace(world, basePos.down());

        int branchMinHeight;
        for (branchMinHeight = 0; branchMinHeight < trunkHeight; ++branchMinHeight){
            getAndSetState(world, replacer, random, basePos.up(branchMinHeight), config);
        }

        branchMinHeight = (int) ((float) trunkHeight * 0.6f);
        int branchMaxHeight = trunkHeight - 1;
        this.placeWood(world, random, basePos.up(branchMaxHeight), replacer, config, Direction.Axis.Y);
        List<FoliagePlacer.TreeNode> foliage = new ArrayList<>();
        int deg = 0;

        int rootUp;
        for (int y = branchMaxHeight; y >= branchMinHeight; --y) {
            int branches = 1 + random.nextInt(2);

            for (rootUp = 0; rootUp < branches; ++rootUp){
                deg += 50 + random.nextInt(70);
                float angle = (float) Math.toRadians(deg);
                float cos = MathHelper.cos(angle);
                float sin = MathHelper.sin(angle);
                float angleY = random.nextFloat() * (float)Math.toRadians(40.0D);
                float cosY = MathHelper.cos(angleY);
                float sinY = MathHelper.sin(angleY);
                int length = 4 + random.nextInt(6);
                BlockPos.Mutable branchPos = (new BlockPos.Mutable()).set(basePos, 0, y, 0);
                Direction.Axis branchAxis = Direction.fromRotation((deg + 90)).getAxis();

                for (int l = 0; l < length; ++l){
                    if (Math.floor((cos * l)) != Math.floor((cos * (l - 1)))){
                        branchPos.move((int) Math.signum(cos),0, 0);
                    }
                    if (Math.floor((sin * l)) != Math.floor((sin * (l - 1)))){
                        branchPos.move(0, 0, (int) Math.signum(sin));
                    }

                    if (Math.floor((sinY * l)) != Math.floor((sinY * (l - 1)))){
                        branchPos.move(0, (int) Math.signum(sinY), 0);
                    }

                    if (branchPos.getX() != basePos.getX() || branchPos.getY() != basePos.getY() || branchPos.getZ() > basePos.getZ() + branchMaxHeight){
                        if (!TreeFeature.canReplace(world, basePos)){
                            break;
                        }

                        this.placeWood(world, random, branchPos, replacer, config, branchAxis);

                    }
                }

                foliage.add(new FoliagePlacer.TreeNode(branchPos.up(2), random.nextInt(2), false));
            }
        }

        Iterator var25 = Direction.Type.HORIZONTAL.iterator();

        while (var25.hasNext()) {
            Direction dir = (Direction) var25.next();
            rootUp = random.nextInt(3);
            int rootLength = 3 + rootUp + random.nextInt(3);
            int maxOut = 1;
            if (rootUp >= 2 && random.nextBoolean()){
                ++maxOut;
            }

            BlockPos.Mutable rootPos = (new BlockPos.Mutable()).set(basePos, dir.getOffsetX(), rootUp, dir.getOffsetZ());
            this.growRootsDownAndThanOut(world, random, rootPos, rootLength, dir, maxOut, replacer, config);
        }

        return foliage;
    }
}
