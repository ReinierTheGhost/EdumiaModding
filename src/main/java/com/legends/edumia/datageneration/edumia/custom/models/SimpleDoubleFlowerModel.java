package com.legends.edumia.datageneration.edumia.custom.models;

import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleDoubleFlowerModel {

    public record Flower(Block flower) {}

    public static List<Block> blocks = new ArrayList<>() {
        {
            add(BlockLoader.YELLOW_IRIS);
            add(BlockLoader.FLAME_OF_THE_SOUTH);
            add(BlockLoader.HIBISCUS);

        }
    };
}
