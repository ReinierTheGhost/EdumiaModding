package com.legends.edumia.world.biomes;

import com.mojang.serialization.Codec;
import com.legends.edumia.world.chunkgen.EdumiaChunkGenerator;
import com.legends.edumia.world.chunkgen.map.MapImageLoader;
import com.legends.edumia.world.chunkgen.map.EdumiaHeightMap;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeCoords;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ModBiomeSource extends BiomeSource {
    private final ArrayList<RegistryEntry<Biome>> biomes;

    public ModBiomeSource(ArrayList<RegistryEntry<Biome>> biomes) {
        this.biomes = biomes;
    }

    @Override
    protected Codec<? extends BiomeSource> getCodec() {
        return CODEC;
    }

    @Override
    protected Stream<RegistryEntry<Biome>> biomeStream() {
        return biomes.stream();
    }

    @Override
    public RegistryEntry<Biome> getBiome(int x, int y, int z, MultiNoiseUtil.MultiNoiseSampler noise) {
        int i = BiomeCoords.toBlock(x);
        int k = BiomeCoords.toBlock(z);

        if(!EdumiaHeightMap.isCoordinateInBounds(i, k)) return biomes.get(0);
        EdumiaBiome edumiaBiome = EdumiaBiomesData.biomeMap.get(MapImageLoader.getBiomeColor(i, k));
        if(edumiaBiome == null) {
            return biomes.get(0);
        }

        RegistryKey<Biome> biome = edumiaBiome.biome;
        RegistryKey<Biome> processedBiome;

        if(!EdumiaBiomesData.waterBiomes.contains(biome)) {
            float height = EdumiaChunkGenerator.DIRT_HEIGHT + EdumiaHeightMap.getHeight(i, k);
            if(height <= EdumiaChunkGenerator.WATER_HEIGHT + 1.25f) {
                processedBiome = EdumiaBiomesData.millPond.biome;
            } else processedBiome = biome;
        } else processedBiome = biome;

        return biomes.stream().filter(
                        b -> b.getKey().get().toString().equalsIgnoreCase(processedBiome.toString()))
                .findFirst().get();
    }
}
