package com.legends.edumia.world.worldgen.placed.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.world.worldgen.configured.TreeConfiguredFeatures;
import com.legends.edumia.world.worldgen.configured.trees.SequoiaTreeConfiguredFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class SequoiaTreePlacedFeatures {

    public static final RegistryKey<PlacedFeature> SMALL_TRUNK_FLOOR = registerKey("tree/sequoia/small/trunk_floor");
    public static final RegistryKey<PlacedFeature> SMALL_TRUNK_LOW = registerKey("tree/sequoia/small/trunk_low");
    public static final RegistryKey<PlacedFeature> SMALL_TRUNK_LOW_TO_MIDDLE = registerKey("tree/sequoia/small/trunk_low_to_middle");
    public static final RegistryKey<PlacedFeature> SMALL_TRUNK_TOP_AND_FOLIAGE = registerKey("tree/sequoia/small/trunk_top_and_foliage");
    public static final RegistryKey<PlacedFeature> SMALL_TREE_BUILDER = registerKey("tree/sequoia/small/tree_builder");
    public static final RegistryKey<PlacedFeature> TREE_PLACER = registerKey("tree/sequoia/template_tree_placer");

    public static final RegistryKey<PlacedFeature> COMMON_EMPTY = registerKey("tree/sequoia/common/empty");
    public static final RegistryKey<PlacedFeature> COMMON_TRUNK_FLOOR = registerKey("tree/sequoia/common/trunk_floor");
    public static final RegistryKey<PlacedFeature> COMMON_TRUNK_LOW = registerKey("tree/sequoia/common/trunk_low");
    public static final RegistryKey<PlacedFeature> COMMON_TRUNK_LOW_TO_MIDDLE = registerKey("tree/sequoia/common/trunk_low_to_middle");
    public static final RegistryKey<PlacedFeature> COMMON_TRUNK_MIDDLE_TO_TOP = registerKey("tree/sequoia/common/trunk_middle_to_top");

    public static final RegistryKey<PlacedFeature> LARGE_TRUNK_TOP_AND_FOLIAGE = registerKey("tree/sequoia/large/trunk_top_and_foliage");
    public static final RegistryKey<PlacedFeature> LARGE_TREE_BUILDER = registerKey("tree/sequoia/large/tree_builder");

    public static final RegistryKey<PlacedFeature> MEDIUM_TRUNK_TOP_AND_FOLIAGE = registerKey("tree/sequoia/medium/trunk_top_and_foliage");
    public static final RegistryKey<PlacedFeature> MEDIUM_TREE_BUILDER = registerKey("tree/sequoia/medium/tree_builder");


    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, SMALL_TRUNK_FLOOR, configuredFeatureRegistryEntryLookup.getOrThrow(SequoiaTreeConfiguredFeatures.SMALL_TRUNK_FLOOR),
                List.of());

        register(context, SMALL_TRUNK_LOW, configuredFeatureRegistryEntryLookup.getOrThrow(SequoiaTreeConfiguredFeatures.SMALL_TRUNK_LOW),
                List.of());

        register(context, SMALL_TRUNK_LOW_TO_MIDDLE, configuredFeatureRegistryEntryLookup.getOrThrow(SequoiaTreeConfiguredFeatures.SMALL_TRUNK_LOW_TO_MIDDLE),
                List.of());

        register(context, SMALL_TRUNK_TOP_AND_FOLIAGE, configuredFeatureRegistryEntryLookup.getOrThrow(SequoiaTreeConfiguredFeatures.SMALL_TRUNK_TOP_AND_FOLIAGE),
                List.of());

        register(context, SMALL_TREE_BUILDER, configuredFeatureRegistryEntryLookup.getOrThrow(SequoiaTreeConfiguredFeatures.SMALL_TREE_BUILDER),
                List.of());

        register(context, COMMON_EMPTY, configuredFeatureRegistryEntryLookup.getOrThrow(SequoiaTreeConfiguredFeatures.COMMON_EMPTY),
                List.of());

        register(context, COMMON_TRUNK_FLOOR, configuredFeatureRegistryEntryLookup.getOrThrow(SequoiaTreeConfiguredFeatures.COMMON_TRUNK_FLOOR),
                List.of());

        register(context, COMMON_TRUNK_LOW, configuredFeatureRegistryEntryLookup.getOrThrow(SequoiaTreeConfiguredFeatures.COMMON_TRUNK_LOW),
                List.of());

        register(context, COMMON_TRUNK_LOW_TO_MIDDLE, configuredFeatureRegistryEntryLookup.getOrThrow(SequoiaTreeConfiguredFeatures.COMMON_TRUNK_LOW_TO_MIDDLE),
                List.of());

        register(context, COMMON_TRUNK_MIDDLE_TO_TOP, configuredFeatureRegistryEntryLookup.getOrThrow(SequoiaTreeConfiguredFeatures.COMMON_TRUNK_MIDDLE_TO_TOP),
                List.of());

        register(context, MEDIUM_TRUNK_TOP_AND_FOLIAGE, configuredFeatureRegistryEntryLookup.getOrThrow(SequoiaTreeConfiguredFeatures.MEDIUM_TRUNK_TOP_AND_FOLIAGE),
                List.of());

        register(context, MEDIUM_TREE_BUILDER, configuredFeatureRegistryEntryLookup.getOrThrow(SequoiaTreeConfiguredFeatures.MEDIUM_TREE_BUILDER),
                List.of());

        register(context, LARGE_TRUNK_TOP_AND_FOLIAGE, configuredFeatureRegistryEntryLookup.getOrThrow(SequoiaTreeConfiguredFeatures.LARGE_TRUNK_TOP_AND_FOLIAGE),
                List.of());

        register(context, LARGE_TREE_BUILDER, configuredFeatureRegistryEntryLookup.getOrThrow(SequoiaTreeConfiguredFeatures.LARGE_TREE_BUILDER),
                List.of());

        register(context, TREE_PLACER, configuredFeatureRegistryEntryLookup.getOrThrow(SequoiaTreeConfiguredFeatures.TREE_PLACER),
                List.of());

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
