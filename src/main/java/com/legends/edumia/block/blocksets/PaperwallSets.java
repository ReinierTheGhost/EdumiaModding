package com.legends.edumia.block.blocksets;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.BlockRegisters;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;

public class PaperwallSets {

    public static PaperwallSet BLACK_PAPERWALL = registerGlassSet("black_paperwall",  DyeColor.BLACK);
    public static PaperwallSet BLUE_PAPERWALL = registerGlassSet("blue_paperwall", DyeColor.BLUE);
    public static PaperwallSet BROWN_PAPERWALL = registerGlassSet("brown_paperwall",  DyeColor.BROWN);
    public static PaperwallSet CYAN_PAPERWALL = registerGlassSet("cyan_paperwall",  DyeColor.CYAN);
    public static PaperwallSet GRAY_PAPERWALL = registerGlassSet("gray_paperwall",  DyeColor.GRAY);
    public static PaperwallSet GREEN_PAPERWALL = registerGlassSet("green_paperwall",  DyeColor.GREEN);
    public static PaperwallSet LIGHT_BLUE_PAPERWALL = registerGlassSet("light_blue_paperwall",  DyeColor.LIGHT_BLUE);
    public static PaperwallSet LIGHT_GRAY_PAPERWALL = registerGlassSet("light_gray_paperwall",  DyeColor.LIGHT_GRAY);
    public static PaperwallSet LIME_PAPERWALL = registerGlassSet("lime_paperwall",  DyeColor.LIME);
    public static PaperwallSet MAGENTA_PAPERWALL = registerGlassSet("magenta_paperwall",  DyeColor.MAGENTA);
    public static PaperwallSet ORANGE_PAPERWALL = registerGlassSet("orange_paperwall",  DyeColor.ORANGE);
    public static PaperwallSet PINK_PAPERWALL = registerGlassSet("pink_paperwall",  DyeColor.PINK);
    public static PaperwallSet PURPLE_PAPERWALL = registerGlassSet("purple_paperwall",  DyeColor.PURPLE);
    public static PaperwallSet RED_PAPERWALL = registerGlassSet("red_paperwall",  DyeColor.RED);
    public static PaperwallSet WHITE_PAPERWALL = registerGlassSet("white_paperwall",  DyeColor.WHITE);
    public static PaperwallSet YELLOW_PAPERWALL = registerGlassSet("yellow_paperwall",  DyeColor.YELLOW);

    public static PaperwallSet[] paperwallSets = new PaperwallSet[]{
            BLACK_PAPERWALL,
            BLUE_PAPERWALL,
            BROWN_PAPERWALL,
            CYAN_PAPERWALL,
            GRAY_PAPERWALL,
            GREEN_PAPERWALL,
            LIGHT_BLUE_PAPERWALL,
            LIGHT_GRAY_PAPERWALL,
            LIME_PAPERWALL,
            MAGENTA_PAPERWALL,
            ORANGE_PAPERWALL,
            PINK_PAPERWALL,
            PURPLE_PAPERWALL,
            RED_PAPERWALL,
            WHITE_PAPERWALL,
            YELLOW_PAPERWALL,
    };

    public record PaperwallSet(Block pane){


    }

    public static PaperwallSet registerGlassSet(String name, DyeColor color) {
        

            Block pane = BlockRegisters.registerGlassBlock(name, new StainedGlassPaneBlock(color,
                    AbstractBlock.Settings.create().instrument(Instrument.HAT).strength(0.3f).sounds(BlockSoundGroup.WOOL)
                            .nonOpaque()));
        

        return new PaperwallSet(pane);
    }
    public static void registerModBlockSets() {
        Edumia.LOGGER.debug("Registering BuildingSets for " + Edumia.MOD_ID);
    }
}
