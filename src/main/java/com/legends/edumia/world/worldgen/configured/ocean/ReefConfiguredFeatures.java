package com.legends.edumia.world.worldgen.configured.ocean;

import com.legends.edumia.Edumia;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

public class ReefConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> REEF_KEY = registerKey("ocean/reef/reef");
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        register(context, REEF_KEY, Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfig(RegistryEntryList.of(
                PlacedFeatures.createEntry(Feature.CORAL_TREE, FeatureConfig.DEFAULT, new PlacementModifier[0]),
                PlacedFeatures.createEntry(Feature.CORAL_CLAW, FeatureConfig.DEFAULT, new PlacementModifier[0]),
                PlacedFeatures.createEntry(Feature.CORAL_MUSHROOM, FeatureConfig.DEFAULT, new PlacementModifier[0])
        )));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
