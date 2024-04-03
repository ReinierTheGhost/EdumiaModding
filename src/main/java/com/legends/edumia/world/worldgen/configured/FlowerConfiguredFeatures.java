package com.legends.edumia.world.worldgen.configured;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.blocksets.StoneSets;
import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class FlowerConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> AVELION_FLOWER_KEY = registerKey("avelion/flower");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        register(context, AVELION_FLOWER_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(8, 6, 2,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(
                        DataPool.<BlockState>builder().add(BlockLoader.ASPHODEL.getDefaultState(), 1))))));

    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, "flowers/" +name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
