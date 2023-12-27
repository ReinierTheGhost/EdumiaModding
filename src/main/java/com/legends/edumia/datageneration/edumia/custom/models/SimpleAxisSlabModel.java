package com.legends.edumia.datageneration.edumia.custom.models;

import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleAxisSlabModel {
    public record Slab(Block block, Block slab) {}

    public static List<Slab> blocks = new ArrayList<>() {
        {
            add(new Slab(BlockLoader.CLAY_TILING, BlockLoader.CLAY_TILING_SLAB));
            add(new Slab(BlockLoader.BLACK_CLAY_TILING, BlockLoader.BLACK_CLAY_TILING_SLAB));
            add(new Slab(BlockLoader.BLUE_CLAY_TILING, BlockLoader.BLUE_CLAY_TILING_SLAB));
            add(new Slab(BlockLoader.BROWN_CLAY_TILING, BlockLoader.BROWN_CLAY_TILING_SLAB));
            add(new Slab(BlockLoader.CYAN_CLAY_TILING, BlockLoader.CYAN_CLAY_TILING_SLAB));
            add(new Slab(BlockLoader.GRAY_CLAY_TILING, BlockLoader.GRAY_CLAY_TILING_SLAB));
            add(new Slab(BlockLoader.GREEN_CLAY_TILING, BlockLoader.GREEN_CLAY_TILING_SLAB));
            add(new Slab(BlockLoader.LIGHT_BLUE_CLAY_TILING, BlockLoader.LIGHT_BLUE_CLAY_TILING_SLAB));
            add(new Slab(BlockLoader.LIGHT_GRAY_CLAY_TILING, BlockLoader.LIGHT_GRAY_CLAY_TILING_SLAB));
            add(new Slab(BlockLoader.LIME_CLAY_TILING, BlockLoader.LIME_CLAY_TILING_SLAB));
            add(new Slab(BlockLoader.MAGENTA_CLAY_TILING, BlockLoader.MAGENTA_CLAY_TILING_SLAB));
            add(new Slab(BlockLoader.ORANGE_CLAY_TILING, BlockLoader.ORANGE_CLAY_TILING_SLAB));
            add(new Slab(BlockLoader.PINK_CLAY_TILING, BlockLoader.PINK_CLAY_TILING_SLAB));
            add(new Slab(BlockLoader.PURPLE_CLAY_TILING, BlockLoader.PURPLE_CLAY_TILING_SLAB));
            add(new Slab(BlockLoader.RED_CLAY_TILING, BlockLoader.RED_CLAY_TILING_SLAB));
            add(new Slab(BlockLoader.WHITE_CLAY_TILING, BlockLoader.WHITE_CLAY_TILING_SLAB));
            add(new Slab(BlockLoader.YELLOW_CLAY_TILING, BlockLoader.YELLOW_CLAY_TILING_SLAB));

            add(new Slab(BlockLoader.BROWN_STONE, BlockLoader.BROWN_STONE_SLAB));
            add(new Slab(BlockLoader.LIGHT_GRAY_STONE, BlockLoader.LIGHT_GRAY_STONE_SLAB));
            add(new Slab(BlockLoader.LIGHT_GRAY_STONE_BRICKS, BlockLoader.LIGHT_GRAY_STONE_BRICKS_SLAB));
            add(new Slab(BlockLoader.BLUE_STONE, BlockLoader.BLUE_STONE_SLAB));
            add(new Slab(BlockLoader.BLUE_BRICK, BlockLoader.BLUE_BRICK_SLAB));
            add(new Slab(BlockLoader.YELLOW_STONE, BlockLoader.YELLOW_STONE_SLAB));
            add(new Slab(BlockLoader.YELLOW_STONE_2, BlockLoader.YELLOW_STONE_2_SLAB));
            add(new Slab(BlockLoader.YELLOW_STONE_BRICKS, BlockLoader.YELLOW_STONE_BRICKS_SLAB));
            add(new Slab(BlockLoader.YELLOW_STONE_BRICKS_2, BlockLoader.YELLOW_STONE_BRICKS_2_SLAB));
            add(new Slab(BlockLoader.BASALT_BRICKS, BlockLoader.BASALT_BRICKS_SLAB));
            add(new Slab(BlockLoader.GREEN_BASALT, BlockLoader.GREEN_BASALT_SLAB));
            add(new Slab(BlockLoader.GREEN_BASALT_BRICKS, BlockLoader.GREEN_BASALT_BRICKS_SLAB));
            add(new Slab(BlockLoader.MOSSY_BASALT_BRICKS, BlockLoader.MOSSY_BASALT_BRICKS_SLAB));
            add(new Slab(BlockLoader.CRACKED_GREEN_BASALT, BlockLoader.CRACKED_GREEN_BASALT_SLAB));
            add(new Slab(BlockLoader.GREEN_BASALT_COBBLESTONE, BlockLoader.GREEN_BASALT_COBBLESTONE_SLAB));
            add(new Slab(BlockLoader.GNEISS, BlockLoader.GNEISS_SLAB));
            //add(new Slab(BlockLoader.LIMESTONE_SLAB));
            add(new Slab(BlockLoader.CYAN_STONE, BlockLoader.CYAN_STONE_SLAB));
            add(new Slab(BlockLoader.ORANGE_ROCK, BlockLoader.ORANGE_ROCK_SLAB));
            add(new Slab(BlockLoader.RED_ROCK, BlockLoader.RED_ROCK_SLAB));
            add(new Slab(BlockLoader.YELLOW_COBBLE, BlockLoader.YELLOW_COBBLE_SLAB));
            add(new Slab(BlockLoader.CHALK, BlockLoader.CHALK_SLAB));
            add(new Slab(BlockLoader.CHALK_BRICKS, BlockLoader.CHALK_BRICKS_SLAB));
            add(new Slab(BlockLoader.HIGH_ELVEN_ROCK, BlockLoader.HIGH_ELVEN_ROCK_SLAB));
            add(new Slab(BlockLoader.DARK_HIGH_ELVEN_ROCK, BlockLoader.DARK_HIGH_ELVEN_ROCK_SLAB));
            add(new Slab(BlockLoader.LIGHT_HIGH_ELVEN_ROCK, BlockLoader.LIGHT_HIGH_ELVEN_ROCK_SLAB));
            add(new Slab(BlockLoader.HIGH_ELVEN_BRICKS, BlockLoader.HIGH_ELVEN_BRICKS_SLAB));
            add(new Slab(BlockLoader.DARK_HIGH_ELVEN_BRICKS, BlockLoader.DARK_HIGH_ELVEN_BRICKS_SLAB));
            add(new Slab(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS, BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_SLAB));
            add(new Slab(BlockLoader.SMALL_HIGH_ELVEN_BRICKS, BlockLoader.SMALL_HIGH_ELVEN_BRICKS_SLAB));
            add(new Slab(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS, BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_SLAB));
            add(new Slab(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS, BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_SLAB));
            add(new Slab(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS, BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_SLAB));
            add(new Slab(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS, BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_SLAB));
            add(new Slab(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS, BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_SLAB));
            add(new Slab(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS, BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_SLAB));
            add(new Slab(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS, BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_SLAB));
            add(new Slab(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS, BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_SLAB));
            add(new Slab(BlockLoader.BROWN_SANDSTONE_BRICKS, BlockLoader.BROWN_SANDSTONE_BRICKS_SLAB));
            add(new Slab(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS, BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_SLAB));
            add(new Slab(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS, BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_SLAB));
            add(new Slab(BlockLoader.CACHOLONG_BRICKS, BlockLoader.CACHOLONG_BRICKS_SLAB));
            add(new Slab(BlockLoader.CRACKED_CACHOLONG_BRICKS, BlockLoader.CRACKED_CACHOLONG_BRICKS_SLAB));
            add(new Slab(BlockLoader.MOSSY_CACHOLONG_BRICKS, BlockLoader.MOSSY_CACHOLONG_BRICKS_SLAB));
            add(new Slab(BlockLoader.BLACK_DEMON_BRICKS, BlockLoader.BLACK_DEMON_BRICKS_SLAB));
            add(new Slab(BlockLoader.CRACKED_BLACK_DEMON_BRICKS, BlockLoader.CRACKED_BLACK_DEMON_BRICKS_SLAB));
            add(new Slab(BlockLoader.MOSSY_BLACK_DEMON_BRICKS, BlockLoader.MOSSY_BLACK_DEMON_BRICKS_SLAB));
            add(new Slab(BlockLoader.BLUE_BRICKS, BlockLoader.BLUE_BRICKS_SLAB));
            add(new Slab(BlockLoader.CRACKED_BLUE_BRICKS, BlockLoader.CRACKED_BLUE_BRICKS_SLAB));
            add(new Slab(BlockLoader.MOSSY_BLUE_BRICKS, BlockLoader.MOSSY_BLUE_BRICKS_SLAB));
            add(new Slab(BlockLoader.DEMON_BASALT_BRICKS, BlockLoader.DEMON_BASALT_BRICKS_SLAB));
            add(new Slab(BlockLoader.VULCANIC_DEMON_BRICKS, BlockLoader.VULCANIC_DEMON_BRICKS_SLAB));
            add(new Slab(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS, BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_SLAB));
            add(new Slab(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS, BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_SLAB));
            add(new Slab(BlockLoader.RED_BRICKS, BlockLoader.RED_BRICKS_SLAB));
            add(new Slab(BlockLoader.CRACKED_RED_BRICKS, BlockLoader.CRACKED_RED_BRICKS_SLAB));
            add(new Slab(BlockLoader.MOSSY_RED_BRICKS, BlockLoader.MOSSY_RED_BRICKS_SLAB));
            add(new Slab(BlockLoader.DESERT_MUD_BRICKS, BlockLoader.DESERT_MUD_BRICKS_SLAB));
            add(new Slab(BlockLoader.CRACKED_DESERT_MUD_BRICKS, BlockLoader.CRACKED_DESERT_MUD_BRICKS_SLAB));
            add(new Slab(BlockLoader.MOSSY_DESERT_MUD_BRICKS, BlockLoader.MOSSY_DESERT_MUD_BRICKS_SLAB));
            add(new Slab(BlockLoader.HIGH_ELVEN_BRICK_TILING, BlockLoader.HIGH_ELVEN_BRICK_TILING_SLAB));
            add(new Slab(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING, BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_SLAB));
            add(new Slab(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING, BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_SLAB));

            add(new Slab(BlockLoader.HIGH_ELVEN_COBBLESTONE, BlockLoader.HIGH_ELVEN_COBBLESTONE_SLAB));
            add(new Slab(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE, BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_SLAB));
            add(new Slab(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE, BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB));

            add(new Slab(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE, BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_SLAB));
            add(new Slab(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE, BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_SLAB));
            add(new Slab(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE, BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB));

            add(new Slab(BlockLoader.VULCANIC_ROCK, BlockLoader.VULCANIC_ROCK_SLAB));
        }
    };
}
