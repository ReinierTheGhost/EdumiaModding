package com.legends.edumia.datageneration.edumia.custom.models;

import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleFallenLeavesBlockModel {

    public record FallenLeaves(Block texture, Block leaves){}

    public static List<FallenLeaves> blocks = new ArrayList<>(){
        {

        }
    };
}
