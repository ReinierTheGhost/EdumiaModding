package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.function.BiConsumer;

public class GoldenOakFoliagePlacer extends FoliagePlacer {
    public static final Codec<GoldenOakFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            fillFoliagePlacerFields(instance).and(IntProvider.createValidatingCodec(0, 24).fieldOf("trunk_height")
                            .forGetter((placer) -> placer.trunkHeight))
            .apply(instance, GoldenOakFoliagePlacer::new));
    private final IntProvider trunkHeight;

    public GoldenOakFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider height) {
        super(radius, offset);
        this.trunkHeight = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.GOLDEN_OAK_FOLIAGE_PLACER;
    }

    /**
     * Places a sphere of leaves.
     * @param level The {@link TestableWorld}.
     * @param foliageSetter The {@link BiConsumer} of a {@link BlockPos} and {@link BlockState} used for block placement.
     * @param random The {@link Random}.
     * @param config The {@link TreeFeatureConfig}.
     * @param maxFreeTreeHeight The {@link Integer} for the maximum tree height.
     * @param attachment A {@link FoliagePlacer.TreeNode} to add foliage to.
     * @param foliageHeight The {@link Integer} for the foliage height.
     * @param foliageRadius The {@link Integer} for the foliage radius.
     * @param offset The {@link Integer} for the foliage offset.
     */
    @Override
    protected void generate(TestableWorld level, BlockPlacer foliageSetter, Random random, TreeFeatureConfig config, int maxFreeTreeHeight, TreeNode attachment, int foliageHeight, int foliageRadius, int offset) {
        for (int i = offset; i >= offset - foliageHeight; --i) {
            this.generateSquare(level, foliageSetter, random, config, attachment.getCenter(), 4, i, attachment.isGiantTrunk());
        }
    }
    /**
     * Determines the foliage height at a constant value of 7.
     * @param random The {@link Random}.
     * @param height The {@link Integer} for the foliage height.
     * @param config The {@link TreeFeatureConfig}.
     * @return The {@link Integer} for the foliage height.
     */
    @Override
    public int getRandomHeight(Random random, int height, TreeFeatureConfig config) {
        return 7;
    }

    /**
     * Skips placing a foliage block at a spherical edge location and with some randomness.
     * @param random The {@link Random}.
     * @param localX The local {@link Integer} x-position.
     * @param localY The local {@link Integer} y-position.
     * @param localZ The local {@link Integer} z-position.
     * @param range The {@link Integer} for the placement range.
     * @param large The {@link Boolean} for whether the tree is large.
     * @return Whether the location should be skipped, as a {@link Boolean}.
     */
    @Override
    protected boolean isInvalidForLeaves(Random random, int localX, int localY, int localZ, int range, boolean large) {
        return MathHelper.square(localX) + MathHelper.square(localY + 2) + MathHelper.square(localZ) > 12 + random.nextInt(5);
    }
}
