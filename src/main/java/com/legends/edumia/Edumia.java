package com.legends.edumia;

import com.legends.edumia.block.ModNatureBlocks;
import com.legends.edumia.block.WoodBlocks;
import com.legends.edumia.block.blocksets.*;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.core.CreativeTabLoader;
import com.legends.edumia.core.ItemLoader;
import com.legends.edumia.mixin.FoliagePlacerTypeInvoker;
import com.legends.edumia.world.worldgen.trees.EdumiaFoliagePlacerTypes;
import com.legends.edumia.world.worldgen.trees.EdumiaTreeDecoratorTypes;
import com.legends.edumia.world.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.legends.edumia.world.worldgen.trees.foliageplacer.GhostGumFoliagePlacer;
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
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.Registry;
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
        WoodBlocks.registerModBlocks();
        ModNatureBlocks.registerModBlocks();
        OreRockSets.registerModBlockSets();
        BuildingSets.registerModBlockSets();
        StoneSets.registerModBlockSets();
        ClayTilingSets.registerModBlockSets();
        NotBrickBuildingSets.registerModBlockSets();


        ModRecipes.registerRecipes();

        ModEntities.registerModEntities();
        ModEntitySpawning.addSpawns();

        ModSounds.registerModSounds();

        EdumiaFoliagePlacerTypes.register();
        EdumiaTrunkPlacerTypes.register();
        EdumiaTreeDecoratorTypes.register();

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