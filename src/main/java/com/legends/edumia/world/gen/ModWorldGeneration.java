package com.legends.edumia.world.gen;

import com.legends.edumia.world.biomes.caves.ModCaveBiomes;
import com.legends.edumia.world.worldgen.EdumiaFeatures;

public class ModWorldGeneration {

    public static void generateModWorldGen() {
        ModCaveBiomes.init();
        EdumiaFeatures.init();
    }

}
