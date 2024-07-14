package com.legends.edumia.world.worldgen.placed.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.ModNatureBlocks;
import com.legends.edumia.world.worldgen.configured.trees.SequoiaTreeConfiguredFeatures;
import com.legends.edumia.world.worldgen.configured.trees.TemperateTreeConfiguredFeatures;
import com.legends.edumia.world.worldgen.configured.trees.TropicalTreeConfiguredFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class TemperateTreePlacedFeatures {

    public static final RegistryKey<PlacedFeature> SAKURA_BUSH = registerKey("sakura/sakura_bush");
    public static final RegistryKey<PlacedFeature> SAKURA_TREE_MEDIUM = registerKey("sakura/sakura_tree_medium");
    public static final RegistryKey<PlacedFeature> SAKURA_TREE_BIG = registerKey("sakura/sakura_tree_big");

    public static final RegistryKey<PlacedFeature> AZALEA_BUSH = registerKey("azalea/azalea_bush");

    public static final RegistryKey<PlacedFeature> CEDER_KEY = registerKey("ceder/ceder_tree");
    public static final RegistryKey<PlacedFeature> LARGE_CEDER_KEY = registerKey("ceder/large_ceder_tree");

    public static final RegistryKey<PlacedFeature> CYPRESS_KEY = registerKey("cypress/cypress_tree");

    public static final RegistryKey<PlacedFeature> ASPEN_KEY = registerKey("aspen/aspen_tree");
    public static final RegistryKey<PlacedFeature> ASPEN_2_KEY = registerKey("aspen/aspen_2_tree");

    public static final RegistryKey<PlacedFeature> BIRCH_PLACED_TREE_KEY = registerKey("birch/birch_tree");
    public static final RegistryKey<PlacedFeature> SPARSE_BIRCH_PLACED_TREE_KEY = registerKey("birch/sparse_birch_tree");
    public static final RegistryKey<PlacedFeature> RARE_BIRCH_PLACED_TREE_KEY = registerKey("birch/rare_birch_tree");
    public static final RegistryKey<PlacedFeature> VERY_RARE_BIRCH_PLACED_TREE_KEY = registerKey("birch/super_rare_birch_tree");
    public static final RegistryKey<PlacedFeature> MEGA_BIRCH_PLACED_COMMON_TREE_KEY = registerKey("birch/mega_birch_common_tree");
    public static final RegistryKey<PlacedFeature> MEGA_BIRCH_PLACED_TREE_KEY = registerKey("birch/mega_birch_tree");

    public static final RegistryKey<PlacedFeature> BLACKTHORN_PLACED_TREE_KEY = registerKey("blackthorn/blackthorn_tree");
    public static final RegistryKey<PlacedFeature> COMMON_BLACKTHORN_PLACED_TREE_KEY = registerKey("blackthorn/common_blackthorn_tree");
    public static final RegistryKey<PlacedFeature> RARE_BLACKTHORN_PLACED_TREE_KEY = registerKey("blackthorn/rare_blackthorn_tree");

    public static final RegistryKey<PlacedFeature> WHITE_ASH_PLACED_TREE_KEY = registerKey("white_ash/white_ash_tree");
    public static final RegistryKey<PlacedFeature> SMALL_WHITE_ASH_PLACED_TREE_KEY = registerKey("white_ash/small_white_ash_tree");
    public static final RegistryKey<PlacedFeature> WHITE_ASH_BUSH_PLACED_TREE_KEY = registerKey("white_ash/white_ash_bush");
    public static final RegistryKey<PlacedFeature> MEGA_WHITE_ASH_PLACED_TREE_KEY = registerKey("white_ash/mega_white_ash_tree");

    public static final RegistryKey<PlacedFeature> MAPLE_PLACED_TREE_KEY = registerKey("maple/maple_tree");

    public static final RegistryKey<PlacedFeature> HOLLY_TREE_KEY = registerKey("holly/holly_tree");
    public static final RegistryKey<PlacedFeature> HOLLY_BEES_TREE_KEY = registerKey("holly/holly_tree_bees");

    public static final RegistryKey<PlacedFeature> WILLOW_PLACED_TREE_KEY = registerKey("willow/willow_tree");
    public static final RegistryKey<PlacedFeature> GENSAI_SAKURA_GROVE_TREES = registerKey("sakura/gensai_sakura_grove_trees");


    static PlacementModifier foothillsTree = PlacedFeatures.createCountExtraModifier(5, 0.5f, 1);
    static PlacementModifier abundantTree = PlacedFeatures.createCountExtraModifier(3, 0.5f, 1);
    static PlacementModifier frequentTree = PlacedFeatures.createCountExtraModifier(1, 0.5f, 1);
    static PlacementModifier commonTree = PlacedFeatures.createCountExtraModifier(1, 0.1f, 1);
    static PlacementModifier uncommonTree = PlacedFeatures.createCountExtraModifier(0, 0.5f, 1);
    static PlacementModifier scarceTree = PlacedFeatures.createCountExtraModifier(0, 0.25f, 1);
    static PlacementModifier rareTree = PlacedFeatures.createCountExtraModifier(0, 0.125f, 1);
    static PlacementModifier megaTree = PlacedFeatures.createCountExtraModifier(0, 0.1f, 1);
    static PlacementModifier veryRareTree = PlacedFeatures.createCountExtraModifier(0, 0.05f, 1);
    static PlacementModifier superRareTree = PlacedFeatures.createCountExtraModifier(0, 0.025f, 1);
    static PlacementModifier specialTree = PlacedFeatures.createCountExtraModifier(0, 0.01f, 1);

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, BIRCH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.BIRCH_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(scarceTree,
                        Blocks.BIRCH_SAPLING));
        register(context, SPARSE_BIRCH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.BIRCH_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(rareTree,
                        Blocks.BIRCH_SAPLING));
        register(context, RARE_BIRCH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.BIRCH_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(veryRareTree,
                        Blocks.BIRCH_SAPLING));
        register(context, VERY_RARE_BIRCH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.BIRCH_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(superRareTree,
                        Blocks.BIRCH_SAPLING));
        register(context, MEGA_BIRCH_PLACED_COMMON_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.BIRCH_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(uncommonTree,
                        Blocks.BIRCH_SAPLING));
        register(context, MEGA_BIRCH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.MEGA_BIRCH_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(megaTree,
                        Blocks.BIRCH_SAPLING));

        register(context, BLACKTHORN_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.BLACKTHORN_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(frequentTree,
                        ModNatureBlocks.BLACKTHORN_SAPLING));
        register(context, COMMON_BLACKTHORN_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.BLACKTHORN_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(abundantTree,
                        ModNatureBlocks.BLACKTHORN_SAPLING));
        register(context, RARE_BLACKTHORN_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.BLACKTHORN_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(rareTree,
                        ModNatureBlocks.BLACKTHORN_SAPLING));

        register(context, WHITE_ASH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.WHITE_ASH_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(13, 0.2f, 2),
                        ModNatureBlocks.WHITE_ASH_SAPLING));
        register(context, SMALL_WHITE_ASH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.SMALL_WHITE_ASH_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(4, 0.25f, 1),
                        ModNatureBlocks.WHITE_ASH_SAPLING));
        register(context, MEGA_WHITE_ASH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.MEGA_WHITE_ASH_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(8, 0.2f, 1),
                        ModNatureBlocks.WHITE_ASH_SAPLING));
        register(context, WHITE_ASH_BUSH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.WHITE_ASH_BUSH_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(commonTree, ModNatureBlocks.WHITE_ASH_SAPLING));

        register(context, MAPLE_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.MAPLE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(superRareTree,
                        ModNatureBlocks.MAPLE_SAPLING));

        register(context, WILLOW_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.WILLOW_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(uncommonTree,
                        ModNatureBlocks.WILLOW_SAPLING));



        register(context, SAKURA_BUSH, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.SAKURA_BUSH),
                List.of());

        register(context, SAKURA_TREE_MEDIUM, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.SAKURA_TREE_MEDIUM),
                List.of());

        register(context, SAKURA_TREE_BIG, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.SAKURA_TREE_BIG),
                List.of());

        register(context, AZALEA_BUSH, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.AZALEA_BUSH),
                List.of());

        register(context, CEDER_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.CEDER_KEY),
                List.of());

        register(context, LARGE_CEDER_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.LARGE_CEDER_KEY),
                List.of());

        register(context, CYPRESS_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.CYPRESS_KEY),
                List.of());

        register(context, ASPEN_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.ASPEN_KEY),
                List.of());
        register(context, ASPEN_2_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.ASPEN_2_KEY),
                List.of());

        register(context, HOLLY_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.HOLLY_TREE_KEY),
                List.of());

        register(context, HOLLY_BEES_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.HOLLY_BEES_TREE_KEY),
                List.of());


        register(context, GENSAI_SAKURA_GROVE_TREES,
                configuredFeatureRegistryEntryLookup.getOrThrow(TemperateTreeConfiguredFeatures.GENSAI_SAKURA_GROVE_TREES),
                List.of(CountPlacementModifier.of(ConstantIntProvider.create(128)),
                        SquarePlacementModifier.of(),NoiseBasedCountPlacementModifier.of(8, 202, 0.25),
                        HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE), RarityFilterPlacementModifier.of(100),
                        BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(Blocks.FERN.getDefaultState(), BlockPos.ORIGIN)),
                        BiomePlacementModifier.of()));

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Edumia.MOD_ID, "tree/temperate/" + name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
