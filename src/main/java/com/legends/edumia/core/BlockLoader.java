package com.legends.edumia.core;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.*;
import com.legends.edumia.block.plants.DriedReedsBlock;
import com.legends.edumia.block.plants.ReedsBlock;
import com.legends.edumia.world.worldgen.treegrowers.AppleTreeGrower;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class BlockLoader {

    public static final Block SAND_LAYER = registerBlock("sand_layer",
            new Layer(AbstractBlock.Settings.copy(Blocks.SAND).sounds(BlockSoundGroup.SAND)));
    public static final Block RED_SAND_LAYER = registerBlock("red_sand_layer",
            new Layer(AbstractBlock.Settings.copy(Blocks.SAND).sounds(BlockSoundGroup.SAND)));

    public static final Block WHITE_SAND = registerBlock("white_sand",
            new FallingBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.SAND)));
    public static final Block WHITE_SAND_LAYER = registerBlock("white_sand_layer",
            new Layer(AbstractBlock.Settings.copy(Blocks.SAND).sounds(BlockSoundGroup.SAND)));





    public static final Block BRICK_PILLAR = registerBlock("brick_pillar",
            new EdumiaPillarBlock(AbstractBlock.Settings.create()));
    public static final Block STONE_PILLAR = registerBlock("stone_pillar",
            new EdumiaPillarBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));


    public static final Block CLAY_TILING = registerBlock("clay_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CLAY_TILING_STAIRS = registerBlock("clay_tiling_stairs",
            new StairsBlock(BlockLoader.CLAY_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block CLAY_TILING_SLAB = registerBlock("clay_tiling_slab",
            new AxialSlabBlock(CLAY_TILING));
    public static final Block CLAY_TILING_VERTICAL_CORNER = registerBlock("clay_tiling_vertical_corner",
            new VerticalCorner(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block BLACK_CLAY_TILING = registerBlock("black_clay_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block BLACK_CLAY_TILING_STAIRS = registerBlock("black_clay_tiling_stairs",
            new StairsBlock(BlockLoader.BLACK_CLAY_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block BLACK_CLAY_TILING_SLAB = registerBlock("black_clay_tiling_slab",
            new AxialSlabBlock(BLACK_CLAY_TILING));
    public static final Block BLACK_CLAY_TILING_VERTICAL_CORNER = registerBlock("black_clay_tiling_vertical_corner",
            new VerticalCorner(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block BLUE_CLAY_TILING = registerBlock("blue_clay_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block BLUE_CLAY_TILING_STAIRS = registerBlock("blue_clay_tiling_stairs",
            new StairsBlock(BlockLoader.BLUE_CLAY_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block BLUE_CLAY_TILING_SLAB = registerBlock("blue_clay_tiling_slab",
            new AxialSlabBlock(BLUE_CLAY_TILING));
    public static final Block BLUE_CLAY_TILING_VERTICAL_CORNER = registerBlock("blue_clay_tiling_vertical_corner",
            new VerticalCorner(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block BROWN_CLAY_TILING = registerBlock("brown_clay_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block BROWN_CLAY_TILING_STAIRS = registerBlock("brown_clay_tiling_stairs",
            new StairsBlock(BlockLoader.BROWN_CLAY_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block BROWN_CLAY_TILING_SLAB = registerBlock("brown_clay_tiling_slab",
            new AxialSlabBlock(BROWN_CLAY_TILING));
    public static final Block BROWN_CLAY_TILING_VERTICAL_CORNER = registerBlock("brown_clay_tiling_vertical_corner",
            new VerticalCorner(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CYAN_CLAY_TILING = registerBlock("cyan_clay_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CYAN_CLAY_TILING_STAIRS = registerBlock("cyan_clay_tiling_stairs",
            new StairsBlock(BlockLoader.CYAN_CLAY_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block CYAN_CLAY_TILING_SLAB = registerBlock("cyan_clay_tiling_slab",
            new AxialSlabBlock(CYAN_CLAY_TILING));
    public static final Block CYAN_CLAY_TILING_VERTICAL_CORNER = registerBlock("cyan_clay_tiling_vertical_corner",
            new VerticalCorner(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block GRAY_CLAY_TILING = registerBlock("gray_clay_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block GRAY_CLAY_TILING_STAIRS = registerBlock("gray_clay_tiling_stairs",
            new StairsBlock(BlockLoader.GRAY_CLAY_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block GRAY_CLAY_TILING_SLAB = registerBlock("gray_clay_tiling_slab",
            new AxialSlabBlock(GRAY_CLAY_TILING));
    public static final Block GRAY_CLAY_TILING_VERTICAL_CORNER = registerBlock("gray_clay_tiling_vertical_corner",
            new VerticalCorner(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block GREEN_CLAY_TILING = registerBlock("green_clay_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block GREEN_CLAY_TILING_STAIRS = registerBlock("green_clay_tiling_stairs",
            new StairsBlock(BlockLoader.GREEN_CLAY_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block GREEN_CLAY_TILING_SLAB = registerBlock("green_clay_tiling_slab",
            new AxialSlabBlock(GREEN_CLAY_TILING));
    public static final Block GREEN_CLAY_TILING_VERTICAL_CORNER = registerBlock("green_clay_tiling_vertical_corner",
            new VerticalCorner(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block LIGHT_BLUE_CLAY_TILING = registerBlock("light_blue_clay_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block LIGHT_BLUE_CLAY_TILING_STAIRS = registerBlock("light_blue_clay_tiling_stairs",
            new StairsBlock(BlockLoader.LIGHT_BLUE_CLAY_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block LIGHT_BLUE_CLAY_TILING_SLAB = registerBlock("light_blue_clay_tiling_slab",
            new AxialSlabBlock(LIGHT_BLUE_CLAY_TILING));
    public static final Block LIGHT_BLUE_CLAY_TILING_VERTICAL_CORNER = registerBlock("light_blue_clay_tiling_vertical_corner",
            new VerticalCorner(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block LIGHT_GRAY_CLAY_TILING = registerBlock("light_gray_clay_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block LIGHT_GRAY_CLAY_TILING_STAIRS = registerBlock("liht_gray_clay_tiling_stairs",
            new StairsBlock(BlockLoader.LIGHT_GRAY_CLAY_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block LIGHT_GRAY_CLAY_TILING_SLAB = registerBlock("light_gray_clay_tiling_slab",
            new AxialSlabBlock(LIGHT_GRAY_CLAY_TILING));
    public static final Block LIGHT_GRAY_CLAY_TILING_VERTICAL_CORNER = registerBlock("light_gray_clay_tiling_vertical_corner",
            new VerticalCorner(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block LIME_CLAY_TILING = registerBlock("lime_clay_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block LIME_CLAY_TILING_STAIRS = registerBlock("lime_clay_tiling_stairs",
            new StairsBlock(BlockLoader.LIME_CLAY_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block LIME_CLAY_TILING_SLAB = registerBlock("lime_clay_tiling_slab",
            new AxialSlabBlock(LIME_CLAY_TILING));
    public static final Block LIME_CLAY_TILING_VERTICAL_CORNER = registerBlock("lime_clay_tiling_vertical_corner",
            new VerticalCorner(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block MAGENTA_CLAY_TILING = registerBlock("magenta_clay_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block MAGENTA_CLAY_TILING_STAIRS = registerBlock("magenta_clay_tiling_stairs",
            new StairsBlock(BlockLoader.MAGENTA_CLAY_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block MAGENTA_CLAY_TILING_SLAB = registerBlock("magenta_clay_tiling_slab",
            new AxialSlabBlock(MAGENTA_CLAY_TILING));
    public static final Block MAGENTA_CLAY_TILING_VERTICAL_CORNER = registerBlock("magenta_clay_tiling_vertical_corner",
            new VerticalCorner(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block ORANGE_CLAY_TILING = registerBlock("orange_clay_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block ORANGE_CLAY_TILING_STAIRS = registerBlock("orange_clay_tiling_stairs",
            new StairsBlock(BlockLoader.ORANGE_CLAY_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block ORANGE_CLAY_TILING_SLAB = registerBlock("orange_clay_tiling_slab",
            new AxialSlabBlock(ORANGE_CLAY_TILING));
    public static final Block ORANGE_CLAY_TILING_VERTICAL_CORNER = registerBlock("orange_clay_tiling_vertical_corner",
            new VerticalCorner(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block PINK_CLAY_TILING = registerBlock("pink_clay_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block PINK_CLAY_TILING_STAIRS = registerBlock("pink_clay_tiling_stairs",
            new StairsBlock(BlockLoader.PINK_CLAY_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block PINK_CLAY_TILING_SLAB = registerBlock("pink_clay_tiling_slab",
            new AxialSlabBlock(PINK_CLAY_TILING));
    public static final Block PINK_CLAY_TILING_VERTICAL_CORNER = registerBlock("pink_clay_tiling_vertical_corner",
            new VerticalCorner(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block PURPLE_CLAY_TILING = registerBlock("purple_clay_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block PURPLE_CLAY_TILING_STAIRS = registerBlock("purple_clay_tiling_stairs",
            new StairsBlock(BlockLoader.PURPLE_CLAY_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block PURPLE_CLAY_TILING_SLAB = registerBlock("purple_clay_tiling_slab",
            new AxialSlabBlock(PURPLE_CLAY_TILING));
    public static final Block PURPLE_CLAY_TILING_VERTICAL_CORNER = registerBlock("purple_clay_tiling_vertical_corner",
            new VerticalCorner(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block RED_CLAY_TILING = registerBlock("red_clay_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block RED_CLAY_TILING_STAIRS = registerBlock("red_clay_tiling_stairs",
            new StairsBlock(BlockLoader.RED_CLAY_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block RED_CLAY_TILING_SLAB = registerBlock("red_clay_tiling_slab",
            new AxialSlabBlock(RED_CLAY_TILING));
    public static final Block RED_CLAY_TILING_VERTICAL_CORNER = registerBlock("red_clay_tiling_vertical_corner",
            new VerticalCorner(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block WHITE_CLAY_TILING = registerBlock("white_clay_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block WHITE_CLAY_TILING_STAIRS = registerBlock("white_clay_tiling_stairs",
            new StairsBlock(BlockLoader.WHITE_CLAY_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block WHITE_CLAY_TILING_SLAB = registerBlock("white_clay_tiling_slab",
            new AxialSlabBlock(WHITE_CLAY_TILING));
    public static final Block WHITE_CLAY_TILING_VERTICAL_CORNER = registerBlock("white_clay_tiling_vertical_corner",
            new VerticalCorner(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block YELLOW_CLAY_TILING = registerBlock("yellow_clay_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block YELLOW_CLAY_TILING_STAIRS = registerBlock("yellow_clay_tiling_stairs",
            new StairsBlock(BlockLoader.YELLOW_CLAY_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block YELLOW_CLAY_TILING_SLAB = registerBlock("yellow_clay_tiling_slab",
            new AxialSlabBlock(YELLOW_CLAY_TILING));
    public static final Block YELLOW_CLAY_TILING_VERTICAL_CORNER = registerBlock("yellow_clay_tiling_vertical_corner",
            new VerticalCorner(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));


    public static final Block BROWN_STONE = registerBlock("brown_stone",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.5f, 6f).requiresTool()));
    public static final Block BROWN_STONE_STAIRS = registerBlock("brown_stone_stairs",
            new StairsBlock(BlockLoader.BROWN_STONE.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block BROWN_STONE_SLAB = registerBlock("brown_stone_slab",
            new AxialSlabBlock(BROWN_STONE));
    public static final Block BROWN_STONE_WALL = registerBlock("brown_stone_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block LIGHT_GRAY_STONE = registerBlock("light_gray_stone",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.5f, 6f).requiresTool()));
    public static final Block LIGHT_GRAY_STONE_STAIRS = registerBlock("light_gray_stone_stairs",
            new StairsBlock(BlockLoader.LIGHT_GRAY_STONE.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block LIGHT_GRAY_STONE_SLAB = registerBlock("light_gray_stone_slab",
            new AxialSlabBlock(LIGHT_GRAY_STONE));
    public static final Block LIGHT_GRAY_STONE_WALL = registerBlock("light_gray_stone_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block LIGHT_GRAY_STONE_BRICKS = registerBlock("light_gray_stone_bricks",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.5f, 6f).requiresTool()));
    public static final Block LIGHT_GRAY_STONE_BRICKS_STAIRS = registerBlock("light_gray_stone_bricks_stairs",
            new StairsBlock(BlockLoader.LIGHT_GRAY_STONE_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block LIGHT_GRAY_STONE_BRICKS_SLAB = registerBlock("light_gray_stone_bricks_slab",
            new AxialSlabBlock(LIGHT_GRAY_STONE_BRICKS));
    public static final Block LIGHT_GRAY_STONE_BRICKS_WALL = registerBlock("light_gray_stone_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block BLUE_STONE = registerBlock("blue_stone",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.5f, 6f).requiresTool()));
    public static final Block BLUE_STONE_STAIRS = registerBlock("blue_stone_stairs",
            new StairsBlock(BlockLoader.BLUE_STONE.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block BLUE_STONE_SLAB = registerBlock("blue_stone_slab",
            new AxialSlabBlock(BLUE_STONE));
    public static final Block BLUE_STONE_WALL = registerBlock("blue_stone_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block BLUE_BRICK = registerBlock("blue_brick",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.5f, 6f).requiresTool()));
    public static final Block BLUE_BRICK_STAIRS = registerBlock("blue_brick_stairs",
            new StairsBlock(BlockLoader.BLUE_BRICK.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block BLUE_BRICK_SLAB = registerBlock("blue_brick_slab",
            new AxialSlabBlock(BLUE_BRICK));
    public static final Block BLUE_BRICK_WALL = registerBlock("blue_brick_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block YELLOW_STONE = registerBlock("yellow_stone",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.5f, 6f).requiresTool()));
    public static final Block YELLOW_STONE_STAIRS = registerBlock("yellow_stone_stairs",
            new StairsBlock(BlockLoader.YELLOW_STONE.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block YELLOW_STONE_SLAB = registerBlock("yellow_stone_slab",
            new AxialSlabBlock(YELLOW_STONE));
    public static final Block YELLOW_STONE_WALL = registerBlock("yellow_stone_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block YELLOW_STONE_2 = registerBlock("yellow_stone_2",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.5f, 6f).requiresTool()));
    public static final Block YELLOW_STONE_2_STAIRS = registerBlock("yellow_stone_2_stairs",
            new StairsBlock(BlockLoader.YELLOW_STONE_2.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block YELLOW_STONE_2_SLAB = registerBlock("yellow_stone_2_slab",
            new AxialSlabBlock(YELLOW_STONE_2));
    public static final Block YELLOW_STONE_2_WALL = registerBlock("yellow_stone_2_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block YELLOW_STONE_BRICKS = registerBlock("yellow_stone_bricks",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.5f, 6f).requiresTool()));
    public static final Block YELLOW_STONE_BRICKS_STAIRS = registerBlock("yellow_stone_bricks_stairs",
            new StairsBlock(BlockLoader.YELLOW_STONE_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block YELLOW_STONE_BRICKS_SLAB = registerBlock("yellow_stone_bricks_slab",
            new AxialSlabBlock(YELLOW_STONE_BRICKS));
    public static final Block YELLOW_STONE_BRICKS_WALL = registerBlock("yellow_stone_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block YELLOW_STONE_BRICKS_2 = registerBlock("yellow_stone_bricks_2",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block YELLOW_STONE_BRICKS_2_STAIRS = registerBlock("yellow_stone_bricks_2_stairs",
            new StairsBlock(BlockLoader.YELLOW_STONE_BRICKS_2.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block YELLOW_STONE_BRICKS_2_SLAB = registerBlock("yellow_stone_bricks_2_slab",
            new AxialSlabBlock(YELLOW_STONE_BRICKS_2));
    public static final Block YELLOW_STONE_BRICKS_2_WALL = registerBlock("yellow_stone_bricks_2_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block BASALT_BRICKS = registerBlock("basalt_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block BASALT_BRICKS_STAIRS = registerBlock("basalt_bricks_stairs",
            new StairsBlock(BlockLoader.BASALT_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block BASALT_BRICKS_SLAB = registerBlock("basalt_bricks_slab",
            new AxialSlabBlock(BASALT_BRICKS));
    public static final Block BASALT_BRICKS_WALL = registerBlock("basalt_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block GREEN_BASALT = registerBlock("green_basalt",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block GREEN_BASALT_STAIRS = registerBlock("green_basalt_stairs",
            new StairsBlock(BlockLoader.GREEN_BASALT.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block GREEN_BASALT_SLAB = registerBlock("green_basalt_slab",
            new AxialSlabBlock(GREEN_BASALT));
    public static final Block GREEN_BASALT_WALL = registerBlock("green_basalt_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

//    public static final Block GREEN_BASALT_ROUND_ARCH = registerBlock("green_basalt_round_arch",
//            new Arch(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//
//
//    public static final Block GREEN_BASALT_GOTHIC_ARCH = registerBlock("green_basalt_gothic_arch",
//            new Arch(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//    public static final Block GREEN_BASALT_SEGMENTAL_ARCH = registerBlock("green_basalt_segmental_arch",
//            new Arch(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
     public static final Block GREEN_BASALT_SMALL_ARCH = registerBlock("green_basalt_small_arch",
             new ArchSmall(AbstractBlock.Settings.create().requiresTool()
                     .strength(1.5f, 6f)));
     public static final Block GREEN_BASALT_TWO_METER_ARCH = registerBlock("green_basalt_two_meter_arch",
             new ArchTwoMeter(AbstractBlock.Settings.create().requiresTool()
                     .strength(1.5f, 6f)));
     public static final Block GREEN_BASALT_ARROWSLIT = registerBlock("green_basalt_arrowslit",
             new ArrowSlit(AbstractBlock.Settings.create().requiresTool()
                     .strength(1.5f, 6f)));
    public static final Block GREEN_BASALT_BALUSTRADE = registerBlock("green_basalt_balustrade",
            new Balustrade(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));


    public static final Block GREEN_BASALT_BRICKS = registerBlock("green_basalt_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block GREEN_BASALT_BRICKS_STAIRS = registerBlock("green_basalt_bricks_stairs",
            new StairsBlock(BlockLoader.GREEN_BASALT_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block GREEN_BASALT_BRICKS_SLAB = registerBlock("green_basalt_bricks_slab",
            new AxialSlabBlock(GREEN_BASALT_BRICKS));
    public static final Block GREEN_BASALT_BRICKS_WALL = registerBlock("green_basalt_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
//    public static final Block GREEN_BASALT_BRICKS_GOTHIC_ARCH = registerBlock("green_basalt_bricks_gothic_arch",
//            new Arch(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//    public static final Block GREEN_BASALT_BRICKS_SEGMENTAL_ARCH = registerBlock("green_basalt_bricks_segmental_arch",
//            new Arch(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//    public static final Block GREEN_BASALT_BRICKS_ROUND_ARCH = registerBlock("green_basalt_bricks_round_arch",
//            new Arch(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//    public static final Block GREEN_BASALT_BRICKS_SMALL_ARCH = registerBlock("green_basalt_bricks_small_arch",
//            new ArchSmall(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//    public static final Block GREEN_BASALT_BRICKS_TWO_METER_ARCH = registerBlock("green_basalt_bricks_two_meter_arch",
//            new ArchTwoMeter(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//    public static final Block GREEN_BASALT_BRICKS_ARROWSLIT = registerBlock("green_basalt_bricks_arrowslit",
//            new ArrowSlit(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//    public static final Block GREEN_BASALT_BRICKS_BALUSTRADE = registerBlock("green_basalt_bricks_balustrade",
//            new Balustrade(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//    public static final Block GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL = registerBlock
//            ("green_basalt_bricks_corinthian_capital",
//                    new CubeCapitalCorinthian(AbstractBlock.Settings.create().requiresTool()
//                            .strength(1.5f, 6f)));
//    public static final Block GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL_PILLAR = registerBlock
//            ("green_basalt_bricks_corinthian_capital_pillar",
//                    new PillarCapitalCorinthian(AbstractBlock.Settings.create().requiresTool()
//                            .strength(1.5f, 6f)));
//    public static final Block GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL_WALL = registerBlock
//            ("green_basalt_bricks_corinthian_capital_wall",
//                    new WallCapitalCorinthian(AbstractBlock.Settings.create().requiresTool()
//                            .strength(1.5f, 6f)));
//    public static final Block GREEN_BASALT_BRICKS_IONIAN_CAPITAL = registerBlock
//            ("green_basalt_bricks_ionian_capital",
//                    new Log(AbstractBlock.Settings.create().requiresTool()
//                            .strength(1.5f, 6f)));
//    public static final Block GREEN_BASALT_BRICKS_IONIAN_CAPITAL_LARGE_PILLAR = registerBlock
//            ("green_basalt_bricks_ionian_capital_large_pillar",
//                    new PillarLargeRotated(AbstractBlock.Settings.create().requiresTool()
//                            .strength(1.5f, 6f)));
//    public static final Block GREEN_BASALT_BRICKS_IONIAN_CAPITAL_PILAR = registerBlock
//            ("green_basalt_bricks_ionian_capital_pillar",
//                    new PillarRotated(AbstractBlock.Settings.create().requiresTool()
//                            .strength(1.5f, 6f)));
//    public static final Block GREEN_BASALT_BRICKS_IONIAN_CAPITAL_SMALL_PILLAR = registerBlock
//            ("green_basalt_bricks_ionian_capital_small_pillar",
//                    new PillarSmallRotated(AbstractBlock.Settings.create().requiresTool()
//                            .strength(1.5f, 6f)));
//    public static final Block GREEN_BASALT_BRICKS_IONIAN_CAPITAL_WALL = registerBlock
//            ("green_basalt_bricks_ionian_capital_wall",
//                    new Wall(AbstractBlock.Settings.create().requiresTool()
//                            .strength(1.5f, 6f)));
//
//
    public static final Block MOSSY_BASALT_BRICKS = registerBlock("mossy_basalt_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block MOSSY_BASALT_BRICKS_STAIRS = registerBlock("mossy_basalt_bricks_stairs",
            new StairsBlock(BlockLoader.MOSSY_BASALT_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block MOSSY_BASALT_BRICKS_SLAB = registerBlock("mossy_basalt_bricks_slab",
            new AxialSlabBlock(MOSSY_BASALT_BRICKS));
    public static final Block MOSSY_BASALT_BRICKS_WALL = registerBlock("mossy_basalt_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CHISELED_BASALT = registerBlock("chiseled_basalt",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CRACKED_GREEN_BASALT = registerBlock("cracked_green_basalt",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CRACKED_GREEN_BASALT_STAIRS = registerBlock("cracked_green_basalt_stairs",
            new StairsBlock(BlockLoader.CRACKED_GREEN_BASALT.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block CRACKED_GREEN_BASALT_SLAB = registerBlock("cracked_green_basalt_slab",
            new AxialSlabBlock(CRACKED_GREEN_BASALT));
    public static final Block CRACKED_GREEN_BASALT_WALL = registerBlock("cracked_green_basalt_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block GREEN_BASALT_COBBLESTONE = registerBlock("green_basalt_cobblestone",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block GREEN_BASALT_COBBLESTONE_STAIRS = registerBlock("green_basalt_cobblestone_stairs",
            new StairsBlock(BlockLoader.GREEN_BASALT_COBBLESTONE.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block GREEN_BASALT_COBBLESTONE_SLAB = registerBlock("green_basalt_cobblestone_slab",
            new AxialSlabBlock(GREEN_BASALT_COBBLESTONE));
    public static final Block GREEN_BASALT_COBBLESTONE_WALL = registerBlock("green_basalt_cobblestone_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block GNEISS = registerBlock("gneiss",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block GNEISS_STAIRS = registerBlock("gneiss_stairs",
            new StairsBlock(BlockLoader.GNEISS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block GNEISS_SLAB = registerBlock("gneiss_slab",
            new AxialSlabBlock(GNEISS));
    public static final Block GNEISS_WALL = registerBlock("gneiss_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
//
//    public static final Block LIMESTONE = registerBlock("limestone",
//            new Block(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//    public static final Block LIMESTONE_STAIRS = registerBlock("limestone_stairs",
//            new StairsBlock(BlockLoader.LIMESTONE.getDefaultState() ,
//                    AbstractBlock.Settings.create().requiresTool()
//                            .strength(1.5f, 6f)));
//    public static final Block LIMESTONE_SLAB = registerBlock("limestone_slab",
//            new AxialSlabBlock(LIMESTONE));
//    public static final Block LIMESTONE_WALL = registerBlock("limestone_wall",
//            new WallBlock(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//
    public static final Block CYAN_STONE = registerBlock("cyan_stone",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CYAN_STONE_STAIRS = registerBlock("cyan_stone_stairs",
            new StairsBlock(BlockLoader.CYAN_STONE.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block CYAN_STONE_SLAB = registerBlock("cyan_stone_slab",
            new AxialSlabBlock(CYAN_STONE));
    public static final Block CYAN_STONE_WALL = registerBlock("cyan_stone_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block ORANGE_ROCK = registerBlock("orange_rock",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block ORANGE_ROCK_STAIRS = registerBlock("orange_rock_stairs",
            new StairsBlock(BlockLoader.ORANGE_ROCK.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block ORANGE_ROCK_SLAB = registerBlock("orange_rock_slab",
            new AxialSlabBlock(ORANGE_ROCK));
    public static final Block ORANGE_ROCK_WALL = registerBlock("orange_rock_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block RED_ROCK = registerBlock("red_rock",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block RED_ROCK_STAIRS = registerBlock("red_rock_stairs",
            new StairsBlock(BlockLoader.RED_ROCK.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block RED_ROCK_SLAB = registerBlock("red_rock_slab",
            new AxialSlabBlock(RED_ROCK));
    public static final Block RED_ROCK_WALL = registerBlock("red_rock_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block YELLOW_COBBLE = registerBlock("yellow_cobble",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block YELLOW_COBBLE_STAIRS = registerBlock("yellow_cobble_stairs",
            new StairsBlock(BlockLoader.YELLOW_COBBLE.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block YELLOW_COBBLE_SLAB = registerBlock("yellow_cobble_slab",
            new AxialSlabBlock(YELLOW_COBBLE));
    public static final Block YELLOW_COBBLE_WALL = registerBlock("yellow_cobble_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CHALK = registerBlock("chalk",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CHALK_STAIRS = registerBlock("chalk_stairs",
            new StairsBlock(BlockLoader.CHALK.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block CHALK_SLAB = registerBlock("chalk_slab",
            new AxialSlabBlock(CHALK));
    public static final Block CHALK_WALL = registerBlock("chalk_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CHALK_BRICKS = registerBlock("chalk_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CHALK_BRICKS_STAIRS = registerBlock("chalk_bricks_stairs",
            new StairsBlock(BlockLoader.CHALK_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block CHALK_BRICKS_SLAB = registerBlock("chalk_bricks_slab",
            new AxialSlabBlock(CHALK_BRICKS));
    public static final Block CHALK_BRICKS_WALL = registerBlock("chalk_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CHALK_PILLAR = registerBlock("chalk_pillar",
            new EdumiaPillarBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block HIGH_ELVEN_ROCK = registerBlock("high_elven_rock",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block HIGH_ELVEN_ROCK_STAIRS = registerBlock("high_elven_rock_stairs",
            new StairsBlock(BlockLoader.HIGH_ELVEN_ROCK.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block HIGH_ELVEN_ROCK_SLAB = registerBlock("high_elven_rock_slab",
            new AxialSlabBlock(HIGH_ELVEN_ROCK));
    public static final Block HIGH_ELVEN_ROCK_WALL = registerBlock("high_elven_rock_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block DARK_HIGH_ELVEN_ROCK = registerBlock("dark_high_elven_rock",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block DARK_HIGH_ELVEN_ROCK_STAIRS = registerBlock("dark_high_elven_rock_stairs",
            new StairsBlock(BlockLoader.DARK_HIGH_ELVEN_ROCK.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block DARK_HIGH_ELVEN_ROCK_SLAB = registerBlock("dark_high_elven_rock_slab",
            new AxialSlabBlock(DARK_HIGH_ELVEN_ROCK));
    public static final Block DARK_HIGH_ELVEN_ROCK_WALL = registerBlock("dark_high_elven_rock_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block LIGHT_HIGH_ELVEN_ROCK = registerBlock("light_high_elven_rock",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block LIGHT_HIGH_ELVEN_ROCK_STAIRS = registerBlock("light_high_elven_rock_stairs",
            new StairsBlock(BlockLoader.HIGH_ELVEN_ROCK.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block LIGHT_HIGH_ELVEN_ROCK_SLAB = registerBlock("light_high_elven_rock_slab",
            new AxialSlabBlock(LIGHT_HIGH_ELVEN_ROCK));
    public static final Block LIGHT_HIGH_ELVEN_ROCK_WALL = registerBlock("light_high_elven_rock_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block HIGH_ELVEN_BRICKS = registerBlock("high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block HIGH_ELVEN_BRICKS_STAIRS = registerBlock("high_elven_bricks_stairs",
            new StairsBlock(BlockLoader.HIGH_ELVEN_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block HIGH_ELVEN_BRICKS_SLAB = registerBlock("high_elven_bricks_slab",
            new AxialSlabBlock(HIGH_ELVEN_BRICKS));
    public static final Block HIGH_ELVEN_BRICKS_WALL = registerBlock("high_elven_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
//    public static final Block HIGH_ELVEN_BRICKS_GOTHIC_ARCH = registerBlock("high_elven_bricks_gothic_arch",
//            new Arch(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//    public static final Block HIGH_ELVEN_BRICKS_SEGMENTAL_ARCH = registerBlock("high_elven_bricks_segmental_arch",
//            new Arch(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//    public static final Block HIGH_ELVEN_BRICKS_ROUND_ARCH = registerBlock("high_elven_bricks_round_arch",
//            new Arch(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//    public static final Block HIGH_ELVEN_BRICKS_SMALL_ARCH = registerBlock("high_elven_bricks_small_arch",
//            new ArchSmall(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//    public static final Block HIGH_ELVEN_BRICKS_TWO_METER_ARCH = registerBlock("high_elven_bricks_two_meter_arch",
//            new ArchTwoMeter(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
    public static final Block SMALL_HIGH_ELVEN_BRICKS = registerBlock("small_high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block SMALL_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("small_high_elven_bricks_stairs",
            new StairsBlock(BlockLoader.SMALL_HIGH_ELVEN_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block SMALL_HIGH_ELVEN_BRICKS_SLAB = registerBlock("small_high_elven_bricks_slab",
            new AxialSlabBlock(SMALL_HIGH_ELVEN_BRICKS));
    public static final Block SMALL_HIGH_ELVEN_BRICKS_WALL = registerBlock("small_high_elven_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block HIGH_ELVEN_PILLAR = registerBlock("high_elven_pillar",
            new EdumiaPillarBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
//
//    public static final Block HIGH_ELVEN_BALUSTRADE = registerBlock("high_elven_balustrade",
//            new Balustrade(AbstractBlock.Settings.create()));
//    public static final Block HIGH_ELVEN_BRICK_ARROWSLIT = registerBlock("high_elven_brick_arrowslit",
//            new ArrowSlit(AbstractBlock.Settings.create()));
//
//
    public static final Block CHISELED_HIGH_ELVEN_BRICKS = registerBlock("chiseled_high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CRACKED_HIGH_ELVEN_BRICKS = registerBlock("cracked_high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CRACKED_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("cracked_high_elven_bricks_stairs",
            new StairsBlock(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block CRACKED_HIGH_ELVEN_BRICKS_SLAB = registerBlock("cracked_high_elven_bricks_slab",
            new AxialSlabBlock(CRACKED_HIGH_ELVEN_BRICKS));
    public static final Block CRACKED_HIGH_ELVEN_BRICKS_WALL = registerBlock("cracked_high_elven_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
//
    public static final Block MOSSY_HIGH_ELVEN_BRICKS = registerBlock("mossy_high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block MOSSY_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("mossy_high_elven_bricks_stairs",
            new StairsBlock(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block MOSSY_HIGH_ELVEN_BRICKS_SLAB = registerBlock("mossy_high_elven_bricks_slab",
            new AxialSlabBlock(MOSSY_HIGH_ELVEN_BRICKS));
    public static final Block MOSSY_HIGH_ELVEN_BRICKS_WALL = registerBlock("mossy_high_elven_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block LIGHT_HIGH_ELVEN_BRICKS = registerBlock("light_high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block LIGHT_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("light_high_elven_bricks_stairs",
            new StairsBlock(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block LIGHT_HIGH_ELVEN_BRICKS_SLAB = registerBlock("light_high_elven_bricks_slab",
            new AxialSlabBlock(LIGHT_HIGH_ELVEN_BRICKS));
    public static final Block LIGHT_HIGH_ELVEN_BRICKS_WALL = registerBlock("light_high_elven_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
//    public static final Block LIGHT_HIGH_ELVEN_BALUSTRADE = registerBlock("light_high_elven_balustrade",
//            new Balustrade(AbstractBlock.Settings.create()));
    public static final Block LIGHT_HIGH_ELVEN_PILLAR = registerBlock("light_high_elven_pillar",
            new EdumiaPillarBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block SMALL_LIGHT_HIGH_ELVEN_BRICKS = registerBlock("small_light_high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block SMALL_LIGHT_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("small_light_high_elven_bricks_stairs",
            new StairsBlock(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block SMALL_LIGHT_HIGH_ELVEN_BRICKS_SLAB = registerBlock("small_light_high_elven_bricks_slab",
            new AxialSlabBlock(SMALL_LIGHT_HIGH_ELVEN_BRICKS));
    public static final Block SMALL_LIGHT_HIGH_ELVEN_BRICKS_WALL = registerBlock("small_light_high_elven_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CHISELED_LIGHT_HIGH_ELVEN_BRICKS = registerBlock("chiseled_light_high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
//
    public static final Block CRACKED_LIGHT_HIGH_ELVEN_BRICKS = registerBlock("cracked_light_high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CRACKED_LIGHT_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("cracked_light_high_elven_bricks_stairs",
            new StairsBlock(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block CRACKED_LIGHT_HIGH_ELVEN_BRICKS_SLAB = registerBlock("cracked_light_high_elven_bricks_slab",
            new AxialSlabBlock(CRACKED_LIGHT_HIGH_ELVEN_BRICKS));
    public static final Block CRACKED_LIGHT_HIGH_ELVEN_BRICKS_WALL = registerBlock("cracked_light_high_elven_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block MOSSY_LIGHT_HIGH_ELVEN_BRICKS = registerBlock("mossy_light_high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block MOSSY_LIGHT_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("mossy_light_high_elven_bricks_stairs",
            new StairsBlock(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block MOSSY_LIGHT_HIGH_ELVEN_BRICKS_SLAB = registerBlock("mossy_light_high_elven_bricks_slab",
            new AxialSlabBlock(MOSSY_LIGHT_HIGH_ELVEN_BRICKS));
    public static final Block MOSSY_LIGHT_HIGH_ELVEN_BRICKS_WALL = registerBlock("mossy_light_high_elven_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block DARK_HIGH_ELVEN_BRICKS = registerBlock("dark_high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block DARK_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("dark_high_elven_bricks_stairs",
            new StairsBlock(BlockLoader.DARK_HIGH_ELVEN_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block DARK_HIGH_ELVEN_BRICKS_SLAB = registerBlock("dark_high_elven_bricks_slab",
            new AxialSlabBlock(DARK_HIGH_ELVEN_BRICKS));
    public static final Block DARK_HIGH_ELVEN_BRICKS_WALL = registerBlock("dark_high_elven_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
//    public static final Block DARK_HIGH_ELVEN_BALUSTRADE = registerBlock("dark_high_elven_balustrade",
//            new Balustrade(AbstractBlock.Settings.create()));
    public static final Block DARK_HIGH_ELVEN_PILLAR = registerBlock("dark_high_elven_pillar",
            new EdumiaPillarBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block SMALL_DARK_HIGH_ELVEN_BRICKS = registerBlock("small_dark_high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block SMALL_DARK_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("small_dark_high_elven_bricks_stairs",
            new StairsBlock(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block SMALL_DARK_HIGH_ELVEN_BRICKS_SLAB = registerBlock("small_dark_high_elven_bricks_slab",
            new AxialSlabBlock(SMALL_DARK_HIGH_ELVEN_BRICKS));
    public static final Block SMALL_DARK_HIGH_ELVEN_BRICKS_WALL = registerBlock("small_dark_high_elven_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CHISELED_DARK_HIGH_ELVEN_BRICKS = registerBlock("chiseled_dark_high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CRACKED_DARK_HIGH_ELVEN_BRICKS = registerBlock("cracked_dark_high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CRACKED_DARK_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("cracked_dark_high_elven_bricks_stairs",
            new StairsBlock(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block CRACKED_DARK_HIGH_ELVEN_BRICKS_SLAB = registerBlock("cracked_dark_high_elven_bricks_slab",
            new AxialSlabBlock(CRACKED_DARK_HIGH_ELVEN_BRICKS));
    public static final Block CRACKED_DARK_HIGH_ELVEN_BRICKS_WALL = registerBlock("cracked_dark_high_elven_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block MOSSY_DARK_HIGH_ELVEN_BRICKS = registerBlock("mossy_dark_high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block MOSSY_DARK_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("mossy_dark_high_elven_bricks_stairs",
            new StairsBlock(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block MOSSY_DARK_HIGH_ELVEN_BRICKS_SLAB = registerBlock("mossy_dark_high_elven_bricks_slab",
            new AxialSlabBlock(MOSSY_DARK_HIGH_ELVEN_BRICKS));
    public static final Block MOSSY_DARK_HIGH_ELVEN_BRICKS_WALL = registerBlock("mossy_dark_high_elven_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block BROWN_SANDSTONE_BRICKS = registerBlock("brown_sandstone_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block BROWN_SANDSTONE_BRICKS_STAIRS = registerBlock("brown_sandstone_bricks_stairs",
            new StairsBlock(BlockLoader.BROWN_SANDSTONE_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block BROWN_SANDSTONE_BRICKS_SLAB = registerBlock("brown_sandstone_bricks_slab",
            new AxialSlabBlock(BROWN_SANDSTONE_BRICKS));
    public static final Block BROWN_SANDSTONE_BRICKS_WALL = registerBlock("brown_sandstone_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));


    public static final Block CARVED_BROWN_SANDSTONE_BRICKS = registerBlock("carved_brown_sandstone_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CRACKED_BROWN_SANDSTONE_BRICKS = registerBlock("cracked_brown_sandstone_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CRACKED_BROWN_SANDSTONE_BRICKS_STAIRS = registerBlock("cracked_brown_sandstone_bricks_stairs",
            new StairsBlock(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block CRACKED_BROWN_SANDSTONE_BRICKS_SLAB = registerBlock("cracked_brown_sandstone_bricks_slab",
            new AxialSlabBlock(CRACKED_BROWN_SANDSTONE_BRICKS));
    public static final Block CRACKED_BROWN_SANDSTONE_BRICKS_WALL = registerBlock("cracked_brown_sandstone_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block MOSSY_BROWN_SANDSTONE_BRICKS = registerBlock("mossy_brown_sandstone_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block MOSSY_BROWN_SANDSTONE_BRICKS_STAIRS = registerBlock("mossy_brown_sandstone_bricks_stairs",
            new StairsBlock(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block MOSSY_BROWN_SANDSTONE_BRICKS_SLAB = registerBlock("mossy_brown_sandstone_bricks_slab",
            new AxialSlabBlock(MOSSY_BROWN_SANDSTONE_BRICKS));
    public static final Block MOSSY_BROWN_SANDSTONE_BRICKS_WALL = registerBlock("mossy_brown_sandstone_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CACHOLONG_BRICKS = registerBlock("cacholong_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CACHOLONG_BRICKS_STAIRS = registerBlock("cacholong_bricks_stairs",
            new StairsBlock(BlockLoader.CACHOLONG_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block CACHOLONG_BRICKS_SLAB = registerBlock("cacholong_bricks_slab",
            new AxialSlabBlock(CACHOLONG_BRICKS));
    public static final Block CACHOLONG_BRICKS_WALL = registerBlock("cacholong_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CACHOLONG_PILLAR = registerBlock("cacholong_pillar",
            new EdumiaPillarBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));


    public static final Block CARVED_CACHOLONG_BRICKS = registerBlock("carved_cacholong_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CRACKED_CACHOLONG_BRICKS = registerBlock("cracked_cacholong_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CRACKED_CACHOLONG_BRICKS_STAIRS = registerBlock("cracked_cacholong_bricks_stairs",
            new StairsBlock(BlockLoader.CRACKED_CACHOLONG_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block CRACKED_CACHOLONG_BRICKS_SLAB = registerBlock("cracked_cacholong_bricks_slab",
            new AxialSlabBlock(CRACKED_CACHOLONG_BRICKS));
    public static final Block CRACKED_CACHOLONG_BRICKS_WALL = registerBlock("cracked_cacholong_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block MOSSY_CACHOLONG_BRICKS = registerBlock("mossy_cacholong_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block MOSSY_CACHOLONG_BRICKS_STAIRS = registerBlock("mossy_cacholong_bricks_stairs",
            new StairsBlock(BlockLoader.MOSSY_CACHOLONG_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block MOSSY_CACHOLONG_BRICKS_SLAB = registerBlock("mossy_cacholong_bricks_slab",
            new AxialSlabBlock(MOSSY_CACHOLONG_BRICKS));
    public static final Block MOSSY_CACHOLONG_BRICKS_WALL = registerBlock("mossy_cacholong_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block BLACK_DEMON_BRICKS = registerBlock("black_demon_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block BLACK_DEMON_BRICKS_STAIRS = registerBlock("black_demon_bricks_stairs",
            new StairsBlock(BlockLoader.BLACK_DEMON_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block BLACK_DEMON_BRICKS_SLAB = registerBlock("black_demon_bricks_slab",
            new AxialSlabBlock(BLACK_DEMON_BRICKS));
    public static final Block BLACK_DEMON_BRICKS_WALL = registerBlock("black_demon_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));


    public static final Block CARVED_BLACK_DEMON_BRICKS = registerBlock("carved_black_demon_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CRACKED_BLACK_DEMON_BRICKS = registerBlock("cracked_black_demon_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CRACKED_BLACK_DEMON_BRICKS_STAIRS = registerBlock("cracked_black_demon_bricks_stairs",
            new StairsBlock(BlockLoader.CRACKED_BLACK_DEMON_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block CRACKED_BLACK_DEMON_BRICKS_SLAB = registerBlock("cracked_black_demon_bricks_slab",
            new AxialSlabBlock(CRACKED_BLACK_DEMON_BRICKS));
    public static final Block CRACKED_BLACK_DEMON_BRICKS_WALL = registerBlock("cracked_black_demon_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block MOSSY_BLACK_DEMON_BRICKS = registerBlock("mossy_black_demon_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block MOSSY_BLACK_DEMON_BRICKS_STAIRS = registerBlock("mossy_black_demon_bricks_stairs",
            new StairsBlock(BlockLoader.MOSSY_BLACK_DEMON_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block MOSSY_BLACK_DEMON_BRICKS_SLAB = registerBlock("mossy_black_demon_bricks_slab",
            new AxialSlabBlock(MOSSY_BLACK_DEMON_BRICKS));
    public static final Block MOSSY_BLACK_DEMON_BRICKS_WALL = registerBlock("mossy_black_demon_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block BLUE_BRICKS = registerBlock("blue_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block BLUE_BRICKS_STAIRS = registerBlock("blue_bricks_stairs",
            new StairsBlock(BlockLoader.BLUE_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block BLUE_BRICKS_SLAB = registerBlock("blue_bricks_slab",
            new AxialSlabBlock(BLUE_BRICKS));
    public static final Block BLUE_BRICKS_WALL = registerBlock("blue_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));


    public static final Block CARVED_BLUE_BRICKS = registerBlock("carved_blue_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CRACKED_BLUE_BRICKS = registerBlock("cracked_blue_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CRACKED_BLUE_BRICKS_STAIRS = registerBlock("cracked_blue_bricks_stairs",
            new StairsBlock(BlockLoader.CRACKED_BLUE_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block CRACKED_BLUE_BRICKS_SLAB = registerBlock("cracked_blue_bricks_slab",
            new AxialSlabBlock(CRACKED_BLUE_BRICKS));
    public static final Block CRACKED_BLUE_BRICKS_WALL = registerBlock("cracked_blue_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block MOSSY_BLUE_BRICKS = registerBlock("mossy_blue_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block MOSSY_BLUE_BRICKS_STAIRS = registerBlock("mossy_blue_bricks_stairs",
            new StairsBlock(BlockLoader.MOSSY_BLUE_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block MOSSY_BLUE_BRICKS_SLAB = registerBlock("mossy_blue_bricks_slab",
            new AxialSlabBlock(MOSSY_BLUE_BRICKS));
    public static final Block MOSSY_BLUE_BRICKS_WALL = registerBlock("mossy_blue_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block DEMON_BASALT_BRICKS = registerBlock("demon_basalt_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block DEMON_BASALT_BRICKS_STAIRS = registerBlock("demon_basalt_bricks_stairs",
            new StairsBlock(BlockLoader.DEMON_BASALT_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block DEMON_BASALT_BRICKS_SLAB = registerBlock("demon_basalt_bricks_slab",
            new AxialSlabBlock(DEMON_BASALT_BRICKS));
    public static final Block DEMON_BASALT_BRICKS_WALL = registerBlock("demon_basalt_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CARVED_DEMON_BASALT_BRICKS = registerBlock("carved_demon_basalt_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block VULCANIC_ROCK = registerBlock("vulcanic_rock",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block VULCANIC_ROCK_STAIRS = registerBlock("vulcanic_rock_stairs",
            new StairsBlock(BlockLoader.VULCANIC_ROCK.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block VULCANIC_ROCK_SLAB = registerBlock("vulcanic_rock_slab",
            new AxialSlabBlock(VULCANIC_ROCK));
    public static final Block VULCANIC_ROCK_WALL = registerBlock("vulcanic_rock_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block VULCANIC_DEMON_BRICKS = registerBlock("vulcanic_demon_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block VULCANIC_DEMON_BRICKS_STAIRS = registerBlock("vulcanic_demon_bricks_stairs",
            new StairsBlock(BlockLoader.VULCANIC_DEMON_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block VULCANIC_DEMON_BRICKS_SLAB = registerBlock("vulcanic_demon_bricks_slab",
            new AxialSlabBlock(VULCANIC_DEMON_BRICKS));
    public static final Block VULCANIC_DEMON_BRICKS_WALL = registerBlock("vulcanic_demon_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CARVED_VULCANIC_DEMON_BRICKS = registerBlock("carved_vulcanic_demon_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CRACKED_VULCANIC_DEMON_BRICKS = registerBlock("cracked_vulcanic_demon_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CRACKED_VULCANIC_DEMON_BRICKS_STAIRS = registerBlock("cracked_vulcanic_demon_bricks_stairs",
            new StairsBlock(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block CRACKED_VULCANIC_DEMON_BRICKS_SLAB = registerBlock("cracked_vulcanic_demon_bricks_slab",
            new AxialSlabBlock(CRACKED_VULCANIC_DEMON_BRICKS));
    public static final Block CRACKED_VULCANIC_DEMON_BRICKS_WALL = registerBlock("cracked_vulcanic_demon_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block MOSSY_VULCANIC_DEMON_BRICKS = registerBlock("mossy_vulcanic_demon_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block MOSSY_VULCANIC_DEMON_BRICKS_STAIRS = registerBlock("mossy_vulcanic_demon_bricks_stairs",
            new StairsBlock(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block MOSSY_VULCANIC_DEMON_BRICKS_SLAB = registerBlock("mossy_vulcanic_demon_bricks_slab",
            new AxialSlabBlock(MOSSY_VULCANIC_DEMON_BRICKS));
    public static final Block MOSSY_VULCANIC_DEMON_BRICKS_WALL = registerBlock("mossy_vulcanic_demon_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block RED_BRICKS = registerBlock("red_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block RED_BRICKS_STAIRS = registerBlock("red_bricks_stairs",
            new StairsBlock(BlockLoader.RED_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block RED_BRICKS_SLAB = registerBlock("red_bricks_slab",
            new AxialSlabBlock(RED_BRICKS));
    public static final Block RED_BRICKS_WALL = registerBlock("red_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block RED_PILLAR = registerBlock("red_pillar",
            new EdumiaPillarBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CARVED_RED_BRICKS = registerBlock("carved_red_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CRACKED_RED_BRICKS = registerBlock("cracked_red_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CRACKED_RED_BRICKS_STAIRS = registerBlock("cracked_red_bricks_stairs",
            new StairsBlock(BlockLoader.CRACKED_RED_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block CRACKED_RED_BRICKS_SLAB = registerBlock("cracked_red_bricks_slab",
            new AxialSlabBlock(CRACKED_RED_BRICKS));
    public static final Block CRACKED_RED_BRICKS_WALL = registerBlock("cracked_red_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block MOSSY_RED_BRICKS = registerBlock("mossy_red_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block MOSSY_RED_BRICKS_STAIRS = registerBlock("mossy_red_bricks_stairs",
            new StairsBlock(BlockLoader.MOSSY_RED_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block MOSSY_RED_BRICKS_SLAB = registerBlock("mossy_red_bricks_slab",
            new AxialSlabBlock(MOSSY_RED_BRICKS));
    public static final Block MOSSY_RED_BRICKS_WALL = registerBlock("mossy_red_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block DESERT_MUD_BRICKS = registerBlock("desert_mud_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block DESERT_MUD_BRICKS_STAIRS = registerBlock("desert_mud_bricks_stairs",
            new StairsBlock(BlockLoader.DESERT_MUD_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block DESERT_MUD_BRICKS_SLAB = registerBlock("desert_mud_bricks_slab",
            new AxialSlabBlock(DESERT_MUD_BRICKS));
    public static final Block DESERT_MUD_BRICKS_WALL = registerBlock("desert_mud_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));


    public static final Block CRACKED_DESERT_MUD_BRICKS = registerBlock("cracked_desert_mud_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block CRACKED_DESERT_MUD_BRICKS_STAIRS = registerBlock("cracked_desert_mud_bricks_stairs",
            new StairsBlock(BlockLoader.CRACKED_DESERT_MUD_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block CRACKED_DESERT_MUD_BRICKS_SLAB = registerBlock("cracked_desert_mud_bricks_slab",
            new AxialSlabBlock(CRACKED_DESERT_MUD_BRICKS));
    public static final Block CRACKED_DESERT_MUD_BRICKS_WALL = registerBlock("cracked_desert_mud_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block MOSSY_DESERT_MUD_BRICKS = registerBlock("mossy_desert_mud_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block MOSSY_DESERT_MUD_BRICKS_STAIRS = registerBlock("mossy_desert_mud_bricks_stairs",
            new StairsBlock(BlockLoader.DESERT_MUD_BRICKS.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block MOSSY_DESERT_MUD_BRICKS_SLAB = registerBlock("mossy_desert_mud_bricks_slab",
            new AxialSlabBlock(MOSSY_DESERT_MUD_BRICKS));
    public static final Block MOSSY_DESERT_MUD_BRICKS_WALL = registerBlock("mossy_desert_mud_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block HIGH_ELVEN_BRICK_TILING = registerBlock("high_elven_brick_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block HIGH_ELVEN_BRICK_TILING_STAIRS = registerBlock("high_elven_brick_tiling_stairs",
            new StairsBlock(BlockLoader.HIGH_ELVEN_BRICK_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block HIGH_ELVEN_BRICK_TILING_SLAB = registerBlock("high_elven_brick_tiling_slab",
            new AxialSlabBlock(HIGH_ELVEN_BRICK_TILING));

    public static final Block DARK_HIGH_ELVEN_BRICK_TILING = registerBlock("dark_high_elven_brick_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block DARK_HIGH_ELVEN_BRICK_TILING_STAIRS = registerBlock("dark_high_elven_brick_tiling_stairs",
            new StairsBlock(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block DARK_HIGH_ELVEN_BRICK_TILING_SLAB = registerBlock("dark_high_elven_brick_tiling_slab",
            new AxialSlabBlock(DARK_HIGH_ELVEN_BRICK_TILING));

    public static final Block LIGHT_HIGH_ELVEN_BRICK_TILING = registerBlock("light_high_elven_brick_tiling",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block LIGHT_HIGH_ELVEN_BRICK_TILING_STAIRS = registerBlock("light_high_elven_brick_tiling_stairs",
            new StairsBlock(BlockLoader.HIGH_ELVEN_BRICK_TILING.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block LIGHT_HIGH_ELVEN_BRICK_TILING_SLAB = registerBlock("light_high_elven_brick_tiling_slab",
            new AxialSlabBlock(LIGHT_HIGH_ELVEN_BRICK_TILING));


    public static final Block HIGH_ELVEN_COBBLESTONE = registerBlock("high_elven_cobblestone",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block HIGH_ELVEN_COBBLESTONE_STAIRS = registerBlock("high_elven_cobblestone_stairs",
            new StairsBlock(BlockLoader.HIGH_ELVEN_COBBLESTONE.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block HIGH_ELVEN_COBBLESTONE_SLAB = registerBlock("high_elven_cobblestone_slab",
            new AxialSlabBlock(HIGH_ELVEN_COBBLESTONE));
    public static final Block HIGH_ELVEN_COBBLESTONE_WALL = registerBlock("high_elven_cobblestone_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block MOSSY_HIGH_ELVEN_COBBLESTONE = registerBlock("mossy_high_elven_cobblestone",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block MOSSY_HIGH_ELVEN_COBBLESTONE_STAIRS = registerBlock("mossy_high_elven_cobblestone_stairs",
            new StairsBlock(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block MOSSY_HIGH_ELVEN_COBBLESTONE_SLAB = registerBlock("mossy_high_elven_cobblestone_slab",
            new AxialSlabBlock(MOSSY_HIGH_ELVEN_COBBLESTONE));
    public static final Block MOSSY_HIGH_ELVEN_COBBLESTONE_WALL = registerBlock("mossy_high_elven_cobblestone_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block LIGHT_HIGH_ELVEN_COBBLESTONE = registerBlock("light_high_elven_cobblestone",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS = registerBlock("light_high_elven_cobblestone_stairs",
            new StairsBlock(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB = registerBlock("light_high_elven_cobblestone_slab",
            new AxialSlabBlock(LIGHT_HIGH_ELVEN_COBBLESTONE));
    public static final Block LIGHT_HIGH_ELVEN_COBBLESTONE_WALL = registerBlock("light_high_elven_cobblestone_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE = registerBlock("mossy_light_high_elven_cobblestone",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS = registerBlock("mossy_light_high_elven_cobblestone_stairs",
            new StairsBlock(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB = registerBlock("mossy_light_high_elven_cobblestone_slab",
            new AxialSlabBlock(MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE));
    public static final Block MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_WALL = registerBlock("mossy_light_high_elven_cobblestone_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block DARK_HIGH_ELVEN_COBBLESTONE = registerBlock("dark_high_elven_cobblestone",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block DARK_HIGH_ELVEN_COBBLESTONE_STAIRS = registerBlock("dark_high_elven_cobblestone_stairs",
            new StairsBlock(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block DARK_HIGH_ELVEN_COBBLESTONE_SLAB = registerBlock("dark_high_elven_cobblestone_slab",
            new AxialSlabBlock(DARK_HIGH_ELVEN_COBBLESTONE));
    public static final Block DARK_HIGH_ELVEN_COBBLESTONE_WALL = registerBlock("dark_high_elven_cobblestone_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block MOSSY_DARK_HIGH_ELVEN_COBBLESTONE = registerBlock("mossy_dark_high_elven_cobblestone",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));
    public static final Block MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_STAIRS = registerBlock("mossy_dark_high_elven_cobblestone_stairs",
            new StairsBlock(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE.getDefaultState() ,
                    AbstractBlock.Settings.create().requiresTool()
                            .strength(1.5f, 6f)));
    public static final Block MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_SLAB = registerBlock("mossy_dark_high_elven_cobblestone_slab",
            new AxialSlabBlock(MOSSY_DARK_HIGH_ELVEN_COBBLESTONE));
    public static final Block MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_WALL = registerBlock("mossy_dark_high_elven_cobblestone_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

//    public static final Block BROWN_SANDSTONE_SLATES = registerBlock("brown_sandstone_slates",
//            new EdumiaStoneBlock(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//
//
//
//    public static final Block MARBLE_PINK = registerBlock("marble_pink",
//            new Block(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//    //ores
    public static final Block TOPAZ_ORE = registerBlock("topaz_ore",
            new Block(AbstractBlock.Settings.create()
                    .strength(3f).requiresTool()));
//    public static final Block ORE_VEIL = registerBlock("ore_veil",
//            new Block(AbstractBlock.Settings.create()
//                    .strength(3f).requiresTool()));
//    public static final Block ALEXANDRITE_ORE = registerBlock("alexandrite_ore",
//            new Block(AbstractBlock.Settings.create()
//                    .strength(3f).requiresTool()));
//    public static final Block ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
//            new Block(AbstractBlock.Settings.create()
//                    .strength(3f).requiresTool()));
//    public static final Block RAW_ALEXANDRITE_BLOCK = registerBlock("raw_alexandrite_block",
//            new Block(AbstractBlock.Settings.create()
//                    .strength(3f).requiresTool()));
//
//
    //wood
    public static final Block APPLE_SAPLING = registerBlock("apple_sapling",
            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

//    public static final Block ASPEN_SAPLING = registerBlock("aspen_sapling",
//            new SaplingBlock(new AspenTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));



//    public static final Block BEECH_SAPLING = registerBlock("beech_sapling",
//            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

//    public static final Block BLACKTHORN_SAPLING = registerBlock("blackthorn_sapling",
//            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

//    public static final Block CEDAR_SAPLING = registerBlock("cedar_sapling",
//            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


//    public static final Block CHERRY_SAPLING = registerBlock("cherry_sapling",
//            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


//    public static final Block CYPRESS_SAPLING = registerBlock("cypress_sapling",
//            new SaplingBlock(new CypressTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


//    public static final Block FIR_SAPLING = registerBlock("fir_sapling",
//            new SaplingBlock(new FirTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


//    public static final Block GHOST_GUM_LEAVES = registerBlock("ghost_gum_leaves",
//            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
//                    .strength(0.2F).nonOpaque()));
//    public static final Block GHOST_GUM_SAPLING = registerBlock("ghost_gum_sapling",
//            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


//    public static final Block GREEN_OAK_SAPLING = registerBlock("green_oak_sapling",
//            new SaplingBlock(new GreenOakTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


//    public static final Block HOLLY_SAPLING = registerBlock("holly_sapling",
//            new SaplingBlock(new HollyTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


//    public static final Block LARCH_SAPLING = registerBlock("larch_sapling",
//            new SaplingBlock(new LarchTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

//    public static final Block MAPLE_SAPLING = registerBlock("maple_sapling",
//            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


//    public static final Block PEAR_SAPLING = registerBlock("pear_sapling",
//            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


//    public static final Block PINE_SAPLING = registerBlock("pine_sapling",
//            new SaplingBlock(new PineTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));



//    public static final Block RED_OAK_SAPLING = registerBlock("red_oak_sapling",
//            new SaplingBlock(new RedOakTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


//    public static final Block REDWOOD_SAPLING = registerBlock("redwood_sapling",
//            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.create()));


//
//    public static final Block SILVER_SPRUCE_SAPLING = registerBlock("silver_spruce_sapling",
//            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


//    public static final Block WHITE_ASH_SAPLING = registerBlock("white_ash_sapling",
//            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    //Plants

    public static final Block REEDS = registerBlock("reeds", new ReedsBlock());

    public static final Block PAPYRUS = registerBlock("papyrus", new ReedsBlock());

    public static final Block DRIED_REEDS = registerBlock("dried_reeds", new DriedReedsBlock());


    //grass

//    public static final Block ARID_GRASS = registerBlock("arid_grass",
//            new TallGrassBlock(AbstractBlock.Settings.create().mapColor(MapColor.PLANT).replaceable()
//                    .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)
//                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
//    public static final Block BLACK_GRASS = registerBlock("black_grass",
//            new TallGrassBlock(AbstractBlock.Settings.create().mapColor(MapColor.PLANT).replaceable()
//                    .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)
//                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
//    public static final Block FLAX_GRASS = registerBlock("flax_grass",
//            new TallGrassBlock(AbstractBlock.Settings.create().mapColor(MapColor.PLANT).replaceable()
//                    .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)
//                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
//
    //flowers
    public static final Block ASPHODEL = registerBlock("asphodel",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block BLUE_DELPHINIUM = registerBlock("blue_delphinium",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block BLUEBELL = registerBlock("bluebell",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block CALLA_LILY = registerBlock("calla_lily",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block CELSEMIUM = registerBlock("celsemium",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block CHRYS_BLUE = registerBlock("chrys_blue",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block CHRYS_ORANGE = registerBlock("chrys_orange",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block CHRYS_PINK = registerBlock("chrys_pink",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block CHRYS_WHITE = registerBlock("chrys_white",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block CHRYS_YELLOW = registerBlock("chrys_yellow",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block CROCUS = registerBlock("crocus",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block DAISY = registerBlock("daisy",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block DELPHINIUM = registerBlock("delphinium",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block FLAX_FLOWERS = registerBlock("flax_flowers",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block FOXGLOVE_ORANGE = registerBlock("foxglove_orange",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block FOXGLOVE_PINK = registerBlock("foxglove_pink",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block FOXGLOVE_RED = registerBlock("foxglove_red",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block FOXGLOVE_WHITE = registerBlock("foxglove_white",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block GERBERA_RED = registerBlock("gerbera_red",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block GERBERA_YELLOW = registerBlock("gerbera_yellow",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block HEATHER_BUSH = registerBlock("heather_bush",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block LAVENDER = registerBlock("lavender",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block MARIGOLD = registerBlock("marigold",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block PINK_ANEMONE = registerBlock("pink_anemone",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block SIMBLELMYNE = registerBlock("simbelmyne",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));
    public static final Block TUBEROSE = registerBlock("tuberose",
            new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.copy(Blocks.ALLIUM)
                    .nonOpaque().noCollision()));

    public static final Block YELLOW_IRIS = registerBlock("yellow_iris", new TallFlowerBlock(AbstractBlock.Settings
            .create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)
            .offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block FLAME_OF_THE_SOUTH = registerBlock("flame_of_the_south", new TallFlowerBlock(AbstractBlock.Settings
            .create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)
            .offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HIBISCUS = registerBlock("hibiscus", new TallFlowerBlock(AbstractBlock.Settings
            .create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)
            .offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY)));


    public static final Block POTTED_ASPHODEL = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID, "potted_asphodel"),
            new FlowerPotBlock(ASPHODEL, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_BLUE_DELPHINIUM = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_blue_delphinium"),
            new FlowerPotBlock(BLUE_DELPHINIUM, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_BLUEBELL = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_bluebell"),
            new FlowerPotBlock(BLUEBELL, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_CALLA_LILY = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_calla_lily"),
            new FlowerPotBlock(CALLA_LILY, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_CELSEMIUM = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_celsemium"),
            new FlowerPotBlock(CELSEMIUM, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_CHRYS_BLUE = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_chrys_blue"),
            new FlowerPotBlock(CHRYS_BLUE, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_CHRYS_ORANGE = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_chrys_orange"),
            new FlowerPotBlock(CHRYS_ORANGE, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_CHRYS_PINK = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_chrys_pink"),
            new FlowerPotBlock(CHRYS_PINK, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_CHRYS_WHITE = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_chrys_white"),
            new FlowerPotBlock(CHRYS_WHITE, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_CHRYS_YELLOW = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID, "potted_chrys_yellow"),
            new FlowerPotBlock(CHRYS_YELLOW, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_CROCUS = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_crocus"),
            new FlowerPotBlock(CROCUS, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_DAISY = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_daisy"),
            new FlowerPotBlock(DAISY, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_DELPHINIUM = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_delphinium"),
            new FlowerPotBlock(DELPHINIUM, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_FLAX_FLOWERS = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_flax_flowers"),
            new FlowerPotBlock(FLAX_FLOWERS, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_FOXGLOVE_ORANGE = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_foxglove_orange"),
            new FlowerPotBlock(FOXGLOVE_ORANGE, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_FOXGLOVE_PINK = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_foxglove_pink"),
            new FlowerPotBlock(FOXGLOVE_PINK, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_FOXGLOVE_RED = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_foxglove_red"),
            new FlowerPotBlock(FOXGLOVE_RED, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_FOXGLOVE_WHITE = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_foxglove_white"),
            new FlowerPotBlock(FOXGLOVE_WHITE, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_GERBERA_RED = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_gerbera_red"),
            new FlowerPotBlock(GERBERA_RED, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_GERBERA_YELLOW = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_gerbera_yellow"),
            new FlowerPotBlock(GERBERA_YELLOW, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_HEATHER_BUSH = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_heather_bush"),
            new FlowerPotBlock(HEATHER_BUSH, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_LAVENDER = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_lavender"),
            new FlowerPotBlock(LAVENDER, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_MARIGOLD = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_marigold"),
            new FlowerPotBlock(MARIGOLD, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_PINK_ANEMONE = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_pink_anemone"),
            new FlowerPotBlock(PINK_ANEMONE, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_SIMBLELMYNE = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_simbelmyne"),
            new FlowerPotBlock(SIMBLELMYNE, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));
    public static final Block POTTED_TUBEROSE = Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID,"potted_tuberose"),
            new FlowerPotBlock(TUBEROSE, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)
                    .nonOpaque()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Edumia.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Edumia.LOGGER.info("Registering ModBlocks for " + Edumia.MOD_ID);
    }
}
