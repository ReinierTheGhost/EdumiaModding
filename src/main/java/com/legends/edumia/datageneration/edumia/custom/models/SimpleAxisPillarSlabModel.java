package com.legends.edumia.datageneration.edumia.custom.models;

import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleAxisPillarSlabModel {

    public record Slab(Block block, Block slab) {}

    public static List<Slab> blocks = new ArrayList<>() {
        {


        }
    };
}
