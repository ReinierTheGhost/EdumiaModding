package com.legends.edumia.world.worldgen;

import com.legends.edumia.Edumia;
import com.legends.edumia.world.features.crystal.CrystalFeatureConfig;
import com.legends.edumia.world.worldgen.configured.*;
import com.legends.edumia.world.worldgen.configured.beach.BeachConfiguredFeatures;
import com.legends.edumia.world.worldgen.configured.boulders.BoulderConfiguredFeatures;
import com.legends.edumia.world.worldgen.configured.crystals.CrystalConfiguresFeatures;
import com.legends.edumia.world.worldgen.configured.ocean.ReefConfiguredFeatures;
import com.legends.edumia.world.worldgen.configured.plants.ReedsConfiguredFeatures;
import com.legends.edumia.world.worldgen.configured.trees.*;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;


public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> NOTING = registerKey("noting");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context){

        register(context, NOTING, Feature.NO_OP, new DefaultFeatureConfig());

        BeechTreeConfiguredFeatures.bootstrap(context);
        TreeConfiguredFeatures.bootstrap(context);
        SaplingConfiguredFeatures.bootstrap(context);
        OreConfiguredFeatures.bootstrap(context);
        BushesConfiguredFeatures.bootstrap(context);
        BeachConfiguredFeatures.bootstrap(context);
        ReefConfiguredFeatures.bootstrap(context);
        OakTreeConfiguredFeatures.bootstrap(context);
        RockConfiguredFeatures.bootstrap(context);
        FlowerConfiguredFeatures.bootstrap(context);
        TropicalTreeConfiguredFeatures.bootstrap(context);
        TemperateTreeConfiguredFeatures.bootstrap(context);
        BorealTreeConfiguredFeatures.bootstrap(context);
        BoulderConfiguredFeatures.bootstrap(context);
        CrystalConfiguresFeatures.bootstrap(context);
        ReedsConfiguredFeatures.bootstrap(context);

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
