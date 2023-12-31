package com.legends.edumia.world.biomes;


import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Converts PNG pixel color to a BiomeKey reference.
 */
public class EdumiaBiomesData {
    public static HashMap<Integer, EdumiaBiome> biomeMap = new HashMap<>();
    public static List<RegistryKey<Biome>> waterBiomes = new ArrayList<>();
    public static List<RegistryKey<Biome>> mirkwoodSwampBiomes = new ArrayList<>();
    public static EdumiaBiome defaultBiome;
    public static EdumiaBiome millPond;
    public static EdumiaBiome mirkwoodSwamp;

    /// Only supports height value from -22 to 41
    public static final int MINIMAL_HEIGHT = -22;

    public static void addBiome(Color color, EdumiaBiome biome) {
        biomeMap.put(color.getRGB(), biome);
    }

    public static void loadBiomes() {
        defaultBiome = new EdumiaBiome(-21, EdumiaBiomeKeys.EDUMIA_OCEAN, Blocks.SAND, Blocks.STONE, Blocks.STONE, Blocks.STONE);
        millPond = new EdumiaBiome(-10, EdumiaBiomeKeys.MILLPOND,  Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE);

        addBiome(new Color(55, 90, 195), defaultBiome);
        addBiome(new Color(110, 154, 218), millPond);

        addBiome(new Color(54, 75, 12), new EdumiaBiome(6, EdumiaBiomeKeys.DARK_ELF_FOREST, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(236, 236, 236), new EdumiaBiome(8, EdumiaBiomeKeys.EDUMIA_TUNDRA, Blocks.SNOW, Blocks.SNOW_BLOCK, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(101, 123, 243), new EdumiaBiome(-18, EdumiaBiomeKeys.FROZEN_OCEAN, Blocks.GRAVEL, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(237, 229, 145), new EdumiaBiome(5, EdumiaBiomeKeys.ORC_DESERT, Blocks.SAND, Blocks.SAND, Blocks.SANDSTONE, Blocks.STONE));
        addBiome(new Color(67, 193, 125), new EdumiaBiome(4, EdumiaBiomeKeys.AVELION_PLAINS, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(129, 129, 129), new EdumiaBiome(41, EdumiaBiomeKeys.EDUMIA_MOUNTAINS, Blocks.SNOW_BLOCK, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(83, 129, 186), new EdumiaBiome(-22, EdumiaBiomeKeys.EDUMIA_RIVER, Blocks.SAND, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(121, 186, 111), new EdumiaBiome(4, EdumiaBiomeKeys.TAIGA_FOREST, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(48, 109, 42), new EdumiaBiome(5, EdumiaBiomeKeys.GENSAI_JUNGLE, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));

        waterBiomes.add(EdumiaBiomeKeys.EDUMIA_OCEAN);
        waterBiomes.add(EdumiaBiomeKeys.EDUMIA_RIVER);


    }
}