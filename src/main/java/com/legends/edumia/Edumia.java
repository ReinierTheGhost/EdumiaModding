package com.legends.edumia;

import com.legends.edumia.block.blocksets.BuildingSets;
import com.legends.edumia.block.blocksets.OreRockSets;
import com.legends.edumia.block.blocksets.StoneSets;
import com.legends.edumia.block.blocksets.WoodBlockSets;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.core.CreativeTabLoader;
import com.legends.edumia.core.ItemLoader;
import net.fabricmc.api.ModInitializer;
import com.legends.edumia.entity.ModEntities;
import com.legends.edumia.statusEffects.ModStatusEffects;
import com.legends.edumia.recipe.ModRecipes;
import com.legends.edumia.sound.ModSounds;
import com.legends.edumia.world.spawners.ModEntitySpawning;
import com.legends.edumia.world.biomes.EdumiaBiomeKeys;
import com.legends.edumia.world.biomes.EdumiaBiomesData;
import com.legends.edumia.world.chunkgen.map.MapImageLoader;
import com.legends.edumia.world.dimension.ModDimensions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;

public class Edumia implements ModInitializer {

    public static final String MOD_ID = "edumia";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final int MAP_ITERATION = 3;
    @Override
    public void onInitialize() {
        ModStatusEffects.registerStatusEffects();



        ItemLoader.registerModItems();
        BlockLoader.registerModBlocks();
        CreativeTabLoader.register();

        WoodBlockSets.registerModBlockSets();
        OreRockSets.registerModBlockSets();
        BuildingSets.registerModBlockSets();
        StoneSets.registerModBlockSets();

        ModRecipes.registerRecipes();

        ModEntities.registerModEntities();
        ModEntitySpawning.addSpawns();

        ModSounds.registerModSounds();

        ModDimensions.register();
        EdumiaBiomeKeys.registerModBiomes();
        EdumiaBiomesData.loadBiomes();

        try {
            MapImageLoader.loadImage(getClass().getClassLoader());
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}