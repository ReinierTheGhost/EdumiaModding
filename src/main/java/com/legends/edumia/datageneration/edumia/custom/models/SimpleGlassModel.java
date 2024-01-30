package com.legends.edumia.datageneration.edumia.custom.models;

import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleGlassModel {

    public record Glass(Block block, Block pane) {}

    public static List<Glass> blocks = new ArrayList<>() {
        {

        }
    };
}
