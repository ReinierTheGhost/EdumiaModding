package com.legends.edumia.world.worldgen.configured.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.ModNatureBlocks;
import com.legends.edumia.block.blocksets.WoodBlockSets;
import com.legends.edumia.world.worldgen.trees.foliageplacer.OakFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.CanopyTrunkPlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.OakTrunkPlacer;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class OakTreeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> GREEN_OAK_KEY = registerKey("green/green_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_OAK_KEY = registerKey("red/red_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLACK_OAK_KEY = registerKey("black/black_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CANOPY_RED_OAK_KEY = registerKey("red/canopy_red_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CANOPY_GREEN_OAK_KEY = registerKey("green/canopy_green_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CANOPY_BLACK_OAK_KEY = registerKey("black/canopy_dark_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CANOPY_OAK_KEY = registerKey("normal/canopy_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CANOPY_DARK_OAK_KEY = registerKey("dark/canopy_dark_oak_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){

        register(context, RED_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.RED_OAK.log()),
                new OakTrunkPlacer(4, 4, 0, WoodBlockSets.RED_OAK.wood().getDefaultState(),
                        WoodBlockSets.RED_OAK.woodWall().getDefaultState()),
                BlockStateProvider.of(WoodBlockSets.RED_OAK.leaves()),
                new OakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 3),

                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, BLACK_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.BLACK_OAK.log()),
                new OakTrunkPlacer(4, 4, 0, WoodBlockSets.BLACK_OAK.wood().getDefaultState(),
                        WoodBlockSets.BLACK_OAK.woodWall().getDefaultState()),
                BlockStateProvider.of(ModNatureBlocks.BLACK_OAK_LEAVES),
                new OakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, GREEN_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.GREEN_OAK.log()),
                new OakTrunkPlacer(4, 4, 0, WoodBlockSets.GREEN_OAK.wood().getDefaultState(),
                        WoodBlockSets.GREEN_OAK.woodWall().getDefaultState()),
                BlockStateProvider.of(WoodBlockSets.GREEN_OAK.leaves()),
                new OakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 3),

                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, CANOPY_RED_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.RED_OAK.log()),
                new CanopyTrunkPlacer(12, 2, 0.91f, 0.87f, 5.0f, 3,
                        0.42f, -0.1f, 1,1),
                BlockStateProvider.of(WoodBlockSets.RED_OAK.leaves().getDefaultState().with(LeavesBlock.PERSISTENT, true)),
                new OakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1, 0, 0)).build());

        register(context, CANOPY_GREEN_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.GREEN_OAK.log()),
                new CanopyTrunkPlacer(12, 2, 0.91f, 0.87f, 5.0f, 3,
                        0.42f, -0.1f, 1,1),
                BlockStateProvider.of(WoodBlockSets.GREEN_OAK.leaves().getDefaultState().with(LeavesBlock.PERSISTENT, true)),
                new OakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1, 0, 0)).build());

        register(context, CANOPY_BLACK_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.BLACK_OAK.log()),
                new CanopyTrunkPlacer(12, 2, 0.91f, 0.87f, 5.0f, 3,
                        0.42f, -0.1f, 1,1),
                BlockStateProvider.of(ModNatureBlocks.BLACK_OAK_LEAVES.getDefaultState().with(LeavesBlock.PERSISTENT, true)),
                new OakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1, 0, 0)).build());

        register(context, CANOPY_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new CanopyTrunkPlacer(12, 2, 0.91f, 0.87f, 5.0f, 3,
                        0.42f, -0.1f, 1,1),
                BlockStateProvider.of(Blocks.OAK_LEAVES.getDefaultState().with(LeavesBlock.PERSISTENT, true)),
                new OakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1, 0, 0)).build());

        register(context, CANOPY_DARK_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.DARK_OAK_LOG),
                new CanopyTrunkPlacer(12, 2, 0.91f, 0.87f, 5.0f, 3,
                        0.42f, -0.1f, 1,1),
                BlockStateProvider.of(Blocks.DARK_OAK_LEAVES.getDefaultState().with(LeavesBlock.PERSISTENT, true)),
                new OakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1, 0, 0)).build());

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, "tree/oaks/" +name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
