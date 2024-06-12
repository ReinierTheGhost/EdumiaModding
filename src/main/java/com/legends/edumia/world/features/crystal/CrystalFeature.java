package com.legends.edumia.world.features.crystal;

import com.legends.edumia.block.CrystalBlock;
import com.mojang.serialization.Codec;
import com.teamresourceful.bytecodecs.defaults.CollectionCodec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CrystalFeature extends Feature<CrystalFeatureConfig> {
    public CrystalFeature(Codec<CrystalFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<CrystalFeatureConfig> context) {
        BlockPos.Mutable movingPos = new BlockPos.Mutable();

        StructureWorldAccess world = context.getWorld();
        Random random = context.getRandom();
        BlockPos pos = context.getOrigin();
        CrystalFeatureConfig config = context.getConfig();
        java.util.Random rand = new java.util.Random();

        for (int l = 0; l < config.tries; l++){
            int x = pos.getX() - random.nextInt(config.xSpread) + random.nextInt(config.xSpread);
            int y = pos.getY() - random.nextInt(config.ySpread) + random.nextInt(config.ySpread);
            int z = pos.getZ() - random.nextInt(config.zSpread) + random.nextInt(config.zSpread);
            movingPos.set(x, y, z);
            if (world.isAir(movingPos)) {
                BlockState baseState = config.stateProvider.get(random, movingPos);
                List<Direction> dirs = Arrays.asList(Direction.values());
                Collections.shuffle(dirs, rand);
                Iterator var13 = dirs.iterator();

                while (var13.hasNext()){
                    Direction dir = (Direction) var13.next();
                    BlockState placeState = (BlockState) baseState.with(CrystalBlock.CRYSTAL_FACING, dir);
                    if (placeState.canPlaceAt(world, movingPos)){
                        world.setBlockState(movingPos, placeState, 2);
                        break;
                    }
                }
            }
        }
        return true;
    }
}
