package com.legends.edumia.world.worldgen.trees.trunkplacers;

import com.legends.edumia.world.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class EdumiaGiantTrunkPlacer extends ExtendedTrunkPlacer {
    public static final Codec<EdumiaGiantTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) ->
            baseCodecWithWood(instance).apply(instance, EdumiaGiantTrunkPlacer::new));
    private final boolean generateLeaves = true;
    protected EdumiaGiantTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, Optional<BlockStateProvider> woodProvider, Optional<BlockStateProvider> strippedLogProvider, Optional<BlockStateProvider> branchProvider) {
        super(baseHeight, heightRandA, heightRandB, woodProvider, strippedLogProvider, branchProvider);
    }

    public EdumiaGiantTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, BlockState wood, BlockState strippedLog){
        this(baseHeight, heightRandA, heightRandB, Optional.of(BlockStateProvider.of(wood)), Optional.of(BlockStateProvider.of(strippedLog)),
                Optional.empty());
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return EdumiaTrunkPlacerTypes.EDUMIA_GIANT_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> trunk, Random random,
                                                 int trunkHeight, BlockPos basePos, TreeFeatureConfig config) {
        int trunkRadiusMin = (int) ((float) trunkHeight * 0.125F);
        int trunkRadiusMax = trunkRadiusMin + 4;
        int xSlope = MathHelper.nextInt(random, 4, 18) * (random.nextBoolean() ? -1 : 1);
        int zSlope = MathHelper.nextInt(random, 4, 18) * (random.nextBoolean() ? -1 : 1);
        List<FoliagePlacer.TreeNode> foliage = new ArrayList<>();
        BlockPos.Mutable offsetCentrePos = (new BlockPos.Mutable()).set(basePos);
        Set<BlockPos> strippedLogTrunkPositions = new HashSet<>();
        BlockPos.Mutable movingPos = new BlockPos.Mutable();


        for (int y = 0; y < trunkHeight; ++y){
            float heightF = (float) y / (float) trunkHeight;
            int width = trunkRadiusMax - (int) (heightF * (float) (trunkRadiusMax - trunkRadiusMin));

            for (int x = -width; x <= width; ++x){
                for (int z = -width; z <= width; ++z){
                    movingPos.set(offsetCentrePos).move(x, y, z);
                    if (x * x + z * z < width * width) {
                        if (this.placeStrippedLog(world, random, movingPos, trunk, config, Direction.Axis.Y)){
                            strippedLogTrunkPositions.add(movingPos.toImmutable());
                        }

                        if (y == 0){
                            EdumiaTrunkPlacerTypes.setGrassToDirt(world, movingPos.down());
                            BlockPos.Mutable woodBelowPos = (new BlockPos.Mutable()).set(movingPos.down());
                            int woodBelow = 0;
                            int maxWoodBelow = 6 + random.nextInt(5);

                            while (woodBelowPos.getY() >= 0 && this.placeStrippedLog(world, random, woodBelowPos, trunk, config, Direction.Axis.Y)){
                                strippedLogTrunkPositions.add(woodBelowPos.toImmutable());
                                EdumiaTrunkPlacerTypes.setGrassToDirt(world, woodBelowPos.down());
                                woodBelowPos.move(Direction.DOWN);
                                ++woodBelow;
                                if (woodBelow > maxWoodBelow){
                                    break;
                                }
                            }
                        }
                    }
                }

            }

            if (y % xSlope == 0){
                if (xSlope > 0){
                    offsetCentrePos.move(Direction.EAST);
                }else if (xSlope < 0){
                    offsetCentrePos.move(Direction.WEST);
                }
            }

            if (y % zSlope == 0){
                if (zSlope > 0){
                    offsetCentrePos.move(Direction.SOUTH);
                } else if (zSlope < 0) {
                    offsetCentrePos.move(Direction.NORTH);
                }
            }
        }

        Predicate<BlockState> notWood = (state) ->
                !state.isIn(BlockTags.LOGS);

        ModifiableTestableWorld newWorld = (ModifiableTestableWorld) world;
        for (BlockPos strippedPos : strippedLogTrunkPositions) {
            for (Direction checkDir : Direction.values()) {
                if (world.testBlockState(strippedPos.offset(checkDir), notWood)){
                    newWorld.setBlockState(strippedPos, (this.woodProvider.get()).get(random, strippedPos), 19);
                    break;
                }
            }
        }

        int angle = 0;

        while (angle < 360){
            angle += 10 + random.nextInt(20);
            float angleR = (float) Math.toRadians(angle);
            float sin = MathHelper.sin(angleR);
            float cos = MathHelper.cos(angleR);
            int boughLength = 12 + random.nextInt(10);
            int boughThickness = Math.round(boughLength / 25.0F * 1.5F);
            int boughBaseHeight = MathHelper.floor(trunkHeight * (0.9F + random.nextFloat() * 0.1F));
            int boughHeight = 3 + random.nextInt(4);

            for (int l = 0; l < boughLength; ++l){
                int x = Math.round(cos * l);
                int z = Math.round(sin * l);
                int y = boughBaseHeight + Math.round((float) l / (float) boughLength * (float) boughHeight);
                int range = boughThickness - Math.round((float) l / (float) boughLength * boughThickness * 0.5F);

                for (int x1 = -range; x1 <= range; ++x1){
                    for (int y1 = -range; y1 <= range; y1++) {
                        for (int z1 = -range; z1 <= range; z1++) {
                            movingPos.set(offsetCentrePos).move(x + x1, y + y1, z + z1);
                            this.placeWood(world, random, movingPos, trunk, config, Direction.Axis.Y);
                        }
                    }
                }

                int branch_angle = angle + random.nextInt(360);
                float branch_angleR = (float) Math.toRadians(branch_angle);
                float branch_sin = MathHelper.sin(branch_angleR);
                float branch_cos = MathHelper.cos(branch_angleR);
                int branchLength = 7 + random.nextInt(6);
                int branchHeight = random.nextInt(6);

                for (int l1 = 0; l1 < branchLength; l1++) {
                    int x1 = x + Math.round(branch_cos * l1);
                    int z1 = z + Math.round(branch_sin * l1);
                    int y1 = y + Math.round((float) l1 / (float) branchLength * (float) branchHeight);
                    for (int y2 = 0; y2 >= -1; y2--) {
                        movingPos.set(offsetCentrePos).move(x1, y1 + y2, z1);
                        this.placeWood(world, random, movingPos, trunk, config, Direction.Axis.Y);
                    }

                    if (l1 == branchLength - 1) {
                        BlockPos foliagePos = offsetCentrePos.toImmutable().add(x1, y1, z1);
                        foliage.add(new FoliagePlacer.TreeNode(foliagePos, 0, false));
                    }
                }
            }
        }
        return foliage;
    }
}
