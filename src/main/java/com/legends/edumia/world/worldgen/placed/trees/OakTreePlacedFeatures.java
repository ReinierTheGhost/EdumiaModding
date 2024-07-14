package com.legends.edumia.world.worldgen.placed.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.ModNatureBlocks;
import com.legends.edumia.world.worldgen.configured.trees.OakTreeConfiguredFeatures;
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

public class OakTreePlacedFeatures {

    public static final RegistryKey<PlacedFeature> MEGA_DARK_OAK_PLACED_TREE_KEY = registerKey("dark/mega_dark_oak_tree");
    public static final RegistryKey<PlacedFeature> MEGA_DARK_OAK_PLACED_COMMON_TREE_KEY = registerKey("dark/mega_dark_oak_common_tree");

    public static final RegistryKey<PlacedFeature> LIST_SMALL_RED_OAK_PLACED_TREE_KEY = registerKey("red/list_small_red_oak_tree");
    public static final RegistryKey<PlacedFeature> LIST_RED_OAK_PLACED_TREE_KEY = registerKey("red/list_red_oak_tree");
    public static final RegistryKey<PlacedFeature> LIST_LARGE_RED_OAK_PLACED_TREE_KEY = registerKey("red/list_large_red_oak_tree");
    public static final RegistryKey<PlacedFeature> LIST_MEGA_RED_OAK_PLACED_TREE_KEY = registerKey("red/list_mega_red_oak_tree");
    public static final RegistryKey<PlacedFeature> LIST_COLOSSAL_RED_OAK_PLACED_TREE_KEY = registerKey("red/list_colossal_red_oak_tree");

    public static final RegistryKey<PlacedFeature> SMALL_RED_OAK_PLACED_TREE_KEY = registerKey("red/small_red_oak_tree");
    public static final RegistryKey<PlacedFeature> RED_OAK_PLACED_TREE_KEY = registerKey("red/red_oak_tree");
    public static final RegistryKey<PlacedFeature> SPARSE_RED_OAK_PLACED_TREE_KEY = registerKey("red/sparse_red_oak_tree");
    public static final RegistryKey<PlacedFeature> MEGA_RED_OAK_PLACED_TREE_KEY = registerKey("red/mega_red_oak_tree");

    public static final RegistryKey<PlacedFeature> LIST_SMALL_GREEN_OAK_PLACED_TREE_KEY = registerKey("green/list_small_green_oak_tree");
    public static final RegistryKey<PlacedFeature> LIST_GREEN_OAK_PLACED_TREE_KEY = registerKey("green/list_green_oak_tree");
    public static final RegistryKey<PlacedFeature> LIST_LARGE_GREEN_OAK_PLACED_TREE_KEY = registerKey("green/list_large_green_oak_tree");
    public static final RegistryKey<PlacedFeature> LIST_MEGA_GREEN_OAK_PLACED_TREE_KEY = registerKey("green/list_mega_green_oak_tree");
    public static final RegistryKey<PlacedFeature> LIST_COLOSSAL_GREEN_OAK_PLACED_TREE_KEY = registerKey("green/list_colossal_green_oak_tree");

    public static final RegistryKey<PlacedFeature> SMALL_GREEN_OAK_PLACED_TREE_KEY = registerKey("green/small_green_oak_tree");
    public static final RegistryKey<PlacedFeature> GREEN_OAK_PLACED_TREE_KEY = registerKey("green/green_oak_tree");
    public static final RegistryKey<PlacedFeature> SPARSE_GREEN_OAK_PLACED_TREE_KEY = registerKey("green/sparse_green_oak_tree");
    public static final RegistryKey<PlacedFeature> MEGA_GREEN_OAK_PLACED_TREE_KEY = registerKey("green/mega_green_oak_tree");

    public static final RegistryKey<PlacedFeature> LIST_SMALL_BLACK_OAK_PLACED_TREE_KEY = registerKey("black/list_small_black_oak_tree");
    public static final RegistryKey<PlacedFeature> LIST_BLACK_OAK_PLACED_TREE_KEY = registerKey("black/list_black_oak_tree");
    public static final RegistryKey<PlacedFeature> LIST_LARGE_BLACK_OAK_PLACED_TREE_KEY = registerKey("black/list_large_black_oak_tree");
    public static final RegistryKey<PlacedFeature> LIST_MEGA_BLACK_OAK_PLACED_TREE_KEY = registerKey("black/list_mega_black_oak_tree");
    public static final RegistryKey<PlacedFeature> LIST_COLOSSAL_BLACK_OAK_PLACED_TREE_KEY = registerKey("black/list_colossal_black_oak_tree");

