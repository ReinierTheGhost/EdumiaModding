package com.legends.edumia.world.chunkgen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.legends.edumia.world.biomes.EdumiaBiome;
import com.legends.edumia.world.biomes.EdumiaBiomeKeys;
import com.legends.edumia.world.biomes.EdumiaBiomesData;
import com.legends.edumia.world.biomes.ModBiomeSource;
import com.legends.edumia.world.chunkgen.map.MapImageLoader;
import com.legends.edumia.world.chunkgen.map.EdumiaHeightMap;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryOps;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.CheckedRandom;
import net.minecraft.util.math.random.ChunkRandom;
import net.minecraft.util.math.random.RandomSeed;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.*;
import net.minecraft.world.gen.noise.NoiseConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class EdumiaChunkGenerator extends ChunkGenerator {
    public static final int STONE_HEIGHT = 32;
    public static final int WATER_HEIGHT = 64;
    public static final int HEIGHT = 24 + STONE_HEIGHT;
    public static final int DIRT_HEIGHT = 3 + HEIGHT;

    RegistryEntryLookup<Biome> biomeRegistry;
    public static final Codec<EdumiaChunkGenerator> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(RegistryOps.getEntryLookupCodec(RegistryKeys.BIOME))
                    .apply(instance, instance.stable(EdumiaChunkGenerator::new)));

    public EdumiaChunkGenerator(RegistryEntryLookup<Biome> biomeRegistry) {
        super(new ModBiomeSource(
                new ArrayList<>(Arrays.asList(
                        biomeRegistry.getOrThrow(EdumiaBiomeKeys.EDUMIA_OCEAN),
                        biomeRegistry.getOrThrow(EdumiaBiomeKeys.DARK_ELF_FOREST),
                        biomeRegistry.getOrThrow(EdumiaBiomeKeys.EDUMIA_TUNDRA),
                        biomeRegistry.getOrThrow(EdumiaBiomeKeys.FROZEN_OCEAN),
                        biomeRegistry.getOrThrow(EdumiaBiomeKeys.ORC_DESERT),
                        biomeRegistry.getOrThrow(EdumiaBiomeKeys.AVELION_PLAINS),
                        biomeRegistry.getOrThrow(EdumiaBiomeKeys.MILLPOND),
                        biomeRegistry.getOrThrow(EdumiaBiomeKeys.EDUMIA_MOUNTAINS),
                        biomeRegistry.getOrThrow(EdumiaBiomeKeys.EDUMIA_RIVER),
                        biomeRegistry.getOrThrow(EdumiaBiomeKeys.TAIGA_FOREST),
                        biomeRegistry.getOrThrow(EdumiaBiomeKeys.GENSAI_JUNGLE),
                        biomeRegistry.getOrThrow(EdumiaBiomeKeys.GENSAI_BEACH),
                        biomeRegistry.getOrThrow(EdumiaBiomeKeys.GENSAI_REEF),
                        biomeRegistry.getOrThrow(EdumiaBiomeKeys.GENSAI_SAKURA_GROVE)
                ))
            )
        );
        this.biomeRegistry = biomeRegistry;
    }

    @Override
    protected Codec<? extends ChunkGenerator> getCodec() {
        return CODEC;
    }

    @Override
    public void carve(ChunkRegion chunkRegion, long seed, NoiseConfig noiseConfig,
                      BiomeAccess biomeAccess, StructureAccessor structureAccessor,
                      Chunk chunk2, GenerationStep.Carver carverStep) {

    }

    @Override
    public void buildSurface(ChunkRegion region, StructureAccessor structures, NoiseConfig noiseConfig, Chunk chunk) {
        int bottomY = chunk.getBottomY();
        for(int x = 0; x < 16; x++) {
            for(int z = 0; z < 16; z++) {
                int posX = (chunk.getPos().x * 16) + x;
                int posZ = (chunk.getPos().z * 16) + z;
                EdumiaBiome edumiaBiome;

                if(EdumiaHeightMap.isCoordinateInBounds(posX, posZ)) {
                    edumiaBiome = EdumiaBiomesData.biomeMap.get(MapImageLoader.getBiomeColor(posX, posZ));
                } else {
                    edumiaBiome = EdumiaBiomesData.defaultBiome;
                }

                if(edumiaBiome == null) {
                    int c = MapImageLoader.getBiomeColor(posX, posZ);
                    edumiaBiome = EdumiaBiomesData.defaultBiome;
                }

                float height = EdumiaHeightMap.getHeight(posX, posZ);

                for(int y = bottomY + 1; y <= WATER_HEIGHT; y++) {
                    chunk.setBlockState(chunk.getPos().getBlockPos(x, y, z), Blocks.WATER.getDefaultState(), false);
                }
                chunk.setBlockState(chunk.getPos().getBlockPos(x, bottomY, z), Blocks.BEDROCK.getDefaultState(), false);
                for(int y = bottomY + 1; y < STONE_HEIGHT + height; y++) {
                    chunk.setBlockState(chunk.getPos().getBlockPos(x, y, z), edumiaBiome.deepStoneBlock.getDefaultState(), false);
                }
                if(Math.random() < 0.5f) chunk.setBlockState(chunk.getPos().getBlockPos(x, chunk.getBottomY() + 1, z), Blocks.BEDROCK.getDefaultState(), false);
                for(int y = (int) (STONE_HEIGHT + height); y < HEIGHT + height; y++) {
                    chunk.setBlockState(chunk.getPos().getBlockPos(x, y, z), edumiaBiome.stoneBlock.getDefaultState(), false);
                }
                for(int y = (int) (HEIGHT + height); y < DIRT_HEIGHT + height; y++) {
                    chunk.setBlockState(chunk.getPos().getBlockPos(x, y, z), edumiaBiome.underSurfaceBlock.getDefaultState(), false);
                }

                BlockState surfaceBlock = edumiaBiome.surfaceBlock.getDefaultState();
                if(DIRT_HEIGHT + height < WATER_HEIGHT && edumiaBiome.surfaceBlock == Blocks.GRASS_BLOCK) {
                    surfaceBlock = Blocks.DIRT.getDefaultState();
                }
                chunk.setBlockState(chunk.getPos().getBlockPos(x, (int) (DIRT_HEIGHT + height), z), surfaceBlock, false);
            }
        }

    }


    @Override
    public void populateEntities(ChunkRegion region) {
        ChunkPos chunkPos = region.getCenterPos();
        RegistryEntry<Biome> registryEntry = region.getBiome(chunkPos.getStartPos().withY(region.getTopY() - 1));
        ChunkRandom chunkRandom = new ChunkRandom(new CheckedRandom(RandomSeed.getSeed()));
        chunkRandom.setPopulationSeed(region.getSeed(), chunkPos.getStartX(), chunkPos.getStartZ());
        SpawnHelper.populateEntities(region, registryEntry, chunkPos, chunkRandom);
    }

    @Override
    public int getWorldHeight() {
        return 256;
    }


    @Override
    public CompletableFuture<Chunk> populateNoise(Executor executor, Blender blender, NoiseConfig noiseConfig, StructureAccessor structureAccessor, Chunk chunk) {

        return CompletableFuture.completedFuture(chunk);
    }

    @Override
    public int getSeaLevel() {
        return WATER_HEIGHT;
    }

    @Override
    public int getMinimumY() {
        return 0;
    }

    @Override
    public int getHeight(int x, int z, Heightmap.Type heightmap, HeightLimitView world, NoiseConfig noiseConfig) {
        float worldHeight = 1 + DIRT_HEIGHT + EdumiaHeightMap.getHeight(x, z);
        return (int)worldHeight;
    }

    @Override
    public VerticalBlockSample getColumnSample(int x, int z, HeightLimitView world, NoiseConfig noiseConfig) {
        return new VerticalBlockSample(0, new BlockState[0]);
    }

    @Override
    public void getDebugHudText(List<String> text, NoiseConfig noiseConfig, BlockPos pos) {

    }
}
