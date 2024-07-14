package com.legends.edumia.world.biomes.surface;

import com.legends.edumia.world.biomes.BiomeColorsDTO;
import com.legends.edumia.world.biomes.EdumiaBiomeKeys;
import com.legends.edumia.world.spawners.ModSpawnSettingsBuilder;
import com.legends.edumia.world.worldgen.placed.ocean.ReefPlacedFeatures;
import com.legends.edumia.world.worldgen.placed.trees.TemperateTreePlacedFeatures;
import com.legends.edumia.world.worldgen.placed.trees.TropicalTreePlacedFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ModBiomes {
    public static final int defaultSky = 7907327;
    public static final int defaultFog = 12638463;
    public static final int defaultWater = 4159204;
    public static final int defaultWaterFog = 329011;
    public static final int hillySky = 8233727;
    public static final int waterSky = 8103167;
    public static final int nearHaradSky = 7254527;
    public static final int nearHaradSkyFog = 12902399;

    private static List<RegistryKey<PlacedFeature>> vegetation = new ArrayList<>();;
    private static ArrayList<RegistryKey<PlacedFeature>> undergroundOres = new ArrayList<>();;

    public static void bootstrap(Registerable<Biome> context) {
        context.register(EdumiaBiomeKeys.EDUMIA_VALES, createAnduinBiome(context, new BiomeColorsDTO(
                defaultSky, defaultFog, defaultWater, defaultWaterFog, 8703593, 8703593)));

        context.register(EdumiaBiomeKeys.GENSAI_BEACH, createCorsairCoastBiome(context, new BiomeColorsDTO(
                nearHaradSky, defaultFog, 5212644, 333363, 12107900, 10860366)));

        context.register(EdumiaBiomeKeys.EDUMIA_FOOTHILLS, createEdumiaFoothillsBiome(context, new BiomeColorsDTO(
                7508201, 10863086, defaultWater, defaultWaterFog, 6722387, 6198343)));

        context.register(EdumiaBiomeKeys.DARK_ELF_FOREST, createDarkElvenWoodBiome(context, new BiomeColorsDTO(
                7972607, defaultFog, 4293787, 338483, 3559947, 1789719)));

        context.register(EdumiaBiomeKeys.EDUMIA_TUNDRA, createForodwaithBiome(context, new BiomeColorsDTO(
                8364543, 10335206, 3823818, 66852, 3494723, 4478280)));

        context.register(EdumiaBiomeKeys.FROZEN_OCEAN, createOceanBiome(context, new BiomeColorsDTO(
                8628223, 10599910, 3750089, 263470, 3494723, 4478280)));

        context.register(EdumiaBiomeKeys.FROZEN_POND, createFrozenPond(context, new BiomeColorsDTO(
                8628223, 10599910, 3750089, 263470, 3494723, 4478280)));

        context.register(EdumiaBiomeKeys.ORC_DESERT, createHaradDesertBiome(context, new BiomeColorsDTO(
                nearHaradSky, nearHaradSkyFog, 5407446, 1120828, 13419633, 9615182)));

        context.register(EdumiaBiomeKeys.AVELION_PLAINS, createAvelionPlainsBiome(context, new BiomeColorsDTO(
                8827134, 12771327, defaultWater, defaultWaterFog, 6929025, 5157703)));

        context.register(EdumiaBiomeKeys.GENSAI_SAKURA_GROVE, createGensaiSakuraGroveBiome(context, new BiomeColorsDTO(
                defaultSky, 13748853, defaultWater, defaultWaterFog, 12961832, 6989412)));

        context.register(EdumiaBiomeKeys.FAIRY_SWAMP, createMirkwoodSwampBiome(context, new BiomeColorsDTO(
                6981536, 8821922, 5080729, 1458241, 4546876, 4284215)));

        context.register(EdumiaBiomeKeys.AVELION_MOUNTAINS, createMistyMountainsBiome(context, new BiomeColorsDTO(
                hillySky, defaultFog, defaultWater, defaultWaterFog, 7777673, 7316862), true));

        context.register(EdumiaBiomeKeys.EDUMIA_MOUNTAINS, createMistyMountainsBiome(context, new BiomeColorsDTO(
                9745151, 13426943, defaultWater, defaultWaterFog, 7643011, 7709826), false));

        context.register(EdumiaBiomeKeys.GENSAI_VOLCANO, createGensaiFulcanoBiome(context, new BiomeColorsDTO(
                4142646, 3090215, 6450777, 1513734, 3550502, 2169880)));

        context.register(EdumiaBiomeKeys.OCEAN, createOceanBiome(context, new BiomeColorsDTO(
                waterSky, defaultFog, 4157145, defaultWaterFog, 7576434, 6588506)));

        context.register(EdumiaBiomeKeys.OCEAN_COAST, createOceanCoastBiome(context, new BiomeColorsDTO(
                8104447, defaultFog, 5145060, 330291, 7971954, 6590810)));

        context.register(EdumiaBiomeKeys.OASIS, createOasisBiome(context, new BiomeColorsDTO(
                nearHaradSky, nearHaradSkyFog, 5407446, 1120828, 7253092, 6592350)));

        context.register(EdumiaBiomeKeys.POND, createPondBiome(context, new BiomeColorsDTO(
                waterSky, defaultFog, 4290786, defaultWaterFog, 7583083, 6592339)));


        context.register(EdumiaBiomeKeys.EDUMIA_RIVER, createRiverBiome(context, new BiomeColorsDTO(
                waterSky, defaultFog, 4290790, defaultWaterFog, 7583083, 6592339)));
        context.register(EdumiaBiomeKeys.GENSAI_REEF, createGensaiReefBiome(context, new BiomeColorsDTO(
                waterSky, 12638463, 4159204, defaultWaterFog, 10995507, 7181907)));
       context.register(EdumiaBiomeKeys.TAIGA_FOREST, createNorthDunlandBiome(context, new BiomeColorsDTO(
                7508201, 10863086, defaultWater, defaultWaterFog, 8302697, 7252827), false));

        context.register(EdumiaBiomeKeys.GENSAI_JUNGLE, createGensaiJungleBiome(context, new BiomeColorsDTO(
                6785744, 10004675, 4421513, 402733, 2311707, 2050588)));

        context.register(EdumiaBiomeKeys.WASTE_POND, createWastePondBiome(context, new BiomeColorsDTO(
                8163746, 10926783, 5860963, 863008, 4020033, 2371608)));

    }

    public static Biome createAnduinBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addFarmAnimals(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addDefaultVegetation(generationSettings);
        ModBiomeFeatures.addCoarseDirtOre(vegetation);
        ModBiomeFeatures.addFlowerGreenJewel(vegetation);
        ModBiomeFeatures.addGravelOre(vegetation);
        ModBiomeFeatures.addOakBushes(vegetation);
        ModBiomeFeatures.addWildGrass(vegetation);
        ModBiomeFeatures.addWilderGrass(vegetation);
        ModBiomeFeatures.addVeryRareBirchTrees(vegetation);
        ModBiomeFeatures.addSparseLarchTrees(vegetation);
        ModBiomeFeatures.addMapleTrees(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }

    public static Biome createCorsairCoastBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addHaradMobs(spawnSettings);
        ModSpawnSettingsBuilder.addLlama(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addHaradVegetation(generationSettings);
        ModBiomeFeatures.addCoastalFoliage(vegetation);
        vegetation.add(VegetationPlacedFeatures.PATCH_CACTUS_DESERT);
        ModBiomeFeatures.addGraniteBoulder(vegetation);
        ModBiomeFeatures.addSandStoneBoulder(vegetation);
        ModBiomeFeatures.addStoneBoulder(vegetation);
        ModBiomeFeatures.addSandOre(vegetation);
        ModBiomeFeatures.addGravelOre(vegetation);

        ModBiomeFeatures.addPalmTrees(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }

    public static Biome createEdumiaFoothillsBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addMountainsMobs(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addNordicVegetation(generationSettings);
        ModBiomeFeatures.addCoarseDirtOre(vegetation);
        ModBiomeFeatures.addDolomiteOre(vegetation);
        ModBiomeFeatures.addGravelOre(vegetation);
        ModBiomeFeatures.addPodzolOre(vegetation);
        ModBiomeFeatures.addStoneGrassOre(vegetation);
        ModBiomeFeatures.addTuffOre(vegetation);
        ModBiomeFeatures.addCommonLarchTrees(vegetation);
        ModBiomeFeatures.addAbundantPineTrees(vegetation);
        ModBiomeFeatures.addAbundantSpruceTrees(vegetation);
        ModBiomeFeatures.addCommonSpruceBushes(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }

    public static Biome createDarkElvenWoodBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addDefaultVegetation(generationSettings);
        vegetation.add(VegetationPlacedFeatures.PATCH_TALL_GRASS_2);
        ModBiomeFeatures.addMossyBoulder(vegetation);
        ModBiomeFeatures.addForestMoss(vegetation);
        ModBiomeFeatures.addForestBlockMoss(vegetation);
        ModBiomeFeatures.addOldPodzolOre(vegetation);
        ModBiomeFeatures.addGravelOre(vegetation);
        ModBiomeFeatures.addWildGrass(vegetation);
        ModBiomeFeatures.addRareMorsel(vegetation);
        ModBiomeFeatures.addRareWhiteMushroom(vegetation);

        ModBiomeFeatures.addDarkElvenOakTrees(vegetation);


        return createBiome(biomeColors, spawnSettings, generationSettings);
    }

    public static Biome createForodwaithBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addForochelMobs(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addForodwaithVegetation(generationSettings);

        return createBiome(biomeColors, spawnSettings, generationSettings, -0.8f, true);
    }

    public static Biome createHaradDesertBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addHaradMobs(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addHaradDesertVegetation(generationSettings);
        vegetation.add(VegetationPlacedFeatures.PATCH_DEAD_BUSH_2);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.8f, false);
    }

    public static Biome createAvelionPlainsBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addFarmAnimals(spawnSettings);
        ModSpawnSettingsBuilder.addPlainsMobs(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addDefaultVegetation(generationSettings);
        ModBiomeFeatures.addCornflower(vegetation);
        ModBiomeFeatures.addRareForestMoss(vegetation);
        ModBiomeFeatures.addGravelOre(vegetation);
        ModBiomeFeatures.addLimestoneBoulder(vegetation);
        ModBiomeFeatures.addWhiteSand(vegetation);
        ModBiomeFeatures.addOakBushes(vegetation);
        ModBiomeFeatures.addRareBirchTrees(vegetation);
        ModBiomeFeatures.addMegaBirchTrees(vegetation);
        ModBiomeFeatures.addRareMegaOakTrees(vegetation);
        ModBiomeFeatures.addElvenCrystal(undergroundOres);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }

    public static Biome createGensaiSakuraGroveBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addFarmAnimals(spawnSettings);
        ModSpawnSettingsBuilder.addSwan(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        vegetation.add(TemperateTreePlacedFeatures.GENSAI_SAKURA_GROVE_TREES);

        addLothlorienVegetation(generationSettings);


        return createBiome(biomeColors, spawnSettings, generationSettings);
    }

    public static Biome createMirkwoodSwampBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addSwampMobs(spawnSettings);

        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addMirkwoodVegetation(generationSettings);
        ModBiomeFeatures.addWaterDelta(vegetation);
        ModBiomeFeatures.addForestMoss(vegetation);
        ModBiomeFeatures.addReedsFoliage(vegetation);
        ModBiomeFeatures.addWheatGrass(vegetation);
        ModBiomeFeatures.addMudOre(vegetation);

        ModBiomeFeatures.addWillowTrees(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }

    public static Biome createMistyMountainsBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors, boolean foothills) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        float temperature = -0.6f;
        addNordicVegetation(generationSettings);
        ModBiomeFeatures.addDolomiteOre(vegetation);
        ModBiomeFeatures.addTuffOre(vegetation);
        if(foothills) {
            temperature = 0.2f;
            ModBiomeFeatures.addCoarseDirtOre(vegetation);
            ModBiomeFeatures.addGravelOre(vegetation);
            ModBiomeFeatures.addStoneGrassOre(vegetation);
            ModBiomeFeatures.addCommonLarchTrees(vegetation);
            ModBiomeFeatures.addAbundantPineTrees(vegetation);
            ModBiomeFeatures.addAbundantSpruceTrees(vegetation);
            ModBiomeFeatures.addCommonSpruceBushes(vegetation);
        } else {
            ModBiomeFeatures.addPowderSnowOre(vegetation);
        }
        return createBiome(biomeColors, spawnSettings, generationSettings,temperature, true);
    }

    public static Biome createGensaiFulcanoBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addMordorVegetation(generationSettings);
        ModBiomeFeatures.addAshenDirtStoneOre(vegetation);
        ModBiomeFeatures.addLavaMagmaLake(generationSettings);
        ModBiomeFeatures.addBasaltPile(vegetation);
        ModBiomeFeatures.addBlackStonePile(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings, 0.7f, false);
    }

    public static Biome createNorthDunlandBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors, boolean trees) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addFarmAnimals(spawnSettings);
        ModSpawnSettingsBuilder.addNordicMobs(spawnSettings);
        ModSpawnSettingsBuilder.addWolves(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addNordicVegetation(generationSettings);
        ModBiomeFeatures.addGravelOre(vegetation);
        ModBiomeFeatures.addCoarseDirtOre(vegetation);
        ModBiomeFeatures.addOakBushes(vegetation);
        ModBiomeFeatures.addSpruceBushes(vegetation);

        if(trees) {
            ModBiomeFeatures.addForestMoss(vegetation);
            ModBiomeFeatures.addBirchTrees(vegetation);
            ModBiomeFeatures.addLarchTrees(vegetation);
            ModBiomeFeatures.addOakTrees(vegetation);
            ModBiomeFeatures.addCommonPineTrees(vegetation);
            ModBiomeFeatures.addSpruceTrees(vegetation);
        } else {
            ModBiomeFeatures.addLarchTrees(vegetation);
            ModBiomeFeatures.addSparsePineTrees(vegetation);
            ModBiomeFeatures.addRareSpruceTrees(vegetation);
        }
        return createBiome(biomeColors, spawnSettings, generationSettings);
    }

    public static Biome createGensaiJungleBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addDeer(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        vegetation.add(VegetationPlacedFeatures.PATCH_TALL_GRASS_2);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_PLAIN);
        vegetation.add(VegetationPlacedFeatures.BAMBOO_LIGHT);
        vegetation.add(TropicalTreePlacedFeatures.GENSAI_JUNGLE_TREES);


        return createBiome(biomeColors, spawnSettings, generationSettings);
    }

    public static Biome createRiverBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addRiverAnimals(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        ModBiomeFeatures.addRiverDisks(undergroundOres);
        vegetation.add(OceanPlacedFeatures.KELP_COLD);
        vegetation.add(OceanPlacedFeatures.SEAGRASS_NORMAL);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_FOREST);
        vegetation.add(VegetationPlacedFeatures.FLOWER_DEFAULT);
        vegetation.add(VegetationPlacedFeatures.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacedFeatures.PATCH_PUMPKIN);
        ModBiomeFeatures.addReedsFoliage(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }

    public static Biome createGensaiReefBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addRiverAnimals(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        //addOceanVegetation(generationSettings);
        addReef(generationSettings);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }

    public static Biome createOasisBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addRiverAnimals(spawnSettings);
        ModSpawnSettingsBuilder.addCamel(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addOasisVegetation(generationSettings);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }


    public static Biome createWastePondBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addRiverAnimals(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(OceanPlacedFeatures.KELP_WARM);
        vegetation.add(OceanPlacedFeatures.SEAGRASS_NORMAL);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_FOREST);
        vegetation.add(VegetationPlacedFeatures.PATCH_SUGAR_CANE);
        ModBiomeFeatures.addReedsFoliage(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }

    public static Biome createOceanBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addOceanAnimals(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addOceanVegetation(generationSettings);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }

    public static Biome createOceanCoastBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addOceanAnimals(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addOceanVegetation(generationSettings);
        ModBiomeFeatures.addCoastalFoliage(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }

    public static Biome createPondBiome(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addRiverAnimals(spawnSettings);
        ModSpawnSettingsBuilder.addDuck(spawnSettings);
        ModSpawnSettingsBuilder.addGoose(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addOceanVegetation(generationSettings);
        ModBiomeFeatures.addRiverSand(undergroundOres);
        ModBiomeFeatures.addWillowTrees(vegetation);
        ModBiomeFeatures.addReeds(vegetation);

        return createBiome(biomeColors, spawnSettings, generationSettings);
    }

    public static Biome createFrozenPond(Registerable<Biome> context, BiomeColorsDTO biomeColors) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModSpawnSettingsBuilder.addColdWaterAnimals(spawnSettings);
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));
        
        ModBiomeFeatures.addDisks(undergroundOres);

        vegetation.add(OceanPlacedFeatures.KELP_COLD);
        vegetation.add(OceanPlacedFeatures.SEAGRASS_NORMAL);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_FOREST);

        return createBiome(biomeColors, spawnSettings, generationSettings, -0.1f, true);
    }

    public static void addNordicTrees(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addLarchTrees(vegetation);
        ModBiomeFeatures.addSparsePineTrees(vegetation);
        ModBiomeFeatures.addRareSpruceTrees(vegetation);
    }

    public static void addDarkElvenTrees(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addRedOakTrees(vegetation);
        ModBiomeFeatures.addGreenOakTrees(vegetation);

        ModBiomeFeatures.addSparseRedOakTrees(vegetation);
        ModBiomeFeatures.addSparseGreenOakTrees(vegetation);

    }

    public static void addMegaDarkElvenTrees(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addMegaRedOakTrees(vegetation);
        ModBiomeFeatures.addMegaGreenOakTrees(vegetation);

    }

    public static void addDefaultVegetation(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_FOREST);
        vegetation.add(VegetationPlacedFeatures.FLOWER_DEFAULT);
        vegetation.add(VegetationPlacedFeatures.BROWN_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.RED_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacedFeatures.PATCH_PUMPKIN);
        ModBiomeFeatures.addStoneBoulder(vegetation);
        ModBiomeFeatures.addWildBeetroot(vegetation);
        ModBiomeFeatures.addWildCucumber(vegetation);
        ModBiomeFeatures.addWildFlax(vegetation);
        ModBiomeFeatures.addWildGarlic(vegetation);
    }

    public static void addArthedainVegetation(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_NORMAL);
        vegetation.add(VegetationPlacedFeatures.PATCH_TALL_GRASS_2);
        vegetation.add(VegetationPlacedFeatures.FLOWER_DEFAULT);
        vegetation.add(VegetationPlacedFeatures.BROWN_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.RED_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacedFeatures.PATCH_PUMPKIN);
        ModBiomeFeatures.addHeather(vegetation);
        ModBiomeFeatures.addHeatherBush(vegetation);
        ModBiomeFeatures.addWheatGrass(vegetation);
        ModBiomeFeatures.addWilderGrass(vegetation);
        ModBiomeFeatures.addWildGarlic(vegetation);
        ModBiomeFeatures.addWildLeek(vegetation);
        ModBiomeFeatures.addWildLettuce(vegetation);
        ModBiomeFeatures.addWildPotato(vegetation);
        ModBiomeFeatures.addStoneBoulder(vegetation);
        ModBiomeFeatures.addDryDirtOre(vegetation);
        ModBiomeFeatures.addGravelOre(vegetation);
    }

    public static void addEriadorVegetation(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_FOREST);
        vegetation.add(VegetationPlacedFeatures.FLOWER_DEFAULT);
        vegetation.add(VegetationPlacedFeatures.BROWN_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.RED_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacedFeatures.PATCH_PUMPKIN);
        vegetation.add(VegetationPlacedFeatures.TREES_PLAINS);
        ModBiomeFeatures.addFlowerGreenJewel(vegetation);
        ModBiomeFeatures.addWildFlax(vegetation);
        ModBiomeFeatures.addWildGrass(vegetation);
        ModBiomeFeatures.addWildLeek(vegetation);
        ModBiomeFeatures.addWildLettuce(vegetation);
        ModBiomeFeatures.addWildOnion(vegetation);
        ModBiomeFeatures.addGraniteBoulder(vegetation);
    }

    public static void addForodwaithVegetation(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        ModBiomeFeatures.addToughBerriesRare(vegetation);
    }

    public static void addGondorVegetation(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_FOREST);
        vegetation.add(VegetationPlacedFeatures.FLOWER_DEFAULT);
        vegetation.add(VegetationPlacedFeatures.BROWN_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.RED_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacedFeatures.PATCH_PUMPKIN);
        ModBiomeFeatures.addWildCarrot(vegetation);
        ModBiomeFeatures.addWildOnion(vegetation);
        ModBiomeFeatures.addWildGarlic(vegetation);
        ModBiomeFeatures.addWildFlax(vegetation);
    }

    public static void addHaradVegetation(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_SAVANNA);
        vegetation.add(VegetationPlacedFeatures.PATCH_TALL_GRASS);
        vegetation.add(VegetationPlacedFeatures.PATCH_SUGAR_CANE);
        ModBiomeFeatures.addHaradFoliage(vegetation);
        ModBiomeFeatures.addDryDirtOre(vegetation);
        ModBiomeFeatures.addWildBellPepper(vegetation);
        ModBiomeFeatures.addWildTomato(vegetation);
    }

    public static void addHaradDesertVegetation(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(VegetationPlacedFeatures.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_SAVANNA);
        ModBiomeFeatures.addDryGrass(vegetation);
        ModBiomeFeatures.addSandStoneBoulder(vegetation);
    }

    public static void addLothlorienVegetation(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_FOREST);
        vegetation.add(VegetationPlacedFeatures.FLOWER_MEADOW);
        vegetation.add(VegetationPlacedFeatures.BROWN_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.RED_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacedFeatures.PATCH_PUMPKIN);
        vegetation.add(VegetationPlacedFeatures.TREES_PLAINS);
        ModBiomeFeatures.addGravelOre(vegetation);
        ModBiomeFeatures.addDryDirtOre(vegetation);
        ModBiomeFeatures.addLimestoneBoulder(vegetation);
        ModBiomeFeatures.addTuftGrass(vegetation);
        ModBiomeFeatures.addWilderGrass(vegetation);
        ModBiomeFeatures.addWhiteAshBushes(vegetation);
        ModBiomeFeatures.addOakBushes(vegetation);
        ModBiomeFeatures.addMallos(vegetation);
        ModBiomeFeatures.addWildCarrot(vegetation);
        ModBiomeFeatures.addWildFlax(vegetation);
        ModBiomeFeatures.addWildLettuce(vegetation);
        ModBiomeFeatures.addWildOnion(vegetation);
    }

    public static void addMirkwoodVegetation(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_FOREST);
        vegetation.add(VegetationPlacedFeatures.PATCH_TALL_GRASS_2);
        vegetation.add(VegetationPlacedFeatures.PATCH_LARGE_FERN);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_TAIGA);
        vegetation.add(VegetationPlacedFeatures.BROWN_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.RED_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.PATCH_BERRY_RARE);
        ModBiomeFeatures.addCoarseDirtOre(vegetation);
        ModBiomeFeatures.addOldPodzolOre(vegetation);
        ModBiomeFeatures.addWildGrass(vegetation);
        ModBiomeFeatures.addOakBushes(vegetation);
        ModBiomeFeatures.addWildFlax(vegetation);
        ModBiomeFeatures.addWildGarlic(vegetation);
        ModBiomeFeatures.addWildOnion(vegetation);
        ModBiomeFeatures.addMossyBoulder(vegetation);
    }

    public static void addMordorVegetation(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        ModBiomeFeatures.addMordorLichen(vegetation);
        ModBiomeFeatures.addAshBlockOre(vegetation);
        ModBiomeFeatures.addBasaltOre(vegetation);
        ModBiomeFeatures.addBlackSand(vegetation);
        ModBiomeFeatures.addCommonToughBerries(vegetation);
    }

    public static void addNordicVegetation(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(VegetationPlacedFeatures.PATCH_LARGE_FERN);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_TAIGA);
        vegetation.add(VegetationPlacedFeatures.FLOWER_DEFAULT);
        vegetation.add(VegetationPlacedFeatures.BROWN_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.RED_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.PATCH_BERRY_RARE);
        ModBiomeFeatures.addAndesiteBoulder(vegetation);
        ModBiomeFeatures.addWildGrass(vegetation);
        ModBiomeFeatures.addBrownBolete(vegetation);
        ModBiomeFeatures.addMorsel(vegetation);
        ModBiomeFeatures.addWhiteMushroom(vegetation);
        ModBiomeFeatures.addWildBeetroot(vegetation);
        ModBiomeFeatures.addWildPotato(vegetation);
    }

    public static void addOasisVegetation(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(OceanPlacedFeatures.KELP_WARM);
        vegetation.add(OceanPlacedFeatures.SEAGRASS_WARM);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_SAVANNA);
        vegetation.add(VegetationPlacedFeatures.FLOWER_DEFAULT);
        vegetation.add(VegetationPlacedFeatures.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacedFeatures.PATCH_PUMPKIN);
        ModBiomeFeatures.addHaradFoliage(vegetation);
        ModBiomeFeatures.addWildBellPepper(vegetation);
        ModBiomeFeatures.addWildTomato(vegetation);
    }

    public static void addOceanVegetation(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(OceanPlacedFeatures.KELP_COLD);
        vegetation.add(OceanPlacedFeatures.SEAGRASS_NORMAL);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_FOREST);
        vegetation.add(VegetationPlacedFeatures.FLOWER_DEFAULT);
        vegetation.add(VegetationPlacedFeatures.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacedFeatures.PATCH_PUMPKIN);
        ModBiomeFeatures.addReedsFoliage(vegetation);
    }

    public static void addReef(GenerationSettings.LookupBackedBuilder generationSettings) {
        vegetation.add(ReefPlacedFeatures.REEF_KEY);
    }

    public static void addRivendellVegetation(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_FOREST);
        vegetation.add(VegetationPlacedFeatures.BROWN_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.RED_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacedFeatures.PATCH_PUMPKIN);
        ModBiomeFeatures.addFlowerMeadow(vegetation);
        ModBiomeFeatures.addWilderGrass(vegetation);
        ModBiomeFeatures.addGravelOre(vegetation);
        ModBiomeFeatures.addWhiteSand(vegetation);

        ModBiomeFeatures.addWildLeek(vegetation);
        ModBiomeFeatures.addWildLettuce(vegetation);
        ModBiomeFeatures.addWildOnion(vegetation);
        ModBiomeFeatures.addLimestoneBoulder(vegetation);
    }

    public static void addRhunVegetation(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_FOREST);
        vegetation.add(VegetationPlacedFeatures.TREES_PLAINS);
        vegetation.add(VegetationPlacedFeatures.FLOWER_DEFAULT);
        vegetation.add(VegetationPlacedFeatures.BROWN_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.RED_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacedFeatures.PATCH_PUMPKIN);
        ModBiomeFeatures.addWildCarrot(vegetation);
        ModBiomeFeatures.addWildBellPepper(vegetation);
        ModBiomeFeatures.addWildFlax(vegetation);
        ModBiomeFeatures.addWildLettuce(vegetation);
        ModBiomeFeatures.addWildOnion(vegetation);
        ModBiomeFeatures.addStoneBoulder(vegetation);
    }

    public static void addShireVegetation(GenerationSettings.LookupBackedBuilder generationSettings) {
        ModBiomeFeatures.addDisks(undergroundOres);
        vegetation.add(VegetationPlacedFeatures.PATCH_GRASS_FOREST);
        vegetation.add(VegetationPlacedFeatures.FLOWER_DEFAULT);
        vegetation.add(VegetationPlacedFeatures.BROWN_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.RED_MUSHROOM_NORMAL);
        vegetation.add(VegetationPlacedFeatures.PATCH_SUGAR_CANE);
        vegetation.add(VegetationPlacedFeatures.PATCH_PUMPKIN);
        ModBiomeFeatures.addWilderGrass(vegetation);
        ModBiomeFeatures.addGravelOre(vegetation);
        ModBiomeFeatures.addWildBeetroot(vegetation);
        ModBiomeFeatures.addWildCarrot(vegetation);
        ModBiomeFeatures.addWildCucumber(vegetation);
        ModBiomeFeatures.addWildGarlic(vegetation);
        ModBiomeFeatures.addWildLeek(vegetation);
        ModBiomeFeatures.addWildLettuce(vegetation);
        ModBiomeFeatures.addWildOnion(vegetation);
        ModBiomeFeatures.addWildPipeweed(vegetation);
        ModBiomeFeatures.addWildPotato(vegetation);
        ModBiomeFeatures.addStoneBoulder(vegetation);
    }

    public static Biome createBiome(BiomeColorsDTO biomeColors, SpawnSettings.Builder spawnSettings, GenerationSettings.LookupBackedBuilder generationSettings) {
        return createBiome(biomeColors, spawnSettings, generationSettings, 0.5f, true);
    }

    public static Biome createBiome(BiomeColorsDTO biomeColors, SpawnSettings.Builder spawnSettings, GenerationSettings.LookupBackedBuilder generationSettings, float temperature, boolean precipitation) {
        undergroundOres.add(OrePlacedFeatures.ORE_DIRT);
        undergroundOres.add(OrePlacedFeatures.ORE_GRAVEL);
        undergroundOres.add(OrePlacedFeatures.ORE_GRANITE_UPPER);
        undergroundOres.add(OrePlacedFeatures.ORE_GRANITE_LOWER);
        undergroundOres.add(OrePlacedFeatures.ORE_DIORITE_UPPER);
        undergroundOres.add(OrePlacedFeatures.ORE_DIORITE_LOWER);
        undergroundOres.add(OrePlacedFeatures.ORE_ANDESITE_UPPER);
        undergroundOres.add(OrePlacedFeatures.ORE_ANDESITE_LOWER);
        undergroundOres.add(OrePlacedFeatures.ORE_TUFF);
        undergroundOres.add(OrePlacedFeatures.ORE_COAL_UPPER);
        vegetation.add(UndergroundPlacedFeatures.GLOW_LICHEN);

        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);

        vegetation = vegetation.stream().sorted(Comparator.comparing(a -> a.getValue().toString())).toList();
        for (RegistryKey<PlacedFeature> feature: vegetation) {
            generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, feature);
        }
        for (RegistryKey<PlacedFeature> feature: undergroundOres.stream().sorted(Comparator.comparing(a -> a.getValue().toString())).toList()) {
            generationSettings.feature(GenerationStep.Feature.UNDERGROUND_ORES, feature);
        }

        Biome biome = (new Biome.Builder())
                .precipitation(precipitation)
                .temperature(temperature)
                .downfall(0.5F)
                .effects((new BiomeEffects.Builder())
                        .skyColor(biomeColors.skyColor)
                        .fogColor(biomeColors.fogColor)
                        .waterColor(biomeColors.waterColor)
                        .waterFogColor(biomeColors.waterFogColor)
                        .grassColor(biomeColors.grassColor)
                        .foliageColor(biomeColors.foliageColor)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
        vegetation = new ArrayList<>();
        undergroundOres = new ArrayList<>();
        return biome;
    }
}
