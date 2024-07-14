package com.legends.edumia.world.worldgen.configured.trees;

import com.google.common.collect.ImmutableList;
import com.legends.edumia.Edumia;
import com.legends.edumia.block.ModNatureBlocks;
import com.legends.edumia.block.blocksets.WoodBlockSets;
import com.legends.edumia.world.worldgen.ModPlacedFeatures;
import com.legends.edumia.world.worldgen.placed.trees.BorealTreePlacedFeatures;
import com.legends.edumia.world.worldgen.placed.trees.OakTreePlacedFeatures;
import com.legends.edumia.world.worldgen.placed.trees.TemperateTreePlacedFeatures;
import com.legends.edumia.world.worldgen.trees.foliageplacer.ClusterFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.foliageplacer.OakFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.foliageplacer.OvalFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.CanopyTrunkPlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.EdumiaGiantTrunkPlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.LargeTrunkPlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.OakTrunkPlacer;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class OakTreeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> GREEN_OAK_KEY = registerKey("green/green_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_OAK_KEY = registerKey("red/red_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLACK_OAK_KEY = registerKey("black/black_oak_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> OAK_BUSH_TREE_KEY = registerKey("oak/oak_bush_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OAK_TREE_KEY = registerKey("oak/oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OAK_TREE_VINES_KEY = registerKey("oak/oak_vines_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_OAK_TREE_KEY = registerKey("oak/mega_oak_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_DARK_OAK_TREE_KEY = registerKey("dark/mega_dark_oak_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_RED_OAK_TREE_KEY = registerKey("red/small_red_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARGE_RED_OAK_TREE_KEY = registerKey("red/large_red_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_RED_OAK_TREE_KEY = registerKey("red/mega_red_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COLOSSAL_RED_OAK_TREE_KEY = registerKey("red/colossal_red_oak_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_GREEN_OAK_TREE_KEY = registerKey("green/small_green_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARGE_GREEN_OAK_TREE_KEY = registerKey("green/large_green_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_GREEN_OAK_TREE_KEY = registerKey("green/mega_green_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COLOSSAL_GREEN_OAK_TREE_KEY = registerKey("green/colossal_green_oak_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_BLACK_OAK_TREE_KEY = registerKey("black/small_black_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARGE_BLACK_OAK_TREE_KEY = registerKey("black/large_black_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_BLACK_OAK_TREE_KEY = registerKey("black/mega_black_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COLOSSAL_BLACK_OAK_TREE_KEY = registerKey("black/colossal_black_oak_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RegistryEntryLookup<PlacedFeature> registryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        register(context, RED_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.RED_OAK.log()),
                new OakTrunkPlacer(4, 4, 0, WoodBlockSets.RED_OAK.wood().getDefaultState(),
                        WoodBlockSets.RED_OAK.woodWall().getDefaultState()),
                BlockStateProvider.of(WoodBlockSets.RED_OAK.leaves()),
                new OakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 3),

                new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());

        register(context, BLACK_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.BLACK_OAK.log()),
                new OakTrunkPlacer(4, 4, 0, WoodBlockSets.BLACK_OAK.wood().getDefaultState(),
                        WoodBlockSets.BLACK_OAK.woodWall().getDefaultState()),
                BlockStateProvider.of(ModNatureBlocks.BLACK_OAK_LEAVES),
                new OakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());

        register(context, GREEN_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.GREEN_OAK.log()),
                new OakTrunkPlacer(4, 4, 0, WoodBlockSets.GREEN_OAK.wood().getDefaultState(),
                        WoodBlockSets.GREEN_OAK.woodWall().getDefaultState()),
                BlockStateProvider.of(WoodBlockSets.GREEN_OAK.leaves()),
                new OakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 3),

                new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());

        register(context, MEGA_DARK_OAK_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.DARK_OAK_LOG),
                new CanopyTrunkPlacer(21, 3, 1.8f, 0.55f, 6.1f, 3, 0.44f, -0.15f, 2, 0),
                BlockStateProvider.of(Blocks.DARK_OAK_LEAVES),
                new OvalFoliagePlacer(2, ConstantIntProvider.create(0), ConstantIntProvider.create(3), 0.4f),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());

        register(context, SMALL_RED_OAK_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.RED_OAK.wood()),
                new CanopyTrunkPlacer(7, 2, 0.9f, 0.87f, 3.2f, 1, 0.28f, -0.15f, 0, 0),
                BlockStateProvider.of(WoodBlockSets.RED_OAK.leaves()),
                new OvalFoliagePlacer(2, ConstantIntProvider.create(-1), ConstantIntProvider.create(2), 0.3f),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.1F)))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());
        register(context, LARGE_RED_OAK_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.RED_OAK.wood()),
                new LargeTrunkPlacer(14, 2, 1.1f, 0.55f, 3.2f, 2, 0.28f),
                BlockStateProvider.of(WoodBlockSets.RED_OAK.leaves()),
                new OvalFoliagePlacer(2, ConstantIntProvider.create(-1), ConstantIntProvider.create(3), 0.4f),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.25F)))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());
        register(context, MEGA_RED_OAK_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.RED_OAK.log()),
                new LargeTrunkPlacer(27, 3, 2.3f, 0.6f, 6.2f, 5, 0.25f),
                BlockStateProvider.of(WoodBlockSets.RED_OAK.leaves()),
                new OvalFoliagePlacer(3, ConstantIntProvider.create(-1), ConstantIntProvider.create(4), 0.5f),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.25F)))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());
        register(context, COLOSSAL_RED_OAK_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.RED_OAK.log()),
                new EdumiaGiantTrunkPlacer(32, 24, 24, WoodBlockSets.RED_OAK.wood().getDefaultState(),
                        WoodBlockSets.RED_OAK.strippedWood().getDefaultState()),
                BlockStateProvider.of(WoodBlockSets.RED_OAK.leaves()),
                new ClusterFoliagePlacer( ConstantIntProvider.create(3), ConstantIntProvider.create(0)),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.25F)))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());

        register(context, SMALL_GREEN_OAK_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.GREEN_OAK.wood()),
                new CanopyTrunkPlacer(7, 2, 0.9f, 0.87f, 3.2f, 1, 0.28f, -0.15f, 0, 0),
                BlockStateProvider.of(WoodBlockSets.GREEN_OAK.leaves()),
                new OvalFoliagePlacer(2, ConstantIntProvider.create(-1), ConstantIntProvider.create(2), 0.3f),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.1F)))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());
        register(context, LARGE_GREEN_OAK_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.GREEN_OAK.wood()),
                new LargeTrunkPlacer(14, 2, 1.1f, 0.55f, 3.2f, 2, 0.28f),
                BlockStateProvider.of(WoodBlockSets.GREEN_OAK.leaves()),
                new OvalFoliagePlacer(2, ConstantIntProvider.create(-1), ConstantIntProvider.create(3), 0.4f),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.25F)))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());
        register(context, MEGA_GREEN_OAK_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.GREEN_OAK.log()),
                new LargeTrunkPlacer(27, 3, 2.3f, 0.6f, 6.2f, 5, 0.25f),
                BlockStateProvider.of(WoodBlockSets.GREEN_OAK.leaves()),
                new OvalFoliagePlacer(3, ConstantIntProvider.create(-1), ConstantIntProvider.create(4), 0.5f),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.25F)))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());
        register(context, COLOSSAL_GREEN_OAK_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.GREEN_OAK.log()),
                new EdumiaGiantTrunkPlacer(32, 24, 24, WoodBlockSets.GREEN_OAK.wood().getDefaultState(),
                        WoodBlockSets.GREEN_OAK.strippedWood().getDefaultState()),
                BlockStateProvider.of(WoodBlockSets.GREEN_OAK.leaves()),
                new ClusterFoliagePlacer( ConstantIntProvider.create(3), ConstantIntProvider.create(0)),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.25F)))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());

        register(context, SMALL_BLACK_OAK_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.BLACK_OAK.wood()),
                new CanopyTrunkPlacer(7, 2, 0.9f, 0.87f, 3.2f, 1, 0.28f, -0.15f, 0, 0),
                BlockStateProvider.of(ModNatureBlocks.BLACK_OAK_LEAVES),
                new OvalFoliagePlacer(2, ConstantIntProvider.create(-1), ConstantIntProvider.create(2), 0.3f),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.1F)))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());
        register(context, LARGE_BLACK_OAK_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.BLACK_OAK.wood()),
                new LargeTrunkPlacer(14, 2, 1.1f, 0.55f, 3.2f, 2, 0.28f),
                BlockStateProvider.of(ModNatureBlocks.BLACK_OAK_LEAVES),
                new OvalFoliagePlacer(2, ConstantIntProvider.create(-1), ConstantIntProvider.create(3), 0.4f),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.25F)))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());
        register(context, MEGA_BLACK_OAK_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.BLACK_OAK.log()),
                new LargeTrunkPlacer(27, 3, 2.3f, 0.6f, 6.2f, 5, 0.25f),
                BlockStateProvider.of(ModNatureBlocks.BLACK_OAK_LEAVES),
                new OvalFoliagePlacer(3, ConstantIntProvider.create(-1), ConstantIntProvider.create(4), 0.5f),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.25F)))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());
        register(context, COLOSSAL_BLACK_OAK_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.BLACK_OAK.log()),
                new EdumiaGiantTrunkPlacer(32, 24, 24, WoodBlockSets.BLACK_OAK.wood().getDefaultState(),
                        WoodBlockSets.BLACK_OAK.strippedWood().getDefaultState()),
                BlockStateProvider.of(ModNatureBlocks.BLACK_OAK_LEAVES),
                new ClusterFoliagePlacer( ConstantIntProvider.create(3), ConstantIntProvider.create(0)),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.25F)))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());

        register(context, OAK_BUSH_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new StraightTrunkPlacer(1, 0, 0), BlockStateProvider.of(Blocks.OAK_LEAVES),
                new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(0, 0, 0)).build());


        register(context, OAK_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new CanopyTrunkPlacer(12, 2, 0.91f, 0.87f, 5.0f, 3, 0.42f, -0.1f, 1,1),
                BlockStateProvider.of(Blocks.OAK_LEAVES),
                new OvalFoliagePlacer(2, ConstantIntProvider.create(0), ConstantIntProvider.create(3), 0.3f),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());
        register(context, OAK_TREE_VINES_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new CanopyTrunkPlacer(10, 2, 0.91f, 0.87f, 5.0f, 3, 0.42f, -0.1f, 1,1),
                BlockStateProvider.of(Blocks.OAK_LEAVES),
                new OvalFoliagePlacer(2, ConstantIntProvider.create(0), ConstantIntProvider.create(3), 0.3f),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.25F)))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());
        register(context, MEGA_OAK_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new CanopyTrunkPlacer(20, 3, 1.8f, 0.55f, 5.7f, 3, 0.38f, -0.15f, 2, 0),
                BlockStateProvider.of(Blocks.OAK_LEAVES),
                new OvalFoliagePlacer(2, ConstantIntProvider.create(0), ConstantIntProvider.create(3), 0.4f),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());






    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, "tree/oaks/" +name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
