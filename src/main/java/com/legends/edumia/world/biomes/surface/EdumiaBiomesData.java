package com.legends.edumia.world.biomes.surface;

import com.legends.edumia.block.blocksets.StoneSets;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.world.biomes.EdumiaBiomeKeys;
import com.legends.edumia.world.biomes.caves.CaveType;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.biome.Biome;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Converts PNG pixel color to a BiomeKey reference.
 */
public class EdumiaBiomesData {


    private static List<EdumiaBiome> biomes = new ArrayList<>();
    public static List<RegistryKey<Biome>> waterBiomes = new ArrayList<>();
    public static List<RegistryKey<Biome>> frozenBiomes = new ArrayList<>();
    public static List<RegistryKey<Biome>> wastePondBiomes = new ArrayList<>();
    public static List<RegistryKey<Biome>> mirkwoodSwampBiomes = new ArrayList<>();
    public static List<RegistryKey<Biome>> oasisBiomes = new ArrayList<>();
    public static List<RegistryKey<Biome>> pondBiomes = new ArrayList<>();

    public static EdumiaBiome defaultBiome;
    public static EdumiaBiome frozenPond;
    public static EdumiaBiome oasis;
    public static EdumiaBiome pond;
    public static EdumiaBiome wastePond;
    public static EdumiaBiome mirkwoodSwamp;


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

    public void loadBiomes() {
        defaultBiome = new EdumiaBiome(-13, EdumiaBiomeKeys.OCEAN, Blocks.SAND, Blocks.STONE, Blocks.STONE);
        frozenPond = new EdumiaBiome(-10, EdumiaBiomeKeys.FROZEN_POND,  Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, CaveType.FROZEN);
        oasis = new EdumiaBiome(-10, EdumiaBiomeKeys.OASIS,  Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, CaveType.DESERT);
        pond = new EdumiaBiome(-10, EdumiaBiomeKeys.POND,  Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE);
        mirkwoodSwamp = new EdumiaBiome(-10, EdumiaBiomeKeys.FAIRY_SWAMP, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE);
        wastePond = new EdumiaBiome(-10, EdumiaBiomeKeys.WASTE_POND, StoneSets.YELLOW_COBBLE.block(), StoneSets.YELLOW_COBBLE.block(), Blocks.STONE);

        // Water Biomes :
        addBiome(new Color(55, 90, 195), defaultBiome);
        addBiome(new Color(104, 168, 222), oasis);
        addBiome(new Color(104, 168, 222), frozenPond);
        addBiome(new Color(110, 154, 218), pond);
        addBiome(new Color(89, 136, 129), mirkwoodSwamp);
        addBiome(new Color(75, 108, 143), wastePond);

        addBiome(new Color(101, 123, 243), new EdumiaBiome(-11, EdumiaBiomeKeys.FROZEN_OCEAN, Blocks.GRAVEL, Blocks.ICE, Blocks.STONE, CaveType.FROZEN));
        addBiome(new Color(75, 106, 199), new EdumiaBiome(-9, EdumiaBiomeKeys.OCEAN_COAST, Blocks.SAND, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(83, 129, 186), new EdumiaBiome(-8, EdumiaBiomeKeys.EDUMIA_RIVER, BlockLoader.WHITE_SAND, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(255, 0, 110), new EdumiaBiome(-1, EdumiaBiomeKeys.GENSAI_REEF, StoneSets.CHALK.block(), Blocks.STONE, Blocks.STONE));



        addBiome(new Color(156, 207, 113), new EdumiaBiome(4, EdumiaBiomeKeys.EDUMIA_VALES, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE));
        addBiome(new Color(234, 222, 117), new EdumiaBiome(1, EdumiaBiomeKeys.GENSAI_BEACH, BlockLoader.WHITE_SAND, Blocks.SANDSTONE, Blocks.STONE, CaveType.DESERT));
        addBiome(new Color(132, 137, 124), new EdumiaBiome(35, EdumiaBiomeKeys.EDUMIA_FOOTHILLS, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(54, 75, 12), new EdumiaBiome(6, EdumiaBiomeKeys.DARK_ELF_FOREST, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE));
        addBiome(new Color(236, 236, 236), new EdumiaBiome(14, EdumiaBiomeKeys.EDUMIA_TUNDRA, Blocks.SNOW_BLOCK, Blocks.SNOW_BLOCK, Blocks.ICE, CaveType.FROZEN));
        addBiome(new Color(237, 229, 145), new EdumiaBiome(4, EdumiaBiomeKeys.ORC_DESERT, Blocks.SAND, Blocks.SAND, Blocks.SANDSTONE, CaveType.DESERT));
        addBiome(new Color(92, 42, 109), new EdumiaBiome(5, EdumiaBiomeKeys.GENSAI_SAKURA_GROVE, Blocks.GRASS_BLOCK, Blocks.DIRT, StoneSets.LIMESTONE.block(), Blocks.STONE));
        addBiome(new Color(178, 0, 255), new EdumiaBiome(35, EdumiaBiomeKeys.AVELION_MOUNTAINS, Blocks.STONE, Blocks.STONE, Blocks.STONE, CaveType.MISTIES));
        addBiome(new Color(67, 193, 125), new EdumiaBiome(35, EdumiaBiomeKeys.AVELION_PLAINS, Blocks.GRASS_BLOCK, Blocks.DIRT, StoneSets.HIGH_ELVEN_ROCK.block()));
        addBiome(new Color(129, 129, 129), new EdumiaBiome(53, EdumiaBiomeKeys.EDUMIA_MOUNTAINS, Blocks.SNOW_BLOCK, Blocks.STONE, Blocks.STONE, CaveType.MISTIES));
        addBiome(new Color(36, 31, 31), new EdumiaBiome(47, EdumiaBiomeKeys.GENSAI_VOLCANO, BlockLoader.VOLCANIC_DIRT, StoneSets.VOLCANIC_ROCK.block(), StoneSets.VOLCANIC_ROCK.block(), CaveType.ASHEN));

        addBiome(new Color(121, 186, 111), new EdumiaBiome(4, EdumiaBiomeKeys.TAIGA_FOREST, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE));

        addBiome(new Color(48, 109, 42), new EdumiaBiome(7, EdumiaBiomeKeys.GENSAI_JUNGLE, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE));

        waterBiomes.add(EdumiaBiomeKeys.FROZEN_POND);
        waterBiomes.add(EdumiaBiomeKeys.FROZEN_OCEAN);
        waterBiomes.add(EdumiaBiomeKeys.OCEAN);
        waterBiomes.add(EdumiaBiomeKeys.OCEAN_COAST);
        waterBiomes.add(EdumiaBiomeKeys.EDUMIA_RIVER);
        waterBiomes.add(EdumiaBiomeKeys.GENSAI_REEF);

        frozenBiomes.add(EdumiaBiomeKeys.EDUMIA_TUNDRA);

        mirkwoodSwampBiomes.add(EdumiaBiomeKeys.DARK_ELF_FOREST);

//        oasisBiomes.add(EdumiaBiomeKeys.ORC_DESERT);

        wastePondBiomes.add(EdumiaBiomeKeys.GENSAI_VOLCANO);
    }

    public static EdumiaBiome getBiomeByKey(RegistryEntry<Biome> biome) {
        return biomes.stream().filter(
                b -> b.biome.getValue().toString().equalsIgnoreCase(biome.getKey().get().getValue().toString()))
                .findFirst().get();
    }
}
