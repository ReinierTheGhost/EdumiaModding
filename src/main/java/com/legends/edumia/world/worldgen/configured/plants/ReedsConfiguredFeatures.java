package com.legends.edumia.world.worldgen.configured.plants;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.world.features.reeds.ReedsFeatureConfig;
import com.legends.edumia.world.worldgen.EdumiaFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class ReedsConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> REEDS = registerKey("reeds");
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        register(context, REEDS, EdumiaFeatures.REEDS, new ReedsFeatureConfig(new WeightedBlockStateProvider(
                DataPool.<BlockState>builder().add(BlockLoader.REEDS.getDefaultState(),900)
                        .add(BlockLoader.DRIED_REEDS.getDefaultState(), 100)),
                32, 5, 2, 5, 0.75f));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
