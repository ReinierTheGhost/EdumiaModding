package com.legends.edumia.world.worldgen.trees.treefeatures;

import com.legends.edumia.block.blocksets.WoodBlockSets;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeature;
import org.apache.commons.lang3.ArrayUtils;

public abstract class PalmTreeFeature extends Feature<DefaultFeatureConfig> {
    public PalmTreeFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    protected SaplingBlock getSapling() {
        return null;
    }

    protected final BlockState getLeaf() {
        return WoodBlockSets.PALM.leaves().getDefaultState();
    }

    protected final BlockState getLog() {
        return WoodBlockSets.PALM.log().getDefaultState();
    }

    protected boolean isAir(final WorldView world, final BlockPos pos) {
        return world.isAir(pos);
    }
    protected void placeLeaf(final ModifiableTestableWorld world, int x, int y, int z) {
        this.placeLeaf(world, new BlockPos(x, y, z));
    }

    protected void placeLeaf(final ModifiableTestableWorld world, BlockPos pos) {
        // From FoliagePlacer
        if (TreeFeature.isAirOrLeaves(world, pos)) {
            setBlockState(world, pos, getLeaf());
        }
    }

    protected void placeLog(final ModifiableTestableWorld world, int x, int y, int z) {
        this.placeLog(world, new BlockPos(x, y, z));
    }

    protected void placeLog(final ModifiableTestableWorld world, BlockPos pos) {
        if (TreeFeature.isAirOrLeaves(world, pos)) {
            setBlockState(world, pos, getLog());
        }
    }

    private static final Direction[] DIRECTIONS = ArrayUtils.removeElement(Direction.values(), Direction.UP);


}
