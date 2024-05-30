package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class TropicalFruitFoliagePlacer  extends FoliagePlacer {
    public static final Codec<TropicalFruitFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillFoliagePlacerFields(instance)
                    .apply(instance, TropicalFruitFoliagePlacer::new));

    private TropicalFruitFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    public TropicalFruitFoliagePlacer() {
        this(ConstantIntProvider.create(0), ConstantIntProvider.create(0));
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.TROPICAL_FRUIT_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        int leafStart = offset - 3 + random.nextInt(2);
        int leafTop = offset;

        for (int y = leafStart; y <= leafTop; y++){
            int leafRange = (y == leafTop) ? 2 : ((y == leafStart) ? 1 : 3);

            generateSquare(world, placer, random, config, treeNode.getCenter(), leafRange, y, treeNode.isGiantTrunk());
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        int dCh = dx + dz;
        if (dCh <= 4 && ((dx < radius && dz < radius) || random.nextInt(3) != 0)){
            return false;
        }else{
            return true;
        }
    }
}
