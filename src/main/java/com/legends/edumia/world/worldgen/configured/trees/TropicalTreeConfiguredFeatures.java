package com.legends.edumia.world.worldgen.configured.trees;

import com.google.common.collect.ImmutableList;
import com.legends.edumia.Edumia;
import com.legends.edumia.block.blocksets.WoodBlockSets;
import com.legends.edumia.world.worldgen.placed.trees.TropicalTreePlacedFeatures;
import com.legends.edumia.world.worldgen.trees.foliageplacer.*;
import com.legends.edumia.world.worldgen.trees.treedecorators.HangingBranchDecorator;
import com.legends.edumia.world.worldgen.trees.trunkplacers.*;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.JungleFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.CocoaBeansTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class TropicalTreeConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> BENDING_JUNGLE_TREE = registerKey("bending_jungle_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CANOPY_JUNGLE_TREE = registerKey("canopy_jungle_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARGE_JUNGLE_TREE = registerKey("large_jungle_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_JUNGLE_TREE = registerKey("mega_jungle_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MAHOGANY = registerKey("mahogany");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_MAHOGANY = registerKey("big_mahogany");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CANOPY_MAHOGANY_TREE = registerKey("canopy_mahogany_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARGE_MAHOGANY_TREE = registerKey("large_mahogany_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_PALM_TREE = registerKey("small_palm_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_PARASOL_PALM = registerKey("big_parasol_palm");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_PARASOL_PALM = registerKey("small_parasol_palm");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RANDOM_PALM = registerKey("random_palm");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COCONUT_PALM = registerKey("coconut_palm");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PAPAYA_PALM = registerKey("papaya_palm");

    public static final RegistryKey<ConfiguredFeature<?, ?>> BANANA = registerKey("banana");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MANGO = registerKey("mango");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MANGO_TWO = registerKey("mango_two");

    public static final RegistryKey<ConfiguredFeature<?, ?>> GENSAI_JUNGLE_TREES = registerKey("gensai_jungle_trees");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){

        RegistryEntryLookup<PlacedFeature> registryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntry.Reference<PlacedFeature> jungle_bush = registryEntryLookup.getOrThrow(TreePlacedFeatures.JUNGLE_BUSH);
        RegistryEntry.Reference<PlacedFeature> jungle = registryEntryLookup.getOrThrow(TreePlacedFeatures.JUNGLE_TREE);
        RegistryEntry.Reference<PlacedFeature> mega_jungle_checked = registryEntryLookup.getOrThrow(TreePlacedFeatures.MEGA_JUNGLE_TREE_CHECKED);
        RegistryEntry.Reference<PlacedFeature> bending_jungle = registryEntryLookup.getOrThrow(TropicalTreePlacedFeatures.BENDING_JUNGLE_TREE);
        RegistryEntry.Reference<PlacedFeature> canopy_jungle = registryEntryLookup.getOrThrow(TropicalTreePlacedFeatures.CANOPY_JUNGLE_TREE);
        RegistryEntry.Reference<PlacedFeature> large_jungle = registryEntryLookup.getOrThrow(TropicalTreePlacedFeatures.LARGE_JUNGLE_TREE);
        RegistryEntry.Reference<PlacedFeature> mega_jungle = registryEntryLookup.getOrThrow(TropicalTreePlacedFeatures.MEGA_JUNGLE_TREE);

        RegistryEntry.Reference<PlacedFeature> mahogany = registryEntryLookup.getOrThrow(TropicalTreePlacedFeatures.MAHOGANY);
        RegistryEntry.Reference<PlacedFeature> big_mahogany = registryEntryLookup.getOrThrow(TropicalTreePlacedFeatures.BIG_MAHOGANY);
        RegistryEntry.Reference<PlacedFeature> canopy_mahogany = registryEntryLookup.getOrThrow(TropicalTreePlacedFeatures.CANOPY_MAHOGANY_TREE);
        RegistryEntry.Reference<PlacedFeature> large_mahogany = registryEntryLookup.getOrThrow(TropicalTreePlacedFeatures.LARGE_MAHOGANY_TREE);

        RegistryEntry.Reference<PlacedFeature> big_parasol = registryEntryLookup.getOrThrow(TropicalTreePlacedFeatures.BIG_PARASOL_PALM);
        RegistryEntry.Reference<PlacedFeature> small_parasol = registryEntryLookup.getOrThrow(TropicalTreePlacedFeatures.SMALL_PARASOL_PALM);
        RegistryEntry.Reference<PlacedFeature> random_palm = registryEntryLookup.getOrThrow(TropicalTreePlacedFeatures.RANDOM_PALM);
        RegistryEntry.Reference<PlacedFeature> coconut_palm = registryEntryLookup.getOrThrow(TropicalTreePlacedFeatures.COCONUT_PALM);
        RegistryEntry.Reference<PlacedFeature> papaya_palm = registryEntryLookup.getOrThrow(TropicalTreePlacedFeatures.PAPAYA_PALM);


        RegistryEntry.Reference<PlacedFeature> banana = registryEntryLookup.getOrThrow(TropicalTreePlacedFeatures.BANANA);

        RegistryEntry.Reference<PlacedFeature> mango = registryEntryLookup.getOrThrow(TropicalTreePlacedFeatures.MANGO);
        RegistryEntry.Reference<PlacedFeature> mango_two = registryEntryLookup.getOrThrow(TropicalTreePlacedFeatures.MANGO_TWO);




        register(context, BENDING_JUNGLE_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.JUNGLE_LOG),
                new BendingTrunkPlacer(8, 6, 0, 8, UniformIntProvider.create(1, 4)),
                BlockStateProvider.of(Blocks.JUNGLE_LEAVES),
                new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0),
                        ConstantIntProvider.create(2),32),
                new TwoLayersFeatureSize(1, 0, 1))
                .decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, new LeavesVineTreeDecorator(0.25f),
                        new CocoaBeansTreeDecorator(0.2f)))
                .ignoreVines().build());

        register(context, CANOPY_JUNGLE_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.JUNGLE_LOG),
                new CanopyTrunkPlacer(12, 10, 2f, 0.87f, 5.0f, 3, 0.42f, -0.1f, 1,1),
                BlockStateProvider.of(Blocks.JUNGLE_LEAVES),
                new JungleFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1), 3),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, new LeavesVineTreeDecorator(0.25f)))
                .ignoreVines().build());

        register(context, LARGE_JUNGLE_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.JUNGLE_LOG),
                new LargeTrunkPlacer(27, 3, 2.3f, 0.6f, 6.2f, 5, 0.25f),
                BlockStateProvider.of(Blocks.JUNGLE_LEAVES),
                new JungleFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1), 3),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, new LeavesVineTreeDecorator(0.25f)))
                .ignoreVines().build());

        register(context, MEGA_JUNGLE_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.JUNGLE_LOG),
                new LargeTrunkPlacer(70, 16, 2.3f, 0.6f, 6.2f, 5, 0.25f),
                BlockStateProvider.of(Blocks.JUNGLE_LEAVES.getDefaultState().with(LeavesBlock.PERSISTENT, true)),
                new OvalFoliagePlacer(3, ConstantIntProvider.create(0), ConstantIntProvider.create(3), 0.5f),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, new LeavesVineTreeDecorator(0.25f)))
                .ignoreVines().build());

        register(context, MAHOGANY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.MAHOGANY.log()),
                new MahoganyTrunkPlacer(8, 6, 0, WoodBlockSets.MAHOGANY.wood().getDefaultState(),
                        WoodBlockSets.MAHOGANY.woodWall().getDefaultState()),
                BlockStateProvider.of(WoodBlockSets.MAHOGANY.leaves()),
                new MahoganyFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(0, 1, 0))
                .decorators(List.of(new LeavesVineTreeDecorator(0.25f),
                        new HangingBranchDecorator(0.25F,
                                BlockStateProvider.of(WoodBlockSets.MAHOGANY.leaves().getDefaultState().with(Properties.PERSISTENT, true)),
                                BlockStateProvider.of(WoodBlockSets.MAHOGANY.leaves().getDefaultState().with(Properties.PERSISTENT, true))
                        ))).build());

        register(context, BIG_MAHOGANY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.MAHOGANY.log()),
                new MahoganyTrunkPlacer(16, 12, 0, WoodBlockSets.MAHOGANY.wood().getDefaultState(),
                        WoodBlockSets.MAHOGANY.woodWall().getDefaultState()),
                BlockStateProvider.of(WoodBlockSets.MAHOGANY.leaves()),
                new MahoganyFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(0, 1, 0))
                .decorators(List.of(new LeavesVineTreeDecorator(0.25f),
                        new HangingBranchDecorator(0.25F,
                                BlockStateProvider.of(WoodBlockSets.MAHOGANY.leaves().getDefaultState().with(Properties.PERSISTENT, true)),
                                BlockStateProvider.of(WoodBlockSets.MAHOGANY.leaves().getDefaultState().with(Properties.PERSISTENT, true))
                        ))).build());

        register(context, CANOPY_MAHOGANY_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.MAHOGANY.log()),
                new CanopyTrunkPlacer(12, 10, 2f, 0.87f, 5.0f, 3, 0.42f, -0.1f, 1,1),
                BlockStateProvider.of(WoodBlockSets.MAHOGANY.leaves().getDefaultState().with(LeavesBlock.PERSISTENT, true)),
                new MahoganyFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1), 3),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, new LeavesVineTreeDecorator(0.25f),
                        new HangingBranchDecorator(0.25F,
                                BlockStateProvider.of(WoodBlockSets.MAHOGANY.leaves().getDefaultState()
                                        .with(Properties.PERSISTENT, true)),
                                BlockStateProvider.of(WoodBlockSets.MAHOGANY.leaves().getDefaultState()
                                        .with(Properties.PERSISTENT, true))
                        ))).ignoreVines().build());

        register(context, LARGE_MAHOGANY_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.MAHOGANY.log()),
                new LargeTrunkPlacer(27, 3, 2.3f, 0.6f, 6.2f, 5, 0.25f),
                BlockStateProvider.of(WoodBlockSets.MAHOGANY.leaves().getDefaultState().with(LeavesBlock.PERSISTENT, true)),
                new MahoganyFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1), 3),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, new LeavesVineTreeDecorator(0.25f),
                        new HangingBranchDecorator(0.25F,
                                BlockStateProvider.of(WoodBlockSets.MAHOGANY.leaves().getDefaultState()
                                        .with(Properties.PERSISTENT, true)),
                                BlockStateProvider.of(WoodBlockSets.MAHOGANY.leaves().getDefaultState()
                                        .with(Properties.PERSISTENT, true))
                        ))).ignoreVines().build());

        register(context, SMALL_PALM_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.PALM.log()),
                new PleodendronTrunkPlacer(9, 6, 7),
                BlockStateProvider.of(WoodBlockSets.PALM.leaves()),
                new PleodendronFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).ignoreVines().build());


        register(context, BIG_PARASOL_PALM, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.PALM.log()),
                new SlantedTrunkPlacer(9, 6, 7),
                BlockStateProvider.of(WoodBlockSets.PALM.leaves()),
                new LargeParasolPalmFoliagePlacer(),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).ignoreVines().build());

        register(context, SMALL_PARASOL_PALM, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.PALM.log()),
                new SlantedTrunkPlacer(6, 4, 5),
                BlockStateProvider.of(WoodBlockSets.PALM.leaves()),
                new ParasolPalmFoliagePlacer(),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, RANDOM_PALM, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.PALM.log()),
                new PalmTrunkPlacer(10, 2, 0.02f, 0.07f, 0),
                BlockStateProvider.of(WoodBlockSets.PALM.leaves()),
                new PalmFoliagePlacer(4, ConstantIntProvider.create(0), ConstantIntProvider.create(1), -0.3f, 0.3f),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, COCONUT_PALM, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.PALM.log()),
                new PalmTrunkPlacer(10, 2, 0.02f, 0.07f, 0),
                BlockStateProvider.of(WoodBlockSets.PALM.leaves()),
                new CoconutFoliagePlacer( ConstantIntProvider.create(4), ConstantIntProvider.create(0)),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, PAPAYA_PALM, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.PALM.log()),
                new PalmTrunkPlacer(10, 2, 0.02f, 0.07f, 0),
                BlockStateProvider.of(WoodBlockSets.PALM.leaves()),
                new PapayaFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0)),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, BANANA, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.BANANA.log()),
                new StraightTrunkPlacer(4, 1, 0),
                BlockStateProvider.of(WoodBlockSets.BANANA.leaves()),
                new BananaFoliagePlacer(0f, 0f),
                new TwoLayersFeatureSize(0, 1, 0)).build());

        register(context, MANGO, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.MANGO.log()),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.of(WoodBlockSets.MANGO.leaves()),
                new TropicalFruitFoliagePlacer(),
                new TwoLayersFeatureSize(0, 1, 0)).build());

        register(context, MANGO_TWO, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.MANGO.log()),
                new DesertTrunkPlacer(4, 2, 0, WoodBlockSets.MANGO.wood().getDefaultState()),
                BlockStateProvider.of(WoodBlockSets.MANGO.leaves()),
                new DesertFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(0, 1, 0)).build());


        register(context, GENSAI_JUNGLE_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(
                 mega_jungle_checked, 0.07f), new RandomFeatureEntry(large_jungle, 0.08f),
                new RandomFeatureEntry(canopy_jungle, 0.02f), new RandomFeatureEntry(canopy_mahogany, 0.04f),
                new RandomFeatureEntry(large_mahogany, 0.4f), new RandomFeatureEntry(bending_jungle, 0.05f),
                new RandomFeatureEntry(mega_jungle, 0.01f), new RandomFeatureEntry(big_mahogany, 0.08f),
                new RandomFeatureEntry(mahogany, 0.08f), new RandomFeatureEntry(banana, 0.09f),
                new RandomFeatureEntry(big_parasol, 0.03f), new RandomFeatureEntry(small_parasol, 0.07f),
                new RandomFeatureEntry(random_palm, 0.04f), new RandomFeatureEntry(coconut_palm, 0.04f),
                new RandomFeatureEntry(papaya_palm, 0.04f), new RandomFeatureEntry(mango, 0.05F),
                new RandomFeatureEntry(mango_two, 0.09f)), jungle_bush));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, "tree/tropical/" + name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
