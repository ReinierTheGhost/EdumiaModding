package com.legends.edumia.datageneration.me.content.models;

import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleBlockModel {
    public static List<Block> blocks = new ArrayList<>() {
        {
            add(BlockLoader.RUBY_ORE);

        }
    };
}
