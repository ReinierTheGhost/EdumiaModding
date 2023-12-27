package com.legends.edumia.world.biomes;

import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.Map;

public class EdumiaBiomeFogData {
    public static Map<RegistryKey<Biome>, EdumiaBiomeFogData> DATA;
    static {
        DATA = new HashMap<>();

        DATA.put(EdumiaBiomeKeys.DARK_ELF_FOREST, new EdumiaBiomeFogData(0.4f, 0.6f));
        DATA.put(EdumiaBiomeKeys.EDUMIA_TUNDRA, new EdumiaBiomeFogData(0.3f, 0.5f));
        DATA.put(EdumiaBiomeKeys.EDUMIA_MOUNTAINS, new EdumiaBiomeFogData(-2.0f, 0.2f));
        DATA.put(EdumiaBiomeKeys.GENSAI_JUNGLE, new EdumiaBiomeFogData(0.4f, 0.6f));
    };

    public float fogStart;
    public float fogEnd;

    public EdumiaBiomeFogData(float fogStart, float fogEnd) {
        this.fogStart = fogStart;
        this.fogEnd = fogEnd;
    }
}
