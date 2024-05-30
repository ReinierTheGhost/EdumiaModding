package com.legends.edumia.world.worldgen.configured.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.blocksets.WoodBlockSets;
import com.legends.edumia.world.worldgen.ModPlacedFeatures;
import com.legends.edumia.world.worldgen.placed.trees.TemperateTreePlacedFeatures;
import com.legends.edumia.world.worldgen.placed.trees.TropicalTreePlacedFeatures;
import com.legends.edumia.world.worldgen.trees.foliageplacer.AspenFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.foliageplacer.CederFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.foliageplacer.CypressFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.CederTrunkPlacer;
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
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

public class TemperateTreeConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAKURA_BUSH = registerKey("tree/temperate/sakura/sakura_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAKURA_TREE_MEDIUM = registerKey("tree/temperate/sakura/sakura_tree_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAKURA_TREE_BIG = registerKey("tree/temperate/sakura/sakura_tree_big");

    public static final RegistryKey<ConfiguredFeature<?, ?>> AZALEA_BUSH = registerKey("tree/temperate/azalea/azalea_bush");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CEDER_KEY = registerKey("tree/temperate/ceder/ceder_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARGE_CEDER_KEY = registerKey("tree/temperate/ceder/large_ceder_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CYPRESS_KEY = registerKey("tree/cypress/cypress_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ASPEN_KEY = registerKey("tree/temperate/aspen/aspen_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASPEN_2_KEY = registerKey("tree/temperate/aspen/aspen_2_tree");



    public static final RegistryKey<ConfiguredFeature<?, ?>> GENSAI_SAKURA_GROVE_TREES = registerKey("tree/temperate/sakura/gensai_sakura_grove_trees");


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
                new RandomFeatureEntry(sakura_big_tree, 0.01f), new RandomFeatureEntry(sakura_medium_tree, 0.07f),
                new RandomFeatureEntry(sakura_bush, 0.1f), new RandomFeatureEntry(azalea_bush, 0.1f),
                new RandomFeatureEntry(ceder, 0.05f), new RandomFeatureEntry(ceder_big, 0.03f),
                new RandomFeatureEntry(cypress, 0.06f), new RandomFeatureEntry(aspen, 0.06f),
                new RandomFeatureEntry(aspen2, 0.03f)), noting));


    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
