package com.legends.edumia.datageneration.edumia.custom.models;

import com.legends.edumia.block.blocksets.StoneSets;
import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleBalustradeModels {
    public record Balustrade(Block texture, Block balustrade) {}

    public static List<Balustrade> blocks = new ArrayList<>() {
        {
        }
    };
}
