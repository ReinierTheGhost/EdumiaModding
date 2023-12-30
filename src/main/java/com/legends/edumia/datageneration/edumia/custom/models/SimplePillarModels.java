package com.legends.edumia.datageneration.edumia.custom.models;

import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimplePillarModels {
    public record Pillar(Block pillar) {}

    public static List<Pillar> blocks = new ArrayList<>() {
        {
            add(new Pillar(BlockLoader.BRICK_PILLAR));
            add(new Pillar(BlockLoader.STONE_PILLAR));
            add(new Pillar(BlockLoader.SANDSTONE_PILLAR));
        }
    };
}
