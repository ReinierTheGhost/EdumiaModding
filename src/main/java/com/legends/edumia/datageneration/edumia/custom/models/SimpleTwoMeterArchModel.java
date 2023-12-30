package com.legends.edumia.datageneration.edumia.custom.models;

import com.legends.edumia.block.blocksets.StoneSets;
import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleTwoMeterArchModel {
    public record Arch(Block texture, Block arch) {}

    public static List<Arch> blocks = new ArrayList<>() {
        {
            add(new Arch(StoneSets.GREEN_BASALT.block(), BlockLoader.GREEN_BASALT_TWO_METER_ARCH));
        }
    };
}
