package com.legends.edumia.datageneration.edumia.custom.models;

import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleWoodBlockModel {
    public record WoodBlocks(Block texture, Block wood){}

    public static List<WoodBlocks> blocks = new ArrayList<>(){
        {

        }
    };
}
