package com.legends.edumia.datageneration.edumia.custom.models;

import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleCornerBlockModel {

    public record Corner(Block texture, Block corner) {}

    public static List<Corner> blocks = new ArrayList<>() {
        {
            add(new Corner(BlockLoader.CLAY_TILING, BlockLoader.CLAY_TILING_VERTICAL_CORNER));
            add(new Corner(BlockLoader.BLACK_CLAY_TILING, BlockLoader.BLACK_CLAY_TILING_VERTICAL_CORNER));
            add(new Corner(BlockLoader.BLUE_CLAY_TILING, BlockLoader.BLUE_CLAY_TILING_VERTICAL_CORNER));
            add(new Corner(BlockLoader.BROWN_CLAY_TILING, BlockLoader.BROWN_CLAY_TILING_VERTICAL_CORNER));
            add(new Corner(BlockLoader.CYAN_CLAY_TILING, BlockLoader.CYAN_CLAY_TILING_VERTICAL_CORNER));
            add(new Corner(BlockLoader.GRAY_CLAY_TILING, BlockLoader.GRAY_CLAY_TILING_VERTICAL_CORNER));
            add(new Corner(BlockLoader.GREEN_CLAY_TILING, BlockLoader.GREEN_CLAY_TILING_VERTICAL_CORNER));
            add(new Corner(BlockLoader.LIGHT_BLUE_CLAY_TILING, BlockLoader.LIGHT_BLUE_CLAY_TILING_VERTICAL_CORNER));
            add(new Corner(BlockLoader.LIGHT_GRAY_CLAY_TILING, BlockLoader.LIGHT_GRAY_CLAY_TILING_VERTICAL_CORNER));
            add(new Corner(BlockLoader.LIME_CLAY_TILING, BlockLoader.LIME_CLAY_TILING_VERTICAL_CORNER));
            add(new Corner(BlockLoader.MAGENTA_CLAY_TILING, BlockLoader.MAGENTA_CLAY_TILING_VERTICAL_CORNER));
            add(new Corner(BlockLoader.ORANGE_CLAY_TILING, BlockLoader.ORANGE_CLAY_TILING_VERTICAL_CORNER));
            add(new Corner(BlockLoader.PINK_CLAY_TILING, BlockLoader.PINK_CLAY_TILING_VERTICAL_CORNER));
            add(new Corner(BlockLoader.PURPLE_CLAY_TILING, BlockLoader.PURPLE_CLAY_TILING_VERTICAL_CORNER));
            add(new Corner(BlockLoader.RED_CLAY_TILING, BlockLoader.RED_CLAY_TILING_VERTICAL_CORNER));
            add(new Corner(BlockLoader.WHITE_CLAY_TILING, BlockLoader.WHITE_CLAY_TILING_VERTICAL_CORNER));
            add(new Corner(BlockLoader.YELLOW_CLAY_TILING, BlockLoader.YELLOW_CLAY_TILING_VERTICAL_CORNER));
        }
    };
}
