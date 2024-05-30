package com.legends.edumia.world.worldgen.placed.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.world.worldgen.configured.trees.SequoiaTreeConfiguredFeatures;
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

public class TropicalTreePlacedFeatures {
    public static final RegistryKey<PlacedFeature> BENDING_JUNGLE_TREE = registerKey("bending_jungle_tree");
    public static final RegistryKey<PlacedFeature> CANOPY_JUNGLE_TREE = registerKey("canopy_jungle_tree");
    public static final RegistryKey<PlacedFeature> LARGE_JUNGLE_TREE = registerKey("large_jungle_tree");
    public static final RegistryKey<PlacedFeature> MEGA_JUNGLE_TREE = registerKey("mega_jungle_tree");

    public static final RegistryKey<PlacedFeature> MAHOGANY = registerKey("mahogany");
    public static final RegistryKey<PlacedFeature> BIG_MAHOGANY = registerKey("big_mahogany");
    public static final RegistryKey<PlacedFeature> CANOPY_MAHOGANY_TREE = registerKey("canopy_mahogany_tree");
    public static final RegistryKey<PlacedFeature> LARGE_MAHOGANY_TREE = registerKey("large_mahogany_tree");

    public static final RegistryKey<PlacedFeature> GENSAI_JUNGLE_TREES = registerKey("gensai_jungle_trees");

    public static final RegistryKey<PlacedFeature> SMALL_PALM_TREE = registerKey("small_palm_tree");

    public static final RegistryKey<PlacedFeature> BIG_PARASOL_PALM = registerKey("big_parasol_palm");
    public static final RegistryKey<PlacedFeature> SMALL_PARASOL_PALM = registerKey("small_parasol_palm");
    public static final RegistryKey<PlacedFeature> RANDOM_PALM = registerKey("random_palm");


    public static final RegistryKey<PlacedFeature> BANANA = registerKey("banana");
    public static final RegistryKey<PlacedFeature> MANGO = registerKey("mango");
    public static final RegistryKey<PlacedFeature> MANGO_TWO = registerKey("mango_two");
    public static final RegistryKey<PlacedFeature> COCONUT_PALM = registerKey("coconut_palm");
    public static final RegistryKey<PlacedFeature> PAPAYA_PALM = registerKey("papaya_palm");

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, BENDING_JUNGLE_TREE,
                configuredFeatureRegistryEntryLookup.getOrThrow(TropicalTreeConfiguredFeatures.BENDING_JUNGLE_TREE),
                List.of());

        register(context, CANOPY_JUNGLE_TREE,
                configuredFeatureRegistryEntryLookup.getOrThrow(TropicalTreeConfiguredFeatures.CANOPY_JUNGLE_TREE),
                List.of());

        register(context, LARGE_JUNGLE_TREE,
                configuredFeatureRegistryEntryLookup.getOrThrow(TropicalTreeConfiguredFeatures.LARGE_JUNGLE_TREE),
                List.of());

        register(context, MEGA_JUNGLE_TREE,
                configuredFeatureRegistryEntryLookup.getOrThrow(TropicalTreeConfiguredFeatures.MEGA_JUNGLE_TREE),
                List.of());

        register(context, MAHOGANY,
                configuredFeatureRegistryEntryLookup.getOrThrow(TropicalTreeConfiguredFeatures.MAHOGANY),
                List.of());

        register(context, BIG_MAHOGANY,
                configuredFeatureRegistryEntryLookup.getOrThrow(TropicalTreeConfiguredFeatures.BIG_MAHOGANY),
                List.of());

        register(context, CANOPY_MAHOGANY_TREE,
                configuredFeatureRegistryEntryLookup.getOrThrow(TropicalTreeConfiguredFeatures.CANOPY_MAHOGANY_TREE),
                List.of());

        register(context, LARGE_MAHOGANY_TREE,
                configuredFeatureRegistryEntryLookup.getOrThrow(TropicalTreeConfiguredFeatures.LARGE_MAHOGANY_TREE),
                List.of());

        register(context, BIG_PARASOL_PALM,
                configuredFeatureRegistryEntryLookup.getOrThrow(TropicalTreeConfiguredFeatures.BIG_PARASOL_PALM),
                List.of());
        register(context, SMALL_PARASOL_PALM,
                configuredFeatureRegistryEntryLookup.getOrThrow(TropicalTreeConfiguredFeatures.SMALL_PARASOL_PALM),
                List.of());
        register(context, RANDOM_PALM,
                configuredFeatureRegistryEntryLookup.getOrThrow(TropicalTreeConfiguredFeatures.RANDOM_PALM),
                List.of());
        register(context, COCONUT_PALM,
                configuredFeatureRegistryEntryLookup.getOrThrow(TropicalTreeConfiguredFeatures.RANDOM_PALM),
                List.of());
        register(context, PAPAYA_PALM,
                configuredFeatureRegistryEntryLookup.getOrThrow(TropicalTreeConfiguredFeatures.RANDOM_PALM),
                List.of());

        register(context, BANANA,
                configuredFeatureRegistryEntryLookup.getOrThrow(TropicalTreeConfiguredFeatures.BANANA),
                List.of());

        register(context, MANGO,
                configuredFeatureRegistryEntryLookup.getOrThrow(TropicalTreeConfiguredFeatures.MANGO),
                List.of());

        register(context, MANGO_TWO,
                configuredFeatureRegistryEntryLookup.getOrThrow(TropicalTreeConfiguredFeatures.MANGO_TWO),
                List.of());

        register(context, GENSAI_JUNGLE_TREES,
                configuredFeatureRegistryEntryLookup.getOrThrow(TropicalTreeConfiguredFeatures.GENSAI_JUNGLE_TREES),
                List.of(CountPlacementModifier.of(new WeightedListIntProvider(DataPool.<IntProvider>builder().add(ConstantIntProvider.create(50), 90)
                        .add(ConstantIntProvider.create(51), 10).build())),
                        SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0),
                        HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR), BlockFilterPlacementModifier.of(BlockPredicate.allOf(
                                BlockPredicate.matchingBlocks(new BlockPos(0, -1, 0), Blocks.GRASS_BLOCK, Blocks.DIRT,
                                        Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.ROOTED_DIRT))), BiomePlacementModifier.of()));



    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Edumia.MOD_ID, "tree/tropical/" + name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
