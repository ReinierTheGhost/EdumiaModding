package com.legends.edumia.datageneration.edumia;

import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.datageneration.me.content.loot_tables.BlockDrops;
import com.legends.edumia.datageneration.me.content.loot_tables.LeavesDrops;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;

public class ModBlockLootTables extends FabricBlockLootTableProvider {

    public ModBlockLootTables(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        addDrop(BlockLoader.BROWN_SANDSTONE_SLATES);

        addDrop(BlockLoader.REEDS);
        addDrop(BlockLoader.DRIED_REEDS);
        addDrop(BlockLoader.PAPYRUS);

        addDrop(BlockLoader.SAND_LAYER);
        addDrop(BlockLoader.RED_SAND_LAYER);
        addDrop(BlockLoader.WHITE_SAND);
        addDrop(BlockLoader.WHITE_SAND_LAYER);

        addDrop(BlockLoader.GREEN_BASALT_BALUSTRADE);
        addDrop(BlockLoader.GREEN_BASALT_ARROWSLIT);
        addDrop(BlockLoader.GREEN_BASALT_SMALL_ARCH);
        addDrop(BlockLoader.GREEN_BASALT_TWO_METER_ARCH);


        addDrop(BlockLoader.CHISELED_HIGH_ELVEN_BRICKS);


        addDrop(BlockLoader.CHISELED_LIGHT_HIGH_ELVEN_BRICKS);

        addDrop(BlockLoader.CHISELED_DARK_HIGH_ELVEN_BRICKS);

        addDrop(BlockLoader.CARVED_BROWN_SANDSTONE_BRICKS);


        addDrop(BlockLoader.CARVED_CACHOLONG_BRICKS);


        addDrop(BlockLoader.CARVED_BLACK_DEMON_BRICKS);

        addDrop(BlockLoader.CARVED_BLUE_BRICKS);


        addDrop(BlockLoader.CARVED_DEMON_BASALT_BRICKS);

        addDrop(BlockLoader.CARVED_VOLCANIC_DEMON_BRICKS);

        addDrop(BlockLoader.CARVED_RED_GENSAI_BRICKS);

//
//        addDrop(BlockLoader.BROWN_SANDSTONE_SLATES);



        addDrop(BlockLoader.BRICK_PILLAR);
        addDrop(BlockLoader.STONE_PILLAR);
        addDrop(BlockLoader.SANDSTONE_PILLAR);
//
//
//        //grass
//        addDrop(BlockLoader.ARID_GRASS);
//        addDrop(BlockLoader.BLACK_GRASS);
//        addDrop(BlockLoader.FLAX_GRASS);
//
//
//        //flowers
        addDrop(BlockLoader.ASPHODEL);
        addDrop(BlockLoader.BLUE_DELPHINIUM);
        addDrop(BlockLoader.BLUEBELL);
        addDrop(BlockLoader.CALLA_LILY);
        addDrop(BlockLoader.CELSEMIUM);
        addDrop(BlockLoader.CHRYS_BLUE);
        addDrop(BlockLoader.CHRYS_ORANGE);
        addDrop(BlockLoader.CHRYS_PINK);
        addDrop(BlockLoader.CHRYS_WHITE);
        addDrop(BlockLoader.CHRYS_YELLOW);
        addDrop(BlockLoader.CROCUS);
        addDrop(BlockLoader.DAISY);
        addDrop(BlockLoader.DELPHINIUM);
        addDrop(BlockLoader.FLAX_FLOWERS);
        addDrop(BlockLoader.FOXGLOVE_ORANGE);
        addDrop(BlockLoader.FOXGLOVE_PINK);
        addDrop(BlockLoader.FOXGLOVE_RED);
        addDrop(BlockLoader.FOXGLOVE_WHITE);
        addDrop(BlockLoader.GERBERA_RED);
        addDrop(BlockLoader.GERBERA_YELLOW);
        addDrop(BlockLoader.HEATHER_BUSH);
        addDrop(BlockLoader.LAVENDER);
        addDrop(BlockLoader.MARIGOLD);
        addDrop(BlockLoader.PINK_ANEMONE);
        addDrop(BlockLoader.SIMBLELMYNE);
        addDrop(BlockLoader.TUBEROSE);

        addDrop(BlockLoader.CRACKED_GREEN_BASALT);
        addDrop(BlockLoader.CRACKED_GREEN_BASALT_SLAB);
        addDrop(BlockLoader.CRACKED_GREEN_BASALT_STAIRS);
        addDrop(BlockLoader.CRACKED_GREEN_BASALT_WALL);

        addDrop(BlockLoader.CHISELED_BASALT);;

        addDrop(BlockLoader.HIGH_ELVEN_BRICK_TILING);
        addDrop(BlockLoader.HIGH_ELVEN_BRICK_TILING_STAIRS);
        addDrop(BlockLoader.HIGH_ELVEN_BRICK_TILING_SLAB);

        addDrop(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING);
        addDrop(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_STAIRS);
        addDrop(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_SLAB);

        addDrop(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING);
        addDrop(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_STAIRS);
        addDrop(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_SLAB);

        for (Block block : BlockDrops.blocks) {
            addDrop(block);
        }
        for (Block block : LeavesDrops.blocks) {
            addDrop(block, BlockLootTableGenerator.dropsWithShears(block));
        }
    }
}
