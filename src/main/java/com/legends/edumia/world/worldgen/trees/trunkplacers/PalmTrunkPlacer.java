package com.legends.edumia.world.worldgen.trees.trunkplacers;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.legends.edumia.world.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.*;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public class PalmTrunkPlacer extends TrunkPlacer {
    public static final Codec<PalmTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(
                Codec.intRange(0,90).fieldOf("base_height").forGetter((trunkPlacer) -> {
                    return trunkPlacer.baseHeight;
                }), Codec.intRange(0,16).fieldOf("random_height").forGetter((trunkPlacer) -> {
                    return trunkPlacer.randomHeight;
                }), Codec.floatRange(0.0f,0.2f).fieldOf("min_acceleration").forGetter((trunkPlacer) -> {
                    return trunkPlacer.minAcceleration;
                }), Codec.floatRange(0.0f,0.2f).fieldOf("max_acceleration").forGetter((trunkPlacer) -> {
                    return trunkPlacer.maxAcceleration;
                }), Codec.floatRange(0.0f,0.2f).fieldOf("velocity").forGetter((trunkPlacer) -> {
                    return trunkPlacer.velocity;
                })).apply(instance, PalmTrunkPlacer::new);
    });


    protected final int baseHeight;
    protected final int randomHeight;
    protected final float minAcceleration;
    protected final float maxAcceleration;
    protected final float velocity;

    public PalmTrunkPlacer(int baseHeight, int randomHeight,
                           float minAcceleration, float maxAcceleration, float velocity) {
        super(baseHeight, randomHeight, 0);
        this.baseHeight = baseHeight;
        this.randomHeight = randomHeight;
        this.minAcceleration = minAcceleration;
        this.maxAcceleration = maxAcceleration;
        this.velocity = velocity;

    }

    public PalmTrunkPlacer(int baseHeight, int randomHeight, float minAcceleration, float maxAcceleration, float velocity, BlockState wood){
        this(baseHeight, randomHeight, minAcceleration, maxAcceleration, velocity);
    }


    @Override
    protected TrunkPlacerType<?> getType() {
        return EdumiaTrunkPlacerTypes.PALM_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> trunk, Random random,
                                                 int trunkHeight, BlockPos startPos, TreeFeatureConfig config) {

        BlockPos blockPos = startPos.down();
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        double angle = Math.random() * 180;
        float acceleration = (float) ((Math.random() * (maxAcceleration - minAcceleration)) + minAcceleration);
        List<FoliagePlacer.TreeNode> treeNodes = createArcBranch(world, trunk, random, mutable, config,
                startPos, getHeight(random), angle, acceleration, this.velocity);

        return ImmutableList.copyOf(treeNodes);

    }


    protected List<FoliagePlacer.TreeNode> createArcBranch(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos.Mutable mutable,
                                                           TreeFeatureConfig config, BlockPos startPos, int height, double angle, float acceleration, float velocity) {
        if(height < 0) {
            height *= -1;
        }
        Vec3d dir = new Vec3d(Math.cos(angle), 1, Math.sin(angle)).normalize();
        Vec3d currentPos = new Vec3d(startPos.getX(), startPos.getY() - 1, startPos.getZ());
        float currentVel = velocity;

        int topHeight = (int) (currentPos.y + height);
        while (currentPos.getY() < topHeight) {
            currentPos = currentPos.add(new Vec3d(dir.x * currentVel, dir.y, dir.z * currentVel));
            this.setLog(world, replacer, random, mutable, config, new BlockPos((int) currentPos.x, (int) currentPos.y, (int) currentPos.z),
                    0, 0, 0);
            currentVel += acceleration;
        }
        List<FoliagePlacer.TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(new FoliagePlacer.TreeNode(new BlockPos((int) currentPos.x, (int) currentPos.y, (int) currentPos.z), 0, false));
        return treeNodes;
    }

    protected void setLog(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos.Mutable tmpPos,
                          TreeFeatureConfig config, BlockPos startPos, int dx, int dy, int dz) {
        tmpPos.set(startPos, dx, dy, dz);
        this.trySetState(world, replacer, random, tmpPos, config);
    }

}
