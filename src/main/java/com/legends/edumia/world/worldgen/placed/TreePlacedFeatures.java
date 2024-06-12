package com.legends.edumia.world.worldgen.placed;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.ModNatureBlocks;
import com.legends.edumia.world.worldgen.configured.TreeConfiguredFeatures;
import com.legends.edumia.world.worldgen.configured.trees.BeechTreeConfiguredFeatures;
import com.legends.edumia.world.worldgen.placed.trees.SequoiaTreePlacedFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class TreePlacedFeatures {

    public static final RegistryKey<PlacedFeature> COMMON_BEECH_PLACED_TREE_KEY = registerKey("tree/beech/common_beech_tree");
    public static final RegistryKey<PlacedFeature> BEECH_PLACED_TREE_KEY = registerKey("tree/beech/beech_tree_2");
    public static final RegistryKey<PlacedFeature> RARE_BEECH_PLACED_TREE_KEY = registerKey("tree/beech/rare_beech_tree");
    public static final RegistryKey<PlacedFeature> VERY_RARE_BEECH_PLACED_TREE_KEY = registerKey("tree/beech/very_rare_beech_tree");

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

    public static final RegistryKey<PlacedFeature> TINY_BEECH_KEY = registerKey("tree/beech/tiny_beech_tree");
    public static final RegistryKey<PlacedFeature> BEECH_KEY = registerKey("tree/beech/beech_tree");
    public static final RegistryKey<PlacedFeature> BIG_BEECH_KEY = registerKey("tree/beech/big_beech_tree");



    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, BEECH_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BeechTreeConfiguredFeatures.BEECH_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.1f, 1),
                        ModNatureBlocks.BEECH_SAPLING));
        register(context, BIG_BEECH_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BeechTreeConfiguredFeatures.BIG_BEECH_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.1f, 1),
                        ModNatureBlocks.BEECH_SAPLING));

        register(context, COMMON_BEECH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BeechTreeConfiguredFeatures.BEECH_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(uncommonTree,
                        Blocks.BIRCH_SAPLING));
        register(context, BEECH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BeechTreeConfiguredFeatures.BEECH_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(rareTree,
                        Blocks.BIRCH_SAPLING));
        register(context, RARE_BEECH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BeechTreeConfiguredFeatures.BEECH_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(veryRareTree,
                        Blocks.BIRCH_SAPLING));
        register(context, VERY_RARE_BEECH_PLACED_TREE_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BeechTreeConfiguredFeatures.BEECH_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(superRareTree,
                        Blocks.BIRCH_SAPLING));




    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
