package com.legends.edumia.datageneration.edumia.custom.models;

import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class SimpleReedsModel {
    public record Reed(Block reed) {}

    public static List<Reed> blocks = new ArrayList<>() {
        {
            add(new Reed(BlockLoader.REEDS));
            add(new Reed(BlockLoader.PAPYRUS));
            add(new Reed(BlockLoader.DRIED_REEDS));
        }
    };
}
