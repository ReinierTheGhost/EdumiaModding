package com.legends.edumia.world.worldgen.configured.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.blocksets.WoodBlockSets;
import com.legends.edumia.world.worldgen.trees.foliageplacer.ClusterFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.foliageplacer.OvalFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.CanopyTrunkPlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.EdumiaGiantTrunkPlacer;
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
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;

import java.util.List;

public class BeechTreeConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PARTY_BEECH_KEY = registerKey("party_beech_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GIGA_BEECH_KEY = registerKey("giga_beech_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BEECH_KEY = registerKey("beech_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_BEECH_KEY = registerKey("big_beech_tree");
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        register(context, GIGA_BEECH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.BEECH.log()),
                new EdumiaGiantTrunkPlacer(20, 20, 0, WoodBlockSets.BEECH.wood().getDefaultState(),
                        WoodBlockSets.BEECH.woodWall().getDefaultState()),
                BlockStateProvider.of(WoodBlockSets.BEECH.leaves()),
                new ClusterFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0)),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, PARTY_BEECH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.BEECH.log()),
                new PartyTreeTrunkPlacer(10, 14, 0, WoodBlockSets.BEECH.wood().getDefaultState(),
                        WoodBlockSets.BEECH.woodWall().getDefaultState()),
                BlockStateProvider.of(WoodBlockSets.BEECH.leaves()),
                new ClusterFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),
                new TwoLayersFeatureSize(1, 0, 0)).build());

        register(context, BEECH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.BEECH.log()),
                new CanopyTrunkPlacer(12, 2, 0.91f, 0.87f, 5.0f, 3, 0.42f, -0.1f, 1,1),
                BlockStateProvider.of(WoodBlockSets.BEECH.leaves()),
                new OvalFoliagePlacer(3, ConstantIntProvider.create(0), ConstantIntProvider.create(2), 0.4f),
                new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());

        register(context, BIG_BEECH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.BEECH.log()),
                new CanopyTrunkPlacer(18, 3, 1.0f, 0.67f, 5.2f, 3,
                        0.44f, -0.05f, 2, 1),
                BlockStateProvider.of(WoodBlockSets.BEECH.leaves()),
                new OvalFoliagePlacer(2, ConstantIntProvider.create(0), ConstantIntProvider.create(3), 0.4f),
                new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, "tree/beech/" +name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
