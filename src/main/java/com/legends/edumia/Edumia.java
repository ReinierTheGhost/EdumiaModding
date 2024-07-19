package com.legends.edumia;

import com.legends.edumia.block.ModNatureBlocks;
import com.legends.edumia.block.WoodBlocks;
import com.legends.edumia.block.blocksets.*;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.core.CreativeTabLoader;
import com.legends.edumia.core.ItemLoader;
import com.legends.edumia.utils.ModRegisters;
import com.legends.edumia.world.map.EdumiaMapGeneration;
import com.legends.edumia.world.gen.ModWorldGeneration;
import com.legends.edumia.world.worldgen.EdumiaFeatures;
import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.legends.edumia.world.worldgen.trees.EdumiaTreeDecoratorTypes;
import com.legends.edumia.world.worldgen.trees.EdumiaTrunkPlacerTypes;
import net.fabricmc.api.ModInitializer;
import com.legends.edumia.entity.ModEntities;
import com.legends.edumia.statusEffects.ModStatusEffects;
import com.legends.edumia.recipe.ModRecipes;
import com.legends.edumia.world.spawners.ModEntitySpawning;
import com.legends.edumia.world.biomes.EdumiaBiomeKeys;
import com.legends.edumia.world.biomes.surface.EdumiaBiomesData;
import com.legends.edumia.world.dimension.ModDimensions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Edumia implements ModInitializer {


    public static final String MOD_ID = "edumia";
    public static final String MOD_VERSION = "1.4.0-1.20.1";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final boolean IS_DEBUG = true;
    public static final int MAP_ITERATION = 3;
    @Override
    public void onInitialize() {
        ModStatusEffects.registerStatusEffects();



        ItemLoader.registerModItems();
        BlockLoader.registerModBlocks();
        CreativeTabLoader.register();

        WoodBlockSets.registerModBlockSets();
        WoodBlocks.registerModBlocks();
        ModNatureBlocks.registerModBlocks();
        OreRockSets.registerModBlockSets();
        BuildingSets.registerModBlockSets();
        GlassSets.registerModBlockSets();
        PaperwallSets.registerModBlockSets();
        StoneSets.registerModBlockSets();
        ClayTilingSets.registerModBlockSets();
        NotBrickBuildingSets.registerModBlockSets();


        ModRegisters.registerModStuffs();

        ModRecipes.registerRecipes();

        ModEntities.registerModEntities();
        ModEntitySpawning.addSpawns();

        //ModSounds.registerModSounds();


        EdumiaFoliagePlacerTypes.register();
        EdumiaTrunkPlacerTypes.register();
        EdumiaTreeDecoratorTypes.register();

        ModDimensions.register();
        EdumiaBiomeKeys.registerModBiomes();
        EdumiaBiomesData edumiaBiomesData = new EdumiaBiomesData();
        edumiaBiomesData.loadBiomes();
        ModWorldGeneration.generateModWorldGen();

        try {
            new EdumiaMapGeneration();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}