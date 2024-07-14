package com.legends.edumia.world.worldgen.configured.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.blocksets.WoodBlockSets;
import com.legends.edumia.world.worldgen.trees.foliageplacer.SilverSpruceFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.SpruceTrunkPlacer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.BiasedToBottomIntProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

public class BorealTreeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> LARCH_KEY = registerKey("larch/larch_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARCH_TREE_KEY = registerKey("larch/larch_tree_2");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_LARCH_KEY = registerKey("larch/big_larch_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> PINE_TREE_KEY = registerKey("pine/pine_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEAD_PINE_TREE_KEY = registerKey("pine/dead_pine_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPRUCE_TREE_KEY = registerKey("spruce/spruce_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPRUCE_BUSH_TREE_KEY = registerKey("spruce/spruce_bush_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SILVER_SPRUCE_TREE_KEY = registerKey("silver_spruce/silver_spruce_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RegistryEntryLookup<PlacedFeature> placed = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        BeehiveTreeDecorator beehive05TreeDecorator = new BeehiveTreeDecorator(0.05f);

        register(context, LARCH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.LARCH.log()),
                new StraightTrunkPlacer(8, 8, 0),
                BlockStateProvider.of(WoodBlockSets.LARCH.leaves()),
                new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), ConstantIntProvider.create(1), UniformIntProvider.create(1, 3)),
                new TwoLayersFeatureSize(1, 0, 1))
                .ignoreVines().build());

        register(context, LARCH_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.LARCH.log()),
                new StraightTrunkPlacer(11, 2 , 1),
                BlockStateProvider.of(WoodBlockSets.LARCH.leaves()),
                new SpruceFoliagePlacer(ConstantIntProvider.create(3), UniformIntProvider.create(0, 2), UniformIntProvider.create(2, 3)),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());

        register(context, BIG_LARCH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.LARCH.log()),
                new StraightTrunkPlacer(8, 4, 13),
                BlockStateProvider.of(WoodBlockSets.LARCH.leaves()),
                new MegaPineFoliagePlacer(BiasedToBottomIntProvider.create(1, 1), UniformIntProvider.create(1, 3), UniformIntProvider.create(12, 22)),
                new TwoLayersFeatureSize(1, 0, 1, OptionalInt.of(0)))
                .dirtProvider(BlockStateProvider.of(Blocks.COARSE_DIRT))
                .ignoreVines().forceDirt().build());

        register(context, PINE_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.PINE.log()),
                new SpruceTrunkPlacer(14, 3),
                BlockStateProvider.of(WoodBlockSets.PINE.leaves()),
                new PineFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), UniformIntProvider.create(4, 4)),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());
        register(context, DEAD_PINE_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.PINE.log()),
                new SpruceTrunkPlacer(14, 3),
                BlockStateProvider.of(Blocks.AIR),
                new PineFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), ConstantIntProvider.create(1)),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());

        register(context, SPRUCE_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.SPRUCE_LOG),
                new StraightTrunkPlacer(14, 2, 0),
                BlockStateProvider.of(Blocks.SPRUCE_LEAVES),
                new SpruceFoliagePlacer(ConstantIntProvider.create(3), UniformIntProvider.create(0, 1), ConstantIntProvider.create(2)),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());
        register(context, SPRUCE_BUSH_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.SPRUCE_LOG),
                new StraightTrunkPlacer(1, 0, 0), BlockStateProvider.of(Blocks.SPRUCE_LEAVES),
                new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(0, 0, 0)).build());

        register(context, SILVER_SPRUCE_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.SILVER_SPRUCE.log()),
                new StraightTrunkPlacer(8, 7, 0),
                BlockStateProvider.of(WoodBlockSets.SILVER_SPRUCE.leaves()),
                new SilverSpruceFoliagePlacer(ConstantIntProvider.create(2), UniformIntProvider.create(0, 2), UniformIntProvider.create(7, 11)),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirtProvider(BlockStateProvider.of(Blocks.GRASS_BLOCK)).build());







    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID,"tree/boreal/" + name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
