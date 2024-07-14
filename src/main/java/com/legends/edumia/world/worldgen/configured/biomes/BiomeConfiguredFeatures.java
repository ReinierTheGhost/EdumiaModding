package com.legends.edumia.world.worldgen.configured.biomes;

import com.legends.edumia.Edumia;
import com.legends.edumia.world.worldgen.ModPlacedFeatures;
import com.legends.edumia.world.worldgen.placed.trees.BorealTreePlacedFeatures;
import com.legends.edumia.world.worldgen.placed.trees.OakTreePlacedFeatures;
import com.legends.edumia.world.worldgen.placed.trees.TemperateTreePlacedFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class BiomeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> DARK_ELVEN_OAK_TREES_KEY = registerKey("dark_elven/trees");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RegistryEntryLookup<PlacedFeature> registryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RegistryEntry.Reference<PlacedFeature> normal_green_oak = registryEntryLookup.getOrThrow(OakTreePlacedFeatures.LIST_GREEN_OAK_PLACED_TREE_KEY);
        RegistryEntry.Reference<PlacedFeature> normal_red_oak = registryEntryLookup.getOrThrow(OakTreePlacedFeatures.LIST_RED_OAK_PLACED_TREE_KEY);
        RegistryEntry.Reference<PlacedFeature> normal_black_oak = registryEntryLookup.getOrThrow(OakTreePlacedFeatures.LIST_BLACK_OAK_PLACED_TREE_KEY);

        RegistryEntry.Reference<PlacedFeature> noting = registryEntryLookup.getOrThrow(ModPlacedFeatures.NOTING);
        RegistryEntry.Reference<PlacedFeature> small_green_oak = registryEntryLookup.getOrThrow(OakTreePlacedFeatures.LIST_SMALL_GREEN_OAK_PLACED_TREE_KEY);
        RegistryEntry.Reference<PlacedFeature> small_red_oak = registryEntryLookup.getOrThrow(OakTreePlacedFeatures.LIST_SMALL_RED_OAK_PLACED_TREE_KEY);
        RegistryEntry.Reference<PlacedFeature> small_black_oak = registryEntryLookup.getOrThrow(OakTreePlacedFeatures.LIST_SMALL_BLACK_OAK_PLACED_TREE_KEY);

        RegistryEntry.Reference<PlacedFeature> large_green_oak = registryEntryLookup.getOrThrow(OakTreePlacedFeatures.LIST_LARGE_GREEN_OAK_PLACED_TREE_KEY);
        RegistryEntry.Reference<PlacedFeature> large_red_oak = registryEntryLookup.getOrThrow(OakTreePlacedFeatures.LIST_LARGE_RED_OAK_PLACED_TREE_KEY);
        RegistryEntry.Reference<PlacedFeature> large_black_oak = registryEntryLookup.getOrThrow(OakTreePlacedFeatures.LIST_LARGE_BLACK_OAK_PLACED_TREE_KEY);

        RegistryEntry.Reference<PlacedFeature> mega_green_oak = registryEntryLookup.getOrThrow(OakTreePlacedFeatures.LIST_MEGA_GREEN_OAK_PLACED_TREE_KEY);
        RegistryEntry.Reference<PlacedFeature> mega_red_oak = registryEntryLookup.getOrThrow(OakTreePlacedFeatures.LIST_MEGA_RED_OAK_PLACED_TREE_KEY);
        RegistryEntry.Reference<PlacedFeature> mega_black_oak = registryEntryLookup.getOrThrow(OakTreePlacedFeatures.LIST_MEGA_BLACK_OAK_PLACED_TREE_KEY);

        RegistryEntry.Reference<PlacedFeature> silver_spruce = registryEntryLookup.getOrThrow(BorealTreePlacedFeatures.SILVER_SPRUCE_TREE_LIST);
        RegistryEntry.Reference<PlacedFeature> holly = registryEntryLookup.getOrThrow(TemperateTreePlacedFeatures.HOLLY_TREE_KEY);
        RegistryEntry.Reference<PlacedFeature> holly_with_bees = registryEntryLookup.getOrThrow(TemperateTreePlacedFeatures.HOLLY_BEES_TREE_KEY);

        RegistryEntry.Reference<PlacedFeature> colossal_green_oak = registryEntryLookup.getOrThrow(OakTreePlacedFeatures.LIST_COLOSSAL_GREEN_OAK_PLACED_TREE_KEY);
        RegistryEntry.Reference<PlacedFeature> colossal_red_oak = registryEntryLookup.getOrThrow(OakTreePlacedFeatures.LIST_COLOSSAL_RED_OAK_PLACED_TREE_KEY);
        RegistryEntry.Reference<PlacedFeature> colossal_black_oak = registryEntryLookup.getOrThrow(OakTreePlacedFeatures.LIST_MEGA_BLACK_OAK_PLACED_TREE_KEY);

        register(context, DARK_ELVEN_OAK_TREES_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                // Red Oak
                new RandomFeatureEntry(mega_red_oak, 0.038f),   // 10% of 38%
                new RandomFeatureEntry(large_red_oak, 0.076f),  // 20% of 38%
                new RandomFeatureEntry(small_red_oak, 0.133f),  // 35% of 38%
                new RandomFeatureEntry(normal_red_oak, 0.133f), // 35% of 38%

                // Green Oak
                new RandomFeatureEntry(mega_green_oak, 0.038f),   // 10% of 38%
                new RandomFeatureEntry(large_green_oak, 0.076f),  // 20% of 38%
                new RandomFeatureEntry(small_green_oak, 0.133f),  // 35% of 38%
                new RandomFeatureEntry(normal_green_oak, 0.133f), // 35% of 38%

                // Black Oak
                new RandomFeatureEntry(mega_black_oak, 0.019f),   // 10% of 19%
                new RandomFeatureEntry(large_black_oak, 0.038f),  // 20% of 19%
                new RandomFeatureEntry(small_black_oak, 0.0665f), // 35% of 19%
                new RandomFeatureEntry(normal_black_oak, 0.0665f), // 35% of 19%

                // Silver Spruce
                new RandomFeatureEntry(silver_spruce, 0.025f), // 2.5%

                // Holly Tree
                new RandomFeatureEntry(holly, 0.0125f),       // 50% of 2.5%
                new RandomFeatureEntry(holly_with_bees, 0.0125f)     // 50% of 2.5%
        ),noting));


    }
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, "biomes" +name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
