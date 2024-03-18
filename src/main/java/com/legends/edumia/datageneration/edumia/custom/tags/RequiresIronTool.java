package com.legends.edumia.datageneration.edumia.custom.tags;

import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class RequiresIronTool {
    public static List<Block> blocks = new ArrayList<>() {
        {
            add(BlockLoader.RUBY_ORE);
        }
    };
}
