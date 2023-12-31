package com.legends.edumia.datageneration.edumia.custom.models;

import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class SimpleLayerModel {

    public record Layer(Block texture, Block layer) {}

    public static List<Layer> blocks = new ArrayList<>() {
        {
            add(new Layer(BlockLoader.WHITE_SAND, BlockLoader.WHITE_SAND_LAYER));
            add(new Layer(Blocks.SAND, BlockLoader.SAND_LAYER));
            add(new Layer(Blocks.RED_SAND, BlockLoader.RED_SAND_LAYER));
        }
    };
}