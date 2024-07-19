package com.legends.edumia.world.biomes;

import com.legends.edumia.Edumia;
import com.legends.edumia.utils.LoggerUtil;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class EdumiaBiomeKeys extends BiomeKeys {
    // region SURFACE
    public static final RegistryKey<Biome> EDUMIA_VALES = EdumiaBiomeKeys.register("edumia_vales");
    public static final RegistryKey<Biome> GENSAI_BEACH = EdumiaBiomeKeys.register("gensai_beach");
    public static final RegistryKey<Biome> EDUMIA_FOOTHILLS = EdumiaBiomeKeys.register("edumia_foothills");
    public static final RegistryKey<Biome> DARK_ELF_FOREST = EdumiaBiomeKeys.register("dark_elf_forest");
    public static final RegistryKey<Biome> EDUMIA_TUNDRA = EdumiaBiomeKeys.register("edumia_tundra");
    public static final RegistryKey<Biome> FROZEN_OCEAN = EdumiaBiomeKeys.register("frozen_ocean");
    public static final RegistryKey<Biome> FROZEN_POND = EdumiaBiomeKeys.register("frozen_pond");
    public static final RegistryKey<Biome> ORC_DESERT = EdumiaBiomeKeys.register("orc_desert");

    public static final RegistryKey<Biome> AVELION_PLAINS = EdumiaBiomeKeys.register("avelion_plains");

    public static final RegistryKey<Biome> GENSAI_SAKURA_GROVE = EdumiaBiomeKeys.register("gensai_sakura_grove");

    public static final RegistryKey<Biome> FAIRY_SWAMP = EdumiaBiomeKeys.register("fairy_swamp");

    public static final RegistryKey<Biome> AVELION_MOUNTAINS = EdumiaBiomeKeys.register("avelion_mountains");
    public static final RegistryKey<Biome> EDUMIA_MOUNTAINS = EdumiaBiomeKeys.register("edumia_mountains");

    public static final RegistryKey<Biome> GENSAI_VOLCANO = EdumiaBiomeKeys.register("gensai_volcano");

    public static final RegistryKey<Biome> OCEAN = EdumiaBiomeKeys.register("ocean");
    public static final RegistryKey<Biome> OCEAN_COAST = EdumiaBiomeKeys.register("ocean_coast");

    public static final RegistryKey<Biome> OASIS = EdumiaBiomeKeys.register("oasis");
    public static final RegistryKey<Biome> POND = EdumiaBiomeKeys.register("pond");

    public static final RegistryKey<Biome> GENSAI_REEF = EdumiaBiomeKeys.register("gensai_reef");
    public static final RegistryKey<Biome> EDUMIA_RIVER = EdumiaBiomeKeys.register("edumia_river");


    public static final RegistryKey<Biome> TAIGA_FOREST = EdumiaBiomeKeys.register("taiga_forest");


    public static final RegistryKey<Biome> GENSAI_JUNGLE = EdumiaBiomeKeys.register("gensai_jungle");

    public static final RegistryKey<Biome> WASTE_POND = EdumiaBiomeKeys.register("waste_pond");

    // endregion

    // region CAVES
    public static final RegistryKey<Biome> BASIC_CAVE = EdumiaBiomeKeys.register("basic_cave");
    public static final RegistryKey<Biome> LUSH_CAVE = EdumiaBiomeKeys.register("lush_cave");
    public static final RegistryKey<Biome> DRIPSTONE_CAVE = EdumiaBiomeKeys.register("dripstone_cave");
    public static final RegistryKey<Biome> MUD_CAVE = EdumiaBiomeKeys.register("mud_cave");
    public static final RegistryKey<Biome> FUNGUS_CAVE = EdumiaBiomeKeys.register("fungus_cave");
    public static final RegistryKey<Biome> BASALT_CAVE = EdumiaBiomeKeys.register("basalt_cave");
    public static final RegistryKey<Biome> MAGMA_CAVE = EdumiaBiomeKeys.register("magma_cave");
    public static final RegistryKey<Biome> MITHRIL_CAVE = EdumiaBiomeKeys.register("mithril_cave");
    public static final RegistryKey<Biome> DRY_CAVE = EdumiaBiomeKeys.register("dry_cave");
    public static final RegistryKey<Biome> ICE_CAVE = EdumiaBiomeKeys.register("ice_cave");

    // endregion

    public static RegistryKey<Biome> register(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(Edumia.MOD_ID, name));
    }


    public static void registerModBiomes() {
        LoggerUtil.getInstance().logDebugMsg("Registering ModBiomes for " + Edumia.MOD_ID);
    }
}
