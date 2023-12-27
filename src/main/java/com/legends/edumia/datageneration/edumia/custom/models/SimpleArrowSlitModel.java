package com.legends.edumia.datageneration.edumia.custom.models;

import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleArrowSlitModel {
    public record ArrowSlit(Block texture, Block arrowSlit) {}

    public static List<ArrowSlit> blocks = new ArrayList<>() {
        {
            add(new ArrowSlit(BlockLoader.GREEN_BASALT, BlockLoader.GREEN_BASALT_ARROWSLIT));
        }
    };
}
