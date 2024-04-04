package com.legends.edumia.world.chunkgen;

import com.legends.edumia.block.blocksets.StoneSets;
import com.legends.edumia.utils.noises.BlendedNoise;
import com.legends.edumia.utils.noises.SimplexNoise;
import com.legends.edumia.world.map.EdumiaMapRuntime;
import com.legends.edumia.world.map.EdumiaMapUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.legends.edumia.world.biomes.EdumiaBiome;
import com.legends.edumia.world.biomes.EdumiaBiomeKeys;
import com.legends.edumia.world.biomes.EdumiaBiomesData;
import com.legends.edumia.world.biomes.ModBiomeSource;
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
import net.minecraft.world.*;
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
    public static final int EPMOSTO_LEVEL = -32;
    public static final int DIFTOMIN_LEVEL = 0;
    public static final int DEEPSLATE_LEVEL = 32;
    public static final int STONE_HEIGHT = 36;
    public static final int WATER_HEIGHT = 64;
    public static final int LAVA_HEIGHT = -60;
    public static final int HEIGHT = 27 + STONE_HEIGHT;
    public static final int DIRT_HEIGHT = 3 + HEIGHT;
    public static final int CAVE_NOISE = 5;

    EdumiaMapUtils edumiaMapUtils;
    EdumiaMapRuntime edumiaMapRuntime;

    private static final int CAVE_STRETCH_H = 60;
    private static final int CAVE_STRETCH_V = 50;
    private static float minNoise = 10000;
    private static float maxNoise = -10000;
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
                        biomeRegistry.getOrThrow(EdumiaBiomeKeys.GENSAI_REEF)
                ))
            )
        );
        this.biomeRegistry = biomeRegistry;
        this.edumiaMapUtils = EdumiaMapUtils.getInstance();
        this.edumiaMapRuntime = EdumiaMapRuntime.getInstance();
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
                EdumiaBiome edumiaBiome = null;

                if (edumiaMapUtils.isWorldCoordinateInBorder(posX, posZ)){
                    RegistryEntry<Biome> biome = region.getBiome(new BlockPos(posX, chunk.getTopY(), posZ));
                    edumiaBiome = EdumiaBiomesData.getBiomeByKey(biome);
                    if (edumiaBiome == null){
                        edumiaBiome = EdumiaBiomesData.defaultBiome;
                    }
                } else {
                    edumiaBiome = EdumiaBiomesData.defaultBiome;
                }

                float height = EdumiaHeightMap.getHeight(posX, posZ);
                float caveBlendNoise = (float) ((2 * CAVE_NOISE * BlendedNoise.noise((double) posX / 24,  (double) posZ / 24)) - CAVE_NOISE);

                chunk.setBlockState(chunk.getPos().getBlockPos(x, bottomY, z), Blocks.BEDROCK.getDefaultState(), false);
                for(int y = bottomY + 1; y <= LAVA_HEIGHT; y++) {
                    chunk.setBlockState(chunk.getPos().getBlockPos(x, y, z), Blocks.LAVA.getDefaultState(), false);
                }

                for(int y = bottomY + 1; y < EPMOSTO_LEVEL + caveBlendNoise; y++) {
                    trySetBlock(chunk, chunk.getPos().getBlockPos(x, y, z), StoneSets.BROWN_STONE.block().getDefaultState());
                }

                if(Math.random() < 0.5f) chunk.setBlockState(chunk.getPos().getBlockPos(x, chunk.getBottomY() + 1, z),
                        Blocks.BEDROCK.getDefaultState(), false);

                for(int y = EPMOSTO_LEVEL + (int) caveBlendNoise; y < DIFTOMIN_LEVEL + caveBlendNoise; y++) {
                    trySetBlock(chunk, chunk.getPos().getBlockPos(x, y, z), StoneSets.LIGHT_GRAY_STONE.block().getDefaultState());
                }

                for(int y = DIFTOMIN_LEVEL + (int) caveBlendNoise; y < DEEPSLATE_LEVEL + caveBlendNoise; y++) {
                    trySetBlock(chunk, chunk.getPos().getBlockPos(x, y, z), Blocks.DEEPSLATE.getDefaultState());
                }

                float dirtHeight = HEIGHT + height - 1;

                for(int y = DEEPSLATE_LEVEL + (int) caveBlendNoise; y < (dirtHeight / 2); y++) {
                    trySetBlock(chunk, chunk.getPos().getBlockPos(x, y, z), edumiaBiome.stoneBlock.getDefaultState());
                }

                for(int y = (int) (dirtHeight / 2); y < dirtHeight; y++) {
                    trySetBlock(chunk, chunk.getPos().getBlockPos(x, y, z), edumiaBiome.upperStoneBlock.getDefaultState());
                }

                chunk.setBlockState(chunk.getPos().getBlockPos(x, (int) (HEIGHT + height - 1), z), edumiaBiome.stoneBlock.getDefaultState(), false);

                for(int y = (int) (HEIGHT + height); y < DIRT_HEIGHT + height; y++) {
                    chunk.setBlockState(chunk.getPos().getBlockPos(x, y, z), edumiaBiome.underSurfaceBlock.getDefaultState(), false);
                }

                BlockState surfaceBlock = edumiaBiome.surfaceBlock.getDefaultState();

                if(DIRT_HEIGHT + height < WATER_HEIGHT && edumiaBiome.surfaceBlock == Blocks.GRASS_BLOCK) {
                    surfaceBlock = Blocks.DIRT.getDefaultState();
                }

                chunk.setBlockState(chunk.getPos().getBlockPos(x, (int) (DIRT_HEIGHT + height), z), surfaceBlock, false);

                for(int y = (int) (DIRT_HEIGHT + height + 1); y <= WATER_HEIGHT; y++) {
                    chunk.setBlockState(chunk.getPos().getBlockPos(x, y, z), Blocks.WATER.getDefaultState(), false);
                }
            }
        }

    }

    private void trySetBlock(Chunk chunk, BlockPos blockPos, BlockState blockState) {
        float noise = 0;
        if(blockPos.getY() < WATER_HEIGHT) {
            noise =(float) SimplexNoise.noise(
                    (float) blockPos.getX() / CAVE_STRETCH_H, Math.tan((float) blockPos.getY() / CAVE_STRETCH_V), (float) blockPos.getZ() / CAVE_STRETCH_H);
            noise += 0.5f * (float) SimplexNoise.noise(
                    (float) blockPos.getX() / (CAVE_STRETCH_H * 0.5f), (float) blockPos.getY() / (CAVE_STRETCH_V * 0.5f), (float) blockPos.getZ() / (CAVE_STRETCH_H * 0.5f));
            noise = noise / (1 + 0.5f);
        }
        float noise3 = (float) SimplexNoise.noise((float) blockPos.getX() / 90, (float) blockPos.getY() / 60, (float) blockPos.getZ() / 90);
        float miniNoise = (float) SimplexNoise.noise((float) blockPos.getX() / 40, (float) blockPos.getY() / 30, (float) blockPos.getZ() / 40);

        if(noise < 0.4f && noise3 < 0.75f && miniNoise < 0.8f) { //
            chunk.setBlockState(blockPos, blockState, false);
        }
    }

    @Override
    public void generateFeatures(StructureWorldAccess world, Chunk chunk, StructureAccessor structureAccessor) {
        super.generateFeatures(world, chunk, structureAccessor);
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
        return 384;
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
        return -4;
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
