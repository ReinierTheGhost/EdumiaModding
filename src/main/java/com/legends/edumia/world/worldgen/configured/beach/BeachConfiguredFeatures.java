package com.legends.edumia.world.worldgen.configured.beach;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.Layer;
import com.legends.edumia.block.blocksets.OreRockSets;
import com.legends.edumia.block.blocksets.WoodBlockSets;
import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.Properties;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import java.util.List;

public class BeachConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_SAND_LAYER_FIRST = registerKey("beach/layers/white/first");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_SAND_LAYER_SECOND = registerKey("beach/layers/white/second");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_SAND_LAYER_THIRD = registerKey("beach/layers/white/third");
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        register(context, WHITE_SAND_LAYER_FIRST, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig( new WeightedBlockStateProvider(
                DataPool.<BlockState>builder()
                        .add(BlockLoader.WHITE_SAND_LAYER.getDefaultState().with(Layer.LAYERS, 6), 5)
                        .add(BlockLoader.WHITE_SAND_LAYER.getDefaultState().with(Layer.LAYERS, 7), 4))));

        register(context, WHITE_SAND_LAYER_SECOND, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig( new WeightedBlockStateProvider(
                DataPool.<BlockState>builder()
                        .add(BlockLoader.WHITE_SAND_LAYER.getDefaultState().with(Layer.LAYERS, 4), 1)
                        .add(BlockLoader.WHITE_SAND_LAYER.getDefaultState().with(Layer.LAYERS, 5), 1))));

        register(context, WHITE_SAND_LAYER_THIRD, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig( new WeightedBlockStateProvider(
                DataPool.<BlockState>builder()
                        .add(BlockLoader.WHITE_SAND_LAYER.getDefaultState().with(Layer.LAYERS, 2), 4)
                        .add(BlockLoader.WHITE_SAND_LAYER.getDefaultState().with(Layer.LAYERS, 3), 3))));


    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
