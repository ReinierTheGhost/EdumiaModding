package com.legends.edumia.datageneration.edumia.custom.models;

import com.legends.edumia.core.BlockLoader;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleSaplingModel {
    public static List<Block> blocks = new ArrayList<>() {
        {
            add(BlockLoader.APPLE_SAPLING);
            add(BlockLoader.TEST_SAPLING);
            add(BlockLoader.ASPEN_SAPLING);
            add(BlockLoader.BEECH_SAPLING);
            add(BlockLoader.BLACKTHORN_SAPLING);
            add(BlockLoader.CEDAR_SAPLING);
            add(BlockLoader.CYPRESS_SAPLING);
            add(BlockLoader.FIR_SAPLING);
            add(BlockLoader.GHOST_GUM_SAPLING);
            add(BlockLoader.GREEN_OAK_SAPLING);
            add(BlockLoader.HOLLY_SAPLING);
            add(BlockLoader.LARCH_SAPLING);
            add(BlockLoader.PINE_SAPLING);
            add(BlockLoader.RED_OAK_SAPLING);
            add(BlockLoader.REDWOOD_SAPLING);
            add(BlockLoader.SILVER_SPRUCE_SAPLING);
            add(BlockLoader.WHITE_ASH_SAPLING);
        }
    };
}
