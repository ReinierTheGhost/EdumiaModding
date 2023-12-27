package com.legends.edumia.datageneration.edumia.custom.models;

import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleTwoMeterArchModel {
    public record Arch(Block texture, Block arch) {}

    public static List<Arch> blocks = new ArrayList<>() {
        {
            add(new Arch(BlockLoader.GREEN_BASALT, BlockLoader.GREEN_BASALT_TWO_METER_ARCH));
        }
    };
}
