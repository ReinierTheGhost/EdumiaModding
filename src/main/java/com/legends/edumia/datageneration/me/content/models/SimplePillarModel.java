package com.legends.edumia.datageneration.me.content.models;

import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimplePillarModel {
    public record Pillar(Block base) {}

    public static List<Pillar> blocks = new ArrayList<>() {
        {

        }
    };
}
