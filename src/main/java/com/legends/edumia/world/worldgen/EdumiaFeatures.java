package com.legends.edumia.world.worldgen;

import com.legends.edumia.Edumia;
import com.legends.edumia.utils.LoggerUtil;
import com.legends.edumia.utils.ModTags;
import com.legends.edumia.world.biomes.surface.EdumiaBiome;
import com.legends.edumia.world.features.bouders.BoulderFeature;
import com.legends.edumia.world.features.bouders.BouldersFeatureConfig;
import com.legends.edumia.world.features.crystal.CrystalFeature;
import com.legends.edumia.world.features.crystal.CrystalFeatureConfig;
import com.legends.edumia.world.features.reeds.ReedsFeature;
import com.legends.edumia.world.features.reeds.ReedsFeatureConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;


public class EdumiaFeatures {

    public static final Feature<BouldersFeatureConfig> BOULDER = register("boulder", new BoulderFeature(BouldersFeatureConfig.CODEC));
    public static final Feature<CrystalFeatureConfig> CRYSTAL = register("crystal", new CrystalFeature(CrystalFeatureConfig.CODEC));
    public static final Feature<ReedsFeatureConfig> REEDS = register("reeds", new ReedsFeature(ReedsFeatureConfig.CODEC));



    public static BlockState getBlockStateInContext(BlockState state, WorldAccess worldAccess, BlockPos pos){
        return Block.postProcessState(state, worldAccess, pos);
    }

    public static boolean isSurfaceBlock(WorldAccess world, BlockPos pos){
        return isSurfaceBlock(world, pos, 0);
    }

    private static boolean isSurfaceBlock(WorldAccess world, BlockPos pos, int recursion) {
        if (world.getBlockState(pos.up()).isLiquid()){
            return false;
        } else {
            BlockState state = world.getBlockState(pos);
            EdumiaBiome edumiaBiome = new EdumiaBiome();
            Block block = state.getBlock();

            Block topMaterial = edumiaBiome.surfaceBlock;
            Block underMaterial = edumiaBiome.underSurfaceBlock;

            if (!block.getDefaultState().isIn(BlockTags.SAND) && !block.getDefaultState().isIn(BlockTags.VALID_SPAWN)
                    && !block.getDefaultState().isIn(ModTags.Blocks.GRAVEL) && !block.getDefaultState().isIn(ModTags.Blocks.DIRT)){
                if (block.getDefaultState().isIn(ModTags.Blocks.VOLCANIC_PLANT_SURFACE)) {
                    return true;
                } else {
                    return block == Blocks.STONE && recursion <= 1 && isSurfaceBlock(world, pos.down(), recursion + 1);
                }
            } else {
                return true;
            }
        }
    }



    public static void setGrassToDirtBelow(WorldAccess world, BlockPos pos){
        BlockPos belowPos = pos.down();
        BlockState belowState = world.getBlockState(belowPos);

        if (world.getBlockState(pos).isOf(Blocks.GRASS_BLOCK)){
            if (belowState.isOf(Blocks.DIRT) || belowState.isOf(Blocks.GRASS_BLOCK)){
                world.setBlockState(belowPos, Blocks.DIRT.getDefaultState(), 3);
            }
        }
    }

    public static void init() {
        LoggerUtil.getInstance().logInfoMsg("Registering new features");
    }

    private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return (F) Registry.register(Registries.FEATURE, new Identifier(Edumia.MOD_ID, name), feature);
    }

}
