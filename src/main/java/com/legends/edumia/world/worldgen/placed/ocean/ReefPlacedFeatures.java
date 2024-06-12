package com.legends.edumia.world.worldgen.placed.ocean;

import com.legends.edumia.Edumia;
import com.legends.edumia.world.worldgen.configured.ocean.ReefConfiguredFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.NoiseBasedCountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class ReefPlacedFeatures {

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, REEF_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ReefConfiguredFeatures.REEF_KEY),
                List.of(NoiseBasedCountPlacementModifier.of(20, 400.0, 0.0),
                        SquarePlacementModifier.of(), PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP, BiomePlacementModifier.of()));
    }
    public static final RegistryKey<PlacedFeature> REEF_KEY = registerKey("ocean/reef/reef");

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
