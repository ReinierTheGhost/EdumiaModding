package com.legends.edumia.datageneration.edumia.custom.models;

import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleSaplingModel {
    public record Sapling(Block sapling) {}

    public static List<Block> blocks = new ArrayList<>() {
        {
            add(BlockLoader.APPLE_SAPLING);
            add(BlockLoader.ASPEN_SAPLING);
            add(BlockLoader.GHOST_GUM_SAPLING);
        }
    };
}
