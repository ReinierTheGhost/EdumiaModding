package com.legends.edumia.block.blocksets;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.AxialSlabBlock;
import com.legends.edumia.block.BlockRegisters;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;

public class GlassSets {
    public static GlassSet FINE_GLASS = registerGlassSet("fine_glass", false, null);
    public static GlassSet BLACK_FINE_GLASS = registerGlassSet("black_fine_glass", true, DyeColor.BLACK);
    public static GlassSet BLUE_FINE_GLASS = registerGlassSet("blue_fine_glass", true, DyeColor.BLUE);
    public static GlassSet BROWN_FINE_GLASS = registerGlassSet("brown_fine_glass", true, DyeColor.BROWN);
    public static GlassSet CYAN_FINE_GLASS = registerGlassSet("cyan_fine_glass", true, DyeColor.CYAN);
    public static GlassSet GRAY_FINE_GLASS = registerGlassSet("gray_fine_glass", true, DyeColor.GRAY);
    public static GlassSet GREEN_FINE_GLASS = registerGlassSet("green_fine_glass", true, DyeColor.GREEN);
    public static GlassSet LIGHT_BLUE_FINE_GLASS = registerGlassSet("light_blue_fine_glass", true, DyeColor.LIGHT_BLUE);
    public static GlassSet LIGHT_GRAY_FINE_GLASS = registerGlassSet("light_gray_fine_glass", true, DyeColor.LIGHT_GRAY);
    public static GlassSet LIME_FINE_GLASS = registerGlassSet("lime_fine_glass", true, DyeColor.LIME);
    public static GlassSet MAGENTA_FINE_GLASS = registerGlassSet("magenta_fine_glass", true, DyeColor.MAGENTA);
    public static GlassSet ORANGE_FINE_GLASS = registerGlassSet("orange_fine_glass", true, DyeColor.ORANGE);
    public static GlassSet PINK_FINE_GLASS = registerGlassSet("pink_fine_glass", true, DyeColor.PINK);
    public static GlassSet PURPLE_FINE_GLASS = registerGlassSet("purple_fine_glass", true, DyeColor.PURPLE);
    public static GlassSet RED_FINE_GLASS = registerGlassSet("red_fine_glass", true, DyeColor.RED);
    public static GlassSet WHITE_FINE_GLASS = registerGlassSet("white_fine_glass", true, DyeColor.WHITE);
    public static GlassSet YELLOW_FINE_GLASS = registerGlassSet("yellow_fine_glass", true, DyeColor.YELLOW);



    public static GlassSet[] glassSets = new GlassSet[]{
            FINE_GLASS,
            BLACK_FINE_GLASS,
            BLUE_FINE_GLASS,
            BROWN_FINE_GLASS,
            CYAN_FINE_GLASS,
            GRAY_FINE_GLASS,
            GREEN_FINE_GLASS,
            LIGHT_BLUE_FINE_GLASS,
            LIGHT_GRAY_FINE_GLASS,
            LIME_FINE_GLASS,
            MAGENTA_FINE_GLASS,
            ORANGE_FINE_GLASS,
            PINK_FINE_GLASS,
            PURPLE_FINE_GLASS,
            RED_FINE_GLASS,
            WHITE_FINE_GLASS,
            YELLOW_FINE_GLASS,

    };

    public record GlassSet(Block block, Block pane){


    }

    public static GlassSet registerGlassSet(String name, boolean stained, DyeColor color) {
        Block block = null;
        Block pane = null;
        if (stained) {
            block = BlockRegisters.registerGlassBlock(name, new StainedGlassBlock(color,
                    AbstractBlock.Settings.create()
                            .instrument(Instrument.HAT).strength(0.3F).sounds(BlockSoundGroup.GLASS).nonOpaque()
                            .allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never)
                            .blockVision(Blocks::never)));

            pane = BlockRegisters.registerGlassBlock(name + "_pane", new StainedGlassPaneBlock(color,
                    AbstractBlock.Settings.create().instrument(Instrument.HAT).strength(0.3f).sounds(BlockSoundGroup.GLASS)
                            .nonOpaque()));
    } else{
            block = BlockRegisters.registerGlassBlock(name, new GlassBlock(AbstractBlock.Settings.create()
                    .instrument(Instrument.HAT).strength(0.3F).sounds(BlockSoundGroup.GLASS)
                    .nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never)
                    .blockVision(Blocks::never)));

            pane = BlockRegisters.registerGlassBlock(name + "_pane", new PaneBlock(
                    AbstractBlock.Settings.create().instrument(Instrument.HAT).strength(0.3f).sounds(BlockSoundGroup.GLASS)
                            .nonOpaque()));
        }

        return new GlassSet(block, pane);
    }
    public static void registerModBlockSets() {
        Edumia.LOGGER.debug("Registering BuildingSets for " + Edumia.MOD_ID);
    }
}
