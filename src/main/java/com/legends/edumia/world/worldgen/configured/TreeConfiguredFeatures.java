package com.legends.edumia.world.worldgen.configured;

import com.google.common.collect.ImmutableList;
import com.legends.edumia.Edumia;
import com.legends.edumia.block.ModNatureBlocks;
import com.legends.edumia.block.blocksets.WoodBlockSets;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.world.worldgen.trees.foliageplacer.AspenFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.foliageplacer.BoughsFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.foliageplacer.CederFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.foliageplacer.GhostGumFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.BoughsTrunkPlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.CederTrunkPlacer;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.treedecorator.*;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import org.apache.logging.log4j.core.appender.db.jdbc.ColumnConfig;

import java.util.ArrayList;
import java.util.List;

public class TreeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> APPLE_KEY = registerKey("tree/apple_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASPEN_KEY = registerKey("tree/aspen_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CEDER_KEY = registerKey("tree/ceder_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARGE_CEDER_KEY = registerKey("tree/large_ceder_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TEST_KEY = registerKey("tree/test_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> GHOST_GUM_KEY = registerKey("tree/ghost_gum_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GHOST_GUM_BEES_KEY = registerKey("tree/ghost_gum_bees_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_ASH_KEY = registerKey("tree/white_ash_tree");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        BeehiveTreeDecorator beehiveTreeDecorator = new BeehiveTreeDecorator(0.05f);

        /**
         * only change the Key
         */
        register(context, TEST_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                /**
                 * Block for the Trunk
                 */
                BlockStateProvider.of(WoodBlockSets.CEDAR.log()),
                /**
                 * Type of trunk you want to use, with the height parameters and additional blocks
                 */
                new GiantTrunkPlacer(15, 15, 0),

                /**
                 * leaves you want to use
                 */
                BlockStateProvider.of(WoodBlockSets.CEDAR.leaves()),

                /**
                 * Type of Foliage you want to use, first 2 parameters can be a ConstantIntProvider(one fixed number)
                 * or a UniformIntProvider(Min number, max number)
                 */
                new CederFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),

                /**
                 * mainly for world gen and placement
                 */
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines()
                .dirtProvider(BlockStateProvider.of(BlockLoader.WHITE_SAND.getDefaultState()))
                .decorators(List.of(beehiveTreeDecorator)).build());





        register(context, LARGE_CEDER_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.CEDAR.log()),
                new CederTrunkPlacer(15, 15, 0, WoodBlockSets.CEDAR.wood().getDefaultState(),
                        WoodBlockSets.CEDAR.woodWall().getDefaultState()),

                BlockStateProvider.of(WoodBlockSets.CEDAR.leaves()),
                new CederFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),

                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, CEDER_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.CEDAR.log()),
                new CederTrunkPlacer(10, 6, 0, WoodBlockSets.CEDAR.wood().getDefaultState(),
                        WoodBlockSets.CEDAR.woodWall().getDefaultState()),

                BlockStateProvider.of(WoodBlockSets.CEDAR.leaves()),
                new CederFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),

                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, WHITE_ASH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.WHITE_ASH.log()),
                new BoughsTrunkPlacer(10, 4, 0, WoodBlockSets.WHITE_ASH.wood().getDefaultState(),
                        WoodBlockSets.WHITE_ASH.woodWall().getDefaultState()),

                BlockStateProvider.of(WoodBlockSets.WHITE_ASH.leaves()),
                new BoughsFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), 3),

                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());


        register(context, ASPEN_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.ASPEN.log()),
                new StraightTrunkPlacer(8, 7, 0),

                BlockStateProvider.of(WoodBlockSets.ASPEN.leaves()),
                new AspenFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(2), ConstantIntProvider.create(2)),

                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, APPLE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.APPLE.log()),
                new StraightTrunkPlacer(4, 3, 2),

                BlockStateProvider.of(WoodBlockSets.APPLE.leaves()),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, GHOST_GUM_KEY, Feature.TREE, buildClassicTreeWithSpecifiedFoliage(WoodBlockSets.GHOST_GUM.log().getDefaultState(),
                BlockStateProvider.of(ModNatureBlocks.GHOST_GUM_LEAVES), 5, 4,
                new GhostGumFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 4),
                false, false));

        register(context, GHOST_GUM_BEES_KEY, Feature.TREE, buildClassicTreeWithSpecifiedFoliage(WoodBlockSets.GHOST_GUM.log().getDefaultState(),
                BlockStateProvider.of(ModNatureBlocks.GHOST_GUM_LEAVES), 5, 4,
                new GhostGumFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 4),
                true, false));

    }

    private static TreeFeatureConfig buildClassicTreeWithSpecifiedFoliage(BlockState log, BlockStateProvider leavesPool, int baseHeight,
                                                                          int heightRandA, FoliagePlacer foliage, boolean bees, boolean vines){
        List<TreeDecorator> decorators = new ArrayList<>();
        BeehiveTreeDecorator beehiveTreeDecorator = new BeehiveTreeDecorator(0.05f);

        if (bees){
            decorators.add(beehiveTreeDecorator);
        }

        if (vines){
            decorators.add(TrunkVineTreeDecorator.INSTANCE);
            decorators.add(new LeavesVineTreeDecorator(0.25f));
        }

        return (new TreeFeatureConfig.Builder(BlockStateProvider.of(log),new StraightTrunkPlacer(baseHeight, heightRandA, 0), leavesPool,
                foliage, new TwoLayersFeatureSize(1, 0, 1))).ignoreVines()
                .decorators(ImmutableList.copyOf(decorators)).build();
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
