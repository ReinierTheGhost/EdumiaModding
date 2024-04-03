package com.legends.edumia.world.worldgen.placed;

import com.legends.edumia.Edumia;
import com.legends.edumia.world.worldgen.configured.RockConfiguredFeatures;
import com.legends.edumia.world.worldgen.placed.ocean.ReefPlacedFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class RockPlacedFeatures {
    public static final RegistryKey<PlacedFeature> AVELION_MOUNTAIN_LAYERS = registerKey("avelion/mountain_layers");

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(context, AVELION_MOUNTAIN_LAYERS, configuredFeatureRegistryEntryLookup.getOrThrow(RockConfiguredFeatures.AVELION_MOUNTAIN_LAYERS_KEY),
                List.of(CountPlacementModifier.of(22), CountPlacementModifier.of(74),
                        SquarePlacementModifier.of(), HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE_WG),
                        BiomePlacementModifier.of()));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Edumia.MOD_ID, "rock/" + name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
