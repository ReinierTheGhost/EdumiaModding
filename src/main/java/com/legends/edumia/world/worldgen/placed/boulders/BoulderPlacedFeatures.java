package com.legends.edumia.world.worldgen.placed.boulders;

import com.legends.edumia.Edumia;
import com.legends.edumia.world.worldgen.configured.boulders.BoulderConfiguredFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

public class BoulderPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ANDESITE_BOULDER = registerKey("andesite_boulder");
    public static final RegistryKey<PlacedFeature> ANDESITE_BOULDER_2 = registerKey("andesite_boulder_2");
    public static final RegistryKey<PlacedFeature> CALCITE_BOULDER = registerKey("calcite_boulder");
    public static final RegistryKey<PlacedFeature> DIORITE_BOULDER = registerKey("diorite_boulder");
    public static final RegistryKey<PlacedFeature> GRANITE_BOULDER = registerKey("granite_boulder");
    public static final RegistryKey<PlacedFeature> LIMESTONE_BOULDER = registerKey("limestone_boulder");
    public static final RegistryKey<PlacedFeature> SANDSTONE_BOULDER = registerKey("sandstone_boulder");
    public static final RegistryKey<PlacedFeature> STONE_BOULDER = registerKey("stone_boulder");
    public static final RegistryKey<PlacedFeature> MOSSY_BOULDER = registerKey("mossy_boulder");

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> andesite = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.ANDESITE_BOULDER);

        RegistryEntry.Reference<ConfiguredFeature<?, ?>> andesite_2 = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.ANDESITE_BOULDER_2);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> calcite = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.CALCITE_BOULDER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> diorite = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.DIORITE_BOULDER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> granite = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.GRANITE_BOULDER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> limestone = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.LIMESTONE_BOULDER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> sandStone = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.STONE_BOULDER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> stone = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.STONE_BOULDER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> mossy = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.MOSSY_BOULDER);

        PlacementModifier common = PlacedFeatures.createCountExtraModifier(0, 0.5f, 1);
        PlacementModifier placeChance = PlacedFeatures.createCountExtraModifier(0, 0.25f, 1);

        PlacedFeatures.register(featureRegisterable, ANDESITE_BOULDER, andesite, placeChance,
                SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(featureRegisterable, CALCITE_BOULDER, calcite, placeChance,
                SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(featureRegisterable, DIORITE_BOULDER, diorite, placeChance,
                SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(featureRegisterable, GRANITE_BOULDER, granite, placeChance,
                SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(featureRegisterable, LIMESTONE_BOULDER, limestone, placeChance,
                SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(featureRegisterable, STONE_BOULDER, stone, placeChance,
                SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(featureRegisterable, SANDSTONE_BOULDER, sandStone, placeChance,
                SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(featureRegisterable, MOSSY_BOULDER, mossy, placeChance,
                SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        PlacedFeatures.register(featureRegisterable, ANDESITE_BOULDER_2, andesite_2,
                PlacedFeatures.createCountExtraModifier(0, 1.0F/ 16, 4),
                SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }
}
