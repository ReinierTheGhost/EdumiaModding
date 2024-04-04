package com.legends.edumia.world.biomes.caves;

import com.legends.edumia.world.biomes.EdumiaBiome;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.ArrayList;
import java.util.List;

public class ModCaveBiomes {
    public static final int defaultSky = 7907327;
    public static final int defaultFog = 12638463;
    public static final int defaultWater = 4159204;
    public static final int defaultWaterFog = 329011;

    private static List<RegistryKey<PlacedFeature>> undergroundOres = new ArrayList<>();
    public static CaveBiomesMap defaultCaves = new CaveBiomesMap();
    public static CaveBiomesMap ashCaves = new CaveBiomesMap();
    public static CaveBiomesMap forodCaves = new CaveBiomesMap();
    public static CaveBiomesMap desertCaves = new CaveBiomesMap();

    public static RegistryKey<Biome> getBiome(Vec2f coordinates, EdumiaBiome surfaceBiome) {
        return switch (surfaceBiome.caveType) {
            case ASHEN -> ashCaves.getClosestBiome(coordinates);
            case DESERT -> desertCaves.getClosestBiome(coordinates);
            case FOROD -> forodCaves.getClosestBiome(coordinates);
            default -> defaultCaves.getClosestBiome(coordinates);
        };
    }
}
