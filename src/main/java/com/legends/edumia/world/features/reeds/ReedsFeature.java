package com.legends.edumia.world.features.reeds;

import com.legends.edumia.block.plants.ReedsBlock;
import com.legends.edumia.utils.EdumiaLog;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class ReedsFeature extends Feature<ReedsFeatureConfig> {
    public ReedsFeature(Codec<ReedsFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<ReedsFeatureConfig> context) {
        BlockPos.Mutable movingPos = new BlockPos.Mutable();

        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();
        ReedsFeatureConfig config = context.getConfig();
        StructureWorldAccess world = context.getWorld();

        for (int l = 0; l < config.tries; l++){
            int x = pos.getX() - random.nextInt(config.xSpread) + random.nextInt(config.xSpread);
            int y = pos.getY() - random.nextInt(config.ySpread) + random.nextInt(config.ySpread);
            int z = pos.getZ() - random.nextInt(config.zSpread) + random.nextInt(config.zSpread);
            movingPos.set(x, y, z);

            Block reedBlock = config.stateProvider.get(random, movingPos).getBlock();
            if (!(reedBlock instanceof ReedsBlock)){
                EdumiaLog.warn("Attempt to generate non-reed block in a reeds feature (block: %s, position: [%d %d %d])",
                new Object[]{reedBlock.getName(), x, y, z});
            }else {
                BlockState baseState = reedBlock.getDefaultState();
                baseState = (BlockState) baseState.with(ReedsBlock.WATERLOGGED, this.isWaterLogged(world, movingPos));
                if (this.canReedsReplaceAt(world, movingPos) && baseState.canPlaceAt(world, movingPos)) {
                    boolean threeHigh = random.nextFloat() < config.fullyGrownChange;
                    boolean placeTreeHigh = false;
                    BlockPos abovePos;

                    if (threeHigh){
                        abovePos = movingPos.up();
                        BlockPos twoAbovePos = abovePos.up();
                        if ((world.isAir(abovePos) || world.getFluidState(abovePos).getFluid() == Fluids.WATER)
                                && world.isAir(twoAbovePos)){
                            this.placeAppropriateReedState(world, movingPos, baseState, ReedsBlock.Type.THREE_BOTTOM);
                            this.placeAppropriateReedState(world, abovePos, baseState, ReedsBlock.Type.THREE_MIDDLE);
                            this.placeAppropriateReedState(world, twoAbovePos, baseState, ReedsBlock.Type.THREE_TOP);
                            placeTreeHigh = true;
                        }
                    }

                    if (!placeTreeHigh){
                        abovePos = movingPos.up();
                        if (world.isAir(abovePos) || world.getFluidState(abovePos).getFluid() == Fluids.WATER){
                            this.placeAppropriateReedState(world, movingPos, baseState, ReedsBlock.Type.TWO_BOTTOM);
                            this.placeAppropriateReedState(world, abovePos, baseState, ReedsBlock.Type.TWO_TOP);
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean canReedsReplaceAt(WorldAccess world, BlockPos pos) {
        BlockState existingState = world.getBlockState(pos);
        return existingState.isAir() || existingState.isReplaceable() || existingState.getBlock() == Blocks.WATER;
    }

    private void placeAppropriateReedState(WorldAccess world, BlockPos pos, BlockState state, ReedsBlock.Type type){
        world.setBlockState(pos, (BlockState)((BlockState)state.with(ReedsBlock.REEDS_TYPE, type))
                .with(ReedsBlock.WATERLOGGED, this.isWaterLogged(world, pos)), 2);
    }

    private boolean isWaterLogged(WorldAccess world, BlockPos pos){
        return world.getFluidState(pos).getFluid() == Fluids.WATER;
    }
}
