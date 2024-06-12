package com.legends.edumia.world.worldgen.trees.treeplacers.trunks;

import com.google.common.collect.ImmutableList;
import com.legends.edumia.world.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.legends.edumia.world.worldgen.trees.trunkplacers.SlantedTrunkPlacer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class TinyTreeTrunk extends TrunkPlacer {
    public static final Codec<TinyTreeTrunk> CODEC =
            RecordCodecBuilder.create((placer) -> fillTrunkPlacerFields(placer).apply(placer, TinyTreeTrunk::new));
    public TinyTreeTrunk(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
       return EdumiaTrunkPlacerTypes.TINY_TREE_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int i = 0; i < 8; i++){
            this.setLog(world, replacer, random, mutable, config, startPos,0, i, 0);
        }
        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(height), 0, true));
    }

    private void setLog(TestableWorld world, BiConsumer<BlockPos, BlockState> trunk, Random random, BlockPos.Mutable tmpPos,
                        TreeFeatureConfig config, BlockPos basePos, int dx, int dy, int dz) {
        tmpPos.set(basePos, dx, dy, dz);
        this.trySetState(world, trunk, random, tmpPos, config);
    }


}
