package com.legends.edumia.world.map;

import com.legends.edumia.Edumia;

public class EdumiaMapConfigs {
    public static final String BIOME_PATH = "data/edumia/%s/biomes/i_%s".formatted(Edumia.MOD_VERSION, "%s");
    public static final String HEIGHT_PATH = "data/edumia/%s/heights".formatted(Edumia.MOD_VERSION);
    public static final String IMAGE_NAME = "/%s_%s.png";
    public static final String INITIAL_IMAGE = "assets/%s/textures/edumia_biome_map_3000.png".formatted(Edumia.MOD_ID);
    public static final String INITIAL_HEIGHT_IMAGE = "assets/%s/textures/edumia_height_map_3000.png".formatted(Edumia.MOD_ID);;

    /**
     *  Current image is 3000 x 3000, should be a common divider;
     */
    public static final int REGION_SIZE = 3000;
    public static final int PIXEL_WEIGHT = 4;
    public static final int THREAD_POOL_SIZE = 8;
    public static final boolean FORCE_GENERATION = false;
    /**
     * Map Iteration Explanation :
     * 1 : 6000 (24,000);
     * 2 : 12 000 (48,000);
     * 3 : 24 000 (96,000);
     * 4 : 48 000 (192,000);
     * 5 : 96 000 (384,000);
     * 6 : 192 000 (768,000);
     * 7 : 384 000 (1,536,000);
     */
    public static final int MAP_ITERATION = 3;
    public static final int BIOME_VALIDATION_TICK_DELAY = 1000;
    public static final int BIOME_VALIDATION_BLOCK_DELAY = 5000;
    public final static int BIOME_VALIDATION_DIST_CHECK = 2000;
}
