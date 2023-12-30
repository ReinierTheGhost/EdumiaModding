package com.legends.edumia.block.blocksets;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.AxialSlabBlock;
import com.legends.edumia.block.BlockRegisters;
import com.legends.edumia.block.VerticalCorner;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.sound.BlockSoundGroup;

public class ClayTilingSets {
    public static final float CLAY_STRENGTH = 1.25f;
    public static final float CLAY_RESISTANCE = 4.2f;
    public static ClayTilingSet CLAY_TILING = registerClaySet("", CLAY_STRENGTH, CLAY_RESISTANCE);
    public static ClayTilingSet BLACK_CLAY_TILING = registerClaySet("black_", CLAY_STRENGTH, CLAY_RESISTANCE);
    public static ClayTilingSet BLUE_CLAY_TILING = registerClaySet("blue_", CLAY_STRENGTH, CLAY_RESISTANCE);
    public static ClayTilingSet BROWN_CLAY_TILING = registerClaySet("brown_", CLAY_STRENGTH, CLAY_RESISTANCE);
    public static ClayTilingSet CYAN_CLAY_TILING = registerClaySet("cyan_", CLAY_STRENGTH, CLAY_RESISTANCE);
    public static ClayTilingSet GRAY_CLAY_TILING = registerClaySet("gray_", CLAY_STRENGTH, CLAY_RESISTANCE);
    public static ClayTilingSet GREEN_CLAY_TILING = registerClaySet("green_", CLAY_STRENGTH, CLAY_RESISTANCE);
    public static ClayTilingSet LIGHT_BLUE_CLAY_TILING = registerClaySet("light_blue_", CLAY_STRENGTH, CLAY_RESISTANCE);
    public static ClayTilingSet LIGHT_GRAY_CLAY_TILING = registerClaySet("light_gray_", CLAY_STRENGTH, CLAY_RESISTANCE);
    public static ClayTilingSet LIME_CLAY_TILING = registerClaySet("lime_", CLAY_STRENGTH, CLAY_RESISTANCE);
    public static ClayTilingSet MAGENTA_CLAY_TILING = registerClaySet("magenta_", CLAY_STRENGTH, CLAY_RESISTANCE);
    public static ClayTilingSet ORANGE_CLAY_TILING = registerClaySet("orange_", CLAY_STRENGTH, CLAY_RESISTANCE);
    public static ClayTilingSet PINK_CLAY_TILING = registerClaySet("pink_", CLAY_STRENGTH, CLAY_RESISTANCE);
    public static ClayTilingSet PURPLE_CLAY_TILING = registerClaySet("purple_", CLAY_STRENGTH, CLAY_RESISTANCE);
    public static ClayTilingSet RED_CLAY_TILING = registerClaySet("red_", CLAY_STRENGTH, CLAY_RESISTANCE);
    public static ClayTilingSet WHITE_CLAY_TILING = registerClaySet("white_", CLAY_STRENGTH, CLAY_RESISTANCE);
    public static ClayTilingSet YELLOW_CLAY_TILING = registerClaySet("yellow_", CLAY_STRENGTH, CLAY_RESISTANCE);




    public static ClayTilingSet[] sets = new ClayTilingSet[] {
            CLAY_TILING,
            BLACK_CLAY_TILING,
            BLUE_CLAY_TILING,
            BROWN_CLAY_TILING,
            CYAN_CLAY_TILING,
            GRAY_CLAY_TILING,
            GREEN_CLAY_TILING,
            LIGHT_BLUE_CLAY_TILING,
            LIGHT_GRAY_CLAY_TILING,
            LIME_CLAY_TILING,
            MAGENTA_CLAY_TILING,
            ORANGE_CLAY_TILING,
            PINK_CLAY_TILING,
            PURPLE_CLAY_TILING,
            RED_CLAY_TILING,
            WHITE_CLAY_TILING,
            YELLOW_CLAY_TILING
    };

    public record ClayTilingSet(Block block, Block slab, Block stairs, Block corner) {
    }

    public static ClayTilingSet registerClaySet(String name, float strength, float resistance) {

        Block block = BlockRegisters.registerbuildingBlock(name + "clay_tiling", new Block(AbstractBlock.Settings.copy(Blocks.STONE)
                .strength(strength, resistance).sounds(BlockSoundGroup.STONE).requiresTool()));


        Block slab = BlockRegisters.registerbuildingBlock(name + "clay_tiling_slab", new AxialSlabBlock(block));

        Block stairs = BlockRegisters.registerbuildingBlock(name + "clay_tiling_stairs", new StairsBlock(block.getDefaultState(),
                FabricBlockSettings.copyOf(block).strength(strength, resistance).sounds(BlockSoundGroup.STONE).requiresTool()));

        Block corner = BlockRegisters.registerbuildingBlock(name +"clay_tiling_vertical_corner", new VerticalCorner(AbstractBlock.Settings
                .copy(block).strength(strength, resistance).requiresTool()));

        return new ClayTilingSet(block, slab, stairs, corner);
    }

    public static void registerModBlockSets() {
        Edumia.LOGGER.debug("Registering OreSets for " + Edumia.MOD_ID);
    }

}
