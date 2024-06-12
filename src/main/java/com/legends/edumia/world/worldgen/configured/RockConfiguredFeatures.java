package com.legends.edumia.world.worldgen.configured;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.blocksets.StoneSets;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class RockConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> AVELION_MOUNTAIN_LAYERS_KEY = registerKey("avelion/mountain_layers");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){

        register(context, AVELION_MOUNTAIN_LAYERS_KEY, Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfig(RegistryEntryList.of(
                PlacedFeatures.createEntry(Feature.NETHERRACK_REPLACE_BLOBS, new ReplaceBlobsFeatureConfig(Blocks.TERRACOTTA.getDefaultState(),
                        StoneSets.HIGH_ELVEN_ROCK.block().getDefaultState(), UniformIntProvider.create(7, 12))),
                PlacedFeatures.createEntry(Feature.NETHERRACK_REPLACE_BLOBS, new ReplaceBlobsFeatureConfig(Blocks.YELLOW_TERRACOTTA.getDefaultState(),
                        StoneSets.DARK_HIGH_ELVEN_ROCK.block().getDefaultState(), UniformIntProvider.create(7, 12))),
                PlacedFeatures.createEntry(Feature.NETHERRACK_REPLACE_BLOBS,  new ReplaceBlobsFeatureConfig(Blocks.ORANGE_TERRACOTTA.getDefaultState(),
                        StoneSets.LIGHT_HIGH_ELVEN_ROCK.block().getDefaultState(), UniformIntProvider.create(7, 12))),
                PlacedFeatures.createEntry(Feature.NETHERRACK_REPLACE_BLOBS, new ReplaceBlobsFeatureConfig(Blocks.RED_TERRACOTTA.getDefaultState(),
                        StoneSets.LIGHT_HIGH_ELVEN_ROCK.block().getDefaultState(), UniformIntProvider.create(7, 12))),
                PlacedFeatures.createEntry(Feature.NETHERRACK_REPLACE_BLOBS, new ReplaceBlobsFeatureConfig(Blocks.LIGHT_GRAY_TERRACOTTA.getDefaultState(),
                        StoneSets.LIGHT_HIGH_ELVEN_ROCK.block().getDefaultState(), UniformIntProvider.create(7, 12))),
                PlacedFeatures.createEntry(Feature.NETHERRACK_REPLACE_BLOBS, new ReplaceBlobsFeatureConfig(Blocks.WHITE_TERRACOTTA.getDefaultState(),
                        StoneSets.LIGHT_HIGH_ELVEN_ROCK.block().getDefaultState(), UniformIntProvider.create(7, 12))),
                PlacedFeatures.createEntry(Feature.NETHERRACK_REPLACE_BLOBS, new ReplaceBlobsFeatureConfig(Blocks.BROWN_TERRACOTTA.getDefaultState(),
                        StoneSets.DARK_HIGH_ELVEN_ROCK.block().getDefaultState(), UniformIntProvider.create(7, 12)))
        )));

    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, "rock/" +name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
