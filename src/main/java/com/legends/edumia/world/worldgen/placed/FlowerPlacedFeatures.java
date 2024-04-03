package com.legends.edumia.world.worldgen.placed;

import com.legends.edumia.Edumia;
import com.legends.edumia.world.worldgen.configured.FlowerConfiguredFeatures;
import com.legends.edumia.world.worldgen.configured.RockConfiguredFeatures;
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

public class FlowerPlacedFeatures {
    public static final RegistryKey<PlacedFeature> AVELION_FLOWER_KEY = registerKey("avelion/flower");

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(context, AVELION_FLOWER_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(FlowerConfiguredFeatures.AVELION_FLOWER_KEY),
                List.of(CountPlacementModifier.of(3),
                        SquarePlacementModifier.of(), HeightmapPlacementModifier.of(Heightmap.Type.MOTION_BLOCKING),
                        BiomePlacementModifier.of()));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Edumia.MOD_ID, "flowers/" + name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
