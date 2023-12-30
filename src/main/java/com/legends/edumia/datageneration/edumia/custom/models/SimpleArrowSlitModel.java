package com.legends.edumia.datageneration.edumia.custom.models;

import com.legends.edumia.block.blocksets.StoneSets;
import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleArrowSlitModel {
    public record ArrowSlit(Block texture, Block arrowSlit) {}

    public static List<ArrowSlit> blocks = new ArrayList<>() {
        {
            add(new ArrowSlit(StoneSets.GREEN_BASALT.block(), BlockLoader.GREEN_BASALT_ARROWSLIT));
        }
    };
}
