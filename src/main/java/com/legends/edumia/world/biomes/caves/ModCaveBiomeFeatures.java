package com.legends.edumia.world.biomes.caves;

import com.legends.edumia.entity.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;

public class ModCaveBiomeFeatures {

    public static void addAmethystGeode(GenerationSettings.LookupBackedBuilder builder) {
    }
    public static void addCitrineGeode(GenerationSettings.LookupBackedBuilder builder) {
    }
    public static void addGlowstoneGeode(GenerationSettings.LookupBackedBuilder builder) {
    }
    public static void addRedAgateGeode(GenerationSettings.LookupBackedBuilder builder) {
    }
    public static void addQuartzGeode(GenerationSettings.LookupBackedBuilder builder) {
    }

    public static void addAxolotls(SpawnSettings.Builder spawnSettings) {
        spawnSettings.spawn(SpawnGroup.AXOLOTLS, new SpawnSettings.SpawnEntry(EntityType.AXOLOTL, 12, 2, 5));
    }
    public static void addBats(SpawnSettings.Builder spawnSettings) {
        spawnSettings.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.BAT, 3, 1, 2));
    }
    public static void addFrogs(SpawnSettings.Builder spawnSettings) {
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FROG, 4, 1, 4));
    }
    public static void addSnails(SpawnSettings.Builder spawnSettings) {
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FROG, 5, 1, 3));
    }

    public static void addCaveTrolls(SpawnSettings.Builder spawnSettings) {
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FROG, 2, 1, 3));
    }
}
