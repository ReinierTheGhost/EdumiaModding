package com.legends.edumia.core;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.*;
import com.legends.edumia.block.plants.DriedReedsBlock;
import com.legends.edumia.block.plants.ReedsBlock;
import com.legends.edumia.world.worldgen.treegrowers.*;
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
    public static final Block SANDSTONE_PILLAR = registerBlock("sandstone_pillar",
            new EdumiaPillarBlock(AbstractBlock.Settings.create().requiresTool()
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

    public static final Block CHISELED_HIGH_ELVEN_BRICKS = registerBlock("chiseled_high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CHISELED_LIGHT_HIGH_ELVEN_BRICKS = registerBlock("chiseled_light_high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CHISELED_DARK_HIGH_ELVEN_BRICKS = registerBlock("chiseled_dark_high_elven_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));


    public static final Block CARVED_BROWN_SANDSTONE_BRICKS = registerBlock("carved_brown_sandstone_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CARVED_CACHOLONG_BRICKS = registerBlock("carved_cacholong_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CARVED_BLACK_DEMON_BRICKS = registerBlock("carved_black_demon_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));


    public static final Block CARVED_BLUE_BRICKS = registerBlock("carved_blue_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CARVED_DEMON_BASALT_BRICKS = registerBlock("carved_demon_basalt_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CARVED_VOLCANIC_DEMON_BRICKS = registerBlock("carved_volcanic_demon_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CARVED_RED_GENSAI_BRICKS = registerBlock("carved_red_gensai_bricks",
            new Block(AbstractBlock.Settings.create().requiresTool()
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



    public static final Block BROWN_SANDSTONE_SLATES = registerBlock("brown_sandstone_slates",
            new PillarBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(1.5f, 6f)));

    public static final Block CHISELED_ANDESITE = registerBlock("chiseled_andesite",
            new PillarBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(2f, 6f)));

    public static final Block CHISELED_DIORITE = registerBlock("chiseled_diorite",
            new PillarBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(2f, 6f)));

    public static final Block CHISELED_GRANITE = registerBlock("chiseled_granite",
            new PillarBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(2f, 6f)));

    public static final Block CHISELED_DRIPSTONE = registerBlock("chiseled_dripstone",
            new PillarBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(2f, 6f)));
    public static final Block DIRTY_CHALK = registerBlock("dirty_chalk",
            new PillarBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(2f, 6f)));
//
//
//
//    public static final Block MARBLE_PINK = registerBlock("marble_pink",
//            new Block(AbstractBlock.Settings.create().requiresTool()
//                    .strength(1.5f, 6f)));
//    //ores
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

    public static final Block TEST_SAPLING = registerBlock("test_sapling",
            new SaplingBlock(new TestTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));
    public static final Block APPLE_SAPLING = registerBlock("apple_sapling",
            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block ASPEN_SAPLING = registerBlock("aspen_sapling",
            new SaplingBlock(new AspenTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block GHOST_GUM_SAPLING = registerBlock("ghost_gum_sapling",
            new SaplingBlock(new GhostGumTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


//    public static final Block BEECH_SAPLING = registerBlock("beech_sapling",
//            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

//    public static final Block BLACKTHORN_SAPLING = registerBlock("blackthorn_sapling",
//            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block CEDAR_SAPLING = registerBlock("cedar_sapling",
            new SaplingBlock(new CederTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


//    public static final Block CHERRY_SAPLING = registerBlock("cherry_sapling",
//            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


    public static final Block CYPRESS_SAPLING = registerBlock("cypress_sapling",
            new SaplingBlock(new CypressTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


    public static final Block FIR_SAPLING = registerBlock("fir_sapling",
            new SaplingBlock(new FirTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


    public static final Block GREEN_OAK_SAPLING = registerBlock("green_oak_sapling",
            new SaplingBlock(new GreenOakTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


    public static final Block HOLLY_SAPLING = registerBlock("holly_sapling",
            new SaplingBlock(new HollyTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


    public static final Block LARCH_SAPLING = registerBlock("larch_sapling",
            new SaplingBlock(new LarchTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

//    public static final Block MAPLE_SAPLING = registerBlock("maple_sapling",
//            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


//    public static final Block PEAR_SAPLING = registerBlock("pear_sapling",
//            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


//    public static final Block PINE_SAPLING = registerBlock("pine_sapling",
//            new SaplingBlock(new PineTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));



    public static final Block RED_OAK_SAPLING = registerBlock("red_oak_sapling",
            new SaplingBlock(new RedOakTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


//    public static final Block REDWOOD_SAPLING = registerBlock("redwood_sapling",
//            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.create()));


//
    public static final Block SILVER_SPRUCE_SAPLING = registerBlock("silver_spruce_sapling",
            new SaplingBlock(new SilverSpruceTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


    public static final Block WHITE_ASH_SAPLING = registerBlock("white_ash_sapling",
            new SaplingBlock(new WhiteAshTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    //Plants

    public static final Block REEDS = registerBlock("reeds", new ReedsBlock());

    public static final Block PAPYRUS = registerBlock("papyrus", new ReedsBlock());

    public static final Block DRIED_REEDS = registerBlock("dried_reeds", new DriedReedsBlock());


    //grass

    public static final Block ARID_GRASS = registerBlock("arid_grass",
            new FernBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).replaceable()
                    .noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ)
                    .burnable().pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block BLACK_GRASS = registerBlock("black_grass",
            new FernBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).replaceable()
                    .noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ)
                    .burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block FLAX_GRASS = registerBlock("flax_grass",
            new FernBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).replaceable()
                    .noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ)
                    .burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BEACH_GRASS = registerBlock("beach_grass",
            new TallPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).replaceable()
                    .noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ)
                    .burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block TALL_BEACH_GRASS = registerBlock("tall_beach_grass",
            new TallPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).replaceable()
                    .noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ)
                    .burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block FROSTED_GRASS = registerBlock("frosted_grass",
            new FernBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).replaceable()
                    .noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ)
                    .burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block TALL_FROSTED_GRASS = registerBlock("tall_frosted_grass",
            new TallPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).replaceable()
                    .noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ)
                    .burnable().pistonBehavior(PistonBehavior.DESTROY)));


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
