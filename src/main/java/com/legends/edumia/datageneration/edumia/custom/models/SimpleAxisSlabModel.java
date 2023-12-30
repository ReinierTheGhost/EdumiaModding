package com.legends.edumia.datageneration.edumia.custom.models;

import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleAxisSlabModel {
    public record Slab(Block block, Block slab) {}

    public static List<Slab> blocks = new ArrayList<>() {
        {
            add(new Slab(BlockLoader.BLUE_BRICK, BlockLoader.BLUE_BRICK_SLAB));
            add(new Slab(BlockLoader.CRACKED_GREEN_BASALT, BlockLoader.CRACKED_GREEN_BASALT_SLAB));
            add(new Slab(BlockLoader.HIGH_ELVEN_BRICK_TILING, BlockLoader.HIGH_ELVEN_BRICK_TILING_SLAB));
            add(new Slab(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING, BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_SLAB));
            add(new Slab(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING, BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_SLAB));

        }
    };
}
