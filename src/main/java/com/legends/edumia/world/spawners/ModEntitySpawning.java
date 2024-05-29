package com.legends.edumia.world.spawners;

import com.legends.edumia.entity.ModEntities;
import com.legends.edumia.world.biomes.EdumiaBiomeKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.List;

public class ModEntitySpawning {
    private static HashMap<RegistryKey<Biome>, List<EntitySpawningSettings>> spawns = new HashMap<>();

    public static void addSpawns() {

        //spawns.put(EdumiaBiomeKeys.BEACH, List.of(new EntitySpawningSettings(ModEntities.CRAB, 1, 3)));
    }

    public static List<EntitySpawningSettings> getSpawnsAt(RegistryKey<Biome> biomeRegistryKey) {
        if(spawns.containsKey(biomeRegistryKey)) return spawns.get(biomeRegistryKey);
        return null;
    }
}