    public static final RegistryKey<PlacedFeature> SMALL_BLACK_OAK_PLACED_TREE_KEY = registerKey("black/small_black_oak_tree");
    public static final RegistryKey<PlacedFeature> BLACK_OAK_PLACED_TREE_KEY = registerKey("black/black_oak_tree");
    public static final RegistryKey<PlacedFeature> SPARSE_BLACK_OAK_PLACED_TREE_KEY = registerKey("black/sparse_black_oak_tree");
    public static final RegistryKey<PlacedFeature> MEGA_BLACK_OAK_PLACED_TREE_KEY = registerKey("black/mega_black_oak_tree");

    public static final RegistryKey<PlacedFeature> OAK_BUSH_PLACED_TREE_KEY = registerKey("oak/oak_bush_tree");
    public static final RegistryKey<PlacedFeature> OAK_BUSH_COMMON_PLACED_TREE_KEY = registerKey("oak/oak_bush_common_tree");
    public static final RegistryKey<PlacedFeature> COMMON_OAK_PLACED_TREE_KEY = registerKey("oak/common_oak_tree");
    public static final RegistryKey<PlacedFeature> OAK_PLACED_TREE_KEY = registerKey("oak/oak_tree");
    public static final RegistryKey<PlacedFeature> RARE_OAK_PLACED_TREE_KEY = registerKey("oak/rare_oak_tree");
    public static final RegistryKey<PlacedFeature> OAK_VINES_PLACED_TREE_KEY = registerKey("oak/oak_vines_tree");
    public static final RegistryKey<PlacedFeature> MEGA_OAK_PLACED_TREE_KEY = registerKey("oak/mega_oak_tree");
    public static final RegistryKey<PlacedFeature> RARE_MEGA_OAK_PLACED_TREE_KEY = registerKey("oak/rare_mega_oak_tree");
    public static final RegistryKey<PlacedFeature> VERY_RARE_MEGA_OAK_PLACED_TREE_KEY = registerKey("oak/very_rare_mega_oak_tree");
    public static final RegistryKey<PlacedFeature> MEGA_OAK_COMMON_PLACED_TREE_KEY = registerKey("oak/mega_oak_common_tree");

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

        register(context, MEGA_DARK_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.MEGA_DARK_OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(frequentTree,
                        Blocks.DARK_OAK_SAPLING));
        register(context, MEGA_DARK_OAK_PLACED_COMMON_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.MEGA_DARK_OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(abundantTree,
                        Blocks.DARK_OAK_SAPLING));

