package com.legends.edumia.world.worldgen.placed;

import com.legends.edumia.Edumia;
import com.legends.edumia.world.worldgen.configured.TreeConfiguredFeatures;
import com.legends.edumia.world.worldgen.placed.trees.SequoiaTreePlacedFeatures;
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
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class TreePlacedFeatures {

    public static final RegistryKey<PlacedFeature> BEECH_KEY = registerKey("tree/beech_tree");

    public static final RegistryKey<PlacedFeature> PALM = registerKey("tree/palm/palm");
    public static final RegistryKey<PlacedFeature> PALM2 = registerKey("tree/palm/palm2");
    public static final RegistryKey<PlacedFeature> PALM3 = registerKey("tree/palm/palm3");


    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, BEECH_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.BEECH_KEY),
                List.of(CountPlacementModifier.of(6), SquarePlacementModifier.of(), HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE),
                        NoiseBasedCountPlacementModifier.of(157, 0, 9),
                        BlockFilterPlacementModifier.of(BlockPredicate.matchingBlocks(Blocks.GRASS_BLOCK, Blocks.DIRT)),
                        BiomePlacementModifier.of()));

        register(context, PALM, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.PALM),
                List.of());

        register(context, PALM2, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.PALM2),
                List.of());

        register(context, PALM3, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.PALM3),
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
