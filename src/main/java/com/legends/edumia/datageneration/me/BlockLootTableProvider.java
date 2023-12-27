package com.legends.edumia.datageneration.me;

import com.legends.edumia.core.BlockLoader;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import com.legends.edumia.datageneration.me.content.loot_tables.BlockDrops;
import com.legends.edumia.datageneration.me.content.loot_tables.LeavesDrops;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;

public class BlockLootTableProvider extends FabricBlockLootTableProvider {

    protected BlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(BlockLoader.SAND_LAYER);
        addDrop(BlockLoader.RED_SAND_LAYER);
        addDrop(BlockLoader.WHITE_SAND);
        addDrop(BlockLoader.WHITE_SAND_LAYER);

        for (Block block : BlockDrops.blocks) {
            addDrop(block);
        }
        for (Block block : LeavesDrops.blocks) {
            addDrop(block, BlockLootTableGenerator.dropsWithShears(block));
        }
    }
}
