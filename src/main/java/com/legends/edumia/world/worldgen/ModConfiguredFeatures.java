package com.legends.edumia.world.worldgen;

import com.legends.edumia.Edumia;
import com.legends.edumia.world.worldgen.configured.BushesConfiguredFeatures;
import com.legends.edumia.world.worldgen.configured.OreConfiguredFeatures;
import com.legends.edumia.world.worldgen.configured.TreeConfiguredFeatures;
import com.legends.edumia.world.worldgen.configured.beach.BeachConfiguredFeatures;
import com.legends.edumia.world.worldgen.configured.trees.SaplingConfiguredFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class ModConfiguredFeatures {

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context){
        TreeConfiguredFeatures.bootstrap(context);
        SaplingConfiguredFeatures.bootstrap(context);
        OreConfiguredFeatures.bootstrap(context);
        BushesConfiguredFeatures.bootstrap(context);
        BeachConfiguredFeatures.bootstrap(context);
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
