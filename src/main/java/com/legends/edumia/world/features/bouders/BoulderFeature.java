package com.legends.edumia.world.features.bouders;

import com.legends.edumia.world.worldgen.EdumiaFeatures;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class BoulderFeature extends Feature<BouldersFeatureConfig> {
    public BoulderFeature(Codec<BouldersFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<BouldersFeatureConfig> context) {
        BlockPos pos = context.getOrigin();
        StructureWorldAccess world = context.getWorld();
        Random rand = context.getRandom();

        BouldersFeatureConfig config = context.getConfig();

        world.getBiome(pos);
        int boulderWidth = MathHelper.nextInt(rand, config.minWidth, config.maxWidth);

        int highestHeight = pos.getY();
        int lowestHeight = highestHeight;

        int spheres;
        int heightValue;

        for (int i = -boulderWidth; i <= boulderWidth; i++){
            for (spheres = -boulderWidth; spheres <= boulderWidth; spheres++){
                BlockPos heightPos = world.getTopPosition(Heightmap.Type.WORLD_SURFACE_WG, pos.add(i, 0, spheres));
                if (!this.isSurfaceBlock(world, heightPos.down())){
                    return false;
                }

                heightValue = heightPos.getY();
                if (heightValue > highestHeight){
                    highestHeight = heightValue;
                }

                if (heightValue < lowestHeight){
                    lowestHeight = heightValue;
                }
            }
        }

        if (highestHeight - lowestHeight > config.heightCheck){
            return false;
        }else {
            BlockPos.Mutable movePos = new BlockPos.Mutable();
            spheres = MathHelper.nextInt(rand, 1, Math.max(1, boulderWidth));

            for (int l = 0; l < spheres; l++) {
                heightValue = MathHelper.nextInt(rand, -boulderWidth, boulderWidth);
                int zOffset = MathHelper.nextInt(rand, -boulderWidth, boulderWidth);
                BlockPos boulderPos = world.getTopPosition(Heightmap.Type.WORLD_SURFACE_WG, pos.add(heightValue, 0, zOffset));
                int sphereWidth = MathHelper.nextInt(rand, config.minWidth, config.maxWidth);

                for (int i = -sphereWidth; i <= sphereWidth; i++) {
                    for (int j = -sphereWidth; j <= sphereWidth; j++) {
                        for (int k = -sphereWidth; k <= sphereWidth; k++) {
                            int dist = i * i + j * j + k * k;
                            if (dist < sphereWidth * sphereWidth || dist < (sphereWidth + 1) * (sphereWidth + 1) && rand.nextInt(3) == 0) {
                                movePos.set(boulderPos.add(i, j, k));

                                for (BlockPos below = movePos.down(); movePos.getY() >= 0 && !world.getBlockState(below).isOpaqueFullCube(world, below); below = below.down()) {
                                    movePos.set(below);
                                }

                                world.setBlockState(movePos, config.stateProfider.get(rand, movePos), 3);
                                EdumiaFeatures.setGrassToDirtBelow(world, movePos);
                            }
                        }
                    }
                }
                return true;
            }
        }
        return true;
    }

    private boolean isSurfaceBlock(WorldAccess world, BlockPos pos){
        return EdumiaFeatures.isSurfaceBlock(world, pos);
    }
}