        register(context, LIST_SMALL_RED_OAK_PLACED_TREE_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.SMALL_RED_OAK_TREE_KEY),
                List.of());
        register(context, LIST_RED_OAK_PLACED_TREE_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.RED_OAK_KEY),
                List.of());
        register(context, LIST_LARGE_RED_OAK_PLACED_TREE_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.LARGE_RED_OAK_TREE_KEY),
                List.of());
        register(context, LIST_MEGA_RED_OAK_PLACED_TREE_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.MEGA_RED_OAK_TREE_KEY),
                List.of());
        register(context, LIST_COLOSSAL_RED_OAK_PLACED_TREE_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.COLOSSAL_RED_OAK_TREE_KEY),
                List.of());

        register(context, SMALL_RED_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.SMALL_RED_OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(15, 0.25f, 2),
                        ModNatureBlocks.RED_OAK_SAPLING));
        register(context, SPARSE_RED_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.LARGE_RED_OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 1),
                        ModNatureBlocks.RED_OAK_SAPLING));
        register(context, RED_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.RED_OAK_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(21, 0.2f, 2),
                        ModNatureBlocks.RED_OAK_SAPLING));
        register(context, MEGA_RED_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.MEGA_RED_OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(18, 0.2f, 1),
                        ModNatureBlocks.RED_OAK_SAPLING));


        register(context, LIST_SMALL_GREEN_OAK_PLACED_TREE_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.SMALL_GREEN_OAK_TREE_KEY),
                List.of());
        register(context, LIST_GREEN_OAK_PLACED_TREE_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.GREEN_OAK_KEY),
                List.of());
        register(context, LIST_LARGE_GREEN_OAK_PLACED_TREE_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.LARGE_GREEN_OAK_TREE_KEY),
                List.of());
        register(context, LIST_MEGA_GREEN_OAK_PLACED_TREE_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.MEGA_GREEN_OAK_TREE_KEY),
                List.of());
        register(context, LIST_COLOSSAL_GREEN_OAK_PLACED_TREE_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.COLOSSAL_GREEN_OAK_TREE_KEY),
                List.of());

        register(context, SMALL_GREEN_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.SMALL_GREEN_OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(15, 0.25f, 2),
                        ModNatureBlocks.GREEN_OAK_SAPLING));
        register(context, SPARSE_GREEN_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.LARGE_GREEN_OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 1),
                        ModNatureBlocks.GREEN_OAK_SAPLING));
        register(context, GREEN_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.GREEN_OAK_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(21, 0.2f, 2),
                        ModNatureBlocks.GREEN_OAK_SAPLING));
        register(context, MEGA_GREEN_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.MEGA_GREEN_OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(18, 0.2f, 1),
                        ModNatureBlocks.GREEN_OAK_SAPLING));

        register(context, LIST_SMALL_BLACK_OAK_PLACED_TREE_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.SMALL_BLACK_OAK_TREE_KEY),
                List.of());
        register(context, LIST_BLACK_OAK_PLACED_TREE_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.BLACK_OAK_KEY),
                List.of());
        register(context, LIST_LARGE_BLACK_OAK_PLACED_TREE_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.LARGE_BLACK_OAK_TREE_KEY),
                List.of());
        register(context, LIST_MEGA_BLACK_OAK_PLACED_TREE_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.MEGA_BLACK_OAK_TREE_KEY),
                List.of());
        register(context, LIST_COLOSSAL_BLACK_OAK_PLACED_TREE_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.COLOSSAL_BLACK_OAK_TREE_KEY),
                List.of());

        register(context, SMALL_BLACK_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.SMALL_BLACK_OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(15, 0.25f, 2),
                        ModNatureBlocks.BLACK_OAK_SAPLING));
        register(context, SPARSE_BLACK_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.LARGE_BLACK_OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 1),
                        ModNatureBlocks.BLACK_OAK_SAPLING));
        register(context, BLACK_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.BLACK_OAK_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(21, 0.2f, 2),
                        ModNatureBlocks.BLACK_OAK_SAPLING));
        register(context, MEGA_BLACK_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.MEGA_BLACK_OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(18, 0.2f, 1),
                        ModNatureBlocks.BLACK_OAK_SAPLING));

        register(context, OAK_BUSH_COMMON_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.OAK_BUSH_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(frequentTree,
                        Blocks.OAK_SAPLING));
        register(context, OAK_BUSH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.OAK_BUSH_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(uncommonTree,
                        Blocks.OAK_SAPLING));
        register(context, COMMON_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(uncommonTree,
                        Blocks.OAK_SAPLING));
        register(context, OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(rareTree,
                        Blocks.OAK_SAPLING));
        register(context, RARE_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(veryRareTree,
                        Blocks.OAK_SAPLING));
        register(context, OAK_VINES_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.OAK_TREE_VINES_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(frequentTree,
                        Blocks.OAK_SAPLING));
        register(context, MEGA_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.MEGA_OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(megaTree,
                        Blocks.OAK_SAPLING));
        register(context, MEGA_OAK_COMMON_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.MEGA_OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(abundantTree,
                        Blocks.OAK_SAPLING));
        register(context, RARE_MEGA_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.MEGA_OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(veryRareTree,
                        Blocks.OAK_SAPLING));
        register(context, VERY_RARE_MEGA_OAK_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(OakTreeConfiguredFeatures.MEGA_OAK_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(specialTree,
                        Blocks.OAK_SAPLING));



    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Edumia.MOD_ID, "tree/oaks/" + name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
