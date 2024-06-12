package com.legends.edumia.world.worldgen.configured.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.blocksets.WoodBlockSets;
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

    public static final RegistryKey<ConfiguredFeature<?, ?>> LARCH_KEY = registerKey("tree/larch/larch_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARCH_TREE_KEY = registerKey("tree/larch/larch_tree_2");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_LARCH_KEY = registerKey("tree/larch/big_larch_tree");

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





    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
