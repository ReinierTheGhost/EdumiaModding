package com.legends.edumia.world.worldgen.configured.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.world.worldgen.placed.TreePlacedFeatures;
import com.legends.edumia.world.worldgen.placed.trees.SequoiaTreePlacedFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class SaplingConfiguredFeatures {


    public static final RegistryKey<ConfiguredFeature<?, ?>> PALM_TREES = registerKey("tree/palm/palm_trees");



    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RegistryEntryLookup<PlacedFeature> placed = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntry.Reference<PlacedFeature> palm = placed.getOrThrow(TreePlacedFeatures.PALM);
        RegistryEntry.Reference<PlacedFeature> palm2 = placed.getOrThrow(TreePlacedFeatures.PALM2);
        RegistryEntry.Reference<PlacedFeature> palm3 = placed.getOrThrow(TreePlacedFeatures.PALM3);


        register(context, PALM_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(palm, 0.4f),
                new RandomFeatureEntry(palm2, 0.4f)),
                palm3));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
