package com.legends.edumia.world.worldgen.configured.trees;

import com.google.common.collect.ImmutableList;
import com.legends.edumia.Edumia;
import com.legends.edumia.block.ModNatureBlocks;
import com.legends.edumia.block.blocksets.WoodBlockSets;
import com.legends.edumia.world.worldgen.ModPlacedFeatures;
import com.legends.edumia.world.worldgen.placed.trees.TemperateTreePlacedFeatures;
import com.legends.edumia.world.worldgen.trees.foliageplacer.*;
import com.legends.edumia.world.worldgen.trees.trunkplacers.CanopyTrunkPlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.CederTrunkPlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.LargeTrunkPlacer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.foliage.PineFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

public class TemperateTreeConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAKURA_BUSH = registerKey("sakura/sakura_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAKURA_TREE_MEDIUM = registerKey("sakura/sakura_tree_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAKURA_TREE_BIG = registerKey("sakura/sakura_tree_big");

    public static final RegistryKey<ConfiguredFeature<?, ?>> AZALEA_BUSH = registerKey("azalea/azalea_bush");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CEDER_KEY = registerKey("ceder/ceder_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARGE_CEDER_KEY = registerKey("ceder/large_ceder_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CYPRESS_KEY = registerKey("cypress/cypress_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ASPEN_KEY = registerKey("aspen/aspen_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASPEN_2_KEY = registerKey("aspen/aspen_2_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> BIRCH_TREE_KEY = registerKey("birch/birch_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_BIRCH_TREE_KEY = registerKey("birch/mega_birch_tree");


    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_ASH_TREE_KEY = registerKey("white_ash/white_ash_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_WHITE_ASH_TREE_KEY = registerKey("white_ash/small_white_ash_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_ASH_BUSH_KEY = registerKey("white_ash/white_ash_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_WHITE_ASH_TREE_KEY = registerKey("white_ash/mega_white_ashtree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MAPLE_TREE_KEY = registerKey("maple/maple_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> BLACKTHORN_TREE_KEY = registerKey("blackthorn/blackthorn_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> HOLLY_TREE_KEY = registerKey("holly/holly_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HOLLY_BEES_TREE_KEY = registerKey("holly/holly_tree_bees");

    public static final RegistryKey<ConfiguredFeature<?, ?>> WILLOW_TREE_KEY = registerKey("willow/willow_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GENSAI_SAKURA_GROVE_TREES = registerKey("sakura/gensai_sakura_grove_trees");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RegistryEntryLookup<PlacedFeature> placed = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        BeehiveTreeDecorator beehive05TreeDecorator = new BeehiveTreeDecorator(0.05f);

        RegistryEntry.Reference<PlacedFeature> noting = placed.getOrThrow(ModPlacedFeatures.NOTING);

        RegistryEntry.Reference<PlacedFeature> sakura_bush = placed.getOrThrow(TemperateTreePlacedFeatures.SAKURA_BUSH);
        RegistryEntry.Reference<PlacedFeature> sakura_medium_tree = placed.getOrThrow(TemperateTreePlacedFeatures.SAKURA_TREE_MEDIUM);
        RegistryEntry.Reference<PlacedFeature> sakura_big_tree = placed.getOrThrow(TemperateTreePlacedFeatures.SAKURA_TREE_BIG);
        RegistryEntry.Reference<PlacedFeature> azalea_bush = placed.getOrThrow(TemperateTreePlacedFeatures.AZALEA_BUSH);
        RegistryEntry.Reference<PlacedFeature> ceder = placed.getOrThrow(TemperateTreePlacedFeatures.CEDER_KEY);
        RegistryEntry.Reference<PlacedFeature> ceder_big = placed.getOrThrow(TemperateTreePlacedFeatures.LARGE_CEDER_KEY);
        RegistryEntry.Reference<PlacedFeature> cypress = placed.getOrThrow(TemperateTreePlacedFeatures.CYPRESS_KEY);
        RegistryEntry.Reference<PlacedFeature> aspen = placed.getOrThrow(TemperateTreePlacedFeatures.ASPEN_KEY);
        RegistryEntry.Reference<PlacedFeature> aspen2 = placed.getOrThrow(TemperateTreePlacedFeatures.ASPEN_2_KEY);

        register(context, BIRCH_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.BIRCH_LOG),
                new CanopyTrunkPlacer(15, 2, 0.95f, 0.9f, 4.3f, 3, 0.37f,  0.025f,1,1),
                BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                new OvalFoliagePlacer(3, ConstantIntProvider.create(0), ConstantIntProvider.create(2), 0.4f),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());
        register(context, MEGA_BIRCH_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.BIRCH_LOG),
                new CanopyTrunkPlacer(18, 3, 1.0f, 0.67f, 5.2f, 3, 0.44f, -0.05f, 2, 1),
                BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                new OvalFoliagePlacer(2, ConstantIntProvider.create(0), ConstantIntProvider.create(3), 0.4f),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());

        register(context, WHITE_ASH_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.WHITE_ASH.log()),
                new CanopyTrunkPlacer(16, 2, 0.9f, 0.87f, 5.2f, 3, 0.45f, -0.15f, 0,1),
                BlockStateProvider.of(WoodBlockSets.WHITE_ASH.leaves()),
                new OvalFoliagePlacer(2, ConstantIntProvider.create(0), ConstantIntProvider.create(3), 0.4f),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());
        register(context, SMALL_WHITE_ASH_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.WHITE_ASH.log()),
                new CanopyTrunkPlacer(9, 2, 0.9f, 0.87f, 5.2f, 2, 0.45f, -0.15f, 0,1),
                BlockStateProvider.of(WoodBlockSets.WHITE_ASH.leaves()),
                new OvalFoliagePlacer(2, ConstantIntProvider.create(0), ConstantIntProvider.create(3), 0.4f),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());
        register(context, MEGA_WHITE_ASH_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.WHITE_ASH.log()),
                new CanopyTrunkPlacer(34, 3, 1.6f, 0.56f, 8.3f, 4, 0.48f, 0f, 2,1),
                BlockStateProvider.of(WoodBlockSets.WHITE_ASH.leaves()),
                new OvalFoliagePlacer(3, ConstantIntProvider.create(-1), ConstantIntProvider.create(4), 0.7f),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());
        register(context, WHITE_ASH_BUSH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.WHITE_ASH.log()),
                new StraightTrunkPlacer(1, 0, 0), BlockStateProvider.of(WoodBlockSets.WHITE_ASH.leaves()),
                new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(0, 0, 0)).build());

        register(context, MAPLE_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.MAPLE.log()),
                new CanopyTrunkPlacer(11, 2, 0.91f, 0.87f, 5.1f, 2, 0.37f, -0.1f, 1,1),
                BlockStateProvider.of(ModNatureBlocks.MAPLE_LEAVES),
                new OvalFoliagePlacer(2, ConstantIntProvider.create(0), ConstantIntProvider.create(3), 0.3f),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());

        register(context, BLACKTHORN_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.BLACKTHORN.log()),
                new CanopyTrunkPlacer(10, 2, 0.9f, 0.87f, 8.6f, 3, 0.42f, -0.15f, 0,1),
                BlockStateProvider.of(WoodBlockSets.BLACKTHORN.leaves()),
                new OvalFoliagePlacer(2, ConstantIntProvider.create(0), ConstantIntProvider.create(2), 0.4f),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());

        register(context, SAKURA_BUSH, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.CHERRY_LOG),
                new StraightTrunkPlacer(1, 0, 0),
                BlockStateProvider.of(Blocks.CHERRY_LEAVES),
                new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(0, 0, 0)
        ).forceDirt().build());

        register(context, SAKURA_TREE_MEDIUM, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.CHERRY_LOG),
                new LargeOakTrunkPlacer(3, 3, 6),
                BlockStateProvider.of(Blocks.CHERRY_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(16))
        ).forceDirt().build());

        register(context, SAKURA_TREE_BIG, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.CHERRY_LOG),
                new LargeOakTrunkPlacer(12, 6, 10),
                BlockStateProvider.of(Blocks.CHERRY_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(2), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(16))
        ).forceDirt().ignoreVines().decorators(List.of(beehive05TreeDecorator)).build());

        register(context, AZALEA_BUSH, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new StraightTrunkPlacer(1, 0, 0),
                new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(Blocks.AZALEA_LEAVES.getDefaultState(), 5)
                        .add(Blocks.FLOWERING_AZALEA_LEAVES.getDefaultState(), 2)),
                new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 1)
        ).forceDirt().build());

        register(context, LARGE_CEDER_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.CEDAR.log()),
                new CederTrunkPlacer(15, 15, 0, WoodBlockSets.CEDAR.wood().getDefaultState(),
                        WoodBlockSets.CEDAR.woodWall().getDefaultState()),

                BlockStateProvider.of(WoodBlockSets.CEDAR.leaves()),
                new CederFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),

                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, CEDER_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.CEDAR.log()),
                new CederTrunkPlacer(10, 6, 0, WoodBlockSets.CEDAR.wood().getDefaultState(),
                        WoodBlockSets.CEDAR.woodWall().getDefaultState()),
                BlockStateProvider.of(WoodBlockSets.CEDAR.leaves()),
                new CederFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, ASPEN_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.ASPEN.log()),
                new StraightTrunkPlacer(8, 7, 0),
                BlockStateProvider.of(WoodBlockSets.ASPEN.leaves()),
                new AspenFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(2), ConstantIntProvider.create(2)),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, ASPEN_2_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.ASPEN.log()),
                new StraightTrunkPlacer(4, 3, 6),
                new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(WoodBlockSets.ASPEN.leaves().getDefaultState(), 4)
                        .add(Blocks.AIR.getDefaultState(), 1)),
                new PineFoliagePlacer(UniformIntProvider.create(2, 3), ConstantIntProvider.create(1), ConstantIntProvider.create(3)),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, CYPRESS_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.CYPRESS.log()),
                new StraightTrunkPlacer(8, 5, 0),
                BlockStateProvider.of(WoodBlockSets.CYPRESS.leaves()),
                new CypressFoliagePlacer(UniformIntProvider.create(1, 2), ConstantIntProvider.create(1), UniformIntProvider.create(1, 3)),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, GENSAI_SAKURA_GROVE_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(sakura_big_tree, 0.02f), new RandomFeatureEntry(sakura_medium_tree, 0.08f),
                new RandomFeatureEntry(sakura_bush, 0.4f), new RandomFeatureEntry(azalea_bush, 0.3f),
                new RandomFeatureEntry(ceder, 0.06f), new RandomFeatureEntry(ceder_big, 0.04f),
                new RandomFeatureEntry(cypress, 0.07f), new RandomFeatureEntry(aspen, 0.07f),
                new RandomFeatureEntry(aspen2, 0.04f)), noting));

        register(context, HOLLY_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.HOLLY.log()),
                new StraightTrunkPlacer(9, 5, 0),
                BlockStateProvider.of(ModNatureBlocks.HOLLY_LEAVES),
                new HollyFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(2), UniformIntProvider.create(1, 3)),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());

        register(context, HOLLY_BEES_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.HOLLY.log()),
                new StraightTrunkPlacer(9, 5, 0),
                BlockStateProvider.of(ModNatureBlocks.HOLLY_LEAVES),
                new HollyFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(2), UniformIntProvider.create(1, 3)),
                new TwoLayersFeatureSize(1, 0, 1))
                .decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05f)))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());


        register(context, WILLOW_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.WILLOW.log()),
                new LargeTrunkPlacer(13, 2, 1.2f, 0.67f, 6.0f, 3, 0.32f),
                BlockStateProvider.of(WoodBlockSets.WILLOW.leaves()),
                new OvalFoliagePlacer(2, ConstantIntProvider.create(-1), ConstantIntProvider.create(3), 0.4f),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.35F)))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());


    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, "tree/temperate/" + name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}