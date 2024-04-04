package com.legends.edumia.world.biomes;

import com.legends.edumia.utils.noises.SimplexNoise;
import com.legends.edumia.world.biomes.caves.ModCaveBiomes;
import com.legends.edumia.world.map.EdumiaMapRuntime;
import com.mojang.serialization.Codec;
import com.legends.edumia.world.chunkgen.EdumiaChunkGenerator;
import com.legends.edumia.world.chunkgen.map.EdumiaHeightMap;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeCoords;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ModBiomeSource extends BiomeSource {
    private final ArrayList<RegistryEntry<Biome>> biomes;
    private final int CAVE_NOISE = 96;
    private final int CAVE_OFFSET = 7220;
    private EdumiaMapRuntime edumiaMapRuntime;


    public ModBiomeSource(ArrayList<RegistryEntry<Biome>> biomes) {
        this.biomes = biomes;
        edumiaMapRuntime = EdumiaMapRuntime.getInstance();
    }

    @Override
    protected Codec<? extends BiomeSource> getCodec() {
        return CODEC;
    }

    @Override
    protected Stream<RegistryEntry<Biome>> biomeStream() {
        return biomes.stream();
    }

    private RegistryKey<Biome> getCaveBiome(int x, int z, EdumiaBiome surfaceBiome) {
        float temperature = (float) SimplexNoise.noise((double) x / CAVE_NOISE,  (double) z / CAVE_NOISE);
        float humidity = (float) SimplexNoise.noise((double) (x + CAVE_OFFSET) / CAVE_NOISE, (double)(z + CAVE_OFFSET) / CAVE_NOISE);
        return ModCaveBiomes.getBiome(new Vec2f(temperature, humidity), surfaceBiome);
    }

    @Override
    public RegistryEntry<Biome> getBiome(int x, int y, int z, MultiNoiseUtil.MultiNoiseSampler noise) {
        int i = BiomeCoords.toBlock(x);
        int j = BiomeCoords.toBlock(y);
        int k = BiomeCoords.toBlock(z);

        EdumiaBiome edumiaBiome = edumiaMapRuntime.getBiome(i, k);

        if(edumiaBiome == null) {
            return biomes.get(0);
        }

        RegistryKey<Biome> biome = edumiaBiome.biome;
        RegistryKey<Biome> processedBiome;

        if(!EdumiaBiomesData.waterBiomes.contains(biome)) {
            float height = EdumiaChunkGenerator.DIRT_HEIGHT + EdumiaHeightMap.getHeight(i, k);
            if(j < (height - 16)){
                processedBiome = getCaveBiome(i, k, edumiaBiome);
            }
            else if(height <= EdumiaChunkGenerator.WATER_HEIGHT + 1.25f) {
                if (EdumiaBiomesData.oasisBiomes.contains(biome)){
                    processedBiome = EdumiaBiomesData.oasis.biome;
                }else if (EdumiaBiomesData.frozenBiomes.contains(biome)){
                    processedBiome = EdumiaBiomesData.frozenPond.biome;
                }else{
                    processedBiome = EdumiaBiomesData.pond.biome;
                }

            } else processedBiome = biome;
        } else processedBiome = biome;

        return biomes.stream().filter(
                        b -> b.getKey().get().toString().equalsIgnoreCase(processedBiome.toString()))
                .findFirst().get();
    }
}
