package com.legends.edumia.world.worldgen.trees.foliageplacer;

import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.block.CocoaBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class BananaFoliagePlacer extends FoliagePlacer {
    public static final Codec<BananaFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(Codec.FLOAT.fieldOf("banana_chance").orElse(0.0F).forGetter((fp) ->
                                    fp.bananaChance),
                            Codec.FLOAT.fieldOf("extra_banana_chance").orElse(0.25F).forGetter((fp) ->
                                    fp.extraBananaChance))
                    .apply(instance, BananaFoliagePlacer::new));
    private final float bananaChance;
    private final float extraBananaChance;

    public BananaFoliagePlacer(float bananaChance, float extraBananaChance) {
        super(ConstantIntProvider.create(0), ConstantIntProvider.create(0));
        this.bananaChance = bananaChance;
        this.extraBananaChance = extraBananaChance;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return EdumiaFoliagePlacerTypes.BANANA_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer leaves, Random random, TreeFeatureConfig config, int trunkHeight,
                            TreeNode foliage, int foliageHeight, int radius, int offset) {
        BlockPos leafPos = foliage.getCenter();
            int[] leave = new int[4];
            for (int l = 0; l < 4; l++)
                leave[l] = 1 + random.nextInt(3);
            for (int m = 0; m < 4; m++) {

                Direction dir = Direction.fromHorizontal(m + 2);
                for (int l1 = 0; l1 < leave[m]; l1++){
                    this.generateLeaf(world, leaves, leafPos.add(dir.getOffsetX(),-2 + l1, dir.getOffsetZ()),
                            random, config);
                }
                for (int l1 = -1; l1 < 1; l1++){
                    this.generateLeaf(world, leaves, leafPos.add( dir.getOffsetX() * 2, -2 + leave[m] + l1,
                                     dir.getOffsetZ()  * 2),
                            random, config);

            }

        }



        if (this.bananaChance > 0.0F) {
            BlockPos datePos = leafPos.down().offset(Direction.Type.HORIZONTAL.random(random));
            if (random.nextDouble() <= this.bananaChance) {
                leaves.placeBlock(datePos, Blocks.COCOA.getDefaultState().with(CocoaBlock.AGE, MathHelper.nextInt(random, 0, 2)));
                if (random.nextDouble() <= this.extraBananaChance) { //Chance for 2nd date
                    datePos = leafPos.up().offset(Direction.Type.HORIZONTAL.random(random));
                    leaves.placeBlock(datePos, Blocks.COCOA.getDefaultState().with(CocoaBlock.AGE, MathHelper.nextInt(random, 0, 2)));
                }
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
