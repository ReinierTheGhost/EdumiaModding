package com.legends.edumia.datageneration.edumia.custom.models;

import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleCornerBlockModel {

    public record Corner(Block texture, Block corner) {}

    public static List<Corner> blocks = new ArrayList<>() {
        {

        }
    };
}
