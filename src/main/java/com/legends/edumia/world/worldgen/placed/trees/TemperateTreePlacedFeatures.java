package com.legends.edumia.world.worldgen.placed.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.world.worldgen.configured.trees.SequoiaTreeConfiguredFeatures;
import com.legends.edumia.world.worldgen.configured.trees.TemperateTreeConfiguredFeatures;
import com.legends.edumia.world.worldgen.configured.trees.TropicalTreeConfiguredFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class TemperateTreePlacedFeatures {

    public static final RegistryKey<PlacedFeature> SAKURA_BUSH = registerKey("tree/temperate/sakura/sakura_bush");
    public static final RegistryKey<PlacedFeature> SAKURA_TREE_MEDIUM = registerKey("tree/temperate/sakura/sakura_tree_medium");
    public static final RegistryKey<PlacedFeature> SAKURA_TREE_BIG = registerKey("tree/temperate/sakura/sakura_tree_big");

    public static final RegistryKey<PlacedFeature> AZALEA_BUSH = registerKey("tree/temperate/azalea/azalea_bush");

    public static final RegistryKey<PlacedFeature> CEDER_KEY = registerKey("tree/temperate/ceder/ceder_tree");
    public static final RegistryKey<PlacedFeature> LARGE_CEDER_KEY = registerKey("tree/temperate/ceder/large_ceder_tree");

    public static final RegistryKey<PlacedFeature> CYPRESS_KEY = registerKey("tree/cypress/cypress_tree");

    public static final RegistryKey<PlacedFeature> ASPEN_KEY = registerKey("tree/temperate/aspen/aspen_tree");
    public static final RegistryKey<PlacedFeature> ASPEN_2_KEY = registerKey("tree/temperate/aspen/aspen_2_tree");

    public static final RegistryKey<PlacedFeature> GENSAI_SAKURA_GROVE_TREES = registerKey("tree/temperate/sakura/gensai_sakura_grove_trees");


    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, SAKURA_BUSH, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.SAKURA_BUSH),
                List.of());

        register(context, SAKURA_TREE_MEDIUM, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.SAKURA_TREE_MEDIUM),
                List.of());

        register(context, SAKURA_TREE_BIG, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.SAKURA_TREE_BIG),
                List.of());

        register(context, AZALEA_BUSH, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.AZALEA_BUSH),
                List.of());

        register(context, CEDER_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.CEDER_KEY),
                List.of());

        register(context, LARGE_CEDER_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.LARGE_CEDER_KEY),
                List.of());

        register(context, CYPRESS_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.CYPRESS_KEY),
                List.of());

        register(context, ASPEN_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.ASPEN_KEY),
                List.of());
        register(context, ASPEN_2_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.ASPEN_2_KEY),
                List.of());


        register(context, GENSAI_SAKURA_GROVE_TREES,
                configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.GENSAI_SAKURA_GROVE_TREES),
                List.of(CountPlacementModifier.of(ConstantIntProvider.create(128)),
                        SquarePlacementModifier.of(),NoiseBasedCountPlacementModifier.of(8, 202, 0.25),
                        HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE), RarityFilterPlacementModifier.of(100),
                        BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(Blocks.FERN.getDefaultState(), BlockPos.ORIGIN)),
                        BiomePlacementModifier.of()));

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
