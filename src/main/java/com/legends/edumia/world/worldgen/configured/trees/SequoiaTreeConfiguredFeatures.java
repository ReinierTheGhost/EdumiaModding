package com.legends.edumia.world.worldgen.configured.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.blocksets.WoodBlockSets;
import com.legends.edumia.world.worldgen.placed.trees.SequoiaTreePlacedFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.MegaPineFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;

import java.util.List;


public class SequoiaTreeConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_TRUNK_FLOOR = registerKey("tree/sequoia/small/trunk_floor");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_TRUNK_LOW = registerKey("tree/sequoia/small/trunk_low");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_TRUNK_LOW_TO_MIDDLE = registerKey("tree/sequoia/small/trunk_low_to_middle");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_TRUNK_TOP_AND_FOLIAGE = registerKey("tree/sequoia/small/trunk_top_and_foliage");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_TREE_BUILDER = registerKey("tree/sequoia/small/tree_builder");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TREE_PLACER = registerKey("tree/sequoia/template_tree_placer");

    public static final RegistryKey<ConfiguredFeature<?, ?>> COMMON_EMPTY = registerKey("tree/sequoia/common/empty");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COMMON_TRUNK_FLOOR = registerKey("tree/sequoia/common/trunk_floor");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COMMON_TRUNK_LOW = registerKey("tree/sequoia/common/trunk_low");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COMMON_TRUNK_LOW_TO_MIDDLE = registerKey("tree/sequoia/common/trunk_low_to_middle");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COMMON_TRUNK_MIDDLE_TO_TOP = registerKey("tree/sequoia/common/trunk_middle_to_top");

    public static final RegistryKey<ConfiguredFeature<?, ?>> LARGE_TRUNK_TOP_AND_FOLIAGE = registerKey("tree/sequoia/large/trunk_top_and_foliage");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARGE_TREE_BUILDER = registerKey("tree/sequoia/large/tree_builder");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MEDIUM_TRUNK_TOP_AND_FOLIAGE = registerKey("tree/sequoia/medium/trunk_top_and_foliage");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEDIUM_TREE_BUILDER = registerKey("tree/sequoia/medium/tree_builder");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RegistryEntryLookup<PlacedFeature> placed = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntry.Reference<PlacedFeature> small_trunk_floor = placed.getOrThrow(SequoiaTreePlacedFeatures.SMALL_TRUNK_FLOOR);
        RegistryEntry.Reference<PlacedFeature> small_trunk_low = placed.getOrThrow(SequoiaTreePlacedFeatures.SMALL_TRUNK_LOW);
        RegistryEntry.Reference<PlacedFeature> small_trunk_mid = placed.getOrThrow(SequoiaTreePlacedFeatures.SMALL_TRUNK_LOW_TO_MIDDLE);
        RegistryEntry.Reference<PlacedFeature> small_trunk_foliage = placed.getOrThrow(SequoiaTreePlacedFeatures.SMALL_TRUNK_TOP_AND_FOLIAGE);
        RegistryEntry.Reference<PlacedFeature> common_trunk_floor = placed.getOrThrow(SequoiaTreePlacedFeatures.COMMON_TRUNK_FLOOR);
        RegistryEntry.Reference<PlacedFeature> common_trunk_low = placed.getOrThrow(SequoiaTreePlacedFeatures.COMMON_TRUNK_LOW);
        RegistryEntry.Reference<PlacedFeature> common_trunk_mid = placed.getOrThrow(SequoiaTreePlacedFeatures.COMMON_TRUNK_LOW_TO_MIDDLE);
        RegistryEntry.Reference<PlacedFeature> common_trunk_top = placed.getOrThrow(SequoiaTreePlacedFeatures.COMMON_TRUNK_MIDDLE_TO_TOP);
        RegistryEntry.Reference<PlacedFeature> medium_trunk_foliage = placed.getOrThrow(SequoiaTreePlacedFeatures.MEDIUM_TRUNK_TOP_AND_FOLIAGE);
        RegistryEntry.Reference<PlacedFeature> large_trunk_foliage = placed.getOrThrow(SequoiaTreePlacedFeatures.LARGE_TRUNK_TOP_AND_FOLIAGE);
        RegistryEntry.Reference<PlacedFeature> common_empty = placed.getOrThrow(SequoiaTreePlacedFeatures.COMMON_EMPTY);
        RegistryEntry.Reference<PlacedFeature> small_tree_builder = placed.getOrThrow(SequoiaTreePlacedFeatures.SMALL_TREE_BUILDER);
        RegistryEntry.Reference<PlacedFeature> medium_tree_builder = placed.getOrThrow(SequoiaTreePlacedFeatures.MEDIUM_TREE_BUILDER);
        RegistryEntry.Reference<PlacedFeature> large_tree_builder = placed.getOrThrow(SequoiaTreePlacedFeatures.LARGE_TREE_BUILDER);



        register(context, COMMON_EMPTY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.AIR)));

        register(context, TREE_PLACER, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(small_tree_builder, 0.07f),
                new RandomFeatureEntry(medium_tree_builder, 0.10f),
                new RandomFeatureEntry(large_tree_builder, 0.3f)),
                common_empty));


        register(context, LARGE_TREE_BUILDER, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(common_trunk_low, 0.15f),
                new RandomFeatureEntry(common_trunk_mid, 0.15f),
                new RandomFeatureEntry(common_trunk_top, 0.15f),
                new RandomFeatureEntry(large_trunk_foliage, 0.15f)),
                common_trunk_floor));

        register(context, MEDIUM_TREE_BUILDER, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(common_trunk_low, 0.15f),
                new RandomFeatureEntry(common_trunk_mid, 0.15f),
                new RandomFeatureEntry(common_trunk_top, 0.15f),
                new RandomFeatureEntry(medium_trunk_foliage, 0.15f)),
                common_trunk_floor));

        register(context, LARGE_TRUNK_TOP_AND_FOLIAGE, Feature.TREE, new TreeFeatureConfig.Builder(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 5)
                        .add(WoodBlockSets.REDWOOD.strippedLog().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 1)),
                new GiantTrunkPlacer(32, 22, 24),
                BlockStateProvider.of(WoodBlockSets.REDWOOD.leaves()),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(0), ConstantIntProvider.create(8)),
                new TwoLayersFeatureSize(0,0,0)).ignoreVines()
                .dirtProvider(BlockStateProvider.of(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y)))
                .decorators(List.of(new LeavesVineTreeDecorator(0.5f))).build());

        register(context, MEDIUM_TRUNK_TOP_AND_FOLIAGE, Feature.TREE, new TreeFeatureConfig.Builder(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 5)
                        .add(WoodBlockSets.REDWOOD.strippedLog().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 1)),
                new GiantTrunkPlacer(32, 15, 19),
                BlockStateProvider.of(WoodBlockSets.REDWOOD.leaves()),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(0), ConstantIntProvider.create(8)),
                new TwoLayersFeatureSize(0,0,0)).ignoreVines()
                .dirtProvider(BlockStateProvider.of(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y)))
                .decorators(List.of(new LeavesVineTreeDecorator(0.5f))).build());

        register(context, SMALL_TREE_BUILDER, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(small_trunk_low, 0.15f),
                new RandomFeatureEntry(small_trunk_mid, 0.15f),
                new RandomFeatureEntry(common_trunk_top, 0.15f),
                new RandomFeatureEntry(small_trunk_foliage, 0.15f)),
                small_trunk_floor));

        register(context, COMMON_TRUNK_FLOOR, Feature.TREE, new TreeFeatureConfig.Builder(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 15)
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Z), 1)
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.X), 1)
                        .add(WoodBlockSets.REDWOOD.strippedLog().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 15)
                        .add(WoodBlockSets.REDWOOD.strippedLog().getDefaultState().with(Properties.AXIS, Direction.Axis.Z), 1)
                        .add(WoodBlockSets.REDWOOD.strippedLog().getDefaultState().with(Properties.AXIS, Direction.Axis.X), 1)),
                new GiantTrunkPlacer(2, 1, 2),
                BlockStateProvider.of(Blocks.AIR),
                new BushFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
                new TwoLayersFeatureSize(0,0,0)).ignoreVines()
                .dirtProvider(new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 7)
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Z), 2)
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.X), 2)))
                .decorators(List.of(new AlterGroundTreeDecorator(new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(Blocks.PODZOL.getDefaultState(), 4000)
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.X), 9)
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 1))))
                ).build());

        register(context, COMMON_TRUNK_LOW, Feature.TREE, new TreeFeatureConfig.Builder(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 5)
                        .add(WoodBlockSets.REDWOOD.strippedLog().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 1)),
                new GiantTrunkPlacer(6, 2, 4),
                BlockStateProvider.of(Blocks.AIR),
                new BushFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
                new TwoLayersFeatureSize(0,0,0)).ignoreVines()
                .dirtProvider(new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 10))).build());

        register(context, COMMON_TRUNK_LOW_TO_MIDDLE, Feature.TREE, new TreeFeatureConfig.Builder(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 5)
                        .add(WoodBlockSets.REDWOOD.strippedLog().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 1)),
                new GiantTrunkPlacer(8, 3, 6),
                BlockStateProvider.of(Blocks.AIR),
                new BushFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
                new TwoLayersFeatureSize(0,0,0)).ignoreVines()
                .dirtProvider(new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 10))).build());

        register(context, COMMON_TRUNK_MIDDLE_TO_TOP, Feature.TREE, new TreeFeatureConfig.Builder(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 5)
                        .add(WoodBlockSets.REDWOOD.strippedLog().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 1)),
                new GiantTrunkPlacer(17, 4, 8),
                BlockStateProvider.of(Blocks.AIR),
                new BushFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
                new TwoLayersFeatureSize(0,0,0)).ignoreVines()
                .dirtProvider(new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 10))).build());

        register(context, SMALL_TRUNK_FLOOR, Feature.TREE, new TreeFeatureConfig.Builder(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 15)
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Z), 1)
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.X), 1)
                        .add(WoodBlockSets.REDWOOD.strippedLog().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 15)
                        .add(WoodBlockSets.REDWOOD.strippedLog().getDefaultState().with(Properties.AXIS, Direction.Axis.Z), 1)
                        .add(WoodBlockSets.REDWOOD.strippedLog().getDefaultState().with(Properties.AXIS, Direction.Axis.X), 1)),
                new GiantTrunkPlacer(1, 0, 0),
                BlockStateProvider.of(Blocks.AIR),
                new BushFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
                new TwoLayersFeatureSize(0,0,0)).ignoreVines()
                .dirtProvider(new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 7)
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Z), 2)
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.X), 2))).build());

        register(context, SMALL_TRUNK_LOW, Feature.TREE, new TreeFeatureConfig.Builder(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 5)
                        .add(WoodBlockSets.REDWOOD.strippedLog().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 1)),
                new GiantTrunkPlacer(4, 2, 4),
                BlockStateProvider.of(Blocks.AIR),
                new BushFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
                new TwoLayersFeatureSize(0,0,0)).ignoreVines()
                .dirtProvider(new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 10))).build());

        register(context, SMALL_TRUNK_LOW_TO_MIDDLE, Feature.TREE, new TreeFeatureConfig.Builder(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 5)
                        .add(WoodBlockSets.REDWOOD.strippedLog().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 1)),
                new GiantTrunkPlacer(5, 3, 6),
                BlockStateProvider.of(Blocks.AIR),
                new BushFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
                new TwoLayersFeatureSize(0,0,0)).ignoreVines()
                .dirtProvider(new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 10))).build());

        register(context, SMALL_TRUNK_TOP_AND_FOLIAGE, Feature.TREE, new TreeFeatureConfig.Builder(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 5)
                        .add(WoodBlockSets.REDWOOD.strippedLog().getDefaultState().with(Properties.AXIS, Direction.Axis.Y), 1)),
                new GiantTrunkPlacer(32, 10, 14),
                BlockStateProvider.of(WoodBlockSets.REDWOOD.leaves()),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), ConstantIntProvider.create(10)),
                new TwoLayersFeatureSize(0,0,0)).ignoreVines()
                .dirtProvider(BlockStateProvider.of(WoodBlockSets.REDWOOD.log().getDefaultState().with(Properties.AXIS, Direction.Axis.Y)))
                .decorators(List.of(new LeavesVineTreeDecorator(0.5f))).build());

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
