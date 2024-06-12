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

public class PinusFoliagePlacer extends FoliagePlacer {
    public static final Codec<PinusFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            fillFoliagePlacerFields(instance).and(IntProvider.createValidatingCodec(0, 24).fieldOf("foliage_height").forGetter((foliage) ->
                    foliage.heightSpread)).apply(instance, PinusFoliagePlacer::new));
    private final IntProvider heightSpread;
    public PinusFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider heightSpread) {
        super(radius, offset);
        this.heightSpread = heightSpread;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.PINUS_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode foliage, int foliageHeight, int foliageMaxWidth, int foliageOffset) {
        int baseFoliageWidth = foliage.getFoliageRadius();
        this.generateSquare(world, leaves, random, config, foliage.getCenter(), baseFoliageWidth, foliageOffset, foliage.isGiantTrunk());
        this.generateSquare(world, leaves, random, config, foliage.getCenter(), baseFoliageWidth + 1, foliageOffset - 1, foliage.isGiantTrunk());
        int y = foliageOffset - 3;

        while (y > foliageOffset - foliageHeight){
            int layerType = random.nextInt(3);
            if (layerType == 0){
                this.generateSquare(world, leaves, random, config, foliage.getCenter(), baseFoliageWidth + 1, y, foliage.isGiantTrunk());
                y -= 2;
            }else if (layerType == 1){
                --y;
                this.generateSquare(world, leaves, random, config, foliage.getCenter(), baseFoliageWidth + foliageMaxWidth - 2, y + 1, foliage.isGiantTrunk());
                this.generateSquare(world, leaves, random, config, foliage.getCenter(), baseFoliageWidth + foliageMaxWidth - 1, y, foliage.isGiantTrunk());
                this.generateSquare(world, leaves, random, config, foliage.getCenter(), baseFoliageWidth + foliageMaxWidth -2, y - 1, foliage.isGiantTrunk());
                y -= 3;
            } else if (layerType == 2) {
                this.generateSquare(world, leaves, random, config, foliage.getCenter(), baseFoliageWidth + foliageMaxWidth - 1, y + 1, foliage.isGiantTrunk());
                this.generateSquare(world, leaves, random, config, foliage.getCenter(), baseFoliageWidth + foliageMaxWidth, y, foliage.isGiantTrunk());
                this.generateSquare(world, leaves, random, config, foliage.getCenter(), baseFoliageWidth + foliageMaxWidth -1, y - 1, foliage.isGiantTrunk());
                y -= 3;
            }

        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.heightSpread.get(random);
    }

    @Override
    public int getRandomRadius(Random random, int baseHeight) {
        return super.getRandomRadius(random, baseHeight);
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return dx + dz > radius && radius > 0;
    }
}
