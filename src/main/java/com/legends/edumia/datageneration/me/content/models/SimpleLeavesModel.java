package com.legends.edumia.datageneration.me.content.models;

import com.legends.edumia.block.ModNatureBlocks;
import com.legends.edumia.block.WoodBlocks;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleLeavesModel {
    public static List<Block> blocks = new ArrayList<>() {
        {
            add(ModNatureBlocks.APPLE_LEAVES_RED);
            add(ModNatureBlocks.APPLE_LEAVES_GREEN);
            add(ModNatureBlocks.PEAR_LEAVES_FRUIT);
            add(ModNatureBlocks.CHERRY_LEAVES_FRUIT);
        }
    };
}
