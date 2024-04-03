package com.legends.edumia.world.worldgen.configured.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.blocksets.WoodBlockSets;
import com.legends.edumia.world.worldgen.trees.foliageplacer.ClusterFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.foliageplacer.OakFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.CanopyTrunkPlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.PartyTreeTrunkPlacer;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class OakTreeConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PARTY_RED_OAK_KEY = registerKey("red/party_red_oak_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){

        register(context, PARTY_RED_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.RED_OAK.log()),
                new CanopyTrunkPlacer(12, 2, 0.91f, 0.87f, 5.0f, 3,
                        0.42f, -0.1f, 1,1),
                BlockStateProvider.of(WoodBlockSets.RED_OAK.leaves()),
                new OakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 0)).build());

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, "tree/oaks/" +name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
