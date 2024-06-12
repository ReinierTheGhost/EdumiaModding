package com.legends.edumia.world.worldgen.placed;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.world.worldgen.configured.beach.BeachConfiguredFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class BeachPlacedFeatures {

    public static final RegistryKey<PlacedFeature> WHITE_SAND_LAYER_FIRST = registerKey("beach/layers/white/first");
    public static final RegistryKey<PlacedFeature> WHITE_SAND_LAYER_SECOND = registerKey("beach/layers/white/second");
    public static final RegistryKey<PlacedFeature> WHITE_SAND_LAYER_THIRD = registerKey("beach/layers/white/third");

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, WHITE_SAND_LAYER_FIRST, configuredFeatureRegistryEntryLookup.getOrThrow(BeachConfiguredFeatures.WHITE_SAND_LAYER_FIRST),
                List.of(CountPlacementModifier.of(80), CountPlacementModifier.of(10), SquarePlacementModifier.of(),
                        HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE_WG), BlockFilterPlacementModifier.of(
                                BlockPredicate.allOf(BlockPredicate.matchingBlocks(new BlockPos(0, -1, 0),
                                         BlockLoader.WHITE_SAND), BlockPredicate.matchingBlocks(
                                        new BlockPos(0, 0, 0), Blocks.AIR, BlockLoader.WHITE_SAND_LAYER))),
                        BlockFilterPlacementModifier.of(BlockPredicate.allOf(BlockPredicate.matchingBlocks(new BlockPos(1,
                                        0, 0),  BlockLoader.WHITE_SAND),
                                BlockPredicate.matchingBlocks(new BlockPos(0,
                                        0, 1),  BlockLoader.WHITE_SAND),
                                BlockPredicate.matchingBlocks(new BlockPos(-1,
                                        0, 0),  BlockLoader.WHITE_SAND),
                                BlockPredicate.matchingBlocks(new BlockPos(0,
                                        0, -1),  BlockLoader.WHITE_SAND))),
                        BiomePlacementModifier.of()));

        register(context, WHITE_SAND_LAYER_SECOND, configuredFeatureRegistryEntryLookup.getOrThrow(BeachConfiguredFeatures.WHITE_SAND_LAYER_SECOND),
                List.of(CountPlacementModifier.of(80), CountPlacementModifier.of(10), SquarePlacementModifier.of(),
                        HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE_WG), BlockFilterPlacementModifier.of(
                                BlockPredicate.allOf(BlockPredicate.matchingBlocks(new BlockPos(0, -1, 0),
                                         BlockLoader.WHITE_SAND), BlockPredicate.matchingBlocks(
                                        new BlockPos(0, 0, 0), Blocks.AIR, BlockLoader.WHITE_SAND_LAYER))),
                        BlockFilterPlacementModifier.of(BlockPredicate.allOf(BlockPredicate.matchingBlocks(new BlockPos(1,
                                        0, 0),  BlockLoader.WHITE_SAND),
                                BlockPredicate.matchingBlocks(new BlockPos(0,
                                        0, 1),  BlockLoader.WHITE_SAND),
                                BlockPredicate.matchingBlocks(new BlockPos(-1,
                                        0, 0),  BlockLoader.WHITE_SAND),
                                BlockPredicate.matchingBlocks(new BlockPos(0,
                                        0, -1),  BlockLoader.WHITE_SAND))),
                        BiomePlacementModifier.of()));

        register(context, WHITE_SAND_LAYER_THIRD, configuredFeatureRegistryEntryLookup.getOrThrow(BeachConfiguredFeatures.WHITE_SAND_LAYER_THIRD),
                List.of(CountPlacementModifier.of(80), CountPlacementModifier.of(10), SquarePlacementModifier.of(),
                        HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE_WG), BlockFilterPlacementModifier.of(
                                BlockPredicate.allOf(BlockPredicate.matchingBlocks(new BlockPos(0, -1, 0),
                                         BlockLoader.WHITE_SAND), BlockPredicate.matchingBlocks(
                                        new BlockPos(0, 0, 0), Blocks.AIR, BlockLoader.WHITE_SAND_LAYER))),
                        BlockFilterPlacementModifier.of(BlockPredicate.allOf(BlockPredicate.matchingBlocks(new BlockPos(1,
                                        0, 0),  BlockLoader.WHITE_SAND),
                                BlockPredicate.matchingBlocks(new BlockPos(0,
                                        0, 1),  BlockLoader.WHITE_SAND),
                                BlockPredicate.matchingBlocks(new BlockPos(-1,
                                        0, 0),  BlockLoader.WHITE_SAND),
                                BlockPredicate.matchingBlocks(new BlockPos(0,
                                        0, -1),  BlockLoader.WHITE_SAND))),
                        BiomePlacementModifier.of()));

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
