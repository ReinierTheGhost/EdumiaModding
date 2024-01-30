package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.legends.edumia.world.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class RandomPalmLeavesFoliagePlacer extends FoliagePlacer {
    public static final Codec<RandomPalmLeavesFoliagePlacer> CODEC = RecordCodecBuilder.create((placer) ->
            fillFoliagePlacerFields(placer).apply(placer, RandomPalmLeavesFoliagePlacer::new));
    public RandomPalmLeavesFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    public RandomPalmLeavesFoliagePlacer() {
        this(ConstantIntProvider.create(0), ConstantIntProvider.create(0));
    }
    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.RANDOM_PALM_LEAVES_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int radius, int offset) {
        BlockPos leavePos = foliage.getCenter();

        int leafAngle = 0;
        while (leafAngle < 360) {
            leafAngle += 15 + random.nextInt(15);
            float angleR = (float)Math.toRadians(leafAngle);
            float sin = MathHelper.sin(angleR);
            float cos = MathHelper.cos(angleR);
            float angleY = random.nextFloat() * (float)Math.toRadians(30.0D);
            float cosY = MathHelper.cos(angleY);
            float sinY = MathHelper.sin(angleY);
            int i1 = foliage.getCenter().getX();
            int j1 = trunkHeight - 1;
            int k1 = foliage.getCenter().getZ();
            int jStart = j1;
            int branchLength = 5;
            for (int n = 1; n <= branchLength; ) {
                if (Math.floor((sinY * n)) != Math.floor((sinY * (n - 1)))) {
                    j1 = (int)(j1 + Math.signum(sinY));
                }else {
                    double dCos = Math.floor(Math.abs(cos * n)) - Math.floor(Math.abs(cos * (n - 1)));
                    double dSin = Math.floor(Math.abs(sin * n)) - Math.floor(Math.abs(sin * (n - 1)));
                    dCos = Math.abs(dCos);
                    dSin = Math.abs(dSin);
                    boolean cosOrSin = (dCos == dSin) ? random.nextBoolean() : ((dCos > dSin));
                    if (cosOrSin) {
                        i1 = (int)(i1 + Math.signum(cos));
                    }else {
                        k1 = (int)(k1 + Math.signum(sin));
                    }
                }
                generateLeaf(world, leaves, leavePos.add(i1, j1, k1), random, config);

                if (n >= 5)
                    break;
                n++;
            }
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }

    private void generateLeaf(TestableWorld seedReader, BlockPlacer leaves, BlockPos pos, Random random, TreeFeatureConfig config) {
        if (TreeFeature.isAirOrLeaves(seedReader, pos)) {
            leaves.placeBlock(pos, config.foliageProvider.get(random, pos));
        }
    }
}
