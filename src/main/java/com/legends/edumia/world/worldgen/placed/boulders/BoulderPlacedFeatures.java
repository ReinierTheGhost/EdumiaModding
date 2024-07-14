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
    public static final RegistryKey<PlacedFeature> BIG_ANDESITE_BOULDER = registerKey("big_andesite_boulder");
    public static final RegistryKey<PlacedFeature> CALCITE_BOULDER = registerKey("calcite_boulder");
    public static final RegistryKey<PlacedFeature> BIG_CALCITE_BOULDER = registerKey("big_calcite_boulder");
    public static final RegistryKey<PlacedFeature> DIORITE_BOULDER = registerKey("diorite_boulder");
    public static final RegistryKey<PlacedFeature> BIG_DIORITE_BOULDER = registerKey("big_diorite_boulder");
    public static final RegistryKey<PlacedFeature> GRANITE_BOULDER = registerKey("granite_boulder");
    public static final RegistryKey<PlacedFeature> BIG_GRANITE_BOULDER = registerKey("big_granite_boulder");
    public static final RegistryKey<PlacedFeature> LIMESTONE_BOULDER = registerKey("limestone_boulder");
    public static final RegistryKey<PlacedFeature> BIG_LIMESTONE_BOULDER = registerKey("big_limestone_boulder");
    public static final RegistryKey<PlacedFeature> SANDSTONE_BOULDER = registerKey("sandstone_boulder");
    public static final RegistryKey<PlacedFeature> BIG_SANDSTONE_BOULDER = registerKey("big_sandstone_boulder");
    public static final RegistryKey<PlacedFeature> STONE_BOULDER = registerKey("stone_boulder");
    public static final RegistryKey<PlacedFeature> BIG_STONE_BOULDER = registerKey("big_stone_boulder");
    public static final RegistryKey<PlacedFeature> MOSSY_BOULDER = registerKey("mossy_boulder");
    public static final RegistryKey<PlacedFeature> BIG_MOSSY_BOULDER = registerKey("big_mossy_boulder");

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> andesite = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.ANDESITE_BOULDER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> big_andesite = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.BIG_ANDESITE_BOULDER);

        RegistryEntry.Reference<ConfiguredFeature<?, ?>> calcite = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.CALCITE_BOULDER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> big_calcite = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.BIG_CALCITE_BOULDER);

        RegistryEntry.Reference<ConfiguredFeature<?, ?>> diorite = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.DIORITE_BOULDER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> big_diorite = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.BIG_DIORITE_BOULDER);

        RegistryEntry.Reference<ConfiguredFeature<?, ?>> granite = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.GRANITE_BOULDER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> big_granite = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.BIG_GRANITE_BOULDER);

        RegistryEntry.Reference<ConfiguredFeature<?, ?>> limestone = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.LIMESTONE_BOULDER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> big_limestone = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.BIG_LIMESTONE_BOULDER);

        RegistryEntry.Reference<ConfiguredFeature<?, ?>> sandStone = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.SANDSTONE_BOULDER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> big_sandStone = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.BIG_SANDSTONE_BOULDER);

        RegistryEntry.Reference<ConfiguredFeature<?, ?>> stone = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.STONE_BOULDER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> big_stone = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.BIG_STONE_BOULDER);

        RegistryEntry.Reference<ConfiguredFeature<?, ?>> mossy = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.MOSSY_BOULDER);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> big_mossy = registryEntryLookup.getOrThrow(BoulderConfiguredFeatures.BIG_MOSSY_BOULDER);

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

        PlacedFeatures.register(featureRegisterable, BIG_ANDESITE_BOULDER, big_andesite,
                PlacedFeatures.createCountExtraModifier(0, 1.0F/ 16, 4),
                SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of());

        PlacedFeatures.register(featureRegisterable, BIG_DIORITE_BOULDER, big_diorite,
                PlacedFeatures.createCountExtraModifier(0, 1.0F/ 16, 4),
                SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of());
        PlacedFeatures.register(featureRegisterable, BIG_CALCITE_BOULDER, big_calcite,
                PlacedFeatures.createCountExtraModifier(0, 1.0F/ 16, 4),
                SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of());
        PlacedFeatures.register(featureRegisterable, BIG_GRANITE_BOULDER, big_granite,
                PlacedFeatures.createCountExtraModifier(0, 1.0F/ 16, 4),
                SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of());
        PlacedFeatures.register(featureRegisterable, BIG_LIMESTONE_BOULDER, big_limestone,
                PlacedFeatures.createCountExtraModifier(0, 1.0F/ 16, 4),
                SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of());

        PlacedFeatures.register(featureRegisterable, BIG_SANDSTONE_BOULDER, big_sandStone,
                PlacedFeatures.createCountExtraModifier(0, 1.0F/ 16, 4),
                SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of());

        PlacedFeatures.register(featureRegisterable, BIG_STONE_BOULDER, big_stone,
                PlacedFeatures.createCountExtraModifier(0, 1.0F/ 16, 4),
                SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of());

        PlacedFeatures.register(featureRegisterable, BIG_MOSSY_BOULDER, big_mossy,
                PlacedFeatures.createCountExtraModifier(0, 1.0F/ 16, 4),
                SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Edumia.MOD_ID, "boulders/" + name));
    }
}
