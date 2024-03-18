package com.legends.edumia.world.worldgen.configured;

import com.google.common.collect.ImmutableList;
import com.legends.edumia.Edumia;
import com.legends.edumia.block.ModNatureBlocks;
import com.legends.edumia.block.blocksets.WoodBlockSets;
import com.legends.edumia.world.worldgen.trees.foliageplacer.*;
import com.legends.edumia.world.worldgen.trees.treedecorators.HangingBranchDecorator;
import com.legends.edumia.world.worldgen.trees.treedecorators.PineBranchDecorator;
import com.legends.edumia.world.worldgen.trees.treeplacers.trunks.TinyTreeTrunk;
import com.legends.edumia.world.worldgen.trees.trunkplacers.*;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.BiasedToBottomIntProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.*;
import net.minecraft.world.gen.trunk.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;

public class TreeConfiguredFeatures {


    public static final RegistryKey<ConfiguredFeature<?, ?>> APPLE_KEY = registerKey("tree/apple_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ASPEN_KEY = registerKey("tree/aspen/aspen_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASPEN_2_KEY = registerKey("tree/aspen/aspen_2_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TINY_BEECH_KEY = registerKey("tree/tiny_beech_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BEECH_KEY = registerKey("tree/beech_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_BEECH_KEY = registerKey("tree/big_beech_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CEDER_KEY = registerKey("tree/ceder_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARGE_CEDER_KEY = registerKey("tree/large_ceder_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TEST_KEY = registerKey("tree/test/test_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TEST2_KEY = registerKey("tree/test/test2_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> GHOST_GUM_KEY = registerKey("tree/ghost_gum_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GHOST_GUM_BEES_KEY = registerKey("tree/ghost_gum_bees_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_ASH_KEY = registerKey("tree/white_ash_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CYPRESS_KEY = registerKey("tree/cypress_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FIR_KEY = registerKey("tree/fir_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HOLLY_KEY = registerKey("tree/holly_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SILVER_SPRUCE_KEY = registerKey("tree/silver_spruce_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARCH_KEY = registerKey("tree/larch/larch_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_LARCH_KEY = registerKey("tree/larch/big_larch_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GREEN_OAK_KEY = registerKey("tree/green_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_OAK_KEY = registerKey("tree/red_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLACK_OAK_KEY = registerKey("tree/black_oak_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> PINE_KEY = registerKey("tree/pine_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> REDWOOD_KEY = registerKey("tree/redwood_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLACKTHORN_KEY = registerKey("tree/blackthorn_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DRAGON_BLOOD_SMALL_KEY = registerKey("tree/dragon_blood_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALM = registerKey("tree/palm");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALM2 = registerKey("tree/palm2");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALM3 = registerKey("tree/palm3");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MAHOGANY = registerKey("tree/mahogany");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        BeehiveTreeDecorator beehiveTreeDecorator = new BeehiveTreeDecorator(0.03f);
        BlockStateProvider pineBranchProvider = (new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(WoodBlockSets.PINE.log().getDefaultState(), 2).add(WoodBlockSets.PINE.strippedLog().getDefaultState(), 1)));

        register(context, TINY_BEECH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
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

        register(context, MAHOGANY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.MAHOGANY.log()),
                new MahoganyTrunkPlacer(8, 6, 0, WoodBlockSets.MAHOGANY.wood().getDefaultState(),
                        WoodBlockSets.MAHOGANY.woodWall().getDefaultState()),
                BlockStateProvider.of(WoodBlockSets.MAHOGANY.leaves()),
                new MahoganyFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(0, 1, 0))
                .decorators(List.of(new LeavesVineTreeDecorator(0.25f),
                        new HangingBranchDecorator(0.25F,
                                BlockStateProvider.of(WoodBlockSets.MAHOGANY.leaves().getDefaultState().with(Properties.PERSISTENT, true)),
                                BlockStateProvider.of(WoodBlockSets.MAHOGANY.leaves().getDefaultState().with(Properties.PERSISTENT, true))
                        ))).build());

        register(context, TEST_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.MAPLE.log()),
                new StraightTrunkPlacer(14, 4, 4),
                BlockStateProvider.of(ModNatureBlocks.MAPLE_LEAVES.getDefaultState()),
                new WillowFoliagePlacer( ConstantIntProvider.create(4), ConstantIntProvider.create(0)),
                new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());

        register(context, DRAGON_BLOOD_SMALL_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.DRAGON_BLOOD.log()),
                new DragonBloodTrunkPlacer(3, 4, 0, WoodBlockSets.DRAGON_BLOOD.wood().getDefaultState(), WoodBlockSets.DRAGON_BLOOD.woodWall().getDefaultState()),
                BlockStateProvider.of(WoodBlockSets.DRAGON_BLOOD.leaves()),
                new DragonBloodFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, PALM3, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.PALM.log()),
                new SlantedTrunkPlacer(9, 6, 7),
                BlockStateProvider.of(WoodBlockSets.PALM.leaves()),
                new LargeParasolPalmFoliagePlacer(),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).ignoreVines().build());

        register(context, PALM2, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.PALM.log()),
                new SlantedTrunkPlacer(6, 4, 5),
                BlockStateProvider.of(WoodBlockSets.PALM.leaves()),
                new ParasolPalmFoliagePlacer(),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, PALM, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.PALM.log()),
                new PalmTrunkPlacer(10, 2, 0.02f, 0.07f, 0),
                BlockStateProvider.of(WoodBlockSets.PALM.leaves()),
                new PalmFoliagePlacer(4, ConstantIntProvider.create(0), ConstantIntProvider.create(1), -0.3f, 0.3f),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, TEST2_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.BEECH.log()),
                new ForkingTrunkPlacer(5, 4, 8),
                BlockStateProvider.of(WoodBlockSets.BEECH.leaves()),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(2), 2),
                new TwoLayersFeatureSize(1, 0, 1)).decorators(List.of(beehiveTreeDecorator)).ignoreVines().build());

        register(context, BLACKTHORN_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.BLACKTHORN.log()),
                new ForkingTrunkPlacer(5, 4, 0),
                BlockStateProvider.of(WoodBlockSets.BLACKTHORN.leaves()),
                new AspenFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1), ConstantIntProvider.create(2)),

                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, REDWOOD_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.REDWOOD.log()),
                new MediumRedwoodTrunkPlacer(WoodBlockSets.REDWOOD.wood().getDefaultState()),
                BlockStateProvider.of(WoodBlockSets.REDWOOD.leaves()),
                new EdumiaPineFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), ConstantIntProvider.create(20)),

                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, PINE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.PINE.log()),
                new StraightTrunkPlacer(12, 12, 0),
                BlockStateProvider.of(WoodBlockSets.PINE.leaves()),
                new PinusFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1), UniformIntProvider.create(6, 12)),

                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines()
                .decorators(Collections.singletonList(new PineBranchDecorator(WoodBlockSets.PINE.log().getDefaultState(), 0.75f))).build());


        
        register(context, RED_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.RED_OAK.log()),
                new OakTrunkPlacer(4, 4, 0, WoodBlockSets.RED_OAK.wood().getDefaultState(),
                        WoodBlockSets.RED_OAK.woodWall().getDefaultState()),
                BlockStateProvider.of(WoodBlockSets.RED_OAK.leaves()),
                new OakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 3),

                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, BLACK_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.BLACK_OAK.log()),
                new OakTrunkPlacer(4, 4, 0, WoodBlockSets.BLACK_OAK.wood().getDefaultState(),
                        WoodBlockSets.BLACK_OAK.woodWall().getDefaultState()),
                BlockStateProvider.of(ModNatureBlocks.BLACK_OAK_LEAVES),
                new OakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, GREEN_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.GREEN_OAK.log()),
                new OakTrunkPlacer(4, 4, 0, WoodBlockSets.GREEN_OAK.wood().getDefaultState(),
                        WoodBlockSets.GREEN_OAK.woodWall().getDefaultState()),
                BlockStateProvider.of(WoodBlockSets.GREEN_OAK.leaves()),
                new OakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 3),

                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, LARCH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.LARCH.log()),
                new StraightTrunkPlacer(8, 8, 0),
                BlockStateProvider.of(WoodBlockSets.LARCH.leaves()),
                new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), ConstantIntProvider.create(1), UniformIntProvider.create(1, 3)),

                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, BIG_LARCH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.LARCH.log()),
                new StraightTrunkPlacer(8, 4, 13),
                BlockStateProvider.of(WoodBlockSets.LARCH.leaves()),
                new MegaPineFoliagePlacer(BiasedToBottomIntProvider.create(1, 1), UniformIntProvider.create(1, 3), UniformIntProvider.create(12, 22)),

                new TwoLayersFeatureSize(1, 0, 1, OptionalInt.of(0)))
                .dirtProvider(BlockStateProvider.of(Blocks.COARSE_DIRT)).ignoreVines().forceDirt().build());

        register(context, SILVER_SPRUCE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.SILVER_SPRUCE.log()),
                new StraightTrunkPlacer(5, 3, 0),
                BlockStateProvider.of(WoodBlockSets.SILVER_SPRUCE.leaves()),
                new SilverSpruceFoliagePlacer(ConstantIntProvider.create(2), UniformIntProvider.create(0, 2), UniformIntProvider.create(7, 11)),

                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());

        register(context, HOLLY_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.HOLLY.log()),
                new StraightTrunkPlacer(9, 5, 0),
                BlockStateProvider.of(ModNatureBlocks.HOLLY_LEAVES),
                new HollyFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(2), UniformIntProvider.create(1, 3)),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, FIR_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.FIR.log()),
                new StraightTrunkPlacer(6, 7, 0),
                BlockStateProvider.of(WoodBlockSets.FIR.leaves()),
                new FirFoliagePlacer(UniformIntProvider.create(2, 3), ConstantIntProvider.create(2), UniformIntProvider.create(7, 11)),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, CYPRESS_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.CYPRESS.log()),
                new StraightTrunkPlacer(8, 5, 0),
                BlockStateProvider.of(WoodBlockSets.CYPRESS.leaves()),
                new CypressFoliagePlacer(UniformIntProvider.create(1, 2), ConstantIntProvider.create(1), UniformIntProvider.create(1, 3)),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());


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

        register(context, ASPEN_2_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WoodBlockSets.ASPEN.log()),
                new StraightTrunkPlacer(4, 3, 6),

                new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(WoodBlockSets.ASPEN.leaves().getDefaultState(), 4)
                        .add(Blocks.AIR.getDefaultState(), 1)),
                new PineFoliagePlacer(UniformIntProvider.create(2, 3), ConstantIntProvider.create(1), ConstantIntProvider.create(3)),

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

    private static TreeFeatureConfig buildEdumiaMegaTree(BlockState log, BlockState leaves, BlockState wood, BlockState strippedLog, boolean vines){
        List<TreeDecorator> decorators = new ArrayList<>();

        if (vines){
            decorators.add(TrunkVineTreeDecorator.INSTANCE);
            decorators.add(new LeavesVineTreeDecorator(0.5f));
        }

        return (new TreeFeatureConfig.Builder(BlockStateProvider.of(log),
                new EdumiaGiantTrunkPlacer(20, 20, 0, wood, strippedLog),
                BlockStateProvider.of(leaves.with(LeavesBlock.PERSISTENT, true)),
                new ClusterFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0)),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().decorators(ImmutableList.copyOf(decorators)).build());

    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable< ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
