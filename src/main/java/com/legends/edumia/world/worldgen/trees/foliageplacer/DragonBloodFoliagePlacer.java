package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class DragonBloodFoliagePlacer extends FoliagePlacer {
    public static final Codec<DragonBloodFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            fillFoliagePlacerFields(instance).and(Codec.intRange(0, 16).fieldOf("foliage_heiht").forGetter((foliage) ->
                    foliage.foliageHeight)
            ).apply(instance, DragonBloodFoliagePlacer::new));

    private final int foliageHeight;
    public DragonBloodFoliagePlacer(IntProvider radius, IntProvider offset, int foliageHeight) {
        super(radius, offset);
        this.foliageHeight = foliageHeight;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.DRAGON_BLOOD_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config,
                            int trunkHeight, TreeNode foliage, int foliageHeight, int foliageMaxWidth, int foliageOffset) {
        for (int y = foliageOffset; y >= foliageOffset - foliageHeight; y--) {
            int layerWidth = foliageMaxWidth + foliage.getFoliageRadius() - y;
            this.generateSquare(world, leaves, random, config, foliage.getCenter(), layerWidth, y, foliage.isGiantTrunk());
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.foliageHeight;
    }

    @Override
    public int getRandomRadius(Random random, int baseHeight) {
        return super.getRandomRadius(random, baseHeight);
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int absX, int layerY, int absZ, int layerWidth, boolean bool6) {


        if (layerY == 0) {
            return absX + absZ - 2 > layerWidth;
        }
        if (layerY == -1){
            return absX + absZ - 2 > layerWidth;
            //return  absX > layerWidth -2 && absZ > layerWidth -2 && layerWidth > 0;
        }
        if (layerY == -2){
            return absX + absZ - 3 > layerWidth;
        }

        return false;
    }
}
