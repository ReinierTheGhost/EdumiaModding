package com.legends.edumia.world.biomes;


import com.legends.edumia.block.blocksets.StoneSets;
import com.legends.edumia.block.register.NaturalStoneBlocks;
import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.biome.Biome;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Converts PNG pixel color to a BiomeKey reference.
 */
public class EdumiaBiomesData {

    private static List<EdumiaBiome> biomes = new ArrayList<>();
    public static List<RegistryKey<Biome>> waterBiomes = new ArrayList<>();
    public static List<RegistryKey<Biome>> frozenBiomes = new ArrayList<>();
    public static List<RegistryKey<Biome>> pondBiomes = new ArrayList<>();
    public static List<RegistryKey<Biome>> oasisBiomes = new ArrayList<>();
    public static EdumiaBiome defaultBiome;
    public static EdumiaBiome frozenPond;
    public static EdumiaBiome oasis;
    public static EdumiaBiome pond;

    public static void addBiome(Color color, EdumiaBiome biome) {
        biome.color = color;
        biomes.add(biome);
    }

    public static EdumiaBiome getBiomeByColor(Integer rgb){
        try{
            return biomes.stream().filter(x -> x.color.getRGB() == rgb).findFirst().get();
        } catch (Exception e){
            System.out.println("EdumiaBiomes::No registered biome has %s for color".formatted(rgb));
        }
        return null;
    }

    public static EdumiaBiome getBiomeById(Short id){
        try{
            return biomes.get(id);
        } catch (Exception e){
            System.out.println("EdumiaBiomes::No registered biome has %s for id".formatted(id));
        }
        return null;
    }

    public static Integer getColorByBiomeId(Short id){
        try{
            return biomes.get(id).color.getRGB();
        } catch (Exception e){
            System.out.println("EdumiaBiomes::No registered biome has %s for id".formatted(id));
        }
        return null;
    }

    public static void loadBiomes() {
        defaultBiome = new EdumiaBiome(-21, EdumiaBiomeKeys.EDUMIA_OCEAN, Blocks.SAND, Blocks.STONE, Blocks.STONE, Blocks.STONE);
        pond  = new EdumiaBiome(-10, EdumiaBiomeKeys.MILLPOND,  Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE);

        addBiome(new Color(55, 90, 195), defaultBiome);
        addBiome(new Color(110, 154, 218), pond);

        addBiome(new Color(54, 75, 12), new EdumiaBiome(6, EdumiaBiomeKeys.DARK_ELF_FOREST, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(236, 236, 236), new EdumiaBiome(8, EdumiaBiomeKeys.EDUMIA_TUNDRA, Blocks.SNOW, Blocks.SNOW_BLOCK, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(101, 123, 243), new EdumiaBiome(-18, EdumiaBiomeKeys.FROZEN_OCEAN, Blocks.GRAVEL, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(237, 229, 145), new EdumiaBiome(4, EdumiaBiomeKeys.ORC_DESERT, Blocks.SAND, Blocks.SAND, Blocks.SANDSTONE, Blocks.STONE));
        addBiome(new Color(67, 193, 125), new EdumiaBiome(4, EdumiaBiomeKeys.AVELION_PLAINS, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(129, 129, 129), new EdumiaBiome(41, EdumiaBiomeKeys.EDUMIA_MOUNTAINS, Blocks.SNOW_BLOCK, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(83, 129, 186), new EdumiaBiome(-22, EdumiaBiomeKeys.EDUMIA_RIVER, Blocks.SAND, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(121, 186, 111), new EdumiaBiome(4, EdumiaBiomeKeys.TAIGA_FOREST, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(48, 109, 42), new EdumiaBiome(5, EdumiaBiomeKeys.GENSAI_JUNGLE, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(234, 222, 117), new EdumiaBiome(3, EdumiaBiomeKeys.GENSAI_BEACH, BlockLoader.WHITE_SAND, BlockLoader.WHITE_SAND, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(255, 0, 110), new EdumiaBiome(-6, EdumiaBiomeKeys.GENSAI_REEF, StoneSets.CHALK.block(), StoneSets.CHALK.block(), Blocks.STONE, Blocks.STONE));


        waterBiomes.add(EdumiaBiomeKeys.EDUMIA_OCEAN);
        waterBiomes.add(EdumiaBiomeKeys.EDUMIA_RIVER);


    }

    public static EdumiaBiome getBiomeByKey(RegistryEntry<Biome> biome) {
        return biomes.stream().filter(
                        b -> b.biome.getValue().toString().equalsIgnoreCase(biome.getKey().get().getValue().toString()))
                .findFirst().get();
    }
}
