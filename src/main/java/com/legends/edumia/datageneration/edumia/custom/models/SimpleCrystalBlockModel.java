package com.legends.edumia.datageneration.edumia.custom.models;

import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleCrystalBlockModel {

    public record Crystals(Block crystal) {}

    public static List<Crystals> blocks = new ArrayList<>() {
        {
            add(new Crystals(BlockLoader.HIGH_ELVEN_CRYSTAL));
        }
    };
}
