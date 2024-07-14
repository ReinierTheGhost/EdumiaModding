package com.legends.edumia.world.worldgen.placed.biomes;

import com.legends.edumia.Edumia;
import com.legends.edumia.world.worldgen.configured.biomes.BiomeConfiguredFeatures;
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
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class BiomePlacedFeatures {

    public static final RegistryKey<PlacedFeature> DARK_ELVEN_OAK_TREES_KEY = registerKey("dark_elven/trees");

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);


        register(context, DARK_ELVEN_OAK_TREES_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(BiomeConfiguredFeatures.DARK_ELVEN_OAK_TREES_KEY),
                List.of(CountPlacementModifier.of(new WeightedListIntProvider(DataPool.<IntProvider>builder().add(ConstantIntProvider.create(50), 90)
                                .add(ConstantIntProvider.create(51), 10).build())),
                        SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0),
                        HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR), BlockFilterPlacementModifier.of(BlockPredicate.allOf(
                                BlockPredicate.matchingBlocks(new BlockPos(0, -1, 0), Blocks.GRASS_BLOCK, Blocks.DIRT,
                                        Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.ROOTED_DIRT))), BiomePlacementModifier.of()));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Edumia.MOD_ID, "biomes/" + name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
