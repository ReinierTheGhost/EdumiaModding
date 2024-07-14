package com.legends.edumia.world.biomes.caves;

import com.legends.edumia.world.biomes.BiomeColorsDTO;
import com.legends.edumia.world.biomes.EdumiaBiomeKeys;
import com.legends.edumia.world.biomes.surface.EdumiaBiome;
import com.legends.edumia.world.worldgen.placed.crystrals.CrystalPlacedFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ModCaveBiomes {
    public static final int defaultSky = 7907327;
    public static final int defaultFog = 12638463;
    public static final int defaultWater = 4159204;
    public static final int defaultWaterFog = 329011;

    private static List<RegistryKey<PlacedFeature>> undergroundOres = new ArrayList<>();;

    public static CaveBiomesMap defaultCaves = new CaveBiomesMap();
    public static CaveBiomesMap ashCaves = new CaveBiomesMap();
    public static CaveBiomesMap forodCaves = new CaveBiomesMap();
    public static CaveBiomesMap haradCaves = new CaveBiomesMap();

    public static void init() {
        defaultCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.LUSH_CAVE, new Vec2f(-1.0f,0f)));
        defaultCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.DRIPSTONE_CAVE, new Vec2f(1.0f,0f)));
        defaultCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.MUD_CAVE, new Vec2f(1.0f,1.0f)));
        defaultCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.FUNGUS_CAVE, new Vec2f(0f,-1.0f)));
        defaultCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.BASIC_CAVE, new Vec2f(0.0f,0.8f)));

        ashCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.DRIPSTONE_CAVE, new Vec2f(1.0f,0.5f)));
        ashCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.BASALT_CAVE, new Vec2f(-1.0f,0.5f)));
        ashCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.MAGMA_CAVE, new Vec2f(0.0f,-1.0f)));

        haradCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.DRIPSTONE_CAVE, new Vec2f(1.0f,0f)));
        haradCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.DRY_CAVE, new Vec2f(0.0f,0f)));
        haradCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.BASIC_CAVE, new Vec2f(-1.0f,0f)));

        forodCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.ICE_CAVE, new Vec2f(-0.5f,0f)));
        forodCaves.addCave(new CaveBiomeDTO(EdumiaBiomeKeys.DRIPSTONE_CAVE, new Vec2f(1.0f,0f)));
    }

    public static RegistryKey<Biome> getBiome(Vec2f coordinates, EdumiaBiome surfaceBiome) {
        return switch (surfaceBiome.caveType) {
            case ASHEN -> ashCaves.getClosestBiome(coordinates);
            case DESERT -> haradCaves.getClosestBiome(coordinates);
            case FROZEN -> forodCaves.getClosestBiome(coordinates);
            default -> defaultCaves.getClosestBiome(coordinates);
        };
    }

    public static void bootstrap(Registerable<Biome> context) {
        context.register(EdumiaBiomeKeys.BASIC_CAVE, createBasicCave(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 10338918, 10604137)));
        context.register(EdumiaBiomeKeys.LUSH_CAVE, createLushCave(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 8703593, 8703593)));
        context.register(EdumiaBiomeKeys.DRIPSTONE_CAVE, createDripstoneCave(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 10338918, 10604137)));
        context.register(EdumiaBiomeKeys.MUD_CAVE, createMudCaves(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 7435337, 7905386)));
        context.register(EdumiaBiomeKeys.FUNGUS_CAVE, createFungusCave(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 5869935, 6263141)));

        context.register(EdumiaBiomeKeys.MITHRIL_CAVE, createMithrilCave(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 10338918, 10604137)));

        context.register(EdumiaBiomeKeys.BASALT_CAVE, createBasaltCave(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 9534809, 8878692)));
        context.register(EdumiaBiomeKeys.MAGMA_CAVE, createMagmaCave(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 9527897, 8876132)));

        context.register(EdumiaBiomeKeys.DRY_CAVE, createDryCave(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 10928742, 11259497)));
        context.register(EdumiaBiomeKeys.ICE_CAVE, createIceCaves(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 11121530, 10990723)));
    }

    public static Biome createBasicCave(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addBasicFeatures(generationSettings, true);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }

    public static Biome createLushCave(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModCaveBiomeFeatures.addAxolotls(spawnSettings);

        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addBasicFeatures(generationSettings, true);
        DefaultBiomeFeatures.addPlainsTallGrass(generationSettings);

        undergroundOres.add(OrePlacedFeatures.ORE_CLAY);
        undergroundOres.add(UndergroundPlacedFeatures.UNDERWATER_MAGMA);
        undergroundOres.add(MiscPlacedFeatures.DISK_SAND);
        undergroundOres.add(MiscPlacedFeatures.DISK_CLAY);
        undergroundOres.add(MiscPlacedFeatures.DISK_GRAVEL);
        undergroundOres.add(CrystalPlacedFeatures.ELVEN_CRYSTAL);


        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }

    public static Biome createDripstoneCave(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        undergroundOres.add(UndergroundPlacedFeatures.LARGE_DRIPSTONE);
        undergroundOres.add(UndergroundPlacedFeatures.DRIPSTONE_CLUSTER);
        undergroundOres.add(UndergroundPlacedFeatures.POINTED_DRIPSTONE);
        undergroundOres.add(MiscPlacedFeatures.DISK_GRAVEL);
        addBasicFeatures(generationSettings, true);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }

    public static Biome createMudCaves(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModCaveBiomeFeatures.addSnails(spawnSettings);
        ModCaveBiomeFeatures.addFrogs(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addBasicFeatures(generationSettings, true);
        undergroundOres.add(MiscPlacedFeatures.DISK_GRAVEL);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }

    public static Biome createFungusCave(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModCaveBiomeFeatures.addSnails(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addBasicFeatures(generationSettings, true);
        undergroundOres.add(MiscPlacedFeatures.DISK_GRAVEL);


        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }

    public static Biome createMithrilCave(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addBasicFeatures(generationSettings, true);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }

    public static Biome createBasaltCave(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addBasicFeatures(generationSettings, false);
        generationSettings.feature(GenerationStep.Feature.SURFACE_STRUCTURES, NetherPlacedFeatures.SMALL_BASALT_COLUMNS);

        undergroundOres.add(MiscPlacedFeatures.DISK_GRAVEL);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }

    public static Biome createMagmaCave(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addBasicFeatures(generationSettings, false);
        generationSettings.feature(GenerationStep.Feature.SURFACE_STRUCTURES, NetherPlacedFeatures.DELTA);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }

    public static Biome createDryCave(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));


        addBasicFeatures(generationSettings, true);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, false);
    }

    public static Biome createIceCaves(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addBasicFeatures(generationSettings, true);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, false);
    }

    private static void addBasicFeatures(GenerationSettings.LookupBackedBuilder generationSettings, boolean vanillaRocks) {
        ModCaveBiomeFeatures.addAmethystGeode(generationSettings);
        ModCaveBiomeFeatures.addCitrineGeode(generationSettings);
        ModCaveBiomeFeatures.addGlowstoneGeode(generationSettings);
        ModCaveBiomeFeatures.addRedAgateGeode(generationSettings);
        ModCaveBiomeFeatures.addQuartzGeode(generationSettings);

        undergroundOres.add(MiscPlacedFeatures.SPRING_WATER);


        undergroundOres.add(OrePlacedFeatures.ORE_GRAVEL);

        if(vanillaRocks) {
            undergroundOres.add(OrePlacedFeatures.ORE_DIRT);
            undergroundOres.add(OrePlacedFeatures.ORE_GRANITE_UPPER);
            undergroundOres.add(OrePlacedFeatures.ORE_GRANITE_LOWER);
            undergroundOres.add(OrePlacedFeatures.ORE_DIORITE_UPPER);
            undergroundOres.add(OrePlacedFeatures.ORE_DIORITE_LOWER);
            undergroundOres.add(OrePlacedFeatures.ORE_ANDESITE_UPPER);
            undergroundOres.add(OrePlacedFeatures.ORE_ANDESITE_LOWER);
        }
        undergroundOres.add(OrePlacedFeatures.ORE_TUFF);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, UndergroundPlacedFeatures.GLOW_LICHEN);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
    }

    public static Biome createBiome(BiomeColorsDTO biomeColors, SpawnSettings.Builder spawnSettings, GenerationSettings.LookupBackedBuilder generationSettings, float temperature, boolean precipitation) {
        ModCaveBiomeFeatures.addBats(spawnSettings);
        ModCaveBiomeFeatures.addCaveTrolls(spawnSettings);

        undergroundOres = undergroundOres.stream().sorted(Comparator.comparing(a -> a.getValue().toString())).toList();
        for (RegistryKey<PlacedFeature> feature: undergroundOres) {
            generationSettings.feature(GenerationStep.Feature.UNDERGROUND_ORES, feature);
        }

        Biome biome = (new Biome.Builder())
                .precipitation(precipitation)
                .temperature(temperature)
                .downfall(0.5F)
                .effects((new BiomeEffects.Builder())
                        .skyColor(biomeColors.skyColor)
                        .fogColor(biomeColors.fogColor)
                        .waterColor(biomeColors.waterColor)
                        .waterFogColor(biomeColors.waterFogColor)
                        .grassColor(biomeColors.grassColor)
                        .foliageColor(biomeColors.foliageColor)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
        undergroundOres = new ArrayList<>();
        return biome;
    }
}
