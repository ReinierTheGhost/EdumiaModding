package com.legends.edumia.world.biomes;

import com.legends.edumia.world.biomes.caves.CaveType;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

import java.awt.*;

public class EdumiaBiome {
    public float height;
    public Color color;
    public RegistryKey<Biome> biome;
    public Block surfaceBlock;
    public Block underSurfaceBlock;
    public Block stoneBlock;
    public Block deepStoneBlock;

    public EdumiaBiome(float height, RegistryKey<Biome> biome, Block surfaceBlock, Block underSurfaceBlock, Block stoneBlock, Block deepStoneBlock) {
        this.height = height;
        this.biome = biome;
        this.surfaceBlock = surfaceBlock;
        this.underSurfaceBlock = underSurfaceBlock;
        this.stoneBlock = stoneBlock;
        this.deepStoneBlock = deepStoneBlock;
    }
}
