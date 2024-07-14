package com.legends.edumia.world.worldgen.placed.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.ModNatureBlocks;
import com.legends.edumia.world.worldgen.configured.trees.BorealTreeConfiguredFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class BorealTreePlacedFeatures {

    public static final RegistryKey<PlacedFeature> COMMON_LARCH_PLACED_TREE_KEY = registerKey("larch/abundant_larch_tree");
    public static final RegistryKey<PlacedFeature> LARCH_PLACED_TREE_KEY = registerKey("larch/larch_tree");
    public static final RegistryKey<PlacedFeature> SPARSE_LARCH_PLACED_TREE_KEY = registerKey("larch/sparse_larch_tree");

    public static final RegistryKey<PlacedFeature> ABUNDANT_PINE_PLACED_TREE_KEY = registerKey("pine/abundant_pine_tree");
    public static final RegistryKey<PlacedFeature> COMMON_PINE_PLACED_TREE_KEY = registerKey("pine/common_pine_tree");
    public static final RegistryKey<PlacedFeature> PINE_PLACED_TREE_KEY = registerKey("pine/pine_tree");
    public static final RegistryKey<PlacedFeature> DEAD_PINE_PLACED_TREE_KEY = registerKey("pine/dead_pine_tree");
    public static final RegistryKey<PlacedFeature> SPARSE_PINE_PLACED_TREE_KEY = registerKey("pine/sparse_pine_tree");
    public static final RegistryKey<PlacedFeature> FOOTHILLS_SPRUCE_PLACED_TREE_KEY = registerKey("spruce/foothills_spruce_tree");
    public static final RegistryKey<PlacedFeature> COMMON_SPRUCE_PLACED_TREE_KEY = registerKey("spruce/common_spruce_tree");
    public static final RegistryKey<PlacedFeature> SPRUCE_PLACED_TREE_KEY = registerKey("spruce/spruce_tree");
    public static final RegistryKey<PlacedFeature> COMMON_SPRUCE_BUSH_PLACED_TREE_KEY = registerKey("spruce/common_spruce_bush_tree");
    public static final RegistryKey<PlacedFeature> SPRUCE_BUSH_PLACED_TREE_KEY = registerKey("spruce/spruce_bush_tree");
    public static final RegistryKey<PlacedFeature> SCARCE_SPRUCE_PLACED_TREE_KEY = registerKey("spruce/scarce_spruce_tree");
    public static final RegistryKey<PlacedFeature> RARE_SPRUCE_PLACED_TREE_KEY = registerKey("spruce/rare_spruce_tree");
    public static final RegistryKey<PlacedFeature> VERY_RARE_SPRUCE_PLACED_TREE_KEY = registerKey("spruce/very_rare_spruce_tree");

    public static final RegistryKey<PlacedFeature> SILVER_SPRUCE_TREE_LIST = registerKey("silver_spruce/silver_spruce_tree");


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

        register(context, COMMON_LARCH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BorealTreeConfiguredFeatures.LARCH_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(frequentTree,
                        ModNatureBlocks.LARCH_SAPLING));
        register(context, LARCH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BorealTreeConfiguredFeatures.LARCH_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(rareTree,
                        ModNatureBlocks.LARCH_SAPLING));
        register(context, SPARSE_LARCH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BorealTreeConfiguredFeatures.LARCH_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(veryRareTree,
                        ModNatureBlocks.LARCH_SAPLING));

        register(context, ABUNDANT_PINE_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BorealTreeConfiguredFeatures.PINE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(foothillsTree,
                        ModNatureBlocks.PINE_SAPLING));
        register(context, COMMON_PINE_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BorealTreeConfiguredFeatures.PINE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(frequentTree,
                        ModNatureBlocks.PINE_SAPLING));
        register(context, PINE_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BorealTreeConfiguredFeatures.PINE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(uncommonTree,
                        ModNatureBlocks.PINE_SAPLING));
        register(context, DEAD_PINE_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BorealTreeConfiguredFeatures.DEAD_PINE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(scarceTree,
                        ModNatureBlocks.PINE_SAPLING));
        register(context, SPARSE_PINE_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BorealTreeConfiguredFeatures.PINE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(rareTree,
                        ModNatureBlocks.PINE_SAPLING));

        register(context, FOOTHILLS_SPRUCE_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BorealTreeConfiguredFeatures.SPRUCE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(foothillsTree,
                        Blocks.SPRUCE_SAPLING));
        register(context, COMMON_SPRUCE_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BorealTreeConfiguredFeatures.SPRUCE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(frequentTree,
                        Blocks.SPRUCE_SAPLING));
        register(context, SPRUCE_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BorealTreeConfiguredFeatures.SPRUCE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(uncommonTree,
                        Blocks.SPRUCE_SAPLING));
        register(context, SCARCE_SPRUCE_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BorealTreeConfiguredFeatures.SPRUCE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(scarceTree,
                        Blocks.SPRUCE_SAPLING));
        register(context, RARE_SPRUCE_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BorealTreeConfiguredFeatures.SPRUCE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(rareTree,
                        Blocks.SPRUCE_SAPLING));
        register(context, VERY_RARE_SPRUCE_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BorealTreeConfiguredFeatures.SPRUCE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(veryRareTree,
                        Blocks.SPRUCE_SAPLING));

        register(context, COMMON_SPRUCE_BUSH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BorealTreeConfiguredFeatures.SPRUCE_BUSH_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(frequentTree,
                        Blocks.SPRUCE_SAPLING));
        register(context, SPRUCE_BUSH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BorealTreeConfiguredFeatures.SPRUCE_BUSH_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(uncommonTree,
                        Blocks.SPRUCE_SAPLING));

        register(context, SILVER_SPRUCE_TREE_LIST, configuredFeatureRegistryEntryLookup.getOrThrow(BorealTreeConfiguredFeatures.SILVER_SPRUCE_TREE_KEY),
                List.of());

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Edumia.MOD_ID, "tree/boreal/" + name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
