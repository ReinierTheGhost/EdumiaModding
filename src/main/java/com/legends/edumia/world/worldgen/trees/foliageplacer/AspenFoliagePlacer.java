package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.Set;

public class AspenFoliagePlacer extends FoliagePlacer {

    public static final Codec<AspenFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillFoliagePlacerFields(instance).and(IntProvider.createValidatingCodec(0, 16).fieldOf("trunk_height")
                    .forGetter((foliage) -> foliage.trunkHeightSpread
                    )).apply(instance, AspenFoliagePlacer::new));

    private final IntProvider trunkHeightSpread;
    public AspenFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider trunkHeightSpread) {
        super(radius, offset);
        this.trunkHeightSpread = trunkHeightSpread;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.ASPEN_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight,
                            TreeNode treeNode, int foliageHeight, int radius, int offset) {
        int leafTop = offset;
        int leafBottom = offset - foliageHeight;

        for (int y = offset; y >= leafBottom; --y){
            int baseLayerWidth = radius;
            if (y >= leafTop - 1){
                baseLayerWidth = radius - 2;
            } else if (y >= leafTop - 3 || y <= leafBottom + 1 || random.nextInt(4) == 0) {
                baseLayerWidth = radius - 1;
            }

            int layerWidth = baseLayerWidth + treeNode.getFoliageRadius();
            int branches = 4 + random.nextInt(5);

            for (int b = 0; b < branches; ++b){
                BlockPos.Mutable movingPos = (new BlockPos.Mutable()).set(treeNode.getCenter(), 0, y, 0);
                int origX = movingPos.getX();
                int origZ = movingPos.getZ();
                int length = 4 + random.nextInt(8);

                for (int l = 0; l < length && Math.abs(origX - movingPos.getX()) <= layerWidth && Math.abs(origZ - movingPos.getZ()) <= layerWidth; ++l){
                    this.doPlaceLeafBlock((WorldAccess) world, random, config, movingPos, placer);
                    Direction randDir = Direction.Type.HORIZONTAL.random(random);
                    movingPos.move(randDir);
                }

            }
        }

    }

    private void doPlaceLeafBlock(WorldAccess world, Random random, TreeFeatureConfig config, BlockPos.Mutable movingPos, BlockPlacer leaves){
        if (TreeFeature.canReplace(world, movingPos)){
            world.setBlockState(movingPos, config.foliageProvider.get(random, movingPos), 19);
            leaves.hasPlacedBlock(movingPos.toImmutable());
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return Math.max(4, trunkHeight - trunkHeightSpread.get(random));
    }

    @Override
    public int getRandomRadius(Random random, int baseHeight) {
        return super.getRandomRadius(random, baseHeight);
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }

}
